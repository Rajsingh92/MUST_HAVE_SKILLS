**QUESTION 38        
**

Can one instance be registered with two ELBs in the same region?

A. No

B. Yes, provided both ELBs have the same health check configuration

C. Yes, always

D. Yes, provided both ELBs are in the same AZ

**Answer: C        
**

**Explanation:        
**

Yes, it is possible to have one instance part of two separate ELBs, though both ELBs have

different configurations. ELBs are never launched in specific zones.

[http://docs.aws.amazon.com/ElasticLoadBalancing/latest/DeveloperGuide/enable-disable-az.html](http://docs.aws.amazon.com/ElasticLoadBalancing/latest/DeveloperGuide/enable-disable-az.html)

---

**QUESTION 39        
**

What does Amazon SQS provide?

A. An asynchronous message queue service.

B. A Simple Query Server, managed directly by Amazon Web Services.

C. None of these.

D. A synchronous message queue service.

**Answer: A        
**

**Explanation:        
**

Amazon SQS stands for Simple Queue Services, and provides a cost-effective way to decouple

the components of your application through an asynchronous message queue service

[http://aws.amazon.com/sqs/](http://aws.amazon.com/sqs/)

---

**QUESTION 40        
**

A user is trying to create a list of IAM users with the AWS console. When the IAM users are

created which of the below mentioned credentials will be enabled by default for the user?

A. IAM access key and secret access key

B. IAM X.509 certificates

C. Nothing. Everything is disabled by default

D. IAM passwords

**Answer: C        
**

**Explanation:        
**

Newly created IAM users have no password and no access key \(access key ID and secret

access key\). If the user needs to administer your AWS resources using the AWS Management

Console, you can create a password for the user. If the user needs to interact with AWS

programmatically \(using the command line interface \(CLI\), the AWS SDK, or service-specific

APIs\), you can create an access key for that user. The credentials you create for users are what

they use to uniquely identify themselves to AWS.

[http://docs.aws.amazon.com/IAM/latest/UserGuide/Using\_WorkingWithGroupsAndUsers.html](http://docs.aws.amazon.com/IAM/latest/UserGuide/Using_WorkingWithGroupsAndUsers.html)

---

**QUESTION 41        
**

Bob is an IAM user who has access to the EC2 services. Admin is an IAM user who has access

to all the AWS services including IAM. Can Bob change his password?

A. No, the IAM user can never change the password

B. Yes, provided Admin has given Bob access to change his password

C. Yes, only from AWS CLI

D. Yes, only from the AWS console

**Answer: B        
**

**Explanation:        
**

The IAM users by default cannot change their password. The root owner or IAM administrator

needs to set the policy in the password policy page, which should allow the user to change their

password. Once it is enabled, the IAM user can always change their passwords from the AWS

console or CLI.

[http://docs.aws.amazon.com/IAM/latest/UserGuide/Using\_ManagingUserPwdSelf.html](http://docs.aws.amazon.com/IAM/latest/UserGuide/Using_ManagingUserPwdSelf.html)

---

**QUESTION 42        
**

A user has created photo editing software and hosted it on EC2. The software accepts requests

from the user about the photo format and resolution and sends a message to S3 to enhance the

picture accordingly. Which of the below mentioned AWS services will help make a scalable

software with the AWS infrastructure in this scenario?

A. AWS Elastic Transcoder

B. AWS Simple Notification Service

C. AWS Simple Queue Service

D. AWS Glacier

**Answer: C        
**

**Explanation:        
**

Amazon Simple Queue Service \(SQS\) is a fast, reliable, scalable, and fully managed message

queuing service. SQS provides a simple and cost-effective way to decouple the components of

an application. The user can configure SQS, which will decouple the call between the EC2

application and S3. Thus, the application does not keep waiting for S3 to provide the data.

[http://aws.amazon.com/sqs/faqs/](http://aws.amazon.com/sqs/faqs/)

---

**QUESTION 43      
**

A user has created a blank EBS volume in the US-East-1 region. The user is unable to attach the

volume to a running instance in the same region. What could be the possible reason for this?

A. The instance must be in a running state. It is required to stop the instance to attach volume

B. The AZ for the instance and volume are different

C. The instance is from an instance store backed AMI

D. The instance has enabled the volume attach protection

Answer: B

Explanation:

An EBS volume provides persistent data storage. The user can attach a volume to any instance

provided they are both in the same AZ. Even if they are in the same region but in a different AZ, it

will not be able to attach the volume to that instance.

[http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/AmazonEBS.html](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/AmazonEBS.html)

---

**QUESTION 44      
**

In DynamoDB, could you use IAM to grant access to Amazon DynamoDB resources and API

actions?

A. Yes

B. Depended to the type of access

C. In DynamoDB there is no need to grant access

D. No

**Answer: A      
**

**Explanation:      
**

Amazon DynamoDB integrates with AWS Identity and Access Management \(IAM\).

You can use AWS IAM to grant access to Amazon DynamoDB resources and API actions.

To do this, you first write an AWS IAM policy, which is a document that explicitly lists the

permissions you want to grant. You then attach that policy to an AWS IAM user or role.

[http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/UsingIAMWithDDB.html      
](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/UsingIAMWithDDB.html)

---

**QUESTION 45      
**

A user is planning to host a mobile game on EC2 which sends notifications to active users on

either high score or the addition of new features. The user should get this notification when he is

online on his mobile device. Which of the below mentioned AWS services can help achieve this

functionality?

A. AWS Simple Notification Service.

B. AWS Simple Queue Service.

C. AWS Mobile Communication Service.

D. AWS Simple Email Service.

**Answer: A      
**

**Explanation:      
**

Amazon Simple Notification Service \(Amazon SNS\) is a fast, flexible, and fully managed push

messaging service. Amazon SNS makes it simple and cost-effective to push to mobile devices,

such as iPhone, iPad, Android, Kindle Fire, and internet connected smart devices, as well as

pushing to other distributed services.

[http://aws.amazon.com/sns      
](http://aws.amazon.com/sns)

---

**QUESTION 46      
**

An organization is setting up their website on AWS. The organization is working on various

security measures to be performed on the AWS EC2 instances. Which of the below mentioned

security mechanisms will not help the organization to avoid future data leaks and identify security

weaknesses?

A. Perform SQL injection for application testing.

B. Run penetration testing on AWS with prior approval from Amazon.

C. Perform a hardening test on the AWS instance.

D. Perform a Code Check for any memory leaks.

**Answer: D**

**Explanation:      
**

AWS security follows the shared security model where the user is as much responsible as

Amazon. Since Amazon is a public cloud it is bound to be targeted by hackers. If an organization

is planning to host their application on AWS EC2, they should perform the below mentioned

security checks as a measure to find any security weakness/data leaks:

Perform penetration testing as performed by attackers to find any vulnerability. The organization

must take an approval from AWS before performing penetration testing Perform hardening testing

to find if there are any unnecessary ports open Perform SQL injection to find any DB security

issues

The code memory checks are generally useful when the organization wants to improve the

application performance.

[http://aws.amazon.com/security/penetration-testing/](http://aws.amazon.com/security/penetration-testing/)

---

**QUESTION 47      
**

A root account owner is trying to setup an additional level of security for all his IAM users. Which

of the below mentioned options is a recommended solution for the account owner?

A. Enable access key and secret access key for all the IAM users

B. Enable MFA for all IAM users

C. Enable the password for all the IAM users

D. Enable MFA for the root account

**Answer: B      
**

**Explanation:      
**

Multi-Factor Authentication adds an extra level of security for all the users. The user can enable

MFA for all IAM users which ensures that each user has to provide an extra six digit code for

authentication.

[http://docs.aws.amazon.com/IAM/latest/UserGuide/Using\_ManagingMFA.html](http://docs.aws.amazon.com/IAM/latest/UserGuide/Using_ManagingMFA.html)

---

**QUESTION 48    
**

Regarding Amazon SQS, what happens if there is no activity against a queue for more than 30

consecutive days?

A. Your account will be suspended

B. The queue may be deleted

C. Nothing

D. The queue will be deleted

**Answer: B    
**

**Explanation:    
**

AWS reserve the right to delete a queue if none of the following requests have been issued

against the queue for more than 30 consecutive days:

SendMessage

ReceiveMessage

DeleteMessage

GetQueueAttributes

SetQueueAttributes

You should design your application with this in mind.

[https://aws.amazon.com/sqs/faqs/](https://aws.amazon.com/sqs/faqs/)

---

QUESTION 49

Which of the below mentioned options is a must to have an element as a part of the IAM policy?

A. Condition

B. ID

C. Statement

D. Version

**Answer: C    
**

**Explanation:    
**

The statement is the main element of the IAM policy and it is a must for a policy.

Elements such as condition, version and ID are not required.

[http://docs.aws.amazon.com/IAM/latest/UserGuide/AccessPolicyLanguage\_ElementDescriptions.  
html](http://docs.aws.amazon.com/IAM/latest/UserGuide/AccessPolicyLanguage_ElementDescriptions. html)

---

**QUESTION 50    
**

Which of the below mentioned commands allows the user to share the AMI with his peers using

the AWS EC2 CLI?

A. ec2-share-image-public

B. ec2-share-image-account

C. ec2-share-image

D. ec2-modify-image-attribute

**Answer: D    
**

**Explanation:    
**

A user can share an AMI with another user / peer using the command:

ec2-modify-image-attribute &lt;AMI-ID&gt; -l -a &lt;AWS Account ID&gt;

[http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/sharingamis-explicit.html](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/sharingamis-explicit.html)

---

**QUESTION 51    
**

ExamKiller \(with AWS account ID 111122223333\) has created 50 IAM users for its organization's

employees. ExamKiller wants to make the AWS console login URL for all IAM users like:

[https://examkiller.signin.aws.amazon.com/console/](https://examkiller.signin.aws.amazon.com/console/). How can this be configured?

A. The user needs to use Route 53 to map the examkiller domain and IAM URL

B. Create an IAM AWS account alias with the name examkiller

C. It is not possible to have a personalized IAM login URL

D. Create an IAM hosted zone Identity for the domain examkiller

Answer: B

Explanation:

If a user wants the URL of the AWS IAM sign-in page to have a company name instead of the

AWS account ID, he can create an alias for his AWS account ID.

[http://docs.aws.amazon.com/IAM/latest/UserGuide/AccountAlias.html](http://docs.aws.amazon.com/IAM/latest/UserGuide/AccountAlias.html)

---

**QUESTION 52    
**

A user has created a new EBS volume from an existing snapshot.

The user mounts the volume on the instance to which it is attached.

Which of the below mentioned options is a required step before the user can mount the volume?

A. Run a cyclic check on the device for data consistency

B. Create the file system of the volume

C. Resize the volume as per the original snapshot size

D. No step is required. The user can directly mount the device

**Answer: D    
**

**Explanation:    
**

When a user is trying to mount a blank EBS volume, it is required that the user first creates a file

system within the volume. If the volume is created from an existing snapshot then the user needs

not to create a file system on the volume as it will wipe out the existing data.

[http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-using-volumes.html](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-using-volumes.html)

---

**QUESTION 53    
**

A user is creating multiple IAM users. What advice should be given to him to enhance the

security?

A. Grant least privileges to the individual user

B. Grant all higher privileges to the group

C. Grant less privileges for user, but higher privileges for the group

D. Grant more privileges to the user, but least privileges to the group

**Answer: A    
**

**Explanation:    
**

It is a recommended rule that the root user should grant the least privileges to the IAM user or the

group. The higher the privileges, the more problems it can create.

[http://docs.aws.amazon.com/IAM/latest/UserGuide/IAMBestPractices.html](http://docs.aws.amazon.com/IAM/latest/UserGuide/IAMBestPractices.html)

---

**QUESTION 54    
**

In regards to Amazon SQS how many times will you receive each message?

A. At least twice

B. Exactly once

C. As many times as you want

D. At least once

Answer: D

Explanation:

Amazon SQS is engineered to provide "at least once" delivery of all messages in its queues.

Although most of the time, each message will be delivered to your application exactly once, you

should design your system so that processing a message more than once does not create any

errors or inconsistencies.

[https://aws.amazon.com/sqs/faqs/](https://aws.amazon.com/sqs/faqs/)

---

**QUESTION 55    
**

A user has set an IAM policy where it allows all requests if a request from IP 10.10.10.1/32.

Another policy allows all the requests between 5 PM to 7 PM. What will happen when a user is

requesting access from IP 10.10.10.1/32 at 6 PM?

A. IAM will throw an error for policy conflict

B. It is not possible to set a policy based on the time or IP

C. It will deny access

D. It will allow access

**Answer: D    
**

**Explanation:    
**

With regard to IAM, when a request is made, the AWS service decides whether a given request

should be allowed or denied. The evaluation logic follows these rules:

By default, all requests are denied. \(In general, requests made using the account credentials for

resources in the account are always allowed.\)

An explicit allow policy overrides this default.

An explicit deny policy overrides any allows.

[http://docs.aws.amazon.com/IAM/latest/UserGuide/AccessPolicyLanguage\_EvaluationLogic.html](http://docs.aws.amazon.com/IAM/latest/UserGuide/AccessPolicyLanguage_EvaluationLogic.html)

---

**QUESTION 56    
**

A user is enabling logging on a particular bucket. Which of the below mentioned options may be

best suitable to allow access to the log bucket?

A. Create an IAM policy and allow log access

B. It is not possible to enable logging on the S3 bucket

C. Create an IAM Role which has access to the log bucket

D. Provide ACL for the logging group

**Answer: D    
**

**Explanation:    
**

The only recommended use case for the S3 bucket ACL is to grant the write permission to the

Amazon S3 Log Delivery group to write access log objects to the user's bucket.

[http://docs.aws.amazon.com/AmazonS3/latest/dev/access-policy-alternatives-guidelines.html](http://docs.aws.amazon.com/AmazonS3/latest/dev/access-policy-alternatives-guidelines.html)

---

**QUESTION 56    
**

A user is enabling logging on a particular bucket. Which of the below mentioned options may be

best suitable to allow access to the log bucket?

A. Create an IAM policy and allow log access

B. It is not possible to enable logging on the S3 bucket

C. Create an IAM Role which has access to the log bucket

D. Provide ACL for the logging group

**Answer: D    
**

**Explanation:    
**

The only recommended use case for the S3 bucket ACL is to grant the write permission to the

Amazon S3 Log Delivery group to write access log objects to the user's bucket.

[http://docs.aws.amazon.com/AmazonS3/latest/dev/access-policy-alternatives-guidelines.html](http://docs.aws.amazon.com/AmazonS3/latest/dev/access-policy-alternatives-guidelines.html)

---

**QUESTION 57    
**

A user is running a webserver on EC2. The user wants to receive the SMS when the EC2

instance utilization is above the threshold limit. Which AWS services should the user configure in

this case?

A. AWS CloudWatch + AWS SES.

B. AWS CloudWatch + AWS SNS.

C. AWS CloudWatch + AWS SQS.

D. AWS EC2 + AWS Cloudwatch.

**Answer: B    
**

**Explanation:    
**

Amazon SNS makes it simple and cost-effective to push to mobile devices, such as iPhone, iPad,

Android, Kindle Fire, and internet connected smart devices, as well as pushing to other

distributed services. In this case, the user can configure that Cloudwatch sends an alarm on

when the threshold is crossed to SNS which will trigger an SMS.

[http://aws.amazon.com/sns/](http://aws.amazon.com/sns/)

---

**QUESTION 58    
**

Can a user associate and use his own DNS with ELB instead of the DNS provided by AWS ELB?

A. Yes, by creating a CNAME with the existing domain name provider

B. Yes, by configuring DNS in the AWS Console

C. No

D. Yes, only through Route 53 by mapping ELB and DNS

**Answer: A    
**

**Explanation:    
**

The AWS ELB allows mapping a custom domain name with ELB. The user can map ELB with

DNS in two ways: 1\) By creating CNAME with the existing domain name service provider or 2\) By

creating a record with Route 53.

---

**QUESTION 59    
**

\_\_\_\_\_\_\_\_\_\_\_\_\_ can be used to bootstrap both the Chef Server and Chef Client software on your

EC2 instances.

A. AWS CloudFormation

B. AWS Elastic Beanstalk

C. AWS OpsWorks

D. Amazon Glacier

**Answer: A    
**

**Explanation**:

AWS CloudFormation can be used to bootstrap both the Chef Server and Chef Client software on

your EC2 instances.

[http://aws.amazon.com/cloudformation/faqs/](http://aws.amazon.com/cloudformation/faqs/)

---

**QUESTION 60    
**

In relation to Amazon Simple Workflow Service \(Amazon SWF\),what is an "Activity Worker"?

A. An individual task undertaken by a workflow

B. The automation of a business process

C. A piece of software that implements tasks

D. All answers listed are correct

**Answer: C    
**

**Explanation:    
**

In relation to Amazon Simple Workflow Service \(Amazon SWF\), an activity worker is a program

that receives activity tasks, performs them, and provides results back.

Which translates to a piece of software that implements tasks.

[http://docs.aws.amazon.com/amazonswf/latest/developerguide/swf-dg-develop-activity.html](http://docs.aws.amazon.com/amazonswf/latest/developerguide/swf-dg-develop-activity.html)

---

**QUESTION 61    
**

A user has launched a MySQL RDS. The user wants to plan for the DR and automate the

snapshot. Which of the below mentioned functionality offers this option with RDS?

A. Copy snapshot

B. Automated synchronization

C. Snapshot

D. Automated backup

**Answer: D    
**

**Explanation:    
**

Amazon RDS provides two different methods for backing up and restoring the Amazon DB

instances:

automated backups and DB snapshots. Automated backups automatically back up the DB

instance during a specific, user-definable backup window, and keep the backups for a limited,

user-specified period of time.

---

**QUESTION 62    
**

You cannot access your AWS console, so you revert to using the CLI that you are not familiar

with. Which of the following commands is not a valid CLI command for EC2 instances?

A. ec2-allocate-address

B. ec2-attach-internet-gateway

C. ec2-associate-route-table

D. ec2-allocate-interface

**Answer: D    
**

**Explanation:    
**

You can use the CLI tools to manage your Amazon EC2 resources \(such as instances, security

groups, and volumes\) and your Amazon VPC resources \(such as VPCs, subnets, route tables,

and Internet gateways\). Before you can start using the tools, you must download and configure

them.

The following are valid CLI commands for EC2 instances:

ec2-accept-vpc-peering-connection

ec2-allocate-address

ec2-assign-private-ip-addresses

ec2-associate-address

ec2-associate-dhcp-options

ec2-associate-route-table

ec2-attach-internet-gateway

ec2-attach-network-interface \(not ec2-allocate-interface\)

---

**QUESTION 63    
**

An organization has 20 employees. The organization wants to give all the users access to the

organization AWS account. Which of the below mentioned options is the right solution?

A. Share the root credentials with all the users

B. Create an IAM user for each employee and provide access to them

C. It is not advisable to give AWS access to so many users

D. Use the IAM role to allow access based on STS

**Answer: B    
**

**Explanation:    
**

AWS Identity and Access Management is a web service that enables the AWS customers to

manage users and user permissions in AWS. The IAM is targeted at organizations with multiple

users or systems that use AWS products such as Amazon EC2, Amazon RDS, and the AWS

Management Console. With IAM, the organizaiton can centrally manage users, security

credentials such as access keys, and permissions that control which AWS resources users can

access.

[http://docs.aws.amazon.com/IAM/latest/UserGuide/IAM\_Introduction.html](http://docs.aws.amazon.com/IAM/latest/UserGuide/IAM_Introduction.html)

---

**QUESTION 64    
**

When AutoScaling is launching a new instance based on condition, which of the below mentioned

policies will it follow?

A. Based on the criteria defined with cross zone Load balancing

B. Launch an instance which has the highest load distribution

C. Launch an instance in the AZ with the fewest instances

D. Launch an instance in the AZ which has the highest instances

**Answer: C    
**

**Explanation:    
**

AutoScaling attempts to distribute instances evenly between the Availability Zones that are

enabled for the user's AutoScaling group. Auto Scaling does this by attempting to launch new

instances in the Availability Zone with the fewest instances.

[http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/AS\_Concepts.html](http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/AS_Concepts.html)

---

**QUESTION 65    
**

In regards to Amazon SQS how can you secure the messages in your queues?

A. You can't

B. Amazon SQS uses either your Access Key ID or an X.509 certificate to authenticate your

identity

C. Through your IAM access keys

D. Don't use root access

**Answer: B    
**

**Explanation:    
**

Authentication mechanisms are provided to ensure that messages stored in Amazon SQS

queues are secured against unauthorized access. Only the AWS account owners can access the

queues they create. Amazon SQS uses proven cryptographic methods to authenticate your

identity, either through the use of your Access Key ID and request signature, or through the use

of an X.509 certificate.

[https://aws.amazon.com/sqs/faqs/](https://aws.amazon.com/sqs/faqs/)

---

**QUESTION 66    
**

Which Amazon service is not used by Elastic Beanstalk?

A. Amazon S3

B. Amazon ELB

C. Auto scaling

D. Amazon EMR

**Answer: D    
**

**Explanation:    
**

Elastic Beanstalk leverages AWS services such as Amazon Elastic Cloud Compute \(Amazon

EC2\), Amazon Simple Storage Service \(Amazon S3\), Amazon Simple Notification Service

\(Amazon SNS\), Elastic Load Balancing and Auto Scaling to deliver the same highly reliable,

scalable, and cost-effective infrastructure that hundreds of thousands of businesses depend on

today.

[http://docs.aws.amazon.com/elasticbeanstalk/latest/dg/Welcome.html    
](http://docs.aws.amazon.com/elasticbeanstalk/latest/dg/Welcome.html)

---

**QUESTION 67    
**

In AWS Elastic Beanstalk, if the application returns any response other than 200 ,OK or there is

no response within the configured InactivityTimeout period, \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_.

A. SQS once again makes the message visible in the queue and available for another attempt at

processing

B. SQS waits for another timeout

C. SQS run DeleteMessagecall and deletes the message from the queue

D. SQS sends a message to the application with the MessageID and pending status

**Answer: A    
**

**Explanation:    
**

In AWS Elastic Beanstalk, if the application returns any response other than 200, OK or there is

no response within the configured InactivityTimeout period, SQS once again makes the message

visible in the queue and available for another attempt at processing.

---

**QUESTION 68    
**

Which of the below mentioned options can be a good use case for storing content in AWS RRS?

A. Storing mission critical data Files

B. Storing infrequently used log files

C. Storing a video file which is not reproducible

D. Storing image thumbnails

**Answer: D    
**

**Explanation:    
**

AWS RRS provides the same functionality as AWS S3, but at a cheaper rate. It is ideally suited

for non-mission, critical applications, such as files which can be reproduced.

[http://docs.aws.amazon.com/AmazonS3/latest/dev/UsingRRS.html    
](http://docs.aws.amazon.com/AmazonS3/latest/dev/UsingRRS.html)

---

**QUESTION 69    
**

Which header received at the EC2 instance identifies the port used by the client while requesting

ELB?

A. X-Forwarded-Proto

B. X-Requested-Proto

C. X-Forwarded-Port

D. X-Requested-Port

**Answer: C    
**

**Explanation:    
**

The X-Forwarded-Port request header helps the user identify the port used by the client while

sending a request to ELB.

---

**QUESTION 70    
**

When you register an activity in Amazon SWF, you provide the following information, except:

A. a name

B. timeout values

C. a domain

D. version

**Answer: C    
**

**Explanation:    
**

When designing an Amazon SWF workflow, you precisely define each of the required activities.

You then register each activity with Amazon SWF as an activity type. When you register the

activity, you provide information such as a name and version, and some timeout values based on

how long you expect the activity to take.

[http://docs.aws.amazon.com/amazonswf/latest/developerguide/swf-dg-intro-to-swf.html](http://docs.aws.amazon.com/amazonswf/latest/developerguide/swf-dg-intro-to-swf.html)

---

**QUESTION 71    
**

A user is using an EBS backed instance. Which of the below mentioned statements is true?

A. The user will be charged for volume and instance only when the instance is running

B. The user will be charged for the volume even if the instance is stopped

C. The user will be charged only for the instance running cost

D. The user will not be charged for the volume if the instance is stopped

**Answer: B    
**

**Explanation:    
**

If a user has launched an EBS backed instance, the user will be charged for the EBS volume

even though the instance is in a stopped state. The instance will be charged for the EC2 hourly

cost only when it is running.

[http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-detaching-volume.html](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-detaching-volume.html)

---

**QUESTION 72    
**

A user is trying to create a policy for an IAM user from the AWS console. Which of the below

mentioned options is not available to the user while configuring policy?

A. Use policy generator to create policy

B. Use custom policy to create policy

C. Use policy simulator to create policy

D. Assign No permission

**Answer: C    
**

**Explanation:    
**

When a user is trying to create a policy from the AWS console, it will have options such as create

policy from templates or use a policy generator. The user can also define a custom policy or

chose the option to have no permission. The policy simulator is not available in the console.

[http://docs.aws.amazon.com/IAM/latest/UserGuide/IAMBestPractices.html](http://docs.aws.amazon.com/IAM/latest/UserGuide/IAMBestPractices.html)

---

**QUESTION 73    
**

A user has an S3 object in the US Standard region with the content "color=red". The user

updates the object with the content as "color="white". If the user tries to read the value 1 minute

after it was uploaded, what will S3 return?

A. It will return "color=white"

B. It will return "color=red"

C. It will return an error saying that the object was not found

D. It may return either "color=red" or "color=white" i.e. any of the value

**Answer: D    
**

**Explanation:    
**

AWS S3 follows the eventual consistent model in the US Standard Region. Once the object is

updated it may return the new value or the old value based on whether all the content is

replicated across multiple servers until it becomes consistent \(eventual\).

[http://docs.aws.amazon.com/AmazonS3/latest/dev/Introduction.html](http://docs.aws.amazon.com/AmazonS3/latest/dev/Introduction.html)

---

**QUESTION 74    
**

AWS Elastic Beanstalk will change the health status of a web server environment tier to gray

color when:

A. AWS Elastic Beanstalk detects other problems with the environment that are known to make

the application unavailable

B. Your application hasn't responded to the application health check URL within the last one hour.

C. Your application hasn't responded to the application health check URL within the last five

minutes.

D. Your application's health status is unknown because status is reported when the application is

not in the ready state.

**Answer: D    
**

**Explanation:    
**

AWS Elastic Beanstalk will change the health status of a web server environment tier to gray

color when your application's health status is unknown \(because status is reported when the

application is not in the ready state\).

[http://docs.aws.amazon.com/elasticbeanstalk/latest/dg/using-features.healthstatus.html](http://docs.aws.amazon.com/elasticbeanstalk/latest/dg/using-features.healthstatus.html)

---



