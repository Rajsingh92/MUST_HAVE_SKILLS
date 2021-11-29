# AWS OpsWorks

* AWS OpsWorks is a configuration management service that helps to configure and operate applications in a cloud enterprise by using Chef
* OpsWorks Stacks and AWS OpsWorks for Chef Automate allows using Chef cookbooks and solutions for configuration management

## OpsWorks Stacks

![](https://i0.wp.com/jayendrapatil.com/wp-content/uploads/2016/12/OpsWorks-Stacks.png?resize=656%2C445 "AWS OpsWorks Stacks")

* OpsWorks Stacks provides a simple and flexible way to create and manage stacks, groups of AWS resources like load balancers, web, application and database servers, and application deployed on them
* OpsWorks Stacks helps deploy and monitor applications in the stacks.
* Unlike OpsWorks for Chef Automate, OpsWorks Stacks does not require or create Chef servers; and performs some of the work of a Chef server itself
* OpsWorks Stacks monitors instance health, and provisions new instances, when necessary, by using Auto Healing and Auto Scaling
* OpsWorks Stacks integrates with IAM to control how users can interact with stacks, what stacks can do on the users behalf, what AWS resources an app can access etc
* OpsWorks Stacks integrates with CloudWatch and CloudTrail to enable monitoring and logging
* OpsWorks Stacks can be accessed globally and can be used to create and manage instances globally

### Stacks

* Stack is the core AWS OpsWorks Stacks component.
* Stack is a container for AWS resources like EC2, RDS instances etc that have a common purpose and should be logically managed together
* Stack helps manage the resources as a group and also defines some default configuration settings, such as the instances’ OS and AWS region
* Stacks can also be run in VPC to be isolated from direct user interaction
* Separate Stacks can be created for different environments like Dev, QA etc

### Layers

* Stacks help manage cloud resources in specialized groups called layers.
* A layer represents a set of EC2 instances that serve a particular purpose, such as serving applications or hosting a database server.
* Layers depend on Chef recipes to handle tasks such as installing packages on instances, deploying apps, and running scripts
* Custom recipes and related files is packaged in one or more cookbooks and stored in a cookbook repository such S3 or Git

### Recipes and LifeCycle Events

* Layers depend on Chef recipes to handle tasks such as installing packages on instances, deploying apps, running scripts, and so on.
* OpsWorks Stacks runs the recipes for each layer, even if the instance belongs to multiple layers
  _for e.g. instance hosting both the application and the mysql server_
* AWS OpsWorks Stacks features is a set of lifecycle events – Setup, Configure, Deploy, Undeploy, and Shutdown – which automatically runs specified set of recipes at the appropriate time on each instance
  * Setup
    * Once a new instance has booted, OpsWorks triggers the Setup event, which runs recipes to set up the instance according to the layer configuration _for e.g. installation of apache, PHP packages_
    * Once setup is complete, AWS OpsWorks triggers a Deploy event, which runs recipes to deploy your application to the new instance.
  * Configure
    * Whenever an instance enters or leaves the online state, AWS OpsWorks triggers a Configure event on all instances in the stack.
    * Event runs each layer’s configure recipes to update configuration to reflect the current set of online instances
      _for e.g. the HAProxy layer’s Configure recipes can modify the load balancer configuration to reflect any added or removed application server instances._
  * Deploy
    * OpsWorks triggers a Deploy event when the Deploy command is executed, to deploy the application to a set of application servers.
    * Event runs recipes on the application servers to deploy application and any related files from its repository to the layer’s instances.
  * Undeploy
    * OpsWorks triggers an Undeploy event when an app is deleted or  Undeploy command is executed to remove an app from a set of application servers.
    * Event runs recipes to remove all application versions and perform any additional cleanup tasks.
  * Shutdown
    * OpsWorks triggers a Shutdown event when an instance is being shut down, but before the underlying EC2 instance is actually terminated.
    * Event runs recipes to perform cleanup tasks such as shutting down services.
    * OpsWorks allows Shutdown recipes a configurable amount of time to perform their tasks, and then terminates the instance.

### Instance

* An instance represents a single computing resource _for e.g. EC2 instance  _and it defines resource’s basic configuration, such as OS and size
* OpsWorks Stacks create instances and adds them to a layer.
* When the instance is started, OpsWorks Stacks launches an EC2 instance using the configuration settings specified by the instance and its layer.
* After the EC2 instance has finished booting, OpsWorks Stacks installs an agent that handles communication between the instance and the service and runs the appropriate recipes in response to lifecycle events
* OpsWorks Stacks supports instance auto-healing, whereby if an agent stops communicating with the service, OpsWorks Stacks automatically stops and restarts the instance
* OpsWorks Stacks supports the following instance types
  * 24/7 instances – launched and stopped manually
  * Time based instances – run on scheduled time
  * Load based instances – automatically started and stopped based on configurable load metrics
* Linux based computing resources created outside of the OpsWorks stacks _for e.g. console or CLI _can be added, incorporated and controlled through OpsWorks

### Apps

* An AWS OpsWorks Stacks app represents code that you want to run on an application server residing in the app repository like S3
* App contains the information required to deploy the code to the appropriate application server instances.
* When you deploy an app, AWS OpsWorks Stacks triggers a Deploy event, which runs the Deploy recipes on the stack’s instances.
* OpsWorks supports the ability to deploy multiple apps per stack and per layer



