# EMR - Elastic Map Reduce

* Presto \(and Impala\) for running SQL on hadoop / HDFS

* Use cases:

  * log processing / analytics
  * ETL
  * Clickstream analysis
  * Machine learning \(spark\)

* EMR runs on single AZ
  * for network performance reasons
    Apache Hadoop
* Modules:
  * Hadoop Common \(Hadoop Core\)
    * libraries and utils for other modules
    * abstracts underlying OS, etc.
  * Hadoop Distributed File System \(HDFS\)
    * Distributed File system
    * Fault-tolerant
    * Replicates Data
    * High throughput access to data
  * Hadoop YARN
    * Cluster resource management and job scheduling
* MapReduce Job Tasks:
  * Map:
    * splits data into smaller chunks processed in parallel
    * output becomes input for reduce task \(aggregation\)
  * Steps:
    1. Split
    2. Map \(e.g. count words\)
    3. Shuffle \(Bring same keys together from different machines after map, e.g. bring together counts for a given word\)
    4. Reduce \(aggregate the counts per word., e.g. sum\)

* Hadoop Architecture:
  * Single Master node 
    * Has the Resource manager
  * Multiple Slave nodes
    * contains:
      * Node Manager
      * Application Master
      * Container \(that actually runs the application\)

EMR Architecture:

* Instance Groups
  * just a way to organize EC2 instances \(can have different instances types\)
  * can have more than one instance group belonging to Task Instance Group. \(To be confirmed\)
  * Master Instance Group
  * Core Instance Groups
  * Task Instance Groups
* Nodes:
  * Single Master Node:
    * manages resources
    * coordinates distribution and execution
    * monitors health of core and task nodes
  * Core node \(Slave Node\):
    * runs tasks
    * store data in HDFS \(i.e. they store data\)
    * runs DataNode daemon which handles IO of HDFS / EMRFS
    * runs NodeManager to communicate with master node
    * removing core nodes \(shrinking\) can result in data loss from HDFS
  * Task node
    * they are optional in the cluster
    * they don't store data \(no HDFS\)
    * Added and removed during running of clusters.
    * Useful for extra capacity.
* HDFS
  * Distributed FS, simultaneous access from different machines.
  * Single global namespace provided by the master node.
  * Individual files are divided into multiple blocks which are stored in multiple Slave Nodes,
  * the same block is stored in multiple slave nodes for fault tolerance and performance
    EMR Storage options:
* Instance store \(ephemeral, lost after termination\)
  * High IO , high IOPS, D2 and I3 instance families
* EBS for HDFS: note they don't persist after EMR termination, contrary to EC2 normal behavior.
* EMRFS: implementation of HDFS where data is read/write directly to S3
  * don't need HDFS necessarily
  * Read consistency is same as S3:
    * write consistency on new put requests
    * eventual consistency on overwrite put and delete
    * can cause problems in ETL pipelines when reading after writing as it may fail to read output of previous step
    * EMRFS consistent view feature:
      * checks read-after-write consistency of new S3 objects written or synced with EMRFS
      * retry logic if inconsistency is detected
      * done using metadata in DynamoDB  
* can use HDFS and EMRFS together
  * Copy data from S3 to HDFS using `S3DistCp`
  * use case:
    * need high I/O performance taking advantage of local instance storage.
    * processing the same dataset frequently.

## EMR Operations

* Launching clusters;
  * prebuilt scripts and apps: Java, Hive, Pig, Python, Scala, .NET
  * automatically launch from S3
  * CLI
  * two ways to configure on creation in browser
    * can use quick options for quick
      * can't select VPC, uses the default VPC
      * can only seelect a limited set of applications
      * can only use one instance type for both master and task nodes
      * can not change security groups at creation time, only after
  * Advanced options
    * define exactly what applications
    * can define different instance types for task nodes, master nodes
  * Launching steps:
    * can define what is ran after launching
    * can specify termination after all steps are terminated \(for transient clusters\)
  * Note: tag EC2 instances on EMR launching, not directly in EC2.
  * SSH keypair is optional 
  * on creation 2 default security groups are used:
    * one for master node
    * one for core&task nodes
* Long running vs transient clusters:
  * when to use Long running clusters:
    * jobs run often
    * queries often on the same dataset, inefficient to load it each time
    * HDFS data is kept on core nodes
    * Termination protection is enabled \(can't terminate the cluster accidently\)
  * transient clueters
    * reduced costs, only billed when cluster is running
    * input data, output data and code stored in S3.
    * easy recover in case of failure.
      * Hive metastore can be stored in MySQL RDS.
* Choosing Instance types:
  * Map Reduce: use M types or storage optimized I2 instances
  * Large HBase clusters: use I2 or D2
  * Machine learning: use P2, or C
  * Spark: use memory instances, like R4
* EMR default replication factor for HDFS:
  * 3 for &gt;= 10 nodes
  * 2 for 4-9 nodes
  * 1 for &lt;= 3 nodes
  * override in hdfs-site.xml
* Cluster sizing:
  * Master node sizing:
    * m4.xlarge for &lt;= 50 nodes
    * m5.2xlarge for &gt; 50 nodes
  * Task Nodes:
    * for HDFS, if replication factor is 3, 10 i2 instances each with 800GB SSD means we have capacity for 8 TB / 3
      * can add more instances of more EBS volumes
    * AWS best practice: use less, larger nodes.
      Monitoring EMR
* Cloudwatch events
  * can set up an events rule that triggers whenever an EMR step status changes
    * as target, you can set e.g. msg sent to an SNS topic
* Cloudwatch metrics
  * `S3BytesRead`, `HDFSUtilization`, etc
* Web Interfaces
  * they are not publicly accessible, set up SSH tunnel to master node using local port forwarding, or using SOCKS proxy.
* Using ganglia, which is a distributed monitoring system. Runs on the master node

Resizing a cluster:

* can be done manually
  * adding instances is straightforward.
  * removing instances
  * EMR removes instances in graceful shrink
    * with HDFS, first EMR will replicate the blocks from instances marked for termination
    * can't have less instances than replication factor
* can enable autoscaling for EMR
  * set up min, max instances
  * can set up scale out rules 
  * can set up scale in rules
  * When creating a cluster through the browser, the default autoscaling role is automatically set `EMR_Autoscaling_DefaultRole`
    * without it , autoscaling doesn't work.
    * can't be added after cluster creation.

Hue in EMR

* open source web interface for apache hadoop
* can browse files in S3 and also in HDFS
* can browse HBase \(open source NoSQL database\)
* can browse ZooKeeper \(key value store\)
* has query browser using Hive \(SQL\)
  * similar to mysql workbench / pgadmin
* Job browser to check status of jobs
* browse server logs
* Oozie dashboard
* can use LDAP using existing credentials in an LDAP directory.
  * Should store this in S3, not in master node.
  * stored as a JSON file.

Hive on EMR

* HiveQL, SQL-like interface
* Hive Architecture
  * skipped
  * can store metastore in Mysql RDS for keeping it after termination
* Can run hive on data in:
  * S3 and DynamoDB
* Supports partitions \(folders in S3\)
* dynamoDB:
  * join tables, query, copy from and to dynamodb.
  * CREATE EXTERNAL TABLE command can be used to create a 'view' of a dynamodb table, so that inserts, updates, etc change the original dynamoDB table.

HBase on EMR

* NoSQL database, versioned db
* massively scalable 
* stricly consistent random realtime access for tables with billions of rows and millions of columns
* runs on top of EMRFS / HDFS
* Integrates with Hive
* Use cases:
  * Ad tech, clickstream, content \(e.g. messages\), Financial Data, ...
  * you have 100s of GBs to PBs
  * high write and update rates
  * flexible schema
  * fast access to data, random and real-time
  * fault-tolerance
  * no transactional applications \(no complex joins, etc.\)
  * wide column \(many columns, no row size restrictions\)
  * flexible row key data types \(dynamodb only supports scalar partition key\)
  * HBase index creation is manual and not so easy.
* Hbase VS redshift:
  * both are column oriented
  * writes:
    * HBase: updates and writes perform well
    * Redshift: use batch writes \(COPY command\), updates are slow
  * queries:
    * HBase: near real-time \(over fast changing data\)
    * Redshift: OLAP \(large complex queries, joins, ...\)
  * Summary: use HBase for fast changing data. Redshift for 

Presto on EMR:

* in-memory fast SQL query
* interactive analytic queries
* faster than hive
* query posgres, mongodb, redis, cassandra, dynamodb,...
* high concurrency, run thousands of queries per day.
* Dont use:
  * Not for joining very large tables \(100M plus rows\), use hive instead
  * not so good for batch processing as data needs to fit in memory

Spark on EMR:

* Fast engine for processing large amounts of data.
* runs in-memory or on disk. Much faster on in-memory
* Use cases:
  * interactive analytics \(faster than hive\)
  * scala, python ..
  * can query live data \(w/ spark streaming\)
  * supports stream processing
    * disparate data sources
  * machine learning
    * repeated queries. Traing machine learing algs
  * ETL
* When not to use:
  * not a database
  * data should fit in memory
  * not for large reporting environments with many users
    * instead use spark to copy data to a typical reporting database \(redshift, RDS,...\)
* Spark Core:
  * skipped
* Spark SQL
  * run low latency SQL
  * RDD and DataFrame APIs
  * file formats: avro, parquet, ORC. JSON
  * can query hive tables
  * JBDC/ OBDC for querying traditional databases.
* Spark integration AWS:
  * Spark streaming integrates with Kinesis streams using micro-batches
    * Spark uses abstracted Discretized Streams
    * makes use of KCL
* Compression file formats:
  * GZIP
    * Splittable: no
    * Compression ratio: high
    * speed: medium
  * BZIP2
    * Splittable: yes
    * ratio: very high
    * soeed: slow
  * LZO
    * Splittable: yes
    * ratio: low
    * speed: fast
  * PARQUET
    * Splittable: no \(but splittable on avro?\)
    * ratio: low
    * speed: very fast
  * file sizes:
    * gzip: 1-2 GB, because not splittable
    * avoid smaller than 100mbs 
  * S3DistCp can be used to copy data from-to S3 - HDFS.
    * can be used to combine smaller files into larger files

Lambda integration with Big Data Ecosystem:

* can trigger when S3, then insert data into DynamoDB, redshift,...
* notes:
  * `/tmp` space is 512mb
  * number of processes/ threads: 1024
  * max exec time: 300s
* can use lambda to process kinesis streams \(polls kinesis \)
* s3 -&gt; aws lambda -&gt; redshift . There's a lambda template. It stores metadata in dynamodb to prevent duplicates, checkpointing, etc.

EMR Security:

* security groups
  * need SG for master node, 
  * and other for core and task nodes
* default managed security groups
* use custom security groups e.g. when mulyipl clusters should be isolated from eachother.
* Can create EMR in private subnet
  * needs an S3 endpoint
  * needs bastion host to connect to master node
* Data encryption:
  * encryption at rest
  * in transit with TLS
    * for S3 it's enabled automatically
  * To add encryption needs to add an inline policy to the EMR role to allow access to KMS
  * encryption at rest:
    * supports in S3: SSE-s3, SSE-KMS, CSE-KMS, CSE-Custom
    * in local disk: use KMS
  * cannot change data encrpyion, need to unload to s3, then create new cluster without encryption.
* KMS supports sy,mmetric encryption only, same keys are used for encription and decritpion

check [https://stackoverflow.com/questions/10569455/differences-between-amazon-s3-and-s3n-in-hadoop?rq=1](https://stackoverflow.com/questions/10569455/differences-between-amazon-s3-and-s3n-in-hadoop?rq=1)





Amazon EMR is a web service that utilizes a hosted Hadoop framework running on the web-scale infrastructure of EC2 and S3

* EMR enables businesses, researchers, data analysts, and developers to easily and cost-effectively process vast amounts of data
* EMR
  * uses Apache Hadoop as its distributed data processing engine, which is an open source, Java software that supports data-intensive distributed applications running on large clusters of commodity hardware
  * is ideal for problems that necessitate fast and efficient processing of large amounts of data
  * lets the focus be on crunching or analyzing big data without having to worry about time-consuming set-up, management or tuning of Hadoop clusters or the compute capacity
  * can help perform data-intensive tasks for applications such as web indexing, data mining, log file analysis, machine learning, financial analysis, scientific simulation, and bioinformatics research etc
  * provides web service interface to launch the clusters and monitor processing-intensive computation on clusters
  * is a batch-processing framework that measures the common processing time duration in hours to days, if the use case is to have processing at real time or within minutes Apache Spark or Storm would be a better option
* EMR seamlessly supports On-Demand, Spot, and Reserved Instances
* EMR launches all nodes for a given cluster in the same EC2 Availability Zone, which improves performance as it provides higher data access rate
* EMR supports different EC2 instance types including Standard, High CPU, High Memory, Cluster Compute, High I/O, and High Storage
  * Standard Instances have memory to CPU ratios suitable for most general-purpose applications.
  * High CPU instances have proportionally more CPU resources than memory \(RAM\) and are well suited for compute-intensive applications
  * High Memory instances offer large memory sizes for high throughput applications
  * Cluster Compute instances have proportionally high CPU with increased network performance and are well suited for High Performance Compute \(HPC\) applications and other demanding network-bound applications
  * High Storage instances offer 48 TB of storage across 24 disks and are ideal for applications that require sequential access to very large data sets such as data warehousing and log processing
* EMR charges on hourly increments i.e. once the cluster is running,  charges apply entire hour
* EMR integrates with CloudTrail to record AWS API calls

#### **NOTE: Topic mainly for Solution Architect Professional Exam Only**

## EMR Architecture

* Amazon EMR uses industry proven, fault-tolerant Hadoop software as its data processing engine
* Hadoop is an open source, Java software that supports data-intensive distributed applications running on large clusters of commodity hardware
* Hadoop splits the data into multiple subsets and assigns each subset to more than one EC2 instance. So, if an EC2 instance fails to process one subset of data, the results of another Amazon EC2 instance can be used
* EMR consists of Master node, one or more Slave nodes
  * Master Node
    * EMR currently does not support automatic failover of the master nodes or master node state recovery
    * If master node goes down, the EMR cluster will be terminated and the job needs to be re-executed
  * Slave Nodes – Core nodes and Task nodes
    * Core nodes
      * host persistent data using Hadoop Distributed File System \(HDFS\) and run Hadoop tasks
      * can be increased in an existing cluster
    * Task nodes
      * only run Hadoop tasks
      * can be increased or decreased in an existing cluster
    * EMR is fault tolerant for slave failures and continues job execution if a slave node goes down.
    * Currently, EMR does not automatically provision another node to take over failed slaves
* EMR supports Bootstrap actions which allow
  * users a way to run custom set-up prior to the execution of the cluster.
  * can be used to install software or configure instances before running the cluster

## EMR Security

* EMR cluster starts with different security groups for Master and Slaves
  * Master security group
    * has a port open for communication with the service.
    * has a SSH port open to allow direct SSH into the instances, using the key specified at startup
  * Slave security group
    * only allows interaction with the master instance
    * SSH to the slave nodes can be done by doing SSH to the master node and then to the slave node
  * Security groups can be configured with different access rules

![](https://i2.wp.com/docs.aws.amazon.com/emr/latest/ReleaseGuide/images/emr-encryption.png?zoom=1.25&resize=656%2C421 "EMR Security Encryption")

* EMR enables use of security configuration
  * which helps to encrypt data at-rest, data in-transit, or both
  * can be used to specify settings for S3 encryption with EMR file system \(EMRFS\), local disk encryption, and in-transit encryption
  * is stored in EMR rather than the cluster configuration making it reusable
  * gives flexibility to choose from several options, including keys managed by AWS KMS, keys managed by S3, and keys and certificates from custom providers that you supply
* At-rest Encryption for S3 with EMRFS
  * EMRFS supports Server-side \(SSE-S3, SSE-KMS\) and Client-side encryption \(CSE-KMS or CSE-Custom\)
  * S3 SSE and CSE encryption with EMRFS are mutually exclusive; either one can be selected but not both
  * Transport layer security \(TLS\) encrypts EMRFS objects in-transit between EMR cluster nodes & S3
* At-rest Encryption for Local Disks
  * **Open-source HDFS Encryption**
    * HDFS exchanges data between cluster instances during distributed processing, and also reads from and writes data to instance store volumes and the EBS volumes attached to instances
    * Open-source Hadoop encryption options are activated
      * Secure Hadoop RPC is set to “Privacy”, which uses Simple Authentication Security Layer \(SASL\).
      * Data encryption on HDFS block data transfer is set to true and is configured to use AES 256 encryption.
  * **LUKS**
    . In addition to HDFS encryption, the Amazon EC2 instance store volumes \(except boot volumes\) and the attached Amazon EBS volumes of cluster instances are encrypted using LUKS
* In-Transit Data Encryption
  * Encryption artifacts used for in-transit encryption in one of two ways:
    * either by providing a zipped file of certificates that you upload to S3,
    * or by referencing a custom Java class that provides encryption artifacts

## EMR Cluster Types

* EMR has two cluster types, transient and persistent
* Transient EMR Clusters
  * Transient EMR clusters are clusters that shut down when the job or the steps \(series of jobs\) are complete
  * Transient EMT clusters can be used in situations
    * where total number of EMR processing hours per day &lt; 24 hours and its beneficial to shut down the cluster when it’s not being used.
    * using HDFS as your primary data storage.
    * job processing is intensive, iterative data processing.
* Persistent EMR Clusters
  * Persistent EMR clusters continue to run after the data processing job is complete
  * Persistent EMR clusters can be used in situations
    * frequently run processing jobs where it’s beneficial to keep the cluster running after the previous job.
    * processing jobs have an input-output dependency on one another.
    * In rare cases when it is more cost effective to store the data on HDFS instead of S3

## EMR Best Practices

* Data Migration
  * Two tools – S3DistCp and DistCp – can be used to move data stored on the local \(data center\) HDFS storage to S3, from S3 to HDFS and between S3 and local disk \(non HDFS\) to S3
  * AWS Import/Export and Direct Connect can also be considered for moving data
* Data Collection
  * Apache Flume is a distributed, reliable, and available service for efficiently collecting, aggregating, & moving large amounts of log data
  * Flume agents can be installed on the data sources \(web-servers, app servers etc\) and data shipped to the collectors which can then be stored in persistent storage like S3 or HDFS
* Data Aggregation
  * Data aggregation refers to techniques for gathering individual data records \(for e.g. log records\) and combining them into a large bundle of data files i.e. creating a large file from small files
  * Hadoop, on which EMR runs, generally performs better with fewer large files compared to many small files
  * Hadoop splits the file on HDFS on multiple nodes, while for the data in S3 it uses the HTTP Range header query to split the files which helps improve performance by supporting parallelization
  * Log collectors like Flume and Fluentd can be used to aggregate data before copying it to the final destination \(S3 or HDFS\)
  * Data aggregation has following benefits
    * Improves data ingest scalability by reducing the number of times needed to upload data to AWS
    * Reduces the number of files stored on S3 \(or HDFS\), which inherently helps provide better performance when processing data
    * Provides a better compression ratio as compressing large, highly compressible files is often more effective than compressing a large number of smaller files.
* Data compression
  * Data compression can be used at the input as well as intermediate outputs from the mappers
  * Data compression helps
    * Lower storage costs
    * Lower bandwidth cost for data transfer
    * Better data processing performance by moving less data between data storage location, mappers, and reducers
    * Better data processing performance by compressing the data that EMR writes to disk, i.e. achieving better performance by writing to disk less frequently
  * Data Compression can have an impact on Hadoop data splitting logic as some of the compression techniques like gzip do not support it
  * ![](https://i1.wp.com/jayendrapatil.com/wp-content/uploads/2017/01/Data-Compression-Techniques.png?resize=656%2C246 "Data Compression Techniques")
* Data Partitioning
  * Data partitioning helps in data optimizations and lets you create unique buckets of data and eliminate the need for a data processing job to read the entire data set
  * Data can be partitioned by
    * Data type \(time series\)
    * Data processing frequency \(per hour, per day, etc.\)
    * Data access and query pattern \(query on time vs. query on geo location\)
* Cost Optimization
  * AWS offers different pricing models for EC2 instances
    * On-Demand instances
      * are a good option if using transient EMR jobs or if the EMR hourly usage is less than 17% of the time
    * Reserved instances
      * are a good option for persistent EMR cluster or if the  EMR hourly usage is more than 17% of the time as is more cost effective
    * Spot instances
      * can be a cost effective mechanism to add compute capacity
      * can be used where the data is persists on S3
      * can be used to add extra task capacity with Task nodes, and
      * is not suited for Master node, as if it is lost the cluster is lost and Core nodes \(data nodes\) as they host data and if lost needs to be recovered to rebalance the HDFS cluster
  * Architecture pattern can be used,
    * Run master node on On-Demand or Reserved Instances \(if running persistent EMR clusters\).
    * Run a portion of the EMR cluster on core nodes using On-Demand or Reserved Instances and
    * the rest of the cluster on task nodes using Spot Instances.

## EMR – S3 vs HDFS

* Storing data on S3 provides several benefits
  * inherent features high availability, durability, lifecycle management, data encryption and archival of data to Glacier
  * cost effective as storing data in S3 is cheaper as compared to HDFS with the replication factor
  * ability to use Transient EMR cluster and shutdown the clusters after the job is completed, with data being maintained in S3
  * ability to use Spot instances and not having to worry about losing the spot instances any time
  * provides data durability from any HDFS node failures, where node failures exceed the HDFS replication factor
  * data ingestion with high throughput data stream to S3 is much easier than ingesting to HDFS



