# Auto Scaling & ELB

* Auto Scaling dynamically adds and removes EC2 instances, while Elastic Load Balancing manages incoming requests by optimally routing traffic so that no one instance is overwhelmed
* Auto Scaling helps to automatically increase the number of EC2 instances when the user demand goes up, and decrease the number of EC2 instances when demand goes down
* ELB service helps to distribute the incoming web traffic \(called the load\) automatically among all the running EC2 instances
* ELB uses load balancers to monitor traffic and handle requests that come through the Internet.
* Using ELB & Auto Scaling
  * makes it easy to route traffic across a dynamically changing fleet of EC2 instances
  * load balancer acts as a single point of contact for all incoming traffic to the instances in an Auto Scaling group.

### ![](https://i2.wp.com/jayendrapatil.com/wp-content/uploads/2016/06/Screen-Shot-2016-06-07-at-4.13.10-PM.png?resize=656%2C561 "AWS Auto Scaling &amp; ELB")

## Attaching/Detaching ELB with Auto Scaling Group

* Auto Scaling integrates with Elastic Load Balancing and enables to attach one or more load balancers to an existing Auto Scaling group.
* ELB registers the EC2 instance using its IP address and routes requests to the primary IP address of the primary interface \(eth0\) of the instance.
* After the ELB is attached, it automatically registers the instances in the group and distributes incoming traffic across the instances
* When ELB is detached, it enters the Removing state while deregistering the instances in the group.
* If connection draining is enabled, ELB waits for in-flight requests to complete before deregistering the instances.
* Instances remain running after they are deregistered from the ELB
* Auto Scaling adds instances to the ELB as they are launched, but this can be suspended. Instances launched during the suspension period are not added to load balancer, after resumption, and must be registered manually.

## High Availability & Redundancy

* Auto Scaling can span across multiple AZs, within the same region
* When one AZ becomes unhealthy or unavailable, Auto Scaling launches new instances in an unaffected AZ
* When the unhealthy AZs recovers, Auto Scaling redistributes the traffic across all the healthy AZs
* Elastic Load balancer can be setup to distribute incoming requests across EC2 instances in a single AZ or multiple AZs within a region
* It is recommended to take advantage of the safety and reliability of geographic redundancy by using Auto Scaling & ELB by
  **spanning Auto Scaling groups across multiple AZs within a region and then setting up ELB to distribute incoming traffic across those AZs.**
* Incoming traffic is load balanced equally across all the AZs enabled for ELB

## Health Checks

* Auto Scaling group determines the health state of each instance by periodically checking the results of EC2 instance status checks
* Auto Scaling marks the instance as unhealthy and replaces the instance, if the instance fails the EC2 instance status check
* ELB also performs health checks on the EC2 instances that are registered with the it
  _for e.g. application is available by pinging and health check page_
* Auto Scaling, by default, does not replace the instance, if the ELB health check fails
* **ELB health check with the instances should be used to ensure that traffic is routed only to the healthy instances**
* After a load balancer is registered with an Auto Scaling group, it can be configured to use the results of the ELB health check in addition to the EC2 instance status checks to determine the health of the EC2 instances in the Auto Scaling group.

## Monitoring

* Elastic Load Balancing sends data about the load balancers and EC2 instances to Amazon CloudWatch. CloudWatch collects data about the performance of your resources and presents it as metrics.
* After registering one or more load balancers with the Auto Scaling group, Auto Scaling group can be configured to use ELB metrics \(such as request latency or request count\) to scale the application automatically



