## EBS {#ebs}

* general
 
  * attached in same AZ
  * create snapshot cross AZ or region
  * Root EBS volume is deleted, by default
  * persists independently
* encrypted
 
  * Public or shared snapshots of encrypted volumes are not supported
  * Existing unencrypted volumes cannot be encrypted directly. Can migrate from copy encripted snapshot
  * Supported on all Amazon EBS volume types, not instance type
* performence
 
  * use raid0 , raid1 improve iops
  * EBS optimized with PIOPS EBS
* price
 
  * charge with storage, I/O requests and snapshot storage
  * EBS backed EC2,very stop/start it will be charged as a separate hour
* snapshot



