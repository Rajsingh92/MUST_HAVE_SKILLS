# AWS RDS Security

* AWS provides multiple features to provide RDS security
  * DB instance can be hosted in a VPC for the greatest possible network access control
  * IAM policies can be used to assign permissions that determine who is allowed to manage RDS resources
  * Security groups allow to control what IP addresses or EC2 instances can connect to the databases on a DB instance
  * Secure Socket Layer \(SSL\) connections with DB instances
  * RDS encryption to secure RDS instances and snapshots at rest.
  * Network encryption and transparent data encryption \(TDE\) with Oracle DB instances

## RDS Authentication and Access Control

* IAM can be used to control which RDS operations each individual user has permission to call

## Encrypting RDS Resources

* RDS encrypted instances use the industry standard AES-256 encryption algorithm to encrypt data on the server that hosts the RDS instance
* RDS then handles authentication of access and decryption of this data with a minimal impact on performance, and with no need to modify your database client applications
* Data at Rest Encryption
  * can be enabled on RDS instances to encrypt the underlying storage
  * encryption keys are managed by KMS
  * can be enabled only during instance creation
  * once enabled, the encryption keys cannot be changed
  * if the key is lost, the DB can only be restored from the backup
* Once encryption is enabled for an RDS instance,
  * logs are encrypted
  * snapshots are encrypted
  * automated backups are encrypted
  * read replicas are encrypted
* Cross region replicas and snapshots copy does not work since the key is only available in a single region
* RDS DB Snapshot considerations
  * DB snapshot encrypted using an KMS encryption key can be copied
  * Copying an encrypted DB snapshot, results in an encrypted copy of the DB snapshot
  * When copying, DB snapshot can either be encrypted with the same KMS encryption key as the original DB snapshot, or a different KMS encryption key to encrypt the copy of the DB snapshot.
  * An unencrypted DB snapshot can be copied to an encrypted snapshot, a quick way to add encryption to a previously unencrypted DB instance.
  * Encrypted snapshot can be restored only to an encrypted DB instance
  * If a KMS encryption key is specified when restoring from an unencrypted DB cluster snapshot, the restored DB cluster is encrypted using the specified KMS encryption key
  * Copying an encrypted snapshot shared from another AWS account, requires access to the KMS encryption key used to encrypt the DB snapshot.
  * Because KMS encryption keys are specific to the region that they are created in, encrypted snapshot cannot be copied to another region
* Transparent Data Encryption \(TDE\)
  * Automatically encrypts the data before it is written to the underlying storage device and decrypts when it is read  from the storage device
  * is supported by Oracle and SQL Server
    * Oracle requires key storage outside of the KMS and integrates with CloudHSM for this
    * SQL Server requires a key but is managed by RDS

## SSL to Encrypt a Connection to a DB Instance

* Encrypt connections using SSL for data in transit between the applications and the DB instance
* Amazon RDS creates an SSL certificate and installs the certificate on the DB instance when RDS provisions the instance.
* SSL certificates are signed by a certificate authority. SSL certificate includes the DB instance endpoint as the Common Name \(CN\) for the SSL certificate to guard against spoofing attacks
* While SSL offers security benefits, be aware that SSL encryption is a compute-intensive operation and will increase the latency of the database connection.

## RDS Security Groups

* Security groups control the access that traffic has in and out of a DB instance
* VPC security groups act like a firewall controlling network access to your DB instance.
* VPC security groups can be configured and associated with the DB instance to allow access from an IP address range, port, or EC2 security group
* Database security groups default to a “deny all” access mode and customers must specifically authorize network ingress.

## Master User Account Privileges

* When you create a new DB instance, the default master user that used gets certain privileges for that DB instance
* Subsequently, other users with permissions can be created

## Event Notification

* Event notifications can be configured for important events that occur on the DB instance
* Notifications of a variety of important events that can occur on the RDS instance, such as whether the instance was shut down, a backup was started, a failover occurred, the security group was changed, or your storage space is low can be received



