**Q: What kind of performance can I expect from Amazon EBS volumes?**

Amazon EBS provides four current generation volume types: Provisioned IOPS SSD \(io1\), General Purpose SSD \(gp2\), Throughput Optimized HDD \(st1\) and Cold HDD \(sc1\). These volume types differ in performance characteristics and price, allowing you to tailor your storage performance and cost to the needs of your applications.



**Q: Which volume should I choose?**

Amazon EBS includes two major categories of storage: SSD-backed storage for transactional workloads \(performance depends primarily on IOPS\) and HDD-backed storage for throughput workloads \(performance depends primarily on throughput, measured in MB/s\). SSD-backed volumes are designed for transactional, IOPS-intensive database workloads, boot volumes, and workloads that require high IOPS. SSD-backed volumes include Provisioned IOPS SSD \(io1\) and General Purpose SSD \(gp2\). HDD-backed volumes are designed for throughput-intensive and big-data workloads, large I/O sizes, and sequential I/O patterns. HDD-backed volumes include Throughput Optimized HDD \(st1\) and Cold HDD \(sc1\).



**Q: Does the I/O size of my application reads and writes affect the rate of IOPS I get from my Provisioned IOPS SSD \(io1\) volumes?**

Yes. For a given allocation of resources, the IOPS rate you get depends on the I/O size of your application reads and writes. Provisioned IOPS volumes process your application reads and writes in I/O sizes of 256KB or less. Every increase in I/O size above 256KB increases linearly the resources you need to achieve the same IOPS rate. For example, if you have provisioned a volume with 500 IOPS, that means that it can handle up to 500 256KB writes per second, 250 512KB writes per second, or 125 1024KB writes per second, and so on. You can use[Amazon CloudWatch](https://amazonaws-china.com/cloudwatch/)to monitor your throughput and I/O sizes.

**Q: What factors can affect the performance consistency I see with Provisioned IOPS SSD \(io1\) volumes?**

Provisioned IOPS SSD \(io1\) volumes attached to EBS-optimized instances are designed to offer consistent performance, delivering within 10% of the provisioned IOPS performance 99.9% of the time over a given year. For maximum performance consistency with new volumes created from a snapshot, we recommend reading or writing to all of the blocks on your volume before placing it into service.

Another factor that can impact your performance is if your application isn’t sending enough I/O requests. This can be monitored by looking at your volume’s queue depth. The queue depth is the number of pending I/O requests from your application to your volume. For maximum consistency, a Provisioned IOPS volume must maintain an average queue depth \(rounded to the nearest whole number\) of one for every 500 provisioned IOPS in a minute. For example, for a volume provisioned with 1500 IOPS, the queue depth average must be 3. For more information about ensuring consistent performance of your volumes, see[Increasing EBS Performance](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSPerformance.html).



**Q: Will I be able to access my snapshots using the regular Amazon S3 API?**

No, snapshots are only available through the Amazon EC2 API.



**Q: Do volumes need to be un-mounted to take a snapshot?**

No, snapshots can be done in real time while the volume is attached and in use. However, snapshots only capture data that has been written to your Amazon EBS volume, which might exclude any data that has been locally cached by your application or OS. To ensure consistent snapshots on volumes attached to an instance, we recommend detaching the volume cleanly, issuing the snapshot command, and then reattaching the volume. For Amazon EBS volumes that serve as root devices, we recommend shutting down the machine to take a clean snapshot.

**Q: Does it take longer to snapshot an entire 16 TB volume as compared to an entire 1 TB volume?**

By design, an EBS Snapshot of an entire 16 TB volume should take no longer than the time it takes to snapshot an entire 1 TB volume. However, the actual time taken to create a snapshot depends on several factors including the amount of data that has changed since the last snapshot of the EBS volume.

**Q: Are snapshots versioned? Can I read an older snapshot to do a point-in-time recovery**?

Each snapshot is given a unique identifier, and customers can create volumes based on any of their existing snapshots.

**Q: What is Amazon EBS encryption?**

Amazon EBS encryption offers seamless encryption of EBS data volumes, boot volumes and snapshots, eliminating the need to build and maintain a secure key management infrastructure. EBS encryption enables data at rest security by encrypting your data using Amazon-managed keys, or keys you create and manage using the[AWS Key Management Service](https://amazonaws-china.com/kms/)\(KMS\). The encryption occurs on the servers that host EC2 instances, providing encryption of data as it moves between EC2 instances and EBS storage. For more details, see Amazon EBS encryption in the[Amazon EC2 User Guide](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSEncryption.html).

**Q: Does EBS encryption support boot volumes?**

Yes.

**Q: Can I create an encrypted data volume at the time of instance launch?**

Yes, using[customer master keys \(CMKs\)](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#master_keys)that are either AWS-managed or customer-managed. You can specify the volume details and encryption through a[RunInstances API](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_RunInstances.html)call with the[BlockDeviceMapping](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_BlockDeviceMapping.html)parameter or through the Launch Wizard in the EC2 Console.

**Q: Can I create additional encrpyted data volumes at the time of instance launch that are not part of the AMI?**

Yes, you can create encrpyted data volume with either default or custom CMK encryption at the time of instances launch. You can specify the volume details and encryption through[BlockDeviceMapping](http://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_BlockDeviceMapping.html)object in[RunInstances](http://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_RunInstances.html)API call or through Launch Wizard in EC2 Console.





