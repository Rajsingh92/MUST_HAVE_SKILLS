# AWS Classic Load Balancer vs Application Load Balancer

Elastic Load Balancing supports two types of load balancers: Application Load Balancers and Classic Load Balancers. While there is some overlap in the features, AWS does not maintain feature parity between the two types of load balancers. Content below lists down the feature comparison for both.

**Usage Pattern**

* A Classic Load Balancer is ideal for simple load balancing of traffic across multiple EC2 instances,
* Application Load Balancer is ideal for microservices or container-based architectures where there is a need to route traffic to multiple services or load balance across multiple ports on the same EC2 instance.

![](/assets/classic-ALB11.png)  
**Supported Protocols**

* Classic Load Balancer operates at
  **layer 4**
  and supports HTTP, HTTPS,
  **TCP, SSL**
  while Application Load Balancer operates at
  **layer 7**
  and supports HTTP, HTTPS,
  **HTTP/2, WebSockets**
* If Layer-4 features are needed, Classic Load Balancers should be used

**Supported Platforms**

* Classic Load Balancer supports both
  **EC2-Classic**
  and EC2-VPC while Application Load Balancer supports only EC2-VPC

**Stick Sessions \(Cookies\)**

* Stick Sessions \(Session Affinity\) enables the load balancer to bind a user’s session to a specific instance, which ensures that all requests from the user during the session are sent to the same instance
* Both Classic & Application Load Balancer supports sticky sessions to maintain session affinity

**Idle Connection Timeout**

* Idle Connection Timeout helps specify a time period, which ELB uses to close the connection if no data has been sent or received by the time that the idle timeout period elapses
* Both Classic & Application Load Balancer supports idle connection timeout

**Connection Draining**

* Connection draining enables the load balancer to complete in-flight requests made to instances that are de-registering or unhealthy
* Both Classic & Application Load Balancer supports connection draining

**SSL Termination**

* Both Classic Load Balancer and ALB support SSL Termination to decrypt requests from clients before sending them to targets and hence reducing the load. SSL certificate must be installed on the load balancer.

**Back-end Server Authentication**

* Back-end Server Authentication enables authentication of the instances. Load balancer communicates with an instance only if the public key that the instance presents to the load balancer matches a public key in the authentication policy for the load balancer.
* Classic Load Balancer supports while Application Load Balancer
  **does not**
  support Back-end Server Authentication

**Cross-zone Load Balancing**

* Cross-zone Load Balancing help distribute incoming requests evenly across all instances in its enabled AZs. By default, Load Balancer will evenly distribute requests evenly across its enabled AZs, irrespective of the instances it hosts.
* Both Classic & Application Load Balancer both support Cross-zone load balancing, however for Classic it needs to be enabled while for ALB it is always enabled

**Health Checks**

* Both Classic & Application Load Balancer both support Health checks to determine if the instance is healthy or unhealthy
* ALB provides health check improvements that allow detailed error codes from 200-399 to be configured

**CloudWatch Metrics**

* Both Classic & Application Load Balancer integrate with CloudWatch to provide metrics, with ALB providing additional metrics

**Access Logs**

* Access logs capture detailed information about requests sent to the load balancer. Each log contains information such as the time the request was received, the client’s IP address, latencies, request paths, and server responses
* Both Classic & Application Load Balancer provide access logs, with ALB providing additional attributes

**Host-based Routing &Path-based Routing**

* Host-based routing use host conditions to define rules that forward requests to different target groups based on the host name in the host header. This enables ALB to support multiple domains using a single load balancer.
* Path-based routing use path conditions to define rules that forward requests to different target groups based on the URL in the request. Each path condition has one path pattern. If the URL in a request matches the path pattern in a listener rule exactly, the request is routed using that rule.
* **Only**
  ALB supports Host-based & Path-based routing.

**Dynamic Ports**

* Only ALB supports Dynamic Port Mapping with ECS, which allows two containers of a service to run on a single server on dynamic ports that ALB automatically detects and reconfigures itself.

**Deletion Protection**

* **Only**
  ALB supports Deletion Protection, wherein a load balancer can’t be deleted if deletion protection is enabled

**Request Tracing**

* Only ALB supports Request Tracing to track HTTP requests from clients to targets or other services.

**IPv6 in VPC**

* Only ALB supports IPv6 in VPC

**AWS WAF**

* Only ALB supports AWS WAF, which can be directly used on ALBs \(both internal and external\) in a VPC, to protect websites and web services



