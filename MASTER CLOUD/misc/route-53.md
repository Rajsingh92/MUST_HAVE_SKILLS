# Route 53

* Amazon Route 53 provides three main functions:

  * **Domain registration**
    * allows you to register domain names
  * **Domain Name System \(DNS\) service**
    * translates friendly domains names like www.example.com into IP addresses like 192.0.2.1
    * responds to DNS queries using a global network of authoritative DNS servers, which reduces latency
    * can route Internet traffic to CloudFront, Elastic Beanstalk, ELB, or S3. There’s no charge for DNS queries to these resources
  * **Health checking**

    * can monitor the health of resources such as web and email servers.
    * sends automated requests over the Internet to the application to

      verify that it’s reachable, available, and functional

    * CloudWatch alarms can be configured for the health checks to send notification when a resource becomes unavailable.
    * can be configured to route Internet traffic away from resources that are unavailable

## Supported DNS Resource Record Types

* A \(Address\) Format
  * is an IPv4 address in dotted decimal notation
    _for e.g. 192.0.2.1_
* AAAA Format
  * is an IPv6 address in colon-separated hexadecimal format
* CNAME Format
  * is the same format as a domain name
  * DNS protocol does not allow creation of a CNAME record for the top node of a DNS namespace, also known as the
    **zone apex**
    _for e.g. the DNS name example.com registration, the zone apex is example.com,_
    a CNAME record for example.com cannot be created, but CNAME records can be created for www.example.com, newproduct.example.com etc.
  * If a CNAME record is created for a subdomain, any other resource record sets for that subdomain cannot be created
    _for e.g. if a CNAME created for www.example.com, not other resource record sets for which the value of the Name field is_
    _www.example.com can be created_
* MX \(Mail Xchange\) Format
  * contains a decimal number that represents the priority of the MX record, and the domain name of an email server
* NS \(Name Server\) Format
  * An NS record identifies the name servers for the hosted zone. The value for an NS record is the domain name of a name server.
* PTR Format
  * A PTR record Value element is the same format as a domain name.
* SOA \(Start of Authority\) Format
  * SOA record provides information about a domain and the corresponding Amazon Route 53 hosted zone
* SPF \(Sender Policy Framework\) Format
  * SPF records were formerly used to verify the identity of the sender of email messages, however is not recommended
  * Instead of an SPF record, a TXT record that contains the applicable value is recommended
* SRV Format
  * An SRV record Value element consists of four space-separated values.The first three values are decimal numbers representing priority, weight, and port. The fourth value is a domain name
    _for e.g. 10 5 80 hostname.example.com_
* TXT \(Text\) Format

  * A TXT record contains a space-separated list of double-quoted strings. A single string include a maximum

    of 255 characters. In addition to the characters that are permitted unescaped in domain names, space

    is allowed in TXT strings

## **Alias resource record sets**

* Route 53 supports alias resource record sets, which enables routing of queries to a CloudFront distribution, Elastic Beanstalk, ELB, an S3 bucket configured as a static website, or another Route 53 resource record set
* Alias records are not standard for DNS RFC and are an Route 53 extension to DNS functionality
* **Alias records help map the apex zone \(root domain without the www\) records to the load balancer DNS name as the DNS specification requires “zone apex” to point to an ‘A’ record \(ip address\) and not to an CNAME**
* Route 53 automatically recognizes changes in the resource record sets that the alias resource record set refers to
  _for e.g. for a site pointing to an load balancer, if the ip of the load balancer changes, Route 53 will reflect those changes automatically in the DNS answers without any changes to the hosted zone that contains resource record sets_
* If an alias resource record set points to a CloudFront distribution, a load balancer, or an S3 bucket, the time to live \(TTL\) can’t be set; Route 53 uses the CloudFront, load balancer, or Amazon S3 TTLs.







# AWS Route 53 Routing Policy

AWS Route 53 routing policy determines how AWS would respond to the DNS queries and provides multiple Routing policy options

## Simple Routing Policy

* Simple routing policy is a simple round robin policy and can be applied when there is a single resource doing the function for the domain
  _for e.g. web server that serves content for the website_
* AWS Route 53 responds to the DNS queries based on the values in the resource record set
  _for e.g. ip address in an A record_

## Weighted Routing Policy

* Weighted routing policy enables Route 53 to route traffic to different resources in specified proportions \(weights\) 
  _for e.g., 75% one server and 25% to the_
  _other during a pilot release_
* Weights can be assigned any number from 0 to 255
* Weighted routing policy can be applied when there are multiple resources that perform the same function
  _for e.g., webservers serving the same site_
* Weighted resource record sets let you associate multiple resources with a single DNS name
* Common use cases include
  * load balancing
  * A/B testing and piloting new versions of software
* To create a group of weighted resource record sets, two or more resource record sets can be created that have the same combination of DNS name and type, and each resource record set is assigned a unique identifier and a relative weight.
* When processing a DNS query, Route 53 searches for a resource record set or a group of resource record sets that have the specified name and type.
* Route 53 selects one from the group. Probability of any one resource record set being selected depends on its weight as a proportion of the total weight for all resource record sets in the group 
  _for e.g., suppose for www.example.com has three resource record sets with weights of 1 \(20%\), 1 \(20%\), and 3 \(60%\)\(sum = 5\). On average, Route 53 selects each of the first two resource record sets one-fifth of the time, and returns the third resource record set three-fifths of the time._

## Latency-based Routing \(LBR\) Policy

* Latency-based Routing Policy enables Route 53 to respond to the DNS query based on which data center gives the user the lowest network latency
* Latency-based routing policy can be used when there are multiple resources performing the same function and Route 53 needs to be configured to respond to the DNS queries with the resources that provide the fastest response with lowest latency
* Latency resource record set can be created for the EC2 resource in each region that hosts the application. When Route 53 receives a query for the corresponding domain, it selects the latency resource record set for the EC2 region that gives the user the lowest latency. Route 53 then responds with the value associated with that resource record set 
  _for e.g., you might have web servers for example.com in the EC2 data centers in Ireland and in Tokyo. When a user browses to example.com from Singapore, Route 53 will pick up the data center \(Tokyo\) which has the lowest latency from the users location_
* **Latency between hosts on the Internet can change over time as a result of changes in network connectivity and routing. Latency-based routing is based on latency measurements performed over a period of time, and the measurements reflect these changes**
  _for e.g. if the latency from the user in Singapore to Ireland improves, the user can be routed to Ireland_
  ** **
* Latency based routing cannot guarantee users from the same geographic will be served from the same location for any compliance reason
* Latency resource record sets can be created using any record type that Route 53 supports except NS or SOA

## Failover Routing Policy

* Failover routing policy allows active-passive failover configuration, in which one resource takes all traffic when it’s available and the other resource takes all traffic when the first resource isn’t available.
* Route 53 health checking agents will monitor each location/endpoint of the application to determine the availability.
* Failover routing policy is applicable for Public hosted zones only

## Geolocation Routing Policy

* Geolocation routing policy enables Route 53 to respond to DNS queries based on the geographic location of the users i.e. location from which the DNS queries originate
* Common use cases include
  * localization of content and presenting some or all of the website in the users language
  * restrict distribution of content to only the locations in which you have distribution rights.
  * balancing load across endpoints in a predictable, easy-to-manage way, so that each user location is consistently routed to the same endpoint.
* Geolocation routing policy allows geographic locations to be specified by continent, country, or by state \(only in US\)
* Geolocation record sets, if created, for overlapping geographic regions
  _for e.g. continent and then for the country within the same continent_
  , priority goes to the smallest geographic region, which allows some queries for a continent to be routed to one resource and queries for selected countries on that continent to a different resource
* Geolocation works by mapping IP addresses to locations, which might not mapped to a exact geographic location
* A default resource record set can be created to handle these queries and also the ones which do not have an explicit record set created
* Route 53 returns a “no answer”response for queries from those locations, if a default resource record set if not created
* Two geolocation resource record sets that specify the same geographic location
  **cannot**
  be created
* Route 53 supports the edns-client-subnet extension of EDNS0 \(EDNS0 adds several optional extensions to the DNS protocol.\) to improve the accuracy of geolocation routing



