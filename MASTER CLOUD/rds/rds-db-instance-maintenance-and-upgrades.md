### RDS DB Instance Maintenance and Upgrades

Changes to a DB instance can occur when a DB instance is manually modified_for e.g. DB engine version is upgraded, or when Amazon RDS performs maintenance on an instance_

#### Amazon RDS Maintenance

* Periodically, Amazon RDS performs maintenance on Amazon RDS resources, such as DB instances and most often involves updates to the DB instance’s operating system \(OS\).
* Maintenance items can either
  * be applied manually on a DB instance at ones convenience
  * or wait for the automatic maintenance process initiated by Amazon RDS during the defined weekly maintenance window.
* Maintenance window only determines when pending operations start, but does not limit the total execution time of these operations. Maintenance operations are not guaranteed to finish before the maintenance window ends, and can continue beyond the specified end time.
* Maintenance update availability can be checked both on the RDS console and by using the RDS API. And if an update is available, one can
  * Defer the maintenance items.
  * Apply the maintenance items immediately.
  * Schedule them to start during the next defined maintenance window
* Maintenance items marked as
  * **Required**
    cannot be deferred indefinitely, if deferred AWS will send a notify the time when the update will be performed next
  * **Available**
    and can be deferred indefinitely and the update will not be applied to the DB instance.
* **Required patching is automatically scheduled only for patches that are related to security and instance reliability**
  . Such patching occurs infrequently \(typically once every few months\) and seldom requires more than a fraction of your maintenance window.
* Maintenance items require that RDS take your DB instance offline for a short time. Maintenance that requires DB instance to be offline include scale compute operations, which generally take only a few minutes from start to finish, and required operating system or database patching.
* **Multi-AZ deployment for the DB instance reduces the impact of a maintenance event by following these steps:**
  * **Perform maintenance on the standby.**
  * **Promote the standby to primary.**
  * **Perform maintenance on the old primary, which becomes the new standby.**
* When database engine for the DB instance is modified in a Multi-AZ deployment, RDS upgrades both the primary and secondary DB instances at the same time. In this case, the database engine for the entire Multi-AZ deployment is shut down during the upgrade.

#### Operating System Updates

* Upgrades to the operating system are most often for security issues and should be done as soon as possible.
* OS updates on a DB instance can be applied at ones convenience or can wait for the maintenance process initiated by RDS to apply the update during the defined maintenance window
* DB instance is not automatically backed up when an OS update is applied, and should be backup up before the update is applied

#### Database Engine Version Upgrade

* DB instance engine version can be upgraded when a new DB engine version is supported by RDS.
* Database version upgrades consist of major and minor version upgrades.
  * Major database version upgrades
    * can contain changes that are not backward-compatible
    * RDS doesn’t apply major version upgrades automatically
    * DB instance should be manually modified and thoroughly tested before applying it to the production instances.
  * Minor version upgrades
    * Each DB engine handles minor version upgrade slightly differently _for e.g. RDS automatically apply minor version upgrades to a DB instance running PostgreSQL, but must be manually applied to a DB instance running Oracle._
* Amazon posts an announcement to the forums announcement page and sends a customer e-mail notification before upgrading an DB instance
* Amazon schedule the upgrades at specific times through the year, to help plan around them, because downtime is required to upgrade a DB engine version, even for Multi-AZ instances.
* RDS takes two DB snapshots during the upgrade process.
  * First DB snapshot is of the DB instance before any upgrade changes have been made. If the upgrade fails, it can be restored from the snapshot to create a DB instance running the old version.
  * Second DB snapshot is taken when the upgrade completes. After the upgrade is complete, database engine can’t be reverted to the previous version. For returning to the previous version, restore the first DB snapshot taken to create a new DB instance.
* If the DB instance is using read replication, all of the Read Replicas must be upgraded before upgrading the source instance.
* If the DB instance is in a Multi-AZ deployment, both the primary and standby replicas are upgraded at the same time and would result in an outage. The time for the outage varies based on your database engine, version, and the size of your DB instance.

#### RDS Maintenance Window

* Every DB instance has a weekly maintenance window defined during which any system changes are applied.
* Maintenance window is an opportunity to control when DB instance modifications and software patching occur, in the event either are requested or required.
* If a maintenance event is scheduled for a given week, it will be initiated during the 30 minute maintenance window as defined
* Maintenance events mostly complete during the 30 minute maintenance window, although larger maintenance events may take more time
* 30-minute maintenance window is selected at random from an 8-hour block of time per region. If you don’t specify a preferred maintenance window when you create the DB instance, Amazon RDS assigns a 30-minute maintenance window on a randomly selected day of the week.
* RDS will consume some of the resources on the DB instance while maintenance is being applied, minimally effecting performance.
* For some maintenance events, a Multi-AZ failover may be required for a maintenance update to complete.



