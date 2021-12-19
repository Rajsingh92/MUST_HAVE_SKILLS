Amazon S3 storage classes are designed to sustain the concurrent loss of data in one or two facilities

* S3 storage classes allows lifecycle management for automatic migration of objects for cost savings
* S3 storage classes support SSL encryption of data in transit and data encryption at rest
* S3 also regularly verifies the integrity of your data using checksums and provides auto healing capability

![](https://i1.wp.com/jayendrapatil.com/wp-content/uploads/2016/03/screen-shot-2016-03-29-at-8-16-24-am.png?resize=656%2C208 "AWS S3 Storage Classes Comparision")

## Standard

* Storage class is ideal for performance-sensitive use cases and frequently accessed data and is designed to sustain the loss of data in a two facilities
* STANDARD is the default storage class, if none specified during upload
* Low latency and high throughput performance
* Designed for durability of 99.999999999% of objects
* Designed for 99.99% availability over a given year
* Backed with the [Amazon S3 Service Level Agreement](https://aws.amazon.com/s3/sla/) for availability.

## Standard IA

* S3 STANDARD\_IA \(Infrequent Access\) storage class is optimized for long-lived and less frequently accessed data
  _for e.g. backups and older data where access is limited, but the use case still demands high performance_
* STANDARD\_IA is designed to sustain the loss of data in a two facilities
* STANDARD\_IA objects are available for real-time access.
* STANDARD\_IA storage class is suitable for larger objects greater than 128 KB \(smaller objects are charged for 128KB only\) kept for at least 30 days.
* Same low latency and high throughput performance of Standard
* Designed for durability of 99.999999999% of objects
* Designed for 99.9% availability over a given year
* Backed with the [Amazon S3 Service Level Agreement](https://aws.amazon.com/s3/sla/) for availability

## Reduced Redundancy Storage – RRS

* Reduced Redundancy Storage \(RRS\) storage class is designed for noncritical, reproducible data stored at lower levels of redundancy than the STANDARD storage class, which reduces storage costs
* Designed for durability of 99.99% of objects
* Designed for 99.99% availability over a given year
* Lower level of redundancy results in less durability and availability
* RRS stores objects on multiple devices across multiple facilities, providing 400 times the durability of a typical disk drive,
* RRS does not replicate objects as many times as S3 standard storage and is designed to sustain the loss of data in a single facility.
* If an RRS object is lost, S3 returns a 405 error on requests made to that object
* S3 can send an event notification, configured on the bucket, to alert a user or start a workflow when it detects that an RRS object is lost which can be used to replace the lost object

## Glacier

* GLACIER storage class is suitable for archiving data where data access is infrequent and retrieval time of several \(3-5\) hours  is acceptable.
* GLACIER storage class uses the very low-cost Amazon Glacier storage service, but the objects in this storage class are still managed through S3
* Designed for durability of 99.999999999% of objects
* GLACIER cannot be specified as the storage class at the object creation time but has to be transitioned fromSTANDARD, RRS, or STANDARD\_IA to GLACIER storage class using lifecycle management.
* For accessing GLACIER objects,
  * object must be restored which can taken anywhere between 3-5 hours
  * objects are only available for the time period \(number of days\) specified during the restoration request
  * object’s storage class remains GLACIER
  * charges are levied for both the archive \(GLACIER rate\) and the copy restored temporarily \(RRS rate\)
* Vault Lock feature enforces compliance via a lockable policy



