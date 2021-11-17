[Amazon Glacier](https://aws.amazon.com/cn/documentation/glacier/?id=docs_gateway) 是一种针对不常用的数据（“冷数据”）而经过了优化的存储服务。这项服务为数据存档和备份提供了持久且成本极低的存储解决方案及安全功能。使用 Amazon Glacier，您可以将数据经济高效地存储数月、数年，甚至数十年。Amazon Glacier 可让您将存储扩展到 AWS 并卸下操作以及管理负担，这样，您就不必担心容量规划、硬件配置、数据复制、硬件故障检测和恢复，或者耗时的硬件迁移等问题

# **AWS Glacier**

* Amazon Glacier is a storage service optimized for archival, infrequently used data, or “cold data.”
* Glacier is an extremely low-cost storage service that provides durable storage with security features for data archiving and backup.
* Glacier is designed to provide average annual durability of 99.999999999% for an archive.
* Glacier redundantly stores data in multiple facilities and on multiple devices within each facility.
* To increase durability, Glacier synchronously stores the data across multiple facilities before returning SUCCESS on uploading archives.
* Glacier performs regular, systematic data integrity checks and is built to be automatically self-healing.
* Glacier enables customers to offload the administrative burdens of operating and scaling storage to AWS, without having to worry about capacity planning, hardware provisioning, data replication, hardware failure detection and recovery, or time-consuming hardware migrations.
* **Glacier is a great storage choice when low storage cost is paramount, with data rarely retrieved,**
  ~~**and retrieval latency of several hours is acceptable.**~~
* **Glacier now offers a range of data retrievals options where the retrieval time varies from hours to 1-5 minutes**
* **S3 should be used if applications requires fast, frequent real time access to the data**
* Glacier can store virtually any kind of data in any format.
* All data is encrypted on the server side with Glacier handling key management and key protection. It uses AES-256, one of the strongest block ciphers available
* Glacier allows interaction through AWS Management Console, Command Line Interface CLI and SDKs or REST based APIs.
  * management console can only be used to create and delete vaults.
  * rest of the operations to upload, download data, create jobs for retrieval need CLI, SDK or REST based APIs
* Use cases include
  * Digital media archives
  * Data that must be retained for regulatory compliance
  * Financial and healthcare records
  * Raw genomic sequence data
  * Long-term database backups

## Amazon Glacier Data Model

* Amazon Glacier data model core concepts include vaults and archives and also includes job and notification-configuration resources
  * **Vault**
    * A vault is a container for storing archives
    * Each vault resource has a unique address, which comprises of the region the vault was created and the unique vault name within the region and account for e.g. [https://glacier.us-west-2.amazonaws.com/111122223333/vaults/examplevault](https://glacier.us-west-2.amazonaws.com/111122223333/vaults/examplevault)
    * Vault allows storage of unlimited number of archives
    * Glacier supports various vault operations which are region specific
    * An AWS account can create up to 1,000 vaults per region.
  * **Archive**
    * An archive can be any data such as a photo, video, or document and is a base unit of storage in Glacier.
    * Each archive has a unique ID and an optional description, which can only be specified during the upload of an archive.
    * Glacier assigns the archive an ID, which is unique in the AWS region in which it is stored.
    * Archive can be uploaded in a single request. While for large archives, Glacier provides a multipart upload API that enables uploading an archive in parts.
  * **Jobs**
    * A Job is required to retrieve an Archive and vault inventory list
    * Data retrieval requests are asynchronous operations, are queued and most jobs take about four hours to complete.
    * A job is first initiated and then the output of the job is downloaded after the job is completes
    * Vault inventory jobs needs the vault name
    * Data retrieval jobs needs both the vault name and the archive id, with an optional description
    * A vault can have multiple jobs in progress at any point in time and can be identified by Job ID, assigned when is it created for tracking
    * Glacier maintains job information such as job type, description, creation date, completion date, and job status and can be queried
    * After the job completes, the job output can be downloaded in full or partially by specifying a byte range.
  * **Notification Configuration**
    * As the jobs are asynchronous, Glacier supports notification mechanism to a SNS topic when job completes
    * SNS topic for notification can either be specified with each individual job request or with the vault
    * Glacier stores the notification configuration as a JSON document

## Glacier Data **Retrievals Options**

Glacier provides three options for retrieving data with varying access times and cost: Expedited, Standard, and Bulk retrievals.

### Standard retrievals

* Standard retrievals allow access to any of the archives within several hours.
* Standard retrievals typically complete within 3-5 hours.

### Bulk retrievals

* Bulk retrievals are Glacier’s lowest-cost retrieval option, enabling retrieval of large amounts, even petabytes, of data inexpensively in a day.
* Bulk retrievals typically complete within 5 – 12 hours.

### Expedited retrievals

* Expedited retrievals allows quick access to the data when occasional urgent requests for a subset of archives are required.
* For all but the largest archives \(250MB+\), data accessed using Expedited retrievals are typically made available within 1 – 5 minutes.
* There are two types of Expedited retrievals: On-Demand and Provisioned.
  * On-Demand requests are like EC2 On-Demand instances and are available the vast majority of the time.
  * Provisioned requests are guaranteed to be available when needed

## Glacier Supported Operations

### Vault Operations

* Glacier provides operations to create and delete vaults.
* A vault can be deleted only if there are no archives in the vault as of the last computed inventory and there have been no writes to the vault since the last inventory \(as the inventory is prepared periodically\)
* Vault Inventory
  * Vault inventory helps retrieve list of archives in a vault with information such as archive ID, creation date, and size for each archive
  * Inventory for each vault is prepared periodically, every 24 hours
  * Vault inventory is updated approximately once a day, starting on the day the first archive is uploaded to the vault.
  * When a vault inventory job is, Glacier returns the last inventory it generated, which is a point-in-time snapshot and not real-time data.
* Vault Metadata or Description can also be obtained for a specific vault or for all vaults in a region, which provides information such as
  * creation date,
  * number of archives in the vault,
  * total size in bytes used by all the archives in the vault,
  * and the date the vault inventory was generated
* Glacier also provides operations to set, retrieve, and delete a notification configuration on the vault. Notifications can be used to identify vault events.

### Archive Operations

* Glacier provides operations to upload, download and delete archives.

#### Uploading an Archive

* An archive can be uploaded in a single operation \(1 byte to up to 4 GB in size \) or in parts referred as Multipart upload \(40 TB\)
* Multipart Upload helps to
  * improve the upload experience for larger archives.
  * upload archives in parts, independently, parallely and in any order
  * faster recovery by needing to upload only the part that failed upload and not the entire archive.
  * upload archives without even knowing the size
  * upload archives from 1 byte to about 40,000 GB \(10,000 parts \* 4 GB\) in size
* **To upload existing data to Glacier, consider using the AWS Import/Export service, which accelerates moving large amounts of data into and out of AWS using portable storage devices for transport. AWS transfers the data directly onto and off of storage devices using **
  **Amazon’s high-speed internal network, bypassing the Internet.**
* Glacier returns a response that includes an archive ID which is unique in the region in which the archive is stored
* Glacier does not support any additional metadata information apart from an optional description. Any additional metadata information required should be maintained at client side

#### Downloading an Archive

* Downloading an archive is an asynchronous operation and is the 2 step process
  * Initiate an archive retrieval job
    * When a Job is initiated, a job ID is returned as a part of the response
    * Job is executed asynchronously and the output can be downloaded after the job completes
    * Job can be initiated to download the entire archive or a portion of the archive
  * After the job completes, download the bytes
    * Archive can downloaded as all the bytes or specific byte range to download only a portion of the output
    * Downloading the archive in chunks helps in the event of the download failure, as only that part needs to be downloaded
    * Job completion status can be checked by
      * Check status explicitly \(Not Recommended\)
        * periodically poll the describe job operation request to obtain job information
      * Completion notification
        * An SNS topic can be specified, when the job is initiated or with the vault, to be used to notify job completion

##### About Range Retrievals

* Amazon Glacier allows retrieving an archive either in whole \(default\) or a range, or portion
* Range retrievals need a range to be provided that is megabyte aligned
* Glacier returns checksum in the response which can be used to verify if any errors in download by comparing with checksum computed on the client side
* Specifying a range of bytes can be helpful when:
  * **Control bandwidth costs**
    * Glacier allows retrieval of up to 5 percent of the average monthly storage \(pro-rated daily\) for free each month
    * Scheduling range retrievals can help in two ways.
      * meet the monthly free allowance of 5 percent by spreading out the data requested
      * if the amount of data retrieved doesn’t meet the free allowance percentage, scheduling range retrievals enables reduction of peak retrieval rate, which determines the retrieval fees.
  * **Manage your data downloads**
    * Glacier allows retrieved data to be downloaded for 24 hours after the retrieval request completes
    * Only portions of the archive can be retrieved so that the schedule of downloads can be managed within the given download window.
  * **Retrieve a targeted part of a large archive**
    * Retrieving an archive in range can be useful if an archive is uploaded as an aggregate of multiple individual files, and only few files need to be retrieved

#### Deleting an Archive

* An archive can be deleted from the vault only one at a time
* This operation is idempotent. Deleting an already-deleted archive does not result in an error
* AWS applies pro-rated charge for items that are deleted prior to 90 days, as it is meant for long term storage

#### Updating an Archive

* An existing archive cannot be updated and must be deleted and re-uploaded, which would be assigned a new archive id



