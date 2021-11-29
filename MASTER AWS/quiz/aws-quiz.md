IAM - User Management

COMPUTE
EC2


DATA Storage
DynamoDB

RDS

Redshift

S3

# Security / Networking
- Security Best Practices Whitepaper: https://d0.awsstatic.com/whitepapers/Security/AWS_Security_Best_Practices.pdf
## Security Groups
- Security groups are used to allow traffic. If no rule exists, all traffic is blocked.
    - Inbound rule have 3 variables: Protocol, Port number, Source IP (or ip prefix)
    - Outbound rules have 3 varialbes: Protocol, Port number, Destination IP (or ip prefix). `0.0.0.0/0` means all ips (for IPv6 it's `::/0`)
    
- Default Security Group:
    - One per VPC. Can't be deleted.
    - If you don't specify a security group when you launch an instance, the instance is automatically associated with the default security group.
    - Inbound: Allow all port ranges, only coming from this SG (Source “Default SG”)
    - Outbound: All outbound ports open (Destination `0.0.0.0/0`).

)

- Default settings for a newly created Security Group:
    - Allows no inbound traffic
    - Allows all outbound traffic

- Tagging for access control:
Q: Which of the following strategies will help prevent a similar situation in the future?
The administrator still must be able to:
launch, start stop, and terminate development resources. launch and start production instances.

A: Leverage resource based tagging, along with an IAM user which can prevent specific users from 
terminating production, EC2 resources.

## IAM
Best practices: https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html
- Root account
    - Don't use your AWS root user access keys, it has full access and you can't restrict permissions. Don't create the access keys.
    - If you must have access key, rotate it regularly.
    - Enable MFA
    - Create individual users, even one for yourself (to avoid using the root account)
- Use IAM groups
    - Example: create groups for different job functions (admins, devs, accounting,...)
    - Assign permissions to groups. Avoid defining permissions for individual users.
    - Assign IAM users to groups. A user can belong to multiple groups
- IAM Roles
    - You cannot attach multiple IAM roles to a single instance, but you can attach a single IAM role to multiple instances.
    - 
     
Start:
1. Sign up with username(email) + pass
2. Create your own access keys (Key ID, + secret access key), for SSH / AWS
3. Create other users, and their access keys

### Federation, access
SAML 2.0 can be used to grant access to the federated users to the AWS Management console. 
This requires the use of the AWS SSO endpoint instead of directly calling the AssumeRoleWithSAML API. The endpoint calls the API for the user and returns a URL that automatically redirects the user’s browser to the AWS Management Console
Answer: Use your on-premises SAML 2.0-compliant identity provider (IDP) to grant the NOC members federated access to the AWS Management Console via the AWS single sign-on (SSO) endpoint.


# Networking

- By default, all subnets in the same VPC can route between each other, regardless of being public or private subnets.
- Each subnet maps to a single Availability Zone. They cannot span multiple AZs.
- Creating your own NAT (EC2) instance
    - Disable Source/Destination Check attribute on the NAT instance
- AWS reserves 5 IPs per subnet, the first four and the last IP address.
    
# EBS
- To move an EBS volume to a different AZ:
    - Create a snapshot of the volume and create a new volume from the snapshot in the other AZ

# RDS
- Multi-AZ deployment:
    - synchronous replication to standby instances
- Read-replica:
    - async replication.

# DynamoDb
## Sparse indexes:
DynamoDB writes a corresponding index entry **only if the index sort key value is present in them**. If the sort key doesn't appear in every table, the index is said to be _sparse_.
Sparse indexes are useful for queries over a small subsection of a table. For example, suppose that you have a table where you store all your customer orders, with the following key attributes:

- Partition key: CustomerId
- Sort key: OrderId

To track open orders, you can insert a Boolean attribute named `isOpen` in order items that have not already shipped. Then when the order ships, you can delete the attribute. If you then create an index on CustomerId (partition key) and isOpen (sort key), only those orders with isOpen defined appear in it. When you have thousands of orders of which only a small number are open, it's faster and less expensive to query that index for open orders than to scan the entire table.

Instead of using a Boolean type of attribute like `isOpen`, you could use an attribute with a value that results in a useful sort order in the index. For example, you could use an OrderOpenDate attribute set to the date on which each order was placed, and then delete it after the order is fulfilled. That way, when you query the sparse index, the items are returned sorted by the date on which each order was placed.

Global secondary indexes are sparse by default. When you create a global secondary index, you specify a partition key and optionally a sort-key. Only items in the parent table that contain those attributes appear in the index.

By designing a global secondary index to be sparse, you can provision it with lower write throughput than that of the parent table, while still achieving excellent performance.


    
- Use cases:
    - Storing user-preference data (50KB per user, 5M users):
        - Setup a DynamoDB table with an item for each user having the necessary attributes to hold the user 
preferences. The mobile application will query the user preferences directly from the DynamoDB table. 
Utilize STS. Web Identity Federation, and DynamoDB Fine Grained Access Control to authenticate and 
authorize access.

# Elastic Load Balancer
- Proxy protocol
    - By default, when you use TCP for both front-end and back-end connections, your Classic Load Balancer forwards requests to the instances without modifying the request headers. 
    If you enable Proxy Protocol, a human-readable header is added to the request header with connection information, incl. source IP, destination IP, port. The request is then sent to the instance.

# Deployment, CI/CD
## AWS Ops Works
- Chef, For a single application with two services: 
    - Create one AWS OpsWorks stack create two AWS Ops Works layers, create one custom recipe.
    

# AWS CDN (Content Delivery Network)
- Logs: enable delivery to S3 


# SQS - Simple Queue Service
- Does not allow for assigning priority to tasks. For prioritization, use multiple queues and have the application code poll the highest priority queue first.
- In questions that involve sudden traffic spikes, mention SQS. Store the request temporarily in SQS instead of writing directly to the DB to reduce load on DB servers.


# Architecture Examples
- Q: Your company hosts a social media site supporting users in multiple countries. You have been asked to provide
a highly available design tor the application that leverages multiple regions tor the most recently accessed
content and latency sensitive portions of the wet) site The most latency sensitive component of the application
involves reading user preferences to support web site personalization and ad selection.
In addition to running your application in multiple regions, which option will support this application’s
requirements?
    - A: Serve user content from S3. CloudFront and use Route53 latency-based routing between ELBs in each 
region Retrieve user preferences from a local DynamoDB table in each region and leverage SQS to capture 
changes to user preferences with SOS workers for propagating updates to each table.

- Q: Your company plans to host a large donation website on Amazon Web Services (AWS). You anticipate a large
and undetermined amount of traffic that will create many database writes. To be certain that you do not drop
any writes to a database hosted on AWS.
Which service should you use?

    - A: Amazon Simple Queue Service (SQS) for capturing the writes and draining the queue to write to the 
database.

- Q: A 3-tier e-commerce web application is current deployed on-premises and will be migrated to AWS for greater
scalability and elasticity The web server currently shares read-only data using a network distributed file system
The app server tier uses a clustering mechanism for discovery and shared session state that depends on IPmulticast The database tier uses shared-storage clustering to provide database fall over capability, and uses
several read slaves for scaling Data on all servers and the distributed file system directory is backed up weekly
to off-site tapes.
Which AWS storage and database architecture meets the requirements of the application?

    - A: Web servers: store read-only data in S3, and copy from S3 to root volume at boot time. App servers: share 
state using a combination of DynamoDB and IP unicast. Database: use RDS with multi-AZ deployment and 
one or more Read Replicas. Backup: web and app servers backed up weekly via AMIs, database backed 
up via DB snapshots.

- Q: Your fortune 500 company has under taken a TCO analysis evaluating the use of Amazon S3 versus acquiring
more hardware The outcome was that ail employees would be granted access to use Amazon S3 for storage oftheir personal documents.
Which of the following will you need to consider so you can set up a solution that incorporates single sign-on
from your corporate AD or LDAP directory and restricts access for each user to a designated user folder in a
bucket? (Choose 3)
    - ** A Setting up a federation proxy or identity provider
    - ** B Using AWS Security Token Service to generate temporary tokens
    - C Tagging each folder in the bucket
    - ** D Configuring IAM role
    - E Setting up a matching IAM user for every user in your corporate directory that needs access to a folder in  the bucket

- Q: Avoid errors during application deployment:
    - A: 
        - Set the Elastic Load Balancing health check configuration to target a part of the application that fully tests 
application health and returns an error if the tests fail.
        - Create a new launch configuration that refers to the new AMI, and associate it with the group. Double the 
size of the group, wait for the new instances to become healthy, and reduce back to the original size. If new 
instances do not become healthy, associate the previous launch configuration.

- Q: You are designing a personal document-archiving solution for your global enterprise with thousands of
employee. Each employee has potentially gigabytes of data to be backed up in this archiving solution. The
solution will be exposed to the employees as an application, where they can just drag and drop their files to the
archiving system. Employees can retrieve their archives through a web interface. The corporate network has
high bandwidth AWS Direct Connect connectivity to AWS.
You have a regulatory requirement that all data needs to be encrypted before being uploaded to the cloud.
    - A: Manage encryption keys in Amazon Key Management Service (KMS), upload to S3 with client-side encryption using a 
    KMS customer master key ID, and configure Amazon S3 lifecycle policies to store each object using the Amazon Glacier storage tier.

- Q: Reduce cost of client-side app uploading large files. Existing architecture: upload to auto-scaled instances behind ELB.
    - A: Re-architect your ingest pattern, have the app authenticate against your identity provider, and use your 
identity provider as a broker fetching temporary AWS credentials from AWS Secure Token Service 
(GetFederationToken). Securely pass the credentials and S3 endpoint/prefix to your app. Implement clientside logic that used the S3 multipart upload API to directly upload the file to Amazon S3 using the given 
credentials and S3 prefix.

- Q: Your company previously configured a heavily used, dynamically routed VPN connection between your onpremises data center and AWS. You recently provisioned a DirectConnect connection and would like to start
using the new connection.
After configuring DirectConnect settings in the AWS Console, which of the following options win provide the
most seamless transition for your users?
    - A: Configure your DirectConnect router, update your VPC route tables to point to the DirectConnect 
connection, configure your VPN connection with a higher BGP priority. And verify network traffic is 
leveraging the DirectConnect connection.

- Q: A corporate web application is deployed within an Amazon Virtual Private Cloud (VPC) and is connected to the
corporate data center via an IPSec VPN. The application must authenticate against the on-premises LDAP
server. After authentication, each logged-in user can only access an Amazon Simple Storage Space (S3)
keyspace specific to that user.
Which two approaches can satisfy these objectives? (Choose 2)
    - A: 
        - The application authenticates against LDAP and retrieves the name of an IAM role associated with the user. 
The application then calls the IAM Security Token Service to assume that IAM role. The application can use 
the temporary credentials to access the appropriate S3 bucket.
        - Develop an identity broker that authenticates against LDAP and then calls IAM Security Token Service to 
get IAM federated user credentials. The application calls the identity broker to get IAM federated user 
credentials with access to the appropriate S3 bucket.




# Misc
- ARN format: arn:partition:service:region:account-id:resource
    - Example: arn:aws:iam::123456789012:instance-profile/Webserver  , iam has no region because it's global 

# Exam tips
- For long question texts, read the last sentence first, which usually contains the actual question. This will tell you what to focus on
when reading the complete text, allowing you to quickly skim through useless details. 
- Online courses:
    - acloud.guru
    - linuxacademy
    - udemy
    - ...
    
Memorize:
- Glacier lookup time: 3 or more hours
- max storage gateway volumes: 32
- gateway stored volumes max 16 TB
- max size for storage _CACHED_ gateway: 32 TB
- Gateway-cached volumes supports up to 32 volumes each with a maximum size of 32TB giving a total of 1PB storage.
- Storage gateway traffic can be throttled
- Storage gateway local requirements:
    - On-premise Storage Gateway Virtual Machine requirements are 4 or 8vCPUs, 16GB of RAM and 80GB of VM image and system data storage.
- A gateway-stored volume requires: an amount of storage equal to entire dataset plus upload buffer
- Ports on-prem storage gateway: 443 outbound, 80 inbound (from local network for activation), 3260 inbound (from iscsi clients connecting), and outbound 53 (dns)
- Snapshots can be created of your gateway-cached and gateway-stored volumes.
- Read replicas are available to all: MySQL, MariaDB, Oracle, SQL Server, and PostgreSQL
- RDS snapshots are taken from the secondary in Multi-AZ
- RDS automated backups for MySQL are only avaialble to InnoDB
- RTO - Recovery time objective: RTO can include the time to fix the problem without a recovery, the recovery itself, testing and communication to users.
- Virtual tape shelves are stored on Amazon Glacier and allow you to have unlimited virtual tapes. 
- Virtual Tape Libraries are stored on Amazon S3 and support up to 1500 Virtual Tapes.
- Snowball Import/Export data encryption is optional for imports, mandatory for exports.
- When deleting an RDS instance. automated backups are deleted, but manual backups are kept
- Warm standby: Running a production replica on minimal hardware, including database replicas and instances then scaling it up in the event of a failure.
- AWS Import/Export (not disk!) is for S3 only. (is this export only?)
- AWS Import/Export Disk can import to S3/ EBS or glacier  
- Pilot Light recovery strategy is completely up to  customer. (It's failover from on-prem to cloud?)
- DynamoDB allows cross-region replication with Streams.
- Backup and Restore is the least expensive DR scenario.
- Reserved instance modifications are not available for RedHat or SUSE Linux instances
- You can configure AWS CloudTrail at the paying account level by configuring an S3 bucket and configuring CloudTrail on linked accounts to put logs in the paying account's s3 bucket.
- When you have an existing reserved instances allocation and you submit a modification request to split the footprint across multiple AZs, new Reserved Instance requests are created in each AZ to match the new footprint requirements.
- Opsworks uses Chef to run Code deployments, Software Configurations, Database Setups, Infrastructure Provisioning, and Server Scaling.
- To output data from Cloud Formation, you should use Fn:GetAtt
- CloudFormation: 'Resources' is a mandatory section of the Template.
- CloudFormation does have support for Chef and Puppet, which allows you to provision your application layer. It also has the ability to utilise the bootstrap scripts for EC2 instance provisioning.
- In a VPC configured to use dedicated tenancy, all instances created -- even those selected for shared tenancy -- will be created on dedicated hardware.
