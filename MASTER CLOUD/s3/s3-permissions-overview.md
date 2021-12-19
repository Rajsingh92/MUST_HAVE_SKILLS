By default, all S3 buckets, objects and related subresources are private

* User is the AWS Account or the IAM user who access the resource
* Bucket owner is the AWS account that created a bucket
* Object owner is the AWS account that uploads the object to a bucket, not owned by the account
* Only the Resource owner, the AWS account that creates the resource, can access the resource
* Resource owner can be
  * AWS account that creates the bucket or object owns those resources
  * If an IAM user creates the bucket or object, the AWS account of the IAM user owns the resource
  * If the bucket owner grants cross-account permissions to other AWS account users to upload objects to the buckets, the objects are owned by the AWS account of the user who uploaded the object and not the bucket owner except for the following conditions
    * Bucket owner can deny access to the object, as its still the bucket owner who pays for the object
    * Bucket owner can delete or apply archival rules to the object and perform restoration

## S3 Permissions Classification

S3 permissions are classified into Resource based policies and User policies

### User policies

* User based policies use IAM with S3 to control the type of access a user or group of users has to specific parts of an S3 bucket the AWS account owns
* User based policy is always attached to an User, Group or a Role, anonymous permissions cannot be granted
* If an AWS account that owns a bucket wants to grant permission to users in its account, it can use either a bucket policy or a user policy

### Resource based policies

Bucket policies and access control lists \(ACLs\) are resource-based because they are attached to the Amazon S3 resources

![](/assets/s3-doc-permission1.png)

Bucket Policy & Bucket ACL

#### **Bucket Policies**

* Bucket policy can be used to grant cross-account access to
  **other AWS accounts or IAM users in other accounts**
   for the bucket and objects in it.
* Bucket policies provide centralized, access control to buckets and objects based on a variety of conditions, including S3 operations, requesters, resources, and aspects of the request \(e.g. IP address\)
* If an AWS account that owns a bucket wants to grant permission to users in its account, it can use either a bucket policy or a user policy
* Permissions attached to a bucket apply to all of the objects in that bucket created and owned by the bucket owner
* Policies can either add or deny permissions across all \(or a subset\) of objects within a bucket
* Only the bucket owner is allowed to associate a policy with a bucket

#### **Access Control Lists \(ACLs\)**

* Each bucket and object has an ACL associated with it.
* An ACL is a list of grants identifying grantee and permission granted
* ACLs are used to grant basic read/write permissions on resources to **other AWS accounts**
  .
* ACL supports limited permissions set and
  * cannot grant conditional permissions, nor can you explicitly deny permissions
  * cannot be used to grant permissions for bucket subresources
* Permission can be granted to an AWS account by the email address or the canonical user ID \(is just an obfuscated Account Id\). If an email address is provided, S3 will still find the canonical user ID for the user and add it to the ACL.
* It is Recommended to use Canonical user ID as email address would not be supported
* **Bucket ACL**
  * Only recommended use case for the bucket ACL is to grant write permission to S3 Log Delivery group to write access log objects to the bucket
  * Bucket ACL will help grant write permission on the bucket to the Log Delivery group if access log delivery is needed to your bucket
  * **Only way you can grant necessary permissions to the Log Delivery group is via a bucket ACL**
* **Object ACL**
  * Object ACLs control only Object-level Permissions
  * Object ACL is the
    **only way to manage permission to an object in the bucket not owned by the bucket owner**
    i.e. If the bucket owner allows cross-account object uploads and if the object owner is different from the bucket owner, the only way for the object owner to grant permissions on the object is through Object ACL
  * If the Bucket and Object is owned by the same AWS account, Bucket policy can be used to manage the permissions
  * If the Object and User is owned by the same AWS account, User policy can be used to manage the permissions

### Amazon S3 Request Authorization

When Amazon S3 receives a request, it must evaluate all the user policies, bucket policies and acls to determine whether to authorize or deny the request.

#### **S3 evaluates the policies in 3 context**

* **User context**
  is basically the context in which S3 evaluates the User policy that the parent AWS account \(context authority\) attaches to the user
* **Bucket context**
  is the context in which S3 evaluates the access policies owned by the bucket owner \(context authority\) to check if the bucket owner has not explicitly denied access to the resource
* **Object context**
  is the context where S3 evaluates policies owned by the Object owner \(context authority\)

#### Analogy

* Consider 3 Parents \(AWS Account\) A, B and C with Child \(IAM User\) AA, BA and CA respectively
* Parent A owns a Toy box \(Bucket\) with Toy AAA and also allows toys \(Objects\) to be dropped and picked up
* Parent A can grant permission \(User Policy OR Bucket policy OR both\) to his Child AA to access the Toy box and the toys
* Parent A can grant permissions \(Bucket policy\) to Parent B \(different AWS account\) to drop toys into the toys box. Parent B can grant permissions \(User policy\) to his Child BA to drop Toy BAA
* Parent B can grant permissions \(Object ACL\) to Parent A to access Toy BAA
* Parent A can grant permissions \(Bucket Policy\) to Parent C to pick up the Toy AAA who in turn can grant permission \(User Policy\) to his Child CA to access the toy
* Parent A can grant permission \(through IAM Role\) to Parent C to pick up the Toy BAA who in turn can grant permission \(User Policy\) to his Child CA to access the toy

#### Bucket Operation Authorization

![](/assets/s3-doc-permission2.png)

1. If the requester is an IAM user, the user must have permission \(User Policy\) from the parent AWS account to which it belongs
2. Amazon S3 evaluates a subset of policies owned by the parent account. This subset of policies includes the user policy that the parent account attaches to the user.
3. If the parent also owns the resource in the request \(in this case, the bucket\), Amazon S3 also evaluates the corresponding resource policies \(bucket policy and bucket ACL\) at the same time.
4. Requester must also have permissions \(Bucket Policy or ACL\) from the bucket owner to perform a specific bucket operation.
5. Amazon S3 evaluates a subset of policies owned by the AWS account that owns the bucket. The bucket owner can grant permission by using a bucket policy or bucket ACL.
6. Note that, if the AWS account that owns the bucket is also the parent account of an IAM user, then it can configure bucket permissions in a user policy or bucket policy or both

#### Object Operation Authorization

![](/assets/s3-doc-permission3.png)

1. If the requester is an IAM user, the user must have permission \(User Policy\) from the parent AWS account to which it belongs.
2. Amazon S3 evaluates a subset of policies owned by the parent account. This subset of policies includes the user policy that the parent attaches to the user.
3. If the parent also owns the resource in the request \(bucket, object\), Amazon S3 evaluates the corresponding resource policies \(bucket policy, bucket ACL, and object ACL\) at the same time.
4. If the parent AWS account owns the resource \(bucket or object\), it can grant resource permissions to its IAM user by using either the user policy or the resource policy.
5. S3 evaluates policies owned by the AWS account that owns the bucket.
6. If the AWS account that owns the object in the request is not same as the bucket owner, in the bucket context Amazon S3 checks the policies if the bucket owner has explicitly denied access to the object.
7. If there is an explicit deny set on the object, Amazon S3 does not authorize the request.
8. Requester must have permissions from the object owner \(Object ACL\) to perform a specific object operation.
9. Amazon S3 evaluates the object ACL.
10. If bucket and object owners are the same, access to the object can be granted in the bucket policy, which is evaluated at the bucket context.
11. If the owners are different, the object owners must use an object ACL to grant permissions.
12. If the AWS account that owns the object is also the parent account to which the IAM user belongs, it can configure object permissions in a user policy, which is evaluated at the user context.

**Permission Delegation**

* If an AWS account owns a resource, it can grant those permissions to another AWS account.
* That account can then delegate those permissions, or a subset of them, to users in the account. This is referred to as permission delegation.
* But an account that receives permissions from another account cannot delegate permission cross-account to another AWS account.
* If the Bucket owner wants to grant permission to the Object which does not belong to it to an other AWS account it cannot do it through cross-account permissions and need to define a IAM role which can be assumed by the AWS account to gain access



