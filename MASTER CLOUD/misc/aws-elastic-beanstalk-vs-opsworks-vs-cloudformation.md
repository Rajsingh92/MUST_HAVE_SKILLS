# AWS Elastic Beanstalk vs OpsWorks vs CloudFormation

AWS offers multiple options for provisioning IT infrastructure and application deployment and management varying from convenience & easy of setup with low level granular control  
![](https://i1.wp.com/jayendrapatil.com/wp-content/uploads/2017/01/Deployment-and-Management.png?resize=656%2C325 "Deployment and Management - Elastic Beanstalk vs OpsWorks vs CloudFormation")

## AWS Elastic Beanstalk

* AWS Elastic Beanstalk is a higher level service which allows you to quickly deploy out with minimum management effort a web or worker based environments using EC2, Docker using ECS, Elastic Load Balancing, Auto Scaling, RDS, CloudWatch etc.
* Elastic Beanstalk is the fastest and simplest way to get an application up and running on AWS and perfect for developers who want to deploy code and not worry about underlying infrastructure
* Elastic Beanstalk provides an environment to easily deploy and run applications in the cloud. It is integrated with developer tools and provides a one-stop experience for application lifecycle management
* Elastic Beanstalk requires minimal configuration points and will help deploy, monitor and handle the elasticity/scalability of the application
* A user does’t need to do much more than write application code and configure and define some configuration on Elastic Beanstalk

## AWS OpsWorks

* AWS OpsWorks is an application management service that simplifies software configuration, application deployment, scaling, and monitoring
* OpsWorks is recommended if you want to manage your infrastructure with a configuration management system such as Chef.
* Opsworks enables writing custom chef recipes, utilizes self healing, and works with layers
* Although, Opsworks is deployment management service that helps you deploy applications with Chef recipes, but it is not primally meant to manage the scaling of the application out of the box, and needs to be handled explicitly

## AWS CloudFormation

* AWS CloudFormation enables modeling, provisioning and version-controlling of a wide range of AWS resources ranging from a single EC2 instance to a complex multi-tier, multi-region application
* CloudFormation is a low level service and provides granular control to provision and manage stacks of AWS resources based on templates
* CloudFormation templates enables version control of the infrastructure and makes deployment of environments easy and repeatable
* CloudFormation supports infrastructure needs of many different types of applications such as existing enterprise applications, legacy applications, applications built using a variety of AWS resources and container-based solutions \(including those built using AWS Elastic Beanstalk\).
* CloudFormation is not just an application deployment tool but can provision any kind of AWS resource
* CloudFormation is designed to complement both Elastic Beanstalk and OpsWorks
* CloudFormation with Elastic Beanstalk
  * CloudFormation supports Elastic Beanstalk application environments as one of the AWS resource types.
  * This allows you, for example, to create and manage an AWS Elastic Beanstalk–hosted application along with an RDS database to store the application data. In addition to RDS instances, any other supported AWS resource can be added to the group as well.
* CloudFormation with OpsWorks
  * CloudFormation also supports OpsWorks and OpsWorks components \(stacks, layers, instances, and applications\) can be modeled inside CloudFormation templates, and provisioned as CloudFormation stacks.
  * This enables you to document, version control, and share your OpsWorks configuration.
  * Unified CloudFormation template or separate CloudFormation templates can be created to provision OpsWorks components and other related AWS resources such as VPC and Elastic Load Balancer



