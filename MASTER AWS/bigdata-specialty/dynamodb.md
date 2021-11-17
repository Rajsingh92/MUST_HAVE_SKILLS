# DynamoDB

* fully managed noSQL database
* no practical storage limitations
* runs on SSD behind the scences. single-digit ms latency
* DynamoDB is a collection of Tables

Table:

* You can specify the performance requirements:
  * Write Capacity Units , WCU - number of 1 KB blocks/sec. \(always rounded , 0.5 KB still counts as 1 WCU\)
  * Read Capacity Units, RCU - number of 4 KB blocks/sec. \(also rounded, 2 KB -&gt; 1 RCU\)
* Read Consistency
  * Eventually consistent reads by default
    * uses 0.5 RCU per 4 KB block \(therefore cheaper\)
  * Strongly consistent reads
    * uses 1 RCU per 4 KB block
* Data structure \(data schema\) is not fixed at the table level.
* Elements of a table:

  * Each row is called an `item`.
  * Each row has one or more Attributes \(similar to columns in SQL\).
    * Items don't all need to have the same attributes.
  * Special attributes:
    * Partition Key \(aka Hash Key\)
    * Sort Key \(aka Range Key\)
      * Allows 1-to-many relationship
      * Provides sorted items and efficient range queries
    * The value of the Partition Key + Sort key must unique in the table. If no sort key, then partition key value must be unique.
  * Attribute types:
    * `String`, `Number`, `Binary` \(base64\), `Boolean`, `Null`, `Document(List/Map)`= Json, `Set` = array

* When creating a table you must specify:

  * table name
  * WCU/ RCU
  * Partition key

* DynamoDB integrations:

  * Redshift COPY command can write directly from DynamoDB to Redshift.
  * On EMR, you can use Apache Hive to read and write to DynamoDB using SQL-like language.
    * can join dynamo DB tables, copy to S3, HDFS, etc
  * Use data pipeline to import/ export data from DynamoDB \(which behind the scenes spawns transient EMR clusters\)
  * Can specify triggers that automatically react to dynamoDB tables and call AWS Lambda
  * Kinesis Streams Connector library

DynamoDB Partitions

* A partition relates to the underlying storage and processing nodes of DynamoDB
* Initially one table = one parition
* Initially all data for a table is stored in the single partition.
* You have no direct control over the number of partitions \(only indirect\)
* Max capacity of a single partition:
  * 10 GB
  * 3000 RCU
  * 1000 WCU
* Note that the configured table capacity \(WCU/RCU\) is split accross partitions
* Data distribution over partitions:
  * the node is selected based on the partition key \(hashed\)
  * A given partition key value is mapped to one, and only one partition.
  * However, a partition can hold many different partition key values.
* Scaling \(increase / decrease number of partitions\)

  * When capacity is exceeded a new partition is added automatically and data is spread between them over time.
  * There is no automatic decrease in number of partitions
    * This can cause performance issues whereby a low WCU/RCU is divided among many partitions, which means the actual WCU and RCU limit for a given partition is even lower.
  * in other words, table capacity is divided across partitions!

* Calculating the minimum number of partitions:

  * max of:
    * Desired\_RCU / 3000 + Desired\_WCU / 1000
    * Data size / 10 GB

* Good attributes for partition keys:

  * many distinct values
  * uniform write pattern accross partitions
  * writes distributed uniformly across time \(can't usually control this\)

* Creating more uniform distribution of hot keys:

  * add random suffix \(e.g. PARTITION\_KEY=CONCAT\(ORIGINAL\_PARTITION\_KEY, RAND\(0,10\)\)\)
  * querying requires generating all the suffixes for a given `ORIGINAL_PARTITION_KEY` and querying each one of them.

* To handle bursts of writes, use SQS to buffer writes

* Burst Capacity

  * DynamoDB provides some flexibility in your per-partition throughput provisioning by providing burst capacity, as follows. Whenever you are not fully using a partition's throughput, DynamoDB reserves a portion of that unused capacity for later bursts of throughput to handle usage spikes.
  * retains up to five minutes \(300 seconds\) of unused read and write capacity. 
    During an occasional burst of read or write activity, these extra capacity units can be consumed quickly—even faster than the per-second provisioned throughput capacity that you've defined for your table.
    DynamoDB can also consume burst capacity for background maintenance and other tasks without prior notice.   

DynamoDB operations:

* SCAN
  * very inefficient linear search
* QUERY:
  * a single partition key or partition key + sort key
  * a partition key and range of sort keys
  * Indexed partition key + sort keys

Indexes

* Local Secondary Index \(LSI\)
  * Must be created at table-creation, can't be created after the fact.
  * The index itself contains:
    * old partition key \(same as base table\)
    * new sort key \(must be a single scalar attribute\)
    * old sort key \(as a regular, non-key value\)
    * a subset of attributes \(called projected attributes\)
  * LSI are sparse indexes, it will only have items \(=rows\) that contain non null sort key attribute.
  * Querying \(Reads\):
    * If you query an attribute that is not projected, you are charged for the entire ITEM cost as it must be pulled from the main table
      DynamoDB must query first the index and then the main table
      * Each sub query is rounded to 4KB separately 
  * Writes:
    * ADD: two writes if it belongs to LSI
    * DELETE: two writes if it belongs to LSI
    * UPDATE: may require two updates on the LSI, first to delete old entry, one to add a new entry. 
  * LSI limits the number of sort keys for a given partition key to 10 GB
    * \(Called ItemCollections\).
  * LSI limitations:
    * can perform efficient queries for specified partition key values.
      However, cannot efficiently query the sparse index if one wants to query without specifying the partition key
      example: partition key= weather station, LSI sort key=intrusion detected.
      Can't query all items which have intrusion detected regardless of which weather station it is.
      Need GSI for this. In that case the intrusion\_detected attribute would be defined as the partition key
      and the old partition \(=weather station\) would become the sort key of the GSI\).     
      * Global Secondary Index \(GSI\)
      * can be thought of as a copy of the original table whose replication is handled by dynamoDB
      * can have its own alternative Partition and sort key
      * has its own capacity, RCU/WCU, independent from main table
      * GSI is updated asynchronously
      * Options for attribute projection:
    * KEYS\_ONLY:
      * new partition key
      * new sort key
      * old partition key
      * old sort key
    * INCLUDE:
      * specify custom projection values
    * ALL:
      * projects all attributes
  * Note: GSI can cause bottlenecks to updates to the original table.
    * because GSI has its own WCU/RCU limits 

DynamoDB stream

* an ordered record of updates to a DynamoDB table
* stores changes for 24hrs
* endpoint: streams.dynamodb.us-west-2.amazonaws.com
  * note: the streams API has its own endpoint, not the same has the main dynamodb api.
* All changes show up in the stream once and only once.
* Latency is low \(near real-time\)
* What gets written to the stream is configurable with four 'views':
  * `KEYS_ONLY`: only the key attributes are written to the stream \(partition, sort\)
  * `NEW_IMAGE`: entire item after update
  * `OLD_IMAGE`: entire item before update
  * `OLD_AND_NEW_IMAGE`: both old and new
* Use cases:
  * Replication
    * replicate a database table in one AWS region to another in near-realtime for resiliency
    * sync writes in different regions?
    * Note: as of Nov 2017, replication is now supported natively by DynamoDB with the 'Global Tables' feature. 
  * Triggers
    * Lambda function triggered, e.g.
      * when new user is added to the users table
      * when items are added, for performing analytics 

# AWS DynamoDB

* Amazon DynamoDB is a fully managed NoSQL database service that
  * makes it simple and cost-effective to store and retrieve any amount of data and serve any level of request traffic.
  * provides fast and predictable performance with seamless scalability
* DynamoDB enables customers to offload the administrative burdens of operating and scaling distributed databases to AWS, without having to worry about hardware provisioning, setup and configuration, replication, software patching, or cluster scaling.
* DynamoDB tables do not have fixed schemas, and table consists of items and each item may have a different number of attributes.
* DynamoDB synchronously replicates data across three facilities in an AWS Region, giving high availability and data durability.
* DynamoDB supports fast in-place updates. A numeric attribute can be incremented or decremented in a row using a single API call
* DynamoDB uses proven cryptographic methods to securely authenticate users and prevent unauthorized data access
* Durability, performance, reliability, and security are built in, with SSD \(solid state drive\) storage and automatic 3-way replication.
* DynamoDB supports two different kinds of primary keys:
  * **Partition Key **\(previously called the **Hash key**\)
    * A simple primary key, composed of one attribute
    * DynamoDB uses the partition key’s value as input to an internal hash function; the output from the hash function determine the partition where the item will be stored.
    * No two items in a table can have the same partition key value.
  * **Partition Key and Sort Key **\(previously called the **Hash and Range key**\)
    * A composite primary key composed of two attributes. The first attribute is the partition key, and the second attribute is the sort key.
    * DynamoDB uses the partition key value as input to an internal hash function; the output from the hash function determines the partition where the item will be stored.
    * All items with the same partition key are stored together, in sorted order by sort key value.
    * It is possible for two items to have the same partition key value, but those two items must have different sort key values.
* DynamoDB Secondary indexes
  * add flexibility to the queries, without impacting performance.
  * are automatically maintained as sparse objects, items will only appear in an index if they exist in the table on which the index is defined making queries against an index very efficient
* DynamoDB throughput and single-digit millisecond latency makes it a great fit for gaming, ad tech, mobile, and many other applications
* ElastiCache can be used in front of DynamoDB in order to offload high amount of reads for non frequently changed data

## DynamoDB Performance

* Automatically scales horizontally
* runs exclusively on Solid State Drives \(SSDs\).
  * SSDs help achieve the design goals of predictable low-latency response times for storing and accessing data at any scale.
  * SSDs High I/O performance enables it to serve high-scale request workloads cost efficiently, and to pass this efficiency along in low request pricing
* allows provisioned table reads and writes
  * Scale up throughput when needed
  * Scale down throughput four times per UTC calendar day
* automatically partitions, reallocates and re-partitions the data and provisions additional server capacity as the
  * table size grows or
  * provisioned throughput is increased
* Global Secondary indexes \(GSI\)
  * can be created upfront or added later

## DynamoDB Consistency

* Each DynamoDB table is automatically stored in the three geographically distributed locations for durability
* Read consistency represents the manner and timing in which the successful write or update of a data item is reflected in a subsequent read operation of that same item
* DynamoDB allows user to specify whether the read should be eventually consistent or strongly consistent at the time of the request
  * **Eventually Consistent Reads**
    \(Default\)
    * Eventual consistency option maximizes the read throughput.
    * Consistency across all copies is usually reached within a second
    * However, an eventually consistent read might not reflect the results of a recently completed write.
    * Repeating a read after a short time should return the updated data.
  * **Strongly Consistent Reads**
    * Strongly consistent read returns a result that reflects all writes that received a successful response prior to the read
* Query, GetItem, and BatchGetItem operations perform eventually consistent reads by default
  * Query and GetItem operations can be forced to be strongly consistent
  * Query operations cannot perform strongly consistent reads on Global Secondary Indexes
  * BatchGetItem operations can be forced to be strongly consistent on a per-table basis

## DynamoDB Security

* Fine Grained Access Control \(FGAC\) gives a high degree of control over data in the table
* FGAC helps control who \(caller\) can access which items or attributes of the table and perform what actions \(read/write capability\).
* FGAC is integrated with IAM, which manages the security credentials and the associated permissions.

## DynamoDB Advanced Topics

Refer to[DynamoDB Advanced](http://jayendrapatil.com/aws-dynamodb-advanced/) post, which covers DynamoDB Streams, Triggers, Cross Region Replication, DAX, VPC Endpoints etc.

## DynamoDB Encryption

* Data in Transit Encryption
  * can be done by encrypting sensitive data on the client side or using encrypted connections \(TLS\)
* DynamoDB supports Encryption at rest
  * Encryption at rest enables encryption for the data persisted \(data at rest\) in the DynamoDB tables.
  * Encryption at rest includes the base tables, secondary indexes
  * Encryption at rest automatically integrates with AWS KMS for managing the keys used for encrypting the tables.
  * Encryption at rest can be enabled only for a new table and not for an existing table
  * Encryption once enabled for a table, cannot be disabled
  * DynamoDB Streams do not support encryption
  * On-Demand Backups of encrypted DynamoDB tables are encrypted using S3’s Server-Side Encryption
  * Encryption at rest encrypts your data using 256-bit AES encryption.

## DynamoDB Costs

* Index Storage
  * DynamoDB is an indexed data store
    * Billable Data = Raw byte data size + 100 byte per-item storage indexing overhead
* Provisioned throughput
  * Pay flat, hourly rate based on the capacity reserved as the throughput provisioned for the table
  * one Write Capacity Unit provides one write per second for items &lt;1KB in size.
  * one Read Capacity Unit provides one strongly consistent read \(or two eventually consistent reads\) per second for items 
    &lt;4KB in size.
  * Provisioned throughput charges for every 10 units of Write Capacity and every 50 units of Read Capacity.
* Reserved capacity
  * Significant savings over the normal price
  * Pay a one-time upfront fee

## DynamoDB Best Practices

* Keep item size small
* Store metadata in DynamoDB and large BLOBs in Amazon S3
* Use table per day, week, month etc for storing time series data
* Use conditional or Optimistic Concurrency Control \(OCC\) updates
  * Optimistic Concurrency Control is like Optimistic locking in the RDMS
  * OCC is generally used in environments with low data contention, conflicts are rare and transactions can be completed without the expense of managing locks and transactions
  * OCC assumes that multiple transactions can frequently be completed without interfering with each other.
  * Transactions are executed using data resources without acquiring locks on those resources and waiting for other transaction locks to be cleared
  * Before a transaction is committed, it is verified if the data was modified by any other transaction. If so, it would be rollbacked and needs to be restarted with the updated data
  * OCC leads to higher throughput as compared to other concurrency control methods like pessimistic locking, as locking can drastically limit effective concurrency even when deadlocks are avoided
* Avoid hot keys and hot partitions





# AWS DynamoDB Secondary Indexes

* DynamoDB provides fast access to items in a table by specifying primary key values
* DynamoDB Secondary indexes on a table allow efficient access to data with attributes other than the primary key
* DynamoDB Secondary indexes
  * is a data structure that contains a subset of attributes from a table
  * is associated with exactly one table, from which it obtains its data
  * requires an alternate key for the index partition key and sort key
  * additionally can define projected attributes which are copied from the base table into the index along with the primary key attributes
  * is automatically maintained by DynamoDB
  * any addition, modification, or deletion of items in the base table, any indexes on that table are also updated to reflect these changes.
  * helps reduce the size of the data as compared to the main table, depending upon the project attributes and hence helps improve provisioned throughput performance
  * are automatically maintained as **sparse **objects. Items will only appear in an index if they exist in the table on which the index is defined, making queries an index very efficient
* DynamoDB Secondary indexes supports two types
  * **Global secondary index – **an index with a **partition key and a sort key that can be different from those on the base table**
  * **Local secondary index – **an index that **has the same partition key as the base table, but a different sort key**

## Global Secondary Indexes \(GSI\)

* DynamoDB creates and maintains indexes for the primary key attributes for efficient access of data in the table, which allows applications to quickly retrieve data by specifying primary key values.
* Global Secondary Indexes \(GSI\) are indexes that contain partition or composite partition-and-sort keys that can be different from the keys in the table on which the index is based.
* Global secondary index is considered “global” because queries on the index can span all items in a table, across all partitions.
* Multiple secondary indexes can be created on a table, and queries issued against these indexes.
* Applications benefit from having one or more secondary keys available to allow efficient access to data with attributes other than the primary key.
* GSIs support non-unique attributes, which increases query flexibility by enabling queries against any non-key attribute in the table
* GSIs support
  **eventual consistency**
  . DynamoDB automatically handles item additions, updates and deletes in a GSI when corresponding changes are made to the table
  **asynchronously**
* Data in a secondary index consists of GSI alternate key, primary key and  attributes that are projected, or copied, from the table into the index.
* Attributes that are part of an item in a table, but not part of the GSI key, primary key of the table, or projected attributes are not returned on querying the GSI index
* GSIs manage throughput independently of the table they are based on and the provisioned throughput for the table and each associated GSI needs to be specified at creation time
  * Read provisioned throughput
    * provides one Read Capacity Unit with two eventually consistent reads per second for items &lt; 4KB in size.
    * provides one Write Capacity Unit with one write per second for items &lt;1KB in size.
  * Write provisioned throughput
    * consumes 1 write capacity unit if,
      * new item is inserted into table
      * existing item is deleted from table
      * existing items is updated for project attributes
    * consumes 2 write capacity units if
      * existing item is updated for key attributes, which results in deletion and addition of the new item into the index

## Local Secondary Indexes

* Local secondary index are indexes that has the same partition key as the table, but a different sort key.
* Local secondary index is “local” cause every partition of a local secondary index is scoped to a table partition that has the same partition key.
* LSI allows search using a secondary index in place of the sort key, thus expanding the number of attributes that can be used for queries which can be conducted efficiently
* LSI are updated automatically when the primary index is updated and reads support both
  **strong and eventually consistent options**
* LSIs can only be queried via the Query API
* LSIs cannot be added to existing tables at this time
* LSIs cannot be modified once it is created at this time
* LSI cannot be removed from a table once they are created at this time
* LSI consumes provisioned throughput capacity as part of the table with which it is associated
  * Read Provisioned throughput
    * if data read is index and projected attributes
      * provides one Read Capacity Unit with one strongly consistent read \(or two eventually consistent reads\) per second for items &lt; 4KB
      * data size includes the index and projected attributes only
    * if data read is index and a non projected attribute
      * consumes double the read capacity, with one to read from the index and one to read from the table with the entire data and not just the non projected attribute
  * Write provisioned throughput
    * consumes 1 write capacity unit if,
      * new item is inserted into table
      * existing item is deleted from table
      * existing items is updated for project attributes
    * consumes 2 write capacity units if
      * existing item is updated for key attributes, which results in deletion and addition of the new item into the index

![](https://i2.wp.com/jayendrapatil.com/wp-content/uploads/2017/03/DynamoDB-Secondary-Indexes-GSI-vs-LSI.png?resize=656%2C505 "DynamoDB Secondary Indexes - GSI vs LSI")

