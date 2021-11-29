**Q: How do I get started with IAM?**

To start using IAM, you must subscribe to at least one of the AWS services that is integrated with IAM. You then can create and manage users, groups, and permissions via IAM APIs, the AWS CLI, or the IAM console, which gives you a point-and-click, web-based interface. You can also use the visual editor to create policies.

**Q: How are IAM users managed?**  
IAM supports multiple methods to:

* Create and manage IAM users.
* Create and manage IAM groups.
* Manage users' security credentials.
* Create and manage policies to grant access to AWS services and resources.

You can create and manage users, groups, and policies by using IAM APIs, the [AWS CLI](http://aws.amazon.com/cli/), or the[IAM console](https://console.aws.amazon.com/iam/home). You also can use the[visual editor](https://docs.aws.amazon.com/console/iam/create-policies)and the [IAM policy simulator](https://policysim.aws.amazon.com/)to create and test policies.

**Q: What kinds of security credentials can IAM users have?**

IAM users can have any combination of credentials that AWS supports, such as an AWS access key, X.509 certificate, SSH key, password for web app logins, or an[MFA](https://amazonaws-china.com/identity/saml/)device. This allows users to interact with AWS in any manner that makes sense for them. An employee might have both an AWS access key and a password; a software system might have only an AWS access key to make programmatic calls; IAM users might have a private SSH key to access AWS CodeCommit repositories; and an outside contractor might have only an X.509 certificate to use the EC2 command-line interface. For details, see [Temporary Security Credentials](http://docs.aws.amazon.com/IAM/latest/UserGuide/Using_ManagingLogins.html) in the IAM documentation.

**Q: Where can I use my SSH keys?**

Currently, IAM users can use their SSH keys only with AWS CodeCommit to access their repositories.

**Q: How are user passwords set?**

You can set an initial password for an IAM user via the [IAM console](https://console.aws.amazon.com/iam/home) [AWS CLI](http://amazonaws-china.com/cli/), or IAM APIs. User passwords never appear in clear text after the initial provisioning, and are never displayed or returned via an API call. IAM users can manage their passwords via the **My Password **page in the IAM console. Users access this page by selecting the **Security Credentials **option from the drop-down list in the upper right corner of the AWS Management Console.

**Q: Can I define a password policy for my user’s passwords?**

Yes, you can enforce strong passwords by requiring minimum length or at least one number. You can also enforce automatic password expiration, prevent re-use of old passwords, and require a password reset upon the next AWS sign-in.

**Q: What is an IAM role?**

An IAM role is an IAM entity that defines a set of [permissions](https://amazonaws-china.com/iam/details/manage-permissions/) for making AWS service requests. IAM roles are not associated with a specific user or group. Instead, trusted entities assumeroles, such as IAM users, applications, or AWS services such as EC2.

**Q: How many IAM roles can I assume?**

There is no limit to the number of IAM roles you can assume, but you can only act as one IAM role when making requests to AWS services.

**Q: How many policies can I attach to an IAM role?**

**For**[**inline policies**](http://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_managed-vs-inline.html)**:**You can add as many inline policies as you want to a user, role, or group, but the total aggregate policy size \(the sum size of all inline policies\) per entity cannot exceed the following limits:

* User policy size cannot exceed 2,048 characters.
* Role policy size cannot exceed 10,240 characters.
* Group policy size cannot exceed 5,120 characters.

**Q: How many IAM roles can I create?**

You are limited to 1,000 IAM roles under your AWS account. If you need more roles, submit the [IAM limit increase request form](https://portal.aws.amazon.com/gp/aws/html-forms-controller/iam-limit-increase-request) with your use case, and we will consider your request.

**Q: What are the features of IAM roles for EC2 instances?**

IAM roles for EC2 instances provides the following features:

* AWS temporary security credentials to use when making requests from running EC2 instances to AWS services.
* Automatic rotation of the AWS temporary security credentials.
* Granular AWS service permissions for applications running on EC2 instances.

**Q: Can I associate an IAM role with an Auto Scaling group?**

Yes. You can add an IAM role as an additional parameter in an Auto Scaling launch configuration and create an Auto Scaling group with that launch configuration. All EC2 instances launched in an Auto Scaling group that is associated with an IAM role are launched with the role as an input parameter.

**Q: What's default client's credential search chain?**

the client will search for credentials using the_default credentials provider chain_, in the following order:

1. In system environment variables:`AWS_ACCESS_KEY_ID`and`AWS_SECRET_ACCESS_KEY`.

2. In the Java system properties:`aws.accessKeyId`and`aws.secretKey`.

3. In the default credentials file \(the location of this file varies by platform\).

4. In the_instance profile credentials_, which exist within the instance metadata associated with the IAM role for the EC2 instance.

**Q: Which permissions are required to launch EC2 instances with an IAM role?**  
You must grant an IAM user two distinct permissions to successfully launch EC2 instances with roles:

* Permission to launch EC2 instances.
* Permission to associate an IAM role with EC2 instances.

**Q: Who can access the access keys on an EC2 instance?**

Any local user on the instance can access the access keys associated with the IAM role.

**Q: How do I use the IAM role with my application on the EC2 instance?**  
If you develop your application with the AWS SDK, the AWS SDK automatically uses the AWS access keys that have been made available on the EC2 instance. If you are not using the AWS SDK, you can retrieve the access keys from the[EC2 instance metadata service](http://docs.amazonwebservices.com/AWSEC2/latest/UserGuide/AESDG-chapter-instancedata.html). For details, see[Using an IAM Role to Grant Permissions to Applications Running on Amazon EC2 Instances.](http://docs.aws.amazon.com/IAM/latest/UserGuide/role-usecase-ec2app.html)

**Q: How do I rotate the temporary security credentials on the EC2 instance?**  
The AWS temporary security credentials associated with an IAM role are automatically rotated multiple times a day. New temporary security credentials are made available no later than five minutes before the existing temporary security credentials expire.

**Q: Can I use IAM roles for EC2 instances with any instance type or Amazon Machine Image?**  
Yes. IAM roles for EC2 instances also work in Amazon Virtual Private Cloud \(VPC\), with spot and reserved instances.

**Q: How do permissions work?**

Access control policies are attached to users, groups, and roles to assign permissions to AWS resources. By default, IAM users, groups, and roles have no permissions; users with sufficient permissions must use a policy to grant the desired permissions.

**Q: How do I assign commonly used permissions?**

AWS provides a set of commonly used permissions that you can attach to IAM users, groups, and roles in your account. These are called AWS managed policies. One example is read-only access for Amazon S3. When AWS updates these policies, the permissions are applied automatically to the users, groups, and roles to which the policy is attached. AWS managed policies automatically appear in the**Policies**section of the IAM console. When you assign permissions, you can use an AWS managed policy or you can create your own customer managed policy. Create a new policy based on an existing AWS managed policy, or define your own.

**Q: How are IAM policies evaluated in conjunction with Amazon S3, Amazon SQS, Amazon SNS, and AWS KMS resource-based policies?**

IAM policies are evaluated together with the service’s resource-based policies. When a policy of any type grants access \(without explicitly denying it\), the action is allowed. For more information about the policy evaluation logic, see[IAM Policy Evaluation Logic](http://docs.aws.amazon.com/IAM/latest/UserGuide/AccessPolicyLanguage_EvaluationLogic.html).

**Q: Can I use a managed policy as a resource-based policy?**

Managed policies can only be attached to IAM users, groups, or roles. You cannot use them as resource-based policies.

**Q: How do I set granular permissions using policies?**

Using policies, you can specify several layers of permission granularity. First, you can define specific AWS service actions you wish to allow or explicitly deny access to. Second, depending on the action, you can define specific AWS resources the actions can be performed on. Third, you can define conditions to specify when the policy is in effect \(for example, if MFA is enabled or not\).**Q: Can I grant permissions to access or change account-level information \(for example, payment instrument, contact email address, and billing history\)?**

Yes, you can delegate the ability for an IAM user or a federated user to view AWS billing data and modify AWS account information. For more information about controlling access to your billing information, see[Controlling Access](http://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/control-access-billing.html).**Q: Who can create and manage access keys in an AWS account?**

Only the AWS account owner can manage the access keys for the root account. The account owner and IAM users or roles that have been granted the necessary permissions can manage access keys for IAM users.

**Q: Can I grant permissions to access AWS resources owned by another AWS account?**

Yes. Using IAM roles, IAM users and federated users can access resources in another AWS account via the AWS Management Console, the AWS CLI, or the APIs. See [Manage IAM Roles](http://amazonaws-china.com/iam/details/manage-roles/) for more information.

**Q: What kinds of policies does the IAM policy simulator support?**

The policy simulator supports testing of newly entered policies and existing policies attached to users, groups, or roles. In addition, you can simulate whether resource-level policies grant access to a particular resource for Amazon S3 buckets, Amazon Glacier vaults, Amazon SNS topics, and Amazon SQS queues. These are included in the simulation when an Amazon Resource Name \(ARN\) is specified in the **Resource **field in **Simulation Settings **for a service that supports resource policies

**Q: If I change a policy in the policy simulator, do those changes persist in production?**  
No. To apply changes to production, copy the policy that you’ve modified in the policy simulator and attach it to the desired IAM user, group, or role.

**Q: Can I use the policy simulator programmatically?**  
Yes. You can use the policy simulator using the AWS SDKs or AWS CLI in addition to the policy simulator console. Use the [iam:SimulatePrincipalPolicy](http://docs.aws.amazon.com/IAM/latest/APIReference/API_SimulatePrincipalPolicy.html)API to programmatically test your existing IAM policies. To test the effects of new or updated policies that are not yet attached to a user, group, or role, call the[iam:SimulateCustomPolicy](http://docs.aws.amazon.com/IAM/latest/APIReference/API_SimulateCustomPolicy.html)API.

**Q: Which AWS sites can IAM users access?**

IAM users can sign in to the following AWS sites:

* [AWS Management Console](https://console.aws.amazon.com/)
* [AWS Forums](https://forums.aws.amazon.com/)
* [AWS Support Center](https://amazonaws-china.com/support)
* [AWS Marketplace](https://amazonaws-china.com/marketplace)

**Q: Can a temporary security credential be revoked prior to its expiration?**  
No. When requesting temporary credentials, we recommend the following:

* When creating temporary security credentials, set the expiration to a value that is appropriate for your application.
* Because root account permissions cannot be restricted, use an IAM user and not the root account for creating temporary security credentials. You can revoke permissions of the IAM user that issued the original call to request it. This action almost immediately revokes privileges for all temporary security credentials issued by that IAM user

**Q: Are IAM actions logged for auditing purposes?**

  


Yes. You can log IAM actions, STS actions, and AWS Management Console sign-ins by activating AWS CloudTrail. To learn more about AWS logging, see 

[AWS CloudTrail](http://amazonaws-china.com/cloudtrail/)

.**Q. Can I have multiple MFA devices active for my AWS account?**  
Yes. Each IAM user can have its own MFA device. However, each identity \(IAM user or root account\) can be associated with only one MFA device.  


**Q. Can I use my U2F security key with multiple AWS accounts?**

Yes. AWS allows you to use the same U2F security key with several root and IAM users across multiple accounts.



