package com.pluralsight.kinesis;

/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.kinesis.clientlibrary.types.UserRecord;
import com.amazonaws.services.kinesis.model.Record;
import com.google.common.collect.Iterators;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.timestamps.BoundedOutOfOrdernessTimestampExtractor;
import org.apache.flink.streaming.api.functions.windowing.WindowFunction;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.streaming.connectors.kinesis.FlinkKinesisConsumer;
import org.apache.flink.streaming.connectors.kinesis.config.ConsumerConfigConstants;
import org.apache.flink.streaming.connectors.kinesis.serialization.KinesisDeserializationSchema;
import org.apache.flink.util.Collector;
import twitter4j.HashtagEntity;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterObjectFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Date;
import java.util.Properties;

public class HashTagsCounting {

    public static void main(String[] args) throws Exception {
        // set up the streaming execution environment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment();

        // Get AWS credentials
        DefaultAWSCredentialsProviderChain credentialsProvider = new DefaultAWSCredentialsProviderChain();
        AWSCredentials credentials = credentialsProvider.getCredentials();

        // Configure Flink Kinesis consumer
        Properties consumerConfig = new Properties();
        consumerConfig.put(ConsumerConfigConstants.AWS_REGION, "us-east-1");
        consumerConfig.put(ConsumerConfigConstants.AWS_ACCESS_KEY_ID, credentials.getAWSAccessKeyId());
        consumerConfig.put(ConsumerConfigConstants.AWS_SECRET_ACCESS_KEY, credentials.getAWSSecretKey());
        consumerConfig.put(ConsumerConfigConstants.STREAM_INITIAL_POSITION, "TRIM_HORIZON");

        // Create Kinesis stream
        DataStream<Record> kinesis = env.addSource(
                new FlinkKinesisConsumer<>(
                        "tweets-stream",
                        new RecordKinesisDeserializationSchema(),
                        consumerConfig)
        );

        // Extract tweets
        kinesis.flatMap(new RecordToStatuses()) // DataStream<Status>
                // Assign timestemp to records
                .assignTimestampsAndWatermarks(new StatusTimestampExtractor())
                // Extract hashtags
                .flatMap(new ExtractHashTags()) // DataStream<String, Integer>
                // Key by hashtag value
                .keyBy((KeySelector<String, String>) hashTag -> hashTag)
                // One minute time window
                .timeWindow(Time.minutes(1))
                // Count how many times each was used per minute and preserve a timestamp
                .apply(new WindowFunction<String, Tuple3<Date, String, Integer>, String, TimeWindow>() {
                    @Override
                    public void apply(String hashtag, TimeWindow timeWindow, Iterable<String> hashTags, Collector<Tuple3<Date, String, Integer>> collector) throws Exception {
                        int count = Iterators.size(hashTags.iterator());

                        collector.collect(new Tuple3<>(new Date(timeWindow.getStart()), hashtag, count));
                    }
                }) // DataStream<Tuple3<Date, String, Integer>>
                // Output stream to standard output
                .print();

        // Execute application
        env.execute("Flink/Kinesis demo");
    }

    private static class RecordKinesisDeserializationSchema implements KinesisDeserializationSchema<Record> {
        @Override
        public Record deserialize(byte[] recordValue, String partitionKey, String seqNum, long approxArrivalTimestamp, String stream, String shardId) throws IOException {
            return new Record()
                    .withData(ByteBuffer.wrap(recordValue))
                    .withPartitionKey(partitionKey)
                    .withSequenceNumber(seqNum)
                    .withApproximateArrivalTimestamp(new Date(approxArrivalTimestamp));
        }

        @Override
        public TypeInformation<Record> getProducedType() {
            return TypeInformation.of(Record.class);
        }
    }

    private static class RecordToStatuses implements FlatMapFunction<Record, Status> {
        @Override
        public void flatMap(Record record, Collector<Status> collector) throws Exception {
            for (UserRecord userRecord : UserRecord.deaggregate(Collections.singletonList(record))) {
                Status status = getStatus(userRecord);
                collector.collect(status);
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
    }

    private static class StatusTimestampExtractor extends BoundedOutOfOrdernessTimestampExtractor<Status> {

        public StatusTimestampExtractor() {
            super(Time.seconds(10));
        }

        @Override
        public long extractTimestamp(Status status) {
            return status.getCreatedAt().getTime();
        }
    }

    private static class ExtractHashTags implements FlatMapFunction<Status, String> {
        @Override
        public void flatMap(Status status, Collector<String> collector) throws Exception {
            for (HashtagEntity entity : status.getHashtagEntities()) {
                collector.collect(entity.getText());
            }
        }
    }
}
