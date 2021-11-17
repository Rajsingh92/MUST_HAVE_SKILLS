## Status Checks

* Status monitoring help quickly determine whether EC2 has detected any problems that might prevent instances from running applications.
* EC2 performs automated checks on every running EC2 instance to identify hardware and software issues.
* Status checks are performed every minute and each returns a pass or a fail status.
* If all checks pass, the overall status of the instance is **OK**
* If one or more checks fail, the overall status is **Impaired**
* Status checks are built into EC2, so they cannot be disabled or deleted.
* Status checks data augments the information that EC2 already provides about the intended state of each instance \(such as pending, running, stopping\) as well as the utilization metrics that Amazon CloudWatch monitors \(CPU utilization, network traffic, and disk activity\).
* Alarms can be created, or deleted, that are triggered based on the result of the status checks.
  _for e.g., an alarm can be created to warn if status checks fail on a specific instance_
  .

### System Status Checks

* monitor the AWS systems required to use your instance to ensure they are working properly.
* detect problems with the instance that require AWS involvement to repair.
* When a system status check fails, one can either
  * wait for AWS to fix the issue
  * or resolve it by by stopping and restarting or terminating and replacing an instance
* System status checks failure might be cause of
  * Loss of network connectivity
  * Loss of system power
  * Software issues on the physical host
  * Hardware issues on the physical host

### Instance Status Checks

* monitor the software and network configuration of the individual instance
* checks detect problems that requires involvement to repair.
* When an instance status check fails, it can be resolved by either rebooting the instance or by making modifications in the operating system
* Instance status checks failure might be cause of
  * Failed system status checks
  * Misconfigured networking or startup configuration
  * Exhausted memory
  * Corrupted file system
  * Incompatible kernel

## CloudWatch Monitoring

* CloudWatch, helps monitor EC2 instances, which collects and processes raw data from EC2 into readable, near real-time metrics.
* Statistics are recorded for a period of two weeks, so that historical information can be accessed and used to gain a better perspective on how the application or service is performing.
* By default Basic monitoring is enabled and EC2 metric data is sent to CloudWatch in 5-minute periods automatically
* Detailed monitoring can be enabled on EC2 instance, which sends data to CloudWatch in 1-minute periods.
* **Aggregating Statistics Across Instances/ASG/AMI ID**
  * Aggregate statistics are available for the instances that have detailed monitoring \(at an additional charge\) enable, which provides data in 1-minute periods
  * Instances that use basic monitoring are not included in the aggregates.
  * CloudWatch does not aggregate data across Regions. Therefore, metrics are completely separate between Regions.
  * CloudWatch returns statistics for all dimensions in the AWS/EC2 namespace, if no dimension is specified
  * The technique for retrieving all dimensions across an AWS namespace does not work for custom namespaces published to CloudWatch.
  * Statistics include Sum, Average, Minimum, Maximum, Data Samples
  * With custom namespaces, the complete set of dimensions that are associated with any given data point to retrieve statistics that include the data point must be specified
* **CloudWatch alarms**
  * can be created to monitor any one of the EC2 instance’s metrics.
  * can be configured to automatically send you a notification when the metric reaches a specified threshold.
  * can automatically stop, terminate, reboot, or recover EC2 instances
  * can automatically recover an EC2 instance when the instance becomes impaired due to an underlying hardware failure a problem that requires AWS involvement to repair
  * can automatically stop or terminate the instances to save costs \(EC2 instances that use an EBS volume as the root device can be stopped or terminated, whereas instances that use the instance store as the root device can only be terminated\)
  * can use EC2ActionsAccess IAM role, which enables AWS to perform stop, terminate, or reboot actions on EC2 instances
  * If you have read/write permissions for CloudWatch but not for EC2, alarms can still be created but the stop or terminate actions won’t be performed on the EC2 instance

## EC2 Metrics

* **CPUCreditUsage**
  * \(Only valid for T2 instances\) The number of CPU credits consumed during the specified period.
  * This metric identifies the amount of time during which physical CPUs were used for processing instructions by virtual CPUs allocated to the instance.
  * CPU Credit metrics are available at a 5 minute frequency.
* **CPUCreditBalance**
  * \(Only valid for T2 instances\) The number of CPU credits that an instance has accumulated.
  * This metric is used to determine how long an instance can burst beyond its baseline performance level at a given rate.
  * CPU Credit metrics are available at a 5 minute frequency.
* **CPUUtilization**
  * % of allocated EC2 compute units that are currently in use on the instance. This metric identifies the processing power required to run an application upon a selected instance.
* **DiskReadOps**
  * Completed read operations from all instance store volumes available to the instance in a specified period of time.
* **DiskWriteOps**
  * Completed write operations to all instance store volumes available to the instance in a specified period of time.
* **DiskReadBytes**
  * Bytes read from all instance store volumes available to the instance.
  * This metric is used to determine the volume of the data the application reads from the hard disk of the instance.
  * This can be used to determine the speed of the application.
* **DiskWriteBytes**
  * Bytes written to all instance store volumes available to the instance.
  * This metric is used to determine the volume of the data the application writes onto the hard disk of the instance.
  * This can be used to determine the speed of the application.
* **NetworkIn**
  * The number of bytes received on all network interfaces by the instance. This metric identifies the volume of incoming network traffic to an application on a single instance.
* **NetworkOut**
  * The number of bytes sent out on all network interfaces by the instance. This metric identifies the volume of outgoing network traffic to an application on a single instance.
* **NetworkPacketsIn**
  * The number of packets received on all network interfaces by the instance. This metric identifies the volume of incoming traffic in terms of the number of packets on a single instance.
  * This metric is available for basic monitoring only
* **NetworkPacketsOut**
  * The number of packets sent out on all network interfaces by the instance. This metric identifies the volume of outgoing traffic in terms of the number of packets on a single instance.
  * This metric is available for basic monitoring only.
* **StatusCheckFailed**
  * Reports if either of the status checks, StatusCheckFailed\_Instance and StatusCheckFailed\_System, that has failed.
  * Values for this metric are either 0 \(zero\) or 1 \(one.\) A zero indicates that the status check passed. A one indicates a status check failure.
  * Status check metrics are available at 1 minute frequency
* **StatusCheckFailed\_Instance**
  * Reports whether the instance has passed the Amazon EC2 instance status check in the last minute.
  * Values for this metric are either 0 \(zero\) or 1 \(one.\) A zero indicates that the status check passed. A one indicates a status check failure.
  * Status check metrics are available at 1 minute frequency
* **StatusCheckFailed\_System**
  * Reports whether the instance has passed the EC2 system status check in the last minute.
  * Values for this metric are either 0 \(zero\) or 1 \(one.\) A zero indicates that the status check passed. A one indicates a status check failure.
  * Status check metrics are available at a 1 minute frequency



