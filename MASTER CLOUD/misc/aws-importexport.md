# AWS Import/Export Disk

* AWS Import/Export accelerates moving large amounts of data into and out of AWS using portable storage devices for transport
* AWS transfers the data directly onto and off of storage devices using Amazon’s high-speed internal network, bypassing the Internet, and can be much faster and more cost effective than upgrading connectivity.
* AWS Import/Export can be implemented in two different ways
  * AWS Import/Export Disk \(Disk\)
    * originally the only service offered by AWS for data transfer by mail
    * Disk supports transfers data directly onto and off of storage devices you own using the Amazon high-speed internal network
  * AWS Snowball
    * is generally faster and cheaper to use than Disk for importing data into Amazon S3
* AWS Import/Export supports
  * importing data to several types of AWS storage, including EBS snapshots, S3 buckets, and Glacier vaults.
  * exporting data out from S3 only
* Data load typically begins the next business day after the storage device arrives at AWS and after the data export or import completes, the storage device is returned

#### Ideal Usage Patterns

* AWS Import/Export is ideal for
  **transferring large amounts of data in and out of the AWS cloud, especially in cases where transferring the data over the Internet would be too slow \(a week or more\) or too costly.**
* Common use cases include
  * **first time migration**
    – initial data upload to AWS
  * **content distribution or regular data interchange**
    to/from your customers or business associates,
  * **off-site backup**
    – transfer to Amazon S3 or Amazon Glacier for off-site backup and archival storage, and
  * **disaster recovery**
    – quick retrieval \(export\) of large backups from Amazon S3 or Amazon Glacier

## AWS Import/Export Disk Jobs

* AWS Import/Export jobs can be created in 2 steps
  * Submit a Job request to AWS where  each job corresponds to exactly one storage device
  * Send your storage device to AWS, which after the data is uploaded or downloaded is returned back
* AWS Import/Export jobs can be created
  * using a command line tool, which requires no programming or
  * programmatically using the AWS SDK for Java or the REST API to send requests to AWS or
  * even through third party tools
* AWS Import/Export Data Encrption
  * supports data encryption methods
    * PIN-code encryption, Hardware-based device encryption that uses a physical PIN pad for access to the data.
    * TrueCrypt software encryption, Disk encryption using TrueCrypt, which is an open-source encryption application.
  * Creating an import or export job with encryption requires providing the PIN code or password for the selected encryption method
  * Although is is not mandatory for the data to be encrypted for import jobs, it is highly recommended
  * All export jobs require data encryption can use either hardware encryption or software encryption or both methods.
* AWS Import/Export supported Job Types
  * Import to S3

  * Import to EBS
  * Export to S3
* AWS erases the device after every import job prior to return shipping.

## Guidelines and Limitations

* AWS Import/Export does not support Server-Side Encryption \(SSE\) when importing data.
* Maximum file size of a single file or object to be imported is 5 TB. Files and objects larger than 5 TB won’t be imported.
* Maximum device capacity is 16 TB for Amazon Simple Storage Service \(Amazon S3\) and Amazon EBS jobs.
* Maximum device capacity is 4 TB for Amazon Glacier jobs.
* AWS Import/Export exports only the latest version from an Amazon S3 bucket that has versioning turned on.



