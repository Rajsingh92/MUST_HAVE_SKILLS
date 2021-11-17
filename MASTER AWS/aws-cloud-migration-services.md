# AWS Cloud Migration Services

* AWS Cloud Migration services help to address a lot of common use cases such as
  * cloud migration,
  * disaster recovery,
  * data center decommission, and
  * content distribution.
* For migrating data from On Premises to AWS, the major aspect for considerations are
  * amount of data and network speed
  * data security in transit
  * existing application knowledge for recreation

## **NOTE: Topic mainly for Professional Exam Only**

## VPN

* connection utilizes IPSec to establish encrypted network connectivity between on-premises network and VPC over the Internet.
* **connections can be configured in minutes**
  and a good solution for an immediate need, have low to modest bandwidth requirements, and can tolerate the inherent variability in Internet-based connectivity.
* still requires internet and be configured using VGW and CGW

## AWS EC2 VM Import/Export

* allows easy import of virtual machine images from existing environment to EC2 instances and export them back to on-premises environment
* allows leveraging of existing investments in the virtual machines, built to meet compliance requirements, configuration management and IT security by bringing those virtual machines into EC2 as ready-to-use instances
* Common usages include
  * **Migrate Existing Applications and Workloads to EC2, allows to preserve software and settings that configured in the existing VMs**
  * Copy Your VM Image Catalog to Amazon EC2
  * Create a Disaster Recovery Repository for your VM images

## AWS Direct Connect

* provides a dedicated physical connection between the corporate network and AWS Direct Connect location with no data transfer over the Internet.
* **helps bypass Internet service providers**
  \(ISPs\) in the network path
* helps reduce network costs, increase bandwidth throughput, and provide a more consistent network experience than with Internet-based connection
* takes time to setup and involves third parties
* **are not redundant**
  and would need another direct connect connection or a VPN connection
* Security
  * provides a dedicated physical connection without internet
  * For additional security can be used with VPN

## AWS Import/Export \(upgraded to Snowball\)

* accelerates moving large amounts of data into and out of AWS using secure Snowball appliances
* AWS transfers the data directly onto and off of the storage devices using Amazon’s high-speed internal network, bypassing the Internet
* **Data Migration**
  * for significant data size, AWS Import/Export is faster than Internet transfer is and more cost-effective than upgrading the connectivity
  * **if loading the data over the Internet would take a week or more, AWS Import/Export should be considered**
  * data from appliances can be imported to S3, Glacier and EBS volumes and exported from S3
  * **not suitable for applications that cannot tolerate offline transfer time**
* ** Security**
  * Snowball uses an industry-standard Trusted Platform Module \(TPM\) that has a dedicated processor designed to detect any unauthorized modifications to the hardware, firmware, or software to physically secure the AWS Snowball device.

## AWS Storage Gateway

* connects an on-premises software appliance with cloud-based storage to provide seamless and secure integration between an organization’s on-premises IT environment and the AWS storage infrastructure
* provides low-latency performance by maintaining frequently accessed data on-premises while securely storing all of the data encrypted in S3 or Glacier.
* for disaster recovery scenarios, Storage Gateway, together with EC2, can serve as a cloud-hosted solution that mirrors the entire production environment
* **Data Migration**
  * with gateway-cached volumes, S3 can be used to hold primary data while frequently accessed data is cached locally for faster access reducing the need to scale on premises storage infrastructure
  * with gateway-stored volumes, entire data is stored locally while asynchronously backing up data to S3
  * with gateway-VTL, offline data archiving can be performed by presenting existing backup application with an iSCSI-based VTL consisting of a virtual media changer and virtual tape drives
* **Security**
  * Encrypts all data in transit to and from AWS by using SSL/TLS.
  * All data in AWS Storage Gateway is encrypted at rest using AES-256.
  * Authentication between the gateway and iSCSI initiators can be secured by using Challenge-Handshake Authentication Protocol \(CHAP\).

## S3

* Data Transfer
  * Files up to 5GB can be transferred using single operation
  * Multipart uploads can be used to upload files up to 5 TB and speed up data uploads by dividing the file into multiple parts
  * **transfer rate still limited by the network speed**
* Security
  * Data in transit can be secured by using SSL/TLS or client-side encryption.
  * Encrypt data at-rest by performing server-side encryption using Amazon S3-Managed Keys \(SSE-S3\), AWS Key Management Service \(KMS\)-Managed Keys \(SSE-KMS\), or Customer Provided Keys \(SSE-C\). Or by performing client-side encryption using AWS KMS–Managed Customer Master Key \(CMK\) or Client-Side Master Key.



