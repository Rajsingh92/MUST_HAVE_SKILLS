S3 achieves high availability by replicating data across multiple servers within Amazon’s data centers.

* S3 provides **read-after-write consistency for PUTS of new objects**
  * For a PUT request, S3 synchronously stores data across multiple facilities before returning SUCCESS
  * A process writes a new object to S3 and will be immediately able to read the Object
  * A process writes a new object to S3 and immediately lists keys within its bucket. Until the change is fully propagated, the object might not appear in the list.
* S3 provides **eventual consistency for overwrite PUTS and DELETES **in all regions.
  * For updates and deletes to Objects, the changes are eventually reflected and not available immediately
  * if a process replaces an existing object and immediately attempts to read it. Until the change is fully propagated, S3 might return the prior data
  * if a process deletes an existing object and immediately attempts to read it. Until the deletion is fully propagated, S3 might return the deleted data
  * if a process deletes an existing object and immediately lists keys within its bucket. Until the deletion is fully propagated, S3 might list the deleted object.
* Updates to a single key are atomic. _for e.g., if you PUT to an existing key, a subsequent read might return the old data or the updated data, but it will never write corrupted or partial data._
* S3 does not currently support object locking. _for e.g. If two PUT requests are simultaneously made to the same key, the request with the latest time stamp wins_. If this is an issue, you will need to build an object-locking mechanism into your application.
* Updates are key-based; there is no way to make atomic updates across keys.
  _for e.g, you cannot make the update of one key dependent on the update of another key unless you design this functionality into your application._



