# AWS CloudHSM

* AWS CloudHSM provides secure cryptographic key storage to customers by making hardware security modules \(HSMs\) available in the AWS cloud
* AWS CloudHSM helps meet corporate, contractual and regulatory compliance requirements for data security by using dedicated HSM appliances within the AWS cloud.
* A hardware security module \(HSM\)
  * is a hardware appliance that provides secure key storage and cryptographic operations within a tamper-resistant hardware module.
  * are designed with physical and logical mechanisms, to securely store cryptographic key material and use the key material without exposing it outside the cryptographic boundary of the appliance.
  * physical protections include tamper detection and tamper response. When a tampering event is detected, the HSM is designed to securely destroy the keys rather than risk compromise
  * logical protections include role-based access controls that provide separation of duties
* CloudHSM allows encryption keys protection within HSMs, designed and validated to government standards for secure key management.
* CloudHSM helps comply with strict key management requirements within the AWS cloud without sacrificing application performance
* CloudHSM uses SafeNet Luna SA HSM appliances
* HSMs are located in AWS data centers, managed and monitored by AWS, but AWS does not have access to the keys
* AWS can’t help recover the key material if the credentials are lost
* HSMs are inside your VPC and isolated from the rest of the network
* CloudHSM provides single tenant dedicated access to each HSM appliance
* Placing HSM appliances near your EC2 instances decreases network latency, which can improve application performance
* Only you have access to the keys and operations to generate, store and manage on the keys
* Integrated with Amazon Redshift and Amazon RDS for Oracle
* Other use cases like EBS volume encryption and S3 object encryption and key management can be handled by writing custom applications and integrating them with CloudHSM



