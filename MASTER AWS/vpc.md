## VPC {#vpc}

![](/assets/aws-vpc1.png)

* VPN

  * Virtual Private Gateway , TWO endpoint
  * Customer Gateway, hardware or software, keep ping to alive
  * Direct Connect
  * CloudHub
  * software VPN

* Endpoints

  * vpc connect S3
  * VPC and endpoints must in same region

* IP

  * private, public\(dynamic\), Elasitic IP

* VPC wizard

  * auto create : private sub, custom public sub, NAT, IGW

* NAT

  * NAT Gateway
  * NAT Instance

    * Auto Scaling for HA
    * source/destination checks on the NAT instance should be disabled

* Peering

* security group vs NACL

# VPC Overview & Components

* A virtual private cloud \(VPC\) is a virtual network dedicated to the AWS account. It is logically isolated from other virtual networks in the AWS cloud.
* VPC allows the user to select IP address range, create subnets, and configure route tables, network gateways, and security settings.
* **VPC Sizing**

  * VPC needs a set of IP addresses in the form of a Classless Inter-Domain Routing \(CIDR\) block
    _for e.g,_
    _10.0.0.0/16, which allows 2^16 \(65536\) IP address to be available _
  * Allowed CIDR block size is between
    * /28 netmask \(minimum with 2^4 – 16 available IP address\) and
    * /16 netmask \(maximum with 2^16 – 65536 IP address\)
  * CIDR block from private \(non-publicly routable\) IP address can be assigned
    * 10.0.0.0 – 10.255.255.255 \(10/8 prefix\)
    * 172.16.0.0 – 172.31.255.255 \(172.16/12 prefix\)
    * 192.168.0.0 – 192.168.255.255 \(192.168/16 prefix\)
  * It’s possible to specify a range of publicly routable IP addresses; however, direct access to the Internet is not currently supported from publicly routable CIDR blocks in a VPC

  * Each VPC is separate from any other VPC created with the same CIDR block even if it resides within the same AWS account

* VPC allows [VPC Peering](http://jayendrapatil.com/aws-vpc-peering/) connections with other VPC within the same or different AWS accounts

* Connection between your VPC and corporate or home network can be established, however the CIDR blocks should be not be overlapping  
  _for e.g. VPC with CIDR 10.0.0.0/16 can communicate with 10.1.0.0/16 corporate network but the connections would be dropped if it tries to connect to 10.0.37.0/16 corporate network cause of overlapping ip addresses_  
  .

* VPC allows you to set tenancy option for the Instances launched in it. By default, the tenancy option is shared. If dedicated option selected, all the instances within it are launched on a dedicated hardware overriding the individual instance tenancy setting
* Deletion of the VPC is possible only after terminating all instances within the VPC, and deleting all the components with the VPC
  _for e.g. subnets, security groups, network ACLs, route tables, Internet gateways, VPC peering connections, and DHCP options_

![](https://i0.wp.com/jayendrapatil.com/wp-content/uploads/2016/03/AWS-VPC-Components.png?resize=656%2C467 "AWS VPC Components")

## IP Addresses

Instances launched in the VPC can have Private, Public and Elastic IP address assigned to it and are properties of ENI \(Network Interfaces\)

* Private IP Addresses
  * Private IP addresses are not reachable over the Internet, and can be used for communication only between the instances within the VPC
  * All instances are assigned a private IP address, within the IP address range of the subnet, to the default network interface
  * Primary IP address is associated with the network interface for its lifetime, even when the instance is stopped and restarted and is released only when the instance is terminated
  * Additional Private IP addresses, known as secondary private IP address, can be assigned to the instances and these can be reassigned from one network interface to another
* Public IP address
  * Public IP addresses are reachable over the Internet, and can be used for communication between instances and the Internet, or with other AWS services that have public endpoints
  * Public IP address assignment to the Instance depends if the Public IP Addressing is enabled for the Subnet.
  * Public IP address can also be assigned to the Instance by enabling the Public IP addressing during the creation of the instance, which overrides the subnet’s public IP addressing attribute
  * Public IP address is assigned from AWS pool of IP addresses and it is not associated with the AWS account and hence is released when the instance is stopped and restarted or terminated.
* Elastic IP address
  * Elastic IP addresses are static, persistent public IP addresses which can be associated and disassociated with the instance, as required
  * Elastic IP address is allocated at an VPC and owned by the account unless released
  * A Network Interface can be assigned either a Public IP or an Elastic IP. If you assign an instance, already having an Public IP, an Elastic IP, the public IP is released
  * Elastic IP addresses can be moved from one instance to another, which can be within the same or different VPC within the same account
  * Elastic IP are charged for non usage i.e. if it is not associated or associated with a stopped instance or an unattached Network Interface

## Elastic Network Interface \(ENI\)

* Each Instance is attached with default elastic network interface \(Primary Network Interface eth0\) and cannot be detached from the instance
* ENI can include the following attributes
  * Primary private IP address
  * One or more secondary private IP addresses
  * One Elastic IP address per private IP address
  * One public IP address, which can be auto-assigned to the network interface for eth0 when you launch an instance, but only when you create a network interface for eth0 instead of using an existing ENI
  * One or more security groups
  * A MAC address
  * A source/destination check flag
  * A description
* ENI’s attributes follow the ENI as it is attached or detached from an instance and reattached to another instance. When an ENI is moved from one instance to another, network traffic is redirected to the new instance.
* Multiple ENIs can be attached to an instance and is useful for use cases:
  * Create a management network.
  * Use network and security appliances in your VPC.
  * Create dual-homed instances with workloads/roles on distinct subnets.
  * Create a low-budget, high-availability solution.

## Route Tables

* Route table defines rules, termed as routes, which determine where network traffic from the subnet would be routed
* Each VPC has a implicit router to route network traffic
* Each VPC has a Main Route table, and can have multiple custom route tables created
* Each Subnet within a VPC must be associated with a single route table at a time, while a route table can have multiple subnets associated with it
* Subnet, if not explicitly associated to a route table, is implicitly associated with the main route table
* Every route table contains a local route that enables communication within a VPC which cannot be modified or deleted
* Route priority is decided by matching the most specific route in the route table that matches the traffic
* Route tables needs to be updated to defined routes for Internet gateways, Virtual Private gateways, VPC Peering, VPC Endpoints, NAT Device etc.

## Internet Gateways – IGW

* An Internet gateway is a horizontally scaled, redundant, and highly available VPC component that allows communication between instances in the VPC and the Internet.
* IGW imposes no availability risks or bandwidth constraints on the network traffic.
* An Internet gateway serves two purposes:
  * To provide a target in the VPC route tables for Internet-routable traffic,
  * To perform network address translation \(NAT\) for instances that have been assigned public IP addresses.
* **Enabling Internet access to an Instance requires**
  * Attaching Internet gateway to the VPC
  * Subnet should have route tables associated with the route pointing to the Internet gateway
  * Instances should have a Public IP or Elastic IP address assigned
  * Security groups and NACLs associated with the Instance should allow relevant traffic

## NAT

NAT device enables instances in a private subnet to connect to the Internet or other AWS services, but prevents the Internet from initiating connections with the instances.

## VPC Security

Security within a VPC is provided through

* Security groups – Act as a firewall for associated EC2 instances, controlling both inbound and outbound traffic at the instance level
* Network access control lists \(ACLs\) – Act as a firewall for associated subnets, controlling both inbound and outbound traffic at the subnet level
* Flow logs – Capture information about the IP traffic going to and from network interfaces in your VPC

### Flow logs

* VPC Flow Logs is a feature that enables you to capture information about the IP traffic going to and from network interfaces in the VPC and can help in monitoring the traffic or troubleshooting any connectivity issues
* Flow log data is stored using Amazon CloudWatch Logs
* Flow log can be created for the entire VPC, subnets or each network interface. If enabled, for entire VPC or subnet all the network interfaces are monitored
* Flow logs do not capture real-time log streams for network interfaces.
* Flow logs can be created for network interfaces that are created by other AWS services; for example, Elastic Load Balancing, RDS, ElastiCache, Redshift, and WorkSpaces

## Subnets

* Subnet spans a single Availability Zone, distinct locations engineered to be isolated from failures in other AZs, and cannot span across AZs
* Subnet can be configured with an Internet gateway to enable communication over the Internet, or virtual private gateway \(VPN\) connection to enable communication with your corporate network
* Subnet can be Public or Private and it depends on whether it has Internet connectivity i.e. is able to route traffic to the Internet through the IGW
* Instances within the Public Subnet should be assigned a Public IP or Elastic IP address to be able to communicate with the Internet
* For Subnets not connected to the Internet, but has traffic routed through Virtual Private Gateway only is termed as VPN-only subnet
* Subnets can be configured to Enable assignment of the Public IP address to all the Instances launched within the Subnet by default, which can be overridden during the creation of the Instance
* **Subnet Sizing**
  * CIDR block assigned to the Subnet can be the same as the VPC CIDR, in this case you can launch only one subnet within your VPC
  * CIDR block assigned to the Subnet can be a subset of the VPC CIDR, which allows you to launch multiple subnets within the VPC
  * CIDR block assigned to the subnet should not be overlapping
  * CIDR block size allowed is between
    * /28 netmask \(minimum with 2^4 – 16 available IP address\) and
    * /16 netmask \(maximum with 2^16 – 65536 IP address\)
  * AWS reserves 5 IPs address \(first 4 and last 1 IP address\) in each Subnet which are not available for use and cannot be assigned to an instance.
    _for e.g. for a Subnet with a CIDR block 10.0.0.0/24 the following five IPs are reserved_
    * _10.0.0.0: Network address_
    * _10.0.0.1: Reserved by AWS for the VPC router_
    * _10.0.0.2: Reserved by AWS for mapping to Amazon-provided DNS_
    * _10.0.0.3: Reserved by AWS for future use_
    * _10.0.0.255: Network broadcast address. AWS does not support broadcast in a VPC, therefore the address is reserved._
* **Subnet Routing**
  * Each Subnet is associated with a route table which controls the traffic.
* **Subnet Security**
  * Subnet security can be configured using Security groups and NACLs
  * Security groups works at instance level, NACLs work at the subnet level

## VPC Endpoints

## VPC Peering

## VPC VPN Connections & CloudHub



