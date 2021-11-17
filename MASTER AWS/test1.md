1, An IAM user is trying to perform an action on an object belonging to some other root account’s bucket. Which of the below mentioned options will AWS S3 not verify?

1. [ ] The object owner has provided access to the IAM user

2. [x] Permission provided by the parent of the IAM user on the bucket

3. [ ] Permission provided by the bucket owner to the IAM user

4. [ ] Permission provided by the parent of the IAM user

> If the IAM user is trying to perform some action on the object belonging to another AWS user’s bucket, S3 will verify whether the owner of the IAM user has given sufficient permission to him. It also verifies the policy for the bucket as well as the policy defined by the object owner.[http://docs.aws.amazon.com/AmazonS3/latest/dev/access-control-auth-workflow-object-operation.html](http://docs.aws.amazon.com/AmazonS3/latest/dev/access-control-auth-workflow-object-operation.html)

2, Select the correct set of options. These are the initial settings for the default security group:

1. [ ] Allow all inbound traffic, Allow no outbound traffic and Allow instances associated with this security group to talk to each other.
2. [ ] Allow all inbound traffic, Allow all outbound traffic and Does NOT allow instances associated with this security group to talk to each other.
3. [x] Allow no inbound traffic, Allow all outbound traffic and Allow instances associated with this security group to talk to each other.
4. [ ] Allow no inbound traffic, Allow all outbound traffic and Does NOT allow instances associated with this security group to talk to each other.

> > Refer to [http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-network-security.html\#default-security-group](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-network-security.html#default-security-group)

3, Placement Groups: enables applications to participate in a low-latency, 10 Gbps network. Which of below statements is false.

1. [ ] Not all of the instance types that can be launched into a placement group.

2. [x] You can move an existing instance into a placement group by specify parameter of placement group.

3. [ ] A placement group can't span multiple Availability Zones.

4. [ ] A placement group can span peered VPCs.

> > Refer to [https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/placement-groups.html](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/placement-groups.html)

4, What about below is false for AWS SLA

1. [ ] EC2 availability is guarantee to 99.95%.
2. [x] S3 availability is guarantee to 99.95%.
3. [ ] EBS availability is guarantee to 99.95%.
4. [ ] RDS multi-AZ is guarantee to 99.95%.
   S3 SLA is 99.9%. Refer to [http://aws.amazon.com/s3/sla/](http://aws.amazon.com/s3/sla/)

5, About the charge of Elastic IP Address, which of the following is true?

1. [ ] You are charged for each Elastic IP addressed.
2. [ ] Elastic IP addresses can always be used with no charge.
3. [ ] You can have 5 Elastic IP addresses per region with no charge.
4. [x] You can have one Elastic IP \(EIP\) address associated with a running instance at no charge.
   > > Refer to [http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/elastic-ip-addresses-eip.html](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/elastic-ip-addresses-eip.html)

6, You have assigned one Elastic IP to your EC2 instance. Now we need to restart the VM without EIP changed. Which of below you should not do?

1. [x] Reboot and stop/start both works.
2. [ ] When the instance is in VPC public subnets, stop/start works.
3. [ ] When the instance is in VPC private subnet, stop/start works.
4. [ ] Reboot the instance.

   > > Refer to [http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-instance-lifecycle.html\#lifecycle-differences](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-instance-lifecycle.html#lifecycle-differences)

   7, EC2 role

5. [ ] Setup an IAM group with restricted AWS API access and put the instance in the group at launch.

6. [ ] Pass access AWS credentials in the User Data field when the instance is launched.
7. [ ] Setup an IAM user for the instance to restrict access to AWS API and assign it at launch.
8. [x] Launch an instance with an AWS Identity and Aceess Management \(IAM\) role to restrict AWS API access for the instance.
   > > Refer to [http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/iam-roles-for-amazon-ec2.html](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/iam-roles-for-amazon-ec2.html)

8, Which of the below mentioned steps will not be performed while creating the AMI of instance stored-backend?

1. [ ] Upload the bundled volume.
2. [x] Define the AMI launch permissions.
3. [ ] Bundle the volume.
4. [ ] Register the AMI.

   > > Refer to [http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/creating-an-ami-instance-store.html](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/creating-an-ami-instance-store.html)

   9, The user just started an instance at 3 PM. Between 3 PM to 5 PM, he stopped and started the instance twice. During the same period, he has run the linux reboot command by ssh once and triggered reboot from AWS console once. For how many instance hours will AWS charge this user?

   1. [ ] 3
   2. [x] 4
   3. [ ] 5
   4. [ ] 2

   > > Refer to [http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/Stop\_Start.html](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/Stop_Start.html)

   10, Which service or feature provides the fastest method of getting the  
   data into Amazon Glacier?  
   You are working with a customer who has 10 TB of archival data that they want to migrate to Amazon Glacier. The customer has a 1Mbps connection to the Internet. Which service or feature provides the fastest method of getting the data into Amazon Glacier?  
   A. Amazon Glacier multipart upload  
   B. AWS Storage Gateway  
   C. VM Import/Export  
   D. AWS Import/Export

Answer: D, mail the storage to AWS storage team to help import data.





**1. You are planning to build a fleet of EBS-optimized EC2 instances for your new application. Due to security compliance, your organization wants you to encrypt root volume which is used to boot the instances. How can this be achieved?**

**A. Select Encryption option for the root EBS volume while launching EC2 instance.**

**B. Once the EC2 instances are launched, encrypt the root volume using AWS KMS Master Key.**

**C. Root volumes cannot be encrypted. Add another EBS volume with encryption option selected during launch. Once EC2 instances are launched, make encrypted EBS volume as root volume through the console.**

**D. Launch an unencrypted EC2 instance and create a snapshot of the root volume. Make a copy of the snapshot with the encryption option selected and CreateImage using encrypted snapshot. Use this image to launch EC2 instances.**

**Answer:**D

When launching an EC2 instance, the EBS volume for root cannot be encrypted.

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-EC2-1.png "AWS EC2")You can launch the instance with unencrypted root volume and create a snapshot of the root volume. Once the snapshot is created, you can copy the snapshot where you can make the new snapshot encrypted.

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-EC2-2.png "AWS EC2")

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-EC2-3.png "AWS EC2")

[https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/AMIEncryption.html\#AMIEncryption\_](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/AMIEncryption.html#AMIEncryption_)

**2. Organization XYZ is planning to build an online chat application for their enterprise level collaboration for their employees across the world. They are looking for a single digit latency fully managed database to store and retrieve conversations. What would AWS Database service you recommend?**

**A. AWS DynamoDB**

**B. AWS RDS**

**C. AWS Redshift**

**D. AWS Aurora**

**Answer:**A

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-Database-1.png "AWS Database")

[https://aws.amazon.com/dynamodb/\#whentousedynamodb](https://aws.amazon.com/dynamodb/#whentousedynamodb)

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-Database-2.png "AWS Database")

[https://aws.amazon.com/about-aws/whats-new/2015/07/amazon-dynamodb-available-now-cross-region-replication-triggers-and-streams/](https://aws.amazon.com/about-aws/whats-new/2015/07/amazon-dynamodb-available-now-cross-region-replication-triggers-and-streams/)

**3. When creating an AWS CloudFront distribution, which of the following is not an origin?**

**A. Elastic Load Balancer**

**B. AWS S3 bucket**

**C. AWS MediaPackage channel endpoint**

**D. AWS Lambda**

**Answer:**D

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-CloudFront-1-.png "AWS CloudFront")

Explanation: AWS Lambda is not supported directly as the CloudFront origin. However, Lambda can be invoked through API Gateway which can be set as the origin for AWS CloudFront.

[https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/Introduction.html](https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/Introduction.html)

**4. Which of the following statements are true with respect to VPC? \(choose multiple\)**

**A. A subnet can have multiple route tables associated with it.**

**B. A network ACL can be associated with multiple subnets.**

**C. A route with target “local” on the route table can be edited to restrict traffic within VPC.**

**D. Subnet’s IP CIDR block can be same as the VPC CIDR block.**

**Answer:**B, D

Option A is not correct. A subnet can have only one route table associated with it.

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-VPC-1.png "AWS VPC")

Option B is correct.

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-VPC-2.png "AWS VPC")

Option C is not correct.

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-VPC-3.png "AWS VPC")

Option D is correct.

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-VPC-4.png "AWS VPC")

**5. Organization ABC has a customer base in US and Australia that would be downloading 10s of GBs files from your application. For them to have a better download experience, they decided to use AWS S3 bucket with cross-region replication with the US as source and Australia as the destination. They are using existing unused S3 buckets and had setup cross-region replication successfully. However, when files uploaded to US bucket, they are not being replicated to Australia bucket. What could be the reason?**

**A. Versioning is not enabled on the source and destination buckets.**

**B. Encryption is not enabled on the source and destination buckets.**

**C. Source bucket has a policy with DENY and role used for replication is not excluded from DENY.**

**D. Destination bucket’s default CORS policy does not have source bucket added as the origin.**

**Answer:**C

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-S3-1.png "AWS S3")

When you have a bucket policy which has explicit DENY, you must exclude all IAM resources which need to access the bucket.

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-S3-2.png "AWS S3")

[https://aws.amazon.com/blogs/security/how-to-create-a-policy-that-whitelists-access-to-sensitive-amazon-s3-buckets/](https://aws.amazon.com/blogs/security/how-to-create-a-policy-that-whitelists-access-to-sensitive-amazon-s3-buckets/)

For option A, Cross region replication cannot be enabled without enabling versioning. The question states that cross-region replication has been successfully enabled. So this option is not correct.

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-S3-3.png "AWS S3")

**6. Which of the following is not a category in AWS Trusted Advisor service checks?**

**A. Cost Optimization**

**B. Fault Tolerance**

**C. Service Limits**

**D. Network Optimization**

**Answer:**D

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-Trusted-Advisor-1.png "AWS TrustedAdvisor")

[https://aws.amazon.com/premiumsupport/trustedadvisor/](https://aws.amazon.com/premiumsupport/trustedadvisor/)

**7. Your organization is building a collaboration platform for which they chose AWS EC2 for web and application servers and MySQL RDS instance as the database. Due to the nature of the traffic to the application, they would like to increase the number of connections to RDS instance. How can this be achieved?**

**A. Login to RDS instance and modify database config file under /etc/mysql/my.cnf**

**B. Create a new parameter group, attach it to DB instance and change the setting.**

**C. Create a new option group, attach it to DB instance and change the setting.**

**D. Modify setting in default options group attached to DB instance.**

**Answer:**B

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-RDS-1.png "AWS RDS")

[https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER\_WorkingWithParamGroups](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_WorkingWithParamGroups)

**8. You will be launching and terminating EC2 instances on need basis for your workloads. You need to run some shell scripts and perform certain checks connecting to AWS S3 bucket when the instance is getting launched. Which of the following options will allow performing any tasks during launch? \(choose multiple\)**

**A. Use Instance user data for shell scripts.**

**B. Use Instance metadata for shell scripts.**

**C. Use AutoScaling Group lifecycle hooks and trigger AWS Lambda function through CloudWatch events.**

**D. Use Placement Groups and set “InstanceLaunch” state to trigger AWS Lambda functions.**

**Answer:**A, C

Option A is correct.

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-EC2-Autoscaling-1.png "AWS EC2 Autoscaling")

Option C is correct.

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-EC2-Autoscaling-2.png "AWS EC2 Autoscaling")

[https://docs.aws.amazon.com/autoscaling/ec2/userguide/lifecycle-hooks.html\#preparing-for-notification](https://docs.aws.amazon.com/autoscaling/ec2/userguide/lifecycle-hooks.html#preparing-for-notification)

**9. Your organization has an AWS setup and planning to build Single Sign-On for users to authenticate with on-premise Microsoft Active Directory Federation Services \(ADFS\) and let users log in to AWS console using AWS STS Enterprise Identity Federation. Which of the following service do you need to call from AWS STS service after you authenticate with your on-premise?**

**A. AssumeRoleWithSAML**

**B. GetFederationToken**

**C. AssumeRoleWithWebIdentity**

**D. GetCallerIdentity**

**Answer:**A

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-IAM-CTS-1.png "AWS ITM")

[https://docs.aws.amazon.com/STS/latest/APIReference/API\_AssumeRoleWithSAML.html](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRoleWithSAML.html)

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-IAM-CTS-2.png "AWS ITM")

[https://docs.aws.amazon.com/IAM/latest/UserGuide/id\_roles\_providers\_saml.html](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_providers_saml.html)

**10. How many VPCs can an Internet Gateway be attached to at any given time?**

**A. 2**

**B. 5**

**C. 1**

**D. By default 1. But it can be attached to any VPC peered with its belonging VPC.**

**Answer:**C

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-VPC-5.png "AWS VPC")

[https://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/amazon-vpc-limits.html\#vpc-limits-gateways](https://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/amazon-vpc-limits.html#vpc-limits-gateways)

At any given time, an Internet Gateway can be attached to only one VPC. It can be detached from the VPC and be used for another VPC.

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-VPC-6.png "AWS VPC")

**11. Your organization was planning to develop a web application on AWS EC2. Application admin was tasked to perform AWS setup required to spin EC2 instance inside an existing private VPC. He/she has created a subnet and wants to ensure no other subnets in the VPC can communicate with your subnet except for the specific IP address. So he/she created a new route table and associated with the new subnet. When he/she was trying to delete the route with the target as local, there is no option to delete the route. What could have caused this behavior?**

**A. Policy attached to IAM user does not have access to remove routes.**

**B. A route with the target as local cannot be deleted.**

**C. You cannot add/delete routes when associated with the subnet. Remove associated, add/delete routes and associate again with the subnet.**

**D. There must be at least one route on the route table. Add a new route to enable delete option on existing routes.**

**Answer:**B

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-VPC-1-1.png "AWS VPC")

[https://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC\_Route\_Tables.html\#RouteTa](https://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_Route_Tables.html#RouteTa)

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-VPC-2-1.png "AWS VPC")

**12. Which of the following are not backup and restore solutions provided by AWS? \(choose multiple\)**

**A. AWS Elastic Block Store**

**B. AWS Storage Gateway**

**C. AWS Elastic Beanstalk**

**D. AWS Database Migration Hub**

**E. AWS CloudFormation**

**Answer:**C, E

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-Backup-Recovery-1.png "AWS Backup and Recovery")

Option A is snapshot based data backup solution.

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-Backup-Recovery-2.png "AWS Backup and Recovery")

Option B, AWS Storage Gateway provides multiple solutions for backup & recovery.

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-Backup-Recovery-3.png "AWS Backup and Recovery")

Option D can be used as a Database backup solution.

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-Backup-Recovery-4.png "AWS Backup and Recovery")

**13. Organization ABC has a requirement to send emails to multiple users from their application deployed on EC2 instance in a private VPC. Email receivers will not be IAM users. You have decided to use AWS Simple Email Service and configured from email address. You are using AWS SES API to send emails from your EC2 instance to multiple users. However, email sending getting failed. Which of the following options could be the reason?**

**A. You have not created VPC endpoint for SES service and configured in the route table.**

**B. AWS SES is in sandbox mode by default which can send emails only to verified email addresses.**

**C. IAM user of configured from email address does not have access AWS SES to send emails.**

**D. AWS SES cannot send emails to addresses which are not configured as IAM users. You have to use the SMTP service provided by AWS.**

**Answer:**B

Amazon SES is an email platform that provides an easy, cost-effective way for you to send and receive email using your own email addresses and domains.

For example, you can send marketing emails such as special offers, transactional emails such as order confirmations, and other types of correspondence such as newsletters. When you use Amazon SES to receive mail, you can develop software solutions such as email autoresponders, email unsubscribe systems and applications that generate customer support tickets from incoming emails.

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-Simple-Email-Service-1.png "AWS Simple Email Service")

[https://docs.aws.amazon.com/ses/latest/DeveloperGuide/limits.html](https://docs.aws.amazon.com/ses/latest/DeveloperGuide/limits.html)

[https://docs.aws.amazon.com/ses/latest/DeveloperGuide/request-production-access.html](https://docs.aws.amazon.com/ses/latest/DeveloperGuide/request-production-access.html)

**14. You have configured AWS S3 event notification to send a message to AWS Simple Queue Service whenever an object is deleted. You are performing ReceiveMessage API operation on the AWS SQS queue to receive the S3 delete object message onto AWS EC2 instance. For any successful message operations, you are deleting them from the queue. For failed operations, you are not deleting the messages. You have developed a retry mechanism which reruns the application every 5 minutes for failed RecieveMessage operations. However, you are not receiving the messages again during the rerun. What could have caused this?**

**A. AWS SQS deletes the message after it has been read through ReceiveMessage API**

**B. You are using Long Polling which does not guarantee message delivery.**

**C. Failed RecieveMessage queue messages are automatically sent to Dead Letter Queues. You need to RecieveMessage from Dead Letter Queue for failed retries.**

**D. Visibility Timeout on the SQS queue is set to 10 minutes.**

**Answer:**D When a consumer receives and processes a message from a queue, the message remains in the queue. Amazon SQS doesn’t automatically delete the message. Because Amazon SQS is a distributed system, there’s no guarantee that the consumer actually receives the message \(for example, due to a connectivity issue, or due to an issue in the consumer application\). Thus, the consumer must delete the message from the queue after receiving and processing it.

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-SQS-1.png "AWS SQS")

[https://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/sqs-visibility-timeout.html](https://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/sqs-visibility-timeout.html)

**15. You had set up an internal HTTP\(S\) Elastic Load Balancer to route requests to two EC2 instances inside a private VPC. However, one of the target EC2 instance is showing Unhealthy status. Which of the following options could not be a reason for this?**

**A. Port 80/443 is not allowed on EC2 instance’s Security Group from the load balancer.**

**B. An EC2 instance is in different availability zones than load balancer.**

**C. The ping path does not exist on the EC2 instance.**

**D. The target did not return a successful response code**

**Answer:**B

If a target is taking longer than expected to enter the InService state, it might be failing health checks. Your target is not in service until it passes one health check.

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-ELB-1.png "AWS Elastic Load Balancer")

[https://docs.aws.amazon.com/elasticloadbalancing/latest/application/load-balancer-troubleshooting.html\#target-not-inservice](https://docs.aws.amazon.com/elasticloadbalancing/latest/application/load-balancer-troubleshooting.html#target-not-inservice)

[https://docs.aws.amazon.com/elasticloadbalancing/latest/application/target-group-health-checks.html](https://docs.aws.amazon.com/elasticloadbalancing/latest/application/target-group-health-checks.html)

**16. Your organization has an existing VPC setup and has a requirement to route any traffic going from VPC to AWS S3 bucket through AWS internal network. So they have created VPC endpoint for S3 and configured to allow traffic for S3 buckets. The application you are developing involves sending traffic to AWS S3 bucket from VPC for which you planned to use a similar approach. You have created a new route table, added route to VPC endpoint and associated route table with your new subnet. However, when you are trying to send a request from EC2 to S3 bucket using AWS CLI, the request is getting failed with 403 access denied errors. What could be causing the failure?**

**A. AWS S3 bucket is in the different region than your VPC.**

**B. EC2 security group outbound rules not allowing traffic to S3 prefix list.**

**C. VPC endpoint might have a restrictive policy and does not contain the new S3 bucket.**

**D. S3 bucket CORS configuration does not have EC2 instance as the origin.**

**Answer:**C

Option A is not correct. The question states “403 access denied”. If the S3 bucket is in a different region than VPC, the request looks for a route with NAT Gateway or Internet Gateway. If exists, the request goes through the internet to S3. If does not exist, the request gets failed with connection refused or connection timed out. Not with an error “403 access denied”.

Option B is not correct. Same as above, when the security group does not allow traffic, the failure cause will be 403 access denied.

Option C is correct.

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-S3-and-VPC-1.png "AWS S3 and VPC ")

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-S3-and-VPC-2.png "AWS S3 and VPC")

Option D is not correct.

Cross-origin resource sharing \(CORS\) defines a way for client web applications that are loaded in one domain to interact with resources in a different domain. With CORS support, you can build rich client-side web applications with Amazon S3 and selectively allow cross-origin access to your Amazon S3 resources.

In this case, the request is not coming from a web client.

**17. You have launched an RDS instance with MySQL database with default configuration for your file sharing application to store all the transactional information. Due to security compliance, your organization wants to encrypt all the databases and storage on the cloud. They approached you to perform this activity on your MySQL RDS database. How can you achieve this?**

**A. Copy snapshot from latest snapshot of your RDS instance, select encryption during copy and restore a new DB instance from the newly encrypted snapshot.**

**B. Stop the RDS instance, modify and select encryption option. Start the RDS instance, it may take a while to start RDS instance as existing data is getting encrypted.**

**C. Create a case with AWS support to enable encryption for your RDS instance.**

**D. AWS RDS is a managed service and the data at rest in all RDS instances are encrypted by default.**

**Answer:**A

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-RDS-1-1.png "AWS RDS")

[https://aws.amazon.com/blogs/aws/amazon-rds-update-share-encrypted-snapshots-encrypt-existing-instances/](https://aws.amazon.com/blogs/aws/amazon-rds-update-share-encrypted-snapshots-encrypt-existing-instances/)

**18. Which of the following is an AWS component which consumes resources from your VPC?**

**A. Internet Gateway**

**B. Gateway VPC Endpoints**

**C. Elastic IP Addresses**

**D. NAT Gateway**

**Answer:**D

Option A is not correct.

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-VPC-6-1.png "AWS VPC")

An internet gateway is an AWS component which sits outside of your VPC does not consume any resources from your VPC.

Option B is not correct.

Endpoints are virtual devices. They are horizontally scaled, redundant, and highly available VPC components that allow communication between instances in your VPC and services without imposing availability risks or bandwidth constraints on your network traffic.

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-VPC-7.png "AWS VPC")

Option C is not correct.

An Elastic IP address is a static, public IPv4 address designed for dynamic cloud computing. You can associate an Elastic IP address with any instance or network interface for any VPC in your account. With an Elastic IP address, you can mask the failure of an instance by rapidly remapping the address to another instance in your VPC.

They do not belong to a single VPC.

Option D is correct.

To create a NAT gateway, you must specify the public subnet in which the NAT gateway should reside. For more information about public and private subnets, see Subnet Routing. You must also specify an Elastic IP address to associate with the NAT gateway when you create it. After you’ve created a NAT gateway, you must update the route table associated with one or more of your private subnets to point Internet-bound traffic to the NAT gateway. This enables instances in your private subnets to communicate with the internet.

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-VPC-8.png "AWS VPC")

**19. You have successfully set up a VPC peering connection in your account between two VPCs – VPC A and VPC B, each in a different region. When you are trying to make a request from VPC A to VPC B, request getting failed. Which of the following could be a reason?**

**A. Cross region peering is not supported in AWS**

**B. CIDR blocks of both VPCs might be overlapping.**

**C. Routes not configured in route tables for peering connections.**

**D. VPC A security group default outbound rules not allowing traffic to VPC B IP range.**

**Answer:**C

Option A is not correct. Cross region VPC peering is supported in AWS.

Option B is not correct.

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-VPC-Peering-1.png "AWS VPC Peering ")

When the VPC IP CIDR blocks are overlapping, you cannot create a peering connection. Question states the peering connection was successful.

Option C is correct.

To send private IPv4 traffic from your instance to an instance in a peer VPC, you must add a route to the route table that’s associated with your subnet in which your instance resides. The route points to the CIDR block \(or portion of the CIDR block\) of the peer VPC in the VPC peering connection.

[https://docs.aws.amazon.com/AmazonVPC/latest/PeeringGuide/vpc-peering-routing.html](https://docs.aws.amazon.com/AmazonVPC/latest/PeeringGuide/vpc-peering-routing.html)

Option D is not correct.

A security group’s default outbound rule allows all traffic going out from the resources attached to the security group.

![](https://www.whizlabs.com/blog/wp-content/uploads/sites/2/2018/08/AWS-VPC-Peering-2.png "AWS VPC Peering")

[https://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC\_SecurityGroups.html\#Defaul](https://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_SecurityGroups.html#Defaul)

**20. Which of the following statements are true in terms of allowing/denying traffic from/to VPC assuming the default rules are not in effect? \(choose multiple\)**

**A. In a Network ACL, for a successful HTTPS connection, add an inbound rule with HTTPS type, IP range in source and ALLOW traffic.**

**B. In a Network ACL, for a successful HTTPS connection, you must add an inbound rule and outbound rule with HTTPS type, IP range in source and destination respectively and ALLOW traffic.**

**C. In a Security Group, for a successful HTTPS connection, add an inbound rule with HTTPS type and IP range in the source.**

**D. In a Security Group, for a successful HTTPS connection, you must add an inbound rule and outbound rule with HTTPS type, IP range in source and destination respectively.**

**Answer:**B, C

Security groups are stateful — if you send a request from your instance, the response traffic for that request is allowed to flow in regardless of inbound security group rules. Responses to allowed inbound traffic are allowed to flow out, regardless of outbound rules.

Network ACLs are stateless; responses to allowed inbound traffic are subject to the rules for outbound traffic \(and vice versa\).

Option A is not correct. NACL must have an outbound rule defined for a successful connection due to its stateless nature.

Option B is correct.

Option C is correct.

Configuring an inbound rule in security group is enough for a successful connection due to is stateful nature.

Option D is not correct.

Configuring an outbound rule for incoming connection is not required in security groups.

[https://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC\_ACLs.html\#ACLs](https://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_ACLs.html#ACLs)

[https://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC\_SecurityGroups.html\#VPCSe](https://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_SecurityGroups.html#VPCSe)

