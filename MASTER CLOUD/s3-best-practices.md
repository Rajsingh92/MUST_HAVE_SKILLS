## Performance

### Multiple Concurrent PUTs/GETs

* S3 scales to support very high request rates. If the request rate grows steadily, S3 automatically partitions the buckets as needed to support higher request rates.
* If the typical workload involves only occasional bursts of **100 requests per second and less than 800 requests per second**
  , AWS scales and handle it.
* If the typical workload involves request rate for a bucket to **more than 300 PUT/LIST/DELETE requests per second or more than 800 GET requests per second**, its recommended to open a support case to prepare for the workload and avoid any temporary limits on your request rate.
* S3 best practice guidelines can be applied only if you are routinely **processing 100 or more requests per second**
* Workloads that include a mix of request types
  * If the request workload are typically a mix of GET, PUT, DELETE, or GET Bucket \(list objects\), choosing **appropriate key names **for the objects ensures better performance by providing low-latency access to the S3 index
  * This behavior is driven by how S3 stores key names.
    * S3 maintains an index of object key names in each AWS region.
    * Object keys are stored lexicographically \(UTF-8 binary ordering\) across multiple partitions in the index i.e. S3 stores key names in alphabetical order.
    * Object keys are stored in across multiple partitions in the index and the key name dictates which partition the key is stored in
    * Using a sequential prefix, such as timestamp or an alphabetical sequence, increases the likelihood that S3 will target a specific partition for a large number of keys, overwhelming the I/O capacity of the partition.
  * Introduce **some randomness **in the key name prefixes, the key names, and the I/O load, will be distributed across multiple index partitions.
  * It also ensures scalability regardless of the number of requests sent per second.
* Workloads that are GET-intensive
  * Cloudfront can be used for performance optimization and can help by
    * distributing content with low latency and high data transfer rate.
    * caching the content and thereby reducing the number of direct requests to S3
    * providing multiple endpoints \(Edge locations\) for data availability
    * available in two flavors as Web distribution or RTMP distribution

### PUTs/GETs for Large Objects

* AWS allows Parallelizing the PUTs/GETs request to improve the upload and download performance as well as the ability to recover in case it fails
* For PUTs, **Multipart upload **can help improve the uploads by
  * performing multiple uploads at the same time and maximizing network bandwidth utilization
  * quick recovery from failures, as only the part that failed to upload needs to be re-uploaded
  * ability to pause and resume uploads
  * begin an upload before the Object size is known
* For GETs, **range http header **can help to improve the downloads by
  * allowing the object to be retrieved in parts instead of the whole object
  * quick recovery from failures, as only the part that failed to download needs to be retried.

### List Operations

* Object key names are stored lexicographically in Amazon S3 indexes, making it hard to sort and manipulate the contents of LIST
* S3 maintains a single lexicographically sorted list of indexes
* Build and maintain Secondary Index outside of S3 for e.g. DynamoDB or RDS to store, index and query objects metadata rather then performing operations on S3

## Security

* Use **Versioning**
  * can be used to protect from unintended overwrites and deletions
  * allows the ability to retrieve and restore deleted objects or rollback to previous versions
* Enable additional security by configuring a bucket to enable MFA \(Multi-Factor Authentication\) delete
* **Versioning does not prevent Bucket deletion **and must be backed up, as if accidentally or maliciously deleted the data is lost
* Use Cross Region replication feature to backup data to a different region
* When using VPC with S3, use VPC S3 endpoints as
  * are horizontally scaled, redundant, and highly available VPC components
  * help establish a private connection between VPC and S3 and the traffic never leaves the Amazon network

## Cost

* Optimize S3 storage cost by selecting an appropriate storage class for objects
* Configure appropriate lifecycle management rules to move objects to different storage classes and expire them

## Tracking

* Use Event Notifications to be notified for any put or delete request on the S3 objects
* Use CloudTrail, which helps capture specific API calls made to S3 from the AWS account and delivers the log files to an S3 bucket
* Use CloudWatch to monitor the Amazon S3 buckets, tracking metrics such as object counts and bytes stored and configure appropriate actions



