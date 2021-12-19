## Overview

* An instance is a virtual server in the AWS cloud.You launch an instance from an Amazon Machine Image \(AMI\).
* AMI provides the operating system, application server, and applications for your instance.
* When an instance is launched, it receives a public DNS name that can be used to contact the instance from the Internet. Instance also receives a private DNS name that other instances within the same Amazon EC2 network can use to contact the instance

## Instance Lifecycle

![](https://i1.wp.com/jayendrapatil.com/wp-content/uploads/2016/04/screen-shot-2016-04-30-at-6-32-08-am.png?resize=656%2C343 "EC2 Instance Lifecycle")

* Pending
  * When the instance is first launched is enters into the **pending **state
* Running
  * After the instance is launched, it enters into the **running **state
  * Charges are incurred for every hour or partial hour the instance is running even if it is idle
* Start &Stop \(EBS-backed instances only\)
  * Only and EBS-backed instance can be stopped and started. Instance store-bakced instance cannot be stopped and started
  * An instance can stopped &started in case the instance fails a status check or is not running as expected
  * Stop
    * After the instance is stopped, it enters in stopping state and then to stopped state.
    * Charges are only incurred for the EBS storage and not for the instance hourly charge or data transfer.
    * While the instance is stopped, you can treat its root volume like any other volume, and modify it
      _for e.g. repair file system problems or update software or change the instance type, user data, EBS otpmization attributes etc_
    * Volume can be detached from the stopped instance, and attached to a running instance, modified, detached from the running instance, and then reattached to the stopped instance. It should be reattached using the storage device name that’s specified as the root device in the block device mapping for the instance.
  * Start
    * When the instance is started, it enters into pending state and then into running
    * An instance when stopped and started is launched on a new host
    * Any data on an instance store volume \(not root volume\) would be lost while data on the EBS volume persists
  * EC2 instance retains its private IP address as well as the Elastic IP address. However, the public IP address, if assigned instead of the Elastic IP address, would be released
  * Charges for full hour are incurred for every transition from stopped to running, even if the transition is within the same hour
    _for e.g. if you stop and start your instances 2 times in an hour, you would be charged for 3 full hours, one for the start and then for the 2 transitions as if you had 3 instances running during that hour_
* Instance reboot
  * Both EBS-backed and Instance store-backed instances can be rebooted
  * An instance retains it public DNS, public and private IP address during the reboot
  * Data on the EBS and Instance store volume is also retained
  * Amazon recommends to use Amazon EC2 to reboot the instance instead of running the operating system reboot command from your instance as it performs a hard reboot if the instance does not cleanly shutdown within four minutes also creates an API record in CloudTrail, if enabled.
* Instance retirement
  * An instance is scheduled to be retired when AWS detects irreparable failure of the underlying hardware hosting the instance.
  * When an instance reaches its scheduled retirement date, it is stopped or terminated by AWS.
  * If the instance root device is an Amazon EBS volume, the instance is stopped, and can be started again at any time.
  * If the instance root device is an instance store volume, the instance is terminated, and cannot be used again.
* Instance Termination
  * An instance can be terminated, and it enters into the shutting-down and then the terminated state
  * After an instance is terminated, it can’t be connected and no charges are incurred
  * Instance Shutdown behaviour
    * **EBS-backed instance**
      supports
      **InstanceInitiatedShutdownBehavior**
      attribute which determines whether the instance would be stopped or terminated when a shutdown command is initiated from the instance itself
      _for e.g. shutdown, halt or poweroff command in linux_
      .
    * Default behaviour for the the instance to be stopped.
    * A shutdown command for an Instance store-backed instance will always terminate the instance
  * **Termination protection**
    * Termination protection \(DisableApiTermination attribute\) can be enabled on the instance to prevent it from being accidently terminated
    * DisableApiTerminationfrom the Console, CLI or API.
    * Instance can be terminated through Amazon EC2 CLI.
    * Termination protection does not work for instances when
      * part of an Autoscaling group
      * launched as Spot instances
      * terminating an instance by initiating shutdown from the instance
  * Data persistence
    * EBS volume have a DeleteOnTermination attribute which determines whether the volumes would be persisted or deleted when an instance they are associated with are terminated
    * Data on Instance store volume data does not persist
    * Data on EBS root volumes, have the DeleteOnTermination flag set to true, would be deleted by default
    * Additional EBS volumes attached have the DeleteOnTermination flag set to false are not deleted but just dettached from the instance

![](https://i0.wp.com/jayendrapatil.com/wp-content/uploads/2016/04/screen-shot-2016-04-30-at-7-16-00-am.png?resize=656%2C675 "Screen Shot 2016-04-30 at 7.16.00 AM.png")

