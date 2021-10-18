package com.pluralsight.kinesis.module2;

import com.amazonaws.services.kinesis.clientlibrary.exceptions.InvalidStateException;
import com.amazonaws.services.kinesis.clientlibrary.exceptions.ShutdownException;
import com.amazonaws.services.kinesis.clientlibrary.interfaces.IRecordProcessorCheckpointer;
import com.amazonaws.services.kinesis.clientlibrary.interfaces.v2.IRecordProcessor;
import com.amazonaws.services.kinesis.clientlibrary.lib.worker.ShutdownReason;
import com.amazonaws.services.kinesis.clientlibrary.types.InitializationInput;
import com.amazonaws.services.kinesis.clientlibrary.types.ProcessRecordsInput;
import com.amazonaws.services.kinesis.clientlibrary.types.ShutdownInput;
import com.amazonaws.services.kinesis.model.Record;
import org.apache.commons.lang.time.DateFormatUtils;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterObjectFactory;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TweetsCounter implements IRecordProcessor {

    // Fake DB
    private static TwitterAnalyticsDb twitterAnalyticsDb = new TwitterAnalyticsDb();

    // Number of milliseconds in one minute
    private static long ONE_MINUTE = TimeUnit.MINUTES.toMillis(1);

    // Previous record (for checkpointing)
    private Record prevRecord = null;

    // Minute we are processing since the beginning of computer time
    private long currentMinute = 0;

    // Shard id that this processor is processing
    private String shardId;

    // Number of tweets in each language for current minute
    private Map<String, Integer> tweetsOfLanguage = new HashMap<>();

    @Override
    public void initialize(InitializationInput initializationInput) {
        this.shardId = initializationInput.getShardId();
    }

    @Override
    public void processRecords(ProcessRecordsInput processRecordsInput) {
        for (Record record : processRecordsInput.getRecords()) {
            Status status = getStatus(record);

            // If new time interval
            if (nextMinute(status)) {
                // Save statistics for prev minute
                saveStatistics();
                // Checkpoint!!
                checkpoint(processRecordsInput.getCheckpointer(), prevRecord);
                // Set new current minute
                currentMinute = minutes(status);
            }

            // Record current tweet
            processTweet(status);

            // Change prev status
            prevRecord = record;
        }
    }

    private void saveStatistics() {
        tweetsOfLanguage.forEach((language, count) -> {
            LangAndTime langAndTime = new LangAndTime();
            langAndTime.setLanguage(language);
            langAndTime.setPublicationTime(
                    DateFormatUtils.format(
                            new Date(currentMinute * ONE_MINUTE),
                            "yyyy-MM-dd HH:mm")
            );

            log(String.format("Publishing: %s; count = %d", langAndTime, count));
            boolean idempotent = twitterAnalyticsDb.saveStatistics(
                    langAndTime,
                    count
            );
            if (!idempotent)
                System.err.println(
                        String.format(
                                "%s - NON IDEMPOTENT WRITE - %s - %d",
                                shardId,
                                langAndTime,
                                count));
        });
        tweetsOfLanguage.clear();
    }

    private boolean nextMinute(Status status) {
        return currentMinute < minutes(status);
    }

    private void processTweet(Status status) {
        String tweetLanguage = status.getLang();
        tweetsOfLanguage.put(
                tweetLanguage,
                tweetsOfLanguage.getOrDefault(tweetLanguage, 0) + 1
        );
    }

    private void checkpoint(IRecordProcessorCheckpointer checkpointer, Record record) {
        if (record == null)
            return;
        try {
            checkpointer.checkpoint(record);
        } catch (InvalidStateException e) {
            // Table does not exists
            e.printStackTrace();
        } catch (ShutdownException e) {
            // Two processors are processing the same shard
            e.printStackTrace();
        }
    }

    private Status getStatus(Record record) {
        ByteBuffer data = record.getData();
        String tweetJson = new String(data.array(), StandardCharsets.UTF_8);
        return parseTweet(tweetJson);
    }

    private Status parseTweet(String tweetJson) {
        try {
            return TwitterObjectFactory.createStatus(tweetJson);
        } catch (TwitterException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void shutdown(ShutdownInput shutdownInput) {
        ShutdownReason reason = shutdownInput.getShutdownReason();
        switch (reason) {
            case TERMINATE:
            case REQUESTED:
                saveStatistics();
                checkpoint(shutdownInput.getCheckpointer(), prevRecord);
                break;

            case ZOMBIE:
                log("Zombie shard. No checkpoint.");
                break;
        }
    }

    /**
     * Number of a minute since the beginning of computer time.
     * 1 Jan 1970 00:00:00 -> 0
     * 1 Jan 1970 00:00:01 -> 0
     * 1 Jan 1970 00:00:59 -> 0
     * 1 Jan 1970 00:01:00 -> 1
     * 1 Jan 1970 00:01:02 -> 1
     * @param status - tweet message with metadata
     * @return number of a minute since the beginning of computer time
     */
    private long minutes(Status status) {
        return status.getCreatedAt().getTime() / ONE_MINUTE;
    }

    private void log(String str) {
        System.out.println(shardId + " - " + str);
    }
}
