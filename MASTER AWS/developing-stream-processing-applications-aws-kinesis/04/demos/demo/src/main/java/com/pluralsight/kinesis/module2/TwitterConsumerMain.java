package com.pluralsight.kinesis.module2;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.kinesis.clientlibrary.interfaces.v2.IRecordProcessorFactory;
import com.amazonaws.services.kinesis.clientlibrary.lib.worker.InitialPositionInStream;
import com.amazonaws.services.kinesis.clientlibrary.lib.worker.KinesisClientLibConfiguration;
import com.amazonaws.services.kinesis.clientlibrary.lib.worker.Worker;

public class TwitterConsumerMain {

    public static void main(String... args) {

        final KinesisClientLibConfiguration config = new KinesisClientLibConfiguration(
                "tweets-processor",
                "tweets-stream",
                new DefaultAWSCredentialsProviderChain(),
                "worker-1"
        );
        config.withInitialPositionInStream(InitialPositionInStream.LATEST);
        config.withCallProcessRecordsEvenForEmptyRecordList(true);
        config.withIdleTimeBetweenReadsInMillis(200);

        final IRecordProcessorFactory recordProcessorFactory = new TweetsProcessorFactory();

        final Worker worker = new Worker.Builder()
                .config(config)
                .recordProcessorFactory(recordProcessorFactory)
                .build();

        worker.run();
    }
}
