package com.pluralsight.kinesis.module3;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.kinesis.clientlibrary.lib.worker.KinesisClientLibConfiguration;
import com.amazonaws.services.kinesis.clientlibrary.lib.worker.Worker;
import com.amazonaws.services.kinesis.connectors.KinesisConnectorConfiguration;
import com.amazonaws.services.kinesis.connectors.KinesisConnectorRecordProcessorFactory;
import twitter4j.Status;

import java.util.Properties;

public class ConnectorsMain {
    public static void main(String... args) {
        Properties properties = new Properties();
        properties.setProperty(
                KinesisConnectorConfiguration.PROP_APP_NAME,
                "save-to-s3"
        );
        properties.setProperty(
                KinesisConnectorConfiguration.PROP_S3_BUCKET,
                "pluralsight-kinesis-course"
        );
        properties.setProperty(
                KinesisConnectorConfiguration.PROP_BUFFER_BYTE_SIZE_LIMIT,
                "100"
        );

        KinesisConnectorConfiguration config = new KinesisConnectorConfiguration(
                properties,
                new DefaultAWSCredentialsProviderChain()
        );

        KinesisConnectorRecordProcessorFactory<Status, byte[]> factory =
                new KinesisConnectorRecordProcessorFactory<>(
                        new ConnectorsPipeline(),
                        config
                );


        final KinesisClientLibConfiguration kclConfig = new KinesisClientLibConfiguration(
                "kinesis-to-s3",
                "tweets-stream",
                new DefaultAWSCredentialsProviderChain(),
                "worker-1"
        );

        Worker worker = new Worker.Builder()
                .recordProcessorFactory(factory)
                .config(kclConfig)
                .build();

        worker.run();


    }
}
