# AWS Web Application Firewall – WAF

* AWS WAF is a web application firewall that helps monitor HTTP/ HTTPS requests forwarded to CloudFront and allows controlling access to the content.
* WAF allows defining conditions _for e.g. request originated IP addresses or query strings values_, based on which CloudFront responds to requests either with the requested content or with an access denied \(HTTP 403\)
* CloudFront can be configured to return a custom error page when a request is blocked.
* AWS WAF allows the following behaviors:
  * **Allow all requests except the ones specified**
     – Useful when CloudFront serves content for a public website but want to block requests from attackers.
  * **Block all requests except the ones specified**
     – Useful when CloudFront serves content for a restricted website whose users can be readily identifiable by properties in web requests _for e.g IP addresses the request originate from_
  * **Count the requests that match the specified properties**
     – allows counting of the requests that match the defined properties, which can be useful when configuring and testing allow or block requests using new properties. After confirming that config did not accidentally block all of the traffic to the website, configuration can be applied to change the behavior to allow or block requests.

### WAF Benefits

* Additional protection against web attacks using specified conditions
* Conditions can be defined by using characteristics of web requests such as the following:
  * IP addresses that the requests originate from
  * Values in request headers
  * Strings that appear in the requests
  * Length of requests
  * Presence of SQL code that is likely to be malicious \(this is known as SQL injection\)
  * Presence of a script that is likely to be malicious \(this is known as cross-site scripting\)
* Rules that you can reuse for multiple web applications
* Real-time metrics and sampled web requests
* Automated administration using the WAF API

## How WAF Works

WAF allows controlling behavior to web requests by creating conditions, rules, and web access control lists \(web ACLs\).

### Conditions

* Conditions define basic characteristics to watch for in a web request

  * **Malicious script – XSS  \(Cross Site Scripting\)**
    – Attackers embed scripts that can exploit vulnerabilities in web applications
  * **IP addresses**
    or address ranges that requests originate from.
  * Length of specified parts of the request, such as the query string.
  * **Malicious SQL – SQL injection**
    – Attackers try to extract data from the database by embedding malicious SQL code in a web request
  * **Strings that appear in the request**, _for e.g., values that appear in the User-Agent header or text strings that appear in the query string.Some conditions take multiple values._

### Rules

* **Rules are basically Combination of Conditions**
  to precisely target the requests to be allowed or blocked.
* When a rule includes multiple conditions, WAF looks for requests that match all the conditions-it ANDs the conditions together.
* _for e.g., based on recent requests that you’ve seen from an attacker, you might create a rule that includes the following conditions:_
  * _The requests come from 192.0.2.44._
  * _They contain the value BadBot in the User-Agent header._
  * _They appear to include malicious SQL code in the query string._
* All 3 conditions should be satisfied for the Rule to be passed and the associated action to be taken

### Web ACLs

* Web ACLs provides
  * **Combination of Rules**
  * **Action – allow, block or count**
    to perform for each rule
    * WAF compares a request with the rules in a web ACL in the order in which its listed and takes the action that is associated with the first rule that the request matches.
    * For multiple rules in a web ACL, WAF evaluates each request against the rules in the order they are listed in the web ACL.
    * When a web request matches all of the conditions in a rule, WAF immediately takes the action—allow or block—and doesn’t evaluate the request against the remaining rules in the web ACL, if any.
  * **Default action**
    * determines whether WAF allows or blocks a request that does not match all of the conditions in any of the rules

### Web Application Firewall Sandwich Architecture

NOTE :- from DDOS Resiliency Whitepaper and doesn’t use the AWS WAF

### ![](https://i1.wp.com/jayendrapatil.com/wp-content/uploads/2016/09/WAF-Sandwich-Architecture.png?resize=656%2C349 "WAF Sandwich Architecture")

* DDoS attacks at the application layer commonly target web applications with lower volumes of traffic compared to infrastructure attacks.
* WAF can be included as part of the infrastructure to mitigate these types of attacks
* WAFs act as filters that apply a set of rules to web traffic, which cover exploits like XSS and SQL injection but can also help build resiliency against DDoS by mitigating HTTP GET or POST floods.
* HTTP works as a request-response protocol between end users and applications where end users request data \(GET\) and submit data to be processed \(POST\). GET floods work by requesting the same URL at a high rate or requesting all objects from your application. POST floods work by finding expensive application processes, i.e., logins or database searches, and triggering those process to overwhelm your application.
* WAFs have several features that may prevent these types of attacks from affecting the application availability
  _for e.g. HTTP rate limiting which limits the number of requests per end user within a certain time period. Once the threshold is exceeded, WAFs can block or buffer new requests to ensure other end users have access to the application_
  .
* WAFs can also inspect HTTP requests and identify those that don’t confirm to normal patterns
* In the “**WAF sandwich**,” the EC2 instance running the WAF software \(not the AWS WAF\) is included in an Auto Scaling group and placed in between two ELB load balancers. Basic load balancer in the default VPC will be the frontend, public facing load balancer that will distribute all incoming traffic to the WAF EC2 instance.
* With WAF sandwich pattern, the instance can scale and add additional WAF EC2 instances should the traffic spike to elevated levels.
* Once the traffic has been inspected and filtered, the WAF EC2 instance forwards traffic to the internal, backend load balancer which then distributes traffic across the application EC2 instance.
* This configuration allows the WAF EC2 instances to scale and meet capacity demands without affecting the availability of your application EC2 instance.



