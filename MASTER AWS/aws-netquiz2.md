**Question 1**

REST or Query requests are HTTP or HTTPS requests that use an HTTP verb \(such as GET or POST\) and a parameter named Action or Operation that specifies the API you are calling.

1. FALSE
2. **TRUE**

**Question 2**

Through which of the following interfaces is AWS Identity and Access Management available?

A\) AWS Management Console

B\) Command line interface \(CLI\)

C\) IAM Query API

D\) Existing libraries

1. Only through Command line interface \(CLI\)
2. A, B and C
3. A and C
4. **All of the above**

Question 3

Which of the following programming languages have an officially supported AWS SDK? Choose 2 answers

1. **PHP**
2. Pascal
3. **Java**
4. SQL
5. Perl

**Question 4**

HTTP Query-based requests are HTTP requests that use the HTTP verb GET or POST and a Query parameter named\_\_\_\_\_\_\_\_\_\_\_\_\_.

1. **Action**
2. Value
3. Reset
4. Retrieve

**Question 5**

An AWS customer is deploying an application that is composed of an AutoScaling group of EC2 Instances. The customers security policy requires that every outbound connection from these instances to any other service within the customers Virtual Private Cloud must be authenticated using a unique x.509 certificate that contains the specific instanceid. In addition an x.509 certificates must be designed by the customer’s Key management service in order to be trusted for authentication. Which of the following configurations will support these requirements?

1. Configure an IAM Role that grants access to an Amazon S3 object containing a signed certificate and configure the Auto Scaling group to launch instances with this role. Have the instances bootstrap get the certificate from Amazon S3 upon first boot.
2. Embed a certificate into the Amazon Machine Image that is used by the Auto Scaling group. Have the launched instances generate a certificate signature request with the instance’s assigned instance-id to the Key management service for signature.
3. **Configure the Auto Scaling group to send an SNS notification of the launch of a new instance to the trusted key management service. Have the Key management service generate a signed certificate and send it directly to the newly launched instance.**
4. Configure the launched instances to generate a new certificate upon first boot. Have the Key management service poll the AutoScaling group for associated instances and send new instances a certificate signature that contains the specific instance-id.

**Question 6**

When assessing an organization AWS use of AWS API access credentials which of the following three credentials should be evaluated? Choose 3 answers

1. Key pairs
2. **Console passwords**
3. **Access keys**
4. **Signing certificates**
5. Security Group memberships \(required for EC2 instance access\)

**Question 7**

Your organization’s security policy requires that all privileged users either use frequently rotated passwords or one-time access credentials in addition to username/password. Which two of the following options would allow an organization to enforce this policy for AWS users? Choose 2 answers

1. **Configure multi-factor authentication for privileged IAM users**
2. **Create IAM users for privileged accounts \(**can set password policy**\)**
3. Implement identity federation between your organization’s Identity provider leveraging the IAM Security Token Service
4. Enable the IAM single-use password policy option for privileged users \(no such option the password expiration can be set from 1 to 1095 days\)

**Question 8**

A company needs to deploy services to an AWS region which they have not previously used. The company currently has an AWS identity and Access Management \(IAM\) role for the Amazon EC2 instances, which permits the instance to have access to Amazon DynamoDB. The company wants their EC2 instances in the new region to have the same privileges. How should the company achieve this?

1. Create a new IAM role and associated policies within the new region
2. **Assign the existing IAM role to the Amazon EC2 instances in the new region**
3. Copy the IAM role and associated policies to the new region and attach it to the instances
4. Create an Amazon Machine Image \(AMI\) of the instance and copy it to the desired region using the AMI Copy feature

**Question 9**

When you use the AWS Management Console to delete an IAM user, IAM also deletes any signing certificates and any access keys belonging to the user.

1. FALSE
2. This is configurable
3. **TRUE**

**Question 10**

You are setting up a blog on AWS. In which of the following scenarios will you need AWS credentials? \(Choose 3\)

1. **Sign in to the AWS management console to launch an Amazon EC2 instance**
2. Sign in to the running instance to instance some software \(needs ssh keys\)
3. **Launch an Amazon RDS instance**
4. Log into your blog’s content management system to write a blog post \(need to authenticate using blog authentication\)
5. **Post pictures to your blog on Amazon S3**

**Question 11**

You have a business-to-business web application running in a VPC consisting of an Elastic Load Balancer \(ELB\), web servers, application servers and a database. Your web application should only accept traffic from predefined customer IP addresses. Which two options meet this security requirement? Choose 2 answers

1. Configure web server VPC security groups to allow traffic from your customers’ IPs \(
   Web server is behind the ELB and customer IPs will never reach web servers\)
2. **Configure your web servers to filter traffic based on the ELB’s “X-forwarded-for” header**
   \(get the customer IPs and create a custom filter to restrict access. Refer [link](https://aws.amazon.com/premiumsupport/knowledge-center/log-client-ip-load-balancer-apache/)\)
3. **Configure ELB security groups to allow traffic from your customers’ IPs and deny all outbound traffic**
   \(ELB will see the customer IPs so can restrict access, deny all is basically have no rules in outbound traffic, implicit, and its stateful so would work\)
4. Configure a VPC NACL to allow web traffic from your customers’ IPs and deny all outbound traffic \(NACL is stateless, deny all will not work\)

**Question 12**

A user has created a VPC with public and private subnets using the VPC wizard. Which of the below mentioned statements is true in this scenario?

1. AWS VPC will automatically create a NAT instance with the micro size
2. **VPC bounds the main route table with a private subnet and a custom route table with a public subnet**
3. User has to manually create a NAT instance
4. VPC bounds the main route table with a public subnet and a custom route table with a private subnet

**Question 13**

A user has launched an EC2 instance and installed a website with the Apache webserver. The webserver is running but the user is not able to access the website from the Internet. What can be the possible reason for this failure?

1. **The security group of the instance is not configured properly.**
2. The instance is not configured with the proper key-pairs.
3. The Apache website cannot be accessed from the Internet.
4. Instance is not configured with an elastic IP.

**Question 14**

A user has created a VPC with public and private subnets using the VPC wizard. Which of the below mentioned statements is true in this scenario?

1. AWS VPC will automatically create a NAT instance with the micro size
2. **VPC bounds the main route table with a private subnet and a custom route table with a public subnet**
3. User has to manually create a NAT instance
4. VPC bounds the main route table with a public subnet and a custom route table with a private subnet

**Question 15**

A user has created a VPC with CIDR 20.0.0.0/16. The user has created one subnet with CIDR 20.0.0.0/16 by mistake. The user is trying to create another subnet of CIDR 20.0.0.1/24. How can the user create the second subnet?

1. There is no need to update the subnet as VPC automatically adjusts the CIDR of the first subnet based on the second subnet’s CIDR
2. The user can modify the first subnet CIDR from the console
3. **It is not possible to create a second subnet as one subnet with the same CIDR as the VPC has been created**
4. The user can modify the first subnet CIDR with AWS CLI

**Question 16**

A user has setup a VPC with CIDR 20.0.0.0/16. The VPC has a private subnet \(20.0.1.0/24\) and a public subnet \(20.0.0.0/24\). The user’s data centre has CIDR of 20.0.54.0/24 and 20.1.0.0/24. If the private subnet wants to communicate with the data centre, what will happen?

1. It will allow traffic communication on both the CIDRs of the data centre
2. It will not allow traffic with data centre on CIDR 20.1.0.0/24 but allows traffic communication on 20.0.54.0/24
3. It will not allow traffic communication on any of the data centre CIDRs
4. **It will allow traffic with data centre on CIDR 20.1.0.0/24 but does not allow on 20.0.54.0/24**
   \(as the CIDR block would be overlapping\)

**Question 17**

A user has created a subnet in VPC and launched an EC2 instance within it. The user has not selected the option to assign the IP address while launching the instance. Which of the below mentioned statements is true with respect to the Instance requiring access to the Internet?

1. The instance will always have a public DNS attached to the instance by default
2. The user can directly attach an elastic IP to the instance
3. The instance will never launch if the public IP is not assigned
4. **The user would need to create an internet gateway and then attach an elastic IP to the instance to connect from internet**

**Question 18**

A user has created a VPC with CIDR 20.0.0.0/16 using VPC Wizard. The user has created a public CIDR \(20.0.0.0/24\) and a VPN only subnet CIDR \(20.0.1.0/24\) along with the hardware VPN access to connect to the user’s data centre. Which of the below mentioned components is not present when the VPC is setup with the wizard?

1. Main route table attached with a VPN only subnet
2. **A NAT instance configured to allow the VPN subnet instances to connect with the internet**
3. Custom route table attached with a public subnet
4. An internet gateway for a public subnet

**Question 19**

A user has created a VPC with CIDR 20.0.0.0/16. The user has created public and VPN only subnets along with hardware VPN access to connect to the user’s datacenter. The user wants to make so that all traffic coming to the public subnet follows the organization’s proxy policy. How can the user make this happen?

1. Setting up a NAT with the proxy protocol and configure that the public subnet receives traffic from NAT
2. Setting up a proxy policy in the internet gateway connected with the public subnet
3. It is not possible to setup the proxy policy for a public subnet
4. **Setting the route table and security group of the public subnet which receives traffic from a virtual private gateway**

**Question 20**

Which two components provide connectivity with external networks? When attached to an Amazon VPC which two components provide connectivity with external networks? Choose 2 answers

1. Elastic IPs \(EIP\) \(Does not provide connectivity, public IP address will do as well\)
2. NAT Gateway \(NAT\) \(Not Attached to VPC and still needs IGW\)
3. **Internet Gateway \(IGW\)**
4. **Virtual Private Gateway \(VGW\)**

**Question 21**

If you want to launch Amazon Elastic Compute Cloud \(EC2\) Instances and assign each Instance a predetermined private IP address you should:

1. Assign a group or sequential Elastic IP address to the instances
2. Launch the instances in a Placement Group
3. **Launch the instances in the Amazon virtual Private Cloud \(VPC\)**
4. Use standard EC2 instances since each instance gets a private Domain Name Service \(DNS\) already
5. Launch the Instance from a private Amazon Machine image \(AMI\)

**Question 22**

You have an Amazon VPC with one private subnet and one public subnet with a Network Address Translator \(NAT\) server. You are creating a group of Amazon Elastic Cloud Compute \(EC2\) instances that configure themselves at startup via downloading a bootstrapping script from Amazon Simple Storage Service \(S3\) that deploys an application via GIT. Which setup provides the highest level of security?

1. **Amazon EC2 instances in private subnet, no EIPs, route outgoing traffic via the NAT**
2. Amazon EC2 instances in public subnet, no EIPs, route outgoing traffic via the Internet Gateway \(IGW\)
3. Amazon EC2 instances in private subnet, assign EIPs, route outgoing traffic via the Internet Gateway \(IGW\)
4. Amazon EC2 instances in public subnet, assign EIPs, route outgoing traffic via the NAT

**Question 23**

Can I move a Reserved Instance from one Region to another?

1. **No**
2. Only if they are moving into GovCloud
3. Yes
4. Only if they are moving to US East from another region

**Question 24**

A user has enabled termination protection on an EC2 instance. The user has also set Instance initiated shutdown behavior to terminate. When the user shuts down the instance from the OS, what will happen?

1. The OS will shutdown but the instance will not be terminated due to protection
2. **It will terminate the instance**
3. It will not allow the user to shutdown the instance from the OS
4. It is not possible to set the termination protection when an Instance initiated shutdown is set to Terminate

**Question 25**

A user has launched an EC2 instance and deployed a production application in it. The user wants to prohibit any mistakes from the production team to avoid accidental termination. How can the user achieve this?

1. **The user can the set DisableApiTermination attribute to avoid accidental termination**
2. It is not possible to avoid accidental termination
3. The user can set the Deletion termination flag to avoid accidental termination
4. The user can set the InstanceInitiatedShutdownBehavior flag to avoid accidental termination

**Question 26**

You have been doing a lot of testing of your VPC Network by deliberately failing EC2 instances to test whether instances are failing over properly. Your customer who will be paying the AWS bill for all this asks you if he being charged for all these instances. You try to explain to him how the billing works on EC2 instances to the best of your knowledge. What would be an appropriate response to give to the customer in regards to this?

1. Billing commences when Amazon EC2 AMI instance is completely up and billing ends as soon as the instance starts to shutdown.
2. **Billing commences when Amazon EC2 initiates the boot sequence of an AMI instance and billing ends when the instance shuts down.**
3. Billing only commences only after 1 hour of uptime and billing ends when the instance terminates.
4. Billing commences when Amazon EC2 initiates the boot sequence of an AMI instance and billing ends as soon as the instance starts to shutdown.

**Question 27**

When you view the block device mapping for your instance, you can see only the EBS volumes, not the instance store volumes.

1. Depends on the instance type
2. FALSE
3. Depends on whether you use API call
4. **TRUE**

**Question 28**

Which of the following will occur when an EC2 instance in a VPC \(Virtual Private Cloud\) with an associated Elastic IP is stopped and started? \(Choose 2 answers\)

1. The Elastic IP will be dissociated from the instance
2. **All data on instance-store devices will be lost**
3. All data on EBS \(Elastic Block Store\) devices will be lost
4. The ENI \(Elastic Network Interface\) is detached
5. **The underlying host for the instance is changed**

**Question 29**

A user has created numerous EBS volumes. What is the general limit for each AWS account for the maximum number of EBS volumes that can be created?

1. 10000
2. **5000**
3. 100
4. 1000

**Question 30**

Select the correct set of steps for exposing the snapshot only to specific AWS accounts

1. Select Public for all the accounts and check mark those accounts with whom you want to expose the snapshots and click save.
2. **Select Private and enter the IDs of those AWS accounts, and click Save.**
3. Select Public, enter the IDs of those AWS accounts, and click Save.
4. Select Public, mark the IDs of those AWS accounts as private, and click Save.

**Question 31**

Do the Amazon EBS volumes persist independently from the running life of an Amazon EC2 instance?

1. **Only if instructed to when created**
2. Yes
3. No

**Question 32**

Your company policies require encryption of sensitive data at rest. You are considering the possible options for protecting data while storing it at rest on an EBS data volume, attached to an EC2 instance. Which of these options would allow you to encrypt your data at rest? \(Choose 3 answers\)

1. **Implement third party volume encryption tools**
2. Do nothing as EBS volumes are encrypted by default
3. **Encrypt data inside your applications before storing it on EBS**
4. **Encrypt data using native data encryption drivers at the file system level**
5. Implement SSL/TLS for all services running on the server

**Question 33**

How can you secure data at rest on an EBS volume?

1. Encrypt the volume using the S3 server-side encryption service
2. Attach the volume to an instance using EC2’s SSL interface.
3. Create an IAM policy that restricts read and write access to the volume.
4. Write the data randomly instead of sequentially.
5. **Use an encrypted file system on top of the EBS volume**

**Question 34**

A user has deployed an application on an EBS backed EC2 instance. For a better performance of application, it requires dedicated EC2 to EBS traffic. How can the user achieve this?

1. Launch the EC2 instance as EBS dedicated with PIOPS EBS
2. Launch the EC2 instance as EBS enhanced with PIOPS EBS
3. Launch the EC2 instance as EBS dedicated with PIOPS EBS
4. **Launch the EC2 instance as EBS optimized with PIOPS EBS**

**Question 35**

You are running a database on an EC2 instance, with the data stored on Elastic Block Store \(EBS\) for persistence At times throughout the day, you are seeing large variance in the response times of the database queries Looking into the instance with the isolate command you see a lot of wait time on the disk volume that the database’s data is stored on. What two ways can you improve the performance of the database’s storage while maintaining the current persistence of the data? Choose 2 answers

1. Move to an SSD backed instance
2. **Move the database to an EBS-Optimized Instance**
3. **Use Provisioned IOPs EBS**
4. Use the ephemeral storage on an m2.4xLarge Instance Instead

**Question 36**

An organization wants to move to Cloud. They are looking for a secure encrypted database storage option. Which of the below mentioned AWS functionalities helps them to achieve this?

1. AWS MFA with EBS
2. **AWS EBS encryption**
3. Multi-tier encryption with Redshift
4. AWS S3 server-side storage

**Question 37**

A user is planning to use EBS for his DB requirement. The user already has an EC2 instance running in the VPC private subnet. How can the user attach the EBS volume to a running instance?

1. The user must create EBS within the same VPC and then attach it to a running instance.
2. **The user can create EBS in the same zone as the subnet of instance and attach that EBS to instance.**
   \(Should be in the same AZ\)
3. It is not possible to attach an EBS to an instance running in VPC until the instance is stopped.
4. The user can specify the same subnet while creating EBS and then attach it to a running instance.

**Question 38**

You are designing an enterprise data storage system. Your data management software system requires mountable disks and a real filesystem, so you cannot use S3 for storage. You need persistence, so you will be using AWS EBS Volumes for your system. The system needs as low-cost storage as possible, and access is not frequent or high throughput, and is mostly sequential reads. Which is the most appropriate EBS Volume Type for this scenario?

1. gp1
2. io1
3. **standard**\(Standard or Magnetic volumes are suited for cold workloads where data is infrequently accessed, or scenarios where the lowest storage cost is important\)
4. gp2 

**Question 39**

Which EBS volume type is best for high performance NoSQL cluster deployments?

1. **io1**\(io1 volumes, or Provisioned IOPS \(PIOPS\) SSDs, are best for: Critical business applications that require sustained IOPS performance, or more than 10,000 IOPS or 160 MiB/s of throughput per volume, like large database workloads, such as MongoDB.\)
2. gp1
3. standard
4. gp2

**Question 40**

Provisioned IOPS Costs: you are charged for the IOPS and storage whether or not you use them in a given month.

1. FALSE
2. **TRUE**

**Question 41**

A user is trying to create a PIOPS EBS volume with 8 GB size and 200 IOPS. Will AWS create the volume?

1. **Yes, since the ratio between EBS and IOPS is less than 30**
2. No, since the PIOPS and EBS size ratio is less than 30
3. No, the EBS size is less than 10 GB
4. Yes, since PIOPS is higher than 100

**Question 42**

A user has provisioned 2000 IOPS to the EBS volume. The application hosted on that EBS is experiencing less IOPS than provisioned. Which of the below mentioned options does not affect the IOPS of the volume?

1. The application does not have enough IO for the volume
2. Instance is EBS optimized
3. The EC2 instance has 10 Gigabit Network connectivity
4. **Volume size is too large**

**Question 43**

A user is trying to create a PIOPS EBS volume with 4000 IOPS and 100 GB size. AWS does not allow the user to create this volume. What is the possible root cause for this?

1. **The ratio between IOPS and the EBS volume is higher than 30**
2. The maximum IOPS supported by EBS is 3000
3. The ratio between IOPS and the EBS volume is lower than 50
4. PIOPS is supported for EBS higher than 500 GB size

**Question 44**

Which of the following approaches provides the lowest cost for Amazon Elastic Block Store snapshots while giving you the ability to fully restore data?

1. Maintain two snapshots: the original snapshot and the latest incremental snapshot
2. Maintain a volume snapshot; subsequent snapshots will overwrite one another
3. **Maintain a single snapshot the latest snapshot is both Incremental and complete**
4. Maintain the most current snapshot, archive the original and incremental to Amazon Glacier.

**Question 45**

What will be the status of the snapshot until the snapshot is complete?

1. Running
2. Working
3. Progressing
4. **Pending**

**Question 46**

How are the EBS snapshots saved on Amazon S3?

1. Exponentially
2. **Incrementally**
3. EBS snapshots are not stored in the Amazon S3
4. Decrementally

**Question 47**

Amazon EBS snapshots have which of the following two characteristics? \(Choose 2.\) Choose 2 answers

1. **EBS snapshots only save incremental changes from snapshot to snapshot**
2. **EBS snapshots can be created in real-time without stopping an EC2 instance**
   \(the snapshot can be taken real time however it will not be consistent and the recommended way is to stop or freeze the IO\)
3. EBS snapshots can only be restored to an EBS volume of the same size or smaller \(EBS volume restored from snapshots need to be of the same size of larger size\)
4. EBS snapshots can only be restored and mounted to an instance in the same Availability Zone as the original EBS volume
   **\(**Snapshots are specific to Region and can be used to create a volume in any AZ and does not depend on the original EBS volume AZ**\)**

**Question 48**

When creation of an EBS snapshot is initiated but not completed, the EBS volume

1. Cannot be detached or attached to an EC2 instance until me snapshot completes
2. Can be used in read-only mode while me snapshot is in progress
3. **Can be used while the snapshot is in progress**
4. Cannot be used until the snapshot completes

**Question 49**

A user is creating a snapshot of an EBS volume. Which of the below statements is incorrect in relation to the creation of an EBS snapshot?

1. Its incremental
2. It can be used to launch a new instance
3. **It is stored in the same AZ as the volume**
   \(stored in the same region\)
4. It is a point in time backup of the EBS volume

**Question 50**

A user has created a snapshot of an EBS volume. Which of the below mentioned usage cases is not possible with respect to a snapshot?

1. Mirroring the volume from one AZ to another AZ
2. Launch an instance
3. **Decrease the volume size**
4. Increase the size of the volume

**Question 51**

There is a very serious outage at AWS. EC2 is not affected, but your EC2 instance deployment scripts stopped working in the region with the outage. What might be the issue?

1. The AWS Console is down, so your CLI commands do not work.
2. **S3 is unavailable, so you can’t create EBS volumes from a snapshot you use to deploy new volumes.**
   \(EBS volume snapshots are stored in S3. If S3 is unavailable, snapshots are unavailable\)
3. AWS turns off the DeployCode API call when there are major outages, to protect from system floods.
4. None of the other answers make sense. If EC2 is not affected, it must be some other issue.

**Question 52**

A user has created an EBS volume of 10 GB and attached it to a running instance. The user is trying to access EBS for first time. Which of the below mentioned options is the correct statement with respect to a first time EBS access?

1. The volume will show a size of 8 GB
2. **The volume will show a loss of the IOPS performance the first time**
   \(the volume needed to be wiped cleaned before for new volumes, however pre warming is not needed any more\)
3. The volume will be blank
4. If the EBS is mounted it will ask the user to create a file system



