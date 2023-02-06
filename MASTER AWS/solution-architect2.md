1. **Does S3 provide read-after-write consistency?**

   1. No, not for any region
   2. Yes, but only for certain regions
   3. Yes, but only for certain regions and for new objects
   4. Yes, for all regions

2. **What is the maximum size of a single S3 object?**  
   1. There is no such limit  
   2. 5 TB  
   3. 5 GB  
   4. 100 GB

3. **Is data stored in S3 is always encrypted?**
   1. Yes, S3 always encrypts data for security
   2. No, there is no such feature
   3. Yes, but only when right APIs are called
   4. Yes, but only in Gov Cloud datacenters
4. **What is true for S3 buckets \(select multiple if more than one is true\)?**
   1. Bucket namespace is shared and is global among all AWS users.
   2. Bucket names can contain alpha numeric characters
   3. Bucket are associated with a region, and all data in a bucket resides in that region
   4. Buckets can be transferred from one account to another through API
5. **EBS can always tolerate an Availability Zone failure?**
   1. No, all EBS volume is stored in a single Availability Zone
   2. Yes, EBS volume has multiple copies so it should be fine
   3. Depends on how it is setup
   4. Depends on the Region where EBS volume is initiated
6. **Which of the following Auto scaling CANNOT do \(select multiple if more than one is true\)?**
   1. Start up EC2 instances when CPU utilization is above threshold
   2. Release EC2 instances when CPU utilization is below threshold
   3. Increase the instance size when utilization is above threshold
   4. Add more Relational Database Service \(RDS\) read replicas when utilization is above threshold
7. **Which of the following benefits does adding Multi-AZ deployment in RDS provide \(choose multiple if more than one is true\)?**
   1. MultiAZ deployed database can tolerate an Availability Zone failure
   2. Decrease latencies if app servers accessing database are in multiple Availability zones
   3. Make database access times faster for all app servers
   4. Make database more available during maintenance tasks
8. **What happens to data when an EC2 instance terminates \(select multiple if more than one is true\)?**
   1. For EBS backed AMI, the EBS volume with operation system on it is preserved
   2. For EBS backed AMI, any volume attached other than the OS volume is preserved
   3. All the snapshots of the EBS volume with operating system is preserved
   4. For S3 backed AMI, all the data in the local \(ephemeral\) hard drive is deleted
9. **For an EC2 instance launched in a private subnet in VPC, which of the following are the options for it to be able to connect to the internet \(assume security groups have proper ports open\).**
   1. Simply attach an elastic IP
   2. If there is also a public subnet in the same VPC, an ENI can be attached to the instance with the ip address range of the public subnet
   3. If there is a public subnet in the same VPC with a NAT instance attached to internet gateway, then a route can be configured from the instance to the NAT
   4. There is no way for an instance in private subnet to talk to the internet
10. **When an ELB is setup, what is the best way to route a website’s traffic to it?**
    1. Resolve the ELB name to an ip address  and point the website to that ip address
    2. There is no direct way to do so, Route53 has to be used
    3. Generate a CNAME record for the website pointing to the DNS name of the ELB

**Answers:**

**1\) Answer: C.**

S3’s consistency model is that of eventual consistency. This means that when an object is stored in S3, it is replicated in different datacenters \(availability zones\) in the same region. And it can take a short amount of time before all the data centers have a uniform view of the object \(This time is usually less than a second, but if system is in distress it could take much longer\). Thus in essence, S3 does not provide read-after-write consistency.

But the S3 team has modified the algorithm so as to provide read-after-write consistency for new objects. Which means that if I upload “object-n” for the first time \(lets call it version-1\), I get the opportunity to immediately read it without any consistency issues. This is though not supported for US-East region. Thus S3 support read-after-write consistency for new objects but for all regions except US-East.

**2\) Answer: B.**  
Using multipart upload, a single object in S3 can be upto 5TB in size.

**3\) Answer: C.**  
S3 by default do not encrypt the data stored into its service. But using Server Side Encryption feature, if proper headers are passes \(in REST\), S3 will first encrypt the data and then store that encrypted data.

**4\) Answers: A, B, C**  
Bucket namespace is global, which means that if someone creates a bucket called “pics” nobody else can create a bucket of the same name. Bucket names can contain alphanumeric characters which means we can have a bucket named “cloudthat1234”. And when we create a bucket, we have to select a region for the bucket, and all data stored in that bucket is physically stored in that region only \(although the data can be accessed from anywhere in the world with proper credentials\).

**5\) Answer: A**  
One of the known fallacies of EBS is that all the data of a single volume lives in a single Availability Zone. Thus it cannot withstand Availability zone failures.

**6\) Answer: C, D**  
Auto scaling cannot increase instance size of an EC2 instance. The idea is to be able to scale horizontally, and not vertically. Also D is correct as Auto scaling currently cannot automate RDS instance to do anything.

**7\) Answers: A, D**  
RDS MultiAZ does make database a single AZ failure tolerant, as it has automatic failover feature, where the secondly will become primary and application can keep accessing the database. It also increases availability during maintenance, as maintenance is performed first on secondary, then its made primary and then old-primary is updated.

**8\) Answers: B, C, D**

**9\) Answer: C**

**10\) Answer: C**  
The ip address of an ELB can change, so it’s not advisable to point domain directly at that ip address. Instead use CNAME to map to the ELB DNS name  
—–  
I will also be conducting a bootcamp for this certification in Bangalore and online. If you are interested to join, please [click here and fill out the form](https://cloudthat.in/aws-solution-architect-certification-bootcamp/).

Also more sample questions are coming, so keep checking.. Please share if you liked the post by using the social buttons below.

