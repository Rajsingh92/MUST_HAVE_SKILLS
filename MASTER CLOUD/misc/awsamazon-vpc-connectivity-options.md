# Introduction ![](/assets/vpc-connect1.png)![](/assets/vpc-connect2.png)![](/assets/vpc-connect3.png)

# Network-to-Amazon VPC Connectivity Options 

## Hardware VPN 

![](/assets/hardware-vnp1.png)

![](/assets/hardware-vpn2.png)

VGW provide redundancy and failover.

Both dynamic and static routing options are provided to give you flexibility in your routing configuration. Dynamic routing leverages BGP peering to exchange routing information between AWS and these remote endpoints. With dynamic routing, you can also specify routing priorities, policies, and weights \(metrics\) in your BGP advertisements and influence the network path between your network\(s\) and AWS.

It is important to note that when BGP is used, both the IPSec and the BGP connections must be terminated on the same user gateway device, so it must be capable of terminating both IPSec and BGP connections.

## AWS Direct Connect 

![](/assets/aws-direct-connect1.png)AWS Direct Connect can reduce network costs, increase bandwidth throughput, and provide a more consistent network experience than Internet-based connections.

AWS Direct Connect lets you establish 1 Gbps or 10 Gbps dedicated network connections \(or multiple connections\) between AWS networks and one of the AWS Direct Connect locations. It uses industry-standard VLANs to access Amazon Elastic Compute Cloud \(Amazon EC2\) instances running within an Amazon VPC using private IP addresses. You can choose from an ecosystem of WAN service providers for integrating your AWS Direct Connect endpoint in an AWS Direct Connect location with your remote networks

## AWS Direct Connect + VPN 

![](/assets/aws-direct-connect-vpn1.png)

## AWS VPN CloudHub 

![](/assets/aws-cloudhub1.png)AWS VPN CloudHub leverages an Amazon VPC virtual private gateway with multiple gateways, each using unique BGP autonomous system numbers \(ASNs\). Your gateways advertise the appropriate routes \(BGP prefixes\) over their VPN connections. These routing advertisements are received and readvertised to each BGP peer so that each site can send data to and receive data from the other sites. The remote network prefixes for each spoke must have unique ASNs, and the sites must not have overlapping IP ranges. Each site can also send and receive data from the VPC as if they were using a standard VPN connection.

## Software VPN 

![](/assets/software-vpn1.png)You can choose from an ecosystem of multiple partners and open source communities that have produced software VPN appliances that run on Amazon EC2. These include products from well-known security companies like Check Point, Astaro, OpenVPN Technologies, and Microsoft, as well as popular open source tools like OpenVPN, Openswan, and IPsec-Tools. Along with this choice comes the responsibility for you to manage the software appliance, including configuration, patches, and upgrades.

this design introduces a potential single point of failure into the network design as the software VPN appliance runs on a single Amazon EC2 instance



# Amazon VPC-to-Amazon VPC Connectivity Options 

Use these design patterns when you want to integrate multiple Amazon VPCs into a larger virtual network. This is useful if you require multiple VPCs due to security, billing, presence in multiple regions, or internal charge-back requirements to more easily integrate AWS resources between Amazon VPCs. You can also combine these patterns with the UsCustomer Network-–to–-Amazon VPC Connectivity Options for creating a corporate network that spans remote networks and multiple VPCs.

![](/assets/vpc2vpc-vpn1.png)![](/assets/vpc2vpc-vpn2.png)

## VPC Peering 

![](/assets/vpc-peering1.png)AWS uses the existing infrastructure of a VPC to create VPC peering connections. These connections are neither a gateway nor a VPN connection and do not rely on a separate piece of physical hardware. Therefore they do not introduce a potential single point of failure or network bandwidth bottleneck between VPCs. Additionally, VPC routing tables, security groups, and network access control lists can be leveraged to control which subnets or instances are able to utilize the VPC peering connection.

A VPC peering connection can help you to facilitate the transfer of data between VPCs. You can use them to connect VPCs when you have more than one AWS account, to connect a management or shared services VPC to application- or customer-specific

Amazon Web Services – Amazon VPC Connectivity Options July 2014

Page 18 of 31

VPCs, or to connect seamlessly with a partner’s VPC. For more examples of scenarios in which you can use a VPC peering connection

## Software VPN 

this design introduces a potential single point of failure into the network design as the software VPN appliance runs on a single Amazon EC2 instance![](/assets/peer2peer-softwarevpn1.png)

## Software-to-Hardware VPN 

![](/assets/inter-vpc-hard-soft-vpn1.png)you can create secure VPN tunnels between a software VPN appliance and a virtual private gateway to connect multiple VPCs into a larger virtual private network, allowing instances in each VPC to seamlessly connect to each other using private IP addresses. This option is recommended when you want to connect VPCs across multiple AWS regions and would like to take advantage of the AWS-managed hardware VPN endpoint including automated multidata center redundancy and failover built into the VGW side of the VPN connection. This option uses a virtual private gateway in one Amazon VPC and a combination of an Internet gateway and software VPN appliance in another Amazon VPC

## Hardware VPN 

![](/assets/vpc2vpc-hard-vpn1.png)

## AWS Direct Connect 

![](/assets/vpc2vpc-direct-connect1.png)

# Internal User-to-Amazon VPC Connectivity Options 

![](/assets/internal2vpc1.png)

## Software Remote-Access VPN 

![](/assets/remote-access1.png)![](/assets/remote-access2.png)

