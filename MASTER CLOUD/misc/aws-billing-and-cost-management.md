# AWS Billing and Cost Management

* AWS Billing and Cost Management is the service that you use to pay AWS bill, monitor your usage, and budget your costs

## Analyzing Costs with Graphs

* AWS provides 
  **Cost Explorer**
  tool which allows filter graphs by API operations, Availability Zones, AWS service, custom cost allocation tags, EC2 instance type, purchase options, region, usage type, usage type groups, or, if Consolidated Billing used, by linked account.

## Budgets

* Budgets can be used to track AWS costs to see usage-to-date and current estimated charges from AWS
* Budgets use the cost visualization provided by Cost Explorer to show the status of the budgets and to provide forecasts of your estimated costs.
* Budgets can be used to create CloudWatch alarms that notify when you go over your budgeted amounts, or when the estimated costs exceed budgets
* Notifications can be sent to an SNS topic and to email addresses associated with your budget notification

## Cost Allocation Tags

* Tags can be used to organize AWS resources, and cost allocation tags to track the AWS costs on a detailed level.
* Upon cost allocation tags activation, AWS uses the cost allocation tags to organize the resource costs on the cost allocation report making it easier to categorize and track your AWS costs.
* AWS provides two types of cost allocation tags,
  * an 
    _AWS-generated tag_
    AWS defines, creates, and applies the AWS-generated tag for you,
  * and user-defined tags that you define, create,
* Both types of tags must be activated separately before they can appear in Cost Explorer or on a cost allocation report

## Alerts on Cost Limits

* CloudWatch can be used to create billing alerts when the AWS costs exceed specified thresholds
* When the usage exceeds threshold amounts, AWS sends an email notification





# AWS Consolidated Billing Overview

* Consolidated billing enables consolidating payments from multiple AWS accounts \(
  **Linked Accounts**
  \) within the organization to a single account by designating it to be the
  **Payer Account**
  .
* Consolidate billing
  * is strictly an accounting and billing feature.
  * allows receiving a combined view of charges incurred by all the associated accounts as well as each of the accounts.
  * is not a method for controlling accounts, or provisioning resources for accounts.
* Payer account is billed for all charges of the linked accounts.
* Each linked account is still an independent account in every other way
* Payer account cannot access data belonging to the linked account owners
* However, access to the Payer account users can be granted through Cross Account Access roles
* AWS limits work on the account level only and AWS support is per account only

## Consolidated Billing Process

* Owner of the paying account simply needs to send a request to the account owner from the Consolidated Billing page.
* If the linked account owner accepts the request, the linked account becomes part of the consolidated bill.
* Process cannot be initated from the linked account

## ![](/assets/aws-csbillp1.png)

## Consolidated Billing Scenarios

* Consolidated Billing can be applied to scenarios when you
  * have multiple accounts and want to get a single bill and track each account’s charges
    _for e.g. multiple projects, each with its own AWS account or separate environments \(Dev, Prod\) within the same project_
  * have multiple cost centers to track.
  * have acquired a project or company with its own existing AWS account and you want consolidated bill with your other AWS accounts.

## Consolidated Billing Benefits

* **One Bill**
  * A single bill with a combined view of AWS costs incurred by all accounts is generated
* **Easy Tracking**
  * Detailed cost report & charges for each of the individual AWS accounts associated with the “paying account” can be easily tracked
* **Combined Usage & Volume Discounts**
  * Charges might actually decrease because AWS combines usage from all the accounts to qualify you for
    **volume pricing discounts**
* **Free Tier**
  * Customers that use Consolidated Billing to consolidate payment across multiple accounts
    **will only have access to one free usage tier**
    and it is not combined across accounts

### Volume Pricing Discounts

* For billing purposes, AWS treats all the accounts on the consolidated bill as if they were one account.
* AWS combines the usage from all accounts to determine which volume pricing tiers to apply, giving you a lower overall price whenever possible.

#### Volume Discounts Example

* _**Example AWS Pricing**_
  _– AWS charges $0.17/GB for the first 10 TB of data transfer out used, and $0.13/GB for the next 40 TB used that translates into $174.08 per TB for the first 10 TB, and $133.12 per TB for the next 40 TB_
* _**Usage**_
  _– Bob uses 8 TB of data transfer out during the month, and Susan uses 4 TB \(for a total of 12 TB used\)._
* _**Actual Individual Bill**_
  _– AWS would have charged Bob and Susan each $174.08 per TB for their usage, for a total of $2088.96_
* _**Volume Discount Bill**_
  _– Combined 12 TB total that Bob and Susan used, would cost the paying account \($174.08 \* 10 TB\) + \($133.12 \* 2 TB\) = $1740.80 + $266.24 =$2007.04_

#### EC2 Reserved Instances

* All Linked accounts on a consolidated bill can receive the hourly cost benefit of EC2 Reserved Instances purchased by any other account
* Linked accounts receive the cost benefit from other’s Reserved Instances only if instances are launched in the same Availability Zone where the Reserved Instances were purchased
* Capacity reservation only applies to the product platform, instance type, and Availability Zone specified in the purchase
* _For e.g., Bob and Susan each have an account on Bob’s consolidated bill. Susan has 5 Reserved Instances of the same type, and Bob has none. During one particular hour, Susan uses 3 instances and Bob uses 6, for a total of 9 instances used on Bob’s consolidated bill. AWS will bill 5 as Reserved Instances, and the remaining 4 as normal instances._

## Consolidated Billing Best Practices

* Paying account should be used solely for accounting and billing purposes
* Consolidated billing works best with Resource tagging, as tags are included in the detailed billing report, which enables cost to be analyzed and decomposed across multiple dimensions and aggregation levels.
* Paying account owners should secure their accounts by using MFA \(multi-factor authentication\) and a strong password



