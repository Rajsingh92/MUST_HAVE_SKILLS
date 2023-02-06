# Placement Groups Overview

* Placement group determines how instances are placed on underlying hardware
* AWS now provides two types of placement groups
  * **Cluster **
    – clusters instances into a low-latency group in a
    **single AZ**
  * **Spread**
    – spreads instances
    **across underlying hardware**

## Cluster Placement Group

* is a logical grouping of instances within a
  **single Availability Zone**
* don’t span across Availability Zones
* recommended for applications that benefits from
  **low network latency, high network throughput**
  , or both.
* To provide the
  **lowest latency, and the highest packet-per-second network performance**
  for the placement group, choose an instance type that supports
  **enhanced networking**
* recommended to launch all group instances at the same time to ensure enough capacity
* instances can be added later, but there are chances of encountering an insufficient capacity error
* for moving an instance into the placement group,
  * create an AMI from the existing instance,
  * and then launch a new instance from the AMI into a placement group.
* stopping and starting an instance within the placement group, the instance still runs in the same placement group
* in case of an capacity error, stop and start all of the instances in the placement group, and try the launch again. Restarting the instances may migrate them to hardware that has capacity for all requested instances
* is only available within a single AZ either in the same VPC or peered VPCs
* is more of an hint to AWS that the instances need to be launched physically close to each together
* enables applications to participate in a low-latency, 10 Gbps network.

## ![](https://i0.wp.com/jayendrapatil.com/wp-content/uploads/2016/03/AWS-EC2-Placement-Group.png?resize=656%2C420 "AWS EC2 Placement Group")

## Spread Placement Groups

* is a group of instances that are each placed on distinct underlying hardware
* recommended for applications that have a small number of critical instances that should be kept separate from each other.
* reduces the risk of simultaneous failures that might occur when instances share the same underlying hardware.
* provide access to distinct hardware, and are therefore suitable for mixing instance types or launching instances over time.
* can span multiple AZs, and can have a maximum of seven running instances per AZ per group.
* If the start or launch an instance in a spread placement group fails cause of insufficient unique hardware to fulfill the request, the request can be tried later as EC2 makes more distinct hardware available over time

## Placement Group Rules and Limitations

* Ensure unique Placement group name within AWS account for the region
* Placement groups cannot be merged
* An instance can be launched in one placement group at a time; it cannot span multiple placement groups.
* Instances with a tenancy of host cannot be launched in placement groups.
* Cluster Placement group
  * can’t span multiple Availability Zones.
  * supported by 
    [Specific Instance types](http://aws.amazon.com/ec2/instance-types/#instance-type-matrix)
    \(General Purpose, GPU, Compute, Memory, Storage Optimized – c4.8xlarge, c3.8xlarge, g2.8xlarge, i2.8xlarge, r3.8xlarge, m4.10xlarge, d2.8xlarge\) which support 10 Gigabyte network
  * maximum network throughput speed of traffic between two instances in a cluster placement group is limited by the slower of the two instances, so choose the instance type properly.
  * can use up to 10 Gbps for single-flow traffic.
  * Traffic to and from S3 buckets within the same region over the public IP address space or through a VPC endpoint can use all available instance aggregate bandwidth.
  * recommended to use the same instance type i.e. homogenous instance types. Although multiple instance types can be launched into a cluster placement group. However, this reduces the likelihood that the required capacity will be available for your launch to succeed
  * Network traffic to the internet and over an AWS Direct Connect connection to on-premises resources is limited to 5 Gbps.
* Spread placement groups
  * supports a maximum of seven running instances per Availability Zone
    _for e.g., in a region that has three AZs, then a total of 21 running instances in the group \(seven per zone\)._
  * are not supported for Dedicated Instances or Dedicated Hosts.



