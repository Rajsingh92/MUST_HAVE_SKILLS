# EC2 Instance Metadata & Userdata

* Instance metadata and user data can be used for Self Configuration allowing EC2 instance answer the question
  **Who am I ? What should I do ?**
* Instance metadata and user data can be accessed from within the instance itself
* Data is not protected by cryptographic methods. Anyone who can access the instance can view its metadata and should not be used to any store sensitive data, such as passwords, as user data.
* Both the metadata and user data is available from the IP address
  **169.254.169.254**
  and has the latest as well as previous versions available
* Metadata and User data can be retrieved using simple _curl _or_ GET _command and these requests are not billed

## Instance Metadata

* Instance metadata is data about the Instance and allows you to get answers to the
  **Who am I?**
* Instance metadata is divided into two categories
  * Instance metadata
    * includes metadata about the instance such as instance id, ami id, hostname, ip address, role etc
    * Can be accessed from http://169.254.169.254/latest/meta-data/
  * Dynamic data
    * is generated when the instances are launched such as instance identity documents, instance monitoring etc
    * Can be accessed from http://169.254.169.254/latest/dynamic/
* Instance metadata can be used for managing and configuring instances

## User Data

* User data can be used for bootstrapping EC2 instance and helps answer the
  **What should I do?**
* User data is supplied when launching a EC2 instance and executed at boot time
* User data can be in the form of parameters or user defined script executed when the instance is launched
  _for e.g. perform software patch updates, load and update the application from an S3 bucket etc_
* User data can be used to build more generic AMIs which can then be configured at launch time dynamically
* User data can be retrieved from http://169.254.169.254/latest/user-data
* User data is executed only at the launch of the instance.
* If you stop an instance, modify the user data, and start the instance, the new user data is not executed automatically.
* User data is treated as opaque data and returned as is.
* User data is limited to 16 KB. This limit applies to the data in raw form, not base64-encoded form.
* User data must be base64-encoded before being submitted to the API. The EC2 command line tools perform the base64 encoding for you. The data is decoded before being presented to the instance.

## Cloud-Init & EC2Config

* Cloud-Init and EC2Config provides the ability to parse the user-data script on the instance and run the instructions
* **Cloud-Init**
  * Amazon Linux AMI supports Cloud-Init, which is an open source application built by Canonical.
  * Cloud-Init is installed on Amazon Linux, Ubuntu and RHEL AMIs
  * Cloud-Init enables using the EC2 UserData parameter to specify actions to run on the instance at boot time
  * User data is executed on first boot using Cloud-Init if the user data begins with \#!
* **EC2Config**
  * EC2Config is installed on Windows Server AMIs
  * User data is executed on first boot using Cloud-Init \(technically EC2Config parses the instructions\) if the user data begins with &lt;script&gt; or &lt;powershell&gt;
  * EC2Config service is started when the instance is booted. It performs tasks during initial instance startup \(once\) and each time you stop and start the instance.
  * It can also perform tasks on demand. Some of these tasks are enabled automatically, while others must be enabled manually.
  * EC2Config uses settings files to control its operation
  * EC2Config service runs Sysprep, a Microsoft tool that enables you to create a customized Windows AMI that can be reused.
  * When EC2Config calls Sysprep, it uses the settings files in EC2ConfigService\Settings to determine which operations to perform.



