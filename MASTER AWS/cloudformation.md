# AWS CloudFormation

* AWS CloudFormation gives developers and systems administrators an easy way to create and manage a collection of related AWS resources, provision and update them in an orderly and predictable fashion
* CloudFormation consists of
  * Template
    * is an architectural diagram
    * a JSON or YAML-format, text-based file that describes all the AWS resources you need to deploy to run your application
  * Stack
    * is the end result of that diagram, which is actually provisioned
    * is the set of AWS resources that are created and managed as a single unit when CloudFormation instantiates a template.
* CloudFormation template can be used to set up the resources consistently and repeatedly over and over across multiple regions
* Resources can be updated, deleted and modified in a controlled and predictable way, in effect applying version control to the infrastructure as done for software code
* AWS CloudFormation Template consists of elements :-
  * List of AWS resources and their configuration values
  * An optional template file format version number
  * An optional list of template parameters \(input values supplied at stack creation time\)
  * An optional list of output values like public IP address using the Fn::GetAtt function
  * An optional list of data tables used to lookup static configuration values _for e.g., AMI names per AZ_
* CloudFormation supports Chef & Puppet Integration, meaning that you can deploy and configure right down the application layer
* CloudFormation provides a set of application bootstrapping scripts that enable you to install packages, files, and services on the EC2 instances by simply describing them in the CloudFormation template
* By default, **automatic rollback on error **feature is enabled, which will cause all the AWS resources that CloudFormation created successfully for a stack up to the point where an error occurred to be deleted.
* In case of automatic rollback, charges would still be applied for the resources the time they were up and running
* CloudFormation provides a **WaitCondition **resource that acts as a barrier, blocking the creation of other resources until a completion signal is received from an external source _e.g. application, or management system_
* CloudFormation allows deletion policies to be defined for resources in the template _for e.g. resources to be retained or snapshots can be created before deletion useful for preserving S3 buckets when the stack is deleted_

#### Required Mainly for Developer, SysOps Associate & DevOps Professional Exam

## AWS CloudFormation Concepts

* AWS CloudFormation, you work with templates and stacks
  * **Templates**
    * act as blueprints for building AWS resources.
    * is a JSON or YAML formatted text file, saved with any extension, such as .json, .yaml, .template, or .txt.
    * have additional capabilities to build complex sets of resources and reuse those templates in multiple contexts
      _for e.g. use input parameters to create generic and reusable templates_
    * Name used for a resource within the template is a logical name but when CloudFormation creates the resource, it generates a physical name that is based on the combination of the logical name, the stack name, and a unique ID
  * **Stacks**
    * Stacks manage related resources as a single unit,
    * Collection of resources can be created, updated, and deleted by creating, updating, and deleting stacks.
    * All the resources in a stack are defined by the stack’s AWS CloudFormation template
    * CloudFormation makes underlying service calls to AWS to provision and configure the resources in the stack and can perform only actions that the users have permission to do.
  * **Change Sets**
    * Change Sets presents a summary of the proposed changes CloudFormation will make when a stack is updated
    * Change Sets help check how the changes might impact running resources, especially critical resources, before implementing them
    * CloudFormation makes the changes to the stack only when the change set is executed, allowing you to decide whether to proceed with the proposed changes or explore other changes by creating another change set
    * Change sets don’t indicate whether AWS CloudFormation will successfully update a stack
      _for e.g. if account limits are hit or the user does not have permission_

## ![](https://i1.wp.com/docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/images/update-stack-changesets-diagram.png?zoom=1.25&w=656&ssl=1)

## CloudFormation Access Control

* **IAM**
  * IAM can be applied with CloudFormation to access control for users whether they can view stack templates, create stacks, or delete stacks
  * **IAM permissions need to be provided to the user to the AWS services and resources provisioned, when the stack is created**
  * Before a stack is created, AWS CloudFormation validates the template to check for IAM resources that it might create
* **Service Role**
  * A service role is an AWS IAM role that allows AWS CloudFormation to make calls to resources in a stack on the user’s behalf
  * By default, AWS CloudFormation uses a temporary session that it generates from the user credentials for stack operations.
  * For a service role, AWS CloudFormation uses the role’s credentials.
  * When a service role is specified, AWS CloudFormation always uses that role for all operations that are performed on that stack.

### Template Resource Attributes

* **CreationPolicy**
  Attribute
  * is invoked during the associated resource creation
  * can be associated with a resource to prevent its status from reaching create complete until AWS CloudFormation receives a specified number of success signals or the timeout period is exceeded
  * helps to wait on resource configuration actions before stack creation proceeds
    _for e.g. software installation on an EC2 instance_
* **DeletionPolicy**
  Attribute
  * preserve or \(in some cases\) backup a resource when its stack is deleted
  * By default, if a resource has no DeletionPolicy attribute, AWS CloudFormation deletes the resource
  * To keep a resource when its stack is deleted,
    * specify **Retain **for that resource, to prevent deletion
    * specify **Snapshot **to create a snapshot before deleting the resource, if the snapshot capability is supported
      _for e.g RDS, EC2 volume etc._
* **DependsOn**
  Attribute
  * helps specify that the creation of a specific resource follows another
  * resource is created only after the creation of the resource specified in the DependsOn attribute
* **Metadata**
  Attribute
  * enables association of structured data with a resource
* **UpdatePolicy**
  Attribute
  * defines AWS CloudFormation handles updates to the AWS::AutoScaling::AutoScalingGroup resource

## Labs

* Qwiklabs Free labs
  * [Launching and Managing a Web Application with AWS CloudFormation](https://qwiklabs.com/focuses/349?locale=en&parent=catalog)



