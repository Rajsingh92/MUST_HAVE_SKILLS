package com.pluralsight.kinesis.module3;

import com.amazonaws.services.kinesis.connectors.KinesisConnectorConfiguration;
import com.amazonaws.services.kinesis.connectors.impl.BasicMemoryBuffer;
import com.amazonaws.services.kinesis.connectors.interfaces.*;
import com.amazonaws.services.kinesis.connectors.s3.S3Emitter;
import com.amazonaws.services.kinesis.model.Record;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterObjectFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class ConnectorsPipeline implements IKinesisConnectorPipeline<Status, byte[]> {

    @Override
    public IEmitter<byte[]> getEmitter(KinesisConnectorConfiguration configuration) {
        return new S3Emitter(configuration);
    }

    @Override
    public IBuffer<Status> getBuffer(KinesisConnectorConfiguration configuration) {
        return new BasicMemoryBuffer<>(configuration);
    }

    @Override
    public ITransformerBase<Status, byte[]> getTransformer(KinesisConnectorConfiguration configuration) {
        return new ITransformer<Status, byte[]>() {
            @Override
            public Status toClass(Record record) throws IOException {
                return getStatus(record);
            }

            @Override
            public byte[] fromClass(Status record) throws IOException {
                try {
                    return new ObjectMapper().writeValueAsString(record).getBytes();
                } catch (JsonProcessingException e) {
                    throw new IOException("Failed to serialize record", e);
                }

            }
        };
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
    public IFilter<Status> getFilter(KinesisConnectorConfiguration configuration) {
        // Use AllPassFilter if all tweets should be passed
        return record -> record.getLang().equals("en");
    }
}
