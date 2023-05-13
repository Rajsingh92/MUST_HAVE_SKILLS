**Q: What is the difference between using the local instance store and Amazon Elastic Block Store \(Amazon EBS\) for the root device?**

When you launch your Amazon EC2 instances you have the ability to store your root device data on Amazon EBS or the local instance store. By using Amazon EBS, data on the root device will persist independently from the lifetime of the instance. This enables you to stop and restart the instance at a subsequent time, which is similar to shutting down your laptop and restarting it when you need it again.

Alternatively, the local instance store only persists during the life of the instance. This is an inexpensive way to launch instances where data is not stored to the root device. For example, some customers use this option to run large web sites where each instance is a clone to handle web traffic.

**Q: How do I load and store my systems with Amazon EC2?**

Amazon EC2 allows you to set up and configure everything about your instances from your operating system up to your applications. An Amazon Machine Image \(AMI\) is simply a packaged-up environment that includes all the necessary bits to set up and boot your instance. Your AMIs are your unit of deployment. You might have just one AMI or you might compose your system out of several building block AMIs \(e.g., webservers, appservers, and databases\). Amazon EC2 provides a number of tools to make creating an AMI easy. Once you create a custom AMI, you will need to bundle it. If you are bundling an image with a root device backed by Amazon EBS, you can simply use the bundle command in the AWS Management Console. If you are bundling an image with a boot partition on the instance store, then you will need to use the AMI Tools to upload it to Amazon S3. Amazon EC2 uses Amazon EBS and Amazon S3 to provide reliable, scalable storage of your AMIs so that we can boot them when you ask us to do so.

Or, if you want, you don’t have to set up your own AMI from scratch. You can choose from a number of globally available AMIs that provide useful instances. For example, if you just want a simple Linux server, you can choose one of the standard Linux distribution AMIs.

**Q: How do I select the right instance type?**

Amazon EC2 instances are grouped into 5 families: General Purpose, Compute Optimized, Memory Optimized, Storage Optimized and Accelerated Computing instances. General Purpose Instances have memory to CPU ratios suitable for most general purpose applications and come with fixed performance \(M5, M4\) or burstable performance \(T2\); Compute Optimized instances \(C5, C4\) have proportionally more CPU resources than memory \(RAM\) and are well suited for scale out compute-intensive applications and High Performance Computing \(HPC\) workloads; Memory Optimized Instances \(X1e, X1, R4\) offer larger memory sizes for memory-intensive applications, including database and memory caching applications; Accelerating Computing instances \(P3, P2, G3, F1\) take advantage of the parallel processing capabilities of NVIDIA Tesla GPUs for high performance computing and machine/deep learning; GPU Graphics instances \(G3\) offer high-performance 3D graphics capabilities for applications using OpenGL and DirectX; F1 instances deliver Xilinx FPGA-based reconfigurable computing; Storage Optimized Instances \(H1, I3, D2\) that provide very high, low latency, I/O capacity using SSD-based local instance storage for I/O-intensive applications, with D2 or H1, the dense-storage and HDD-storage instances, provide local high storage density and sequential I/O performance for data warehousing, Hadoop and other data-intensive applications. When choosing instance types, you should consider the characteristics of your application with regards to resource utilization \(i.e. CPU, Memory, Storage\) and select the optimal instance family and instance size.

创建EC2实例的时候，我们可以勾选“自动分配Public IP”（原话是英文的哦~），也可以不勾选，然后手动关联Elastic IP\(EIP\),那么着二者有什么区别呢？

从亚马逊在线技术支持那里了解到：

（1）EIP是属于某个特定的账号，可以关联到账号的任意实例上，也可卸载下来重新关联到其他实例上，而且实例被删除之后，EIP依然单独存在。\(分配EIP时注意VPC和EC2的EIP的区别，不同类型的EIP时能关联到自己类型的实例上，即VPC中的EIP只能用于VPC中的实例，Classic EC2只能关联非VPC的EIP）

（2）而普通的Public IP是属于具体的某台实例，不能卸载重新关联到别的实例，实例创建时，如果勾选自动分配Public IP，则会随实例一起被创建，实例删除时，跟着被删除，无法被重复利用和保留；

（3）还有一个非常重要的特性：Public IP在实例关机后再开机，可能会改变，重启不影响（这跟Classic EC2实例的Public DNS一样，可能会改变）。而EIP怎么都不会变。

（4）如果实例创建之初，有PublicIP,然后再关联了ElasticIP的话，二者都会变成ElasticIP的样子（被覆盖），当EIP被解除关联之后，PublicIP才会被显露，但此时会重新分配PublicIP，所以PublicIP会变。

所以，如果在EC2实例的生命周期内，有停机再开机的可能，还是使用EIP比较保险

**Q: How isolated are Availability Zones from one another?**

Each Availability Zone runs on its own physically distinct, independent infrastructure, and is engineered to be highly reliable. Common points of failures like generators and cooling equipment are not shared across Availability Zones. Additionally, they are physically separate, such that even extremely uncommon disasters such as fires, tornados or flooding would only affect a single Availability Zone.

**Q: How can I make sure that I am in the same Availability Zone as another developer?**

We do not currently support the ability to coordinate launches into the same Availability Zone across AWS developer accounts. One Availability Zone name \(for example, us-east-1a\) in two AWS customer accounts may relate to different physical Availability Zones.

**Q. How many EBS volumes and Elastic Network Interfaces \(ENIs\) can be attached to instances running on the Nitro Hypervisor?**

Instances running on the Nitro Hypervisor support a maximum of 27 additional PCI devices for EBS volumes and VPC ENIs. Each EBS volume or VPC ENI uses a PCI device. For example, if you attach 3 additional network interfaces to an instance that uses the Nitro Hypervisor, you can attach up to 24 EBS volumes to that instance.\(each pci bus has maximum 32 devices, and some slot for sound card, video card......., so left 27 maxinum for EBS or ENI.\)

**Q: Which volume type should I choose?**

Amazon EBS includes two major categories of storage: SSD-backed storage for transactional workloads \(performance depends primarily on IOPS\) and HDD-backed storage for throughput workloads \(performance depends primarily on throughput, measured in MB/s\). SSD-backed volumes are designed for transactional, IOPS-intensive database workloads, boot volumes, and workloads that require high IOPS. SSD-backed volumes include Provisioned IOPS SSD \(io1\) and General Purpose SSD \(gp2\). HDD-backed volumes are designed for throughput-intensive and big-data workloads, large I/O sizes, and sequential I/O patterns. HDD-backed volumes include Throughput Optimized HDD \(st1\) and Cold HDD \(sc1\). For more information on Amazon EBS see the[EBS product details page](https://amazonaws-china.com/ebs/details/).

**Q: Will I be able to access my EBS snapshots using the regular Amazon S3 APIs?**

No, EBS snapshots are only available through the Amazon EC2 APIs.

**Q: Do volumes need to be un-mounted in order to take a snapshot? Does the snapshot need to complete before the volume can be used again? **

No, snapshots can be done in real time while the volume is attached and in use. However, snapshots only capture data that has been written to your Amazon EBS volume, which might exclude any data that has been locally cached by your application or OS. In order to ensure consistent snapshots on volumes attached to an instance, we recommend cleanly detaching the volume, issuing the snapshot command, and then reattaching the volume. For Amazon EBS volumes that serve as root devices, we recommend shutting down the machine to take a clean snapshot.

**Q: How can I discover Amazon EBS snapshots that have been shared with me?**

You can find snapshots that have been shared with you by selecting “Private Snapshots” from the viewing dropdown in the Snapshots section of the AWS Management Console. This section will list both snapshots you own and snapshots that have been shared with you.

**Q. How do I access a file system from an Amazon EC2 instance?**

To access your file system, you mount the file system on an Amazon EC2 Linux-based instance using the standard Linux mount command and the file system’s DNS name. Once you’ve mounted, you can work with the files and directories in your file system just like you would with a local file system.

Amazon EFS uses the NFSv4.1 protocol. For a step-by-step example of how to access a file system from an Amazon EC2 instance, please see the[Amazon EFS Getting Started guide](http://docs.aws.amazon.com/efs/latest/ug/gs-mount-fs-on-ec2instance-and-test.html).

**Q. How do I access my file system from outside my VPC?**

Amazon EC2 instances within your VPC can access your file system directly, and Amazon EC2 Classic instances outside your VPC can mount a file system via [ClassicLink](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/vpc-classiclink.html). On-premises servers can mount your file systems via an [AWS Direct Connect](https://amazonaws-china.com/directconnect/) connection to your VPC.

**Q: What is the minimum time interval granularity for the data that Amazon CloudWatch receives and aggregates?**

Metrics are received and aggregated at 1 minute intervals.

**Q: Which operating systems does Amazon CloudWatch support?**

Amazon CloudWatch receives and provides metrics for all Amazon EC2 instances and should work with any operating system currently supported by the Amazon EC2 service.

**Q: Will I lose the metrics data if I disable monitoring for an Amazon EC2 instance?**

You can retrieve metrics data for any Amazon EC2 instance up to 2 weeks from the time you started to monitor it. After 2 weeks, metrics data for an Amazon EC2 instance will not be available if monitoring was disabled for that Amazon EC2 instance. If you want to archive metrics beyond 2 weeks you can do so by calling mon-get-stats command from the command line and storing the results in Amazon S3 or Amazon SimpleDB.

**Q: What load balancing options does the Elastic Load Balancing service offer?**

Elastic Load Balancing offers two types of load balancers that both feature high availability, automatic scaling, and robust security. These include the[Classic Load Balancer](https://amazonaws-china.com/elasticloadbalancing/classicloadbalancer/)that routes traffic based on either application or network level information, and the[Application Load Balancer](https://amazonaws-china.com/elasticloadbalancing/applicationloadbalancer/)that routes traffic based on advanced application level information that includes the content of the request.

**Q. How many EBS volumes can be attached to C5 instances?**

C5 instances support a maximum for 27 EBS volumes for all Operating systems. The limit is shared with ENI attachments which can be found here [http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-eni.html](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-eni.html). For example: since every instance has at least 1 ENI, if you have 3 additional ENI attachments on the c4.2xlarge, you can attach 24 EBS volumes to that instance.

**Q. What is the underlying hypervisor on C5 instances?**

C5 instances use a new EC2 hypervisor that is based on core KVM technology.

**Q: Why does the total memory reported by Linux not match the advertised memory of the C5 instance type?**

In C5, portions of the total memory for an instance are reserved from use by the Operating System including areas used by the virtual BIOS for things like ACPI tables and for devices like the virtual video RAM.

**Q: What are Accelerated Computing instances?**

Accelerated Computing instance family is a family of instances which use hardware accelerators, or co-processors, to perform some functions, such as floating-point number calculation and graphics processing, more efficiently than is possible in software running on CPUs. Amazon EC2 provides three types of Accelerated Computing instances – GPU compute instances for general-purpose computing, GPU graphics instances for graphics intensive applications, and FPGA programmable hardware compute instances for advanced scientific workloads.

**Q. When should I use GPU Graphics and Compute instances?**

GPU instances work best for applications with massive parallelism such as workloads using thousands of threads. Graphics processing is an example with huge computational requirements, where each of the tasks is relatively small, the set of operations performed form a pipeline, and the throughput of this pipeline is more important than the latency of the individual operations. To be able build applications that exploit this level of parallelism, one needs GPU device specific knowledge by understanding how to program against various graphics APIs \(DirectX, OpenGL\) or GPU compute programming models \(CUDA, OpenCL\).

**Q: How are P3 instances different from G3 instances?**

P3 instances are the next-generation of EC2 general-purpose GPU computing instances, powered by up to 8 of the latest-generation NVIDIA Tesla V100 GPUs. These new instances significantly improve performance and scalability, and add many new features, including new Streaming Multiprocessor \(SM\) architecture for machine learning \(ML\)/deep learning \(DL\) performance optimization, second-generation NVIDIA NVLink high-speed GPU interconnect, and highly tuned HBM2 memory for higher-efficiency.

G3 instances use NVIDIA Tesla M60 GPUs and provide a high-performance platform for graphics applications using DirectX or OpenGL. NVIDIA Tesla M60 GPUs support NVIDIA GRID Virtual Workstation features, and H.265 \(HEVC\) hardware encoding. Each M60 GPU in G3 instances supports 4 monitors with resolutions up to 4096x2160, and is licensed to use NVIDIA GRID Virtual Workstation for one Concurrent Connected User. Example applications of G3 instances include 3D visualizations, graphics-intensive remote workstation, 3D rendering, application streaming, video encoding, and other server-side graphics workloads.**Q: What are the benefits of NVIDIA Volta GV100 GPUs?**

The new NVIDIA Tesla V100 accelerator incorporates the powerful new Volta GV100 GPU. GV100 not only builds upon the advances of its predecessor, the Pascal GP100 GPU, it significantly improves performance and scalability, and adds many new features that improve programmability. These advances will supercharge HPC, data center, supercomputer, and deep learning systems and applications.

**Q: Who will benefit from P3 instances?**

P3 instances with their high computational performance will benefit users in artificial intelligence \(AI\), machine learning \(ML\), deep learning \(DL\) and high performance computing \(HPC\) applications. Users includes data scientists, data architects, data analysts, scientific researchers, ML engineers, IT managers and software developers. Key industries include transportation, energy/oil & gas, financial services \(banking, insurance\), healthcare, pharmaceutical, sciences, IT, retail, manufacturing, high-tech, transportation, government, academia, among many others.

**Q: Why should customers use GPU-powered Amazon P3 instances for AI/ML and HPC?**

GPU-based compute instances provide greater throughput and performance because they are designed for massively parallel processing using thousands of specialized cores per GPU, versus CPUs offering sequential processing with a few cores. In addition, developers have built hundreds of GPU-optimized scientific HPC applications such as quantum chemistry, molecular dynamics, meteorology, among many others. Research indicates that over 70% of the most popular HPC applications provide built-in support for GPUs.

**Q: Will P3 instances support EC2 Classic networking and Amazon VPC?**

P3 instances will support VPC only.

**Q. How are G3 instances different from P2 instances?**

G3 instances use NVIDIA Tesla M60 GPUs and provide a high-performance platform for graphics applications using DirectX or OpenGL. NVIDIA Tesla M60 GPUs support NVIDIA GRID Virtual Workstation features, and H.265 \(HEVC\) hardware encoding. Each M60 GPU in G3 instances supports 4 monitors with resolutions up to 4096x2160, and is licensed to use NVIDIA GRID Virtual Workstation for one Concurrent Connected User. Example applications of G3 instances include 3D visualizations, graphics-intensive remote workstation, 3D rendering, application streaming, video encoding, and other server-side graphics workloads.

P2 instances use NVIDIA Tesla K80 GPUs and are designed for general purpose GPU computing using the CUDA or OpenCL programming models. P2 instances provide customers with high bandwidth 25 Gbps networking, powerful single and double precision floating-point capabilities, and error-correcting code \(ECC\) memory, making them ideal for deep learning, high performance databases, computational fluid dynamics, computational finance, seismic analysis, molecular modeling, genomics, rendering, and other server-side GPU compute workloads.

**Q. Which AMIs can I use with P3, P2 and G3 instances?**

You can currently use Windows Server, SUSE Enterprise Linux, Ubuntu, and Amazon Linux AMIs on P2 and G3 instances. P3 instances only support HVM AMIs. If you want to launch AMIs with operating systems not listed here, contact AWS[Customer Support](https://amazonaws-china.com/contact-us/)with your request or reach out through[EC2 Forums](https://forums.aws.amazon.com/forum.jspa?forumID=30#).

**Q. Why am I unable to see the GPU when using Microsoft Remote Desktop?**

When using Remote Desktop, GPUs using the WDDM driver model are replaced with a non-accelerated Remote Desktop display driver. In order to access your GPU hardware, you need to utilize a different remote access tool, such as VNC.

**Q. What is Amazon EC2 F1?**

Amazon EC2 F1 is a compute instance with programmable hardware you can use for application acceleration. The new F1 instance type provides a high performance, easy to access FPGA for developing and deploying custom hardware accelerations.

**Q. What are FPGAs and why do I need them?**

FPGAs are programmable integrated circuits that you can configure using software. By using FPGAs you can accelerate your applications up to 30x when compared with servers that use CPUs alone. And, FPGAs are reprogrammable, so you get the flexibility to update and optimize your hardware acceleration without having to redesign the hardware.

**Q. How does F1 compare with traditional FPGA solutions?**

F1 is an AWS instance with programmable hardware for application acceleration. With F1, you have access to FPGA hardware in a few simple clicks, reducing the time and cost of full-cycle FPGA development and scale deployment from months or years to days. While FPGA technology has been available for decades, adoption of application acceleration has struggled to be successful in both the development of accelerators and the business model of selling custom hardware for traditional enterprises, due to time and cost in development infrastructure, hardware design, and at-scale deployment. With this offering, customers avoid the undifferentiated heavy lifting associated with developing FPGAs in on-premises data centers.

**Q: What is an Amazon FPGA Image \(AFI\)?**

The design that you create to program your FPGA is called an Amazon FPGA Image \(AFI\). AWS provides a service to register, manage, copy, query, and delete AFIs. After an AFI is created, it can be loaded on a running F1 instance. You can load multiple AFIs to the same F1 instance, and can switch between AFIs in runtime without reboot. This lets you quickly test and run multiple hardware accelerations in rapid sequence. You can also offer to other customers on the AWS Marketplace a combination of your FPGA acceleration and an AMI with custom software or AFI drivers.

**Q. What is available with F1 instances?**

For developers, AWS is providing a Hardware Development Kit \(HDK\) to help accelerate development cycles, a FPGA Developer AMI for development in the cloud, an SDK for AMIs running the F1 instance, and a set of APIs to register, manage, copy, query, and delete AFIs. Both developers and customers have access to the AWS Marketplace where AFIs can be listed and purchased for use in application accelerations.

**Q. Do I need to be a FPGA expert to use an F1 instance?**

AWS customers subscribing to a F1-optimized AMI from AWS Marketplace do not need to know anything about FPGAs to take advantage of the accelerations provided by the F1 instance and the AWS Marketplace. Simply subscribe to an F1-optimized AMI from the AWS Marketplace with an acceleration that matches the workload. The AMI contains all the software necessary for using the FPGA acceleration. Customers need only write software to the specific API for that accelerator and start using the accelerator.

**Q. I’m a FPGA developer, how do I get started with F1 instances?**

Developers can get started on the F1 instance by creating an AWS account and downloading the AWS Hardware Development Kit \(HDK\). The HDK includes documentation on F1, internal FPGA interfaces, and compiler scripts for generating AFI. Developers can start writing their FPGA code to the documented interfaces included in the HDK to create their acceleration function. Developers can launch AWS instances with the FPGA Developer AMI. This AMI includes the development tools needed to compile and simulate the FPGA code. The Developer AMI is best run on the latest C5, M5, or R4 instances. Developers should have experience in the programming languages used for creating FPGA code \(i.e. Verilog or VHDL\) and an understanding of the operation they wish to accelerate.

**Q. I’m not an FPGA developer, how do I get started with F1 instances?**

Customers can get started with F1 instances by selecting an accelerator from the AWS Marketplace, provided by AWS Marketplace sellers, and launching an F1 instance with that AMI. The AMI includes all of the software and APIs for that accelerator. AWS manages programming the FPGA with the AFI for that accelerator. Customers do not need any FPGA experience or knowledge to use these accelerators. They can work completely at the software API level for that accelerator.

**Q. Does AWS provide a developer kit?**

Yes. The Hardware Development Kit \(HDK\) includes simulation tools and simulation models for developers to simulate, debug, build, and register their acceleration code. The HDK includes code samples, compile scripts, debug interfaces, and many other tools you will need to develop the FPGA code for your F1 instances. You can use the HDK either in an AWS provided AMI, or in your on-premises development environment. These models and scripts are available publically with an AWS account.

**Q. Can I use the HDK in my on-premises development environment?**

Yes. You can use the Hardware Development Kit HDK either in an AWS-provided AMI, or in your on-premises development environment.

**Q. What kind of network performance can I expect when I launch instances in cluster placement group?**

The bandwidth an EC2 instance can utilize in a cluster placement group depends on the instance type and its networking performance specification. Inter-instance traffic within the same region can utilize 5 Gbps for single-flow and up to 25 Gbps for multi-flow traffic. When launched in a placement group, select EC2 instances can utilize up to 10 Gbps for single-flow traffic.

**Q. Are there any ways to optimize the likelihood that I receive the full number of instances I request for my cluster via a cluster placement group?**

We recommend that you launch the minimum number of instances required to participate in a cluster in a single launch. For very large clusters, you should launch multiple placement groups, e.g. two placement groups of 128 instances, and combine them to create a larger, 256 instance cluster.

**Q. If an instance in a cluster placement group is stopped then started again, will it maintain its presence in the cluster placement group?**

Yes. A stopped instance will be started as part of the cluster placement group it was in when it stopped. If capacity is not available for it to start within its cluster placement group, the start will fail.

**Q: How does support for Intel AVX-512 benefit EC2 M5 Instance customers?**

Intel Advanced Vector Extension 512 \(AVX-512\) is a set of new CPU instructions available on the latest Intel Xeon Scalable processor family, that can accelerate performance for workloads and usages such as scientific simulations, financial analytics, artificial intelligence, machine learning/deep learning, 3D modeling and analysis, image and video processing, cryptography and data compression, among others. Intel AVX-512 offers exceptional processing of encryption algorithms, helping to reduce the performance overhead for cryptography, which means EC2 M5 customers can deploy more secure data and services into distributed environments without compromising performance

**Q: Why does the total memory reported by Linux not match the advertised memory of the M5 instance type?**

In M5, portions of the total memory for an instance are reserved from use by the operating system including areas used by the virtual BIOS for things like ACPI tables and for devices like the virtual video RAM.

**Q. How do Dense-storage and HDD-storage instances compare to High I/O instances? **

High I/O instances \(I2\) are targeted at workloads that demand low latency and high random I/O in addition to moderate storage density and provide the best price/IOPS across other EC2 instance types. Dense-storage instances \(D2\) and HDD-storage instances \(H1\) are optimized for applications that require high sequential read/write access and low cost storage for very large data sets and provide the best price/GB-storage and price/disk-throughput across other EC2 instances.

**Q. How much disk throughput can Dense-storage and HDD-storage instances deliver?**

The largest current generation of Dense-storage instances, d2.8xlarge, can deliver up to 3.5 GBps read and 3.1 GBps write disk throughput with a 2 MiB block size. The largest H1 instances size, h1.16xlarge, can deliver up to 1.15 GBps read and write. To ensure the best disk throughput performance from your D2 instances on Linux, we recommend that you use the most recent version of the[Amazon Linux AMI](https://amazonaws-china.com/amazon-linux-ami/), or another Linux AMI with a kernel version of 3.8 or later that supports persistent grants - an extension to the Xen block ring protocol that significantly improves disk throughput and scalability.

**Q. Do Dense-storage and HDD-storage instances provide any failover mechanisms or redundancy?**

The primary data storage for Dense-storage instances is HDD-based instance storage. Like all instance storage, these storage volumes persist only for the life of the instance. Hence, we recommend that you build a degree of redundancy \(e.g. RAID 1/5/6\) or use file systems \(e.g. HDFS and MapR-FS\) that support redundancy and fault tolerance. You can also back up data periodically to more durable data storage solutions such as Amazon Simple Storage Service \(S3\) for additional data durability. Please refer to[Amazon S3](https://amazonaws-china.com/s3/)for reference.

**Q. How many IOPS can i3.16.xlarge instances deliver?**

Using HVM AMIs, High I/O I3 instances can deliver up to 3.3 million IOPS measured at 100% random reads using 4KB block size, and up to 300,000 100% random write IOPs, measured at 4KB block sizes to applications across 8 x 1.9 TB NVMe devices.

**Q. What is the sequential throughput of i3 instances?**

The maximum sequential throughput, measured at 128K block sizes is 16 GB/s read throughput and 6.4 GB/s write throughput.

**Q. Do High I/O instances support TRIM?**

The TRIM command allows the operating system to inform SSDs which blocks of data are no longer considered in use and can be wiped internally. In the absence of TRIM, future write operations to the involved blocks can slow down significantly. I3 instances support TRIM.

**Q. Do X1 and X1e instances enable CPU power management state control**

Yes. You can configure C-states and P-states on x1e.32xlarge, x1e.16xlarge, x1e.8xlarge, x1.32xlarge and x1.16xlarge instances. You can use C-states to enable higher turbo frequencies \(as much as 3.1 GHz with one or two core turbo\). You can also use P-states to lower performance variability by pinning all cores at P1 or higher P states, which is similar to disabling Turbo, and running consistently at the base CPU clock speed.

**Q: Is data stored on Amazon EC2 NVMe instance storage encrypted?**

Yes, all data is encrypted in an AWS Nitro hardware module prior to being written on the locally attached SSDs offered via NVMe instance storage.

**Q: What encryption algorithm is used to encrypt Amazon EC2 NVMe instance storage?  **

Amazon EC2 NVMe instance storage is encrypted using an XTS-AES-256 block cipher.

**Q. What is VM Import/Export?**

VM Import/Export enables customers to import Virtual Machine \(VM\) images in order to create Amazon EC2 instances. Customers can also export previously imported EC2 instances to create VMs. Customers can use VM Import/Export to leverage their previous investments in building VMs by migrating their VMs to Amazon EC2.

**Q. What virtual machine file formats are supported?**

You can import VMware ESX VMDK images, Citrix Xen VHD images, Microsoft Hyper-V VHD images and RAW images as Amazon EC2 instances. You can export EC2 instances to VMware ESX VMDK, VMware ESX OVA, Microsoft Hyper-V VHD or Citrix Xen VHD images. For a full list of support operating systems, please see[What operating systems are supported?](https://amazonaws-china.com/ec2/faqs/#What_operating_systems_are_supported).

