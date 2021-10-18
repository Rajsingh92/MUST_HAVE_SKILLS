package com.pluralsight.kinesis.module2;

import com.amazonaws.services.kinesis.clientlibrary.interfaces.v2.IRecordProcessor;
import com.amazonaws.services.kinesis.clientlibrary.types.InitializationInput;
import com.amazonaws.services.kinesis.clientlibrary.types.ProcessRecordsInput;
import com.amazonaws.services.kinesis.clientlibrary.types.ShutdownInput;
import com.amazonaws.services.kinesis.model.Record;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterObjectFactory;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class TweetsProcessor implements IRecordProcessor {
    @Override
    public void initialize(InitializationInput initializationInput) {

    }

    @Override
    public void processRecords(ProcessRecordsInput processRecordsInput) {
        for (Record record : processRecordsInput.getRecords()) {
            System.out.println(getStatus(record));
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

    }
}

