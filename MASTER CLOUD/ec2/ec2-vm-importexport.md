EC2 VM Import/Export enables importing virtual machine \(VM\) images from existing virtualization environment to EC2, and then export them back

* EC2 VM Import/Export enables
  * migration of applications and workloads to EC2,
  * coping VM image catalog to EC2, or
  * create a repository of VM images for backup and disaster recovery
  * to leverage previous investments in building VMs by migrating your VMs to EC2.
* The supported file formats are: VMware ESX VMDK images, Citrix Xen VHD images, Microsoft Hyper-V VHD images, and RAW images
* For VMware vSphere, AWS Connector for vCenter can be used to export a VM from VMware and import it into Amazon EC2
* For Microsoft Systems Center, AWS Systems Manager for Microsoft SCVMM can be used to import Windows VMs from SCVMM to EC2

## ![](https://i1.wp.com/jayendrapatil.com/wp-content/uploads/2016/11/AWS-EC2-ImportExport.png?resize=656%2C479 "AWS EC2 VM Import/Export")

## EC2 VM Import/Export features

* ability to import a VM from a virtualization environment to EC2 as an Amazon Machine Image \(AMI\), which can be used to launch an EC2 instance
* ability to import a VM from a virtualization environment to EC2 as an EC2 instance, which is initially in a stopped state. AMI can be created from it
* ability to export a VM that was previously imported from the virtualization environment
* ability to import disks as Amazon EBS snapshots.



