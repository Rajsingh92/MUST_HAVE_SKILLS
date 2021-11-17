# AWS S3 Subresources

* Amazon S3 Subresources provides support to store, and manage the bucket configuration information
* S3 subresources only exist in the context of a specific bucket or object
* S3 defines a set of subresources associated with buckets and objects.
* S3 Subresources are subordinates to objects; that is, they do not exist on their own, they are always associated with some other entity, such as an object or a bucket
* S3 supports various options to configure a bucket f _or e.g., bucket can be configured for website hosting, configuration added to manage lifecycle of objects in the bucket, and to log all access to the bucket._

## Bucket Subresources

### Object Lifecycle

Refer to My Blog Post about [S3 Object Lifecycle Management](http://jayendrapatil.com/aws-s3-object-lifecycle-management/)

### Static Website hosting

* S3 can be used for Static Website hosting with Client side scripts.
* S3 does not support server-side scripting
* S3, in conjunction with Route 53, supports hosting a website at the root domain which can point to the S3 website endpoint
* S3 website endpoints do not support https.
* For S3 website hosting the content should be made publicly readable which can be provided using a bucket policy or an ACL on an object
* User can configure the index, error document as well as configure the conditional routing of on object name
* Bucket policy applies only to objects owned by the bucket owner. If your bucket contains objects not owned by the bucket owner, then public READ permission on those objects should be granted using the object ACL.
* Requester Pays buckets or DevPay buckets do not allow access through the website endpoint. Any request to such a bucket will receive a 403 -Access Denied response

### Versioning

Refer to My Blog Post about [S3 Object Versioning](http://jayendrapatil.com/aws-s3-object-versioning/)

### Policy & Access Control List \(ACL\)

Refer to My Blog Post about [S3 Permissions](http://jayendrapatil.com/aws-s3-permisions/)

### CORS \(Cross Origin Resource Sharing\)

* All browsers implement the Same-Origin policy, for security reasons, where the web page from an domain can only request resources from the same domain.
* CORS allow client web applications loaded in one domain access to the restricted resources to be requested from another domain
* With CORS support in S3 allows cross-origin access to S3 resources
* CORS configuration rules identify the origins allowed to access the bucket, the operations \(HTTP methods\) that would be supported for each origin, and other operation-specific information

### Logging

* Logging, disabled by default, enables tracking access requests to S3 bucket
* Each access log record provides details about a single access request, such as the requester, bucket name, request time, request action, response status, and error code, if any.
* Access log information can be useful in security and access audits and also help learn about the customer base and understand the S3 bill
* S3 periodically collects access log records, consolidates the records in log files, and then uploads log files to a target bucket as log objects.
* If logging is enabled on multiple source buckets with same target bucket, the target bucket will have access logs for all those source buckets, but each log object will report access log records for a specific source bucket

### Tagging

* S3 provides the tagging subresource to store and manage tags on a bucket
* Cost allocation tags can be added to the bucket to categorize and track AWS costs
* AWS can generate a cost allocation report with usage and costs aggregated by the tags applied to the buckets

### Location

* When you create a bucket, AWS region needs to be specified where the S3 bucket will be created
* S3 stores this information in the location subresource and provides an API for retrieving this information

### Notification

* S3 notification feature enables notifications to be triggered when certain events happen in your bucket
* Notifications are enabled at Bucket level
* Notifications can be configured to be filtered by the prefix and suffix of the key name of objects. However, filtering rules cannot be defined with  overlapping prefixes, overlapping suffixes, or prefix and suffix overlapping
* S3 can publish the following events
  * New Objects created event
    * Can be enabled for PUT, POST or COPY operations
    * You will not receive event notifications from failed operations
  * Object Removal event
    * Can public delete events for object deletion, version object deletion or insertion of delete marker
    * You will not receive event notifications from automatic deletes from lifecycle policies or from failed operations.
  * Reduced Redundancy Storage \(RRS\) object lost event
    * Can be used to reproduce/recreate the Object
* S3 can publish events to the following destination
  * SNS topic
  * SQS queue
  * AWS Lambda
* For S3 to be able to publish events to the destination, S3 principal should be granted necessary permissions

### Cross Region Replication

* Cross-region replication is a bucket-level feature that enables automatic, asynchronous copying of objects across buckets in different AWS regions
* S3 can replicate all or a subset of objects with specific key name prefixes
* S3 encrypts all data in transit across AWS regions using SSL
* Object replicas in the destination bucket are exact replicas of the objects in the source bucket with the same key names and the same metadata.
* Cross Region Replication can be useful for the following scenarios :-
  * **Compliance requirement**
    to have data backed up across regions
  * **Minimize latency**
    to allow users across geography to access objects
  * **Operational reasons**
    compute clusters in two different regions that analyze the same set of objects
* Requirements
  * source and destination buckets must be versioning-enabled
  * source and destination buckets must be in different AWS regions
  * objects can be replicated from a source bucket to only one destination bucket
  * S3 must have permission to replicate objects from that source bucket to the destination bucket on your behalf.
  * If the source bucket owner also owns the object, the bucket owner has full permissions to replicate the object. If not, the source bucket owner must have permission for the S3 actions s3:GetObjectVersion and s3:GetObjectVersionACL to read the object and object ACL
  * Setting up cross-region replication in a cross-account scenario \(where the source and destination buckets are owned by different AWS accounts\), the source bucket owner must have permission to replicate objects in the destination bucket.
* Replicated & Not Replicated
  * Any new objects created after you add a replication configuration **are **replicated
  * S3 **does not **retroactively replicate objects that existed before you added replication configuration.
  * Only Objects created with SSE-S3 **are **replicated using server-side encryption using the S3-managed encryption key.
  * Objects created with server-side encryption using either customer-provided \(SSE-C\) or
  * Objects created with server-side encryption using AWS KMS–managed encryption \(SSE-KMS\) keys **are not replicated, by default. It requires **[**additional handling**](https://docs.aws.amazon.com/AmazonS3/latest/dev/crr-replication-config-for-kms-objects.html)**.**
  * S3 replicates **only **objects in the source bucket for which the bucket owner has permission to read objects and read ACLs
  * S3 **does not **replicate objects in the source bucket for which the bucket owner does not have permissions.
  * Any object ACL updates **are **replicated, although there can be some delay before Amazon S3 can bring the two in sync. This applies only to objects created after you add a replication configuration to the bucket.
  * Updates to bucket-level S3 subresources **are not **replicated, allowing different bucket configurations on the source and destination buckets
  * Only customer actions **are **replicated  & actions performed by lifecycle configuration **are not **replicated
  * Objects in the source bucket that are replicas, created by another cross-region replication, **are not **replicated.

### Requester Pays

* By default, buckets are owned by the AWS account that created it \(the bucket owner\) and the AWS account pays for storage costs, downloads and data transfer charges associated with the bucket.
* Using Requester Pays subresource :-
  * Bucket owner specifies that the requester requesting the download will be charged for the download
  * However, the bucket owner still pays the storage costs
* Enabling Requester Pays on a bucket
  * disables anonymous access to that bucket
  * does not support BitTorrent
  * does not support SOAP requests
  * cannot be enabled for end user logging bucket

## Object Subresources

### Torrent

* Default distribution mechanism for S3 data is via client/server download
* Bucket owner bears the cost of Storage as well as the request and transfer charges which can increase linearly for an popular object
* S3 also supports the BitTorrent protocol
  * BitTorrent is an open source Internet distribution protocol
  * BitTorrent addresses this problem by recruiting the very clients that are downloading the object as distributors themselves
  * S3 bandwidth rates are inexpensive, but BitTorrent allows developers to further save on bandwidth costs for a popular piece of data by letting users download from Amazon and other users simultaneously
* Benefit for publisher is that for large, popular files the amount of data actually supplied by S3 can be substantially lower than what it would have been serving the same clients via client/server download
* Any object in S3 that is publicly available and can be read anonymously can be downloaded via BitTorrent
* torrent file can be retrieved for any publicly available object by simply adding a “?torrent” query string parameter at the end of the REST GET request for the object
* Generating the .torrent for an object takes time proportional to the size of that object, so its recommended to make a first torrent request yourself to generate the file so that subsequent requests are faster
* Torrent are enabled only for objects that are less than 5 GB in size.
* Torrent subresource can only be retrieve, and cannot be created, updated or deleted

### Object ACL

Refer to My Blog Post about[S3 Permissions](http://jayendrapatil.com/aws-s3-permisions/)

