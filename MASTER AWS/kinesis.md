# Notes for the AWS Big Data Specialty Certification Exam

## Links / Tasks

* [https://aws.amazon.com/certification/certified-big-data-specialty/](https://aws.amazon.com/certification/certified-big-data-specialty/)
* Course: [https://aws.amazon.com/training/course-descriptions/bigdata-fundamentals/](https://aws.amazon.com/training/course-descriptions/bigdata-fundamentals/)
  * [https://www.aws.training/transcript/curriculumplayer?transcriptId=WIwWOETJeUC\_B31xuDS1pA2](https://www.aws.training/transcript/curriculumplayer?transcriptId=WIwWOETJeUC_B31xuDS1pA2)
* AWS whitepapers: [https://aws.amazon.com/whitepapers/](https://aws.amazon.com/whitepapers/) ,

# Kinesis

* 3 services:
  * Kinesis Streams
  * Kinesis Analytics: Run SQL on the data streams
  * Kinesis Firehose: Load streaming data into S3, Redshift, etc.

## Kinesis Streams

* Collect and process large streams of data in real-time
* Use cases:

  * Fast \(second / milisecond latency\) processing of log events
  * Real-time metrics and reporting
  * Data analytics
  * Complex stream processing

* Kinesis Libraries / Tools:

  * Producing data:
    * Kinesis Producer Library \(KPL\)
      * Blog post, [Implementing Efficient and Reliable Producers with the Amazon Kinesis Producer Library](https://aws.amazon.com/blogs/big-data/implementing-efficient-and-reliable-producers-with-the-amazon-kinesis-producer-library/)
      * has auto-retry configurable mechanism
      * Supports two complementary ways of batching:
        * Collection \(of stream records\):
          * buffers / collects records to write multiple records to multiple shards in a single request.
          * `RecordMaxBufferedTime`: max time a record may be buffered before a request is sent. Larger = more throughput but higher latency.
        * Aggregation \(of user records\):
          * Combines multiple user records into a single kinesis stream record. \(using `PutRecords` API request\)
      * KCL integration \(for deaggregating user records\)
    * Kinesis Agent
      * Standalone application that you can install in the servers you're interested in.
      * Features:
        * Monitors file patterns and sends new data records to delivery streams
        * Handles file rotation, checkpointing, and retry upon failure
        * Delivers all data in a reliable, timely, and simpler manner
        * Emits CloudWatch metrics for monitoring and troubleshooting
        * Allows preprocessing data ,e.g. converting multi-line record to single line, converting from delimiter to JSON, converting from log to JSON
    * Kinesis Streams API
  * Reading data:
    * Kinesis Client library \(KCL\)
      * The KCL ensures there is a record processor running and processing each shard.
      * The Kinesis Client Library uses a DynamoDB table to store control data. It creates one table per application that is processing data.
      * KCL creates a worker thread for each shard. Auto assigns shards to workers \(even workers on different ec2 instances\)
      * KCL Checkpointing
        * Last processed record sequence number is stored in DynamoDB
        * On worker failure, KCL restarts from last checkpointed record.
      * Supports deaggregation of records aggregated with KPL
      * Note: KCL may be bottlenecked by DynamoDB table \(throwing Provisioned Throughput Exceptions\)
        * Add more provisioned throughput to the dynamoDB table if needed.
    * Kinesis Stream API
  * Emitting data
    * Kinesis Connector Library \(Java\), for KCL
      * Connectors for: DynamoDb, Redshift, S3, Elasticsearch
      * Java library with the following steps / interfaces:
        * iTransformer: maps from stream records to user-defined data model
        * iFilter: remove irrelevant records
        * iBuffer: buffers based on size limit and total byte count
        * iEmitter: sends the data in the buffer to AWS services
      * S3Emitter: writes buffer to a single file.

* Kinesis Stream API:
  * `PutRecord` \(single record per HTTP request\)
  * `PutRecords` \(multiple records per single HTTP request\). Recommended. Higher throughput
    * Single record failure does not stop the processing of subsequent records
    * Will return `HTTP 200` as long as some records succeed \(even when others failed\).
    * Retry requires application code in the producer to examine the `PutRecordsResult` object and retry whichever records failed.

* Kinesis Data Streams \([https://docs.aws.amazon.com/streams/latest/dev/key-concepts.html\#partition-key](https://docs.aws.amazon.com/streams/latest/dev/key-concepts.html#partition-key)\)

  * A stream is a set of shards. Each shard is a sequence of data records.
  * Each data record has a sequence number that is assigned automatically by the stream.
  * A data record has 3 parts:
    * sequence number
    * partition key
    * data blob \(immutable sequence of bytes\). 
    * blob can be up to 1000KB.
  * A sequence number is only unique within it's shard

* Retention Period:

  * The length of time data is accessible in the stream.
  * Default: 24hrs. Max: 7days \(168 hrs\).
  * You pay more for longer retention periods. 

Kinesis Application Name:

* Each application must have a unique name per \(AWS account, region\). The name is used to identify the DynamoDB and the namespace for CloudWatch metrics.   

Partition Keys:

* A partition key is used to group data by shard within a stream. It must be present when writing to the stream. 
* When writing to a stream, Kinesis separates data records into multiple shards based on each record's partition key.
* Partition keys are Unicode strings with a maximum length of 256 bytes. An MD5 hash function is used to map partition keys to 128-bit integer values that defines which shard records will end up in.

A Kinesis data stream is a set of shards. Each shard has a sequence of data records. Each data record has a sequence number that is assigned by Kinesis Data Streams.

* Kinesis Shard
  * Uniquely identified group of data records in a stream
  * You can have multiple shards in a stream.
  * Single shard capacity:
    * write
      * 1 MB/sec input
      * 1000 writes/sec
    * read
      * 2 MB/sec output
      * 5 transaction reads/sec
    * Remember: each stream record can have a blob of up to 1000 KB  
  * Resharding
    * Shard split: divide a shard into two shards
      * To split a shard, we must specify the shard that is to be split and the new hash key, which is the position in the shard where the shard gets split. In many cases, the new hash key might simply be the average of the beginning and ending hash key, but it can be any hash key value in the range being mapped into the shard.
      * Example using boto3:
        \`sinfo = kinesis.describe\_stream\("BotoDemo"\)
        hkey = int\(sinfo\["StreamDescription"\]\["Shards"\]\[0\]\["HashKeyRange"\]\["EndingHashKey"\]\)
        shard\_id = 'shardId-000000000000' \#we only have one shard!
        kinesis.split\_shard\("BotoDemo", shard\_id, str\(\(hkey+0\)/2\)\)\`
    * Shard merge: merge two shards into one
  * Partition Key:
    * Specified by the app that writes into the stream

* Kinesis Server-side encryption:
  * Can automatically encrypt data written, using KMS master keys. Both producer and consumer must have permission to access the master key.
  * Before you use user-generated KMS master keys, ensure that your Kinesis stream producers and consumers \(IAM principals\) are users in the KMS master key policy:
    * Add `kms:GenerateDataKey` to producer's role
    * Add `kms:Decrypt` to consumer's role

# Kinesis Firehose

* Managed service for loading data from streams directly into:
  * S3, Redshift and Elasticsearch
* Fully managed:
  * Scalability, sharding and monitoring with zero admin
  * Secure
* Methods to Load data
  * Use Kinesis Agent
  * Use AWS SDK
    * `PutRecord` and `PutRecordBatch`
* Firehose to S3:
  * Buffering of data before sending to S3. Sends whenever any of these conditions is met:
    * Buffer size \(from 1 MB to 128 MB\)
      * Firehose can raise the buffer size dynamically \(e.g. when falling behind\)
    * Buffer interval \(from 60s to 900s\)
* Can invoke AWS lambda for data transformation. Data flow:
  * Buffers incoming data up to 3 MB or buffering size specified, whichever is lowest
  * Firehose invokes Lambda function
  * Transformed data is sent from Lambda to Firehose for buffering
  * Transformed data is delivered to the destination.
  * Response from Lambda must include:
    * `recordId`: must be the same as prior to transformation
    * `result`: status, one of : `"Ok", "Dropped", "ProcessingFailed"`.
    * `data`: Transformed data payload
  * Failure handling of _data transformation_:
    * 3 retries
    * invocation errors logged in CloudWatch Logs
    * Unsuccessful records are stored in `processing_failed` folder in S3.
  * It's possible to store the source records in S3, prior to transformation. \(Backup S3 bucket\).
* Data delivery speed:
  * S3: based on buffer size / buffer interval
  * Redshift:
    * depending on how fast the redshift cluster finishes the COPY command.
    * Firehose sends new copy commands when previous have finished
  * Elasticsearch:
    * Depends on buffer size \(1 - 100 MB\) and Buffer interval
* Firehose Failure Handling:
  * S3:   
    * retries for up to 24 hrs
  * Redshift:
    * retry duration from 0-7200 sec \(2 hrs\) from S3
    * Skips S3 objects on failure
    * Writes failed objects in manifest file, which can be used manually to recover lost data \(manual backfill\)
  * ElasticSearch:
    * retry duration 0-7200 sec.
    * On failure, skips index request and stores in S3 `index_failed` folder.
    * Manual backfill



# AWS Kinesis

* Amazon Kinesis enables real-time processing of streaming data at massive scale
* Kinesis Streams enables building of custom applications that process or analyze streaming data for specialized needs
* Kinesis Streams features
  * handles provisioning, deployment, ongoing-maintenance of hardware, software, or other services for the data streams
  * manages the infrastructure, storage, networking, and configuration needed to stream the data at the level of required data throughput
  * synchronously replicates data across three facilities in an AWS Region, providing high availability and data durability
  * stores records of a stream for up to 24 hours, by default, from the time they are added to the stream. The limit can be raised to up to 7 days by enabling extended data retention
* Data such as clickstreams, application logs, social media etc can be added from multiple sources and within seconds is available for processing to the Amazon Kinesis Applications
* Kinesis provides ordering of records, as well as the ability to read and/or replay records in the same order to multiple Kinesis applications.
* Kinesis Streams is useful for rapidly moving data off data producers and then continuously processing the data, be it to transform the data before emitting to a data store, run real-time metrics and analytics, or derive more complex data streams for further processing
  * Accelerated log and data feed intake
    : Data producers can push data to Kinesis stream as soon as it is produced, preventing any data loss and making it available for processing within seconds.
  * Real-time metrics and reporting
    : Metrics can be extracted and used to generate reports from data in real-time.
  * Real-time data analytics
    : Run real-time streaming data analytics.
  * Complex stream processing
    : Create Directed Acyclic Graphs \(DAGs\) of Kinesis Applications and data streams, with Kinesis applications adding to another Amazon Kinesis stream for further processing, enabling successive stages of stream processing.
* Kinesis limits
  * stores records of a stream for up to 24 hours, by default, which can be extended to max 7 days
  * maximum size of a data blob \(the data payload before Base64-encoding\) within one record is 1 megabyte \(MB\)
  * Each shard can support up to 1000 PUT records per second
  * Each account can provision 10 shards per region, which can be increased further through request
* Amazon Kinesis is designed to process streaming big data and the pricing model allows heavy PUTs rate.
* Amazon S3 is a cost-effective way to store your data, but not designed to handle a stream of data in real-time

## ![](https://i0.wp.com/docs.aws.amazon.com/streams/latest/dev/images/architecture.png?zoom=1.25&resize=656%2C314 "Kinesis Architecture")

## Kinesis Streams

* **Shard**
  * Streams are made of shards and is the base throughput unit of an Kinesis stream.
  * Each shard provides a capacity of 1MB/sec data input and 2MB/sec data output
  * Each shard can support up to 1000 PUT records per second
  * All data is stored for 24 hours.
  * Replay data inside a 24-hour window
  * Shards define the capacity limits. If the limits are exceeded, either by data throughput or the number of PUT records, the put data call will be rejected with a
    ProvisionedThroughputExceeded
    exception.
  * This can be handled by
    * Implementing a retry on the data producer side, if this is due to a temporary rise of the stream’s input data rate
    * Dynamically scaling the number of shared \(resharding\) to provide enough capacity for the put data calls to consistently succeed
* **Record**
  * A record is the unit of data stored in an Amazon Kinesis stream.
  * A record is composed of a sequence number, partition key, and data blob.
  * Data blob is the data of interest your data producer adds to a stream.
  * Maximum size of a data blob \(the data payload before Base64-encoding\) is 1 MB
* **Partition key**
  * Partition key is used to segregate and route records to different shards of a stream.
  * A partition key is specified by your data producer while adding data to an Amazon Kinesis stream
* **Sequence number**
  * A sequence number is a unique identifier for each record.
  * Sequence number is assigned by Amazon Kinesis when a data producer calls PutRecord or PutRecords operation to add data to an Amazon Kinesis stream.
  * Sequence numbers for the same partition key generally increase over time; the longer the time period between PutRecord or PutRecords requests, the larger the sequence numbers become.

## Kinesis Streams Components

* Data to an Amazon Kinesis stream can be added via PutRecord and
  PutRecords operations, [Kinesis Producer Library \(KPL\)](http://docs.aws.amazon.com/kinesis/latest/dev/developing-producers-with-kpl.html), or [Kinesis Agent](http://docs.aws.amazon.com/kinesis/latest/dev/writing-with-agents.html).
  * **Amazon Kinesis Agent**
    * is a pre-built Java application that offers an easy way to collect and send data to Amazon Kinesis stream.
    * can be installed on a Linux-based server environments such as web servers, log servers, and database servers
    * can be configured to monitor certain files on the disk and then continuously send new data to the Amazon Kinesis stream
  * **Amazon Kinesis Producer Library \(KPL\)**
    * is an easy to use and highly configurable library that helps you put data into an Amazon Kinesis stream.
    * presents a simple, asynchronous, and reliable interface that enables you to quickly achieve high producer throughput with minimal client resources.
* Amazon Kinesis Application is a data consumer that reads and processes data from an Amazon Kinesis stream and can be build using either [Amazon Kinesis API](http://docs.aws.amazon.com/kinesis/latest/dev/kinesis-using-api-java.html) or [Amazon Kinesis Client Library \(KCL\)](http://docs.aws.amazon.com/kinesis/latest/dev/kinesis-record-processor-app.html)
  * **Amazon Kinesis Client Library \(KCL\)**
    * is a pre-built library with multiple language support
    * delivers all records for a given partition key to same record processor
    * makes it easier to build multiple applications reading from the same Kinesis stream for e.g. to perform counting, aggregation, and filtering
    * handles complex issues such as adapting to changes in stream volume, load-balancing streaming data, coordinating distributed services, and processing data with fault-tolerance
  * [Amazon Kinesis Connector Library](https://github.com/awslabs/amazon-kinesis-connectors)
    * is a pre-built library that helps you easily integrate Amazon Kinesis Streams with other AWS services and third-party tools
    * Kinesis Client Library is required for Kinesis Connector Library
  * [Amazon Kinesis Storm Spout](https://github.com/awslabs/kinesis-storm-spout)
    is a pre-built library that helps you easily integrate Amazon Kinesis Streams with
    [Apache Storm](https://storm.incubator.apache.org/)

## Kinesis vs SQS

* Kinesis Streams enables real-time processing of streaming big data while SQS offers a reliable, highly scalable hosted queue for storing messages and move data between distributed application components
* Kinesis provides ordering of records, as well as the ability to read and/or replay records in the same order to multiple Amazon Kinesis Applications while SQS does not guarantee data ordering and provides at least once delivery of messages
* Kinesis stores the data up to 24 hours, by default, and can be extended to 7 days while SQS stores the message up to 4 days, by default, and can be configured from 1 minute to 14 days but clears the message once deleted by the consumer
* Kineses and SQS both guarantee at-least once delivery of message
* Kinesis supports multiple consumers while SQS allows the messages to be delivered to only one consumer at a time and requires multiple queues to deliver message to multiple consumers
* Kinesis use cases requirements
  * Ordering of records.
  * Ability to consume records in the same order a few hours later
  * Ability for multiple applications to consume the same stream concurrently
  * Routing related records to the same [record processor](https://aws.amazon.com/kinesis/streams/faqs/#recordprocessor) \(as in streaming MapReduce\)
* SQS uses cases requirements
  * Messaging semantics like message-level ack/fail and visibility timeout
  * Leveraging SQS’s ability to scale transparently
  * Dynamically increasing concurrency/throughput at read time
  * Individual message delay, which can be delayed

## Kinesis vs S3

![](https://i1.wp.com/jayendrapatil.com/wp-content/uploads/2017/01/Amazon-Kinesis-vs-S3.png?resize=656%2C456 "Amazon Kinesis vs S3")



