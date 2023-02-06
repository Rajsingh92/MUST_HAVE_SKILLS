# RDS Multi-AZ & Read Replica Overview

* DB instances replicas can be created in two ways Multi-AZ & Read Replica
* **Multi-AZ deployment**
  * Multi-AZ deployment provides high availability and failover support
  * RDS automatically provisions and manages a **synchronous **standby replica in a different AZ \(independent infrastructure in a physically separate location\)
  * RDS automatically fails over to the standby so that database operations can resume quickly without administrative intervention in case of
    * Planned database maintenance
    * Software patching
    * Rebooting of the Primary instance
    * Primary DB instance connectivity or host failure, or an
    * Availability Zone failure
* **Read Replica**
  * RDS uses the PostgreSQL, MySQL, and MariaDB DB engines’ built-in replication functionality to create a special type of DB instance called a Read Replica from a source DB instance.
  * Load on the source DB instance can be reduced by routing read queries from applications to the Read Replica.
  * Read Replicas allow elastic scaling beyond the capacity constraints of a single DB instance for read-heavy database workloads

## Multi-AZ deployment

* Multi-AZ deployments provides high availability and automatic failover support for DB instances
* Multi-AZ helps improve the durability and availability of a critical system, enhancing availability during planned system maintenance, DB instance failure and Availability Zone disruption.
* **Multi-AZ is a High Availability feature is not a scaling solution for read-only scenarios; standby replica can’t be used to serve read traffic. To service read-only traffic, use a Read Replica.**
* **Multi-AZ deployments for Oracle, PostgreSQL, MySQL, and MariaDB DB instances use Amazon technology, while SQL Server DB instances use SQL Server Mirroring.**
* In a Multi-AZ deployment,
  * RDS automatically provisions and maintains a **synchronous standby replica in a different Availability Zone**.
  * Copies of data are stored in different Availability Zones for greater levels of data durability.
  * Primary DB instance is **synchronously replicated **across Availability Zones to a standby replica to provide
    * data redundancy,
    * eliminate I/O freezes during snapshots and backups
    * and minimize latency spikes during system backups.
  * DB instances may have increased write and commit latency compared to a Single AZ deployment, due to the synchronous data replication
  * Transaction success is returned only if the commit is successful both on the primary and the standby DB
  * There might be a change in latency if the deployment fails over to the standby replica, although AWS is engineered with low-latency network connectivity between Availability Zones.
* When using the BYOL licensing model, a license for both the primary instance and the standby replica is required
* For production workloads, it is recommended to use Multi-AZ deployment with Provisioned IOPS and DB instance classes \(m1.large and larger\), optimized for Provisioned IOPS for fast, consistent performance.
* When Single-AZ deployment is modified to a Multi-AZ deployment \(for engines other than SQL Server or Amazon Aurora\)
  * RDS takes a snapshot of the primary DB instance from the deployment and restores the snapshot into another Availability Zone.
  * RDS then sets up synchronous replication between the primary DB instance and the new instance.
  * This avoids downtime when conversion from Single AZ to Multi-AZ

### RDS Multi-AZ Failover Process

* In the event of a planned or unplanned outage of the DB instance,
  * RDS automatically switches to a standby replica in another AZ, if enabled for Multi-AZ.
  * Time it takes for the failover to complete depends on the database activity and other conditions at the time the primary DB instance became unavailable.
  * Failover times are typically 60-120 secs. However, large transactions or a lengthy recovery process can increase failover time.
  * **Failover mechanism automatically changes the DNS record of the DB instance to point to the standby DB instance.**
  * Multi-AZ switch is seamless to the applications as there is no change in the endpoint URLs but just needs to re-establish any existing connections to the DB instance.
* RDS handles failover automatically so that database operations can be resumed as quickly as possible without administrative intervention.
* Primary DB instance switches over automatically to the standby replica if any of the following conditions occur:
  * An Availability Zone outage
  * Primary DB instance fails
  * DB instance’s server type is changed
  * Operating system of the DB instance is undergoing software patching
  * A manual failover of the DB instance was initiated using **Reboot with failover **\(also referred to as **Forced Failover**\)
* If the Multi-AZ DB instance has failed over, can be determined by
  * DB event subscriptions can be setup to notify you via email or SMS that a failover has been initiated.
  * DB events can be viewed via the Amazon RDS console or APIs.
  * Current state of your Multi-AZ deployment can be viewed via the RDS console and APIs.

## Read Replica

* Amazon RDS uses the **MySQL, MariaDB, and PostgreSQL **\(version 9.3.5 and later\) DB engines’ built-in replication functionality to create a Read Replica from a source DB instance.
* Updates made to the source DB instance are **asynchronously **copied to the Read Replica.
* Load on the source DB instance can be reduced by routing read queries from the applications to the Read Replica.
* Using Read Replicas allow DB to elastically scale out beyond the capacity constraints of a single DB instance for read-heavy database workloads.
* Read Replica operates as a DB instance that allows read-only connections; applications can connect to a Read Replica the same way they would to any DB instance.

### Read Replica creation

* Up to five Read Replicas can be created from one source DB instance.
* Creation process
  * Automatic backups must be enabled on the source DB instance by setting the backup retention period to a value other than 0
  * Existing DB instance needs to be specified as the source.
  * RDS takes a snapshot of the source instance and creates a read-only instance from the snapshot.
  * RDS then uses the **asynchronous replication **method for the DB engine to update the Read Replica for any changes to the source DB instance.
* RDS replicates all databases in the source DB instance.
* RDS sets up a secure communications channel between the source DB instance and the Read Replica, if that Read Replica is in a different AWS region from the DB instance.
* RDS establishes any AWS security configurations, such as adding security group entries, needed to enable the secure channel.
* During the Read Replica creation, a brief I/O suspension on the source DB instance can be experienced as the DB snapshot occurs.
* **I/O suspension typically lasts about one minute and can be avoided if the source DB instance is a Multi-AZ deployment \(in the case of Multi-AZ deployments, DB snapshots are taken from the standby\)**.
* Read Replica creation time can be slow if any long-running transactions are being executed and should wait for completion
* For multiple Read Replicas created in parallel from the same source DB instance, only one snapshot is taken at the start of the first create action.
* A Read Replica can be promoted to a new independent source DB, in which case the replication link is broken between the Read Replica and the source DB.  However, the replication continues for other replicas using the original source DB as the replication source

### Read Replica Deletion & DB Failover

* Read Replicas must be explicitly deleted, using the same mechanisms for deleting a DB instance.
* If the source DB instance is deleted without deleting the replicas, each replica is promoted to a stand-alone, single-AZ DB instance.
* If the source instance of a Multi-AZ deployment fails over to the standby, any associated Read Replicas are switched to use the secondary as their replication source.

### Read Replica Storage & Compute requirements

* A Read Replica, by default, is created with the same storage type as the source DB instance.
* For replication to operate effectively, each Read Replica should have the same amount of compute & storage resources as the source DB instance.
* Source DB instance, if scaled, Read Replicas should be scaled accordingly

### Read Replica Features & Limitations

* RDS does not support circular replication.
* DB instance cannot be configured to serve as a replication source for an existing DB instance; a new Read Replica can be created only from an existing DB instance
  _for e.g., if MyDBInstance replicates to ReadReplica1, ReadReplica1 can’t be configured to replicate back to MyDBInstance.  From ReadReplica1, only a new Read Replica can be created, such as ReadRep2._
* Cross-Region Replication
  * **MySQL, PostgresSQL**\(update from June 2016\) **or MariaDB Read Replica can be created in a different region**
    than the source DB instance which helps to improve
    * disaster recovery capabilities \(reduces RTO and RPO\),
    * scale read operations into a region closer to end users,
    * migration from a data center in one region to another region
* Read Replica can be created from other Read replicas as well. However, the replica lag is higher for these instances and there cannot be more than four instances involved in a replication chain.

### ![](https://i1.wp.com/jayendrapatil.com/wp-content/uploads/2016/06/Screen-Shot-2016-06-13-at-6.42.06-AM.png?resize=656%2C434 "Read Replica Comparision")

### Read Replica Use cases

* Read Replicas can be used in variety of use cases, including:
  * Scaling beyond the compute or I/O capacity of a single DB instance for read-heavy database workloads, directing excess read traffic to Read Replica\(s\)
  * Serving read traffic while the source DB instance is unavailable
    _for e.g. If the source DB instance cannot take I/O requests due to backups I/O suspension or scheduled maintenance, the read traffic can be directed to the Read Replica\(s\). _**However, the data might be stale.**
  * Business reporting or data warehousing scenarios where business reporting queries can be executed against a Read Replica, rather than the primary, production DB instance.



