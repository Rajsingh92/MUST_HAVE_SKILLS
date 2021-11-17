Enhanced networking results in higher bandwidth, higher packet per second \(PPS\) performance, lower latency, consistency, scalability and lower jitter

* EC2 provides enhanced networking capabilities using single root I/O virtualization \(SR-IOV\) only on supported instance types
  * SR-IVO is a method of device virtualization which provides higher I/O performance and lower CPU utilization
* Amazon Linux AMIs and Windows Server 2012 R2 AMI already have the module installed with the attributes set and does not require any additional configurations.
* It can be enabled for other OS distributions by installing the module with the correct attributes configured

## Enhanced Networking Key Requirements

* VPC, as enhanced networking can’t be enabled for instance in EC2-Classic
* an HVM virtualization type AMI
* Instance kernel version
  * Linux kernel version of 2.6.32+
  * Windows: Server 2008 R2+
* Appropriate Virtual Function \(VF\) driver
  * Linux – should have the ixgbevf module \(for best performance version 2.14.2 or higher\) installed and that sriovNetSupport attribute set for the instance
  * Windows- Intel 82599 Virtual Function driver
* supported instance types i.e. C3, C4, D2, I2, M4 and R3



