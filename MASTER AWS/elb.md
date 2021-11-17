Pre-Warming

* Connection Draining
* Client-Side SSL certificates
* Server Order Preference
* Cross-Zone
* SSL termination
* ELB HTTPS listener does not support Client-Side SSL certificates
* autoscaling

  * Scheduled scaling can not be overlap
  * choose greatest impact when Multiple Policies
  * cooldown period
  * Termination Policy



# AWS Elastic Load Balancer – ELB

* Elastic Load Balancing allows the incoming traffic to be distributed automatically across multiple healthy EC2 instances.
* ELB serves as a single point of contact to the client
* ELB helps to being transparent and increases the application availability by allowing addition or removal of multiple EC2 instances across one or more availability zones, without disrupting the overall flow of information.
* ELB benefits
  * **is itself a distributed system that is fault tolerant and actively monitored**
  * abstracts out the complexity of managing, maintaining, and scaling load balancers
  * can also serve as the first line of defense against attacks on network.
  * can offload the work of encryption and decryption \(SSL termination\) so that the EC2 instances can focus on their main work
  * offers integration with Auto Scaling, which ensures enough back-end capacity available to meet varying traffic levels
  * are engineered to not be a single point of failure
* Elastic Load Balancer, by default, routes each request independently to the registered instance with the smallest load.
* If an EC2 instance fails, ELB automatically reroutes the traffic to the remaining running healthy EC2 instances. If a failed EC2 instance is restored, Elastic Load Balancing restores the traffic to that instance.
* **Load Balancers only work across AZs within a region**

## ![](https://i2.wp.com/jayendrapatil.com/wp-content/uploads/2016/04/screen-shot-2016-04-05-at-7-54-34-am.png?resize=656%2C504 "Elastic Load Balancer basic architecture")

## ELB Application Load Balancer

Refer to Blog Post @[Application Load Balancer](http://jayendrapatil.com/aws-elb-application-load-balancer/)

## ELB Network Load Balancer

Refer to Blog Post @[Network Load Balancer](http://jayendrapatil.com/aws-elb-network-load-balancer/)

## ELB Key Points

### Scaling ELB

* Each ELB is allocated and configured with a default capacity
* ELB Controller is the service which stores all the configuration and also monitors the load balancer and manages the capacity that is used to handle the client requests
* As the traffic profile changes, the controller service scales the load balancers to handle more requests, scaling equally in all AZs.
* ELB increases its capacity by utilizing either larger resources \(scale up – resources with higher performance characteristics\) or more individual resources \(scale out\).
* **AWS itself handles the scaling of the ELB capacity and this scaling is different to scaling of the EC2 instances to which the ELB routes its request to, which is handled by Auto Scaling**
* Time required for Elastic Load Balancing to scale can range from 1 to 7 minutes, depending on the changes in the traffic profile

### Pre-Warming ELB

* ELB works best with gradual increase in traffic
* AWS is able to scale automatically and handle a vast majority of use cases
* However, in certain scenarios, if there is a flash traffic spike expected or a load test cannot be configured to gradually increase traffic, recommended to contact AWS support to have the load balancer “**pre-warmed”**
* AWS will help Pre-warming the ELB, by configuring the load balancer to have the appropriate level of capacity based on expected traffic
* AWS would need the information for the start, end dates and the expected request rate per second with the total size of request/response.

### DNS Resolution

* ELB is scaled automatically depending on the traffic profile
* When scaled, Elastic Load Balancing service will update the Domain Name System \(DNS\) record of the load balancer so that the new resources have their respective IP addresses registered in DNS.
* DNS record created includes a Time-to-Live \(TTL\) setting of 60 seconds
* By default, ELB will return multiple IP addresses when clients perform a DNS resolution, with the records being randomly ordered on each DNS resolution request.
* It is recommended that clients will re-lookup the DNS at least every 60 seconds to take advantage of the increased capacity

### Load Balancer Types

* **Internet Load Balancer**
  * An Internet-facing load balancer takes requests from clients over the Internet and distributes them across the EC2 instances that are registered with the load balancer
* **Internal Load Balancer – **
  * Internal load balancer routes traffic to EC2 instances in private subnets

### Availability Zones/Subnets

* Elastic Load Balancing allows subnets to be added and creates a load balancer node in each of the Availability Zone where the subnet resides.
* Elastic Load Balancer should have atleast one subnet attached
* Only one subnet per AZ can be attached to the ELB. Attaching a subnet with an AZ already attached replaces the existing subnet
* Each Subnet must have a CIDR block with at least a /27 bitmask and has at least 8 free IP addresses, which ELB uses to establish connections with the back-end instances.
* For High Availability, it is recommended to attach one subnet per AZ for at least two AZs, even if the instances are in a single subnet.
* Subnets can be attached or detached from the ELB and it would start or stop sending requests to the instances in the subnet accordingly

### Security Groups & NACL

* Security groups & NACLs should allow Inbound traffic, on the load balancer listener port, from the Client for an Internet ELB or VPC CIDR for an Internal ELB
* Security groups & NACLs should allow Outbound traffic to the back-end instances on both the instance listener port and the health check port
* NACLs, in addition, should allow responses on the ephemeral ports
* All EC2 instances should allow incoming traffic from ELB

### SSL Negotiation Configuration

* For HTTPS load balancer, Elastic Load Balancing uses an Secure Socket Layer \(SSL\) negotiation configuration, known as a security policy, to negotiate SSL connections between a client and the load balancer.
* A security policy is a combination of SSL protocols, SSL ciphers, and the Server Order Preference option
  * Elastic Load Balancing supports the following versions of the SSL protocol TLS 1.2, TLS 1.1,  TLS 1.0, SSL 3.0, 
    SSL 2.0 \(deprecated now\)
  * SSL protocols use several SSL ciphers to encrypt data over the Internet.
  * Elastic Load Balancing supports the
    **Server Order Preference**
    option for negotiating connections between a client and a load balancer.
  * During the SSL connection negotiation process, this allows the load balancer to control and select the first cipher in its list that is in the client’s list of ciphers instead of the default behavior of checking matching first cipher in client’s list with server’s list.
* Elastic Load Balancer allows using a Predefined Security Policies or creating a Custom Security Policy for specific needs. If none is specified, ELB selects the latest Predefined Security Policy.

### Health Checks

* Load balancer performs health checks on all registered instances, whether the instance is in a healthy state or an unhealthy state.
* Load balancer performs health checks to discover the availability of the EC2 instances, the load balancer periodically sends pings, attempts connections, or sends request to health check the EC2 instances.
* Health check is **InService **for status of healthy instances and **OutOfService **for unhealthy ones
* Load balancer sends a request to each registered instance at the _Ping Protocol,  Ping Port_ and _Ping Path _ every  _HealthChec Interval _seconds. It waits for the instance to respond within the _Response Timeout _period. If the health checks exceed the
  _Unhealthy Threshold  _for consecutive failed responses, the load balancer takes the instance out of service. When the health checks exceed the  _Healthy Threshold _for consecutive successful responses, the load balancer puts the instance back in service.
* Load balancer only sends requests to the healthy EC2 instances and stops routing requests to the unhealthy instances

### Listeners

* Listeners is the process which checks for connection requests from client
* Listeners are configured with a protocol and a port for front-end \(client to load balancer\) connections, and a protocol and a port for back-end \(load balancer to back-end instance\) connections.
* Listeners support HTTP, HTTPS, SSL, TCP protocols
* A X.509 certificate is required for HTTPS or SSL connections and load balancer uses the certificate to terminate the connection and then decrypt requests from clients before sending them to the back-end instances.
* If you want to use SSL, but don’t want to terminate the connection on the load balancer, use TCP for connections from the client to the load balancer, use the SSL protocol for connections from the load balancer to the back-end application, and deploy certificates on the back-end instances handling requests.
* If you use an HTTPS/SSL connection for your back end, you can enable authentication on the back-end instance. This authentication can be used to ensure that back-end instances accept only encrypted communication, and to ensure that the back-end instance has the correct certificates.
* ELB HTTPS listener
  **does not support Client-Side SSL certificates**

### Idle Connection Timeout

* For each request that a client makes through a load balancer, it maintains two connections, for each client request, one connection with the client and the other connection is to the back-end instance.
* For each connection, the load balancer manages an idle timeout that is triggered when no data is sent over the connection for a specified time period. If no data has been sent or received, it closes the connection after the idle timeout period \(defaults to 60 seconds\) has elapsed
* For lengthy operations, such as file uploads, the idle timeout setting for the connections should be adjusted to ensure that lengthy operations have time to complete.

### X-Forwarded Headers & Proxy Protocol Support

* As the Elastic Load Balancer intercepts the traffic between the client and the back end servers, the back end server does not know the IP address, Protocol and the Port used between the Client and the Load balancer.
* ELB provides X-Forwarded headers support to help back end servers track the same when using HTTP protocol
  * **X-Forwarded-For**
    request header to help back end servers identify the IP address of a client when you use an HTTP or HTTPS load balancer.
  * **X-Forwarded-Proto**
    request header to help back end servers identify the protocol \(HTTP/S\) that a client used to connect to the server
  * **X-Forwarded-Port**
    request header to help back end servers identify the port that an HTTP or HTTPS load balancer uses to connect to the client.
* ELB provides Proxy Protocol support to help back end servers track the same when using
  _non-HTTP protocol_
   or when using HTTPS and not terminating the SSL connection on the load balancer.
  * Proxy Protocol is an Internet protocol used to carry connection information from the source requesting the connection to the destination for which the connection was requested.
  * Elastic Load Balancing uses Proxy Protocol version 1, which uses a human-readable header format with connection information such as the source IP address, destination IP address, and port numbers
  * If the ELB is already behind a Proxy with the Proxy protocol enabled, enabling the Proxy Protocol on ELB would add the header twice

### Cross-Zone

* By default, the load balancer distributes incoming requests evenly across its enabled Availability Zones
  _ for e.g. If AZ-a has 5 instances and AZ-b has 2 instances, the load will still be distributed 50% across each of the AZs_
* Enabling Cross-Zone load balancing allows the ELB to distribute incoming requests evenly across all the back-end instances, regardless of the AZ
* Cross-zone load balancer reduces the need to maintain equivalent numbers of back-end instances in each Availability Zone, and improves application’s ability to handle the loss of one or more back-end instances.
* It is still recommended to maintain approximately equivalent numbers of instances in each Availability Zone for higher fault tolerance.

### Connection Draining

* By default, if an registered EC2 instance with the ELB is deregistered or becomes unhealthy, the load balancer immediately closes the connection
* Connection draining can help the load balancer to complete the in-flight requests made while keeping the existing connections open, and preventing any new requests being sent to the instances that are de-registering or unhealthy.
* Connection draining helps perform maintenance such as deploying software upgrades or replacing back-end instances without affecting customers’ experience
* Connection draining allows you to specify a maximum time \(between 1 and 3,600 seconds and default 300 seconds\) to keep the connections alive before reporting the instance as de-registered. Maximum timeout limit does not apply to connections to unhealthy instances.
* If the instances are part of an Auto Scaling group and connection draining is enabled for your load balancer, Auto Scaling waits for the in-flight requests to complete, or for the maximum timeout to expire, before terminating instances due to a scaling event or health check replacement.

### Sticky Sessions \(Session Affinity\)

* ELB can be configured to use sticky session feature \(also called session affinity\) which enables it to bind a user’s session to an instance and ensures all requests are sent to the same instance.
* Stickiness remains for a period of time which can be controlled by the application’s session cookie, if one exists, or through cookie, named AWSELB, created through Elastic Load balancer.
* Sticky sessions for ELB are disabled, by default.

#### Requirements

* An HTTP/HTTPS load balancer.
* **SSL traffic should be terminated on the ELB. ELB does session stickiness on a HTTP/HTTPS listener is by utilizing an HTTP cookie. If SSL traffic is not terminated on the ELB and is terminated on the back-end instance, the ELB has no visibility into the HTTP headers and therefore can not set or read any of the HTTP headers being passed back and forth.**
* At least one healthy instance in each Availability Zone.

#### Duration-Based Session Stickiness

* Duration-Based Session Stickiness is maintained by ELB using a special cookie created to track the instance for each request to each listener.
* When the load balancer receives a request, it first checks to see if this cookie is present in the request. If so, the request is sent to the instance specified in the cookie.
* If there is no cookie, the ELB chooses an instance based on the existing load balancing algorithm and a cookie is inserted into the response for binding subsequent requests from the same user to that instance.
* Stickiness policy configuration defines a cookie expiration, which establishes the duration of validity for each cookie. The cookie is automatically updated after its duration expires.

#### Application-Controlled Session Stickiness

* Load balancer uses a special cookie only to associate the session with the instance that handled the initial request, but follows the lifetime of the application cookie specified in the policy configuration.
* Load balancer only inserts a new stickiness cookie if the application response includes a new application cookie. The load balancer stickiness cookie does not update with each request.
* If the application cookie is explicitly removed or expires, the session stops being sticky until a new application cookie is issued.
* If an instance fails or becomes unhealthy, the load balancer stops routing request to that instance, instead chooses a new healthy instance based on the existing load balancing algorithm. The load balancer treats the session as now “stuck” to the new healthy instance, and continues routing requests to that instance even if the failed instance comes back.

### Load Balancer Deletion

* Deleting a load balancer does not affect the instances registered with the load balancer and they would continue to run

### ELB with Autoscaling

Refer to My Blog Post about[ELB with Autoscaling](http://jayendrapatil.com/aws-auto-scaling-elb/)

