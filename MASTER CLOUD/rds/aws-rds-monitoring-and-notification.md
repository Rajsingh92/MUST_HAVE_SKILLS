## AWS RDS Monitoring & Notification

* RDS integrates with CloudWatch and provides metrics for monitoring
* CloudWatch alarms can be created over a single metric that sends an SNS message when the alarm changes state
* RDS also provides SNS notification whenever any RDS event occurs

## CloudWatch RDS Monitoring

* RDS DB instance can be monitored using CloudWatch, which collects and processes raw data from RDS into readable, near real-time metrics.
* The statistics are recorded for a period of two weeks, so that you can access historical information and gain a better perspective on how the service is performing.
* By default, RDS metric data is automatically sent to Amazon CloudWatch in 1-minute periods
* CloudWatch RDS Metrics
  * BinLogDiskUsage – Amount of disk space occupied by binary logs on the master. Applies to MySQL read replicas.
  * CPUUtilization – Percentage of CPU utilization.
  * DatabaseConnections – Number of database connections in use.
  * DiskQueueDepth – The number of outstanding IOs \(read/write requests\) waiting to access the disk.
  * FreeableMemory – Amount of available random access memory.
  * FreeStorageSpace – Amount of available storage space.
  * **ReplicaLag**
    – Amount of time a Read Replica DB instance lags behind the source DB instance. Applies to MySQL, MariaDB, and PostgreSQL Read Replicas.
  * SwapUsage – Amount of swap space used on the DB instance.
  * ReadIOPS – Average number of disk I/O operations per second.
  * WriteIOPS – Average number of disk I/O operations per second.
  * ReadLatency – Average amount of time taken per disk I/O operation.
  * WriteLatency – Average amount of time taken per disk I/O operation.
  * ReadThroughput – Average number of bytes read from disk per second.
  * WriteThroughput – Average number of bytes written to disk per second.
  * NetworkReceiveThroughput – Incoming \(Receive\) network traffic on the DB instance, including both customer database traffic and Amazon RDS traffic used for monitoring and replication.
  * NetworkTransmitThroughput – Outgoing \(Transmit\) network traffic on the DB instance, including both customer database traffic and Amazon RDS traffic used for monitoring and replication.

## RDS Event Notification

* RDS uses the SNS to provide notification when an RDS event occurs
* RDS groups the events into categories, which can be subscribed so that a notification is sent when an event in that category occurs.
* Event category for a DB instance, DB cluster, DB snapshot, DB cluster snapshot, DB security group or for a DB parameter group can be subscribed
* Event notifications are sent to the email addresses provided during subscription creation
* Subscription can be easily turn off notification without deleting a subscription by setting the Enabled radio button to No in the RDS console or by setting the Enabled parameter to false using the CLI or RDS API.



