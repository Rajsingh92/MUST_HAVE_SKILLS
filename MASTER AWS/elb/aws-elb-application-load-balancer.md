# AWS ELB Application Load Balancer

* An Application Load Balancer is a load balancing option for the ELB service that operates at the layer 7 \(application layer\) and allows defining routing rules based on content across multiple services or containers running on one or more EC2 instances.

![](https://i0.wp.com/dmhnzl5mp9mj6.cloudfront.net/application-management_awsblog/images/img2.png?zoom=1.25&w=656&ssl=1)

## Application Load Balancer Benefits

* Support for Path-based routing,  where listener rules can be configured to forward requests based on the URL in the request. This enables structuring application as smaller services, and route requests to the correct service based on the content of the URL.
* Support for routing requests to multiple services on a single EC2 instance by registering the instance using multiple ports.
* Support for containerized applications. EC2 Container Service \(ECS\) can select an unused port when scheduling a task and register the task with a target group using this port, enabling efficient use of the clusters.
* Support for monitoring the health of each service independently, as health checks are defined at the target group level and many CloudWatch metrics are reported at the target group level. Attaching a target group to an Auto Scaling group enables you to scale each service dynamically based on demand.

## Application Load Balancer Features

* supports load balancing of applications using
  **HTTP and HTTPS \(Secure HTTP\) protocols**
* supports 
  **HTTP/2**
  , which is enabled natively. Clients that support HTTP/2 can connect over TLS
* supports
  **WebSockets**
  and Secure WebSockets natively
* supports
  **Request tracing**
  , by default
* supports
  **Sticky Sessions \(Session Affinity\)**
  using load balancer generated cookies, to route requests from the same client to the same target
* supports
  **SSL termination**
  , to decrypt the request on ALB before sending it to the underlying targets.
* supports layer 7 specific features like 
  **X-Forwarded-For**
  headers to help determine the actual client IP, port and protocol
* automatically
  **scales**
  its request handling capacity in response to incoming application traffic.
* provides
  **High Availability**
  , by allowing you to specify more than one AZ and distribution of incoming traffic across multiple AZs.
* integrates with
  **ACM**
  to provision and bind a SSL/TLS certificate to the load balancer thereby making the entire SSL offload process very easy
* supports
  **IPv6**
  addressing, for an Internet facing load balancer
* supports
  **Request Tracking**
  , where in a new custom identifier “X-Amzn-Trace-Id” HTTP header is injected on all requests to help track in the request flow across various services
* supports
  **Security Groups**
  to control the traffic allowed to and from the load balancer.
* provides
  **Access Logs**
  , to record all requests sent the load balancer, and store the logs in S3 for later analysis in compressed format
* provides
  **Delete Protection**
  , to prevent the ALB from accidental deletion
* supports
  **Connection Idle Timeout**
  – ALB maintains two connections for each request one with the Client \(front end\) and one with the target instance \(back end\). If no data has been sent or received by the time that the idle timeout period elapses, ALB closes the front-end connection
* integrates with
  **CloudWatch**
  to provide metrics such as request counts, error counts, error types, and request latency
* integrates with
  **AWS WAF**
  , a web application firewall that helps protect web applications from attacks by allowing rules configuration based on IP addresses, HTTP headers, and custom URI strings
* integrates with
  **CloudTrail**
  to receive a history of ALB API calls made on the AWS account

## Application Load Balancer Listeners

* A listener is a process that checks for connection requests, using the configured protocol and port
* Listener supports HTTP 
  &
   HTTPS protocol with Ports from 1-65535
* ALB supports SSL Termination for HTTPS listener, which helps to offload the work of encryption and decryption so that the targets can focus on their main work.
* HTTPS listener supports exactly one SSL server certificate on the listener.
* WebSockets with both HTTP and HTTPS listeners \(Secure WebSockets\)
* Supports HTTP/2 with HTTPS listeners
  * 128 requests can be sent in parallel using one HTTP/2 connection.
  * ALB converts these to individual HTTP/1.1 requests and distributes them across the healthy targets in the target group using the round robin routing algorithm.
  * HTTP/2 uses front-end connections more efficiently resulting in fewer connections between clients and the load balancer.
  * Server-push feature of HTTP/2 is not supported
* Each listener has a default rule, and can optionally define additional rules.
* Each rule consists of a priority, action, optional host condition, and optional path condition.
  * Priority – Rules are evaluated in priority order, from the lowest value to the highest value. The default rule has lowest priority
  * Action – Each rule action has a type and a target group. Currently, the only supported type is forward, which forwards requests to the target group. You can change the target group for a rule at any time.
  * Condition – There are two types of rule conditions: host and path. When the conditions for a rule are met, then its action is taken
* **Host Condition or Host-based routing**
  * Host conditions can be used to define rules that forward requests to different target groups based on the host name in the host header
  * This enables support for multiple domains using a single ALB
    _for e.g. orders.example.com, images.example.com, registration.example.com_
  * Each host condition has one hostname. If the hostname in
* **Path Condition or path-based routing**
  * Path conditions can be used to define rules that forward requests to different target groups based on the URL in the request
  * Each path condition has one path pattern
    _for e.g. example.com/orders, example.com/images, example.com/registration_
  * If the URL in a request matches the path pattern in a listener rule exactly, the request is routed using that rule.

## Advantages over Classic Load Balancer

* Support for path-based routing, where rules can be configured for the listener to forward requests based on the URL
* Support for host-based routing, where rules can be configured for the listener to forward requests based on the host field in the HTTP header.
* Support for routing requests to multiple applications on a single EC2 instance. Each instance or IP address can be registered with the same target group using multiple ports
* Support for registering targets by IP address, including targets outside the VPC for the load balancer.
* Support containerized applications with ECS using Dynamic port mapping
* Support monitoring the health of each service independently, as health checks and many CloudWatch metrics are defined at the target group level
* Attaching of target group to an Auto Scaling group enables scaling of each service dynamically based on demand
* Access logs contain additional information 
  &
   stored in compressed format
* Improved load balancer performance.



