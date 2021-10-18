package com.pluralsight.kinesis;

import software.amazon.awssdk.services.kinesis.KinesisAsyncClient;
import software.amazon.awssdk.services.kinesis.model.Consumer;
import software.amazon.awssdk.services.kinesis.model.ConsumerStatus;
import software.amazon.awssdk.services.kinesis.model.DescribeStreamConsumerRequest;
import software.amazon.awssdk.services.kinesis.model.DescribeStreamConsumerResponse;
import software.amazon.awssdk.services.kinesis.model.Record;
import software.amazon.awssdk.services.kinesis.model.RegisterStreamConsumerRequest;
import software.amazon.awssdk.services.kinesis.model.RegisterStreamConsumerResponse;
import software.amazon.awssdk.services.kinesis.model.ShardIteratorType;
import software.amazon.awssdk.services.kinesis.model.StartingPosition;
import software.amazon.awssdk.services.kinesis.model.SubscribeToShardEvent;
import software.amazon.awssdk.services.kinesis.model.SubscribeToShardRequest;
import software.amazon.awssdk.services.kinesis.model.SubscribeToShardResponseHandler;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterObjectFactory;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

public class TwitterFanOutConsumer {

    public static void main(String[] args) throws Exception {

        KinesisAsyncClient kinesisClient = KinesisAsyncClient.create();


        Consumer consumer = registerConsumer(kinesisClient);

        waitForConsumerToRegister(kinesisClient, consumer);

        StartingPosition startingPosition = StartingPosition
                .builder()
                .type(ShardIteratorType.TRIM_HORIZON)
                .build();
        SubscribeToShardRequest subscribeToShardRequest
                = SubscribeToShardRequest.builder()
                .consumerARN(consumer.consumerARN())
                .shardId("shardId-000000000001")
                .startingPosition(startingPosition)
                .build();

        while (true) {
            System.out.println("Subscribing to a shard");
            SubscribeToShardResponseHandler recordsHandler
                    = SubscribeToShardResponseHandler
                    .builder()
                    .onError(t -> System.err.println("Subscribe to shard error: " + t.getMessage()))
                    .subscriber(new RecordsProcessor())
                    .build();

            CompletableFuture<Void> future = kinesisClient
                    .subscribeToShard(subscribeToShardRequest, recordsHandler);
            future.join();
        }
    }

    private static Consumer registerConsumer(KinesisAsyncClient kinesisClient)
            throws Exception {
        RegisterStreamConsumerRequest registerStreamConsumerRequest
                = RegisterStreamConsumerRequest.builder()
                .consumerName("fan-out-consumer")
                .streamARN("arn:aws:kinesis:us-east-1:913036176028:stream/tweets-stream")
                .build();

        RegisterStreamConsumerResponse response = kinesisClient
                .registerStreamConsumer(registerStreamConsumerRequest).get();
        Consumer consumer = response.consumer();
        System.out.println("Registered consumer: " + consumer);

        return consumer;
    }


    private static void waitForConsumerToRegister(
            KinesisAsyncClient kinesisClient,
            Consumer consumer)
            throws InterruptedException, java.util.concurrent.ExecutionException {
        DescribeStreamConsumerResponse consumerResponse;
        do {
            System.out.println("Waiting for enhanced consumer to become active");
            sleep(500);
            consumerResponse = kinesisClient
                    .describeStreamConsumer(
                            DescribeStreamConsumerRequest
                                    .builder()
                                    .consumerARN(consumer.consumerARN())
                                    .build()
                    ).get();
        } while (consumerResponse.consumerDescription().consumerStatus()
                != ConsumerStatus.ACTIVE);
    }

    static class RecordsProcessor implements SubscribeToShardResponseHandler.Visitor {
        @Override
        public void visit(SubscribeToShardEvent event) {
            for (Record record : event.records()) {
                processRecord(record);
            }
        }
    }

    private static void processRecord(Record record) {
        byte[] data = record.data().asByteArray();
        String tweetJson = new String(data, StandardCharsets.UTF_8);

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

    private static void sleep(long ms) {
        System.out.println("Sleeping");
        try {
            Thread.sleep(ms);
        } catch (InterruptedException exception) {
            throw new RuntimeException(exception);
        }
    }

}
