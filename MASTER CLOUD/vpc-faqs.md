**Q. What is Amazon Virtual Private Cloud?**

Amazon VPC lets you provision a logically isolated section of the Amazon Web Services \(AWS\) cloud where you can launch AWS resources in a virtual network that you define. You have complete control over your virtual networking environment, including selection of your own IP address ranges, creation of subnets, and configuration of route tables and network gateways. You can also create a hardware Virtual Private Network \(VPN\) connection between your corporate datacenter and your VPC and leverage the AWS cloud as an extension of your corporate datacenter.

You can easily customize the network configuration for your Amazon VPC. For example, you can create a public-facing subnet for your web servers that have access to the Internet, and place your backend systems such as databases or application servers in a private-facing subnet with no Internet access. You can leverage multiple layers of security, including security groups and network access control lists, to help control access to Amazon EC2 instances in each subnet.

**Q. What are the components of Amazon VPC?**

Amazon VPC comprises a variety of objects that will be familiar to customers with existing networks:

* **A Virtual Private Cloud:**
  A logically isolated virtual network in the AWS cloud. You define a VPC’s IP address space from ranges you select.
* **Subnet:**
  A segment of a VPC’s IP address range where you can place groups of isolated resources.
* **Internet Gateway:**
  The Amazon VPC side of a connection to the public Internet.
* **NAT Gateway:**
  A highly available, managed Network Address Translation \(NAT\) service for your resources in a private subnet to access the Internet.
* **Hardware VPN Connection:**
  A hardware-based VPN connection between your Amazon VPC and your datacenter, home network, or co-location facility.
* **Virtual Private Gateway:**
  The Amazon VPC side of a VPN connection.
* **Customer Gateway:**
  Your side of a VPN connection.
* **Peering Connection:**
  A peering connection enables you to route traffic via private IP addresses between two peered VPCs.
* **VPC Endpoints: **
  Enables private connectivity to services hosted in AWS, from within your VPC without using an Internet Gateway, VPN, Network Address Translation \(NAT\) devices, or firewall proxies.
* **Egress-only Internet Gateway:**
  A stateful gateway to provide egress only access for IPv6 traffic from the VPC to the Internet.

、

**Q. What are the different types of VPC Endpoints available on Amazon VPC?**

VPC endpoints enable you to privately connect your VPC to services hosted on AWS without requiring an Internet gateway, a NAT device, VPN, or firewall proxies. Endpoints are horizontally scalable and highly available virtual devices that allow communication between instances in your VPC and AWS services. Amazon VPC offers two different types of endpoints: gateway type endpoints and interface type endpoints.

Gateway type endpoints are available only for AWS services including S3 and DynamoDB. These endpoints will add an entry to your route table you selected and route the traffic to the supported services through Amazon’s private network.

Interface type endpoints provide private connectivity to services powered by PrivateLink, being AWS services, your own services or SaaS solutions, and supports connectivity over Direct Connect. More AWS and SaaS solutions will be supported by these endpoints in the future. Please refer to VPC Pricing for the price of interface type endpoints.

**Q. What are the connectivity options for my VPC?**

You may connect your VPC to:

* The Internet \(via an Internet gateway\)
* Your corporate data center using a Hardware VPN connection \(via the virtual private gateway\)
* Both the Internet and your corporate data center \(utilizing both an Internet gateway and a virtual private gateway\)
* Other AWS services \(via Internet gateway, NAT, virtual private gateway, or VPC endpoints\)
* Other VPCs \(via VPC peering connections\)

**Q. How do I connect my VPC to the Internet?**

Amazon VPC supports the creation of an Internet gateway. This gateway enables Amazon EC2 instances in the VPC to directly access the Internet.

**Q. How do instances in a VPC access the Internet?**

You can use public IP addresses, including Elastic IP addresses \(EIPs\), to give instances in the VPC the ability to both directly communicate outbound to the Internet and to receive unsolicited inbound traffic from the Internet \(e.g., web servers\). You can also use the solutions in the next question.

**Q. How do instances without public IP addresses access the Internet**

Instances without public IP addresses can access the Internet in one of two ways:

1. Instances without public IP addresses can route their traffic through a NAT gateway or a NAT instance to access the Internet. These instances use the public IP address of the NAT gateway or NAT instance to traverse the Internet. The NAT gateway or NAT instance allows outbound communication but doesn’t allow machines on the Internet to initiate a connection to the privately addressed instances.
2. For VPCs with a hardware VPN connection or Direct Connect connection, instances can route their Internet traffic down the virtual private gateway to your existing datacenter. From there, it can access the Internet via your existing egress points and network security/monitoring devices.

**Q. Can I connect to my VPC using a software VPN?**

Yes. You may use a third-party software VPN to create a site to site or remote access VPN connection with your VPC via the Internet gateway.

**Q. How does a hardware VPN connection work with Amazon VPC?**

A hardware VPN connection connects your VPC to your datacenter. Amazon supports Internet Protocol security \(IPsec\) VPN connections. Data transferred between your VPC and datacenter routes over an encrypted VPN connection to help maintain the confidentiality and integrity of data in transit. An Internet gateway is not required to establish a hardware VPN connection.

**Q. What is IPsec?**

[IPsec](http://en.wikipedia.org/wiki/IPsec) is a protocol suite for securing Internet Protocol \(IP\) communications by authenticating and encrypting each IP packet of a data stream.

**Q. Which customer gateway devices can I use to connect to Amazon VPC**

There are two types of VPN connections that you can create: statically-routed VPN connections and dynamically-routed VPN connections. Customer gateway devices supporting statically-routed VPN connections must be able to:

* Establish IKE Security Association using Pre-Shared Keys
* Establish IPsec Security Associations in Tunnel mode
* Utilize the AES 128-bit or 256-bit encryption function
* Utilize the SHA-1 or SHA-2 \(256\) hashing function
* Utilize Diffie-Hellman \(DH\) Perfect Forward Secrecy in "Group 2" mode, or one of the additional DH groups we support
* Perform packet fragmentation prior to encryption

In addition to the above capabilities, devices supporting dynamically-routed VPN connections must be able to:

* Establish Border Gateway Protocol \(BGP\) peerings
* Bind tunnels to logical interfaces \(route-based VPN\)
* Utilize IPsec Dead Peer Detection

**Q. What is the approximate maximum throughput of a VPN connection?**

VGW supports IPSEC VPN throughput upto 1.25 Gbps. Multiple VPN connections to the same VPC are cumulatively bound by the VGW throughput of 1.25 Gbps.

**Q. What factors affect the throughput of my VPN connection?**

VPN connection throughput can depend on multiple factors, such as the capability of your Customer Gateway \(CGW\), the capacity of your connection, average packet size, the protocol being used \(TCP vs. UDP\), and the network latency between your CGW and the Virtual Private Gateway \(VGW\).

**Q. What tools are available to me to help troubleshoot my Hardware VPN configuration?**

The DescribeVPNConnection API displays the status of the VPN connection, including the state \("up"/"down"\) of each VPN tunnel and corresponding error messages if either tunnel is "down". This information is also displayed in the AWS Management Console.

**Q. How do I connect a VPC to my corporate datacenter?**

Establishing a hardware VPN connection between your existing network and Amazon VPC allows you to interact with Amazon EC2 instances within a VPC as if they were within your existing network. AWS does not perform

[network address translation \(NAT\)](http://en.wikipedia.org/wiki/Network_address_translation)

on Amazon EC2 instances within a VPC accessed via a hardware VPN connection.

**Q. Can I NAT my CGW behind a router or firewall?**

Yes, you will need to enable NAT-T and open UDP port 4500 on your NAT device.

**Q. What IP address do I use for my CGW address?**

You will use the public IP address of your NAT device.

**Q: How many IPsec security associations can be established concurrently per tunnel?**

The AWS VPN service is a route-based solution, so when using a route-based configuration you will not run into SA limitations. If, however, you are using a policy-based solution you will need to limit to a single SA, as the service is a route-based solution.

**Q. How do I assign IP address ranges to VPCs?**

You assign a single[Classless Internet Domain Routing \(CIDR\)](http://en.wikipedia.org/wiki/CIDR)IP address range as the primary CIDR block when you create a VPC and can add up to four \(4\) secondary CIDR blocks after creation of the VPC. Subnets within a VPC are addressed from these CIDR ranges by you. Please note that while you can create multiple VPCs with overlapping IP address ranges, doing so will prohibit you from connecting these VPCs to a common home network via the hardware VPN connection. For this reason we recommend using non-overlapping IP address ranges. You can allocate an Amazon-provided IPv6 CIDR block to your VPC.

**Q. What IP address ranges are assigned to a default VPC?**

Default VPCs are assigned a CIDR range of 172.31.0.0/16. Default subnets within a default VPC are assigned /20 netblocks within the VPC CIDR range.

**Q. Can I use my public IPv4 addresses in VPC and access them over the Internet?**

Yes, you can bring your public IPv4 addresses into AWS VPC and statically allocate them to subnets and EC2 instances. To access these addresses over the Internet, you will have to advertise them to the Internet from your on-premises network. You will also have to route the traffic over these addresses between your VPC and on-premises network using AWS DX or AWS VPN connection. You can route the traffic from your VPC using the Virtual Private Gateway. Similarly, you can route the traffic from your on-premises network back to your VPC using your routers.

**Q. How large of a VPC can I create?**

Currently, Amazon VPC supports five \(5\) IP address ranges, one \(1\) primary and four \(4\) secondary for IPv4. Each of these ranges can be between /28 \(in CIDR notation\) and /16 in size. The IP address ranges of your VPC should not overlap with the IP address ranges of your existing network.

For IPv6, the VPC is a fixed size of /56 \(in CIDR notation\). A VPC can have both IPv4 and IPv6 CIDR blocks associated to it.

**Q. Can I change the size of a VPC?**

Yes. You can expand your existing VPC by adding four \(4\) secondary IPv4 IP ranges \(CIDRs\) to your VPC. You can shrink your VPC by deleting the secondary CIDR blocks you have added to your VPC. You cannot however change the size of the IPv6 address range of your VPC.

**Q. How many subnets can I create per VPC?**

Currently you can create 200 subnets per VPC. If you would like to create more, please[submit a case at the support center](https://amazonaws-china.com/contact-us/vpc-request/).

**Q. Is there a limit on how large or small a subnet can be?**

The minimum size of a subnet is a /28 \(or 14 IP addresses.\) for IPv4. Subnets cannot be larger than the VPC in which they are created.

For IPv6, the subnet size is fixed to be a /64. Only one IPv6 CIDR block can be allocated to a subnet.

**Q. Can I change the private IP addresses of an Amazon EC2 instance while it is running and/or stopped within a VPC?**

Primary private IP addresses are retained for the instance's or interface's lifetime. Secondary private IP addresses can be assigned, unassigned, or moved between interfaces or instances at any time.

**Q. If an Amazon EC2 instance is stopped within a VPC, can I launch another instance with the same IP address in the same VPC?**

No. An IP address assigned to a running instance can only be used again by another instance once that original running instance is in a “terminated” state.

**Q. Can I assign any IP address to an instance?**

You can assign any IP address to your instance as long as it is:

* Part of the associated subnet's IP address range
* Not reserved by Amazon for IP networking purposes
* Not currently assigned to another interface

**Q. Can I assign one or more Elastic IP \(EIP\) addresses to VPC-based Amazon EC2 instances?**

Yes, however, the EIP addresses will only be reachable from the Internet \(not over the VPN connection\). Each EIP address must be associated with a unique private IP address on the instance. EIP addresses should only be used on instances in subnets configured to route their traffic directly to the Internet gateway. EIPs cannot be used on instances in subnets configured to use a NAT gateway or a NAT instance to access the Internet. This is applicable only for IPv4. Amazon VPCs do not support EIPs for IPv6 at this time.

**Q. Can I specify which subnet will use which gateway as its default?**

Yes. You may create a default route for each subnet. The default route can direct traffic to egress the VPC via the Internet gateway, the virtual private gateway, or the NAT gateway.

**Q. Does Amazon VPC support**[**multicast**](http://en.wikipedia.org/wiki/IP_multicast)**or**[**broadcast**](http://en.wikipedia.org/wiki/Broadcast_address#IP_network_broadcasting)**?**

No.

**Q. What are the differences between security groups in a VPC and network ACLs in a VPC?**

Security groups in a VPC specify which traffic is allowed to or from an Amazon EC2 instance. Network ACLs operate at the subnet level and evaluate traffic entering and exiting a subnet. Network ACLs can be used to set both Allow and Deny rules. Network ACLs do not filter traffic between instances in the same subnet. In addition, network ACLs perform stateless filtering while security groups perform stateful filtering.

**Q. What is the difference between stateful and stateless filtering?**

Stateful filtering tracks the origin of a request and can automatically allow the reply to the request to be returned to the originating computer. For example, a stateful filter that allows inbound traffic to TCP port 80 on a webserver will allow the return traffic, usually on a high numbered port \(e.g., destination TCP port 63, 912\) to pass through the stateful filter between the client and the webserver. The filtering device maintains a state table that tracks the origin and destination port numbers and IP addresses. Only one rule is required on the filtering device: Allow traffic inbound to the web server on TCP port 80.

Stateless filtering, on the other hand, only examines the source or destination IP address and the destination port, ignoring whether the traffic is a new request or a reply to a request. In the above example, two rules would need to be implemented on the filtering device: one rule to allow traffic inbound to the web server on TCP port 80, and another rule to allow outbound traffic from the webserver \(TCP port range 49, 152 through 65, 535\).

**Q. Can Amazon EC2 instances within a VPC communicate with Amazon EC2 instances not within a VPC?**

Yes. If an Internet gateway has been configured, Amazon VPC traffic bound for Amazon EC2 instances not within a VPC traverses the Internet gateway and then enters the public AWS network to reach the EC2 instance. If an Internet gateway has not been configured, or if the instance is in a subnet configured to route through the virtual private gateway, the traffic traverses the VPN connection, egresses from your datacenter, and then re-enters the public AWS network.

**Q. Can Amazon EC2 instances within a VPC in one region communicate with Amazon EC2 instances within a VPC in another region?**

Yes. Instances in one region can communicate with each other using Inter-Region VPC Peering, public IP addresses, NAT gateway, NAT instances, VPN Connections or Direct Connect connections.

**Q. Can Amazon EC2 instances within a VPC communicate with Amazon S3?**

Yes. There are multiple options for your resources within a VPC to communicate with Amazon S3. You can use VPC Endpoint for S3, which makes sure all traffic remains within Amazon's network and enables you to apply additional access policies to your Amazon S3 traffic. You can use an Internet gateway to enable Internet access from your VPC and instances in the VPC can communicate with Amazon S3. You can also make all traffic to Amazon S3 traverse the Direct Connect or VPN connection, egress from your datacenter, and then re-enter the public AWS network.

**Q. Can I monitor the network traffic in my VPC?**

Yes. You can use the Amazon VPC Flow Logs feature to monitor the network traffic in your VPC.

**Q. Can a subnet span Availability Zones?**

No. A subnet must reside within a single Availability Zone.

**Q. Am I charged for network bandwidth between instances in different subnets?**

If the instances reside in subnets in different Availability Zones, you will be charged $0.01 per GB for data transfer.

**Q. Can I attach or detach one or more network interfaces to an EC2 instance while it’s running?**

Yes.

**Q. Can I have more than two network interfaces attached to my EC2 instance?**

The total number of network interfaces that can be attached to an EC2 instance depends on the instance type. See the EC2 User Guide for more information on the number of allowed network interfaces per instance type.

**Q. Can I attach a network interface in one Availability Zone to an instance in another Availability Zone?**

Network interfaces can only be attached to instances residing in the same Availability Zone.

**Q. Can I attach a network interface in one VPC to an instance in another VPC?**

Network interfaces can only be attached to instances in the same VPC as the interface.

**Q. Can I use Elastic Network Interfaces as a way to host multiple websites requiring separate IP addresses on a single instance?**

Yes, however, this is not a use case best suited for multiple interfaces. Instead, assign additional private IP addresses to the instance and then associate EIPs to the private IPs as needed.

**Q. Will I get charged for an Elastic IP Address that is associated to a network interface but the network interface isn’t attached to a running instance?**

Yes.

**Q. Can I detach the primary interface \(eth0\) on my EC2 instance?**

No. You can attach and detach secondary interfaces \(eth1-ethn\) on an EC2 instance, but you can’t detach the eth0 interface.

**Q. Can I create a peering connection to a VPC in a different region?**

Yes. Peering connections can be created with VPCs in different regions. Inter-region VPC peering is available globally in all commercial regions \(excluding China\).

**Q. Can I peer my VPC with a VPC belonging to another AWS account?**

Yes, assuming the owner of the other VPC accepts your peering connection request.

**Q. Can I peer two VPCs with matching IP address ranges?**

No. Peered VPCs must have non-overlapping IP ranges.

**Q. How much do VPC peering connections cost?**

There is no charge for creating VPC peering connections, however, data transfer across peering connections is charged. See the Data Transfer section of the[EC2 Pricing page](http://amazonaws-china.com/ec2/pricing/)for data transfer rates.

**Q. Do I need an Internet Gateway to use peering connections?**

No. VPC peering connections do not require an Internet Gateway.

**Q. Is VPC peering traffic within the region encrypted?**

No. Traffic between instances in peered VPCs remains private and isolated – similar to how traffic between two instances in the same VPC is private and isolated.

**Q. Is Inter-Region VPC Peering traffic encrypted?**

Traffic is encrypted using modern AEAD \(Authenticated Encryption with Associated Data\) algorithms. Key agreement and key management is handled by AWS.

**Q. How do DNS translations work with Inter-Region VPC Peering?**

By default, a query for a public hostname of an instance in a peered VPC in a different region will resolve to a public IP address. Route 53 private DNS can be used to resolve to a private IP address with Inter-Region VPC Peering.

**Q. Can I reference security groups across an Inter-Region VPC Peering connection?**

No. Security groups cannot be referenced across an Inter-Region VPC Peering connection.

**Q. Does Inter-Region VPC Peering support with IPv6?**

No. Inter-Region VPC Peering does not support IPv6.

**Q. Can Inter-Region VPC Peering be used with EC2-Classic Link?**

No. Inter-Region VPC Peering cannot be used with EC2-ClassicLink.

**Q. Are there AWS Services that cannot be used over Inter-Region VPC Peering?**

Network Load Balancers, AWS PrivateLink and Elastic File System cannot be used over Inter-Region VPC Peering.  


**Q. Can traffic from an EC2-Classic instance travel through the Amazon VPC and egress through the Internet gateway, virtual private gateway, or to peered VPCs?**

Traffic from an EC2-Classic instance can only be routed to private IP addresses within the VPC. They will not be routed to any destinations outside the VPC, including Internet gateway, virtual private gateway, or peered VPC destinations.



**Q. How can I configure/assign my ASN to be advertised as Amazon side ASN?**

You can configure/assign an ASN to be advertised as the Amazon side ASN during creation of the new Virtual Private Gateway \(VGW\). You can create a VGW using the VPC console or a EC2/CreateVpnGateway API call.

**Q. What ASN did Amazon assign prior to this feature?**

Amazon assigned the following ASNs: EU West \(Dublin\) 9059; Asia Pacific \(Singapore\) 17493 and Asia Pacific \(Tokyo\) 10124. All other regions were assigned an ASN of 7224; these ASNs are referred as “legacy public ASN” of the region.

**Q. Can I use any ASN – public and private?**

You can assign any private ASN to the Amazon side. You can assign the "legacy public ASN" of the region until June 30th 2018, you cannot assign any other public ASN. After June 30th 2018, Amazon will provide an ASN of 64512.

**Q. What is AWS PrivateLink?**

AWS PrivateLink enables customers to access services hosted on AWS in a highly available and scalable manner, while keeping all the network traffic within the AWS network. Service users can use this to privately access services powered by PrivateLink from their Amazon Virtual Private Cloud \(VPC\) or their on-premises, without using public IPs, and without requiring the traffic to traverse across the Internet. Service owners can register their Network Load Balancers to PrivateLink services and provide the services to other AWS customers.

**Q. How can I use AWS PrivateLink?**

As a service user, you will need to create interface type VPC endpoints for services that are powered by PrivateLink. These service endpoints will appear as Elastic Network Interfaces \(ENIs\) with private IPs in your VPCs. Once these endpoints are created, any traffic destined to these IPs will get privately routed to the corresponding AWS services.

As a service owner, you can onboard your service to AWS PrivateLink by establishing a Network Load Balancer \(NLB\) to front your service and create a PrivateLink service to register with the NLB. Your customers will be able to establish endpoints within their VPC to connect to your service after you whitelisted their accounts and IAM roles.

**Q. How many VPCs, subnets, Elastic IP addresses, Internet gateways, customer gateways, virtual private gateways, and VPN connections can I create?**

You can have:

* Five Amazon VPCs per AWS account per region
* Two hundred subnets per Amazon VPC
* Five Amazon VPC Elastic IP addresses per AWS account per region
* One Internet gateway per VPC
* Five virtual private gateways per AWS account per region
* Fifty customer gateways per AWS account per region
* Ten IPsec VPN Connections per virtual private gateway





