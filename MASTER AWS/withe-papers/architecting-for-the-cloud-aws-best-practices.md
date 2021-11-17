# Architecting for the Cloud: AWS Best Practices

## The Cloud Computing Difference

IT Assets Become Programmable Resources

Global, Available, and Unlimited Capacity

Higher Level Managed Services

Security Built In

## Design Principles

**Scalability **

---

**Scaling Vertically**: upgrade CPU, RAM， DISK

**Scaling Horizontally**：

1， Stateless Applications：

1.1 distribute load to multiple nodes:

```
  Push model:ELB& Route53

 Pull model: Amazon SQS& Amazon Kinesis
```

1.2 Stateless Components

Amazon DynamoDB, Amazon EFS ,Amazon SWF

1.3 Stateful Components

How to implement session affinity:“sticky sessions” feature of ELB, and  client side implement health check and distribute request.

**Distributed Processing**

By dividing a task and its data into many small fragments of work, you can execute each of them in any of a larger set of available compute resources

Offline Batch job:Amazon EMR

real-time processing of streaming data:Amazon Kinesis

**Disposable Resources Instead of Fixed Servers **

---

**Instantiating Compute Resources**

**Bootstrapping**:user data scripts cloud-init AWS OpsWorks, configuration management tools like Chef or Puppet, AWS CloudFormation

**Golden Images&docker**

**Hybrid\(Bootstrapping& Golden Images\)**

**Infrastructure as Code: AWS CloudFormation**

**Automation**

---

AWS Elastic Beanstalk12 is the fastest and simplest way to get an application up and running on AWS

Amazon EC2 Auto recovery

Auto Scaling

Amazon CloudWatch Alarms

Amazon CloudWatch Events

AWS OpsWorks Lifecycle events

AWS Lambda Scheduled events

**Loose Coupling **

---

Well-Defined  API:** **API Gateway is a fully managed service that makes it easy for developers to create, publish, maintain, monitor, and secure APIs at any scale

Service Discovery:

Asynchronous Integration

Graceful Failure

**Services, Not Servers **

---

Managed Services

Serverless Architectures

**Databases**

---

Relational Databases\(RDS\)

NoSQL Databases

Data Warehouse\(AWS Redshift\)

Search:Amazon CloudSearch and Amazon Elasticsearch Service \(Amazon ES\)

**Removing Single Points of Failure**

---

Introducing Redundancy

Detect Failure

Durable Data Storage

Automated Multi-Data Center Resilience

Fault Isolation and Traditional Horizontal Scaling



**Optimize for Cost**

---

Right Sizing

Elasticity

Take Advantage of the Variety of Purchasing Options\(Reserved Capacity \)



**Caching**

---

Application Data Caching

Edge Caching



**Security**

---

Utilize AWS Features for Defense in Depth

Offload Security Responsibility to AWS

Reduce Privileged Access

Security as Code

Real-Time Auditing



