1. You are implementing a URL whitelisting system for a company that wants to restrict outbound HTTP’S connections to specific domains from their EC2-hosted applications you deploy a single EC2 instance running proxy software and configure It to accept traffic from all subnets and EC2 instances in the VPC. You configure the proxy to only pass through traffic to domains that you define in its whitelist configuration You have a nightly maintenance window or 10 minutes where ail instances fetch new software updates. Each update Is about 200MB In size and there are 500 instances In the VPC that routinely fetch updates After a few days you notice that some machines are failing to successfully download some, but not all of their updates within the maintenance window The download URLs used for these updates are correctly listed in the proxy’s whitelist configuration and you are able to access them manually using a web browser on the instances What might be happening? \(Choose 2 answers\)  
   **\[PROFESSIONAL\]**  
   1. **You are running the proxy on an undersized EC2 instance type so network throughput is not sufficient for all instances to download their updates in time.**  
   2. You have not allocated enough storage to the EC2 instance running me proxy so the network buffer is filling up causing some requests to fall  
   3. You are running the proxy in a public subnet but have not allocated enough EIPs to support the needed network throughput through the Internet Gateway \(IGW\)  
   4. **You are running the proxy on a affluently-sized EC2 instance in a private subnet and its network throughput is being throttled by a NAT running on an undersized EC2 instance**  
   5. The route table for the subnets containing the affected EC2 instances is not configured to direct network traffic for the software update locations to the proxy.

2. You have been asked to design the storage layer for an application. The application requires disk performance of at least 100,000 IOPS in addition; the storage layer must be able to survive the loss of an individual disk, EC2 instance, or Availability Zone without any data loss. The volume you provide must have a capacity of at least 3TB. Which of the following designs will meet these objectives?  
   **\[PROFESSIONAL\]**  
   1. Instantiate an i2.8xlarge instance in us-east-1a. Create a RAID 0 volume using the four 800GB SSD ephemeral disks provided with the instance. Provision 3×1 TB EBS volumes attach them to the instance and configure them as a second RAID 0 volume. Configure synchronous, block-level replication from the ephemeral backed volume to the EBS-backed volume. \(  
      Same AZ will not survive the AZ loss\)  
   2. **Instantiate an i2.8xlarge instance in us-east-1a. Create a RAID 0 volume using the four 800GB SSD ephemeral disks provided with the Instance Configure synchronous block-level replication to an identically configured Instance in us-east-1b.**  
   3. Instantiate a c3.8xlarge Instance in us-east-1. Provision an AWS Storage Gateway and configure it for 3 TB of storage and 100,000 IOPS. Attach the volume to the instance. \(Need synchronous replication to prevent any data loss\)  
   4. Instantiate a c3.8xlarge instance in us-east-1 provision 4x1TB EBS volumes, attach them to the instance, and configure them as a single RAID 5 volume Ensure that EBS snapshots are performed every 15 minutes. \(RAID 5 not recommended by AWS and Need synchronous replication to prevent any data loss\)  
   5. Instantiate a c3 8xlarge Instance in us-east-1 Provision 3x1TB EBS volumes attach them to the instance, and configure them as a single RAID 0 volume Ensure that EBS snapshots are performed every 15 minutes. \(Need synchronous replication to prevent any data loss\)

3. An application you maintain consists of multiple EC2 instances in a default tenancy VPC. This application has undergone an internal audit and has been determined to require dedicated hardware for one instance. Your compliance team has given you a week to move this instance to single-tenant hardware. Which process will have minimal impact on your application while complying with this requirement?

   1. Create a new VPC with tenancy=dedicated and migrate to the new VPC
      \(possible but impact not minimal\)
   2. Use ec2-reboot-instances command line and set the parameter “dedicated=true”
   3. Right click on the instance, select properties and check the box for dedicated tenancy
   4. **Stop the instance, create an AMI, launch a new instance with tenancy=dedicated, and terminate the old instance**

4. Your department creates regular analytics reports from your company’s log files. All log data is collected in Amazon S3 and processed by daily Amazon Elastic Map Reduce \(EMR\) jobs that generate daily PDF reports and aggregated tables in CSV format for an Amazon Redshift data warehouse. Your CFO requests that you optimize the cost structure for this system. Which of the following alternatives will lower costs without compromising average performance of the system or data integrity for the raw data?  
   **\[PROFESSIONAL\]**  
   1. Use reduced redundancy storage \(RRS\) for PDF and CSV data in Amazon S3. Add Spot instances to Amazon EMR jobs. Use Reserved Instances for Amazon Redshift. \(Spot instances impacts performance\)  
   2. **Use reduced redundancy storage \(RRS\) for all data in S3. Use a combination of Spot instances and Reserved Instances for Amazon EMR jobs. Use Reserved instances for Amazon Redshift**  
      \(Combination of the Spot and reserved with guarantee performance and help reduce cost. Also, RRS would reduce cost and guarantee data integrity, which is different from data durability \)  
   3. Use reduced redundancy storage \(RRS\) for all data in Amazon S3. Add Spot Instances to Amazon EMR jobs. Use Reserved Instances for Amazon Redshift \(Spot instances impacts performance\)  
   4. Use reduced redundancy storage \(RRS\) for PDF and CSV data in S3. Add Spot Instances to EMR jobs. Use Spot Instances for Amazon Redshift. \(Spot instances impacts performance\)

5. A research scientist is planning for the one-time launch of an Elastic MapReduce cluster and is encouraged by her manager to minimize the costs. The cluster is designed to ingest 200TB of genomics data with a total of 100 Amazon EC2 instances and is expected to run for around four hours. The resulting data set must be stored temporarily until archived into an Amazon RDS Oracle instance. Which option will help save the most money while meeting requirements?  
   **\[PROFESSIONAL\]**  
   1. **Store ingest and output files in Amazon S3. Deploy on-demand for the master and core nodes and spot for the task nodes.**  
   2. Optimize by deploying a combination of on-demand, RI and spot-pricing models for the master, core and task nodes. Store ingest and output files in Amazon S3 with a lifecycle policy that archives them to Amazon Glacier. \(  
      Reserved Instance not cost effective for 4 hour job and data not needed in S3 once moved to RDS\)  
   3. Store the ingest files in Amazon S3 RRS and store the output files in S3. Deploy Reserved Instances for the master and core nodes and on-demand for the task nodes. \(Reserved Instance not cost effective\)  
   4. Deploy on-demand master, core and task nodes and store ingest and output files in Amazon S3 RRS \(  
      RRS provides not much cost benefits for a 4 hour job while the amount of input data would take time to upload and Output data to reproduce\)

6. A company currently has a highly available web application running in production. The application’s web front-end utilizes an Elastic Load Balancer and Auto scaling across 3 availability zones. During peak load, your web servers operate at 90% utilization and leverage a combination of heavy utilization reserved instances for steady state load and on-demand and spot instances for peak load. You are asked with designing a cost effective architecture to allow the application to recover quickly in the event that an availability zone is unavailable during peak load. Which option provides the most cost effective high availability architectural design for this application?  
   **\[PROFESSIONAL\]**  
   1. **Increase auto scaling capacity and scaling thresholds to allow the web-front to cost-effectively scale across all availability zones to lower aggregate utilization levels that will allow an availability zone to fail during peak load without affecting the applications availability.**  
      \(Ideal for HA to reduce and distribute load\)  
   2. Continue to run your web front-end at 90% utilization, but purchase an appropriate number of utilization RIs in each availability zone to cover the loss of any of the other availability zones during peak load. \(  
      90% is not recommended as well RIs would increase the cost\)  
   3. Continue to run your web front-end at 90% utilization, but leverage a high bid price strategy to cover the loss of any of the other availability zones during peak load. \(  
      90% is not recommended as high bid price would not guarantee instances and would increase cost\)  
   4. Increase use of spot instances to cost effectively to scale the web front-end across all availability zones to lower aggregate utilization levels that will allow an availability zone to fail during peak load without affecting the applications availability. \(Availability cannot be guaranteed\)

7. You run accounting software in the AWS cloud. This software needs to be online continuously during the day every day of the week, and has a very static requirement for compute resources. You also have other, unrelated batch jobs that need to run once per day at any time of your choosing. How should you minimize cost?  
   **\[PROFESSIONAL\]**  
   1. **Purchase a Heavy Utilization Reserved Instance to run the accounting software. Turn it off after hours. Run the batch jobs with the same instance class, so the Reserved Instance credits are also applied to the batch jobs.**  
      \(Because the instance will always be online during the day, in a predictable manner, and there are sequences of batch jobs to perform at any time, we should run the batch jobs when the account software is off. We can achieve Heavy Utilization by alternating these times, so we should purchase the reservation as such, as this represents the lowest cost. There is no such thing a “Full” level utilization purchases on EC2.\)  
   2. Purchase a Medium Utilization Reserved Instance to run the accounting software. Turn it off after hours. Run the batch jobs with the same instance class, so the Reserved Instance credits are also applied to the batch jobs.  
   3. Purchase a Light Utilization Reserved Instance to run the accounting software. Turn it off after hours. Run the batch jobs with the same instance class, so the Reserved Instance credits are also applied to the batch jobs.  
   4. Purchase a Full Utilization Reserved Instance to run the accounting software. Turn it off after hours. Run the batch jobs with the same instance class, so the Reserved Instance credits are also applied to the batch jobs.

8. You have launched an EC2 instance with four \(4\) 500 GB EBS Provisioned IOPS volumes attached. The EC2 Instance is EBS-Optimized and supports 500 Mbps throughput between EC2 and EBS. The two EBS volumes are configured as a single RAID 0 device, and each Provisioned IOPS volume is provisioned with 4,000 IOPS \(4000 16KB reads or writes\) for a total of 16,000 random IOPS on the instance. The EC2 Instance initially delivers the expected 16,000 IOPS random read and write performance. Sometime later in order to increase the total random I/O performance of the instance, you add an additional two 500 GB EBS Provisioned IOPS volumes to the RAID. Each volume is provisioned to 4,000 IOPS like the original four for a total of 24,000 IOPS on the EC2 instance Monitoring shows that the EC2 instance CPU utilization increased from 50% to 70%, but the total random IOPS measured at the instance level does not increase at all. What is the problem and a valid solution?  
   1. Larger storage volumes support higher Provisioned IOPS rates: increase the provisioned volume storage of each of the 6 EBS volumes to 1TB.  
   2. **EBS-Optimized throughput limits the total IOPS that can be utilized use an EBS-Optimized instance that provides larger throughput. \(**[EC2 Instance types](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-ec2-config.html) have limit on max throughput and would require larger instance types to provide 24000 IOPS**\)**  
   3. Small block sizes cause performance degradation, limiting the I’O throughput, configure the instance device driver and file system to use 64KB blocks to increase throughput.  
   4. RAID 0 only scales linearly to about 4 devices, use RAID 0 with 4 EBS Provisioned IOPS volumes but increase each Provisioned IOPS EBS volume to 6.000 IOPS.  
   5. The standard EBS instance root volume limits the total IOPS rate, change the instant root volume to also be a 500GB 4,000 Provisioned IOPS volume

9. You are tasked with moving a legacy application from a virtual machine running inside your datacenter to an Amazon VPC. Unfortunately this app requires access to a number of on-premises services and no one who configured the app still works for your company. Even worse there’s no documentation for it. What will allow the application running inside the VPC to reach back and access its internal dependencies without being reconfigured? \(Choose 3 answers\)  
   1. **An AWS Direct Connect link between the VPC and the network housing the internal services**  
      \(VPN or a DX for communication\)  
   2. An Internet Gateway to allow a VPN connection. \(Virtual and Customer gateway is needed\)  
   3. An Elastic IP address on the VPC instance \(Don’t need a EIP as private subnets can also interact with on-premises network\)  
   4. **An IP address space that does not conflict with the one on-premises**  
      \(IP address cannot conflict\)  
   5. Entries in Amazon Route 53 that allow the Instance to resolve its dependencies’ IP addresses \(Route 53 is not required\)  
   6. **A VM Import of the current virtual machine**  
      \(VM Import to copy the VM to AWS as there is no documentation it can’t be configured from scratch\)

**Questions 10**

Your customer needs to create an application to allow contractors to upload videos to Amazon Simple Storage Service \(S3\) so they can be transcoded into a different format. She creates AWS Identity and Access Management \(IAM\) users for her application developers, and in just one week, they have the application hosted on a fleet of Amazon Elastic Compute Cloud \(EC2\) instances. The attached IAM role is assigned to the instances. As expected, a contractor who authenticates to the application is given a pre-signed URL that points to the location for video upload. However, contractors are reporting that they cannot upload their videos. Which of the following are valid reasons for this behavior? Choose 2 answers { “Version”: “2012-10-17”, “Statement”: \[ { “Effect”: “Allow”, “Action”: “s3:\*”, “Resource”: “\*” } \] }

1. The IAM role does not explicitly grant permission to upload the object. \(The role has all permissions for all activities on S3\)
2. The contractorsˈ accounts have not been granted “write” access to the S3 bucket. \(using pre-signed urls the contractors account don’t need to have access but only the creator of the pre-signed urls\)
3. **The application is not using valid security credentials to generate the pre-signed URL.**
4. The developers do not have access to upload objects to the S3 bucket. \(developers are not uploading the objects but its using pre-signed urls\)
5. The S3 bucket still has the associated default permissions. \(does not matter as long as the user has permission to upload\)
6. **The pre-signed URL has expired.**

**Questions 11**

Company ABCD is currently hosting their corporate site in an Amazon S3 bucket with Static Website Hosting enabled. Currently, when visitors go to [http://www.companyabcd.com](http://www.companyabcd.com) the index.html page is returned. Company C now would like a new page welcome.html to be returned when a visitor enters [http://www.companyabcd.com](http://www.companyabcd.com) in the browser. Which of the following steps will allow Company ABCD to meet this requirement? Choose 2 answers.

1. **Upload an html page named welcome.html to their S3 bucket**
2. Create a welcome subfolder in their S3 bucket
3. **Set the Index Document property to welcome.html**
4. Move the index.html page to a welcome subfolder
5. Set the Error Document property to welcome.html



**Questions 12**

ou have a proprietary data store on-premises that must be backed up daily by dumping the data store contents to a single compressed 50GB file and sending the file to AWS. Your SLAs state that any dump file backed up within the past 7 days can be retrieved within 2 hours. Your compliance department has stated that all data must be held indefinitely. The time required to restore the data store from a backup is approximately 1 hour. Your on-premise network connection is capable of sustaining 1gbps to AWS. Which backup methods to AWS would be most cost-effective while still meeting all of your requirements?

1. Send the daily backup files to Glacier immediately after being generated \(will not meet the RTO\)
2. Transfer the daily backup files to an EBS volume in AWS and take daily snapshots of the volume \(Not cost effective\)
3. Transfer the daily backup files to S3 and use appropriate bucket lifecycle policies to send to Glacier \(Store in S3 for seven days and then archive to Glacier\)
4. Host the backup files on a Storage Gateway with Gateway-Cached Volumes and take daily snapshots \(Not Cost effective as local storage as well as S3 storage\)



