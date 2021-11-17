# Serverless Architectures with AWS Lambda

---

---

## Introduction -What Is Serverless?

---

No server management

Flexible scaling

High availability

No idle capacity

## AWS Lambda—the Basics

---

> _Lambda is a high-scale, provision-free serverless compute offering based on functions. It provides the cloud logic layer for your application_

![](/assets/serverless1.png)

## AWS Lambda—Diving Deeper

---

### Lambda Function Code

**The Function Code Package**

The function code package contains all of the assets you want to have available locally upon execution of your code

**The Handler**

The handler is a specific code method \(Java, C\#\) or function \(Node.js, Python\) that you’ve created and included in your package

**The Event Object**

When your Lambda function is invoked in one of the supported languages, one of the parameters provided to your handler function is an event object

**The Context Object**

{RequestId:'xxxx', RemainingTime:300, Logging:'CloudWatch Logs'}

**Writing Code for AWS Lambda—Statelessness and Reuse**

> _**your code cannotmake assumptions about state**_

![](/assets/lambdacode1.png)

### Lambda Function Event Sources

S3 event, SNS message, APIgateway call, Cloud Formation.......

**Invocation Patterns: Push Model&Pull Model**

**Push Model Event Sources:**

* Amazon S3
* Amazon API Gateway
* Amazon SNS
* AWS CloudFormation
* Amazon CloudWatch Events
* Amazon Alexa

**Pull Model Event Sources**

* Amazon DynamoDB
* Amazon Kinesis Streams

### Lambda Function Configuration

#### **Function Memory**

Not only will function memory dictate the amount of memory available to  
 your function code during execution, but the same dial will also influence the CPU and network resources available to your function.

#### **Versions and Aliases**

Amazon Resource Name \(ARN\):

> arn:aws:lambda:\[region\]:\[account\]:function:\[fn\_name\]:\[version\]

Each and every Lambda function has a default version built in: $LATEST

It’s important to know that a Lambda function container is specific to a particular version of your function

**Lambda aliases** should be used here, instead. A function alias allows you to invoke and point event sources to a specific Lambda function version.

Here are some example suggestions for Lambda aliases and how you might use them:

**• live/prod/active** – This could represent the Lambda function version that your production triggers or that clients are integrating with.

**• blue/green** – Enable the blue/green deployment pattern through use of aliases.

**• debug** – If you’ve created a testing stack to debug your applications, it can integrate with an alias like this when you need to perform a deeper analysis.

#### **IAM Role**

#### Lambda Function Permissions

#### Network Configuration

* Default – Your Lambda function communicates from inside a virtual private cloud \(VPC\) that is managed by Lambda. It can connect to the internet, but not to any privately deployed resources running within your own VPCs.
* VPC – Your Lambda function communicates through an Elastic Network Interface \(ENI\) that is provisioned within the VPC and subnets you choose within your own account. These ENIs can be assigned security groups, and traffic will route based on the route tables of the subnets those ENIs are placed within—just the same as if an EC2 instance were placed in the same subnet.

#### Environment Variables

#### Dead Letter Queues

If an exception occurs when trying to invoke your function in these models, the invocation will be attempted two more times \(with back-off between the retries\). After the third attempt, the event is either discarded or placed onto a dead letter queue, if you configured one for the function.

#### Timeout

The maximum timeout for a Lambda function is 300 seconds

### Serverless Best Practices

---

### Serverless Architecture Best Practices

#### Security Best Practices

ensure security best practices through writing secure application code, tight access control over source code changes, and following AWS security best practices for each of the services that your Lambda functions integrate with

* One IAM Role per Function
* Temporary AWS Credentials
* Persisting Secrets
* Using Secrets
* API Authorization
* VPC Security
* Deployment Access Control

#### Reliability Best Practices

High Availability

Fault Tolerance

Recovery

#### Performance Efficiency Best Practices

Choosing the Optimal Memory Size

Language Runtime Performance

Optimizing Your Code

Understanding Your Application Performance

#### Operational Excellence Best Practices

Logging

**Metrics and Monitoring**: integrate cloudwatch API and log metrics in lambda code

**Deployment: **

* Parallel version invocations
* Deployment schedule
* Rollback

**Load Testing**

**Triage and Debugging**

#### Cost Optimization Best Practices

Right-Sizing

Distributed and Asynchronous Architectures

Batch Size

Event Source Selection

#### Serverless Development Best Practices

##### Infrastructure as Code – the AWS Serverless Application Model \(AWS SAM\)

##### Local Testing – AWS SAM Local

##### Coding and Code Management Best Practices

###### **Coding Best Practices:**

Business Logic outside the Handler

Warm Containers—Caching/Keep-Alive/Reuse

Control Dependencies

Fail Fast

#### Code Management Best Practices

Code Repository Organization

Release Branches

Testing

* Unit Tests
* Integration Testing

## Sample Serverless Architectures

---

### 

## Conclusion

---



