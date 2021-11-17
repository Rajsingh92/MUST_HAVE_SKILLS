# AWS WorkSpace

* Amazon WorkSpace is a fully managed, secure desktop computing service which runs on the AWS cloud.
* WorkSpace is a cloud-based virtual desktop that can act as a replacement for a traditional desktop
* A WorkSpace is available as a bundle of compute resources, storage space, and software applications that allows a user to perform day-to-day tasks just like using a traditional desktop
* WorkSpace allows user to easily provision cloud-based virtual desktops and provide users access to the documents, applications, and resources they need from any supported device, including computers, Chromebooks, iPads, Fire tablets, and Android tablets.
* Each WorkSpace runs on an individual instance for the user it is assigned to and Applications and users’ documents and settings are persistent.
* Security
  * User can login into the WorkSpace using their own credentials set when the instance is provisioned
  * WorkSpaces service integrates with existing Active Directory domain, users will sign in with their regular Active Directory credentials.
  * WorkSpaces also integrates with existing RADIUS server to enable multi-factor authentication \(MFA\).
* Backup and Encryption
  * User volume \(D:\) is backed up every 12 hours and if the WorkSpace fails, AWS can restore the volume from the backup
  * WorkSpaces supports root volume \(C: drive\) and user volume \(D: drive\) encryption
  * WorkSpaces uses EBS volumes that can be encrypted on WorkSpace creation, providing encryption for data stored at rest, disk I/O to the volume, and snapshots created from the volume.
  * WorkSpaces integrates with the AWS KMS service with the ability to provide keys for encrypting the volumes
* Amazon WorkSpaces Application Manager \(Amazon WAM\)
  * WAM offers a fast, flexible, and secure way for you to deploy and manage applications for Amazon WorkSpaces.
  * WAM accelerates software deployment, upgrades, patching, and retirement by packaging Microsoft Windows desktop applications into virtualized application containers that run as though they are natively installed.



