# AWS Well-Architected Framework

## Introduction

---

The AWS Well-Architected Framework helps you understand the pros and cons of decisions you make while building systems on AWS

### Definitions![](/assets/fiverpillars.png)

### On Architecture

### General Design Principles

Stop guessing your capacity needs

Test systems at production scale

Automate to make architectural experimentation easier

Allow for evolutionary architectures

Drive architectures using data

Improve through game days

## The Five Pillars of the Well-Architected Framework

---

### Operational Excellence

#### Design Principles

Perform operations as code

Annotate documentation

Make frequent, small, reversible changes

Refine operations procedures frequently

Anticipate failure:

Learn from all operational failures

#### Best Practices

**Prepare:** AWS Config and AWS Config rules can be used to create standards for

workloads and to determine if environments are compliant with those standards

before being put into production.

**Operate ** Amazon CloudWatch allows you to monitor the operational health of a

workload.

**Evolve  **Amazon Elasticsearch Service \(Amazon ES\) allows you to analyze your log

data to gain actionable insights quickly and securely.

---

### Security

#### Design Principles

Implement a strong identity foundation

Enable traceability

Apply security at all layers:

Automate security best practices

Protect data in transit and at rest

Keep people away from data

Prepare for security events

#### Best Practices

1. Identity and Access Management

2. Detective Controls

3. Infrastructure Protection

4. Data Protection

5. Incident Response

---

### Reliability

#### Design Principles

Test recovery procedures

Automatically recover from failure:

Scale horizontally to increase aggregate system availability

Stop guessing capacity

Manage change in automation

#### Best Practices

1. Foundations

2. Change Management

3. Failure Management

---

### Performance Efficiency

#### Design Principles

Democratize advanced technologies

Go global in minutes

Use serverless architectures

Experiment more often:

Mechanical sympathy

#### Best Practices

1. Selection

2. Review

3. Monitoring

4. Tradeoffs

---

### Cost Optimization

#### Design Principles

Adopt a consumption model

Measure overall efficiency

Stop spending money on data center operations

Analyze and attribute expenditure

Use managed and application level services to reduce cost of ownership

#### Best Practices

1. Cost-Effective Resources

2. Matching supply and demand

3. Expenditure Awareness

4. Optimizing Over Time

---

## Best Practices

---

### Operational Excellence

---

**OPS 1 What factors drive your operational priorities?**

> _Operational priorities are the focus areas of your operations efforts. Clearly define and agree to    
> _
>
> _your operations priorities to maximize the benefits of your operations efforts._

Evaluate business needs

Evaluate compliance requirements

Evaluate risk

**OPS 2 How do you design your workload to enable operability?**

> _The majority of the lifetime of a workload is typically spent in an operating state. Consider    
> _
>
> _operations needs as a part of system design to help you enable long term sustainment of your    
> _
>
> _workload._

Share design standards

Design for cloud operations e.g. elasticity, on-demand scalability, pay-as-you-go pricing, automation

Provide insights into workload behavior

Provide insights into customer behavior:

Implement practices that reduce defects, ease remediation, and improve flow:

Mitigate deployment risks

**OPS 3 How do you know that you are ready to support a workload?**

> _Evaluate the operational readiness of your workload, processes and procedures, and personnel    
> _
>
> _to help you understand the operational risks related to your workload._

Continuous improvement culture

Share understanding of the value to the business:

Ensure personnel capability

Documented accessible governance and guidance

Use checklists

Use runbooks

Use playbooks

Practice recovery

**OPS 4 What factors drive your understanding of operational health?**

> _Define metrics for the evaluation of your workload and processes to help you understand    
> _
>
> _operations effectiveness in supporting business outcomes. Capture and analyze metrics to gain    
> _
>
> _visibility to processes and events so that you can take appropriate action._

Define expected business and customer outcomes

Identify success metrics

Identify workload metrics

Identify operations metrics

Established baselines

Collect and analyze metrics

Validate insights

Business-level view of operations

**OPS 5 How do you manage operational events?    
**

> _Prepare and validate procedures to respond to operational events to help you minimize their_
>
> _potential disruption to your workload._

Determine priority of operational events based on business impact

Processes for event, incident, and problem management

Process per alert

Identify decision makers

Defined escalation paths

Push notifications

Communicate status through dashboards

Process for root cause analysis

**OPS 6 How do you evolve operations?  
**

> Dedicate time and resources for continuous incremental improvement to help evolve the
>
> effectiveness and efficiency of your operations.

Process for continuous improvement

Define drivers for improvement

Implement Feedback loops

Document and share lessons learned

Perform operations metrics reviews

### Security

---

**SEC 1 How do you manage credentials for your workload?  
**

> _Credentials include passwords, tokens, and keys that grant access directly or indirectly to  
> _
>
> _manage your workload. Protect credentials with appropriate mechanisms to help you reduce  
> _
>
> _the risk of accidental or malicious use._

Enforce use of multi-factor authentication

Enforce password requirements

Rotate credentials regularly

Audit credentials periodically

Using centralized identity provider

**SEC 2 How do you control human access to services?  
**

> _Control human access to services with appropriately defined, limited, and segregated access to  
> _
>
> _help you reduce the risk of unauthorized access._

---

Credentials are not shared

User life-cycle managed

Minimum privileges

Access requirements clearly defined

Access is granted through roles or federation

**SEC 3 How do you control programmatic access to services?  
**

> _Control programmatic or automated access to services with appropriately limited short-term  
> _
>
> _credentials and roles to help you reduce the risk of unauthorized access._

Credentials are not shared

Dynamic authentication

Minimum privileges

Access requirements clearly defined

**SEC 4 How are you aware of security events in your workload?  
**

> _Capture and analyze logs and metrics to gain visibility to security threats and events so that  
> _
>
> _you can take appropriate action._

Logging enabled where available

Analyzing AWS CloudTrail

Analyzing logs centrally

Monitoring and alerting for key metrics and events

AWS marketplace or APN partner solution enabled:

**SEC 5 How do you protect your networks?  
**

> _Public and private networks and services require multiple layers of defense to help protect your  
> _
>
> _workloads from network-based threats._

Controlling traffic in Virtual Private Cloud \(VPC\)

Controlling traffic at the boundary

Controlling traffic using available features:

AWS marketplace or APN partner solution enabled

**SEC 6 How do you stay up to date with AWS security features and industry security  
 threats?  
**

> _Staying up to date and implementing AWS and industry best practices including services and  
> _
>
> _features can improve the security of your workload. Being aware of the latest security threats  
> _
>
> _will help you build a threat model to identify and implement protective controls_.

Evaluating new security services and features

Using security services and features

**SEC 7 How do you protect your compute resources?  
**

> _Configure compute resources with manageable components to protect and monitor their  
> _
>
> _integrity so that you can take appropriate action._

Hardening default configurations

Checking file integrity

Intrusion detection enabled

AWS marketplace or APN partner solution enabled

Configuration management tool

Patching and scanning for vulnerabilities

**SEC 8 How do you classify your data?  
**

> _Classification provides a way to categorize data, based on levels of sensitivity, to help you  
> _
>
> _determine appropriate protective controls._

Use a data classification schema

Data classification applied

**SEC 9 How do you manage data protection mechanisms?**

> _Data protection mechanisms include services and keys that protect data in transit and at rest.  
> _
>
> _Protect these services and keys to help you reduce the risk of unauthorized access to systems  
> _
>
> _and data._

Use a secure key management service

Use service level controls

Use client side key management

AWS Marketplace or APN Partner solution

**SEC 10 How do you prepare to respond to an incident?**

> _Prepare to investigate and respond to security incidents to help you minimize potential  
> _
>
> _disruptions to your workload._

Pre-provisioned access

Pre-deployed tools

Run game days

### Reliability

---

**REL 1 How are you managing AWS service limits for your accounts?  
**

> _AWS accounts are provisioned with default service limits to prevent new users from  
> _
>
> _accidentally provisioning more resources than they need. There also limits on how often you  
> _
>
> _can call APIs to protect AWS infrastructure. Evaluate your AWS service needs and request  
> _
>
> _appropriate changes to your limits for each region._

Active monitoring and managing limits

Implemented automated monitoring and management of limits

Aware of fixed service limits

Ensure there is a sufficient gap between the current service limit and the max usage  
 to accommodate for fail over

Service limits are managed across all relevant accounts and regions

**REL 2 How do you plan your network topology on AWS?  
**

> _Applications can exist in one or more environments: EC2-Classic, the default VPC, or VPC\(s\)  
> _
>
> _created by you. Network considerations such as system connectivity, Elastic IP address and  
> _
>
> _public IP address management, VPC and private address management, and name resolution  
> _
>
> _are fundamental to using resources in the cloud. Well planned and documented deployments  
> _
>
> _are essential to reduce the risk of overlap and contention._

Connectivity back to data center is not needed:

Highly available connectivity between AWS and on-premises environment is  
 implemented

Highly available network connectivity for the users of the workload is implemented

Using non-overlapping private IP address ranges in multiple VPCs

IP subnet allocation accounts for expansion and availability

**REL 3 How does your system adapt to changes in demand?  
**

> _A scalable system provides elasticity to add and remove resources automatically so that they  
> _
>
> _closely match the current demand at any given point in time._

Workload scales automatically

Workload is load tested

**REL 4 How do you monitor AWS resources?  
**

> _Logs and metrics are a powerful tool for gaining insight into the health of your workloads. You  
> _
>
> _can configure your system to monitor logs and metrics and send notifications when thresholds  
> _
>
> _are crossed or significant events occur. Ideally, when low-performance thresholds are crossed or  
> _
>
> _failures occur, the system has been architected to automatically self-heal or scale in response._

Monitoring the workload in all tiers

Notifications are sent based on the monitoring

Automated responses are performed for events

Reviews are conducted regularly

**REL 6 How do you back up data?  
**

> _Back up data, applications, and operating environments \(defined as operating systems  
> _
>
> _configured with applications\) to meet requirements for mean time to recovery \(MTTR\) and  
> _
>
> _recovery point objectives \(RPO\)._

Data is backed up manually

Data is backed up using automated processes

Periodic recovery of the data is done to verify backup integrity and processes

Backups are secured and encrypted

**REL 7 How does your system withstand component failures?  
**

> _If your workloads have a requirement, implicit or explicit, for high availability and low mean  
> _
>
> _time to recovery \(MTTR\), architect your workloads for resiliency and distribute your workloads  
> _
>
> _to withstand outages._

Monitoring is done at all layers of the workload to detect failures

Deployed to multiple Availability Zones; Multiple AWS Regions if required

Has loosely coupled dependencies

Has implemented graceful degradation

Automated healing implemented on all layers

Notifications are sent upon availability impacting events

**REL 8 How do you test resilience?  
**

> _Test the resilience of your workload to help you find latent bugs that only surface in  
> _
>
> _production. Exercise these tests regularly._

Use a playbook

Inject failures to test

Schedule game days

Conduct root cause analysis \(RCA\)

**REL 9 How do you plan for disaster recovery?  
**

> _Data recovery \(DR\) is critical should restoration of data be required from backup methods. Your  
> _
>
> _definition of and execution on the objectives, resources, locations, and functions of this data  
> _
>
> _must align with RTO and RPO objectives._

Recovery objectives are defined

Recovery strategy is defined

Configuration drift is managed

Test and validate disaster recovery implementation

Recovery is automated

### Performance Efficiency

---

**PERF 1 How do you select the best performing architecture?**

> _Often, multiple approaches are required to get optimal performance across a workload._
>
> _Well-architected systems use multiple solutions and enable different features to improve_
>
> _performance._

Benchmarking:

load test



**PERF 2 How do you select your compute solution?**

> _The optimal compute solution for a particular system varies based on application design, usage_
>
> _patterns, and configuration settings. Architectures may use different compute solutions for_
>
> _various components and enable different features to improve performance. Selecting the wrong_
>
> _compute solution for an architecture can lead to lower performance efficiency._

Consider options

Consider instance configuration options

Consider container configuration options

Consider function configuration options

Use elasticity



**PERF 3 How do you select your storage solution?**

> _The optimal storage solution for a system varies based on the kind of access method \(block,_
>
> _file, or object\), patterns of access \(random or sequential\), throughput required, frequency of_
>
> _access \(online, offline, archival\), frequency of update \(WORM, dynamic\), and availability and_
>
> _durability constraints. Well-architected systems use multiple storage solutions and enable_
>
> _different features to improve performance._

Consider characteristics

Consider configuration options

Consider access patterns



**PERF 4 How do you select your database solution?**

> _The optimal database solution for a system varies based on requirements for availability,_
>
> _consistency, partition tolerance, latency, durability, scalability, and query capability. Many_
>
> _systems use different database solutions for various sub-systems and enable different features_
>
> _to improve performance. Selecting the wrong database solution and features for a system can_
>
> _lead to lower performance efficiency._

Consider characteristics

Consider configuration options

Consider access patterns

Consider other approaches



**PERF 5 How do you configure your networking solution?**

> T_he optimal network solution for a system varies based on latency, throughput requirements,_
>
> _and so on. Physical constraints such as user or on-premises resources drive location options,_
>
> _which can be offset using edge techniques or resource placement._

Consider location

Consider service features

Consider networking features



### Cost Optimization

---

**COST 1 How do you evaluate cost when you select AWS services?**

> _Amazon EC2, Amazon EBS, and Amazon S3 are building-block AWS services. Managed services,_
>
> _such as Amazon RDS and Amazon DynamoDB, are higher level, or application level, AWS_
>
> _services. By selecting the appropriate building blocks and managed services, you can optimize_
>
> _your architecture for cost. For example, using managed services, you can reduce or remove_
>
> _much of your administrative and operational overhead, freeing you to work on applications and_
>
> _business-related activities._

Select services for cost reduction

Optimize for license costs

Optimize using serverless and container-based approach

Optimize using appropriate storage solutions

Optimize using appropriate databases

Optimize using other application-level services



**COST 4 How do you plan for data transfer charges?**

> E_nsure that you monitor data transfer charges so that you can make architectural decisions_
>
> _that might alleviate some of these costs. For example, if you are a content provider and_
>
> _have been serving content directly from an S3 bucket to your end users, you might be able to_
>
> _significantly reduce your costs if you push your content to the Amazon CloudFront content_
>
> _delivery network \(CDN\). Remember that a small yet effective architectural change can_
>
> _drastically reduce your operational costs._

Optimize:

Use a content delivery network \(CDN

Use AWS Direct Connect



