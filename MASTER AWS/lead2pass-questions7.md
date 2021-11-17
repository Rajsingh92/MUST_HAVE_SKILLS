**QUESTION 261**

You have a video transcoding application running on Amazon EC2. Each instance polls a queue to find out which video should be transcoded, and then runs a transcoding process. If this process is interrupted, the video will be transcoded by another instance based on the queuing system. You have a large backlog of videos which need to be transcoded and would like to reduce this backlog by adding more instances. You will need these instances only until the backlog is reduced. Which type of Amazon EC2 instances should you use to reduce the backlog in the most cost efficient way?

A. Reserved instances  
 B. Spot instances  
 C. Dedicated instances  
 D. On-demand instances

**Answer: B**

---

**QUESTION 262**

A customer has established an AWS Direct Connect connection to AWS. The link is up and routes are being advertised from the customer’s end, however the customer is unable to connect from EC2 instances inside its VPC to servers residing in its datacenter.  
Which of the following options provide a viable solution to remedy this situation? \(Choose 2 answers\)

A. Add a route to the route table with an iPsec VPN connection as the target.

B. Enable route propagation to the virtual pinnate gateway \(VGW\).

C. Enable route propagation to the customer gateway \(CGW\).

D. Modify the route table of all Instances using the ‘route’ command.

E. Modify the Instances VPC subnet route table by adding a route back to the customer’s on-premises environment.

**Answer: B,E**

---

**QUESTION 263**

An International company has deployed a multi-tier web application that relies on DynamoDB in a single region For regulatory reasons they need disaster recovery capability In a separate region with a Recovery Time Objective of 2 hours and a Recovery Point Objective of 24 hours They should synchronize their data on a regular basis and be able to provision me web application rapidly using CloudFormation.  
The objective is to minimize changes to the existing web application, control the throughput of DynamoDB used for the synchronization of data and synchronize only the modified elements.  
Which design would you choose to meet these requirements?

A. Use AWS data Pipeline to schedule a DynamoDB cross region copy once a day. create a Lastupdated’ attribute in your DynamoDB table that would represent the timestamp of the last update and use it as a filter.

B. Use EMR and write a custom script to retrieve data from DynamoDB in the current region using a SCAN operation and push it to DynamoDB in the second region.

C. Use AWS data Pipeline to schedule an export of the DynamoDB table to S3 in the current region once a day then schedule another task immediately after it that will import data from S3 to DynamoDB in the other region.

D. Send also each Ante into an SQS queue in me second region; use an auto-scaiing group behind the SQS queue to replay the write in the second region.

**Answer: C**

---

**QUESTION 264**

If you’re unable to connect via SSH to your EC2 instance, which of the following should you check and possibly correct to restore connectivity?

A. Adjust Security Group to permit egress traffic over TCP port 443 from your IP.

B. Configure the IAM role to permit changes to security group settings.

C. Modify the instance security group to allow ingress of ICMP packets from your IP.

D. Adjust the instance’s Security Group to permit ingress traffic over port 22 from your IP.

E. Apply the most recently released Operating System security patches.

**Answer: D**

---

**QUESTION 265**

Your company produces customer commissioned one-of-a-kind skiing helmets combining nigh fashion with custom technical enhancements Customers can show off their  
Individuality on the ski slopes and have access to head-up-displays. GPS rear-view cams and any other technical innovation they wish to embed in the helmet.  
The current manufacturing process is data rich and complex including assessments to ensure that the custom electronics and materials used to assemble the helmets are to the highest standards Assessments are a mixture of human and automated assessments you need to add a new set of assessment to model the failure modes of the custom electronics using GPUs with CUDA. across a cluster of servers with low latency networking.  
What architecture would allow you to automate the existing process using a hybrid approach and ensure that the architecture can support the evolution of processes over time?

A. Use AWS Data Pipeline to manage movement of data &meta-data and assessments Use an auto-scaling group of G2 instances in a placement group.

B. Use Amazon Simple Workflow \(SWF\) to manages assessments, movement of data &meta-data Use an auto-scaling group of G2 instances in a placement group.

C. Use Amazon Simple Workflow \(SWF\) to manages assessments movement of data &meta-data Use an auto-scaling group of C3 instances with SR-IOV \(Single Root I/O Virtualization\).

D. Use AWS data Pipeline to manage movement of data & meta-data and assessments use auto-scaling group of C3 with SR-IOV \(Single Root I/O virtualization\).

**Answer: B**

\(SR-IOV is a method of device virtualization that provides higher I/O performance and lower CPU utilization when compared to traditional virtualized network interfaces\)

---

**QUESTION 266**

Your startup wants to implement an order fulfillment process for selling a personalized gadget that needs an average of 3-4 days to produce with some orders taking up to 6 months you expect 10 orders per day on your first day. 1000 orders per day after 6 months and 10,000 orders after 12 months.  
Orders coming in are checked for consistency men dispatched to your manufacturing plant for production quality control packaging shipment and payment processing If the product does not meet the quality standards at any stage of the process employees may force the process to repeat a step Customers are notified via email about order status and any critical issues with their orders such as payment failure.  
Your case architecture includes AWS Elastic Beanstalk for your website with an RDS MySQL instance for customer data and orders.  
How can you implement the order fulfillment process while making sure that the emails are delivered reliably?

A. Add a business process management application to your Elastic Beanstalk app servers and re-use the ROS database for tracking order status use one of the Elastic Beanstalk instances to send emails to customers.

B. Use SWF with an Auto Scaling group of activity workers and a decider instance in another Auto Scaling group with min/max=1 Use the decider instance to send emails to customers.

C. Use SWF with an Auto Scaling group of activity workers and a decider instance in another Auto Scaling group with min/max=1 use SES to send emails to customers.

D. Use an SQS queue to manage all process tasks Use an Auto Scaling group of EC2 Instances that poll the tasks and execute them. Use SES to send emails to customers.

**Answer: C**

---

**QUESTION 267**

Will my standby RDS instance be in the same Region as my primary?

A Only for Oracle RDS types

B Yes

C Only if configured at launch

D No

**Answer： B**

---

**QUESTION 268**

Out of the stripping options available for the EBS volumes, which one has the following disadvantage: ‘Doubles the amount of I/O required from the instance to EBS compared to RAID 0, because you’re mirroring all writes to a pair of volumes, limiting how much you can stripe.’ ?

A Raid 0

B RAID 1+0 \(RAID 10\)

C Raid 1

D Raid 2

**Answer: B**

---

**QUESTION 269**

Can Amazon S3 uploads resume on failure or do they need to restart?

A Restart from beginning

B You can resume them, if you flag the “resume on failure” option before uploading.

C Resume on failure

D Depends on the file size

**Answer: A**

---

**QUESTION 270**

What is the maximum write throughput I can provision for a single DynamoDB table?

A 1,000 write capacity units

B 100,000 write capacity units

C DynamoDB is designed to scale without limits, but if you go beyond 10,000 you have to contact AWS first.—

D 10,000 write capacity units

**Answer: D**

---

**QUESTION 271**

Is Federated Storage Engine currently supported by Amazon RDS for MySQL?

A Only for Oracle RDS instances

B No

C Yes

D Only in VPC

**Answer: B**

---

**QUESTION 272**

You must increase storage size in increments of at least**\_**%

A 40

B 30

C 10

D 20

**Answer: C**

---

**QUESTION 273**

You have an application running in us-west-2 that requires six Amazon Elastic Compute Cloud \(EC2\) instances running at all times. With three Availability Zones available in that region \(us-west-2a, us-west-2b, and us-west-2c\), which of the following deployments provides 100 percent fault tolerance if any single Availability Zone in us-west-2 becomes unavailable?Choose 2 answers

A. Us-west-2a with two EC2 instances, us-west-2b with two EC2 instances, and us-west-2c with two EC2 instances

B. Us-west-2a with three EC2 instances, us-west-2b with three EC2 instances, and us-west-2c with no EC2 instances

C. Us-west-2a with four EC2 instances, us-west-2b with two EC2 instances, and us-west-2c with two EC2 instances

D. Us-west-2a with six EC2 instances, us-west-2b with six EC2 instances, and us-west-2c with no EC2 instances

E. Us-west-2a with three EC2 instances, us-west-2b with three EC2 instances, and us-west-2c with three EC2 instances

**Answer： D, E**

---

**QUESTION 274**

You have a business-critical two-tier web app currently deployed in two Availability Zones in a single region, using Elastic Load Balancing and Auto Scaling. The app depends on synchronous replication \(very low latency connectivity\) at the database layer. The application needs to remain fully available even if one application Availability Zone goes off-line, and Auto Scaling cannot launch new instances in the remaining Availability Zones. How can the current architecture be enhanced to ensure this?

A. Deploy in three Availability Zones, with Auto Scaling minimum set to handle 33 percent peak load per zone.

B. Deploy in three Availability Zones, with Auto Scaling minimum set to handle 50 percent peak load per zone.

C. Deploy in two regions using Weighted Round Robin \(WRR\), with Auto Scaling minimums set for 50 percent peak load per Region.

D. Deploy in two regions using Weighted Round Robin \(WRR\), with Auto Scaling minimums set for 100 percent peak load per region.

**Answer: B**

---

**QUESTION 275**

Amazon Glacier is designed for:Choose 2 answers

A. Frequently accessed data

B. Active database storage

C. Infrequently accessed data

D. Cached session data

E. Data archives

**Answer： C, E**

---

**QUESTION 276**

You receive a Spot Instance at a bid of0.03/hr.After30minutes,theSpotPriceincreasesto0.03/hr.After30minutes,theSpotPriceincreasesto0.05/hr and your Spot Instance is terminated by AWS. What was the total EC2 compute cost of running your Spot Instance?

A. $0.00

B. $0.02

C. $0.03

D. $0.05

E. $0.06

**Answer: A**

---

**QUESTION 277**

You have been tasked with creating a VPC network topology for your company. The VPC network must support both Internet-facing applications and internally-facing applications accessed only over VPN. Both Internet-facing and internally-facing applications must be able to leverage at least three AZs for high availability. At a minimum, how many subnets must you create within your VPC to accommodate these requirements?

A. 2

B. 3

C. 4

D. 6

**Answer: D**

---

**QUESTION 278**

Your customer wishes to deploy an enterprise application to AWS which will consist of several web servers, several application servers and a small \(50GB\) Oracle database information is stored, both in the database and the file systems of the various servers. The backup system must support database recovery whole server and whole disk restores, and individual file restores with a recovery time of no more than two hours They have chosen to use RDS Oracle as the database Which backup architecture will meet these requirements?

A. Backup RDS using automated daily DB backups Backup the EC2 instances using AMIs and supplement with file-level backup to S3 using traditional enterprise backup software to provide file level restore

B. Backup RDS using a Multi-AZ Deployment Backup the EC2 instances using Amis, and supplement by copying file system data to S3 to provide file level restore.

C. Backup RDS using automated daily DB backups Backup the EC2 instances using EBS snapshots and supplement with file-level backups to Amazon Glacier using traditional enterprise backup software to provide file level restore

D. Backup RDS database to S3 using Oracle RMAN Backup the EC2 instances using Amis, and supplement with EBS snapshots for individual volume restore.

**Answer: B**

---

**QUESTION 279**

You have a content management system running on an Amazon EC2 instance that is approaching 100% CPU utilization. Which option will reduce load on the Amazon EC2 instance?

A. Create a load balancer, and register the Amazon EC2 instance with it

B. Create a CloudFront distribution, and configure the Amazon EC2 instance as the origin

C. Create an Auto Scaling group from the instance using the CreateAutoScalingGroup action

D. Create a launch configuration from the instance using the CreateLaunchConfiguration action

**Answer： A**

---

**QUESTION 280**

Company B is launching a new game app for mobile devices. Users will log into the game using their existing social media account to streamline data capture. Company B would like to directly save player data and scoring information from the mobile app to a DynamoDS table named Score Data When a user saves their game the progress data will be stored to the Game state S3 bucket. what is the best approach for storing data to DynamoDB and S3?

A. Use an EC2 Instance that is launched with an EC2 role providing access to the Score Data DynamoDB table and the GameState S3 bucket that communicates with the mobile app via web services.

B. Use temporary security credentials that assume a role providing access to the Score Data DynamoDB table and the Game State S3 bucket using web identity federation.

C. Use Login with Amazon allowing users to sign in with an Amazon account providing the mobile app with access to the Score Data DynamoDB table and the Game State S3 bucket.

D. Use an 1AM user with access credentials assigned a role providing access to the Score Data DynamoDB table and the Game State S3 bucket for distribution with the mobile app

**Answer: B**

---

**QUESTION 281**

You’re creating a forum DynamoDB database for hosting forums. Your “thread” table contains the forum name and each “forum name” can have one or more “subjects”. What primary key type would you give the thread table in order to allow more than one subject to be tied to the forum primary key name?

A. Hash

B. Primary and range

C. Range and Hash

D. Hash and Range

**Answer: D**  
ref：[https://forums.aws.amazon.com/thread.jspa?messageID=331668](https://forums.aws.amazon.com/thread.jspa?messageID=331668)

---

**QUESTION 282**

In the basic monitoring package for EC2, Amazon CloudWatch provides the following metrics:

A. web server visible metrics such as number failed transaction requests

B. operating system visible metrics such as memory utilization

C. database visible metrics such as number of connections

D. hypervisor visible metrics such as CPU utilization

**Answer: D.**

---

**QUESTION 283**

Which is an operational process performed by AWS for data security?

A. AES-256 encryption of data stored on any shared storage device

B. Decommissioning of storage devices using industry-standard practices

C. Background virus scans of EBS volumes and EBS snapshots

D. Replication of data across multiple AWS Regions

E. Secure wiping of EBS data when an EBS volume is un-mounted

**Answer: B.**

---

**QUESTION 284**

Select the correct set of options. These are the initial settings for the default security group:

A. Allow no inbound traffic, Allow all outbound traffic and Allow instances associated with this security group to talk to each other.

B. Allow all inbound traffic, Allow no outbound traffic and Allow instances associated with this security group to talk to each other.

C. Allow no inbound traffic, Allow all outbound traffic and Does NOT allow instances associated with this security group to talk to each other.

D. Allow all inbound traffic, Allow all outbound traffic and Does NOT allow instances associated with this security group to talk to each other.

**Answer: A**

---

**QUESTION 285**

An IAM user is trying to perform an action on an object belonging to some other root account’s bucket. Which of the below mentioned options will AWS S3 not verify?

A. Permission provided by the parent of the IAM user on the bucket

B. The object owner has provided access to the IAM user

C. Permission provided by the parent of the IAM user

D. Permission provided by the bucket owner to the IAM user

**Answer: C **

If the IAM user is trying to perform some action on the object belonging to another AWS user’s bucket, S3 will verify whether the owner of the IAM user has given sufficient permission to him. It also verifies the policy for the bucket as well as the policy defined by the object owner.

---

**QUESTION 286**

Placement Groups: enables applications to participate in a low-latency, 10 Gbps network. Which of below statements is false.

A. Not all of the instance types that can be launched into a placement group.

B. A placement group can’t span multiple Availability Zones.

C. You can move an existing instance into a placement group by specify parameter of placement group.

D. A placement group can span peered VPCs.

**Answer: D**

---

**QUESTION 287**

What about below is false for AWS SLA

A. S3 availability is guarantee to 99.95%.

B. EBS availability is guarantee to 99.95%.

C. EC2 availability is guarantee to 99.95%.

D. RDS multi-AZ is guarantee to 99.95%.

**Answer: A**

S3 availability is 99.9%

---

**QUESTION 288**

About the charge of Elastic IP Address, which of the following is true?

A. You can have one Elastic IP \(EIP\) address associated with a running instance at no charge.

B. You are charged for each Elastic IP addressed.

C. You can have 5 Elastic IP addresses per region with no charge.

D. Elastic IP addresses can always be used with no charge.

**Answer: B **

\[ref\]\([http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/elastic-ip-addresses-eip.html](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/elastic-ip-addresses-eip.html)\)

---

**QUESTION 289**

Which of the below mentioned steps will not be performed while creating the AMI of instance stored-backend?

A. Define the AMI launch permissions.

B. Upload the bundled volume.

C. Register the AMI.

D. Bundle the volume.

**Answer：A**

---

**QUESTION 290**

The user just started an instance at 3 PM. Between 3 PM to 5 PM, he stopped and started the instance twice. During the same period, he has run the linux reboot command by ssh once and triggered reboot from AWS console once. For how many instance hours will AWS charge this user?

A. 4

B. 3

C. 2

D. 5

**Answer: B**

[ref](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/Stop_Start.html)  
Each time you start a stopped instance we charge a full instance hour, even if you make this transition multiple times within a single hour.  
Rebooting an instance doesn’t start a new instance billing hour, unlike stopping and restarting your instance.

---

**QUESTION 291**

Amazon Redshift is what type of data warehouse service?

A. Gigabyte-scale

B. Exobyte-scale

C. Petabyte-scale

D. Terabyte-scale

**Answer: C **

Amazon Redshift is a fully-managed, petabyte-scale data warehouse service.

---

**QUESTION 292**

Which AWS storage service assists S3 with transferring data?

A. CloudFront

B. AWS Import/Export

C. DynamoDB

D. ElastiCache

**Answer: b **

\( AWS Import/Export accelerates moving large amounts of data into and out of AWS using portable storage devices. AWS transfers your data directly onto and off of storage devices by using Amazon’s internal network and avoiding the Internet.\)

---

**QUESTION 293**

Amazon S3 offers encryption services for which types of data?

A. data in flight

B. data at relax

C. data at rest

D. data in motion

E. a and c

F. b and d

**Answer: E**

Amazon offers encryption services for data at flight and data at rest.

---

**QUESTION 294**

Amazon S3 has how many pricing components?

A. 4

B. 5

C. 3

D. 2

**Answer: C**

Amazon S3 offers three pricing options. Storage \(per GB per month\), data transfer in or out \(per GB per month\), and requests \(per x thousand requests per month\).

---

**QUESTION 295**

What does RRS stand for when referring to the storage option in Amazon S3 that offers a lower level of durability at a lower storage cost?

A. Reduced Reaction Storage

B. Redundant Research Storage

C. Regulatory Resources Storage

D. Reduced Redundancy Storage

**Answer:D **

\(Non-critical data, such as transcoded media or image thumbnails, can be easily reproduced using the Reduced Redundancy Storage option. Objects stored using the RRS option have less redundancy than objects stored using standard Amazon S3 storage.

---

**QUESTION 296**

Object storage systems require less**\_**than file systems to store and access files.

A. Big data

B. Metadata

C. Master data

D. Exif data

**Answer: B**

\(Object storage systems are typically more efficient because they reduce the overhead of managing file metadata by storing the metadata with the object. This means object storage can be scaled out almost endlessly by adding nodes.\)

---

**QUESTION 297**

Why is a bucket policy necessary?

A. To allow bucket access to multiple users.

B. To grant or deny accounts to read and upload files in your bucket.

C. To approve or deny users the option to add or remove buckets.

D. All of the above

**Answer: B **

Users need a bucket policy to grant or deny accounts to read and upload files in your bucket.

---

**QUESTION 298**

You would like to create a mirror image of your production environment in another region for disaster recovery purposes. Which of the following AWS resources do not need to be recreated in the second region? \(Choose 2 answers\)

A. Route 53 Record Sets

B. IAM Roles

C. Elastic IP Addresses \(EIP\)

D. EC2 Key Pairs

E. Launch configurations

F. Security Groups

**Answer : A,C**

---

**QUESTION 299**

Your company has recently extended its datacenter into a VPC on AWS to add burst computing capacity as needed Members of your Network Operations Center need to be able to go to the AWS Management Console and administer Amazon EC2 instances as necessary You don’t want to create new IAM users for each NOC member and make those users sign in again to the AWS Management Console Which option below will meet the needs for your NOC members?

A. Use OAuth 2 0 to retrieve temporary AWS security credentials to enable your NOC members to sign in to the AVVS Management Console.

B. Use web Identity Federation to retrieve AWS temporary security credentials to enable your NOC members to sign in to the AWS Management Console.

C. Use your on-premises SAML 2 O-compliant identityprovider \(IDP\) to grant the NOC members federated access to the AWS Management Console via the AWS single sign-on \(SSO\) endpoint.

D. Use your on-premises SAML2.0-compliam identity provider \(IDP\) to retrieve temporary security credentials to enable NOC members to sign in to the AWS Management Console.

**Answer : D**

---

**QUESTION 300**

You are implementing AWS Direct Connect. You intend to use AWS public service end points such as Amazon S3, across the AWS Direct Connect link. You want other Internet traffic to use your existing link to an Internet Service Provider. What is the correct way to configure AWS Direct connect for access to services such as Amazon S3?

A. Configure a public Interface on your AWS Direct Connect link Configure a static route via your AWS Direct Connect link that points to Amazon S3 Advertise a default route to AWS using BGP.

B. Create a private interface on your AWS Direct Connect link. Configure a static route via your AWS Direct connect link that points to Amazon S3 Configure specific routes to your network in your VPC.

C. Create a public interface on your AWS Direct Connect link Redistribute BGP routes into your existing routing infrastructure advertise specific routes for your network to AWS.

D. Create a private interface on your AWS Direct connect link. Redistribute BGP routes into your existing routing infrastructure and advertise a default route to AWS.

**Answer : C**

---

**QUESTION 301**

You have deployed a web application targeting a global audience across multiple AWS Regions under the domain name.example.com. You decide to use Route53 Latency-Based Routing to serve web requests to users from the region closest to the user. To provide business continuity in the event of server downtime you configure weighted record sets associated with two web servers in separate Availability Zones per region. Dunning a DR test you notice that when you disable all web servers in one of the regions Route53 does not automatically direct all users to the other region. What could be happening? \(Choose 2 answers\)

A. Latency resource record sets cannot be used in combination with weighted resource record sets.

B. You did not setup an http health check tor one or more of the weighted resource record sets associated with me disabled web servers.

C. The value of the weight associated with the latency alias resource record set in the region with the disabled servers is higher than the weight for the other region.

D. One of the two working web servers in the other region did not pass its HTTP health check.

E. You did not set “Evaluate Target Health” to “Yes” on the latency alias resource record set associated with example com in the region where you disabled the servers.

**Answer : B,D**

---

**QUESTION 302**

Your company produces customer commissioned one-of-a-kind skiing helmets combining nigh fashion with custom technical enhancements Customers can show off their Individuality on the ski slopes and have access to head-up-displays. GPS rear-view cams and any other technical innovation they wish to embed in the helmet.The current manufacturing process is data rich and complex including assessments to ensure that the custom electronics and materials used to assemble the helmets are to the highest standards Assessments are amixture of human and automated assessments you need to add a new set of assessment to model the failure modes of the custom electronics using GPUs with CUDA. across a cluster of servers with low latency networking.What architecture would allow you to automate the existing process using a hybrid approach and ensure that the architecture can support the evolution of processes over time?

A. Use AWS Data Pipeline to manage movement of data &meta-data and assessments Use an auto-scaling group of G2 instances in a placement group.

B. Use Amazon Simple Workflow \(SWF\) 10 manages assessments, movement of data &meta-data Use an auto-scaling group of G2 instances in a placement group.

C. Use Amazon Simple Workflow \(SWF\) lo manages assessments movement of data &meta-data Use an auto-scaling group of C3 instances with SR-IOV \(Single Root I/O Virtualization\).

D. Use AWS data Pipeline to manage movement of data & meta-data and assessments use auto-scaling group of C3 with SR-IOV \(Single Root I/O virtualization\).

**Answer : A**

---

**QUESTION 303**

You require the ability to analyze a large amount of data, which is stored on Amazon S3 using Amazon Elastic Map Reduce. You are using the cc2 8x large Instance type, whose CPUs are mostly idle during processing. Which of the below would be the most cost efficient way to reduce the runtime of the job?

A. Create more smaller flies on Amazon S3.

B.Add additional cc2 8x large instances by introducing a task group.

C. Use smaller instances that have higher aggregate I/O performance.

D. Create fewer, larger files on Amazon S3.

**Answer : C**

---

**QUESTION 304**

You are designing a photo sharing mobile app the application will store all pictures in a single Amazon S3 bucket.Users will upload pictures from their mobile device directly to Amazon S3 and will be able to view and download their own pictures directly from Amazon S3.You want to configure security to handle potentially millions of users in the most secure manner possible. What should your server-side application do when a new user registers on the photo-sharing mobile application?

A. Create a set of long-term credentials using AWS Security Token Service with appropriate permissions Store these credentials in the mobile app and use them to access Amazon S3.

B. Record the user’s Information in Amazon RDS and create a role in IAM with appropriate permissions. When the user uses their mobile app create temporary credentials using the AWS Security Token Service ‘AssumeRole’ function Store these credentials in the mobile app’s memory and use them to access Amazon S3 Generate new credentials the next time the user runs the mobile app.

C. Record the user’s Information In Amazon DynamoDB. When the user uses their mobile app create temporary credentials using AWS Security Token Service with appropriate permissions Store these credentials in the mobile app’s memory and use them to access Amazon S3 Generate new credentials the next time the user runs the mobile app.

D. Create IAM user. Assign appropriate permissions to the IAM user Generate an access key and secret key for the IAM user, store them in the mobile app and use these credentials to access Amazon S3.

E.Create an IAM user. Update the bucket policy with appropriate permissions for the IAM user Generate an access Key and secret Key for the IAM user, store them In the mobile app and use these credentials to access Amazon S3.

**Answer : B**

---

**QUESTION 305**

A customer has a 10 GB AWS Direct Connect connection to an AWS region where they have a web application hosted on Amazon Elastic Computer Cloud \(EC2\). The application has dependencies on an on-premises mainframe database that uses a BASE \(Basic Available. Sort stale Eventual consistency\) rather than an ACID \(Atomicity. Consistency isolation. Durability\) consistency model. The application is exhibiting undesirable behavior because the database is not able to handle the volume of writes. How can you reduce the load on your on-premises database resources in the most cost-effective way?

A. Use an Amazon Elastic Map Reduce \(EMR\) S3DistCp as a synchronization mechanism between the on-premises database and a Hadoop cluster on AWS.

B. Modify the application to write to an Amazon SQS queue and develop a worker process to flush the queue to the on-premises database.

C. Modify the application to use DynamoDB to feed an EMR cluster which uses a map function to write to the on-premises database.

D. Provision an RDS read-replica database on AWS to handle the writes and synchronize the two databases using Data Pipeline.

**Answer : A**

---

**QUESTION 306**

You are the new IT architect in a company that operates a mobile sleep tracking application When activated at night, the mobile app is sending collected data points of 1 kilobyte every5 minutes to your backend The backend takes care of authenticating the user and writing the data points into an Amazon DynamoDB table. Every morning, you scan the table to extract and aggregate last night’s data on a per user basis, and store the results in Amazon S3.Users are notified via Amazon SMS mobile push notifications that new data is available, which is parsed and visualized by \(The mobile app Currently you have around 100k users who are mostly based out of North America. You have been tasked to optimize the architecture of the backend system to lower cost what would you recommend? \(Choose 2 answers\)

A. Create a new Amazon DynamoDB \(able each day and drop the one for the previous day after its data is on Amazon S3.

B. Have the mobile app access Amazon DynamoDB directly instead of JSON files stored on Amazon S3.

C. Introduce an Amazon SQS queue to buffer writes to the Amazon DynamoDB table and reduce provisioned write throughput.

D. Introduce Amazon Elasticache lo cache reads from the Amazon DynamoDB table and reduce provisioned read throughput.

E. Write data directly into an Amazon Redshift cluster replacing both Amazon DynamoDB and Amazon S3.

**Answer : B,D**

---

**QUESTION 307**

Your company is getting ready to do a major public announcement of a social media site on AWS. The website is running on EC2 instances deployed across multiple Availability Zones with a Multi-AZ RDS MySQL Extra Large DB Instance. The site performs a high number of small reads and writes per second and relies on an eventual consistency model. After comprehensive tests you discover that there is read contention on RDS MySQL. Which are the best approaches to meet these requirements? \(Choose 2 answers\)

A. Deploy ElasticCache in-memory cache running in each availability zone

B. Implement sharding to distribute load to multiple RDS MySQL instances

C. Increase the RDS MySQL Instance size and Implement provisioned IOPS

D. Add an RDS MySQL read replica in each availability zone

Answer : A,C

---

**QUESTION 308**

You are tasked with moving a legacy application from a virtual machine running Inside your datacenter to an Amazon VPC Unfortunately this app requires access to a number of on-premises services and no one who configured the app still works for your company. Even worse there’s no documentation for it. What will allow the application running inside the VPC to reach back and access its internal dependencies without being reconfigured? \(Choose 3 answers\)

A. An AWS Direct Connect link between the VPC and the network housing the internal services.

B. AnInternet Gateway to allow a VPN connection.

C. An Elastic IP address on the VPC instance

D. An IP address space that does not conflict with the one on-premises

E. Entries in Amazon Route 53 that allow the Instance to resolve its dependencies’ IP addresses

F. A VM Import of the current virtual machine

**Answer : A,C,F**

---

**QUESTION 309**

Your company currently has a 2-tier web application running in an on-premises data center. You have experienced several infrastructure failures in the past two months resulting in significant financial losses. Your CIO is strongly agreeing to move the application to AWS. While working on achieving buy-infrom the other company executives, he asks you to develop a disaster recovery plan to help improve Business continuity in the short term. He specifies a target Recovery Time Objective \(RTO\) of 4 hours and a Recovery Point Objective \(RPO\) of 1 hour or less.He also asks you to implement the solution within 2 weeks. Your database is 200GB in size and you have a 20Mbps Internet connection. How would you do this while minimizing costs?

A. Create an EBS backed private AMI which includes a fresh install or your application. Setup a script in your data center to backup the local database every 1 hour and to encrypt and copy the resulting file to an S3 bucket using multi-part upload.

B. Install your application on a compute-optimized EC2 instance capable of supporting the application’s average load synchronously replicate transactions from your on-premises database to a database instance in AWS across a secure Direct Connect connection.

C. Deploy your application on EC2 instances within an Auto Scaling group across multiple availability zones asynchronously replicate transactions from your on-premises database to a database instance in AWS across a secure VPN connection.

D. Create an EBS backed private AMI that includes a fresh install of your application. Develop a Cloud Formation template which includes your Mil and the required EC2. Auto-Scaling and ELB resources to support deploying the application across Multiple-Ability Zones. Asynchronously replicate transactions from your on-premises database to a database instance in AWS across a secure VPN connection.

**Answer : A**

---

**QUESTION 310**

Refer to the architecture diagram above of a batch processing solution using Simple Queue Service \(SOS\) to set up a message queue between EC2 instances which are used as batch processors Cloud Watch monitors the number of Job requests \(queued messages\) and an Auto Scaling group adds or deletes batch servers automatically based on parameters set in Cloud Watch alarms. You can use this architecture to implement which of the following features in a cost effective and efficient manner?

A. Reduce the overall lime for executing jobs through parallel processing by allowing a busy EC2 instance that receives a message to pass it to the next instance in a daisy-chain setup.

B. Implement fault tolerance against EC2 instance failure since messages would remain in SQS and worn can continue with recovery of EC2 instances implement fault tolerance against SQS failure by backing up messages to S3.

C. Implement message passing between EC2 instances within a batch by exchanging messages through SOS. D. Coordinate number of EC2 instances with number of job requests automatically thus Improving cost effectiveness.

D. Handle high priority jobs before lower priority jobs by assigning a priority metadata field to SQS messages.

**Answer : B**

---

**QUESTION 311**

A company is building a voting system for a popular TV show, viewers win watch the performances then visit the show’s website to vote for their favorite performer. It is expected that in a short period of time after the show has finished the site will receive millions of visitors. The visitors will first login to the site using their Amazon.com credentials and then submit their vote. After the voting is completed the page will display the vote totals. The company needs to build the site such that can handlethe rapid influx of traffic while maintaining good performance but also wants to keep costs to a minimum. Which of the design patterns below should they use?

A. Use CloudFront and an Elastic Load balancer in front of an auto-scaled set of web servers, the web servers will first can the Login With Amazon service to authenticate the user then process the users vote and store the result into a multi-AZ Relational Database Service instance.

B. Use CloudFront and the static website hosting feature of S3 with the Javascript SDK to call the Login With Amazon service to authenticate the user, use IAM Roles to gain permissions to a DynamoDB table to store the users vote.

C. Use CloudFront and an Elastic Load Balancer in front of an auto-scaled set of web servers, the web servers will first call the Login with Amazon service to authenticate the user, the web servers will process the users vote and store the result into a DynamoDB table using IAM Roles for EC2 instances to gain permissions to the DynamoDB table.

D. Use CloudFront and an Elastic Load Balancer in front of an auto-scaled set of web servers, the web servers will first call the Login. With Amazon service to authenticate the user, the web servers win process the users vote and store the result into an SQS queue using IAM Roles for EC2 Instances to gain permissions to the SQS queue. A set of application servers will then retrieve the items from the queue and store the result into a DynamoDB table.

**Answer : D**

---

**QUESTION 312**

You have a periodic Image analysis application that gets some files In Input analyzes them and tor each file writes some data in output to a ten file the number of files in input per day is high and concentrated in a few hours of the day. Currently you have a server on EC2 with a large EBS volume that hosts the input data and the results it takes almost 20 hours per day to complete the process What services could be used to reduce the elaboration time and improve the availability of the solution?

A. S3 to store I/O files. SQS to distribute elaboration commands to a group of hosts working in parallel. Auto scaling to dynamically size the group of hosts depending on the length of the SQS queue

B. EBS with Provisioned IOPS \(PIOPS\) to store I/O files. SNS to distribute elaboration commands to agroup of hosts working in parallel Auto Scaling to dynamically size the group of hosts depending on the number of SNS notifications

C. S3 to store I/O files, SNS to distribute evaporation commands to a group of hosts working in parallel. Auto scaling to dynamically size the group of hosts depending on the number of SNS notifications

D. EBS with Provisioned IOPS \(PIOPS\) to store I/O files SOS to distribute elaboration commands to a group of hosts working in parallel Auto Scaling to dynamically size the group ot hosts depending on the length of the SQS queue.

**Answer : C**



