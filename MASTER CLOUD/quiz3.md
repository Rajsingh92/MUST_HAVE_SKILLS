**Qestion 1**

You have a business critical two tier web app currently deployed in two availability zones in a single region, using Elastic Load Balancing and Auto Scaling. The app depends on synchronous replication \(very low latency connectivity\) at the database layer. The application needs to remain fully available even if one application Availability Zone goes off-line, and Auto scaling cannot launch new instances in the remaining Availability Zones. How can the current architecture be enhanced to ensure this?

**\[PROFESSIONAL\]**

1. Deploy in two regions using Weighted Round Robin \(WRR\), with Auto Scaling minimums set for 100% peak load per region.
2. **Deploy in three AZs, with Auto Scaling minimum set to handle 50% peak load per zone.**
3. Deploy in three AZs, with Auto Scaling minimum set to handle 33% peak load per zone. \(
   Loss of one AZ will handle only 66% if the autoscaling also fails\)
4. Deploy in two regions using Weighted Round Robin \(WRR\), with Auto Scaling minimums set for 50% peak load per region.

**Qestion 2**

Your startup wants to implement an order fulfillment process for selling a personalized gadget that needs an average of 3-4 days to produce with some orders taking up to 6 months you expect 10 orders per day on your first day. 1000 orders per day after 6 months and 10,000 orders after 12 months. Orders coming in are checked for consistency then dispatched to your manufacturing plant for production quality control packaging shipment and payment processing. If the product does not meet the quality standards at any stage of the process employees may force the process to repeat a step. Customers are notified via email about order status and any critical issues with their orders such as payment failure. Your case architecture includes AWS Elastic Beanstalk for your website with an RDS MySQL instance for customer data and orders. How can you implement the order fulfillment process while making sure that the emails are delivered reliably?

**\[PROFESSIONAL\]**

1. Add a business process management application to your Elastic Beanstalk app servers and re-use the ROS database for tracking order status use one of the Elastic Beanstalk instances to send emails to customers.
2. Use SWF with an Auto Scaling group of activity workers and a decider instance in another Auto Scaling group with min/max=1 Use the decider instance to send emails to customers.
3. **Use SWF with an Auto Scaling group of activity workers and a decider instance in another Auto Scaling group with min/max=1 use SES to send emails to customers.**
4. Use an SQS queue to manage all process tasks Use an Auto Scaling group of EC2 Instances that poll the tasks and execute them. Use SES to send emails to customers.

**Qestion 3**

A large enterprise wants to adopt CloudFormation to automate administrative tasks and implement the security principles of least privilege and separation of duties. They have identified the following roles with the corresponding tasks in the company: \(i\) network administrators: create, modify and delete VPCs, subnets, NACLs, routing tables, and security groups \(ii\) application operators: deploy complete application stacks \(ELB, Auto -Scaling groups, RDS\) whereas all resources must be deployed in the VPCs managed by the network administrators \(iii\) Both groups must maintain their own CloudFormation templates and should be able to create, update and delete only their own CloudFormation stacks. The company has followed your advice to create two IAM groups, one for applications and one for networks. Both IAM groups are attached to IAM policies that grant rights to perform the necessary task of each group as well as the creation, update and deletion of CloudFormation stacks. Given setup and requirements, which statements represent valid design considerations? Choose 2 answers

**\[PROFESSIONAL\]**

1. **Network stack updates will fail upon attempts to delete a subnet with EC2 instances**
   \(Subnets cannot be deleted with instances in them\)
2. Unless resource level permissions are used on the CloudFormation: DeleteStack action, network administrators could tear down application stacks \(
   Network administrators themselves need permission to delete resources within the application stack &
    CloudFormation makes calls to create, modify, and delete those resources on their behalf\)
3. The application stack cannot be deleted before all network stacks are deleted \(
   Application stack can be deleted before network stack\)
4. **Restricting the launch of EC2 instances into VPCs requires resource level permissions in the IAM policy of the application group**
   \(IAM permissions need to be given explicitly to launch instances\)
5. Nesting network stacks within application stacks simplifies management and debugging, but requires resource level permissions in the IAM policy of the network group \(
   Although stacks can be nested, Network group will need to have all the application group permissions\)

**Qestion 4**

A marketing research company has developed a tracking system that collects user behavior during web marketing campaigns on behalf of their customers all over the world. The tracking system consists of an auto-scaled group of Amazon Elastic Compute Cloud \(EC2\) instances behind an elastic load balancer \(ELB\), and the collected data is stored in Amazon DynamoDB. After the campaign is terminated, the tracking system is torn down and the data is moved to Amazon Redshift, where it is aggregated, analyzed and used to generate detailed reports. The company wants to be able to instantiate new tracking systems in any region without any manual intervention and therefore adopted AWS CloudFormation. What needs to be done to make sure that the AWS CloudFormation template works in every AWS region? Choose 2 answers

**\[PROFESSIONAL\]**

1. IAM users with the right to start AWS CloudFormation stacks must be defined for every target region. \(
   IAM users are global\)
2. The names of the Amazon DynamoDB tables must be different in every target region. \(
   DynamoDB names should be unique only within a region\)
3. **Use the built-in function of AWS CloudFormation to set the AvailabilityZone attribute of the ELB resource.**
4. Avoid using DeletionPolicies for EBS snapshots. \(
   Don’t want the data to be retained\)
5. **Use the built-in Mappings and FindInMap functions of AWS CloudFormation to refer to the AMI ID set in the ImageId attribute of the Auto Scaling::LaunchConfiguration resource.**

**Qestion 5**

A gaming company adopted AWS CloudFormation to automate load -testing of their games. They have created an AWS CloudFormation template for each gaming environment and one for the load -testing stack. The load – testing stack creates an Amazon Relational Database Service \(RDS\) Postgres database and two web servers running on Amazon Elastic Compute Cloud \(EC2\) that send HTTP requests, measure response times, and write the results into the database. A test run usually takes between 15 and 30 minutes. Once the tests are done, the AWS CloudFormation stacks are torn down immediately. The test results written to the Amazon RDS database must remain accessible for visualization and analysis. Select possible solutions that allow access to the test results after the AWS CloudFormation load -testing stack is deleted. Choose 2 answers.

**\[PROFESSIONAL\]**

1. **Define a deletion policy of type Retain for the Amazon QDS resource to assure that the RDS database is not deleted with the AWS CloudFormation stack.**
2. **Define a deletion policy of type Snapshot for the Amazon RDS resource to assure that the RDS database can be restored after the AWS CloudFormation stack is deleted.**
3. Define automated backups with a backup retention period of 30 days for the Amazon RDS database and perform point -in -time recovery of the database after the AWS CloudFormation stack is deleted. \(
   as the environment is required for limited time the automated backup will not serve the purpose\)
4. Define an Amazon RDS Read-Replica in the load-testing AWS CloudFormation stack and define a dependency relation between master and replica via the DependsOn attribute. \(
   read replica not needed and will be deleted when the stack is deleted\)
5. Define an update policy to prevent deletion of the Amazon RDS database after the AWS CloudFormation stack is deleted. \(
   UpdatePolicy does not apply to RDS\)

**Qestion 6**

ou need to deploy an AWS stack in a repeatable manner across multiple environments. You have selected CloudFormation as the right tool to accomplish this, but have found that there is a resource type you need to create and model, but is unsupported by CloudFormation. How should you overcome this challenge?

**\[PROFESSIONAL\]**

1. Use a CloudFormation Custom Resource Template by selecting an API call to proxy for create, update, and delete actions. CloudFormation will use the AWS SDK, CLI, or API method of your choosing as the state transition function for the resource type you are modeling.
2. Submit a ticket to the AWS Forums. AWS extends CloudFormation Resource Types by releasing tooling to the AWS Labs organization on GitHub. Their response time is usually 1 day, and they complete requests within a week or two.
3. Instead of depending on CloudFormation, use Chef, Puppet, or Ansible to author Heat templates, which are declarative stack resource definitions that operate over the OpenStack hypervisor and cloud environment.
4. **Create a CloudFormation Custom Resource Type by implementing create, update, and delete functionality, either by subscribing a Custom Resource Provider to an SNS topic, or by implementing the logic in AWS Lambda.**
   \(Refer [link](http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-custom-resources.html) \)

**Qestion 7**

Your company needs to automate 3 layers of a large cloud deployment. You want to be able to track this deployment’s evolution as it changes over time, and carefully control any alterations. What is a good way to automate a stack to meet these requirements?

**\[PROFESSIONAL\]**

1. Use OpsWorks Stacks with three layers to model the layering in your stack.
2. **Use CloudFormation Nested Stack Templates, with three child stacks to represent the three logical layers of your cloud.**
   \(CloudFormation allows source controlled, declarative templates as the basis for stack automation and Nested Stacks help achieve clean separation of layers while simultaneously providing a method to control all layers at once when needed\)
3. Use AWS Config to declare a configuration set that AWS should roll out to your cloud.
4. Use Elastic Beanstalk Linked Applications, passing the important DNS entries between layers using the metadata interface.

**Qestion 8**

You have been asked to de-risk deployments at your company. Specifically, the CEO is concerned about outages that occur because of accidental inconsistencies between Staging and Production, which sometimes cause unexpected behaviors in Production even when Staging tests pass. You already use Docker to get high consistency between Staging and Production for the application environment on your EC2 instances. How do you further de-risk the rest of the execution environment, since in AWS, there are many service components you may use beyond EC2 virtual machines?

**\[PROFESSIONAL\]**

1. **Develop models of your entire cloud system in CloudFormation. Use this model in Staging and Production to achieve greater parity.**
   \(Only CloudFormation’s JSON Templates allow declarative version control of repeatedly deployable models of entire AWS clouds. Refer [link](https://blogs.aws.amazon.com/application-management/blog/category/Best+practices)\)
2. Use AWS Config to force the Staging and Production stacks to have configuration parity. Any differences will be detected for you so you are aware of risks.
3. Use AMIs to ensure the whole machine, including the kernel of the virual machines, is consistent, since Docker uses Linux Container \(LXC\) technology, and we need to make sure the container environment is consistent.
4. Use AWS ECS and Docker clustering. This will make sure that the AMIs and machine sizes are the same across both environments.

**Qestion 9**

You require the ability to analyze a large amount of data, which is stored on Amazon S3 using Amazon Elastic Map Reduce. You are using the cc2.8xlarge instance type, who’s CPUs are mostly idle during processing. Which of the below would be the most cost efficient way to reduce the runtime of the job?

**\[PROFESSIONAL\]**

1. Create smaller files on Amazon S3.
2. Add additional cc2.8xlarge instances by introducing a task group.
3. **Use smaller instances that have higher aggregate I/O performance.**
4. Create fewer, larger files on Amazon S3.

**Qestion 10**

A customer’s nightly EMR job processes a single 2-TB data file stored on Amazon Simple Storage Service \(S3\). The Amazon Elastic Map Reduce \(EMR\) job runs on two On-Demand core nodes and three On-Demand task nodes. Which of the following may help reduce the EMR job completion time? Choose 2 answers

1. Use three Spot Instances rather than three On-Demand instances for the task nodes.
2. **Change the input split size in the MapReduce job configuration.**
3. Use a bootstrap action to present the S3 bucket as a local filesystem.
4. Launch the core nodes and task nodes within an Amazon Virtual Cloud.
5. **Adjust the number of simultaneous mapper tasks.**
6. Enable termination protection for the job flow.

**Qestion 11**

Your department creates regular analytics reports from your company’s log files. All log data is collected in Amazon S3 and processed by daily Amazon Elastic Map Reduce \(EMR\) jobs that generate daily PDF reports and aggregated tables in CSV format for an Amazon Redshift data warehouse. Your CFO requests that you optimize the cost structure for this system. Which of the following alternatives will lower costs without compromising average performance of the system or data integrity for the raw data?

**\[PROFESSIONAL\]**

1. Use reduced redundancy storage \(RRS\) for PDF and CSV data in Amazon S3. Add Spot instances to Amazon EMR jobs. Use Reserved Instances for Amazon Redshift. \(Only Spot instances impacts performance\)
2. **Use reduced redundancy storage \(RRS\) for all data in S3. Use a combination of Spot instances and Reserved Instances for Amazon EMR jobs. Use Reserved instances for Amazon Redshift**
   \(Combination of the Spot and reserved with guarantee performance and help reduce cost. Also, RRS would reduce cost and guarantee data integrity, which is different from data durability\)
3. Use reduced redundancy storage \(RRS\) for all data in Amazon S3. Add Spot Instances to Amazon EMR jobs. Use Reserved Instances for Amazon Redshift \(Only Spot instances impacts performance\)
4. Use reduced redundancy storage \(RRS\) for PDF and CSV data in S3. Add Spot Instances to EMR jobs. Use Spot Instances for Amazon Redshift. \(Spot instances impacts performance and Spot instance not available for Redshift\)

**Qestion 12**

A research scientist is planning for the one-time launch of an Elastic MapReduce cluster and is encouraged by her manager to minimize the costs. The cluster is designed to ingest 200TB of genomics data with a total of 100 Amazon EC2 instances and is expected to run for around four hours. The resulting data set must be stored temporarily until archived into an Amazon RDS Oracle instance. Which option will help save the most money while meeting requirements?

**\[PROFESSIONAL\]**

1. **Store ingest and output files in Amazon S3. Deploy on-demand for the master and core nodes and spot for the task nodes.**
2. Optimize by deploying a combination of on-demand, RI and spot-pricing models for the master, core and task nodes. Store ingest and output files in Amazon S3 with a lifecycle policy that archives them to Amazon Glacier. \(Master and Core must be RI or On Demand. Cannot be Spot\)
3. Store the ingest files in Amazon S3 RRS and store the output files in S3. Deploy Reserved Instances for the master and core nodes and on-demand for the task nodes. \(Need better durability for ingest file. Spot instances can be used for task nodes for cost saving. RI will not provide cost saving in this case\)
4. Deploy on-demand master, core and task nodes and store ingest and output files in Amazon S3 RRS \(
   Input should be in S3 standard, as re-ingesting the input data might end up being more costly then holding the data for limited time in standard S3\)

**Qestion 13**

Your company sells consumer devices and needs to record the first activation of all sold devices. Devices are not activated until the information is written on a persistent database. Activation data is very important for your company and must be analyzed daily with a MapReduce job. The execution time of the data analysis process must be less than three hours per day. Devices are usually sold evenly during the year, but when a new device model is out, there is a predictable peak in activation’s, that is, for a few days there are 10 times or even 100 times more activation’s than in average day. Which of the following databases and analysis framework would you implement to better optimize costs and performance for this workload?

**\[PROFESSIONAL\]**

1. Amazon RDS and Amazon Elastic MapReduce with Spot instances.
2. **Amazon DynamoDB and Amazon Elastic MapReduce with Spot instances.**
3. Amazon RDS and Amazon Elastic MapReduce with Reserved instances.
4. Amazon DynamoDB and Amazon Elastic MapReduce with Reserved instances

**Qestion 14**

You currently operate a web application in the AWS US-East region. The application runs on an auto-scaled layer of EC2 instances and an RDS Multi-AZ database. Your IT security compliance officer has tasked you to develop a reliable and durable logging solution to track changes made to your EC2, IAM and RDS resources. The solution must ensure the integrity and confidentiality of your log data. Which of these solutions would you recommend?

1. **Create a new CloudTrail trail with one new S3 bucket to store the logs and with the global services option selected. Use IAM roles, S3 bucket policies and Multi Factor Authentication \(MFA\) Delete on the S3 bucket that stores your logs. \(**
   Single New bucket with global services option for IAM and MFA delete for confidentiality**\)**
2. Create a new CloudTrail with one new S3 bucket to store the logs. Configure SNS to send log file delivery notifications to your management system. Use IAM roles and S3 bucket policies on the S3 bucket that stores your logs. \(Missing Global Services for IAM\)
3. Create a new CloudTrail trail with an existing S3 bucket to store the logs and with the global services option selected Use S3 ACLs and Multi Factor Authentication \(MFA\) Delete on the S3 bucket that stores your logs. \(Existing bucket prevents confidentiality\)
4. Create three new CloudTrail trails with three new S3 buckets to store the logs one for the AWS Management console, one for AWS SDKs and one for command line tools. Use IAM roles and S3 bucket policies on the S3 buckets that store your logs \(
   3 buckets not needed, Missing Global services options\)

**Qestion 15**

Which of the following are true regarding AWS CloudTrail? Choose 3 answers

1. **CloudTrail is enabled globally**\(it can be enabled for all regions and also per region basis\)
2. CloudTrail is enabled by default \(
   **was not enabled by default, however, it is enabled by default as per the latest **[**AWS enhancements**](https://aws.amazon.com/blogs/aws/new-amazon-web-services-extends-cloudtrail-to-all-aws-customers/)\)
3. **CloudTrail is enabled on a per-region basis**\(it can be enabled for all regions and also per region basis\)
4. CloudTrail is enabled on a per-service basis \(once enabled it is applicable for all the supported services, service can’t be selected\)
5. **Logs can be delivered to a single Amazon S3 bucket for aggregation**
6. CloudTrail is enabled for all available services within a region. \(is enabled only for CloudTrail supported services\)
7. Logs can only be processed and delivered to the region in which they are generated. \(can be logged to bucket in any region\)



**Qestion 16**

Your must architect the migration of a web application to AWS. The application consists of Linux web servers running a custom web server. You are required to save the logs generated from the application to a durable location. What options could you select to migrate the application to AWS? \(Choose 2\)

1. Create an AWS Elastic Beanstalk application using the custom web server platform. Specify the web server executable and the application project and source files. Enable log file rotation to Amazon Simple Storage Service \(S3\). \(EB does not work with Custom server executable\)
2. Create Dockerfile for the application. Create an AWS OpsWorks stack consisting of a custom layer. Create custom recipes to install Docker and to deploy your Docker container using the Dockerfile. Create custom recipes to install and configure the application to publish the logs to Amazon CloudWatch Logs \(although this is one of the option, the last sentence mentions configure the application to push the logs to S3, which would need changes to application as it needs to use SDK or CLI\)
3. Create Dockerfile for the application. Create an AWS OpsWorks stack consisting of a Docker layer that uses the Dockerfile. Create custom recipes to install and configure Amazon Kinesis to publish the logs into Amazon CloudWatch. \(Kinesis not needed\)
4. **Create a Dockerfile for the application. Create an AWS Elastic Beanstalk application using the Docker platform and the Dockerfile. Enable logging the Docker configuration to automatically publish the application logs. Enable log file rotation to Amazon S3.**
   \(Use Docker configuration with awslogs and EB with Docker\)
5. **Use VM import/Export to import a virtual machine image of the server into AWS as an AMI. Create an Amazon Elastic Compute Cloud \(EC2\) instance from AMI, and install and configure the Amazon CloudWatch Logs agent. Create a new AMI from the instance. Create an AWS Elastic Beanstalk application using the AMI platform and the new AMI.**
   \(Use VM Import/Export to create AMI and CloudWatch logs agent to log\)



**Qestion 17**

Your company hosts an on-premises legacy engineering application with 900GB of data shared via a central file server. The engineering data consists of thousands of individual files ranging in size from megabytes to multiple gigabytes. Engineers typically modify 5-10 percent of the files a day. Your CTO would like to migrate this application to AWS, but only if the application can be migrated over the weekend to minimize user downtime. You calculate that it will take a minimum of 48 hours to transfer 900GB of data using your company’s existing 45-Mbps Internet connection. After replicating the application’s environment in AWS, which option will allow you to move the application’s data to AWS without losing any data and within the given timeframe?

1. Copy the data to Amazon S3 using multiple threads and multi-part upload for large files over the weekend, and work in parallel with your developers to reconfigure the replicated application environment to leverage Amazon S3 to serve the engineering files. \(Still limited by 45 Mbps speed with minimum 48 hours when utilized to max\)
2. Sync the application data to Amazon S3 starting a week before the migration, on Friday morning perform a final sync, and copy the entire data set to your AWS file server after the sync completes. \(
   Works best as the data changes can be propagated over the week and are fractional and downtime would be know\)
3. Copy the application data to a 1-TB USB drive on Friday and immediately send overnight, with Saturday delivery, the USB drive to AWS Import/Export to be imported as an EBS volume, mount the resulting EBS volume to your AWS file server on Sunday. \(Downtime is not known when the data upload would be done, although Amazon says the same day the package is received\)
4. Leverage the AWS Storage Gateway to create a Gateway-Stored volume. On Friday copy the application data to the Storage Gateway volume. After the data has been copied, perform a snapshot of the volume and restore the volume as an EBS volume to be attached to your AWS file server on Sunday. \(Still uses the internet\)



**Qestion 18**

You are tasked with moving a legacy application from a virtual machine running inside your datacenter to an Amazon VPC. Unfortunately this app requires access to a number of on-premises services and no one who configured the app still works for your company. Even worse there’s no documentation for it. What will allow the application running inside the VPC to reach back and access its internal dependencies without being reconfigured? \(Choose 3 answers\)

1. **An AWS Direct Connect link between the VPC and the network housing the internal services**
2. An Internet Gateway to allow a VPN connection. \(Virtual and Customer gateway is needed\)
3. An Elastic IP address on the VPC instance
4. **An IP address space that does not conflict with the one on-premises**
5. Entries in Amazon Route 53 that allow the Instance to resolve its dependencies’ IP addresses
6. **A VM Import of the current virtual machine**



