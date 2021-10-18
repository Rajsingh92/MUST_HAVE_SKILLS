package com.pluralsight.kinesis.module2;

import com.amazonaws.services.kinesis.AmazonKinesis;
import com.amazonaws.services.kinesis.AmazonKinesisClientBuilder;
import com.amazonaws.services.kinesis.model.GetRecordsRequest;
import com.amazonaws.services.kinesis.model.GetRecordsResult;
import com.amazonaws.services.kinesis.model.GetShardIteratorRequest;
import com.amazonaws.services.kinesis.model.GetShardIteratorResult;
import com.amazonaws.services.kinesis.model.Record;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterObjectFactory;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class TwitterConsumerMain {
    public static void main(String[] args) {

        var kinesisClient = createKinesisClient();

        GetShardIteratorRequest getShardIteratorRequest = new GetShardIteratorRequest();
        getShardIteratorRequest.setStreamName("tweets-stream");
        getShardIteratorRequest.setShardId("shardId-000000000001");
        getShardIteratorRequest.setShardIteratorType("TRIM_HORIZON");

        GetShardIteratorResult getShardIteratorResult = kinesisClient.getShardIterator(getShardIteratorRequest);
        String shardIterator = getShardIteratorResult.getShardIterator();

        while (true) {
            GetRecordsRequest getRecordsRequest = new GetRecordsRequest();
            getRecordsRequest.setShardIterator(shardIterator);

            GetRecordsResult result = kinesisClient.getRecords(getRecordsRequest);

            List<Record> records = result.getRecords();

            for (Record record : records) {
                processRecord(record);
            }

            sleep(200);

            shardIterator = result.getNextShardIterator();
        }

    }

    private static AmazonKinesis createKinesisClient() {
        AmazonKinesisClientBuilder clientBuilder = AmazonKinesisClientBuilder.standard();

        return clientBuilder.build();
    }

    private static void sleep(long ms) {
        System.out.println("Sleeping");
        try {
            Thread.sleep(ms);
        }
        catch (InterruptedException exception) {
            throw new RuntimeException(exception);
        }
    }

    private static void processRecord(Record record) {
        ByteBuffer data = record.getData();
        String tweetJson = new String(data.array(), StandardCharsets.UTF_8);

        var tweet = parseTweet(tweetJson);
        System.out.println(tweet.getLang() + " => " + tweet.getText());
    }

    private static Status parseTweet(String tweetJson) {
        try {
            return TwitterObjectFactory.createStatus(tweetJson);
        } catch (TwitterException e) {
            throw new RuntimeException(e);
        }
    }
}
