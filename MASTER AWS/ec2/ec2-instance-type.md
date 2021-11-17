# EC2 Instance Types Overview

* EC2 Instance types determines the hardware of the host computer used for the instance.
* Each instance type offers different compute, memory, and storage capabilities and are grouped in instance families based on these capabilities
* EC2 provides each instance with a consistent and predictable amount of CPU capacity, regardless of its underlying hardware.
* EC2 dedicates some resources of the host computer, such as CPU, memory, and instance storage, to a particular instance.
* EC2 shares other resources of the host computer, such as the network and the disk subsystem, among instances. If each instance on a host computer tries to use as much of one of these shared resources as possible, each receives an equal share of that resource. However, when a resource is under-utilized, an instance can consume a higher share of that resource while it’s available

## Current Generation Instance Types

![](https://i0.wp.com/jayendrapatil.com/wp-content/uploads/2016/04/screen-shot-2016-04-15-at-6-55-39-am.png?resize=656%2C282 "EC2 Instance Types")

## EC2 Instance Type selection criteria

* Some Instance types support only HVM virtualization type while others support both the PV and HVM virtualization types. AWS, however, recommends using HVM for taking advantage of the underlying hardware
* All the instances are available in a VPC, however, few instance types are not available in an EC2-classic. AWS recommends VPC to take advantage of enhanced networking, multiple IP addresses, finer security control etc.
* Some Instances types support only EBS volumes, while others support both EBS and Instance store volumes. Some instances that support instance store volumes use solid state drives \(SSD\) to deliver very high random I/O performance
* Some instances can be launched as EBS optimized instances with a dedicated capacity for Amazon EBS I/O
* Some instances can be launched in placement group for to optimize instances for High Performance Computing
* Some instance support Enhanced Networking,  to get significantly higher packet per second \(PPS\) performance, lower network jitter, and lower latencies
* Some Instances allow EBS volumes to be encrypted

## EBS-Optimized

* EBS-optimized instance uses an optimized configuration stack and provides additional, dedicated capacity for EBS I/O
* EBS-optimized instances enable you to get consistently high performance for the EBS volumes by
  **eliminating contention between EBS I/O and other network traffic from the instance**
* EBS-optimized instances deliver dedicated throughput to EBS, with options between 500 Mbps and 4,000 Mbps, depending on the instance type you use.
* When attached to an EBS–optimized instance, General Purpose \(SSD\) volumes are designed to deliver within 10 percent of their baseline and burst performance 99.9 percent of the time in a given year, and Provisioned IOPS \(SSD\) volumes are designed to deliver within 10 percent of their provisioned performance 99.9 percent of the time in a given year.
* EBS optimization can be enabled for an instance that is not EBS–optimized, by default

## Placement Groups

Refer to My Blog Post @[EC2 Placement Groups](http://jayendrapatil.com/aws-ec2-placement-groups/)

## Instance Types

![](https://i0.wp.com/jayendrapatil.com/wp-content/uploads/2016/04/screen-shot-2016-04-15-at-7-06-50-am.png?resize=656%2C337 "Screen Shot 2016-04-15 at 7.06.50 AM.png")

### T2 Instances \(General Purpose\)

* T2 instances are designed to provide moderate baseline performance and the capability to burst to significantly higher performance as required by your workload.
* Mainly intended for workloads that don’t use the full CPU often or consistently, but occasionally need to burst.
* T2 instances are well suited for
  * general purpose workloads, such as web servers, developer environments, remote desktops and small databases
* Requirements
  * can be launched only with HVM AMI
  * can be launched into a  VPC only, and not supported on the EC2-Classic platform
  * are available as EBS-backed instances only
  * are available as On-Demand or Reserved instances, but do not allow spot instances
  * By default, 20 \(soft limit\) T2 instances can run simultaneously
  * cannot be launched as a Dedicated instance

#### CPU Credits

* CPU Credits \(Similar to I/O Credits in case of the EBS general purpose storage\) provides the performance of a full CPU core for one minute
* T2 instances provide a baseline level of CPU performance, while CPU governs the ability to burst above the baseline level
* One CPU credit is equal to one vCPU running at 100% utilization for one minute.
  _for e.g. you can have One vCPU running at 100% for One minute OR One vCPU running @ 50% for 2 minutes OR Two vCPU running @ 25% for 2 minutes_
* Each T2 instance receives a healthy initial credit balance for startup performance
* Initial CPU credits do not expire, but they are used first when an instance uses CPU credits.
* Each T2 instance then continuously \(at a millisecond-level resolution\) receives a set rate of CPU credits per hour, depending on instance size
  _for e.g. t2.nano earns 3/hour while a t2.large earns 36/hour_
* Each T2 instance accumulates the CPU credit when it uses fewer CPU resources than its allowed baseline performance levels
* Maximum earned credit balance for an instance is equal to the number of CPU credits received per hour times 24 hours
  _for e.g. t2.nano can earn max 72 \(24 \* 3\) credits_
* CPU credit balance is available for a period of 24 hours and it expires 24 hours after they were earned. Expired credits are removed from the balance before new ones are added
* CPU credit cease to persist between an instance stop – start. However, after the start, the instance receives the initial CPU credits again
* When credit balance is completely exhausted, the instance will perform at its baseline performance

### C4 Instances \(Compute Intensive\)

* C4 instances are ideal for compute-bound applications that benefit from high performance processors
* Well suited for
  * Batch processing workloads,
  * Media transcoding,
  * High-traffic web servers, massively multiplayer online \(MMO\) gaming servers, and ad serving engines,
  * High-traffic web servers, massively multiplayer online \(MMO\) gaming servers, and ad serving engines
* Features
  * are EBS-optimized, by default
  * can be enabled for Enhanced Networking capabilities
  * can be clustered in a placement group
* requirements
  * requires 64-bit HVM AMI
  * can be launched into a  VPC only, and not supported on the EC2-Classic platform

### G2 Instances \(Graphic Intensive\)

* GPU instances provide  high parallel processing capability
* Well suited for
  * to accelerate many scientific, engineering, and rendering applications by leveraging the Compute Unified Device Architecture \(CUDA\) or OpenCL parallel computing frameworks
  * graphics applications, including game streaming, 3-D application streaming, and other graphics workloads
* Requirements
  * requires HVM AMI
  * can’t access GPU unless NVIDIA drivers installed
* Features
  * can be clustered in a placement group

### I2 Instances \(I/O Intensive\)

* I2 instances are optimized to deliver tens of thousands of low-latency, random I/O operations per second \(IOPS\) to applications.
* Well suited for applications
  * NoSQL databases \(for example, Cassandra and MongoDB\)
  * Clustered databases
  * Online transaction processing \(OLTP\) systems
* Features
  * Primary data storage is SSD-based instance storage.
  * can be enabled for Enhanced Networking capabilities
  * can be clustered in a placement group
  * can enable EBS–optimization to obtain additional, dedicated capacity for Amazon EBS I/O
* Requirements
  * requires HVM AMI
* **HI1**
  is the equivalent previous generation instance
  * supports both PV and HVM AMIs

### D2 Instances \(Density Intensive\)

* D2 instances are designed for workloads with very high storage density and that require high sequential read and write access to very large data sets on local storage.
* Well suited for applications
  * Massive parallel processing \(MPP\) data warehouse
  * MapReduce and Hadoop distributed computing
  * Log or data processing applications
* Features
  * Primary data storage for D2 instances is HDD-based instance storage
  * are EBS-optimized, by default
  * can be enabled for Enhanced Networking capabilities
  * can be clustered in a placement group
* requirements
  * requires 64-bit HVM AMI
* **HS1**
  is the equivalent previous generation instance
  * supports both EBS and Instance store backed AMIs
  * supports both PV and HVM AMIs



