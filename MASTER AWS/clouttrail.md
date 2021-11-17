[CloudTrail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-user-guide.html)

AWS CloudTrail is an AWS service that helps you enable governance, compliance, and operational and risk auditing of your AWS account. Actions taken by a user, role, or an AWS service are recorded as events in CloudTrail. Events include actions taken in the AWS Management Console, AWS Command Line Interface, and AWS SDKs and APIs.

CloudTrail is enabled on your AWS account when you create it. When activity occurs in your AWS account, that activity is recorded in a CloudTrail event. You can easily view recent events in the CloudTrail console by going to Event history. For an ongoing record of activity and events in your AWS account,[create a trail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-create-a-trail-using-the-console-first-time.html).

Visibility into your AWS account activity is a key aspect of security and operational best practices. You can use CloudTrail to view, search, download, archive, analyze, and respond to account activity across your AWS infrastructure. You can identify who or what took which action, what resources were acted upon, when the event occurred, and other details to help you analyze and respond to activity in your AWS account.

You can integrate CloudTrail into applications using the API, automate trail creation for your organization, check the status of trails you create, and control how users view CloudTrail events.



# AWS CloudTrail Overview

* AWS CloudTrail helps to get a history of AWS API calls and related events for the AWS account.
* CloudTrail tracking includes calls made by using the AWS Management Console, AWS SDKs, command line tools, and higher-level AWS services \(such as AWS CloudFormation\)
* CloudTrail helps to identify which users and accounts called AWS for services that support CloudTrail, the source IP address the calls were made from, and when the calls occurred.
* CloudTrail is per AWS account and enabled per region for all the services supporting it
* AWS API call history produced by CloudTrail enables security analysis, resource change tracking, and compliance auditing

## CloudTrail Works

![](https://i0.wp.com/media.amazonwebservices.com/blog/2013/cloudtrail_flow_4.png?zoom=1.25&resize=550%2C761&ssl=1 "CloudTrail Architecture")

* AWS CloudTrail captures AWS API calls and related events made by or on behalf of an AWS account and delivers log files to an specified S3 bucket.
* **Log files contain API calls from all of the **[**account’s CloudTrail supported services**](http://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-supported-services.html)
* Log files from all the regions can be delivered to a single S3 bucket and are encrypted, by default, using S3 server-side encryption \(SSE\)
* CloudTrail typically delivers log files within 15 minutes of an API call and publishes new log files multiple times an hour, usually about every 5 mins.
* CloudTrail can be configured, optionally, to deliver events to a log group to be monitored by CloudWatch Logs.
* Amazon SNS notifications can be configured to be sent each time a log file is delivered to your bucket.
* **A trail, which is a configuration, needs to be created that enables logging of the AWS API activity and related events in your account.**
* Trail can be created with CloudTrail console, AWS CLI, or CloudTrail API.
* **A trail can be applied to all regions or a single region**
  * A trail that applies to all regions
    * When a trail is created that applies to all regions, CloudTrail creates the same trail in each region, records the log files in each region, and delivers the log files to the specified single S3 bucket \(and optionally to the CloudWatch Logs log group\)
    * Default setting when a trail is created using the CloudTrail console
    * A single SNS topic for notifications and CloudWatch Logs log group for events would suffice for all regions
    * Advantages
      * configuration settings for the trail apply consistently across all regions
      * manage trail configuration for all regions from one location.
      * immediately receive events from a new region
      * receive log files from all regions in a single S3 bucket and optionally in a CloudWatch Logs log group.
      * create trails in regions not used often to monitor for unusual activity
  * A trail that applies to one region
    * A S3 bucket can be specified that receives events only from that region and it can be in any region that you specify.
    * Additional individual trails created that apply to specific regions, those trails can deliver event logs to a single S3 bucket.
* ‘Turning on a trail’ means that create a trail and start logging
* CloudTrail supports five trails per region. A trail that applies to all regions counts as one trail in every region
* As a best practice, a trail can be created that applies to all regions in the AWS partition
  _for e.g. aws for all standard aws regions or aws-cn for china_
* IAM can be used to control which AWS users can create, configure, or delete trails, start and stop logging, and access the buckets that contain log information.
* Log file integrity validation can be enabled to verify that log files have remained unchanged since CloudTrail delivered them.

## Global Services Option

* For most services, events are sent to the region where the action happened.
* **For global services such as IAM, AWS STS, and Amazon CloudFront, events are delivered to any trail that has the Include global services option enabled.**
* AWS OpsWorks and Amazon Route 53 actions are logged in the US East \(N. Virginia\) region.
* To avoid receiving duplicate global service events, remember
  * Global service events are always delivered to trails that have the Apply trail to all regions option enabled.
  * Events are delivered from a single region to the bucket for the trail. This setting cannot be changed.
  * **If you have a single region trail, you should enable the Include global services option.**
  * If you have multiple single region trails, you should enable the Include global services option in only one of the trails.
* About global service events
  * have a trail with the Apply trail to all regions option enabled.
  * have multiple single region trails.
  * do not need to enable the Include global services option for the single region trails. Global service events are delivered for the first trail.

## Validating CloudTrail Log File Integrity

* Validated log files are invaluable in security and forensic investigations
* CloudTrail log file integrity validation can be used to check whether a log file was modified, deleted, or unchanged after CloudTrail delivered it
* Validation feature is built using industry standard algorithms: SHA-256 for hashing and SHA-256 with RSA for digital signing which makes it computationally infeasible to modify, delete or forge CloudTrail log files without detection
* When log file integrity validation is enabled:-
  * CloudTrail creates a hash for every log file that it delivers.
  * Every hour, CloudTrail also creates and delivers a digest file that references the log files for the last hour and contains a hash of each.
  * CloudTrail signs each digest file using the private key of a public and private key pair.
  * After delivery, the public key can be used to validate the digest file.
  * CloudTrail uses different key pairs for each AWS region.
  * Digest files are delivered to the same Amazon S3 bucket, but a separate folder, associated with the trail for the log files
  * Separation of digest files and log files enables enforcement of granular security policies and permits existing log processing solutions to continue to operate without modification.
  * Each digest file also contains the digital signature of the previous digest file if one exists.
  * Signature for the current digest file is in the metadata properties of the digest file Amazon S3 object.
  * Log files and digest files can be stored in Amazon S3 or Amazon Glacier securely, durably and inexpensively for an indefinite period of time.
  * To enhance the security of the digest files stored in Amazon S3, Amazon S3 MFA Delete can be enabled

## CloudTrail Enabled Use Cases

* Track changes to AWS resources
  * Can be used to track creation, modification or deletion of AWS resources
* Compliance Aid
  * easier to demonstrate compliance with internal policy and regulatory standards
* Troubleshooting Operational Issues
  * identify the recent changes or actions to troubleshoot any issues
* Security Analysis
  * use log files as inputs to log analysis tools to perform security analysis and to detect user behavior patterns

## CloudTrail Processing Library \(CPL\)

* CloudTrail Processing Library \(CPL\) helps build applications to take immediate action on events in CloudTrail log files
* CPL helps to
  * read messages delivered to SNS or SQS
  * downloads and reads the log files from S3 continuously
  * serializes the events into a POJO
  * allows custom logic implementation for processing
  * fault tolerant and supports multi-threading



