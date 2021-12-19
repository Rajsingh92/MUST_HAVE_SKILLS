EC2 Network covers a lot of features for High Performance Computing, Ehanced Networking, low latency access

## EC2 and VPC

* All the EC2 instance types can be launched in a VPC
* Instance types C4, M4 &T2 are available in VPC only and cannot be launched in EC2-Classic
* Launching an EC2 instance within an VPC provides the following benefits
  * Assign static private IP addresses to instances that persist across starts and stops
  * Assign multiple IP addresses to your instances
  * Define network interfaces, and attach one or more network interfaces to the instances
  * Change security group membership for the instances while they’re running
  * Control the outbound traffic from the instances \(egress filtering\) in addition to controlling the inbound traffic to them \(ingress filtering\)
  * Add an additional layer of access control to your instances in the form of network access control lists \(ACL\)
  * Run the instances on single-tenant dedicated hardware

## EC2 Instance IP Addressing

* Private IP address &Internal DNS Hostnames
  * Private IP address is the IP address that’s not reachable over the internet and can be resolved only within the network
  * When an instance is launched, the default network interface eth0 is assigned a private IP address and an internal DNS hostname which resolves to the private IP address and can be used for communication between the instances in the same network only
  * Private IP address and DNS hostname cannot be resolved outside the network that the instance is in
  * Private IP address behaviour
    * remains associated with the Instance when it is stopped or rebooted
    * is disassociated only when the instance is terminated
  * An instance when launched can be assigned a private IP address or EC2 will automatically assign an IP address to the instance within the address range of the subnet
  * An additional private IP addresses, known as secondary private IP addresses can also be assigned. Unlike primary private IP addresses, secondary private IP addresses can be reassigned from one instance to another.
* Public IP address and External DNS hostnames
  * A public IP address is reachable from the Internet
  * Each instance assigned a public IP address is also given an External DNS hostname. External DNS hostname resolves to the public IP address outside the network and to the private IP address within the network.
  * Public IP address is associated with the primary Private IP address through NAT
  * Within a VPC, an instance may or may not be assigned a public IP address depending upon the subnet Assign Public IP attribute
  * Public IP address assigned to the pool is from the public IP address pool and is assigned to the instance, and not to the AWS account. It cannot be reused once disassociated and is released back to the pool
  * Public IP address behaviour
    * cannot be manually associated or disassciated with an instance
    * is released when an instance is stopped or terminated. Stopped instance when started receives a new public IP address
    * is released when an instance is assigned an Elastic IP address
    * is not assigned if there are more than one network interface attached to the instance
* Multipe Private IP addresses
  * In EC2-VPC, multiple private IP addresses can be specified to the instances.
  * This can be useful in the following cases
    * Host multiple websites on a single server by using multiple SSL certificates on a single server and associating each certificate with a specific IP address.
    * Operate network appliances, such as firewalls or load balancers, that have multiple private IP addresses for each network interface.
    * Redirect internal traffic to a standby instance in case the instance fails, by reassigning the secondary private IP address to the standby instance.
  * Multiple IP addresses work with Network Interfaces
    * Secondary IP address can be assigned to any network interface, which can be attached or detached from an instance
    * Secondary IP address must be assigned from the CIDR block range of the subnet for the network interface
    * Security groups apply to network interfaces and not to IP addresses
    * Secondary private IP addresses can be assigned and unassigned to ENIs attached to running or stopped instances.
    * Secondary private IP addresses that are assigned to a network interface can be reassigned to another one if you explicitly allow it.
    * Primary private IP addresses, secondary private IP addresses, and any associated Elastic IP addresses remain with the network interface when it is detached from an instance or attached to another instance.
    * Although primary network interface cannot be moved from an instance, the secondary private IP address of the primary network interface can be reassigned to another network interface.

## Elastic IP Addresses

* An Elastic IP address is a static IP address designed for dynamic cloud computing.
* Elastic IP address can help mask the failure of an instance or software by rapidly remapping the address to another instance in your account.
* Elastic IP address is associated with the AWS account, not to a particular instance, and it remains associated with the account until released explicitly
* When an instance is launched in the default vpc, it is assigned 2 IP address, a private and a public IP address, which is mapped to the private IP address through NAT
* An instance launched in a non default vpc is assigned only a private IP address unless a public address is specifically requested or the subnet public ip attribute is enabled
* For an instance, without a public IP address, to communicate to internet it must be assigned an Elastic IP address
* When an Elastic IP address is assigned to an instance, the public IP address is disassociated with the instance
* When the Elastic IP address is dissociated the public IP address is assigned back to the instance. However, if secondary network interface is attached to the instance, public IP address is not automatically assigned
* Elastic IP addresses are not charged when associated with a running instance
* However, Amazon imposes a small hourly fee for an unused Elastic IP address to ensure efficient use of Elastic IP addresses. So charges would be applied if it is not associated or associated to an instance in stopped state or associated to an unattached network interface.
* All AWS accounts are limited to 5 EIPs \(soft limit\), because public \(IPv4\) Internet addresses are a scarce public resource

### ![](https://i1.wp.com/jayendrapatil.com/wp-content/uploads/2016/05/screen-shot-2016-05-02-at-7-38-08-am.png?resize=656%2C592 "EC2 Classic, Default &amp; Non Default Subnet Comparision")

## Elastic Network Interfaces \(ENI\)

* Elastic Network Interfaces \(ENIs\) are virtual network interfaces that can be attached to the instances running in an VPC only
* ENI consists of the following
  * A primary private IP address.
  * One or more secondary private IP addresses
  * One Elastic IP address per private IP address.
  * One public IP address, which can be auto-assigned to the elastic network interface for eth0 when an instance is launched, but only when elastic network interface for eth0 is created instead of using an existing network interface.
  * One or more security groups.
  * A MAC address.
  * A source/destination check flag.
  * A description.
* ENI can be created without being attached to an instance
* ENI can be attached to an instance, detached from that instance and attached to an other instance. Attributes of an ENI like elastic IP address, private IP address follow the ENI and when moved from one instance to an other instance &all traffic to the ENI will be routed to the new instance.
* An instance in a VPC always has a default primary ENI attached \(eth0\) with a private ip address assigned from vpc range and cannot be detached
* Additional ENI \(eth1-ethn\) can be attached to the instance and the number varies depending upon the instance type
* Most important difference between eth0 and eth1 is that eth0 cannot be dynamically attached or detached from a running instance. Primary ENIs \(eth0\) are created automatically when an EC2 instance is launched and are also deleted automatically when the instance is terminated unless the administrator has changed a property of the ENI to keep it alive afterward
* Multiple elastic network interfaces are useful for use cases:
  * Create a management network
    * Primary ENI eth0 handles backend with more restrictive control
    * Secondary ENI eth1 handles the public facing traffic
  * Licensing authentication
    * Fixed MAC address associated with a license authentication
  * Use network and security appliances in your VPC
    * configure a third party network and security appliances \(load balancers, NAT, proxy\) with the secondary ENI
  * Create dual-homed instances with workloads/roles on distinct subnets.
  * Create a low-budget, high-availability solution
    * If one of the instances serving a particular function fails, its elastic network interface can be attached to a replacement or hot standby instance pre-configured for the same role in order to rapidly recover the service
    * As the interface maintains its private IP, EIP, and MAC address, network traffic will begin flowing to the standby instance as soon as it is attached to the replacement instance
* ENI Best Practices
  * ENI can be attached to an instance when it’s running \(hot attach\), when it’s stopped \(warm attach\), or when the instance is being launched \(cold attach\).
  * Primary \(eth0\) interface can’t be detached
  * Secondary \(ethN\) ENI can be detached when the instance is running or stopped.
  * ENI in one subnet can be attached to an instance in another subnet, but the same AZ and same VPC
* When launching an instance from the CLI or API, both the primary \(eth0\) and additional elastic network interfaces can be specified
* Launching an Amazon Linux or Microsoft Windows Server instance with multiple network interfaces automatically configures interfaces, private IP addresses, and route tables on the operating system of the instance.
* A warm or hot attach of an additional ENI may require bringing up the second interface manually, configure the private IP address, and modify the route table accordingly.
* Instances running Amazon Linux or Microsoft Windows Server automatically recognize the warm or hot attach and configure themselves.
* Attaching another ENI to an instance is not a method to increase or double the network bandwidth to or from the dual-homed instance.

## Network MTU

* Maximum Transmission Unit \(MTU\) of a network connection is the size, in bytes, of the largest permissible packet that can be transferred over the connection.
* Larger the MTU of the connection the more the data can be transferred in a single packet
* Largest ethernet packet size supported over most of the internet is 1500 MTU
* All Amazon EC2 instance types support 1500 MTU, and many current instance sizes support 9001 MTU, or **Jumbo frames.**
  * Compute optimized: C3, C4, CC2
  * General purpose: M3, M4, T2
  * GPU: CG1, G2
  * Memory optimized: CR1, R3
  * Storage optimized: D2, HI1, HS1, I2
* Jumbo frames are Ethernet frames that allow more than 1500 bytes of data by increasing the payload size per packet, and thus increasing the percentage of the packet that is not packet overhead.
* Jumbo frames should be used with caution for Internet-bound traffic or any traffic that leaves a VPC. Packets are fragmented by intermediate systems, which slows down this traffic.
* For instances that are collocated inside a **placement group**, jumbo frames help to achieve the maximum network throughput possible, and they are recommended in this case



