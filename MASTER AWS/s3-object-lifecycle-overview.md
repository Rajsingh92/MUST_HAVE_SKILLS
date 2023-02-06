S3 Object lifecycle can be managed by using a lifecycle configuration, which defines how S3 manages objects during their lifetime.

* Lifecycle configuration enables simplification of object lifecycle management, 
  _for e.g. moving of less frequently access objects, backup or archival of data for several years or permanent deletion of objects,_
  all transitions can be controlled automatically
* 1000 lifecycle rules can be configured per bucket
* S3 Object Lifecycle Management rules applied to an bucket are applicable to all the existing objects in the bucket as well as the ones that will be added anew
* S3 Object lifecycle management allows 2 types of behavior
  * **Transition**
    in which the storage class for the objects change
  * **Expiration**
    where the objects are permanently deleted
* Lifecycle Management can be configured with [Versioning](http://jayendrapatil.com/aws-s3-object-versioning/), which allows storage of one current object version and zero or more non current object versions
* Object’s lifecycle management applies to both Non Versioning and Versioning enabled buckets
* For Non Versioned buckets
  * Transitioning period is considered from the object’s creation date
* For Versioned buckets,
  * Transitioning period for current object is calculated for the object creation date
  * Transitioning period for non current object is calculated for the date when the object became a noncurrent versioned object
  * S3 uses the number of days since its successor was created as the number of days an object is noncurrent.
* S3 calculates the time by adding the number of days specified in the rule to the object creation time and rounding the resulting time to the next day midnight UTC.
  _For e.g., if an object was created at 15/1/2016 10:30 AM UTC and you specify 3 days in a transition rule, which results in 18/1/2016 10:30 AM UTC and rounded of to next day midnight time 19/1/2016 00:00 UTC_
  .
* Lifecycle configuration on MFA-enabled buckets is not supported.

## S3 Object Lifecycle Management Rules

1. STANDARD or REDUCED\_REDUNDANCY -&gt; \(128 KB & 30 days\) -&gt;STANDARD\_IA
   * Only objects with size more than 128 KB can be transitioned, as cost benefits for transitioning to STANDARD\_IA can be realized only for larger objects
   * Objects must be stored for at least 30 days in the current storage class before being transitioned to the STANDARD\_IA, as younger objects are accessed more frequently or deleted sooner than is suitable for STANDARD\_IA
2. STANDARD\_IA -&gt;**X**-&gt;STANDARD or REDUCED\_REDUNDANCY
   * Cannot transition from STANDARD\_IA to STANDARD or REDUCED\_REDUNDANCY
3. STANDARD or REDUCED\_REDUNDANCY or STANDARD\_IA -&gt;GLACIER
   * Any Storage class can be transitioned to GLACIER
4. STANDARD or REDUCED\_REDUNDANCY -&gt;\(1 day\) -&gt;GLACIER
   * Transitioning from Standard or RRS to Glacier can be done in a day
5. STANDARD\_IA -&gt;\(30 days\) -&gt;GLACIER
   * Transitioning from Standard IA to Glacier can be done only after 30 days or 60 days from the object creation date or non current version date
6. GLACIER-&gt;**X**-&gt;STANDARD or REDUCED\_REDUNDANCY or STANDARD\_IA
   * Transition of objects to the GLACIER storage class is one-way
   * Cannot transition from GLACIER to any other storage class.
7. GLACIER -&gt;\(90 days\) -&gt;Permanent Deletion
   * Deleting data that is archived to Glacier is free, if the objects you delete are archived for three months or longer.
   * Amazon S3 charges a prorated early deletion fee, if the object is deleted or overwritten within three months of archiving it.
8. STANDARD or STANDARD\_IA or GLACIER -&gt;**X**-&gt;REDUCED\_REDUNDANCY
   * Cannot transition from any storage class to REDUCED\_REDUNDANCY.
9. Archival of objects to Amazon Glacier by using object lifecycle management is performed asynchronously and there may be a delay between the transition date in the lifecycle configuration rule and the date of the physical transition. However, AWS charges Amazon Glacier prices based on the transition date specified in the rule
10. For a versioning-enabled bucket
    * Transition and Expiration actions apply to current versions.
    * NoncurrentVersionTransition and NoncurrentVersionExpiration actions apply to noncurrent  versions and works similar to the non versioned objects except the time period is from the time the objects became noncurrent
11. Expiration Rules
    * For Non Versioned bucket
      * Object is permanently deleted
    * For Versioned bucket
      * Expiration is applicable to the Current object only and does not impact any of the non current objects
      * S3 will insert a Delete Marker object with unique id and the previous current object becomes a non current version
      * S3 will not take any action if the Current object is a Delete Marker
      * If the bucket has a single object which is the Delete Marker \(referred to as expired object delete marker\), S3 removes the Delete Marker
    * For Versioned Suspended bucket
      * S3 will insert a Delete Marker object with version ID null and overwrite the any object with version ID null
12. When an object reaches the end of its lifetime, Amazon S3 queues it for removal and removes it asynchronously. There may be a delay between the expiration date and the date at which S3 removes an object.You are not charged for storage time associated with an object that has expired.
13. There are additional cost considerations if you put lifecycle policy to expire objects that have been in STANDARD\_IA for less than 30 days, or GLACIER for less than 90 days.



