Here are some Sample Questions for AWS Certified Developer Associate Certification. Answers are at the bottom. In case you need detailed clarification, please feel free to post it in the comments section.



### **AWS Fundamentals**

1. What is a worker with respect to SWF?

a. Workers are programs that interact with Amazon SWF to get tasks, process the received task, and return the results

b. Workers are ec2 instances which can create s3 buckets and process SQS messages

c. Workers are the people in the warehouse processing orders for amazon

d. Workers are the component of IIS which run on windows platform under the w3wp.exe process

2. Which of the below statements about DynamoDB are true? \(Select any 2\)

a. DynamoDB uses a Transaction-Level Read Consistency

b. DynamoDB uses optimistic concurrency control

c. DynamoDB uses conditional writes for consistency

d. DynamoDB restricts an item access during reads

e. DynamoDB restricts item access during writes

### **Designing and Developing**

1. A Security system monitors 600 cameras, saving image metadata every 1 minute to an Amazon DynamoDB table. Each sample involves 1 kb of data, and the data writes are evenly distributed over time.

How much write throughput is required for the target table?

a. 6000

b. 10

c. 3600

d. 60

e. 600

2. Which read request in DynamoDB returns a response with the most up-to-date data, reflecting the updates from all prior write operations that were successful?

a. Eventual Consistent Reads

b. Conditional reads for consistency

c. Strongly Consistent Reads

d. Not possible

3. You run a Query operation which returned all the data attributes for the selected items. You are only interested in seeing a few attributes. How do you achieve this in DynamoDB?

a. This is not possible

b. Use ProjectExpression

c. Use ExpressionAttribute

d. Use ProjectionExpression

### **Deployment and Security**

1. AWS Elastic Beanstalk currently supports which of the following platforms? \(select any 2\)

a. Java with Apache

b. IBM with Websphere

c. .Net

d. Perl

 2. Which of the following features allow organizations to leverage a commercial federation server as an identity bridge, providing secure single sign-on into the AWS console without storing user keys and without additional passwords or sign-on?

a. Web Identification Services

b. Web Identity Federation

c. Active Directory Authentication Services

d. SAML federation

3. Your web service is burning expensive CPU cycles by constantly polling SQS queues for messages. How can you avoid this?

a. Use Elasticache to cache the messages, rather than SQS.

b. Enable SQS Long Polling

c. Modify web service code to only poll a few minutes

d. SQS automatically pushes messages to the web service, so this should not be a problem

### **Debugging**

1. The output named BackupLoadBalancerDNSName returns the DNS name of the resource with the logical ID of BackupLoadBalancer.

Which of the following represents a valid AWS CloudFormation Template?

a. “Outputs” : {  
“BackupLoadBalancerDNSName” : {  
“Description”: “The DNSName of the backup load balancer”,  
“Value”: { “Ls::GetAtt” : \[ “BackupLoadBalancer”, “DNS” \]},  
}

b. “Outputs” : {  
“BackupLoadBalancerDNSName” : {  
“Description”: “The DNSName of the backup load balancer”,  
“Value”: { “Fn::GetAtt” : \[ “BackupLoadBalancer”, “DNSName” \]},  
}

c. “Outputs” : {  
“BackupLoadBalancerDNSName” : {  
“Description”: “The DNSName of the backup load balancer”,  
“Value”: { “Fn::PostAtt” : \[ “BackupLoadBalancer”, “Name” \]},  
}

d. “Outputs” : {  
“BackupLoadBalancerDNSName” : {  
“Description”: “The DNSName of the backup load balancer”,  
“Value”: { “Fn::GetAtt” : \[ “BackupLoadBalancer”,  \]},  
}

2. According to below IAM Policy which is the most appropriate possibility?

| 123456789101112131415161718192021222324252627282930 | {"Version": "2012-10-17","Statement": \[{"Sid": "Stmt1459162621000","Effect": "Allow","Action": \["sns:CreateTopic","sns:Subscribe","sns:DeleteTopic"\],"Resource": \[ "\*" \]},{"Effect": "Deny","Action": \[ "sns:DeleteTopic"\],"Resource": \[ "\*" \]}\]} |
| :--- | :--- |


a. User can perform CreateTopic,Subscribe and DeleteTopic

b. User  is denied  to perform only DeleteTopic

c. User can perform CreateTopic and Subscribe but denied to perform DeleteTopic operation

d. The above policy is invalid



**Answers:**



### **AWS Fundamentals**

1. a
2. b,c

### **Designing and Developing**

1. b
2. c
3. d

### **Deployment and Security**

1. a,c
2. d
3. b

### **Debugging**

1.  b
2.  c



