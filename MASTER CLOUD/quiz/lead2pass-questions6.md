**QUESTION 216                    
**

What type of block cipher does Amazon S3 offer for server side encryption?

A. Triple DES

B. Advanced Encryption Standard

C. Blowfish

D. RC5

**Answer: B**

---

**QUESTION 217**

A user has setup an application on EC2 which uses the IAM user access key and secret access

key to make secure calls to S3. The user wants to temporarily stop the access to S3 for that IAM

user. What should the root owner do?

A. Delete the IAM user

B. Change the access key and secret access key for the users

C. Disable the access keys for the IAM user

D. Stop the instance

**Answer: C**

**Explanation:**

If the user wants to temporarily stop the access to S3 the best solution is to disable the keys.

Deleting the user will result in a loss of all the credentials and the app will not be useful in the

future. If the user stops the instance IAM users can still access S3. The change of the key does

not help either as they are still active. The best possible solution is to disable the keys.

[http://docs.aws.amazon.com/IAM/latest/UserGuide/ManagingCredentials.html](http://docs.aws.amazon.com/IAM/latest/UserGuide/ManagingCredentials.html)

---

**QUESTION 218**

When should a user try to Force Detach an EBS volume?

A. If the volume is stuck in a detaching state

B. If the volume is not accessible from the instance

C. If the volume is not unmounted and the user still wants to detach

D. If the volume is a root volume

**Answer: A**

**Explanation:**

If an EBS volume stays in the detaching state, the user can force the detachment by clicking

Force Detach. Forcing the detachment can lead to either data loss or a corrupted file system.

The user should use this option only as a last resort to detach a volume from a failed instance or

if he is detaching a volume with the intention of deleting it.

[http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-detaching-volume.html](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-detaching-volume.html)

---

QUESTION 219

How can a user configure three termination policies for the AutoScaling group?

A. Define multiple policies in random order

B. Define multiple policies in the ordered list

C. Keep updating the AutoScaling group with each policy

D. The user cannot specify more than two policies for AutoScaling

**Answer: B**

**Explanation:**

To configure the Auto Scaling termination policy, the user can either specify any one of the

policies as a standalone policy or list multiple policies in an ordered list.

The policies are executed in the order that they are listed.

[http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/us-termination-policy.html](http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/us-termination-policy.html)

**QUESTION 220**

A user wants to configure AutoScaling which scales up when the CPU utilization is above 70%

and scales down when the CPU utilization is below 30%. How can the user configure AutoScaling

for the above mentioned condition?

A. Use AutoScaling with a schedule

B. Configure ELB to notify AutoScaling on load increase or decrease

C. Use dynamic AutoScaling with a policy

D. Use AutoScaling by manually modifying the desired capacity during a condition

**Answer: C**

**Explanation:**

The user can configure the AutoScaling group to automatically scale up and then scale down

based on the specified conditions. To configure this, the user must setup policies which will get

triggered by the CloudWatch alarms.

[http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/as-scale-based-on-demand.html](http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/as-scale-based-on-demand.html)

---

**QUESTION 221**

A user has created an application which sends data to a log file. The server hosting the log files

can be unavailable due to any reason. The user wants to make it so that whenever the log server

is up it should be receiving the messages. Which of the below mentioned AWS services helps

achieve this functionality?

A. AWS Simple Workflow

B. AWS Simple Task Service

C. AWS Simple Notification Service

D. AWS Simple Queue Service

**Answer: D**

**Explanation:**

Amazon Simple Queue Service \(SQS\) is a fast, reliable, scalable, and fully managed message

queuing service. SQS provides a simple and cost-effective way to decouple the components of

an application. The user can use SQS to transmit any volume of data without losing messages or

requiring other services to always be available. Using SQS, the application has to just send the

data to SQS and SQS transmits it to the log file whenever it is available.

[http://aws.amazon.com/sqs/](http://aws.amazon.com/sqs/)

---

**QUESTION 222**

Is there a limit to how much throughput you can get out of a single table in DynamoDB?

A. Yes, not more than 1,000 writes/second or 1,000 reads/second

B. No

C. Yes, not more than 10,000 writes/second or 10,000 reads/second

D. No, but If you wish to exceed throughput rates of 10,000 writes/second or 10,000 reads/second,

you must first contact AWS.

**Answer: D**

**Explanation:**

In DynamoDB, you can increase the throughput you have provisioned for your table using

UpdateTable API or in the AWS Management Console. If you wish to exceed throughput rates of

10,000 writes/second or 10,000 reads/second, you must first contact AWS.

[http://aws.amazon.com/dynamodb/](http://aws.amazon.com/dynamodb/)

---

**QUESTION 223**

In AWS Elastic Beanstalk, you can update your deployed application even while it is part of a

running environment. For a Java application, you can also use \_\_\_\_\_\_\_\_\_\_\_ to update your

deployed application.

A. the AWS Toolkit for Eclipse

B. the AWS Toolkit for Visual Studio

C. the AWS Toolkit for JVM

D. the AWS Toolkit for Netbeans

**Answer: A**

**Explanation:**

In AWS Elastic Beanstalk, you can update your deployed application, even while it is part of a

running environment. For a Java application, you can also use the AWS Toolkit for Eclipse to

update your deployed application.

[http://docs.aws.amazon.com/elasticbeanstalk/latest/dg/GettingStarted.Walkthrough.html](http://docs.aws.amazon.com/elasticbeanstalk/latest/dg/GettingStarted.Walkthrough.html)

**QUESTION 224**

You have a number of image files to encode. In an Amazon SQS worker queue, you create an

Amazon SQS message for each file specifying the command \(jpeg-encode\) and the location of

the file in Amazon S3. Which of the following statements best describes the functionality of

Amazon SQS?

A. Amazon SQS is for single-threaded sending or receiving speeds.

B. Amazon SQS is a non-distributed queuing system.

C. Amazon SQS is a distributed queuing system that is optimized for horizontal scalability, not for

single-threaded sending or receiving speeds.

D. Amazon SQS is a distributed queuing system that is optimized for vertical scalability and for

single-threaded sending or receiving speeds.

**Answer: C**

**Explanation:**

Amazon SQS is a distributed queuing system that is optimized for horizontal scalability, not for

single-threaded sending or receiving speeds. A single client can send or receive Amazon SQS

messages at a rate of about 5 to 50 messages per second. Higher receive performance can be

achieved by requesting multiple messages \(up to 10\) in a single call. It may take several seconds

before a message that has been to a queue is available to be received.

[http://media.amazonwebservices.com/AWS\_Storage\_Options.pdf](http://media.amazonwebservices.com/AWS_Storage_Options.pdf)

**QUESTION 225**

Can you configure an RDS Read Replica using CloudFormation templates?

A. Yes, provided that you have root access.

B. Yes, when you create a new CloudFormation template

C. Yes, but not for all Regions.

D. No, you can add the ReadReplica only when the resource is made available by CloudFormation

**Answer: B**

**Explanation:**

AWS CloudFormation gives developers and systems administrators an easy way to create and

manage collections of AWS resources. You can now set Read Replicas for your databases with

RDS when you create a new CloudFormation template.

You can start using it with the sample template of CloudFormation.

**QUESTION 226**

A user is creating an ELB with VPC. Which of the following options is available as a part of the

"Add EC2 instances" page?

A. Select Subnet

B. Select IAM

C. Select ENI

D. Select VPC

**Answer: A**

**Explanation:**

When a user is launching an ELB with VPC, he/she has to select the options, such as subnet and

security group before selecting the instances part of that subnet.

[http://docs.aws.amazon.com/ElasticLoadBalancing/latest/DeveloperGuide/elb-getting-started.html](http://docs.aws.amazon.com/ElasticLoadBalancing/latest/DeveloperGuide/elb-getting-started.html)

**QUESTION 227**

A user has setup Multi AZ with the MS SQL RDS instance.

Which of the below mentioned functionalities can be achieved by the user?

A. High availability

B. Scalability

C. MS SQL does not support Multi AZ

D. Disaster recovery

**Answer: C**

**Explanation:**

The Multi AZ feature allows the user to achieve High Availability.

MS SQL does not support Multi AZ.

[https://aws.amazon.com/rds/faqs/\#36](https://aws.amazon.com/rds/faqs/#36)

**QUESTION 228**

An organization is having an application which can start and stop an EC2 instance as per

schedule. The organization needs the MAC address of the instance to be registered with its

software. The instance is launched in EC2-CLASSIC.

How can the organization update the MAC registration every time an instance is booted?

A. The instance MAC address never changes.

Thus, it is not required to register the MAC address every time.

B. The organization should write a boot strapping script which will get the MAC address from the

instance metadata and use that script to register with the application.

C. AWS never provides a MAC address to an instance; instead the instance ID is used for

identifying the instance for any software registration.

D. The organization should provide a MAC address as a part of the user data. Thus, whenever the

instance is booted the script assigns the fixed MAC address to that instance.

**Answer: B**

**Explanation:**

AWS provides an on demand, scalable infrastructure. AWS EC2 allows the user to launch OnDemand

instances. AWS does not provide a fixed MAC address to the instances launched in

EC2-CLASSIC. If the instance is launched as a part of EC2-VPC, it can have an ENI which can

have a fixed MAC. However, with EC2-CLASSIC, every time the instance is started or stopped it

will have a new MAC address. To get this MAC, the organization can run a script on boot which

can fetch the instance metadata and get the MAC address from that instance metadata.

Once the MAC is received, the organization can register that MAC with the software.

[http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/AESDG-chapter-instancedata.html](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/AESDG-chapter-instancedata.html)

**QUESTION 229**

A user is trying to share a video file with all his friends. Which of the below mentioned AWS

services will be cheapest and easy to use?

A. AWS S3

B. AWS EC2

C. AWS RRS

D. AWS Glacier

**Answer: C**

**Explanation:**

AWS RRS provides the same functionality as AWS S3, but at a cheaper rate. It is ideally suited

for non mission critical applications. It provides less durability than S3, but is a cheaper option.

[http://docs.aws.amazon.com/AmazonS3/latest/dev/UsingRRS.html](http://docs.aws.amazon.com/AmazonS3/latest/dev/UsingRRS.html)

**QUESTION 230**

A user has configured ELB. Which of the below mentioned protocols the user can configure for

ELB health checks while setting up ELB?

A. All of the options

B. TCP

C. HTTPS

D. SSL

**Answer: A**

**Explanation:**

An ELB performs a health check on its instances to ensure that it diverts traffic only to healthy

instances. The ELB can perform a health check on HTTP, HTTPS, TCP and SSL protocols.

[http://docs.aws.amazon.com/ElasticLoadBalancing/latest/DeveloperGuide/Welcome.html](http://docs.aws.amazon.com/ElasticLoadBalancing/latest/DeveloperGuide/Welcome.html)

**QUESTION 231**

Is it possible to create an S3 bucket accessible only by a certain IAM user, using policies in a

CloudFormation template?

A. No, you can only create the S3 bucket but not the IAM user.

B. S3 is not supported by CloudFormation.

C. Yes, all these resources can be created using a CloudFormation template

D. No, in the same template you can only create the S3 bucket and the realtive policy.

**Answer: C**

**Explanation:**

With AWS Identity and Access Management \(IAM\), you can create IAM users to control who has

access to which resources in your AWS account.

You can use IAM with AWS CloudFormation to control what AWS CloudFormation actions users

can perform, such as view stack templates, create stacks, or delete stacks.

In addition to AWS CloudFormation actions, you can manage what AWS services and resources

are available to each user.

**QUESTION 232**

A user has created an EBS instance in the US-East-1a AZ. The user has a volume of 30 GB in

the US-East-1b zone. How can the user attach the volume to an instance?

A. Since both the volume and the instance are in the same region, the user can attach the volume

B. Use the volume migrate function to move the volume from one AZ to another and attach to the

instance

C. Take a snapshot of the volume. Create a new volume in the USEast-1a and attach that to the

instance

D. Use the volume replicate function to create a new volume in the US-East-1a and attach that to

the volume

**Answer: C**

**Explanation:**

If an EBS volume is not in the same AZ of an EC2 instance, it cannot be attached to the instance.

The only option is to take a snapshot of the volume and create a new volume in the instance's

AZ. [http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSSnapshots.html](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSSnapshots.html)

**QUESTION 233**

A user is part of a group which has a policy allowing him just read only access to EC2. The user

is part of another group which has full access to EC2. What happens when the user tries to

launch an instance?

A. It will allow the user to launch the instance

B. It will fail since the user has just read only access

C. It will allow or deny based on the group under which the user has logged into EC2

D. It will not allow the user to add to the conflicting groups

**Answer: A**

**Explanation:**

The IAM group policy is always aggregated. In this case, if the user does not have permission for

one group, but has permission for another group, he will have full access to EC2.

Unless there is specific deny policy, the user will be able to access EC2.

[http://docs.aws.amazon.com/IAM/latest/UserGuide/PoliciesOverview.html](http://docs.aws.amazon.com/IAM/latest/UserGuide/PoliciesOverview.html)

**QUESTION 234**

A user has launched an RDS instance. The user has created 3 databases on the same server.

What can the maximum size be for each database?

A. The size of each DB cannot be more than 3 TB

B. It is not possible to have more than one DB on a single instance

C. The total instance storage size cannot be more than 3 TB

D. The size of each DB cannot be more than 1 TB

**Answer: C**

**Explanation:**

The AWS RDS DB instance is an isolated DB environment provided by AWS in which the user

can create more than 1 database. The maximum size of the instance should be between 5 GB

and 3 TB. The size of each DB can be anything in this range.

[http://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Welcome.html](http://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Welcome.html)

**QUESTION 235**

A user has created an RDS instance with MySQL. The user is using the HeidiSQL client to

connect with the RDS DB. The client is unable to connect to DB from his home machine. What is

a possible reason for the failure?

A. The user has to open port 80 in the RDS security group to connect with RDS DNS

B. The security group is not configured to allow a request from the user's IP on port 3306

C. You can never connect to RDS from your desktop

D. The user has to open port 22 in the RDS security group to connect with RDS DNS

**Answer: B**

**Explanation:**

If the user needs to connect to RDS then he has to open port 3306 in the RDS security group for

his IP address.

[http://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Welcome.html](http://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Welcome.html)

**QUESTION 236**

A user is creating a new EBS volume from an existing snapshot. The snapshot size shows 10

GB. Can the user create a volume of 30 GB from that snapshot?

A. Provided the original volume has set the change size attribute to true

B. Yes

C. Provided the snapshot has the modify size attribute set as true

D. No

**Answer: B**

**Explanation:**

A user can always create a new EBS volume of a higher size than the original snapshot size.

The user cannot create a volume of a lower size. When the new volume is created the size in the

instance will be shown as the original size. The user needs to change the size of the device with

resize2fs or other OS specific commands.

[http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-expand-volume.html](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-expand-volume.html)

**QUESTION 237**

An organization has 10000 employees. The organization wants to give restricted AWS access to

each employee. How can the organization achieve this?

A. Create an IAM user for each employee and make them a part of the group

B. It is not recommended to support 10000 users with IAM

C. Use STS and create the users' run time

D. Use Identity federation with SSO

**Answer: D**

**Explanation:**

Identity federation enables users from an existing directory to access resources within your AWS

account, making it easier to manage your users by maintaining their identities in a single place.

In this case, the federated user is the only solution since AWS does not allow creating more than

5000 IAM users.

[http://docs.aws.amazon.com/IAM/latest/UserGuide/LimitationsOnEntities.html](http://docs.aws.amazon.com/IAM/latest/UserGuide/LimitationsOnEntities.html)

**QUESTION 238**

In Amazon SNS, to send push notifications to mobile devices using Amazon SNS and ADM, you

need to obtain the following, except:

A. Client secret

B. Client ID

C. Device token

D. Registration ID

**Answer: C**

**Explanation:**

To send push notifications to mobile devices using Amazon SNS and ADM, you need to obtain

the following: Registration ID and Client secret.

[http://docs.aws.amazon.com/sns/latest/dg/SNSMobilePushPrereq.html](http://docs.aws.amazon.com/sns/latest/dg/SNSMobilePushPrereq.html)

**QUESTION 239**

Regarding Amazon SNS, to begin using Amazon SNS mobile push notifications, you first need

\_\_\_\_\_\_\_\_\_\_that uses one of the supported push notification services: APNS, GCM, or ADM.

A. an access policy for the mobile endpoints

B. to active push notification service of Amazon SNS

C. to know the type of mobile device operating system

D. an app for the mobile endpoints

**Answer: D**

**Explanation:**

In Amazon SNS, to begin using Amazon SNS mobile push notifications, you first need an app for

the mobile endpoints that uses one of the supported push notification services: APNS, GCM, or

ADM. After you've registered and configured the app to use one of these services, you configure

Amazon SNS to send push notifications to the mobile endpoints.

[http://docs.aws.amazon.com/sns/latest/dg/SNSMobilePush.html](http://docs.aws.amazon.com/sns/latest/dg/SNSMobilePush.html)

**QUESTION 240**

How many types of block devices does Amazon EC2 support?

A. 5

B. 1

C. 2

D. 4

**Answer: C**

**Explanation:**

Amazon EC2 supports 2 types of block devices.

**QUESTION 241**

ExamKiller \(with AWS account ID 111122223333\) has created 50 IAM users for its organization's

employees. ExamKiller wants to make the AWS console login URL for all IAM users as: https://

examkiller.signin.aws.amazon.com/console/. How can this be configured?

A. Create a bucket with the name ExamKiller and map it with the IAM alias

B. It is not possible to have capital letters as a part of the alias name

C. The user needs to use Route 53 to map the ExamKiller domain and IAM URL

D. For the AWS account, create an alias ExamKiller for the IAM login

**Answer: B**

**Explanation:**

If a user wants the URL of the AWS IAM sign-in page to have the company name instead of the

AWS account ID, he can create an alias for his AWS account ID. The alias must be unique

across all Amazon Webservices products and contain only digits, lowercase letters, and hyphens.

[http://docs.aws.amazon.com/IAM/latest/UserGuide/AccountAlias.html](http://docs.aws.amazon.com/IAM/latest/UserGuide/AccountAlias.html)

**QUESTION 242**

Can a user get a notification of each instance start / terminate configured with Auto Scaling?

A. Yes, always

B. No

C. Yes, if configured with the Auto Scaling group

D. Yes, if configured with the Launch Config

**Answer: C**

**Explanation:**

The user can get notifications using SNS if he has configured the notifications while creating the

Auto Scaling group.

[http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/GettingStartedTutorial.html](http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/GettingStartedTutorial.html)

**QUESTION 243**

AutoScaling is configured with 3 AZs. Each zone has 5 instances running. If AutoScaling wants to

terminate an instance based on the policy action, which instance will it terminate first?

A. Terminate the first launched instance

B. Randomly select the instance for termination

C. Terminate the instance from the AZ which does not have a high AWS load

D. Terminate the instance from the AZ which has instances running near to the billing hour

**Answer: B**

**Explanation:**

Before Auto Scaling selects an instance to terminate, it first identifies the Availability Zone that

has more instances than the other Availability Zones used by the group. If all the Availability

Zones have the same number of instances, it identifies a random Availability Zone.

[http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/us-termination-policy.html](http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/us-termination-policy.html)

**QUESTION 244**

In regard to DynamoDB, can I delete local secondary indexes?

A. Yes, if it is a primary hash key index

B. No

C. Yes, if it is a local secondary indexes

D. Yes, if it is a Global secondary indexes

**Answer: B**

**Explanation:**

In DynamoDB, an index cannot be modified once it is created.

[http://aws.amazon.com/dynamodb/faqs/\#security\_anchor](http://aws.amazon.com/dynamodb/faqs/#security_anchor)

**QUESTION 245**

You need to develop and run some new applications on AWS and you know that Elastic

Beanstalk and CloudFormation can both help as a deployment mechanism for a broad range of

AWS resources. Which of the following statements best describes the differences between

Elastic Beanstalk and CloudFormation?

A. Elastic Beanstalk uses Elastic load balancing and CloudFormation doesn't.

B. CloudFormation is faster in deploying applications than Elastic Beanstalk.

C. CloudFormation is much more powerful than Elastic Beanstalk, because you can actually

design and script custom resources

D. Elastic Beanstalk is faster in deploying applications than CloudFormation.

**Answer: C**

**Explanation:**

These services are designed to complement each other. AWS Elastic Beanstalk provides an

environment to easily develop and run applications in the cloud. It is integrated with developer

tools and provides a one-stop experience for you to manage the lifecycle of your applications.

AWS CloudFormation is a convenient deployment mechanism for a broad range of AWS

resources. It supports the infrastructure needs of many different types of applications such as

existing enterprise applications, legacy applications, applications built using a variety of AWS

resources and container-based solutions \(including those built using AWS Elastic Beanstalk\).

AWS CloudFormation introduces two new concepts: The template, a JSON-format, text-based file

that describes all the AWS resources you need to deploy to run your application and the stack,

the set of AWS resources that are created and managed as a single unit when AWS

CloudFormation instantiates a template.

[http://aws.amazon.com/cloudformation/faqs/](http://aws.amazon.com/cloudformation/faqs/)

**QUESTION 246**

Can you SSH to your private machines that reside in a VPC from outside without elastic IP?

A. Yes, but only if you have direct connect or vpn

B. Only if you are using a non-US region

C. Only if you are using a US region

D. No

**Answer: A**

**Explanation:**

The instances that reside in the private subnets of your VPC are not reachable from the Internet,

meaning that is not possible to ssh into them. To interact with them you can use a bastion server,

located in a public subnet, that will act as a proxy for them.

You can also connect if you have direct connect or vpn.

[http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC\_Scenario2.html](http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_Scenario2.html)

**QUESTION 247**

Does AWS CloudFormation support Amazon EC2 tagging?

A. It depends if the Amazon EC2 tagging has been defined in the template.

B. No, it doesn't support Amazon EC2 tagging.

C. No, CloudFormation doesn't support any tagging

D. Yes, AWS CloudFormation supports Amazon EC2 tagging

**Answer: D**

**Explanation:**

In AWS CloudFormation, Amazon EC2 resources that support the tagging feature can also be

tagged in an AWS template. The tag values can refer to template parameters, other resource

names, resource attribute values \(e.g. addresses\), or values computed by simple functions \(e.g.,

a concatenated list of strings\).

[http://aws.amazon.com/cloudformation/faqs/](http://aws.amazon.com/cloudformation/faqs/)

**QUESTION 248**

A user has created a MySQL RDS instance. Which of the below mentioned options is mandatory

to configure while creating an instance?

A. Multi AZ deployment setup

B. Automated backup window

C. Availability Zone

D. Maintenance window

**Answer: A**

**Explanation:**

When creating an RDS instance, the user needs to specify whether it is Multi AZ or not. If the

user does not provide the value for the zone, the maintenance window or automated backup

window, RDS will automatically select the value.

[http://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Concepts.MultiAZ.html](http://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Concepts.MultiAZ.html)

**QUESTION 249**

A user has enabled the automated backup, but not specified the backup window. What will RDS

do in this case?

A. Will throw an error on instance launch

B. RDS will take 3 AM ?3:30 AM as the default window

C. RDS assigns a random time period based on the region

D. Will not allow to launch a DB instance

**Answer: C**

**Explanation:**

If the user does not specify a preferred backup window while enabling an automated backup,

Amazon RDS assigns a default 30-minute backup window which is selected at random from an 8-

hour block of time per region.

**QUESTION 250**

True or False: In DynamoDB, Scan operations are always eventually consistent.

A. No, scan is like Query operation

B. Yes

C. No, scan is strongly consistent by default

D. No, you can optionally request strongly consistent scan.

**Answer: B**

**Explanation:**

In DynamoDB, Scan operations are always eventually consistent.

[http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/APISummary.html](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/APISummary.html)

**QUESTION 251**

Regarding Amazon SNS, when you want to subscribe to a topic and receive notifications to your

email, in the Protocol drop-down box, you should select \_\_\_\_\_\_\_.

A. Email

B. Message

C. SMTP

D. IMAP

**Answer: A**

**Explanation:**

In Amazon SNS, when you want to subscribe to a topic and receive notifications to your email,

select Email in the Protocol drop-down box. Enter an email address you can use to receive the

notification in the Endpoint field.

[http://docs.aws.amazon.com/sns/latest/dg/SubscribeTopic.html](http://docs.aws.amazon.com/sns/latest/dg/SubscribeTopic.html)

**QUESTION 252**

When a user is detaching an EBS volume from a running instance and attaching it to a new

instance, which of the below mentioned options should be followed to avoid file system damage?

A. Unmount the volume first

B. Stop all the I/O of the volume before processing

C. Take a snapshot of the volume before detaching

D. Force Detach the volume to ensure that all the data stays intact

**Answer: A**

**Explanation:**

When a user is trying to detach an EBS volume, the user can either terminate the instance or

explicitly remove the volume. It is a recommended practice to unmount the volume first to avoid

any file system damage.

[http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-detaching-volume.html](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-detaching-volume.html)

**QUESTION 253**

A user is planning to host a scalable dynamic web application on AWS. Which of the services

may not be required by the user to achieve automated scalability?

A. CloudWatch

B. S3

C. AutoScaling

D. AWS EC2 instances

**Answer: B**

**Explanation:**

The user can achieve automated scaling by launching different EC2 instances and making them

a part of an ELB. Cloudwatch will be used to monitor the resources and based on the scaling

need it will trigger policies. AutoScaling is then used to scale up or down the instances.

[http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/WhatIsAutoScaling.html](http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/WhatIsAutoScaling.html)

**QUESTION 254**

Which one of the following data types does Amazon DynamoDB not support?

A. Arrays

B. String

C. Binary

D. Number Set

**Answer: A**

**Explanation:**

Amazon DynamoDB supports the following data types:

Scalar data types \(like Number, String, and Binary\)

Multi-valued types \(like String Set, Number Set, and Binary Set\).

**QUESTION 255**

Regarding Amazon SNS, you can send notification messages to mobile devices through any of

the following supported push notification services, EXCEPT:

A. Google Cloud Messaging for Android \(GCM\)

B. Apple Push Notification Service \(APNS\)

C. Amazon Device Messaging \(ADM\)

D. Microsoft Windows Mobile Messaging \(MWMM\)

**Answer: D**

**Explanation:**

In Amazon SNS, you have the ability to send notification messages directly to apps on mobile

devices. Notification messages sent to a mobile endpoint can appear in the mobile app as

message alerts, badge updates, or even sound alerts. Microsoft Windows Mobile Messaging

\(MWMM\) doesn't exist and is not supported by Amazon SNS.

[http://docs.aws.amazon.com/sns/latest/dg/SNSMobilePush.html](http://docs.aws.amazon.com/sns/latest/dg/SNSMobilePush.html)

**QUESTION 256**

How can software determine the public and private IP addresses of the Amazon EC2 instance

that it is running on?

A. Query the appropriate Amazon CloudWatch metric.

B. Use ipconfig or ifconfig command.

C. Query the local instance userdata.

D. Query the local instance metadata.

**Answer: D**

**QUESTION 257**

A corporate web application is deployed within an Amazon VPC, and is connected to the

corporate data center via IPSec VPN. The application must authenticate against the on-premise

LDAP server. Once authenticated, logged-in users can only access an S3 keyspace specific to

the user. Which two approaches can satisfy the objectives? Choose 2 answers

A. The application authenticates against LDAP. The application then calls the IAM Security

Service to login to IAM using the LDAP credentials. The application can use the IAM temporary

credentials to access the appropriate S3 bucket.

B. The application authenticates against LDAP, and retrieves the name of an IAM role associated

with the user. The application then calls the IAM Security Token Service to assume that IAM

Role. The application can use the temporary credentials to access the appropriate S3 bucket.

C. The application authenticates against IAM Security Token Service using the LDAP credentials.

The application uses those temporary AWS security credentials to access the appropriate S3

bucket.

D. Develop an identity broker which authenticates against LDAP, and then calls IAM Security

Token Service to get IAM federated user credentials. The application calls the identity broker to

get IAM federated user credentials with access to the appropriate S3 bucket.

E. Develop an identity broker which authenticates against IAM Security Token Service to assume

an IAM Role to get temporary AWS security credentials. The application calls the identity broker

to get AWS temporary security credentials with access to the appropriate S3 bucket.

**Answer: BD**

**QUESTION 258**

Which of these is not a Pseudo Parameter in AWS CloudFormation?

A. AWS::StackName

B. AWS::AccountId

C. AWS::StackArn

D. AWS::NotificationARNs

**Answer: C**

**Explanation:**

This is the complete list of Pseudo Parameters: AWS::AccountId, AWS::NotificationARNs,

AWS::NoValue, AWS::Region, AWS::StackId, AWS::StackName

[http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/pseudo-parameterreference.html          
](http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/pseudo-parameterreference)**QUESTION 259**

What is the scope of an EBS volume?

A. VPC

B. Region

C. Placement Group

D. Availability Zone

**Answer: D**

**Explanation:**

An Amazon EBS volume is tied to its Availability Zone and can be attached only to instances in

the same Availability Zone.

**QUESTION 260**

What is the scope of AWS IAM?

A. Global

B. Availability Zone

C. Region

D. Placement Group

**Answer: A**

**Explanation:**

IAM resources are all global; there is not regional constraint.

