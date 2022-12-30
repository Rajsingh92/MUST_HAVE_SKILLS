**QUESTION 171**

You need to migrate 10 million records in one hour into DynamoDB. All records are 1.5KB in size.

The data is evenly distributed across the partition key. How many write capacity units should you

provision during this batch load?

A. 6667

B. 4166

C. 5556

D. 2778

**Answer: C**

**Explanation:      
**You need 2 units to make a 1.5KB write, since you round up. You need 20 million total units to

perform this load. You have 3600 seconds to do so. Divide and round up for 5556.

---

**QUESTION 172**

You attempt to store an object in the US-STANDARD region in Amazon S3, and receive a

confirmation that it has been successfully stored. You then immediately make another API call

and attempt to read this object. S3 tells you that the object does not exist

What could explain this behavior?

A. US-STANDARD uses eventual consistency and it can take time for an object to be readable in

a bucket

B. Objects in Amazon S3 do not become visible until they are replicated to a second region.

C. US-STANDARD imposes a 1 second delay before new objects are readable.

D. You exceeded the bucket object limit, and once this limit is raised the object will be visible.

**Answer: A**

---

**QUESTION 173**

You are writing to a DynamoDB table and receive the following exception:"

ProvisionedThroughputExceededException". though according to your Cloudwatch metrics for

the table, you are not exceeding your provisioned throughput.

What could be an explanation for this?

A. You haven't provisioned enough DynamoDB storage instances

B. You're exceeding your capacity on a particular Range Key

C. You're exceeding your capacity on a particular Hash Key

D. You're exceeding your capacity on a particular Sort Key

E. You haven't configured DynamoDB Auto Scaling triggers

**Answer: C**

---

**QUESTION 174      
**

If an application is storing hourly log files from thousands of instances from a high traffic web site,

which naming scheme would give optimal performance on S3?

A. Sequential

B. instanceID\_log-HH-DD-MM-YYYY

C. instanceID\_log-YYYY-MM-DD-HH

D. HH-DD-MM-YYYY-log\_instanceID

E. YYYY-MM-DD-HH-log\_instanceID

**Answer: E**

---

**QUESTION 175**

You run an ad-supported photo sharing website using S3 to serve photos to visitors of your site.

At some point you find out that other sites have been linking to the photos on your site, causing

loss to your business.

What is an effective method to mitigate this?

A. Store photos on an EBS volume of the web server

B. Remove public read access and use signed URLs with expiry dates.

C. Use CloudFront distributions for static content.

D. Block the IPs of the offending websites in Security Groups.

**Answer: B**

---

**QUESTION 176**

Company A has an S3 bucket containing premier content that they intend to make available to

only paid subscribers of their website. The S3 bucket currently has default permissions of all

objects being private to prevent inadvertent exposure of the premier content to non-paying

website visitors. How can Company A provide only paid subscribers the ability to download a

premier content file in the S3 bucket?

A. Apply a bucket policy that grants anonymous users to download the content from the S3 bucket

B. Generate a pre-signed object URL for the premier content file when a paid subscriberrequests a

download

C. Add a bucket policy that requires Multi-Factor Authentication for requests to access the S3

bucket objects

D. Enable server side encryption on the S3 bucket for data protection against the non-paying

website visitors

**Answer: B**

---

**QUESTION 177**

Which of the following is chosen as the default region when making an API call with an AWS

SDK?

A. ap-northeast-1

B. us-west-2

C. us-east-1

D. eu-west-1

E. us-central-1

**Answer: C**

---

**QUESTION 178**

Games-R-Us is launching a new game app for mobile devices. Users will log into the game using

their existing Facebook account and the game will record player data and scoring information

directly to a DynamoDB table.

What is the most secure approach for signing requests to the DynamoDB API?

A. Create an IAM user with access credentials that are distributed with the mobile app to sign the

requests

B. Distribute the AWS root account access credentials with the mobile app to sign the requests

C. Request temporary security credentials using web identity federation to sign the requests

D. Establish cross account access between the mobile app and the DynamoDB table to sign the

requests

**Answer: C**

---

**QUESTION 179**

After launching an instance that you intend to serve as a NAT \(Network Address Translation\)

device in a public subnet you modify your route tables to have the NAT device be the target of

internet bound traffic of your private subnet. When you try and make an outbound connection to

the Internet from an instance in the private subnet, you are not successful.

Which of the following steps could resolve the issue?

A. Attaching a second Elastic Network interface \(ENI\) to the NAT instance, and placing it in the

private subnet

B. Attaching a second Elastic Network Interface \(ENI\) to the instance in the private subnet, and

placing it in the public subnet

C. Disabling the Source/Destination Check attribute on the NAT instance

D. Attaching an Elastic IP address to the instance in the private subnet

**Answer: C**

---

**QUESTION 180**

What happens, by default, when one of the resources in a CloudFormation stack cannot be

created?

A. Previously-created resources are kept but the stack creation terminates.

B. Previously-created resources are deleted and the stack creation terminates.

C. The stack creation continues, and the final results indicate which steps failed.

D. CloudFormation templates are parsed in advance so stack creation is guaranteed to succeed.

**Answer: B**

---

**QUESTION 181**

Which of the following statements about SQS is true?

A. Messages will be delivered exactly once and messages will be delivered in First in, First out

order

B. Messages will be delivered exactly once and message delivery order is indeterminate

C. Messages will be delivered one or more times and messages will be delivered in First in, First

out order

D. Messages will be delivered one or more times and message delivery order is indeterminate

**Answer: D**

---

**QUESTION 182**

A user is running a MySQL RDS instance. The user will not use the DB for the next 3 months.

How can the user save costs?

A. Pause the RDS activities from CLI until it is required in the future

B. Stop the RDS instance

C. Create a snapshot of RDS to launch in the future and terminate the instance now

D. Change the instance size to micro

**Answer: C**

**Explanation:**

The RDS instances unlike the AWS EBS backed instances cannot be stopped or paused.

The user needs to take the final snapshot, terminate the instance and launch a new instance in

the future from that snapshot.

---

**QUESTION 183**

In DynamoDB, if you create a table and request 10 units of write capacity and 200 units of read

capacity of provisioned throughput, how much would you be charged in US East \(Northern

Virginia\) Region?

A. $0.05 per hour

B. $0.10 per hour

C. $0.03 per hour

D. $0.15 per hour

**Answer: A**

**Explanation:**

To understand pricing in DynamoDB, consider the following example. If you create a table and

request 10 units of write capacity and 200 units of read capacity of provisioned throughput, you

would be charged:

$0.01 + \(4 x $0.01\) = $0.05 per hour

[http://aws.amazon.com/dynamodb/pricing/](http://aws.amazon.com/dynamodb/pricing/)

---

**QUESTION 184**

You have been doing a lot of testing of your VPC Network by deliberately failing EC2 instances to

test whether instances are failing over properly. Your customer who will be paying the AWS bill

for all this asks you if he being charged for all these instances. You try to explain to him how the

billing works on EC2 instances to the best of your knowledge. What would be an appropriate

response to give to the customer in regards to this?

A. Billing commences when Amazon EC2 AMI instance is completely up and billing ends as soon

as the instance starts to shutdown.

B. Billing commences when Amazon EC2 initiates the boot sequence of an AMI instance and

billing ends when the instance shuts down.

C. Billing only commences only after 1 hour of uptime and billing ends when the instance

terminates.

D. Billing commences when Amazon EC2 initiates the boot sequence of an AMI instance and

billing ends as soon as the instance starts to shutdown.

**Answer: B**

**Explanation:**

Billing commences when Amazon EC2 initiates the boot sequence of an AMI instance. Billing

ends when the instance shuts down, which could occur through a web services command, by

running "shutdown -h", or through instance failure.

[http://aws.amazon.com/ec2/faqs/\#Billing](http://aws.amazon.com/ec2/faqs/#Billing)

---

**QUESTION 185      
**AWS Elastic Load Balancer supports SSL termination.

A. True. For specific availability zones only.

B. False

C. True. For specific regions only

D. True. For all regions

**Answer: D**

**Explanation:**

You can configure your load balancer in ELB \(Elastic Load Balancing\) to use a SSL certificate in

order to improve your system security.The load balancer uses the certificate to terminate and

then decrypt requests before sending them to the back-end instances. Elastic Load Balancing

uses AWS Identity and Access Management \(IAM\) to upload your certificate to your load

balancer.

---

**QUESTION 186      
**A user has launched five instances with ELB. How can the user add the sixth EC2 instance to

ELB?

A. The user can add the sixth instance on the fly.

B. The user must stop the ELB and add the sixth instance.

C. The user can add the instance and change the ELB config file.

D. The ELB can only have a maximum of five instances.

**Answer: A**

**Explanation:**

Elastic Load Balancing automatically distributes incoming traffic across multiple EC2 instances.

You create a load balancer and register instances with the load balancer in one or more

Availability Zones. The load balancer serves as a single point of contact for clients. This enables

you to increase the availability of your application. You can add and remove EC2 instances from

your load balancer as your needs change, without disrupting the overall flow of information.

[http://docs.aws.amazon.com/ElasticLoadBalancing/latest/DeveloperGuide/SvcIntro.html](http://docs.aws.amazon.com/ElasticLoadBalancing/latest/DeveloperGuide/SvcIntro.html)

---

**QUESTION 187**

An organization has 500 employees. The organization wants to set up AWS access for each

department. Which of the below mentioned options is a possible solution?

A. Create IAM roles based on the permission and assign users to each role

B. Create IAM users and provide individual permission to each

C. Create IAM groups based on the permission and assign IAM users to the groups

D. It is not possible to manage more than 100 IAM users with AWS

**Answer: C  
Explanation:**

An IAM group is a collection of IAM users. Groups let the user specify permissions for a collection

of users, which can make it easier to manage the permissions for those users.

[http://docs.aws.amazon.com/IAM/latest/UserGuide/Using\_WorkingWithGroupsAndUsers.html](http://docs.aws.amazon.com/IAM/latest/UserGuide/Using_WorkingWithGroupsAndUsers.html)

---

**QUESTION 188      
**How long can you keep your Amazon SQS messages in Amazon SQS queues?

A. From 120 secs up to 4 weeks

B. From 10 secs up to 7 days

C. From 60 secs up to 2 weeks

D. From 30 secs up to 1 week

**Answer: C**

**Explanation:**

The SQS message retention period is configurable and can be set anywhere from 1 minute to 2

weeks. The default is 4 days and once the message retention limit is reached your messages will

be automatically deleted. The option for longer message retention provides greater flexibility to

allow for longer intervals between message production and consumption.

[https://aws.amazon.com/sqs/faqs/      
](https://aws.amazon.com/sqs/faqs/)

---

**QUESTION 189**

In regard to DynamoDB, which of the following statements is correct?

A. An Item should have at least two value sets, a primary key and another attribute.

B. An Item can have more than one attributes.

C. A primary key should be single-valued.

D. An attribute can have one or several other attributes.

**Answer: B  
Explanation:**

In Amazon DynamoDB, a database is a collection of tables. A table is a collection of items and

each item is a collection of attributes.

[http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataModel.html](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataModel.html)

---

**QUESTION 190**

Which one of the following statements is NOT an advantage of DyanamoDB being built on Solid

State Drives:

A. serve high-scale request workloads

B. low request pricing

C. high I/O performance of WebApp on EC2 instance

D. low-latency response times

**Answer: C**

**Explanation:**

In DynamoDB, SSDs help achieve design goals of predictable low-latency response times for

storing and accessing data at any scale. The high I/O performance of SSDs also enables to serve

high-scale request workloads cost efficiently, and to pass this efficiency along in low request

pricing.

[http://aws.amazon.com/dynamodb/faqs/](http://aws.amazon.com/dynamodb/faqs/)

---

**QUESTION 191  
**

An organization has hosted an application on the EC2 instances. There will be multiple users

connecting to the instance for setup and configuration of application. The organization is planning

to implement certain security best practices. Which of the below mentioned pointers will not help

the organization achieve better security arrangement?

A. Apply the latest patch of OS and always keep it updated.

B. Allow only IAM users to connect with the EC2 instances with their own secret access key.

C. Disable the password based login for all the users. All the users should use their own keys to

connect with the instance securely.

D. Create a procedure to revoke the access rights of the individual user when they are not required

to connect to EC2 instance anymore for the purpose of application configuration.

**Answer: B  
**

**Explanation:  
**

Since AWS is a public cloud any application hosted on EC2 is prone to hacker attacks. It

becomes extremely important for a user to setup a proper security mechanism on the EC2

instances. A few of the security measures are listed below:

Always keep the OS updated with the latest patch

Always create separate users with in OS if they need to connect with the EC2 instances, create

their keys and disable their password

Create a procedure using which the admin can revoke the access of the user when the business

work on the EC2 instance is completed

Lock down unnecessary ports

Audit any proprietary applications that the user may be running on the EC2 instance Provide

temporary escalated privileges, such as sudo for users who need to perform occasional privileged

tasks

The IAM is useful when users are required to work with AWS resources and actions, such as

launching an instance. It is not useful to connect \(RDP / SSH\) with an instance.

[http://aws.amazon.com/articles/1233/  
](http://aws.amazon.com/articles/1233/)

---

**QUESTION 192  
**

A user is planning to make a mobile game which can be played online or offline and will be

hosted on EC2. The user wants to ensure that if someone breaks the highest score or they

achieve some milestone they can inform all their colleagues through email. Which of the below

mentioned AWS services helps achieve this goal?

A. AWS Simple Workflow Service.

B. AWS Simple Queue Service.

C. Amazon Cognito

D. AWS Simple Email Service.

Answer: D

Explanation:

Amazon Simple Email Service \(Amazon SES\) is a highly scalable and cost-effective emailsending

service for businesses and developers. It integrates with other AWS services, making it

easy to send emails from applications that are hosted on AWS.

[http://aws.amazon.com/ses/faqs/  
](http://aws.amazon.com/ses/faqs/)

---

**QUESTION 193  
**

Which one of the following operations is NOT a DynamoDB operation?

A. BatchWriteItem

B. DescribeTable

C. BatchGetItem

D. BatchDeleteItem

**Answer: D  
**

**Explanation:  
**

In DynamoDB, DeleteItem deletes a single item in a table by primary key, but BatchDeleteItem

doesn't exist.

[http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/operationlist.html  
](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/operationlist.html)

---

**QUESTION 194  
**

Company C is currently hosting their corporate site in an Amazon S3 bucket with Static Website

Hosting enabled. Currently, when visitors go to [http://www.companyc.com](http://www.companyc.com) the index.html page is

returned. Company C now would like a new page welcome.html to be returned when a visitor

enters [http://www.companyc.com](http://www.companyc.com) in the browser.

Which of the following steps will allow Company C to meet this requirement? Choose 2 answers

A. Upload an html page named welcome.html to their S3 bucket

B. Create a welcome subfolder in their S3 bucket

C. Set the Index Document property to welcome.html

D. Move the index.html page to a welcome subfolder

E. Set the Error Document property to welcome.html

**Answer: AC  
**

---

**QUESTION 195  
**

What item operation allows the retrieval of multiple items from a DynamoDB table in a single API

call?

A. GetItem

B. BatchGetItem

C. GetMultipleItems

D. GetItemRange

**Answer: B  
**

---

**QUESTION 196  
**

Which of the following are valid arguments for an SNS Publish request? Choose 3 answers

A. TopicAm

B. Subject

C. Destination

D. Format

E. Message

F. Language

**Answer: ABE  
**

---

**QUESTION 197  
**

An application stores payroll information nightly in DynamoDB for a large number of employees

across hundreds of offices. Item attributes consist of individual name, office identifier, and

cumulative daily hours. Managers run reports for ranges of names working in their office. One

query is. "Return all Items in this office for names starting with A through E". Which table

configuration will result in the lowest impact on provisioned throughput for this query?

A. Configure the table to have a hash index on the name attribute, and a range index on the office

identifier

B. Configure the table to have a range index on the name attribute, and a hash index on the office

identifier

C. Configure a hash index on the name attribute and no range index

D. Configure a hash index on the office Identifier attribute and no range index

**Answer: B  
**

---

**QUESTION 198  
**

EC2 instances are launched from Amazon Machine images \(AMIS\).

A given public AMI can:

A. be used to launch EC2 Instances in any AWS region.

B. only be used to launch EC2 instances in the same country as the AMI is stored.

C. only be used to launch EC2 instances in the same AWS region as the AMI is stored.

D. only be used to launch EC2 instances in the same AWS availability zone as the AMI is stored

**Answer: C  
**

---

**QUESTION 199  
**

Which of the following platforms are supported by Elastic Beanstalk? Choose 2 answers

A. Apache Tomcat

B. .NET

C. IBM Websphere

D. Oracle JBoss

E. Jetty

**Answer: AB  
**

---

**QUESTION 200  
**

Which EC2 API call would you use to retrieve a list of Amazon Machine Images \(AMIs\)?

A. DescnbeInstances

B. DescribeAMls

C. DescribeImages

D. GetAMls

E. You cannot retrieve a list of AMIs as there are over 10,000 AMIs

**Answer: E  
**

---

**QUESTION 201  
**

When a Simple Queue Service message triggers a task that takes 5 minutes to complete, which

process below will result in successful processing of the message and remove it from the queue

while minimizing the chances of duplicate processing?

A. Retrieve the message with an increased visibility timeout, process the message, delete the

message from the queue

B. Retrieve the message with an increased visibility timeout, delete the message from the queue,

process the message

C. Retrieve the message with increased DelaySeconds, process the message, delete the

message from the queue

D. Retrieve the message with increased DelaySeconds, delete the message from the queue,

process the message

**Answer: A  
**

---

**QUESTION 202  
**

In Amazon EC2, which of the following is the type of monitoring data for Amazon EBS volumes

that is available automatically in 5-minute periods at no charge?

A. Primary

B. Basic

C. Initial

D. Detailed

**Answer: B  
**

**Explanation:  
**

Basic is the type of monitoring data \(for Amazon EBS volumes\) which is available automatically in

5-minute periods at no charge called.

[http://docs.amazonwebservices.com/AWSEC2/latest/UserGuide/monitoring-volume-status.html  
](http://docs.amazonwebservices.com/AWSEC2/latest/UserGuide/monitoring-volume-status.html)

---

**QUESTION 203  
**

In DynamoDB, to get a detailed listing of secondary indexes on a table, you can use the \_\_\_\_\_

action.

A. DescribeTable

B. BatchGetItem

C. GetItem

D. TableName

**Answer: A  
**

**Explanation:  
**

In DynamoDB, DescribeTable returns information about the table, including the current status of

the table, when it was created, the primary key schema, and any indexes on the table.

[http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/SecondaryIndexes.html  
](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/SecondaryIndexes.html)

---

**QUESTION 204  
**

A user has launched an EC2 instance. However, due to some reason the instance was

terminated. If the user wants to find out the reason for termination, where can he find the details?

A. The user can get information from the AWS console, by checking the Instance description

under the State transition reason label

B. The user can get information from the AWS console, by checking the Instance description

under the Instance Termination reason label

C. The user can get information from the AWS console, by checking the Instance description

under the Instance Status Change reason label

D. It is not possible to find the details after the instance is terminated

**Answer: A  
**

**Explanation:  
**

An EC2 instance, once terminated, may be available in the AWS console for a while after

termination. The user can find the details about the termination from the description tab under the

label State transition reason. If the instance is still running, there will be no reason listed. If the

user has explicitly stopped or terminated the instance, the reason will be "User initiated

shutdown".

---

**QUESTION 205  
**

\_\_\_\_\_\_\_\_\_\_\_ is a task coordination and state management service for cloud applications.

A. Amazon SES

B. Amazon SWF

C. Amazon FPS

D. Amazon SNS

**Answer: B  
**

**Explanation:  
**

Amazon Simple Workflow \(Amazon SWF\) is a task coordination and state management service

for cloud applications. With Amazon SWF, you can stop writing complex glue-code and state

machinery and invest more in the business logic that makes your applications unique.

[http://aws.amazon.com/swf/  
](http://aws.amazon.com/swf/)

---

**QUESTION 206  
**

When you create a table with a hash-and-range key, you must define one or more secondary

indexes on that table.

A. False, hash-range key is another name for secondary index

B. False, it is optional

C. True

D. False, when you have Hash-Range key you cannot define Secondary index

**Answer: B  
**

**Explanation:  
**

When you create a table with a hash-and-range key in DynamoDB, you can also define one or

more secondary indexes on that table.

[http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LSI.html  
](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LSI.html)

---

**QUESTION 207  
**

A user is planning to create a structured database in the cloud. Which of the below mentioned

AWS offerings help the user achieve the goal?

A. AWS DynamoDB

B. AWS RDS

C. AWS SimpleDB

D. AWS RSD

**Answer: B  
**

**Explanation:  
**

AWS RDS is a managed database server offered by AWS, which makes it easy to set up,

operate, and scale a relational database or structured data in cloud.

[http://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Welcome.html  
](http://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Welcome.html)

---

**QUESTION 208  
**

A user has created a MySQL RDS instance with PIOPS. Which of the below mentioned

statements will help user understand the advantage of PIOPS?

A. The user can achieve additional dedicated capacity for the EBS I/O with an enhanced RDS

option

B. It uses optimized EBS volumes and optimized configuration stacks

C. It provides a dedicated network bandwidth between EBS and RDS

D. It uses a standard EBS volume with optimized configuration the stacks

**Answer: B  
**

**Explanation:  
**

RDS DB instance storage comes in two types: standard and provisioned IOPS. Standard storage

is allocated on the Amazon EBS volumes and connected to the user's DB instance. Provisioned

IOPS uses optimized EBS volumes and an optimized configuration stack. It provides additional,

dedicated capacity for the EBS I/O.

[http://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Welcome.html  
](http://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Welcome.html)

---

**QUESTION 209  
**

A user is accessing an EC2 instance on the SSH port for IP 10.20.30.40. Which one is a secure

way to configure that the instance can be accessed only from this IP?

A. In the security group, open port 22 for IP 10.20.30.40/0

B. In the security group, open port 22 for IP 10.20.30.40/32

C. In the security group, open port 22 for IP 10.20.30.40/24

D. In the security group, open port 22 for IP 10.20.30.40

**Answer: B  
**

**Explanation:  
**

In AWS EC2, while configuring a security group, the user needs to specify the IP address in CIDR

notation. The CIDR IP range 10.20.30.40/32 says it is for a single IP 10.20.30.40. If the user

specifies the IP as 10.20.30.40 only, the security group will not accept and ask it in a CIRD

format.

[http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-network-security.html  
](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-network-security.html)

---

**QUESTION 210  
**

An Amazon S3 bucket, "myawsbucket" is configured with website hosting in Tokyo region, what is

the region-specific website endpoint?

A. www.myawsbucket.ap-northeast-1.amazonaws.com

B. myawsbucket.s3-website-ap-northeast-l.amazonawscom

C. myawsbucket.amazonaws.com

D. myawsbucket.tokyo.amazonaws.com

**Answer: B  
**

---

**QUESTION 211  
**

Which of the following items are required to allow an application deployed on an EC2 instance to

write data to a DynamoDB table?

Assume that no security Keys are allowed to be stored on the EC2 instance. Choose 2 answers

A. Create an IAM User that allows write access to the DynamoDB table.

B. Add an IAM Role to a running EC2 instance.

C. Add an IAM User to a running EC2 Instance.

D. Launch an EC2 Instance with the IAM Role included in the launch configuration.

E. Create an IAM Role that allows write access to the DynamoDB table.

F. Launch an EC2 Instance with the IAM User included in the launch configuration.

**Answer: DE  
**

---

**QUESTION 212  
**

Which of the following services are key/value stores? Choose 3 answers

A. Amazon ElastiCache

B. Simple Notification Service

C. DynamoDB

D. Simple Workflow Service

E. Simple Storage Service

**Answer: ABC  
**

---

**QUESTION 213  
**

How is provisioned throughput affected by the chosen consistency model when reading data from

a DynamoDB table?

A. Strongly consistent reads use the same amount of throughput as eventually consistent reads

B. Strongly consistent reads use more throughput than eventually consistent reads.

C. Strongly consistent reads use less throughput than eventually consistent reads

D. Strongly consistent reads use variable throughput depending on read activity

**Answer: B  
**

---

**QUESTION 214  
**

Your application is trying to upload a 6 GB file to Simple Storage Service and receive a "Your

proposed upload exceeds the maximum allowed object size." error message.

What is a possible solution for this?

A. None, Simple Storage Service objects are limited to 5 GB

B. Use the multi-part upload API for this object

C. Use the large object upload API for this object

D. Contact support to increase your object size limit

E. Upload to a different region

**Answer: B  
**

---

**QUESTION 215  
**

Which of the following services are included at no additional cost with the use of the AWS

platform? Choose 2 answers

A. Simple Storage Service

B. Elastic Compute Cloud

C. Auto Scaling

D. Elastic Load Balancing

E. CloudFormation

F. Simple Workflow Service

Answer: CE

---



