1. **An instance is launched into the public subnet of a VPC. Which of the following must be done in order for it to be accessible FROM the Internet?**

   1. Attach an Elastic IP to the instance
   2. Nothing. The instance is accessible from the Internet
   3. Launch a NAT instance and route all traffic to it
   4. Make an entry in the route table passing all traffic going outside the VPC to the NAT instance
2. **In VPCs with private and public subnets, database servers should ideally be launched into:**

   1. The public subnet
   2. The private subnet
   3. Either of them
   4. Not recommended, they should ideally be launched outside VPC

3. **An instance is connected to an ENI \(Elastic Network Interface\) in one subnet. What happens when you attach an ENI of a different subnet to this instance?**
   1. The instance follows the rules of the older subnet
   2. The instance follows the rules of both the subnets
   3. The instance follows the rules of the newer subnet
   4. Not possible cannot be connected to 2 ENIs
4. **You want to use Route53 to direct your www sub-domain to an elastic load balancer fronting your web servers. What kind of record set should you create?**
   1. A.
   2. AAAA
   3. NS
   4. CNAME
5. **You have created 4 weighted resource record sets with weights 1, 2, 3 and 4. the 3rd record set is selected by Route53:**
   1. 1/7th of the  time
   2. 3/10th of the time
   3. 3/7th of the time
   4. 1/4th of the time
6. **You have created a Route 53 latency record set from your domain to a machine in Singapore and a similar record to a machine in Oregon. When a user located in India visits your domain he will be routed to:**
   1. Singapore
   2. Oregon
   3. Depends on the load on each machine
   4. Both, because 2 requests are made, 1 to each machine
7. **Which of the following can be used as an origin server in CloudFront?\(Choose 3\)**
   1. A webserver running on EC2
   2. A webserver running in your own datacenter
   3. A RDS instance
   4. An Amazon S3 bucket
8. **In CloudFront what happens when content is NOT present at an Edge location and a request is made to it?**
   1. An Error 404 not found is returned
   2. CloudFront delivers the content directly from the origin server and stores it in the cache of the edge location
   3. The request is kept on hold till content is delivered to the edge location
   4. The request is routed to the next closest edge location
9. **Which of the following is true with respect to serving private content through CloudFront?**
   1. Signed URLs can be created to access objects from CloudFront edge locations
   2. Direct access to S3 URLs can be removed therefore allowing access only through CloudFront URLs
   3. Mark the S3 bucket private and allow access to CloudFront by means of Roles
   4. Mark the S3 bucket private and and create an Origin Access Identity to access the objects
10. **You have written a CloudFormation template that creates 1 elastic load balancer fronting 2 EC2 instances. Which section of the template should you edit so that the DNS of the load balancer is returned upon creation of the stack.**
    1. Resources
    2. Parameters
    3. Outputs
    4. Mappings

**Answers:**

**1\) a**

**2\) b**

**3\) b**

**4\) d**

**5\) b**

**6\) a**

**7\) a, b, d**

**8\) b**

**9\) a, b, d**

**10\) c**



