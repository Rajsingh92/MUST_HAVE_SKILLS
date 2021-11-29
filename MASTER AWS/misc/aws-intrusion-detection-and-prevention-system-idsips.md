# AWS Intrusion Detection & Prevention System IDS/IPS

* An Intrusion Prevention System IPS
  * is an appliance that monitors and analyzes network traffic to detect malicious patterns and potentially harmful packets and prevent vulnerability exploits
  * Most IPS offer firewall, unified threat management and routing capabilities
* An Intrusion Detection System IDS is
  * an appliance or capability that continuously monitors the environment
  * sends alerts when it detects malicious activity, policy violations or network 
    &
     system attack from someone attempting to break into or compromise the system
  * produces reports for analysis.

## Approaches for AWS IDS/IPS

### **Network Tap or SPAN**

* Traditional approach involves using a network Test Access Point \(TAP\) or Switch Port Analyzer \(SPAN\) to access 
  &
   monitor all network traffic
* Connection between the AWS Internet Gateway \(IGW\) and the Elastic Load Balancer would be an ideal place to capture all network traffic
* However, there is no place to plug this in between IGW and ELB as there are no SPAN ports, network taps, or a concept of Layer 2 bridging

### Packet Sniffing

* It is not possible for a virtual instance running in promiscuous mode to receive or
  sniff
  traffic that is intended for a different virtual instance.
* While interfaces can be placed into promiscuous mode, the hypervisor will not deliver any traffic to an instance that is not addressed to it.
* Even two virtual instances that are owned by the same customer located on the same physical host cannot listen to each other’s traffic
* So, promiscuous mode is not allowed

### **Host Based Firewall – Forward Deployed IDS**

* Deploy a network-based IDS on every instance you deploy IDS workload scales with your infrastructure
* Host-based security software works well with highly distributed and scalable application architectures because network packet inspection is distributed across the entire software fleet
* However, CPU-intensive process is deployed onto every single machine.

### **Host Based Firewall – Traffic Replication**

* An Agent is deployed on every instance to capture 
  &
   replicate traffic for centralized analysis
* Actual workload of network traffic analysis is not performed on the instance but on a separate server
* Traffic capture and replication is still CPU-intensive \(particularly on Windows machines.\)
* It significantly increases the internal network traffic in the environment as every inbound packet is duplicated in the transfer from the instance that captures the traffic to the instance that analyzes the traffic

### ![](https://i0.wp.com/jayendrapatil.com/wp-content/uploads/2016/12/AWS-IDSIPS-Solution-1.png?resize=656%2C427 "AWS IDS IPS Solution 1")

### **In-Line Firewall – Inbound IDS Tier**

* Add another tier to the application architecture where a load balancer sends all inbound traffic to a tier of instances that performs the network analysis
  _for e.g. Third Party Solution_
  [_Fortinet FortiGate_](http://cookbook.fortinet.com/configuring-aws-elb-vip-fortigate-vm/)
* IDS workload is now isolated to a horizontally scalable tier in the architecture You have to maintain and manage another mission-critical elastic tier in the architecture



