# AWS Security Best Practices

## Know the AWS Shared Responsibility Model

**assets:**

• Facilities

• Physical security of hardware

• Network infrastructure

• Virtualization infrastructure

**assets of EC2:**

• Amazon Machine Images \(AMIs\)

• Operating systems

• Applications

• Data in transit

• Data at rest

• Data stores

• Credentials

• Policies and configuration

**three main categories of AWS service**

**Infrastructure Services:** This category includes compute services, such as Amazon EC2, and related services, such as Amazon Elastic Block Store \(Amazon EBS\), Auto Scaling, and Amazon Virtual Private Cloud \(Amazon VPC\). With these services, you can architect and builda cloud infrastructure using technologies similar to and largely compatible with on-premises solutions. You control the operating system, and you configure and operate any identity management system that provides access to the user layer of the virtualization stack.

**Container Services: **Services in this category typically run onseparate Amazon EC2 or other infrastructure instances, but sometimes you don’t manage the operating system or the platform layer. AWS provides managed service for these application “containers”. You are responsible for setting up and managing network controls, such as firewall rules, and for managing platform-level identity and access management separately from IAM. Examples of container services include Amazon Relational Database Services \(Amazon RDS\), Amazon Elastic Map Reduce \(Amazon EMR\) and AWS Elastic Beanstalk

**Abstracted Services: **This category includes high-level storage, database, and messaging services, such as Amazon Simple Storage Service \(Amazon S3\), Amazon Glacier, Amazon DynamoDB, Amazon Simple Queuing Service \(Amazon SQS\), and Amazon Simple Email Service \(Amazon SES\). These services abstract the platform or management layer on which you can build and operate cloud applications. You access the endpoints of these abstracted services using AWS APIs, and AWS manages the underlying service components or the operating system on which they reside. You share the underlying infrastructure, and abstracted services provide a multi- tenant platform which isolates your data in a secure fashion and provides for powerful integration withIAM

### Shared Responsibility Model for Infrastructure Services![](/assets/awsshare1.png)

### Shared Responsibility Model for Container Services![](/assets/awsshare2.png)

### Shared Responsibility Model for Abstracted Services![](/assets/awsshare3.png)

## Manage AWS Accounts, IAM Users, Groups, and Roles

least privilege principle

one company can have multiple account for each users.

one account can have multiple users.

**acount strategies:**![](/assets/accounts1.png)**sign-in credentials:**

username/password

Multi-factor authentication \(MFA\)

**Access Credential Type:**

Access keys

MFA for API calls

**IAM temporary role and credential is used to delegate user access  in some cases.**

**Identity Federation \(broker auth to AWS Security Token Service \(STS\)\)**![](/assets/idfd1.png)

**Managing OS-level Access to Amazon EC2 Instances**

cloud-init for linux instance

ec2config for windows instance

## Secure Your Data

### Protecting Data at Rest on Amazon S3

permissions

versioning

replication

backup

encryption-server side

encryption-client side

### Protecting Data at Rest on Amazon EBS

replication

backup

encryption: windows EFS EFS is a extension to the NTFS file system that provides for transparent file and folder encryption, and integrates with Windows and Active Directory key management facilities, and PKI

Windows Bitlocker  Windows BitLocker is a volume \(or partition, in the case of single drive\) encryption solution included in Windows Server 2008 and later operating systems

Encryption: Linux dm- crypt

Encryption: TrueCrypt

Encryption and integrity authentication: SafeNet ProtectV

### Protecting Data at Rest on Amazon RDS

using database native encrypt function\(mysql, oracle & MSSQL\)

### Decommission Data and Media Securely

AWS only mark block as deleted, not erase the data, so it maybe recovered. you need to manually erase the data if you want decommise it.

### Protect Data in Transit

#### Managing Application and Administrative Access to AWS Public Cloud Services

https/SSL/TLS/RDP/SSH/database support ssl

#### Protecting Data in Transit when Managing AWS Services

AWS web console/API all use ssl/tls

#### Protecting Data in Transit to Amazon S3

https for s3

#### Protecting Data in Transit to Amazon RDS

mysql&MS SQL use ssl/tls, AWS generate the x.509 cert

orace use native network encryption

#### Protecting Data in Transit to Amazon DynamoDB

HTTP over SSL/TLS \(HTTPS\)

#### Protecting Data in Transit to Amazon EMR

Between Hadoop nodes: no need to secure, use the infrastracture secure mechanism

Between Hadoop Cluster and Amazon S3 : use https

Between Hadoop Cluster and Amazon DynamoDB: use https

User or application access to Hadoop cluster: use ssh to login, ssl/tls for api

Administrative access to Hadoop cluster: use ssh

## Secure Your Operating Systems and Applications

Recommendations include:

• Disable root API access keys and secret key

• Restrict access to instances from limited IP ranges using Security Groups

• Password protect the .pem file on usermachines

• Delete keys from the authorized\_keys file on your instanceswhen someone leaves your organization or no longer requires access

• Rotate credentials \(DB, Access Keys\)

• Regularly run least privilege checks using IAM user Access Advisor and IAM user Last Used Access Keys

• Use bastion hosts to enforce control and visibility

##### Creating Custom AMIs security guide:

**Disable insecure applications    
**

Disable services and protocols that authenticate users in clear text over the network, or otherwise insecurely.

**Minimize exposure    
**

Disable non-essential network services on startup. Only administrative services \(SSH/RDP\) and the services required for essential applications should be started.

**Protect credentials    
**

Securely delete all AWS credentials from disk and configuration files.

**Protect credentials    
**

Securely delete any third-party credentials from disk and configuration files.

**Protect credentials    
**

Securely delete all additional certificates or key material from the system.

**Protect credentials    
**

Ensure that software installed does not use default internal accounts and passwords.

**Use good governance    
**

Ensure that the system does not violate the Amazon Web Services Acceptable Use Policy. Examples of violations include open SMTP relays or proxy servers. For more information, see the Amazon Web Services Acceptable Use Policy–[http://aws.amazon.com/aup/](http://aws.amazon.com/aup/).

#### securing Linux AMIs

**Secure services    
**

Configure sshd to allow only public key authentication. Set PubkeyAuthentication to Yes and PasswordAuthentication to No in sshd\_config.

**Secure services    
**

Generate a unique SSH host key on instance creation. If the AMI uses cloud-init, it will handle this automatically.

**Protect credentials    
**

Remove and disable passwords for all user accounts so that they cannot be used to log in and do not have a default password. Run passwd -l &lt;USERNAME&gt; for each account.

**Protect credentials    
**

Securely delete all user SSH public and private key pairs.

**Protect data    
**

Securely delete all shell history and system log files containing sensitive data.

#### securing Windows AMIs

**Protect credentials    
**

Ensure that all enabled user accounts have new randomly generated passwords upon instance creation. You can configure the EC2 Config Service to do this for the Administrator account upon boot, but you must explicitly do so before bundling the image.

**Protect credentials    
**

Ensure that the Guest account is disabled.

**Protect data    
**

Clear the Windows event logs.

**Protect credentials    
**

Make sure the AMI is not a part of a Windows domain.

**Minimizing exposure    
**

Do not enable any file sharing, print spooler, RPC, and other Windows services that are not essential but are enabled by default.

## Secure Your Infrastructure

#### Using Amazon Virtual Private Cloud \(VPC\)

You can leverage Amazon VPC-IPSec or VPC-AWS Direct Connect to seamlessly integrate on-premises or other hosted infrastructure with your Amazon VPC resources in a secure fashion. With either approach, IPSec connections protect data in transit, while BGP on IPSec or AWS Direct Connect links integrate your Amazon VPC and on-premises routing domains for transparent integration for any application, even applications that don’t support native network security mechanisms.

#### Using Security Zoning and Network Segmentation

A network segment simply isolates one network from another,

where a security zone creates a group of system components with similar security levels with common controls.

## Strengthening Network Security

Best practices for network security in the AWS cloud include the following:

• Always use security groups: They provide stateful firewalls forAmazon EC2 instances at the hypervisor level. You can apply multiple security groups to a single instance, and to a singleENI.

• Augment security groups with Network ACLs: They are stateless but they provide fast and efficient controls. Network ACLs are not instance- specific so they can provide another layer of control in addition to security groups. You can apply separation of duties to ACLs management and security group management.

• Use IPSec or AWS Direct Connect for trusted connections to other sites. Use Virtual Gateway \(VGW\) where Amazon VPC-based resources require remote network connectivity.

• Protect data in transit to ensure the confidentiality and integrity of data,as well as the identities of the communicating parties.

• For large-scale deployments, design network security in layers. Instead of creating a single layer of network security protection, apply network security at external, DMZ, and internal layers.

• VPC Flow Logs provides further visibility as it enables you to capture information about the IP traffic going to and from network interfaces in your VPC.

### Building Threat Protection Layers![](/assets/layerednetwork1.png)

#### Log security![](/assets/logpractice1.png)



