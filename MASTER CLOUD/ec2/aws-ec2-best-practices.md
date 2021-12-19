AWS recommends the following to get maximum benefit and satisfaction from EC2

### Security & Network

* Implement the least permissive rules for your security group.
* Regularly patch, update, and secure the operating system and applications on your instance
* Launch your instances into a VPC instead of EC2-Classic \(If aws account is newly created VPC is used by default\)
* Manage access to AWS resources and APIs using identity federation, IAM users, and IAM roles
* Establish credential management policies and procedures for creating, distributing, rotating, and revoking AWS access credentials

### Storage

* EC2 supports Instance store and EBS volumes, so its best to understand the implications of the root device type for data persistence, backup, and recovery
* Use separate Amazon EBS volumes for the operating system \(root device\) versus your data.
* Ensure that the data volume \(with your data\) persists after instance termination
* Use the instance store available for your instance to only store temporary data. \(Remember that the data stored in instance store is deleted when you stop or terminate your instance\)
* If you use instance store for database storage, ensure that you have a cluster with a replication factor that ensures fault tolerance.

### Resource Management

* Use
  [instance metadata](http://jayendrapatil.com/aws-ec2-instance-metadata-userdata/)
  and custom resource tags to track and identify your AWS resources
* View your current limits for Amazon EC2. Plan to request any limit increases in advance of the time that you’ll need them.

### Backup & Recovery

* Regularly back up your instance using
  Amazon EBS snapshots \(not done automatically\) 
  or a backup tool.
* Implement High Availability by deploying critical components of the application across multiple Availability Zones, and replicate the data appropriately
* Monitor and respond to events.
* Design your applications to handle dynamic IP addressing when your instance restarts.
* Implement failover. For a basic solution, you can manually attach a network interface or Elastic IP address to a replacement instance
* Regularly test the process of recovering your instances and Amazon EBS volumes if they fail.

## References

* [Ec2 Best Practices ](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-best-practices.html)



