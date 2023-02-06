**QUESTION 75                  
**

A user wants to access RDS from an EC2 instance using IP addresses. Both RDS and EC2 are

in the same region, but different AZs. Which of the below mentioned options help configure that

the instance is accessed faster?

A. Configure the Private IP of the Instance in RDS security group

B. Security group of EC2 allowed in the RDS security group

C. Configuring the elastic IP of the instance in RDS security group

D. Configure the Public IP of the instance in RDS security group

**Answer: A                  
**

**Explanation:                  
**

If the user is going to specify an IP range in RDS security group, AWS recommends using the

private IP address of the Amazon EC2 instance. This provides a more direct network route from

the Amazon EC2 instance to the Amazon RDS DB instance, and does not incur network charges

for the data sent outside of the Amazon network.

---

**QUESTION 76                
**

A user is creating a snapshot of an EBS volume. Which of the below statements is incorrect in

relation to the creation of an EBS snapshot?

A. Its incremental

B. It can be used to launch a new instance

C. It is stored in the same AZ as the volume

D. It is a point in time backup of the EBS volume

**Answer: C                
**

**Explanation:                
**

The EBS snapshots are a point in time backup of the EBS volume. It is an incremental snapshot,

but is always specific to the region and never specific to a single AZ. Hence the statement "It is

stored in the same AZ as the volume" is incorrect.

[http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSSnapshots.html](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSSnapshots.html)

---

**QUESTION 77              
**

A user is planning to use EBS for his DB requirement. The user already has an EC2 instance

running in the VPC private subnet. How can the user attach the EBS volume to a running

instance?

A. The user must create EBS within the same VPC and then attach it to a running instance.

B. The user can create EBS in the same zone as the subnet of instance and attach that EBS to

instance.

C. It is not possible to attach an EBS to an instance running in VPC until the instance is stopped.

D. The user can specify the same subnet while creating EBS and then attach it to a running

instance.

**Answer: B              
**

**Explanation:              
**

A Virtual Private Cloud \(VPC\) is a virtual network dedicated to the user's AWS account. The user

can create subnets as per the requirement within a VPC. The VPC is always specific to a region.

The user can create a VPC which can span multiple Availability Zones by adding one or more

subnets in each Availability Zone.

The instance launched will always be in the same availability zone of the respective subnet.

When creating an EBS the user cannot specify the subnet or VPC. However, the user must

create the EBS in the same zone as the instance so that it can attach the EBS volume to the

running instance.

[http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC\_Subnets.html\#VPCSubnet](http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_Subnets.html#VPCSubnet)

---

**QUESTION 78              
**

Which of the following groups is AWS Elastic Beanstalk best suited for?

A. Those who want to deploy and manage their applications within minutes in the AWS cloud

B. Those who want to privately store and manage Git repositories in the AWS cloud.

C. Those who want to automate the deployment of applications to instances and to update the

applications as required

D. Those who want to model, visualize, and automate the steps required to release software

**Answer: A              
**

**Explanation:              
**

AWS Elastic Beanstalk is best suited for those groups who want to deploy and manage their

applications within minutes in the AWS cloud. As a bonus, you don't even need experience with

cloud computing to get started.

[https://aws.amazon.com/elasticbeanstalk/faqs/              
](https://aws.amazon.com/elasticbeanstalk/faqs/)

---

**QUESTION 79              
**

You are using Amazon SQS and are getting a "Queue Deleted Recently" error. What is wrong?

A. The message is too big

B. You have incorrect permissions

C. Another user has deleted the queue

D. If you delete a queue, you need to wait for at least 60 seconds before creating a queue with the

same name

**Answer: D              
**

**Explanation:              
**

If you delete a queue, you need to wait for at least 60 seconds before creating a queue with the

same name. Please note that when you delete a queue, the deletion process takes up to 60

seconds. Requests you send to a recently deleted queue might succeed during the 60-second

period. For example, a SendMessage request might succeed, but after 60 seconds the queue

and that message you sent no longer exists.

[https://aws.amazon.com/items/1343?externalID=1343              
](https://aws.amazon.com/items/1343?externalID=1343)

---

**QUESTION 80              
**

Your manager has requested you to tag EC2 instances to organize and manage a load balancer.

Which of the following statements about tag restrictions is incorrect?

A. The maximum key length is 127 Unicode characters.

B. The maximum value length is 255 Unicode characters.

C. Tag keys and values are case sensitive.

D. The maximum number of tags per load balancer is 20.

**Answer: D              
**

**Explanation:              
**

Tags help you to categorize your load balancers in different ways, for example, by purpose,

owner, or environment. The following basic restrictions apply to tags: The maximum number of

tags per resource is

1. The maximum key length is 127 Unicode characters. The maximum value length that can be

used is 255 Unicode characters. The tag keys and values are case sensitive. Allowed characters

are letters, spaces, and numbers representable in UTF-8, plus the following special characters: +

* =. \_ : / @. Do not use leading or trailing spaces. Do not use the aws: prefix in your tag names or

values because it is reserved for AWS use. You can't edit or delete tag names or values with this

prefix. Tags with this prefix do not count against your tags per resource limit.

---

**QUESTION 81              
**

A user is trying to find the state of an S3 bucket with respect to versioning. Which of the below

mentioned states AWS will not return when queried?

A. versioning-enabled

B. versioning-suspended

C. unversioned

D. versioned

**Answer: D              
**

**Explanation:              
**

S3 buckets can be in one of the three states: unversioned \(the default\), versioning-enabled or

versioning-suspended. The bucket owner can configure the versioning state of a bucket. The

versioning state applies to all \(never some\) of the objects in that bucket. The first time owner

enables a bucket for versioning, objects in it are thereafter always versioned and given a unique

version ID.

[http://docs.aws.amazon.com/AmazonS3/latest/dev/Versioning.html](http://docs.aws.amazon.com/AmazonS3/latest/dev/Versioning.html)

---

**QUESTION 82              
**

What is the maximum number of tags that a user can assign to an EC2 instance?

A. 50

B. 10

C. 5

D. 25

**Answer: B              
**

**Explanation:              
**

To help manage EC2 instances as well as their usage in a better way, the user can tag the

instances. The tags are metadata assigned by the user which consists of a key and a value.

One resource can have a maximum of 10 tags.

[http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/Using\_Tags.html              
](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/Using_Tags.html)

---

**QUESTION 83            
**

How do you configure SQS to support longer message retention?

A. Set the MessageRetentionPeriod attribute using the SetQueueAttributes method

B. Using a Lambda function

C. You can't. It is set to 14 days and cannot be changed

D. You need to request it from AWS

**Answer: A            
**

**Explanation:            
**

To configure the message retention period, set the MessageRetentionPeriod attribute using the

SetQueueAttributes method. This attribute is used to specify the number of seconds a message

will be retained by SQS. Currently the default value for the message retention period is 4 days.

Using the MessageRetentionPeriod attribute, the message retention period can be set anywhere

from 60 seconds \(1 minute\), up to 1209600 seconds \(14 days\).

[https://aws.amazon.com/sqs/faqs/](https://aws.amazon.com/sqs/faqs/)

---

QUESTION 84

The user has created multiple AutoScaling groups. The user is trying to create a new AS group

but it fails. How can the user know that he has reached the AS group limit specified by

AutoScaling in that region?

A. Run the command: as-describe-account-limits

B. Run the command: as-describe-group-limits

C. Run the command: as-max-account-limits

D. Run the command: as-list-account-limits

**Answer: A            
**

**Explanation:            
**

A user can see the number of AutoScaling resources currently allowed for the AWS account

either by using the as-describe-account-limits command or by calling the DescribeAccountLimits

action.

[http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/ts-as-capacity.html](http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/ts-as-capacity.html)

---

**QUESTION 85            
**

An organization is hosting an application as part of the free usage tier. The organization wants to

create IAM users for each of its 150 employees and they may access AWS as part of free usage

tier. What will you advise the organization?

A. The IAM is not available as a part of the free usage tier

B. Create IAM roles and give access based on role since it will not cost the user

C. Do not create more than 100 users as it will cost the organization.

D. Create IAM users for each employee as it does not cost

**Answer: D            
**

**Explanation:            
**

IAM is a free service. You can create as many IAM users or groups as desired free of cost.

[http://docs.aws.amazon.com/IAM/latest/UserGuide/IAM\_Introduction.html](http://docs.aws.amazon.com/IAM/latest/UserGuide/IAM_Introduction.html)

---

**QUESTION 86          
**

A user has enabled serverside encryption with S3. The user downloads the encrypted object from

S3.

How can the user decrypt it?

A. S3 does not support server side encryption

B. S3 provides a server side key to decrypt the object

C. The user needs to decrypt the object using their own private key

D. S3 manages encryption and decryption automatically

**Answer: D          
**

**Explanation:          
**

If the user is using the server-side encryption feature, Amazon S3 encrypts the object data before

saving it on disks in its data centres and decrypts it when the user downloads the objects. Thus,

the user is free from the tasks of managing encryption, encryption keys, and related tools.

[http://docs.aws.amazon.com/AmazonS3/latest/dev/UsingEncryption.html](http://docs.aws.amazon.com/AmazonS3/latest/dev/UsingEncryption.html)

---

**QUESTION 87          
**

A user has configured ELB with two instances running in separate AZs of the same region?

Which of the below mentioned statements is true?

A. Multi AZ instances will provide HA with ELB

B. Multi AZ instances are not possible with a single ELB

C. Multi AZ instances will provide scalability with ELB

D. The user can achieve both HA and scalability with ELB

**Answer: A          
**

**Explanation:          
**

If a user is running two instances in separate AZs, it will provide HA with ELB since ELB will

automatically stop routing the traffic to unhealthy instances and send it to healthy instances only.

---

**QUESTION 88          
**

Does Amazon DynamoDB support both increment and decrement atomic operations?

A. No, neither increment nor decrement operations.

B. Only increment, since decrement are inherently impossible with DynamoDB's data model.

C. Only decrement, since increment are inherently impossible with DynamoDB's data model.

D. Yes, both increment and decrement operations.

**Answer: D          
**

**Explanation:          
**

Amazon DynamoDB supports increment and decrement atomic operations.

[http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/APISummary.html](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/APISummary.html)

---

**QUESTION 89          
**

What is the data model of DynamoDB?

A. "Items", with Keys and one or more Attribute; and "Attribute", with Name and Value.

B. "Database", which is a set of "Tables", which is a set of "Items", which is a set of "Attributes".

C. "Table", a collection of Items; "Items", with Keys and one or more Attribute; and "Attribute", with

Name and Value.

D. "Database", a collection of Tables; "Tables", with Keys and one or more Attribute; and

"Attribute", with Name and Value.

**Answer: C          
**

**Explanation:          
**

The data model of DynamoDB is:

"Table", a collection of Items;

"Items", with Keys and one or more Attribute;

"Attribute", with Name and Value.

[http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataModel.html](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataModel.html)

---

**QUESTION 90          
**

A user is trying to configure access with S3. Which of the following options is not possible to

provide access to the S3 bucket / object?

A. Define the policy for the IAM user

B. Define the ACL for the object

C. Define the policy for the object

D. Define the policy for the bucket

**Answer: C          
**

**Explanation:          
**

Amazon S3 offers access policy options broadly categorized as resource-based policies and user

policies. Access policies, such as ACL and resource policy can be attached to the bucket. With

the object the user can only have ACL and not an object policy. The user can also attach access

policies to the IAM users in the account. These are called user policies.

[http://docs.aws.amazon.com/AmazonS3/latest/dev/s3-access-control.html](http://docs.aws.amazon.com/AmazonS3/latest/dev/s3-access-control.html)

---

**QUESTION 91        
**

An organization has enabled a strict password policy for its IAM users. The organization is taking

help from the IAM console to set the password policy. Which of the below mentioned rules cannot

be specified by the user as a part of the policy?

A. Allow at least one lower case letter

B. Allow at least one number

C. Allow at least one non-alphanumeric character

D. Do not allow the user to use the password from the last three passwords

**Answer: D        
**

**Explanation:        
**

AWS IAM allows an organization to create multiple users and provide them access to various

AWS services. By default when the user is created, he does not have password enabled and can

not login to AWS console. If the organization wants to allow the users to login to AWS console,

they can enable password for each user. It is required that IAM users follow certain guidelines to

set their IAM login password. For this IAM provides root account owner to setup passwrod policy.

The password policy also lets the specify whether all IAM users can change their own passwords.

As part of policy, organization can specify that passwords for IAM users must be of a certain

minimum length, must include certain characters, and a few more criteria such as below.

One upper / lower or both letters

One alpha numeric

One number

[http://docs.aws.amazon.com/IAM/latest/UserGuide/Using\_ManagingPasswordPolicies.html](http://docs.aws.amazon.com/IAM/latest/UserGuide/Using_ManagingPasswordPolicies.html)

---

**QUESTION 92        
**

A user has developed an application which is required to send the data to a NoSQL database.

The user wants to decouple the data sending such that the application keeps processing and

sending data but does not wait for an acknowledgement of DB. Which of the below mentioned

applications helps in this scenario?

A. AWS Simple Notification Service

B. AWS Simple Workflow

C. AWS Simple Query Service

D. AWS Simple Queue Service

**Answer: D        
**

**Explanation:        
**

Amazon Simple Queue Service \(SQS\) is a fast, reliable, scalable, and fully managed message

queuing service. SQS provides a simple and cost-effective way to decouple the components of

an application. In this case, the user can use AWS SQS to send messages which are received

from an application and sent to DB. The application can continue processing data without waiting

for any acknowledgement from DB. The user can use SQS to transmit any volume of data without

losing messages or requiring other services to always be available.

[http://aws.amazon.com/sqs/](http://aws.amazon.com/sqs/)

---

**QUESTION 93      
**

In regard to DynamoDB, can I modify the index once it is created?

A. Yes, if it is a primary hash key index

B. Yes, if it is a Global secondary index

C. No

D. Yes, if it is a local secondary index

**Answer: C      
**

**Explanation:      
**

Currently, in DynamoDB, an index cannot be modified once it is created.

[http://aws.amazon.com/dynamodb/faqs/\#security\_anchor](http://aws.amazon.com/dynamodb/faqs/#security_anchor)

---

**QUESTION 94      
**

A user has created a new raw EBS volume. The user mounts the volume on the instance to

which it is attached. Which of the below mentioned options is a required step before the user can

mount the volume?

A. Run a cyclic check on the device for data consistency

B. Create a file system of the volume

C. No step is required. The user can directly mount the device

D. Resize the volume as per the original snapshot size

**Answer: B      
**

**Explanation:      
**

When a user is trying to mount a blank EBS volume, it is required that the user first creates a file

system within the volume.

[http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-using-volumes.html](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-using-volumes.html)

---

**QUESTION 95      
**

A user is launching an AWS RDS with MySQL. Which of the below mentioned options allows the

user to configure the INNODB engine parameters?

A. Options group

B. Engine parameters

C. Parameter groups

D. DB parameters

**Answer: C      
**

**Explanation:      
**

With regard to RDS, the user can manage the configuration of a DB engine by using a DB

parameter group. A DB parameter group contains engine configuration values that can be applied

to one or more DB instances of the same instance type.

[http://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Welcome.html](http://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Welcome.html)

---

**QUESTION 96    
**

A user is configuring the HTTPS protocol on a front end ELB and the SSL protocol for the backend

listener in ELB. What will ELB do?

A. It will allow you to create the configuration, but the instance will not pass the health check

B. Receives requests on HTTPS and sends it to the back end instance on SSL

C. It will not allow you to create this configuration

D. It will allow you to create the configuration, but ELB will not work as expected

**Answer: C    
**

**Explanation:    
**

If a user is configuring HTTPS on the front end and TCP on the back end, ELB will not allow

saving these listeners and will respond with the message.

"Load Balancer protocol is an application layer protocol, but instance protocol is not. Both the

Load Balancer protocol and the instance protocol should be at the same layer. Please fix."

---

**QUESTION 97    
**

ExamKiller \(with AWS account ID 111122223333\) has created 50 IAM users for its organization's

employees. What will be the AWS console URL for these associates?

A. https:// 111122223333.signin.aws.amazon.com/console/

B. https:// signin.aws.amazon.com/console/

C. [https://signin.aws.amazon.com/111122223333/console/](https://signin.aws.amazon.com/111122223333/console/)

D. [https://signin.aws.amazon.com/console/111122223333/](https://signin.aws.amazon.com/console/111122223333/)

**Answer: A    
**

**Explanation:    
**

When an organization is using AWS IAM for creating various users and manage their access

rights, the IAM user cannot use the login URL [http://aws.amazon.com/console](http://aws.amazon.com/console) to access AWS

management console. The console login URL for the IAM user will have AWS account ID of that

organization to identify the IAM user belongs to particular account. The AWS console login URL

for the IAM user will be https:// &lt;AWS\_Account\_ID&gt;.signin.aws.amazon.com/console/.

In this case it will be https:// 111122223333.signin.aws.amazon.com/console/

[http://docs.aws.amazon.com/IAM/latest/UserGuide/AccountAlias.html    
](http://docs.aws.amazon.com/IAM/latest/UserGuide/AccountAlias.html)

---

**QUESTION 98    
**

A user is planning to host MS SQL on an EBS volume. It was recommended to use the AWS

RDS. What advantages will the user have if he uses RDS in comparison to an EBS based DB?

A. Better throughput with PIOPS

B. Automated backup

C. MS SQL is not supported with RDS

D. High availability with multi AZs

**Answer: B    
**

**Explanation:    
**

Comparing with on-premises or EC2 based MS SQL, RDS provides an automated backup

feature. PIOPS is available with both RDS and EBS. However, HA is not available with MS SQL.

[https://aws.amazon.com/rds/faqs/](https://aws.amazon.com/rds/faqs/)

---

**QUESTION 99    
**

A user is setting up an Elastic Load Balancer\(ELB\). Which of the below parameters should the

user consider so as the instance gets registered with the ELB?

A. ELB DNS

B. IP address

C. Security group

D. ELB IP

**Answer: B    
**

**Explanation:    
**

The EC2 instances are registered with the load balancer using the IP addresses associated with

the instances. When an instance is stopped and then started, the IP address associated with the

instance changes. This prevents the load balancer from routing traffic to the restarted instance.

When the user stops and then starts registered EC2 instances, it is recommended that to deregister

the stopped instance from load balancer, and then register the restarted instance. Failure

to do so may prevent the load balancer from performing health checks and routing the traffic to

the restarted instance.

---

**QUESTION 100    
**

The user has configured AutoScaling based on the dynamic policy. Which of the following is not

the right command to specify a change in capacity as a part of the policy?

A. "adjustment=-50" \(type is PercentChangeInCapacity\)

B. "adjustment=3" \(type is ExactCapacity\)

C. "adjustment=-1" \(type is ChangeInCapacity\)

D. "adjustment=-8" \(type is ExactCapacity\)

**Answer: D    
**

**Explanation:    
**

The user can configure the AutoScaling group to automatically scale up and then scale down

based on the various specified CloudWatch monitoring conditions. The user needs to provide the

adjustment value and the adjustment type. A positive adjustment value increases the current

capacity and a negative adjustment value decreases the current capacity. The user can express

the change to the current size as an absolute number, an increment or as a percentage of the

current group size. In this option specifying the exact capacity with the adjustment value = -8 will

not work as when type is exact capacity the adjustment value cannot be negative.

[http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/as-scale-based-on-demand.html](http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/as-scale-based-on-demand.html)

---

**QUESTION 101    
**

When you use the AWS Elastic Beanstalk console to deploy a new application

\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_.

A. you'll need to upload each file separately

B. you'll need to create each file and path

C. you'll need to upload a source bundle

D. you'll need to create each file

**Answer: C    
**

**Explanation:    
**

When you use the AWS Elastic Beanstalk console to deploy a new application or an application

version, you'll need to upload a source bundle.

[http://docs.aws.amazon.com/elasticbeanstalk/latest/dg/using-features.deployment.source.html](http://docs.aws.amazon.com/elasticbeanstalk/latest/dg/using-features.deployment.source.html)

---

**QUESTION 102    
**

A user is planning to use the AWS RDS with MySQL. Which of the below mentioned services the

user is not going to pay?

A. Data transfer

B. RDS Cloudwatch metrics

C. Data storage

D. I/O requests per month

**Answer: B    
**

**Explanation:    
**

RDS charges the user on a pay as you go basis. It charges the user based on the instance type,

number of hours that the instance is running, data transfer, storage cost as well for the I/O

requests. The monitoring is free of cost.

[http://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Welcome.html](http://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Welcome.html)

---

**QUESTION 103    
**

A user has created a snapshot of an EBS volume. Which of the below mentioned usage cases is

not possible with respect to a snapshot?

A. Mirroring the volume from one AZ to another AZ

B. Launch an instance

C. Decrease the volume size

D. Increase the size of the volume

**Answer: C    
**

**Explanation:    
**

The EBS snapshots are a point in time backup of the volume. It is helpful to move the volume

from one AZ to another or launch a new instance. The user can increase the size of the volume

but cannot decrease it less than the original snapshot size.

[http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSSnapshots.html](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSSnapshots.html)

---

QUESTION 104

True or False: AWS CloudFormation allows you to create Microsoft Windows stacks.

A. False, AWS CloudFormation does not support Microsoft Windows.

B. False, Amazon doesn't support Microsoft Windows.

C. False, you cannot create Windows stacks.

D. True

**Answer: D    
**

**Explanation:    
**

AWS CloudFormation allows you to create Microsoft Windows stacks based on Amazon EC2

Windows Amazon Machine Images \(AMIs\) and provides you with the ability to install software, to

use remote desktop to access your stack, and to update and configure your stack.

[http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/cfn-windows-stacks.html](http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/cfn-windows-stacks.html)

---

**QUESTION 105    
**

Which of the following solutions is not supported by DynamoDB:

A. Hash secondary index

B. Local secondary index

C. Hash Primary Key

D. Global secondary index

**Answer: A    
**

**Explanation:    
**

In DynamoDB, a secondary index is a data structure that contains a subset of attributes from a

table, along with an alternate key to support Query operations. DynamoDB supports the following

two types of secondary indexes:

Local secondary index is an index that has the same hash key as the table, but a different range

key. A local secondary index is "local" in the sense that every partition of a local secondary index

is scoped to a table partition that has the same hash key.

Global secondary index is an index with a hash and range key that can be different from those on

the table. A global secondary index is considered "global" because queries on the index can span

all of the data in a table, across all partitions.

[http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataModel.html](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataModel.html)

---

**QUESTION 106    
**

An ELB is diverting traffic across 5 instances. One of the instances was unhealthy only for 20

minutes. What will happen after 20 minutes when the instance becomes healthy?

A. ELB will never divert traffic back to the same instance

B. ELB will not automatically send traffic to the same instance. However, the user can configure to

start sending traffic to the same instance

C. ELB starts sending traffic to the instance once it is healthy

D. ELB terminates the instance once it is unhealthy. Thus, the instance cannot be healthy after 10

minutes

**Answer: C    
**

**Explanation:    
**

AWS Elastic Load Balancing continuously checks the health of an instance. If one of the

instances is unhealthy it stops sending traffic to it and automatically reroutes the traffic to the

remaining running EC2 instances. If the failed EC2 instance is restored, Elastic Load Balancing

will again start sending traffic to that instance.

[http://docs.aws.amazon.com/ElasticLoadBalancing/latest/DeveloperGuide/SvcIntro.html    
](http://docs.aws.amazon.com/ElasticLoadBalancing/latest/DeveloperGuide/SvcIntro.html)

---

**QUESTION 107    
**

An organization has created an application which is hosted on the AWS EC2 instance. The

application stores images to S3 when the end user uploads to it. The organization does not want

to store the AWS secure credentials required to access the S3 inside the instance. Which of the

below mentioned options is a possible solution to avoid any security threat?

A. Use the IAM role and assign it to the instance.

B. Since the application is hosted on EC2, it does not need credentials to access S3.

C. Use the X.509 certificates instead of the access and the secret access keys.

D. Use the IAM based single sign between the AWS resources and the organization application.

**Answer: A    
**

**Explanation:    
**

The AWS IAM role uses temporary security credentials to access AWS services. Once the role is

assigned to an instance, it will not need any security credentials to be stored on the instance.

[http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/iam-roles-for-amazon-ec2.html    
](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/iam-roles-for-amazon-ec2.html)

---

**QUESTION 108    
**

When a user is launching an instance with EC2, which of the below mentioned options is not

available during the instance launch console for a key pair?

A. Proceed without the key pair

B. Upload a new key pair

C. Select an existing key pair

D. Create a new key pair

**Answer: B    
**

**Explanation:    
**

While launching an EC2 instance, the user can create a new key pair, select an existing key pair

or proceed without a key pair. The user cannot upload a new key pair in the EC2 instance launch

console.

[http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/launching-instance.html    
](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/launching-instance.html)

---

**QUESTION 109    
**

Which OS does the current version of AWS Elastic Beanstalk use?

A. Amazon Linux AMI, Windows Server 2003 R2 AMI or the Windows Server 2008 R2 AMI

B. Amazon Linux AMI only

C. Amazon Linux AMI or the Windows Server 2008 R2 AMI

D. Windows Server 2008 R2 AMI only

**Answer: C    
**

**Explanation:    
**

The current version of AWS Elastic Beanstalk uses the Amazon Linux AMI or the Windows

Server 2008 R2 AMI.

[https://aws.amazon.com/elasticbeanstalk/faqs/](https://aws.amazon.com/elasticbeanstalk/faqs/)

---

**QUESTION 110    
**

A user is creating an EBS volume. He asks for your advice. Which advice mentioned below

should you not give to the user for creating an EBS volume?

A. Take the snapshot of the volume when the instance is stopped

B. Stripe multiple volumes attached to the same instance

C. Create an AMI from the attached volume

D. Attach multiple volumes to the same instance

**Answer: C    
**

**Explanation:    
**

When a user creates an EBS volume, the user can attach it to a running instance. The user can

attach multiple volumes to the same instance and stripe them together to increase the I/O. The

user can take a snapshot from the existing volume but cannot create an AMI from the volume.

However, the user can create an AMI from a snapshot.

[http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSVolumes.html](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSVolumes.html)

---

**QUESTION 111**

AWS Elastic Beanstalk stores your application files and optionally server log files in\_\_\_\_\_\_\_\_\_.

A. Amazon Storage Gateway

B. Amazon Glacier

C. Amazon EC2

D. Amazon S3

**Answer: D**

**Explanation:**

AWS Elastic Beanstalk stores your application files and optionally server log files in Amazon S3.

If you are using the AWS Management Console, Git, the AWS Toolkit for Visual Studio, or AWS

Toolkit for Eclipse, an Amazon S3 bucket will be created in your account for you and the files you

upload will be automatically copied from your local client to Amazon S3. Optionally, you may

configure Elastic Beanstalk to copy your server log files every hour to Amazon S3. You do this by

editing the environment configuration settings.

[http://docs.aws.amazon.com/elasticbeanstalk/latest/dg/AWSHowTo.html](http://docs.aws.amazon.com/elasticbeanstalk/latest/dg/AWSHowTo.html)

---

**QUESTION 112**

The AWS console for DynamoDB enables you to do all the following operations, except:

A. Set up alarms to monitor your table's capacity usage.

B. Create, update, and delete tables.

C. Import Data from other databases or from files.

D. View your table's top monitoring metrics on real-time graphs from CloudWatch.

**Answer: C**

**Explanation:**

The AWS console for DynamoDB enables you to do all the above operation but not Importing

Data from other databases or from files and it is not possible to do it.

[http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ConsoleDynamoDB.html](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ConsoleDynamoDB.html)

---

**QUESTION 113**

An organization has created multiple components of a single application for

compartmentalization. Currently all the components are hosted on a single EC2 instance. Due to

security reasons the organization wants to implement two separate SSLs for the separate

modules although it is already using VPC. How can the organization achieve this with a single

instance?

A. Create a VPC instance which will have both the ACL and the security group attached to it and

have separate rules for each IP address.

B. Create a VPC instance which will have multiple network interfaces with multiple elastic IP

addresses.

C. You have to launch two instances each in a separate subnet and allow VPC peering for a single

IP.

D. Create a VPC instance which will have multiple subnets attached to it and each will have a

separate IP address.

**Answer: B**

**Explanation:**

A Virtual Private Cloud \(VPC\) is a virtual network dedicated to the user's AWS account. It enables

the user to launch AWS resources into a virtual network that the user has defined. With VPC the

user can specify multiple private IP addresses for his instances. The number of network

interfaces and private IP addresses that a user can specify for an instance depends on the

instance type. With each network interface the organization can assign an EIP. This scenario

helps when the user wants to host multiple websites on a single EC2 instance by using multiple

SSL certificates on a single server and associating each certificate with a specific EIP address. It

also helps in scenarios for operating network appliances, such as firewalls or load balancers that

have multiple private IP addresses for each network interface.

[http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/MultipleIP.html](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/MultipleIP.html)

---

**QUESTION 114**

In regards to VPC, select the correct statement:

A. You can associate multiple subnets with the same Route Table.

B. You can associate multiple subnets with the same Route Table, but you can't associate a

subnet with only one Route Table.

C. You can't associate multiple subnets with the same Route Table.

D. None of these.

**Answer: A**

**Explanation:**

Every subnet in your VPC must be associated with exactly one Route Table.

However, multiple subnets can be associated with the same Route Table.

[http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC\_Route\_Tables.html](http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_Route_Tables.html)

---

**QUESTION 115**

Which of the following device names is reserved for the root device for Linux instances of

Amazon EC2?

A. /dev/sda1

B. /dev/sd\[b-e\]

C. xvd\[a-e\]

D. /dev/sd\[f-p\]\[1-6\]

**Answer: A**

**Explanation:**

/dev/sda1 is the name of the device reserved for the root device for Linux instances.

[http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/device\_naming.html](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/device_naming.html)

---

**QUESTION 116**

A user has hosted a website on AWS and uses ELB to load balance the multiple instances.

The user application does not have any cookie management.

How can the user bind the session of the requestor with a particular instance?

A. Bind the IP address with a sticky cookie

B. Create a cookie at the application level to set at ELB

C. Use session synchronization with ELB

D. Let ELB generate a cookie for a specified duration

**Answer: D**

**Explanation:**

The key to manage the sticky session is determining how long the load balancer should route the

user's request to the same application instance. If the application has its own session cookie,

then the user can set the Elastic Load Balancing to create the session cookie to follow the

duration specified by the application's session cookie. If the user's application does not have its

own session cookie, then he can set the Elastic Load Balancing to create a session cookie by

specifying his own stickiness duration.

---

**QUESTION 117**

Your supervisor has asked you to build a simple file synchronization service for your department.

He doesn't want to spend too much money and he wants to be notified of any changes to files by

email. What do you think would be the best Amazon service to use for the email solution?

A. Amazon CloudSearch

B. Amazon Elastic Transcoder

C. Amazon SES

D. Amazon AppStream

**Answer: C**

**Explanation:**

File change notifications can be sent via email to users following the resource with Amazon

Simple Email Service \(Amazon SES\), an easy-to-use, cost-effective email solution.

[http://media.amazonwebservices.com/architecturecenter/AWS\_ac\_ra\_filesync\_08.pdf](http://media.amazonwebservices.com/architecturecenter/AWS_ac_ra_filesync_08.pdf)

---

**QUESTION 118**

ExamKiller has three AWS accounts. They have created separate IAM users within each account.

ExamKiller wants a single IAM console URL such as

https://examkiller.signin.aws.amazon.com/console/ for all account users. How can this be

achieved?

A. Merge all the accounts with consolidated billing

B. Create the same account alias with each account ID

C. It is not possible to have the same IAM account login URL for separate AWS accounts

D. Create the S3 bucket with an alias name and use the redirect rule to forward requests to

various accounts

**Answer: C**

**Explanation:**

If a user wants the URL of the AWS IAM sign-in page to have a company name instead of the

AWS account ID, he can create an alias for his AWS account ID. The alias should be unique.

[http://docs.aws.amazon.com/IAM/latest/UserGuide/AccountAlias.html](http://docs.aws.amazon.com/IAM/latest/UserGuide/AccountAlias.html)

---

**QUESTION 119**

A user has enabled automated backup for an RDS instance. What is the longest duration for

which the user can retain the automated backup?

A. 25 days

B. 15 days

C. 45 days

D. 35 days

**Answer: D**

**Explanation:**

Amazon RDS provides two different methods for backing up and restoring the Amazon DB

instances:

automated backups and DB snapshots. Automated backups automatically back up the DB

instance during a specific, user-definable backup window, and keep the backups for a limited,

user-specified period of time. The maximum period can be 35 days.

---

**QUESTION 120**

A user is enabling a static website hosting on an S3 bucket. Which of the below mentioned

parameters cannot be configured by the user?

A. Error document

B. Conditional error on object name

C. Index document

D. Conditional redirection on object name

**Answer: B**

**Explanation:**

To host a static website, the user needs to configure an Amazon S3 bucket for website hosting

and then upload the website contents to the bucket. The user can configure the index, error

document as well as configure the conditional routing of on object name.

[http://docs.aws.amazon.com/AmazonS3/latest/dev/HowDoIWebsiteConfiguration.html](http://docs.aws.amazon.com/AmazonS3/latest/dev/HowDoIWebsiteConfiguration.html)

---



