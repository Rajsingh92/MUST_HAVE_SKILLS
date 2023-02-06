S3 Object Versioning can be used to protect from unintended overwrites and deletions

* Versioning helps to keep multiple variants of an object in the same bucket and can be used to preserve, retrieve, and restore every version of every object stored in your Amazon S3 bucket.
* As Versioning maintains multiple copies of the same objects as whole and you accrue charges for multiple versions 
  _for e.g. for a 1GB file with 5 copies with minor differences would consume 5GB of S3 storage space and you would be charged for the same._
* Versioning is not enabled by default and has to be explicitly enabled for each bucket
* Versioning once enabled, cannot be disabled and can only be suspended
* Versioning enabled on a bucket applies to all the objects within the bucket
* Permissions are set at the version level. Each version has its own object owner; an AWS account that creates the object version is the owner. So, you can set different permissions for different versions of the same object.
* Irrespective of the Versioning, each object in the bucket has a version.
  * For Non Versioned bucket, the version ID for each object is null
  * For Versioned buckets, a unique version ID is assigned to each object
* With Versioning, version ID forms a key element to define uniqueness of an object within an bucket along with the bucket name and object key
* Object Retrieval
  * For Non Versioned bucket
    * An Object retrieval always return the only object available
  * For Versional bucket
    * An object retrieval returns the Current object.
    * Non Current object can be retrieved by specifying the version ID.
* Object Addition
  * For Non Versioned bucket
    * If an object with the same key is uploaded again it overwrites the object
  * For Versioned bucket
    * If an object with the same key is uploaded the new uploaded object becomes the Current version and the previous object becomes the Non current version.
    * A non current versioned object can be retrieved and restored hence protecting against **accidental overwrites**
* When an object in a bucket is deleted
  * For Non Versioned bucket
    * An object is permanently deleted and cannot be recovered
  * For Versioned bucket,
    * All versions remain in the bucket and Amazon inserts a delete marker which becomes the Current version
    * A non current versioned object can be retrieved and restored hence protecting against **accidental overwrites**
    * If a Object with a specific version ID is deleted, a permanent deletion happens and the object cannot be recovered
* Delete marker
  * Delete Marker object does not have any data or acl associated with it, just the key and the version ID
  * An object retrieval on a bucket with delete marker as the Current version would return a 404
  * Only a DELETE operation is allowed on the Delete Marker object
  * If the Delete marker object is deleted by specifying its version ID, the previous non current version object becomes the current version object
  * If a DELETE request is fired on the Bucket with Delete Marker as the current version, the Delete marker object is not deleted but an Delete Marker is added again
* Restoring Previous Versions
  * Copy a previous version of the object into the same bucket. Copied object becomes the current version of that object and all object versions are preserved – **Recommended **as you still keep all the versions
  * Permanently delete the current version of the object. When you delete the current object version, you, in effect, turn the previous version into the current version of that object.
* Versioning Suspended Bucket
  * Versioning can be suspended to stop accruing new versions of the same object in a bucket
  * Existing objects in your bucket do not change and only future requests behavior changes
  * For each new object addition, a object with version ID null is added.
  * For each object addition with the same key name, the object with the version ID null is overwritten
  * An object retrieval request will always return the current version of the object
  * A DELETE request on the bucket, would permanently delete the version ID null object and inserts a Delete Marker
  * A DELETE request does not delete anything if the bucket does not have an object with version ID null
  * A DELETE request can still be fired with a specific version ID for any previous object with version IDs stored
* MFA Delete
  * Additional security can be enabled by configuring a bucket to enable MFA \(Multi-Factor Authentication\) delete
  * MFA Delete can be enabled on a bucket to ensure that data in your bucket cannot be **accidentally deleted**
  * While the bucket owner, the AWS account that created the bucket \(root account\), and all authorized IAM users can enable versioning, but only the **bucket owner \(root account\) can enable MFA delete**
    .



