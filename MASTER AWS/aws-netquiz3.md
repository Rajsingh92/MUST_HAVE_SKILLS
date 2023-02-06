**Question 1**

You have multiple Amazon EC2 instances running in a cluster across multiple Availability Zones within the same region. What combination of the following should be used to ensure the highest network performance \(packets per second\), lowest latency, and lowest jitter? Choose 3 answers

1. Amazon EC2 placement groups \(would not work for multiple AZs\)
2. **Enhanced networking**
   \(provides network performance, lowest latency\)
3. Amazon PV AMI \(Requires HVM\)
4. **Amazon HVM AMI \(**Requires HVM**\)**
5. Amazon Linux \(Can be on others as well\)
6. **Amazon VPC**
   \(works only in VPC, can’t enable enhanced networking if the instance is in EC2-Classic\)

**Question 2**

What are characteristics of Amazon S3? Choose 2 answers

1. **Objects are directly accessible via a URL**
2. S3 should be used to host a relational database
3. S3 allows you to store objects or virtually unlimited size
4. **S3 allows you to store virtually unlimited amounts of data**
5. S3 offers Provisioned IOPS

**Question 3**

When you put objects in Amazon S3, what is the indication that an object was successfully stored?

1. Each S3 account has a special bucket named\_s3\_logs. Success codes are written to this bucket with a timestamp and checksum.
2. A success code is inserted into the S3 object metadata.
3. **A HTTP 200 result code and MD5 checksum, taken together, indicate that the operation was successful.**
4. Amazon S3 is engineered for 99.999999999% durability. Therefore there is no need to confirm that data was inserted.

**Question 4**

What is the maximum number of S3 buckets available per AWS Account?

1. 100 Per region
2. There is no Limit
3. **100 Per Account**\(Refer[documentation](http://docs.aws.amazon.com/AmazonS3/latest/dev/BucketRestrictions.html)\)
4. 500 Per Account
5. 100 Per IAM User

**Question 5**

Which of the following are valid statements about Amazon S3? Choose 2 answers

1. S3 provides read-after-write consistency for any type of PUT or DELETE.
2. Consistency is not guaranteed for any type of PUT or DELETE.
3. **A successful response to a PUT request only occurs when a complete object is saved**
4. Partially saved objects are immediately readable with a GET after an overwrite PUT.
5. **S3 provides eventual consistency for overwrite PUTS and DELETES**

**Question 6**

A user has an S3 object in the US Standard region with the content “color=red”. The user updates the object with the content as “color=”white”. If the user tries to read the value 1 minute after it was uploaded, what will S3 return?

1. It will return “color=white”
2. It will return “color=red”
3. It will return an error saying that the object was not found
4. **It may return either “color=red” or “color=white” i.e. any of the value**
   \(Eventual Consistency\)

**Question 7**

A user has not enabled versioning on an S3 bucket. What will be the version ID of the object inside that bucket?

1. 0
2. There will be no version attached
3. **Null**
4. Blank

**Question 8**

Which set of Amazon S3 features helps to prevent and recover from accidental data loss?

1. Object lifecycle and service access logging
2. **Object versioning and Multi-factor authentication**
3. Access controls and server-side encryption
4. Website hosting and Amazon S3 policies

**Question 9**

If an object is stored in the Standard S3 storage class and you want to move it to Glacier, what must you do in order to properly migrate it?

1. Change the storage class directly on the object.
2. Delete the object and re-upload it, selecting Glacier as the storage class.
3. None of the above.
4. **Create a lifecycle policy that will migrate it after a minimum of 30 days.**
   \(Any object uploaded to S3 must first be placed into either the Standard, Reduced Redundancy, or Infrequent Access storage class. Once in S3 the only way to move the object to glacier is through a lifecycle policy\)

**Question 10**

Which method can be used to prevent an IP address block from accessing public objects in an S3 bucket?

1. **Create a bucket policy and apply it to the bucket**
2. Create a NACL and attach it to the VPC of the bucket
3. Create an ACL and apply it to all objects in the bucket
4. Modify the IAM policies of any users that would access the bucket

**Question 11**

A system admin is managing buckets, objects and folders with AWS S3. Which of the below mentioned statements is true and should be taken in consideration by the sysadmin?

1. Folders support only ACL
2. Both the object and bucket can have an Access Policy but folder cannot have policy
3. Folders can have a policy
4. **Both the object and bucket can have ACL but folders cannot have ACL**

**Question 12**

A user has created an S3 bucket which is not publicly accessible. The bucket is having thirty objects which are also private. If the user wants to make the objects public, how can he configure this with minimal efforts?

1. User should select all objects from the console and apply a single policy to mark them public
2. User can write a program which programmatically makes all objects public using S3 SDK
3. **Set the AWS bucket policy which marks all objects as public**
4. Make the bucket ACL as public so it will also mark all objects as public

**Question 13**

You need to configure an Amazon S3 bucket to serve static assets for your public-facing web application. Which methods ensure that all objects uploaded to the bucket are set to public read? Choose 2 answers

1. **Set permissions on the object to public read during upload.**
2. Configure the bucket ACL to set all objects to public read.
3. **Configure the bucket policy to set all objects to public read.**
4. Use AWS Identity and Access Management roles to set the bucket to public read.
5. Amazon S3 objects default to public read, so no action is needed.

**Question 14**

A user is trying to configure access with S3. Which of the following options is not possible to provide access to the S3 bucket / object?

1. Define the policy for the IAM user
2. Define the ACL for the object
3. **Define the policy for the object**
4. Define the policy for the bucket

**Question 15**

A bucket owner has allowed another account’s IAM users to upload or access objects in his bucket. The IAM user of Account A is trying to access an object created by the IAM user of account B. What will happen in this scenario?

1. The bucket policy may not be created as S3 will give error due to conflict of Access Rights
2. It is not possible to give permission to multiple IAM users
3. **AWS S3 will verify proper rights given by the owner of Account A, the bucket owner as well as by the IAM user B to the object**
4. It is not possible that the IAM user of one account accesses objects of the other IAM user

**Question 16**

A company is storing data on Amazon Simple Storage Service \(S3\). The company’s security policy mandates that data is encrypted at rest. Which of the following methods can achieve this? Choose 3 answers

1. **Use Amazon S3 server-side encryption with AWS Key Management Service managed keys**
2. **Use Amazon S3 server-side encryption with customer-provided keys**
3. Use Amazon S3 server-side encryption with EC2 key pair.
4. Use Amazon S3 bucket policies to restrict access to the data at rest.
5. **Encrypt the data on the client-side before ingesting to Amazon S3 using their own master key**
6. Use SSL to encrypt the data while in transit to Amazon S3.

**Question 17**

A user has enabled versioning on an S3 bucket. The user is using server side encryption for data at Rest. If the user is supplying his own keys for encryption \(SSE-C\) which of the below mentioned statements is true?

1. The user should use the same encryption key for all versions of the same object
2. **It is possible to have different encryption keys for different versions of the same object**
3. AWS S3 does not allow the user to upload his own keys for server side encryption
4. The SSE-C does not work when versioning is enabled

**Question 18**

A user has enabled versioning on an S3 bucket. The user is using server side encryption for data at rest. If the user is supplying his own keys for encryption \(SSE-C\), what is recommended to the user for the purpose of security?

1. User should not use his own security key as it is not secure
2. Configure S3 to rotate the user’s encryption key at regular intervals
3. Configure S3 to store the user’s keys securely with SSL
4. **Keep rotating the encryption key manually at the client side**

**Question 20**

A system admin is planning to encrypt all objects being uploaded to S3 from an application. The system admin does not want to implement his own encryption algorithm; instead he is planning to use server side encryption by supplying his own key \(SSE-C.. Which parameter is not required while making a call for SSE-C?

1. **x-amz-server-side-encryption-customer-key-AES-256**
2. x-amz-server-side-encryption-customer-key
3. x-amz-server-side-encryption-customer-algorithm
4. x-amz-server-side-encryption-customer-key-MD5

**Question 21**

When uploading an object, what request header can be explicitly specified in a request to Amazon S3 to encrypt object data when saved on the server side?

1. x-amz-storage-class
2. Content-MD5
3. x-amz-security-token
4. **x-amz-server-side-encryption**

**Question 22**

Your company is getting ready to do a major public announcement of a social media site on AWS. The website is running on EC2 instances deployed across multiple Availability Zones with a Multi-AZ RDS MySQL Extra Large DB Instance. The site performs a high number of small reads and writes per second and relies on an eventual consistency model. After comprehensive tests you discover that there is read contention on RDS MySQL. Which are the best approaches to meet these requirements? \(Choose 2 answers\)

1. **Deploy ElastiCache in-memory cache running in each availability zone**
2. Implement sharding to distribute load to multiple RDS MySQL instances \(
   this is only a read contention, the writes work fine\)
3. Increase the RDS MySQL Instance size and Implement provisioned IOPS \(
   not scalable, this is only a read contention, the writes work fine\)
4. **Add an RDS MySQL read replica in each availability zone**

**Question 23**

What would happen to an RDS \(Relational Database Service\) multi-Availability Zone deployment if the primary DB instance fails?

1. IP of the primary DB Instance is switched to the standby DB Instance.
2. A new DB instance is created in the standby availability zone.
3. **The canonical name record \(CNAME\) is changed from primary to standby.**
4. The RDS \(Relational Database Service\) DB instance reboots.

**Question 24**

Is creating a Read Replica of another Read Replica supported?

1. Only in certain regions
2. **Only with MySQL based RDS**
3. Only for Oracle RDS types
4. No

**Question 25**

Read Replicas require a transactional storage engine and are only supported for the \_\_\_\_\_\_\_\_\_ storage engine

1. OracleISAM
2. MSSQLDB
3. **InnoDB**
4. MyISAM

**Question 26**

Will I be alerted when automatic failover occurs?

1. **Only if SNS configured**
2. No
3. Yes
4. Only if Cloudwatch configured

**Question 27**

What is the charge for the data transfer incurred in replicating data between your primary and standby?

1. **No charge. It is free.**
2. Double the standard data transfer charge
3. Same as the standard data transfer charge
4. Half of the standard data transfer charge

**Question 28**

A user has created an ELB with three instances. How many security groups will ELB create by default?

1. 3
2. 5
3. **2 **\(One for ELB to allow inbound and Outbound to listener and health check port of instances and One for the Instances to allow inbound from ELB\)
4. 1

**Question 29**

A user has hosted a website on AWS and uses ELB to load balance the multiple instances. The user application does not have any cookie management. How can the user bind the session of the requestor with a particular instance?

1. Bind the IP address with a sticky cookie
2. Create a cookie at the application level to set at ELB
3. Use session synchronization with ELB
4. **Let ELB generate a cookie for a specified duration**

**Question 30**

Which of the following statements are true about Amazon Route 53 resource records? Choose 2 answers

1. **An Alias record can map one DNS name to another Amazon Route 53 DNS name.**
2. A CNAME record can be created for your zone apex.
3. **An Amazon Route 53 CNAME record can point to any DNS record hosted anywhere.**
4. TTL can be set for an Alias record in Amazon Route 53.
5. An Amazon Route 53 Alias record can point to any DNS record hosted anywhere.

**Question 31**

Which of the following are valid arguments for an SNS Publish request? Choose 3 answers.

1. **TopicAm**
2. **Subject**
3. Destination
4. Format
5. **Message**
6. Language

**Question 32**

An organization has setup Auto Scaling with ELB. Due to some manual error, one of the instances got rebooted. Thus, it failed the Auto Scaling health check. Auto Scaling has marked it for replacement. How can the system admin ensure that the instance does not get terminated?

1. Update the Auto Scaling group to ignore the instance reboot event
2. It is not possible to change the status once it is marked for replacement
3. Manually add that instance to the Auto Scaling group after reboot to avoid replacement
4. **Change the health of the instance to healthy using the Auto Scaling commands**

**Question 33**  
A user has configured Auto Scaling with the minimum capacity as 2 and the desired capacity as 2. The user is trying to terminate one of the existing instance with the command: as-terminate-instance-in-auto-scaling-group &lt;Instance ID&gt;  –decrement-desired-capacity. What will Auto Scaling do in this scenario?  
   1. Terminates the instance and does not launch a new instance  
   2. Terminates the instance and updates the desired capacity to 1  
   3. Terminates the instance and updates the desired capacity & minimum size to 1  
   4. **Throws an error**

**Question 34**

In reviewing the auto scaling events for your application you notice that your application is scaling up and down multiple times in the same hour. What design choice could you make to optimize for the cost while preserving elasticity? Choose 2 answers.

1. **Modify the Amazon CloudWatch alarm period that triggers your auto scaling scale down policy.**
2. Modify the Auto scaling group termination policy to terminate the oldest instance first.
3. Modify the Auto scaling policy to use scheduled scaling actions.
4. **Modify the Auto scaling group cool down timers.**
5. Modify the Auto scaling group termination policy to terminate newest instance first.







