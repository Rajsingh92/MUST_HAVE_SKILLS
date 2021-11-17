# AWS EC2 Instance Purchasing Option

* Amazon provides different ways to pay for the EC2 instances
  * On-Demand Instances
  * Reserved Instances
  * Spot Instances
* Light, Medium, and Heavy Utilization Reserved Instances are no longer available for purchase and were part of the Previous Generation AWS EC2 purchasing model
* AWS also allows you to launch EC2 instance on shared or dedicated tenancy

## EC2 Dedicated Instances

* Dedicated Instances are EC2 instances that run in a VPC on hardware that’s dedicated to a single customer
* Dedicated Instances are physically isolated at the host hardware level from the instances that aren’t Dedicated Instances and from instances that belong to other AWS accounts.
* Each VPC has a related instance tenancy attribute, and can’t be changed after the VPC has been created. Default is shared
* Each instance launched into a VPC has a tenancy attribute, can’t be changed after the instance is launched. Default tenancy depends on the VPC tenancy.
* Dedicated Instances can be launched using
  * Create the VPC with the instance tenancy set to dedicated, all instances launched into this VPC are Dedicated Instances even though if you mark the tenancy as shared
  * Create the VPC with the instance tenancy set to default, and specify dedicated tenancy for any instances that should be Dedicated Instances when you launch them.

## On-Demand Instances

* Pay for the instances and the compute capacity that you use by the hour, with no long-term commitments or up-front payments
* Instances can be scaled accordingly as per the demand
* Although AWS makes effort to have the capacity to launch On-Demand instances, there might be instances during peak demand where the instance cannot be launched
* Well suited for
  * Users that want the low cost and flexibility of Amazon EC2 without any up-front payment or long-term commitment
  * Applications with short term, spiky, or unpredictable workloads that cannot be interrupted
  * Applications being developed or tested on Amazon EC2 for the first time

## Reserved Instances

* Reserved Instances provides lower hourly running costs by providing a billing discount as well as capacity reservation that is applied to instances and there would never be a case of insufficient capacity from AWS
* Discounted usage price is fixed for as long as you own the Reserved Instance, allowing compute costs prediction over the term of the reservation.
* Reserved instances are best suited if 
  **consistent, heavy, use is expected**
  and they can provide savings over owning your own hardware or running only On-Demand instances.
* Well Suited for
  * Applications with steady state or predictable usage
  * Applications that require reserved capacity
  * Users able to make upfront payments to reduce their total computing costs even further
* Reserved instance is not a physical instance that is launched, but its just an accounting term applied to the instance usage during billing
* Reserved Instances do not renew automatically, and the EC2 instances can be continued to be used but charged On-Demand rates
* Auto Scaling or other AWS services can be used to launch the On-Demand instances that use the Reserved Instance benefits
* With Reserved Instances
  * **You pay for the entire term, regardless of the usage**
  * Once purchased, the reservation cannot be cancelled but can be sold in the Reserved Instance Marketplace
  * Reserved Instance pricing tier discounts only apply to purchases made from AWS, and not to the third party Reserved instances

### How Reserved Instances work

#### Billing Benefits & Payment Options

* Reserved Instance purchase reservation is automatically applied to running instances that match the specified parameters
* Reserved Instance can also be utilized by launching On-Demand instances with the same configuration as to the purchased reserved capacity

#### Payment Options

* **No Upfront**
  * No upfront payment is required and the account is charged on a discounted hourly rate for every hour, regardless of the usage
  * Only available as 1-year reservation
* **Partial Upfront**
  * A portion of the cost is paid upfront and the remaining hours in the term are charged at an hourly discounted rate, regardless of the usage
* **Full Upfront**
  * Full payment is made at the start of the term, with no costs for the remainder of the term, regardless of the usage

#### Understanding Hourly Billing

* Reserved Instances are billed for every hour during the term that you select, regardless of whether the instance is running or not.
* _Reservations and discounted rates only apply to one instance-hour per hour. If an instance restarts during the first hour of a reservation and runs for two hours before stopping, the first instance-hour is charged at the discounted rate but three instance-hours are charged at the On-Demand rate. If the instance restarts during one hour and again the next hour before running the remainder of the reservation, one instance-hour is charged at the On-Demand rate but the discounted rate is applied to previous and subsequent instance-hours._

#### Consolidated Billing

* Pricing benefits of Reserved Instances are shared when the purchasing account is part of a set of accounts billed under one consolidated billing payer account
* Consolidated billing account aggregates the list value of member accounts within a region.
* When the list value of all active Reserved Instances for the consolidated billing account reaches a discount pricing tier,
  **any Reserved Instances purchased after this point by any member**
  of the consolidated billing account are charged at the discounted rate \(as long as the list value for that consolidated account stays above the discount pricing tier threshold\)

#### Buying Reserved Instances

Buying Reserved Instances need selection of the following

* **Platform**
  \(for example, Linux\)
* **Instance type**
  \(for example,m1.small\)
* **Availability Zone**
  in which to run the instance
* **Term**
  \(time period\) over which you want to reserve capacity
* **Tenancy**
  You can reserve capacity for your instance to run in single-tenant hardware \(dedicated tenancy, as opposed to shared\).
* **Offering**
  \(No Upfront, Partial Upfront, All Upfront\).

#### Modifying Reserved Instances

* Reserved Instances can be modified and continue to benefit from your capacity reservation, when the computing needs change.
* Modification does not change the remaining term of your Reserved Instances; their end dates remain the same.
* There is no fee, and you do not receive any new bills or invoices.
* Modification is separate from purchasing and does not affect how you use, purchase, or sell Reserved Instances.
* Complete reservation or a subset of it can be modified in one or more of the following ways:
  * Switch Availability Zones within the same region
  * Change between EC2-VPC and EC2-Classic
  * Change the instance size within the same instance type, given the instance size footprint remains the same
    _for e.g. four m1.medium instances \(4 x 2\), you can turn it into a reservation for eight m1.small_
    _instances \(8 x 1\) and vice versa. However, you cannot convert a reservation for a single m1.small instance \(1 x 1\) into a reservation for an m1.large instance \(1 x 4\)._

![](https://i1.wp.com/jayendrapatil.com/wp-content/uploads/2016/04/screen-shot-2016-04-26-at-7-07-24-am.png?resize=656%2C328 "Screen Shot 2016-04-26 at 7.07.24 AM.png")

### Scheduled Reserved Instances

* Scheduled Reserved Instances \(Scheduled Instances\) enable you to purchase capacity reservations that recur on a daily, weekly, or monthly basis, with a specified start time and duration, for a one-year term.
* Capacity is reserved in advance and is always available when needed
* Charges are incurred for the time that the instances are scheduled, even if they are not used
* Scheduled Instances are a good choice for workloads that
  **do not run continuously, but do run on a regular schedule**
  _for e.g. weekly or monthly batch jobs_
* EC2 launches the instances, based on the launch specification and then terminates them 3 minutes before the time period ends, so the capacity is available for use for the next scheduled instances it is reserved for
* Scheduled Reserved instances cannot be stopped of rebooted, however they can be terminated and relaunched within minutes of termination
* Scheduled Reserved instances limits or restrictions
  * after purchase cannot be modified, canceled or resold
  * only supported instance types: C3, C4, M4, and R3
  * required term is 365 days \(one year\).
  * minimum required utilization is 1,200 hours per year
  * purchase up to three months in advance

## Spot Instances

* Spot instances enables bidding on unused EC2 instances, and are launched whenever the bid price exceeds the current market spot price
* EC2 sets up the hourly price which fluctuates depending upon the demand and supply of spot instances
* Spot instances are a cost-effective choice and can bring the EC2 costs down significantly
* Spot instances can be used for
  **applications flexible in the timing when they can run and also able to handle interruption**
  by storing the state externally 
  _for e.g. they are well-suited for data analysis, batch jobs, background processing, and optional tasks_
* Well Suited for
  * Applications that have flexible start and end times
  * Applications that are only feasible at very low compute prices
  * Users with urgent computing needs for large amounts of additional capacity
* Spot instances differ from the On-Demand instances
  * they are not launched immediately
  * they can be terminated anytime
  * prices vary as per the demand and supply of spot instances
* Usual strategy involves using Spot instances with On-Demand or Reserved instances, which provide a minimum level of guaranteed compute resources, while spot instances provide an additional computation boost
* Spot instances can also be launched with a required duration \(also known as Spot blocks\), which are not interrupted due to changes in the Spot price
* EC2 provides a data feed, sent to an S3 bucket specified during subscription, that describes the Spot instance usage and pricing
* T2 and HS1 instance class types are not supported for Spot instances

### Spot Concepts

* **Spot pool**
  – Pool of EC2 instances with the same instance type, availability zone, operating system and network platform
* **Spot price**
  – Current market price of a spot instance per hour as set by Amazon EC2 based on the last fulfilled bid
* **Spot bid**
  – is the maximum bid price the bidder is willing to pay for the spot instance
* **Spot fleet**
  – is the set of instances launched based on the criteria the bidder
* **Spot instance **
  **interruption**
   – EC2 terminates the spot instances whenever the bid price is lower than the current market price or the supply has reduced
* **Bid status**
  – provides the current state of the spot bid

### Spot Pricing & How it works

* EC2 sets up an hourly spot price which fluctuates depending upon the demand and supply.
* If the bid price exceeds the current market spot price, the request is fulfilled by Amazon till either the spot instance is terminated or the spot price increases beyond the bid price
* Everyone pays the same market price for the period irrespective of the bid price given the bid price is more than the spot price
  _for e.g. if the spot price is $0.20 and there are 2 bids from Customers with bid price $0.25 and $0.30, both customers would still pay $0.20 only_
* If the Spot instance is terminated by Amazon, you are not billed for the partial hour. However, if the spot instance are terminated by you, you will be charged for the partial hour
* Spot instances with a predefined duration use a fixed hourly price that remains in effect for the Spot instance while it runs
* EC2 can interrupt the Spot instance when the Spot price rises above your bid price, when the demand for Spot instances rises, or when the supply of Spot instances decreases.
* When EC2 marks a Spot instance for termination, it provides a Spot instance termination notice, which gives the instance a
  **two-minute warning**
  before it terminates.
* Termination notice warning is made available to the applications on the Spot instance using an item in the instance metadata termination-time attribute http://169.254.169.254/latest/meta-data/spot/termination-time and includes the time when the shutdown signal will be sent to the instance’s operating system
* Relevant applications on Spot Instances should poll for the termination notice at 5 second intervals, giving it almost the entire two minutes to complete any needed processing before the instance is terminated and taken back by AWS
* EBS-backed instance if it is a Spot instance cannot be stopped and started, but only rebooted or terminated

### **Pricing Example**

![](https://i2.wp.com/jayendrapatil.com/wp-content/uploads/2016/04/screen-shot-2016-04-27-at-11-12-04-am.png?resize=656%2C93 "Screen Shot 2016-04-27 at 11.12.04 AM.png")

* **State 1**
  – Starting with Amazon EC2 has 5 Spot instances available
  * 6 bids available for Spot instances
  * Amazon EC2 picks up the top five priced bids and allocates a Spot instance to them
  * Spot Price is $0.10
  * Bid with the price of $0.05 is not served
* **State 2**
  – Supply of Amazon EC2 Spot instances reduce to 3
  * Amazon EC2 terminates the 2 spot instances with $0.10 \( the order in which the instances are terminated is determined at random \)
  * Rest of the Spot instances continue
* **State 3**
  – New bid for Spot Instance is placed with Price $0.15 is placed
  * Spot instance with price $0.15 is fulfilled
  * Amazon EC2 terminates the single spot instances with $0.10
  * Spot Price changed to $0.15
* **State 4**
  New bid for Spot Instance is placed with Price $2 is placed
  * Spot instance with price $2 is fulfilled
  * Amazon EC2 terminates the single spot instances with $0.15
  * Spot Price changed to $1.00

### Spot Instances best practices

* Choose a reasonable bid price, which is low enough to suit your budget and high enough for the request to be fulfilled and should not be higher than the On-Demand bid price
* Ensure the instances are up and ready as soon as the request is fulfilled, by provisioning an AMI with all the required softwares and load application data from user data
* Store important data regularly and externally in a place that won’t be affected by Spot instance termination 
  _for e.g., use S3, EBS, or DynamoDB_
* Divide the work into smaller finer tasks so that they can be completely and state saved more frequently
* Use Spot termination notice warning to monitor instance status regularly
* Test applications using On-Demand instances and terminating them to ensure that it handles unexpected termination gracefully



