# Blue/Green Deployments on AWS

---

---

## Introduction

---

### Blue/Green Deployment Methodology

The fundamental idea behind blue/green deployment is to shift traffic between two identical environments that are running different versions of your application

### Benefits of Blue/Green

simply roll traffic back to the still-operating blue environment is a key benefit of blue/green deployments

Blue/green deployments also fit well with continuous integration and continuous deployment \(CI/CD\) workflows, in many cases limiting their complexity.

blue/green deployments also provide cost optimization benefits

### Define the Environment Boundary

where have things changed and what needs to be deployed to make those changes live.

## AWS Tools and Services Enabling Blue/Green Deployments

---

### Amazon Route 53

Amazon Route 53 is a highly available and scalable authoritative DNS service that routes user requests for Internet-based resources to the appropriate destination

### Elastic Load Balancing

Elastic Load Balancing distributes incoming application traffic across designated Amazon Elastic Compute Cloud \(Amazon EC2\) instances.3 Elastic Load Balancing scales in response to incoming requests, performs health checking against Amazon EC2 resources, and naturally integrates with other AWS tools, such as Auto Scaling. This makes it a great option for customers who want to increase application fault tolerance.

### Auto Scaling

Auto Scaling helps maintain application availability and lets customers scale EC2 capacity up or down automatically according to defined conditions

### AWS Elastic Beanstalk

AWS Elastic Beanstalk is a fast and simple way to get an application up and running on AWS

### AWS OpsWorks

AWS OpsWorks is a configuration management service based on Chef that allows customers to deploy and manage application stacks on AWS

### AWS CloudFormation

AWS CloudFormation provides customers with the ability to describe the AWS resources they need through JSON formatted templates

### Amazon CloudWatch

Amazon CloudWatch is a monitoring service for AWS Cloud resources and the applications you run on AWS

## Techniques

---

### Update DNS Routing with Amazon Route 53

![](/assets/bgdnsswitch1.png)

### Swap the Auto Scaling Group Behind Elastic Load Balancer

![](/assets/bgautoscalinggroup1.png)

![](/assets/bgautoscaling2.png)

### Update Auto Scaling Group Launch Configurations

![](/assets/bgautoswitch1.png)

![](/assets/bgautoswitch2.png)

![](/assets/bgswithc3.png)

### Swap the Environment of an Elastic Beanstalk Application

benstalk support switch app url. basically it's like DNS switch.

![](/assets/bgswapurl1.png)

![](/assets/bgswapurl2.png)

### Clone a Stack in AWS OpsWorks and Update DNS

![](/assets/bgopsworks1.png)

## Best Practices for Managing Data Synchronization and Schema Changes

---

### Decoupling Schema Changes from Code Changes

![](/assets/bgdatabaseschemachange1.png)

need sufficient test as this approache may break production when the schema change failed.

### When Blue/Green Deployments Are Not Recommended

when the blue and green environments are in geographically disparate regions

application need to be “deployment aware”

commercial off-the-shelf \(COTS\) application come with a predefined update/upgrade process that isn’t blue/green deployment friendly

## Conclusion

---

Comparsion of the blue/green deployment methods

![](/assets/bgdeploytable1.png)

![](/assets/bgdeploytable2.png)

