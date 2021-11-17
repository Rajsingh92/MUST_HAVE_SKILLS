# Optimizing Enterprise Economics with Serverless Architectures

---

---

## Introduction

---

## Understanding Serverless Applications

---

* There is no need to provision, deploy, update, monitor, or otherwise manage servers. All of the actual hardware and server software is handled by the cloud provider.
* The application scales automatically, triggered by its actual use. This is inherently different from conventional applications, which require a receiver fleet and explicit capacity management to scale to peak load.
* In addition to scaling, availability and fault tolerance are built in. No coding, configuration, or management is required to gain the benefit of these capabilities.
* There are no charges for idle capacity. There is no need \(and in fact, no ability\) to pre-provision or over-provision capacity. Instead, billing is pay-per-request and based on the duration it takes for code to run.

### Serverless Application Use Cases

except bleow not appropriate

### Is Serverless Always Appropriate?

below is not appropriate:

* When the goal is explicitly to avoid making any changes to an application.
* When fine-grained control over the environment is required, such as specifying particular operating system patches or accessing low-level networking operations, in order for the code to run properly.
* When an on-premises application hasn’t been migrated to the public cloud.

## Evaluating a Cloud Vendor’s Serverless Platform

---

### ![](/assets/awsserverless1.png)

### The AWS Serverless Platform

![](/assets/awsserverless2.png)

### AWS Serverless Platform Capabilities

•  Amazon API Gateway – HTTP endpoints for Lambda functions, including a full range of API proxy and API management capabilities.

• Amazon S3 – Lambda functions can be used as automatic event triggers when an object is created, copied, or deleted.

• Amazon DynamoDB – Lambda functions can be used to process any or all of the changes made to a database table.

• Amazon SNS – Messages can be routed to Lambda functions for processing, adding the ability to dynamically respond to published content.

Optimizing Enterprise Economics with Serverless Architectures

Page 12

• Amazon SQS – Messages in queues can be easily processed by Lambda functions.

• Amazon Kinesis Streams – In-order record processing of streaming data is provided by Lambda functions, making it easy to build near real-time analytics engines.

• Amazon Kinesis Firehose – Lambda functions can be applied automatically to the records ingested by a Firehose, making it easy to add transformation, filtering, and analysis capabilities to a data stream.

• Amazon Athena –Lambda functions can be automatically triggered for each object in a query’s result set.

• AWS Step Functions – Multiple Lambda functions can be orchestrated to create long-running workflows for both human-centric and automated processes.

• Amazon CloudWatch Events – Lambda functions can be used to automatically respond to events, including third-party events.

• Amazon Aurora – Database triggers can be written as Lambda functions.

## Case Studies

---

### Serverless Websites, Web Apps, and Mobile Backends

### IoT Backends

### Data Processing

### Big Data

### IT Automation

### Additional Use Cases



