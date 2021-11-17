# AWS RDS Best Practices

AWS recommends RDS best practices in terms of Monitoring, Performance and security

### Amazon RDS Basic Operational Guidelines

* **Monitoring**
  * Memory, CPU, and storage usage should be monitored.
  * CloudWatch can be setup for notifications when usage patterns change or when the capacity of deployment is approached, so that system performance and availability can be maintained
* **Scaling**
  * Scale up the DB instance when approaching storage capacity limits.
  * There should be some buffer in storage and memory to accommodate unforeseen increases in demand from the applications.
* **Backups**
  * Enable Automatic Backups and set the backup window to occur during the daily low in WriteIOPS.
* On a MySQL DB instance,
  * Do not create more than 10,000 tables using Provisioned IOPS or 1000 tables using standard storage. Large numbers of tables will significantly increase database recovery time after a failover or database crash. If you need to create more tables than recommended, set the innodb\_file\_per\_table parameter to 0.
  * Avoid tables in the database growing too large. Provisioned storage limits restrict the maximum size of a MySQL table file to 6 TB. Instead, partition the large tables so that file sizes are well under the 6 TB limit. This can also improve performance and recovery time.
* **Performance**
  * If the database workload requires more I/O than provisioned, recovery after a failover or database failure will be slow.
  * To increase the I/O capacity of a DB instance,
    * Migrate to a DB instance class with High I/O capacity.
    * Convert from standard storage to Provisioned IOPS storage, and use a DB instance class that is optimized for Provisioned IOPS.
    * if using Provisioned IOPS storage, provision additional throughput capacity.
* **Multi-AZ & Failover**
  * Deploy applications in all Availability Zones, so if an AZ goes down, applications in other AZs will still be available.
  * Use Amazon RDS DB events to monitor failovers.
  * Set a TTL of less than 30 seconds, if the client application is caching the DNS data of the DB instances. As the underlying IP address of a DB instance can change after a failover, caching the DNS data for an extended time can lead to connection failures if the application tries to connect to an IP address that no longer is in service.
  * Multi-AZ requires transaction logging feature to be enabled. Do not use features like Simple recover mode, offline mode or Read-only mode which turn of transaction logging.
  * To shorten failover time
    * Ensure that sufficient Provisioned IOPS allocated for your workload. Inadequate I/O can lengthen failover times. Database recovery requires I/O.
    * Use smaller transactions. Database recovery relies on transactions, so break up large transactions into multiple smaller transactions to shorten failover time
  * Test failover for your DB instance to understand how long the process takes for your use case and to ensure that the application that accesses your DB instance can automatically connect to the new DB instance after failover.

### DB Instance RAM Recommendations

* An Amazon RDS performance best practice is to allocate enough RAM so that the working set resides almost completely in memory.
* Value of ReadIOPS should be small and stable.
* ReadIOPS metric can be checked, using AWS CloudWatch while the DB instance is under load, to tell if the working set is almost all in memory
* If scaling up the DB instance class with more RAM, results in a dramatic drop in ReadIOPS, the working set was not almost completely in memory.
* Continue to scale up until ReadIOPS no longer drops dramatically after a scaling operation, or ReadIOPS is reduced to a very small amount.

### Amazon RDS Security Best Practices

* Do not use AWS root credentials to manage Amazon RDS resources; and IAM users should be created for everyone,
* Grant each user the minimum set of permissions required to perform his or her duties.
* Use IAM groups to effectively manage permissions for multiple users.
* Rotate your IAM credentials regularly.

### Using Enhanced Monitoring to Identify Operating System Issues

* Amazon RDS provides metrics in real time for the operating system \(OS\) that your DB instance runs on.
* Enhanced monitoring is available for all DB instance classes except for db.t1.micro and db.m1.small.

### Using Metrics to Identify Performance Issues

* To identify performance issues caused by insufficient resources and other common bottlenecks, you can monitor the metrics available for your Amazon RDS DB instance
* Performance metrics should be monitored on a regular basis to benchmark  the average, maximum, and minimum values for a variety of time ranges. to help identify performance degradation.
* Amazon CloudWatch alarms can be set for particular metric thresholds to be alerted when they are reached or breached
* A DB instance has a number of different categories of metrics which includes CPU, memory, disk space, IOPS, db connections and network traffic, and how to determine acceptable values depends on the metric.
* One of the best ways to improve DB instance performance is to tune the most commonly used and most resource-intensive queries to make them less expensive to run.

### Recovery

* **MySQL**
  * InnoDB is the recommended and supported storage engine for MySQL DB instances on Amazon RDS.
  * However, MyISAM performs better than InnoDB if you require intense, full-text search capability.
  * Point-In-Time Restore and snapshot restore features of Amazon RDS for MySQL require a crash-recoverable storage engine and are supported for the InnoDB storage engine only.
  * Although MySQL supports multiple storage engines with varying capabilities, not all of them are optimized for crash recovery and data durability.
  * MyISAM storage engine does not support reliable crash recovery and might prevent a Point-In-Time Restore or snapshot restore from working as intended which might result in lost or corrupt data when MySQL is restarted after a crash.
* **MariaDB**

  * XtraDB is the recommended and supported storage engine for MariaDB DB instances on Amazon RDS.
  * Point-In-Time Restore and snapshot restore features of Amazon RDS for MariaDB require a crash-recoverable storage engine and are supported for the XtraDB storage engine only.
  * Although MariaDB supports multiple storage engines with varying capabilities, not all of them are optimized for crash recovery

    and data durability.

  * _For e.g although Aria is a crash-safe replacement for MyISAM, it might still prevent a Point-In-Time Restore or snapshot restore from working as intended. This might result in lost or corrupt data when MariaDB is restarted after a crash._



