# Why Use AWS 

Switching to AWS offers many advantages:

 Durability – Amazon S3 and Amazon Glacier3 are designed for 99.999999999% durability for the objects stored in them.

 Security – AWS provides a number of options for access control and encrypting data in transit and at rest.

 Global Infrastructure – Amazon Web Services are available across the globe so you can back up and store data in the region that meets your compliance requirement.

 Compliance –AWS infrastructure is designed and managed in alignment with regulations, standards and best-practices including \(as of the date of this publication\) SOC, SSAE 16, ISO 27001, PCI DSS, HIPPA, and FedRamp so you can easily fit the backup solution into your existing compliance regimen.

 Scalability – With AWS, you don’t have to worry about capacity. You can scale your consumption up or down as your needs change.

 Lower TCO – The AWS scale of operations drives service costs down and helps lower the overall TCO of the storage. AWS often passes these cost savings on to the customer. As of the date of this publication, AWS has lowered prices 45 times since they began offering web services.

# Backup and Archive 

A good backup process can be defined based on the objectives:

1. Backing up file data

2. Backing up database

3. Backing up machine images

## Cloud Native 

This scenario describes a workload environment that exists entirely on AWS. This includes web servers, application servers, databases, Active Directory, monitoring servers, etc.![](/assets/cloud-native-backup1.png)

### Snapshot Options for Amazon EBS 

ec2-create-volume –z us-west-1b –snapshot MySnapshotName

ec2-detach-volume OldVolume

ec2-attach-volume VolumeID –I InstanceID –d Device

Remount the volume on the running instance.

### Creating Consistent or Hot Backups 

**Steps to back file system or database:**

it is necessary to quiesce the file system or database in order to make a clean backup. How you do this depends on your database and/or file system, so due diligence is required. To summarize the process for a database:

 If possible, put the database into hot backup mode. Alternatively, create a read replica copy of the database; this is a copy of the database that is up to date but runs on a separate instance. Keep in mind that on AWS you can run this instance for the duration required to perform the backup and then close it down, saving resources.

 Issue the relevant Amazon EBS snapshot commands.

 Take the database out of hot backup mode or, if using a read replica, terminate the read replica instance.

### Multivolume Backups 

In some cases, you may stripe data across multiple Amazon EBS volumes by using a logical volume manager in order to increase potential throughput. When using a logical volume manager \(e.g., mdadm or LVM\), it is important to perform the backup from the volume manager layer rather than the underlying devices. This ensures all metadata is consistent and that the various subcomponent volumes are coherent.You can take a number of approaches to accomplish this, an example being the script created by [alestic.com.9](https://github.com/alestic/ec2-consistent-snapshot)



### Backing Up Databases 

you can leverage efficient data movement techniques such as snapshots to create backups that are fast, reliable, and space efficient

For databases that are built upon RAID sets of Amazon EBS volumes \(and have total storage less than 1 TB\), an alternative backup approach is to asynchronously replicate data to another database instance built using a single Amazon EBS volume. While the destination Amazon EBS volume will have slower performance, it is not being used for data access, and you can easily send a snapshot to Amazon S3 using the Amazon EBS snapshot capability



### Backups for Amazon Relational Database Service 

Automated backups enable point-in-time recovery of your DB Instance. When automated backups are turned on for your DB instance, Amazon RDS automatically performs a full daily backup of your data \(during your preferred backup window\) and captures transaction logs \(as updates to your DB instance are made\).

DB snapshots are user-initiated and enable you to back up your DB instance in a known state as frequently as you wish, and then restore to that specific state at any time. DB snapshots can be created with the AWS Management Console or by using the CreateDBSnapshot API call. The snapshots are kept until you explicitly delete them with the console or the DeleteDBSnapshot API call.

### Backup and Recovery of the Amazon Machine Image \(AMI\)

![](/assets/AMI-backpup1.png)An AMI that you register is automatically stored in your account using Amazon EBS snapshots.

## On Premises 

This scenario describes a workload environment with no component in the cloud. All resources, including web servers, application servers, databases, Active Directory, monitoring, and more, are hosted either in the customer data center or colocation  
![](/assets/on-promise-backup1.png)![](/assets/direct-backup1.png)

![](/assets/proxy-backup1.png)AWS Storage Gateway supports three configurations:

 Gateway-cached volumes – You can store your primary data in Amazon S3 and retain your frequently accessed data locally. Gateway-cached volumes provide substantial cost savings on primary storage, minimize the need to scale your storage on premises, and retain low-latency access to your frequently accessed data.

 Gateway-stored volumes – In the event you need low-latency access to your entire data set, you can configure your on-premises data gateway to store your primary data locally, and asynchronously back up point-in-time snapshots of this data to Amazon S3. Gateway-stored volumes provide durable and inexpensive off-site backups that you can recover locally or from Amazon EC2.

 Gateway-virtual tape library \(gateway-VTL\) – With gateway-VTL you can have a limitless collection of virtual tapes. Each virtual tape can be stored in a virtual tape library backed by Amazon S3 or a virtual tape shelf backed by Amazon Glacier. The virtual tape library exposes an industry standard iSCSI interface, which provides your backup application with online access to the virtual tapes. When you no longer require immediate or frequent access to data contained on a virtual tape, you can use your backup application to move it from its virtual tape library to your virtual tape shelf to further reduce your storage costs.

## Hybrid 

![](/assets/hybid-backup1.png)If you already have an existing framework that backs up data for your on-premises servers, then it is easy to extend that framework to your AWS resources over a VPN connection or AWS Direct Connect. You will install the backup agent on the Amazon EC2 instances and back them up per the existing data protection policies.

Depending on your backup framework setup, you may have a master backup server along with one or more media servers. You may consider moving the master backup server to an Amazon EC2 instance to automatically protect your master backup server against on-premises disasters and have a highly available backup infrastructure.

To manage the backup data flows, you may also consider creating one or more media servers on Amazon EC2 instances. This will help the cloud-based resources backup to a local media target rather than go over the network back to the on-premises environment.

You can also leverage the AWS Storage Gateway or other third-party storage gateways from the AWS Marketplace to connect your backup framework to Amazon storage services. The storage gateways are connected to the media servers allowing data to be securely and durably stored on Amazon S3 or Amazon Glacier.

![](/assets/hbd-gateway-backup1.png)

# Cloud Paradigms 

## Protecting Configurations Rather Than Servers 

With Amazon EC2 you can focus on protecting configuration and stateful data, rather than the server itself. This set of data is much smaller than the aggregate set of server data, which typically includes various application files, operating system files, temporary files, and so on. This change of approach means that regular nightly incremental or weekly full backups can take far less time and consume less storage space.

## 



