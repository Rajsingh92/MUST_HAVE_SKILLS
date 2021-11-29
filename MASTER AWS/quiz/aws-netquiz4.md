**Qeustion 1**

A user has created a launch configuration for Auto Scaling where CloudWatch detailed monitoring is disabled. The user wants to now enable detailed monitoring. How can the user achieve this?

1. Update the Launch config with CLI to set InstanceMonitoringDisabled = false
2. The user should change the Auto Scaling group from the AWS console to enable detailed monitoring
3. Update the Launch config with CLI to set InstanceMonitoring.Enabled = true
4. **Create a new Launch Config with detail monitoring enabled and update the Auto Scaling group**

**Qeustion 2**

A customer has a website which shows all the deals available across the market. The site experiences a load of 5 large EC2 instances generally. However, a week before Thanksgiving vacation they encounter a load of almost 20 large instances. The load during that period varies over the day based on the office timings. Which of the below mentioned solutions is cost effective as well as help the website achieve better performance?

1. Keep only 10 instances running and manually launch 10 instances every day during office hours.
2. **Setup to run 10 instances during the pre-vacation period and only scale up during the office time by launching 10 more instances using the AutoScaling schedule.**
3. During the pre-vacation period setup a scenario where the organization has 15 instances running and 5 instances to scale up and down using Auto Scaling based on the network I/O policy.
4. During the pre-vacation period setup 20 instances to run continuously.

**Qeustion 3**

For AWS Auto Scaling, what is the first transition state an existing instance enters after leaving steady state in Standby mode?

1. Detaching
2. Terminating:Wait
3. **Pending**
   \(You can put any instance that is in an InService state into a Standby state. This enables you to remove the instance from service, troubleshoot or make changes to it, and then put it back into service. Instances in a Standby state continue to be managed by the Auto Scaling group. However, they are not an active part of your application until you put them back into service. Refer [link](http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/AutoScalingGroupLifecycle.html)\)
4. EnteringStandby

**Qeustion 4**

For AWS Auto Scaling, what is the first transition state an instance enters after leaving steady state when scaling in due to health check failure or decreased load?

1. **Terminating**
   \(When Auto Scaling responds to a scale in event, it terminates one or more instances. These instances are detached from the Auto Scaling group and enter the Terminating state. Refer [link](http://docs.aws.amazon.com/AutoScaling/latest/DeveloperGuide/AutoScalingGroupLifecycle.html)\)
2. Detaching
3. Terminating:Wait
4. EnteringStandby



**Qeustion 5**

Which for the services provide root access

1. **Elastic Beanstalk**
2. **EC2**
3. **Opswork**
4. **EC2**
5. DynamoDb
6. RDS
7. S3



