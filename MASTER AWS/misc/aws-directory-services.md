# AWS Directory Services

* AWS Directory Service is a managed service offering, providing directories that contain information about the organization, including users, groups, computers, and other resources
* AWS Directory Services provides multiple ways including
  * Simple AD as a standalone directory service
  * AD Connector to use On-Premise Microsoft Active Directory with other AWS services.
  * AWS Directory Service for Microsoft Active Directory \(Enterprise Edition\), also referred to as Microsoft AD

## Simple AD

* is a Microsoft Active Directory compatible directory from AWS Directory Service that is powered by Samba 4
* is the least expensive option and the best choice if there are 5,000 or fewer users & don’t need the more advanced Microsoft Active Directory features
* supports commonly used Active Directory features such as user accounts, group memberships, domain-joining EC2 instances running Linux and Windows, kerberos-based single sign-on \(SSO\), and group policies
* does not support features like DNS dynamic update, schema extensions, multi-factor authentication, communication over LDAPS, PowerShell AD cmdlets, and the transfer of FSMO roles
* provides daily automated snapshots to enable point-in-time recovery
* However, Trust relationships cannot be setup between Simple AD and other Active Directory domains.

## AD Connector

* helps connect to an existing on-premises Active Directory to AWS
* is the best choice to leverage existing on-premises directory with AWS services
* is a proxy service for connecting on-premises Microsoft Active Directory to AWS without requiring complex directory synchronization technologies or the cost and complexity of hosting a federation infrastructure
* forwards sign-in requests to the Active Directory domain controllers for authentication and provides the ability for applications to query the directory for data
* enables consistent enforcement of existing security policies, such as password expiration, password history, and account lockouts, whether users are accessing resources on premises or in the AWS cloud

## Microsoft Active Directory \(Enterprise Edition\)

* is a feature-rich managed Microsoft Active Directory hosted on the AWS
* is the best choice if there are more than 5,000 users and need a trust relationship set up between an AWS hosted directory and on-premises directories.
* provides much of the functionality offered by Microsoft Active Directory plus integration with AWS applications

## Microsoft AD connectivity options

* If the VGW used to connect to the On-Premise AD is not stable or has connectivity issues, the following options can be explored
  * Simple AD
    * least expensive option
    * provides an standalone instance for the Microsoft AD in AWS
    * No single point of Authentication or Authorization, as a separate copy is maintained
    * trust relationships cannot be setup between Simple AD and other Active Directory domains
  * Read-only Domain Controllers \(RODCs\)
    * works out as a Read-only Active Directory
    * holds a copy of the Active Directory Domain Service \(AD DS\) database and respond to authentication requests
    * are typically deployed in locations where physical security cannot be guaranteed
    * they cannot be written to by applications or other servers.
    * helps maintain a single point to authentication & authorization controls, however needs to be synced
  * Writable Domain Controllers
    * are expensive to setup
    * operate in a multi-master model; changes can be made on any writable server in the forest, and those changes are replicated to servers throughout the entire forest



