1. Verify the Security groups are properly configured to allow ssh access from the ip to the EC2 instance. For Security groups, Inbound traffic from the public ip address should be enabled

1. Verify the NACLs are properly configured to allow ssh access from the ip to the EC2 instance. For NACLs, Inbound traffic from the public ip address should be enabled as well as the Outbound traffic for the response should be enabled
2. Verify you are using the private key file that corresponds to the key pair that you selected when you launched the instance
3. Verify you are connecting with the appropriate user name for your AMI. Mind the user names used to connect to the EC2 instance are different depending upon the AMI \(which also determines the OS for the Instance\)
4. Private User key file is not recognized by the Server



