# Direct Connect Overview

* AWS Direct Connect is a network service that provides an alternative to using the Internet to utilize AWS cloud services
* AWS Direct Connect links your internal network to an AWS Direct Connect location over a standard 1 gigabit or 10 gigabit Ethernet fiber-optic cable with one end of the cable connected to your router, the other to an AWS Direct Connect router.
* Direct Connect connection can be established with 1Gbps and 10Gbps ports. Speeds of 50Mbps, 100Mbps, 200Mbps, 300Mbps, 400Mbps, and 500Mbps can be ordered from any APN partners supporting AWS Direct Connect.
* AWS Direct Connect helps to create virtual interfaces directly to the AWS cloud
  _for e.g, to EC2 _
  _&_
  _ S3_
   and to Virtual Private Cloud \(VPC\), bypassing Internet service providers in the network path.
* AWS Direct Connect location provides access to Amazon Web Services in the region it is associated with, as well as access to other US regions \(in case of a Direct Connect in a US region\). f
  _or e.g. , you can_
  _provision a single connection to any AWS Direct Connect location in the US and use it to access public_
  _AWS services in all US Regions and AWS GovCloud \(US\)._
* Each AWS Direct Connect location enables connectivity to all Availability Zones within the geographically nearest AWS region.

## Direct Connect Advantages

* **Reduced Bandwidth Costs**
  * All data transferred over the dedicated connection is charged at the reduced AWS Direct Connect data transfer rate rather than Internet data transfer rates.
  * Transferring data to and from AWS directly reduces your bandwidth commitment to your Internet service provider
* **Consistent Network Performance**
  * Direct Connect provides a dedicated connection and a more consistent network performance experience as compared to the Internet which can widely vary
* **AWS Services Compatibility**
  * Direct Connect is a network service and works with all of the AWS services like S3, EC2 and VPC
* **Private Connectivity to AWS VPC**
  * Using Direct Connect Private Virtual Interface a private, dedicated, high bandwidth network connection can be established between your network and VPC
* **Elastic**
  * Direct Connect can be easily scaled to meet the needs by either using a higher bandwidth connection or by establishing multiple connections.

## Direct Connect vs IPSec VPN Connections

* A VPC VPN Connection utilizes IPSec to establish encrypted network connectivity between your intranet and Amazon VPC over the Internet.
* VPN Connections
  **can be configured in minutes**
  and are a good solution for immediate needs, have low to modest bandwidth requirements, and can tolerate the inherent variability in Internet-based connectivity.
* AWS Direct Connect does not involve the Internet; instead, it uses dedicated, private network connections between your intranet and Amazon VPC
* VPN connections are very cheap \(
  **$37.20**
  /month as of now
  \) as compared to Direct Connect connection as it requires actual hardware and infrastructure and might go in thousands.

## Direct Connect Anatomy

![](https://i0.wp.com/jayendrapatil.com/wp-content/uploads/2016/05/screen-shot-2016-05-17-at-1-56-15-pm.png?resize=656%2C329 "Direct Connect Anatomy")

* Amazon maintains
  **AWS Direct Connect PoP**
  across different locations \(referred to as Colocation Facilities\) which are different from AWS regions
* Connection from the AWS Direct Connect PoP to the AWS regions is maintained by AWS itself
* As a consumer, you can either purchase a rack space or use any of the AWS APN Partner which already have the infrastructure within the Colocation Facility and configure a
  **Customer Gateway**
* Connection between the AWS Direct Connect PoP and the Customer gateway within the Colocation Facility is called
  **Cross Connect**
  .
* Connection from the Customer Gateway to the Customer Data Center can be establish using any Service Provider Network
* Once a Direct Connect connection is created with AWS,  a LOA-CFA \(Letter Of Authority – Connecting Facility Assignment\) would be received.
* LOA-CFA can be handover to the Colocation Facility or the APN Partner to establish the Cross Connect
* Once the Cross Connect and the connectivity between the CGW and Customer DataCenter is established,
  **Virtual Interfaces**
  can be created
* AWS Direct Connect requires a VGW to access the AWS VPC
* **Virtual Interfaces**
  * Each AWS Direct Connect connection requires a Virtual Interface
  * Each AWS Direct Connect connection can be configured with one or more virtual interfaces.
  * Public Virtual Interface can be created to connect to public resources
    _for e.g. SQS, S3, EC2, Glacier etc_
    which are reachable publicly only.
  * Private virtual interface can be created to connect to the VPC
    _for e.g. instances with private ip address_
  * Each virtual interface needs a VLAN ID, interface IP address, ASN, and BGP key.
* To use your AWS Direct Connect connection with another AWS account, you can create a hosted virtual interface for that account. These hosted virtual interfaces work the same as standard virtual interfaces and can connect to public resources or a VPC.

## Direct Connect Redundancy

![](https://i2.wp.com/jayendrapatil.com/wp-content/uploads/2016/05/screen-shot-2016-05-17-at-1-57-22-pm.png?resize=656%2C300 "Redunant Direct Connect Architecture")

* Direct Connect connections do not provide redundancy and have multiple single point of failures wrt to the hardware devices as each connection consists of a single dedicated connection between ports on your router and an Amazon router
* Redundancy can be provided by
  * Establishing a second Direct Connect connection, preferably in a different Colocation Facility using different router and AWS Direct Connect PoP
  * IPsec VPN connection between the Customer DC to the VGW
* For Multiple ports requested in the same AWS Direct Connect location, Amazon itself makes sure they are provisioned on redundant Amazon routers to prevent impact from an hardware failure



