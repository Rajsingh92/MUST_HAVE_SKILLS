## Elastic Cloud Compute – EC2 Overview

* Elastic Compute Cloud \(EC2\) provides scalable computing capacity in the Amazon Web Services \(AWS\) cloud.
* EC2 eliminates the need to invest in hardware up front, so applications can be developed and deployed faster.
* EC2 can be used to launch as many or as few virtual servers as you need, configure security and networking, and manage storage.
* EC2 enables you to scale up or down to handle changes in requirements or spikes in popularity, reducing your need to forecast traffic.

## EC2 features

* Virtual computing environments, known as
  _**Ec2 instances**_
* Preconfigured templates for your instances, known as
  _**Amazon Machine Images \(AMIs\)**_
  , that package the bits you need for your server \(including the operating system and additional software\)
* Various configurations of CPU, memory, storage, and networking capacity for your instances, known as
  _**Instance types**_
* Secure login information for your instances using
  _**key pairs**_
  \(AWS stores the public key, and you store the private key in a secure place\)
* Storage volumes for temporary data that’s deleted when you stop or terminate your instance, known as
  _**Instance store volumes**_
* Persistent storage volumes for your data using Amazon Elastic Block Store \(Amazon EBS\), known as 
  _**Amazon EBS volumes**_
* Multiple physical locations for your resources, such as instances and Amazon EBS volumes, known as
  _**R**_
  _**egions and Availability Zones**_
* A firewall that enables you to specify the protocols, ports, and source IP ranges that can reach your instances using
  _**security groups**_
* Static IP addresses for dynamic cloud computing, known as
  _**Elastic IP addresses**_
* Metadata, known as
  _**tags**_
  , can be created and assigned to EC2 resources
* Virtual networks you can create that are logically isolated from the rest of the AWS cloud, and that you can optionally connect to your own network, known as
  **Virtual private clouds \(VPCs\)**

## Accessing EC2

* Amazon EC2 console
  * Amazon EC2 console is the web-based user interface which can be accessed from AWS management console
* AWS Command line Interface \(CLI\)
  * Provides commands for a broad set of AWS products, and is supported on Windows, Mac, and Linux.
* Amazon EC2 Command Line Interface \(CLI\) tools
  * Provides commands for Amazon EC2, Amazon EBS, and Amazon VPC, and is supported on Windows, Mac, and Linux
* AWS Tools for Windows Powershell
  * Provides commands for a broad set of AWS products for those who script in the PowerShell environment
* AWS Query API
  * Query API allows for requests are HTTP or HTTPS requests that use the HTTP verbs GET or POST and a Query parameter named
    Action
* AWS SDK libraries
  * AWS provide libraries in various languages which provide basic functions that automate tasks such as cryptographically signing your requests, retrying requests, and handling error responses



