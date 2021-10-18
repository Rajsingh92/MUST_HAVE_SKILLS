package com.pluralsight.kinesis.module2;

import com.amazonaws.services.kinesis.AmazonKinesis;
import com.amazonaws.services.kinesis.AmazonKinesisClientBuilder;
import com.amazonaws.services.kinesis.model.PutRecordRequest;
import com.amazonaws.services.kinesis.model.PutRecordResult;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
public class TwitterProducerMain {
    public static void main(String... args) {
        TwitterStream twitterStream = createTwitterStream();
        twitterStream.addListener(createListener());
        twitterStream.sample();
    }

    private static TwitterStream createTwitterStream() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("o5qd58AWq2RunkDldVDSeQsAG")
                .setOAuthConsumerSecret("sCox2VERwJqU5d53Ec6KcA5C8kLQm6uvh9q62o8YGoigtahMzw")
                .setOAuthAccessToken("179171495-PKZCLxXb1nRPkIGiosuDDZBN2zjM8d3EDG2CmU5r")
                .setOAuthAccessTokenSecret("Emq0L95Tv4W7oJX2dF3ccCoEdrO5xwOhAQSdE7j8dx26i");

        return new TwitterStreamFactory(cb.build()).getInstance();
    }

    private static RawStreamListener createListener() {
        return new TweetsStatusListener(createKinesisClient());
    }

    private static AmazonKinesis createKinesisClient() {
        AmazonKinesisClientBuilder clientBuilder = AmazonKinesisClientBuilder
                .standard();

        return clientBuilder.build();
    }

    static class TweetsStatusListener implements RawStreamListener {


        private final AmazonKinesis kinesisClient;

        TweetsStatusListener(AmazonKinesis kinesisClient) {
            this.kinesisClient = kinesisClient;
        }

        public void onMessage(String rawString) {


            try {
                Status status = TwitterObjectFactory.createStatus(rawString);
                if (status.getUser() != null) {
                    byte[] tweetsBytes = rawString.getBytes(StandardCharsets.UTF_8);

                    PutRecordRequest putRecordRequest = new PutRecordRequest();
                    putRecordRequest.setStreamName("tweets-stream");

                    putRecordRequest.setPartitionKey(status.getLang());
                    putRecordRequest.setData(ByteBuffer.wrap(tweetsBytes));

                    PutRecordResult putRecordResult = kinesisClient.putRecord(
                            putRecordRequest
                    );

                    System.out.println(status.getLang() + " -> " + putRecordResult);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void onException(Exception ex) {
            ex.printStackTrace();
        }
    }
}
