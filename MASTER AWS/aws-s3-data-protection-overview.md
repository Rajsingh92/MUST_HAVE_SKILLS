* Amazon S3 provides a S3 data protection using highly **durable **storage infrastructure designed for mission-critical and primary data storage.

* Objects are redundantly stored on multiple devices across multiple facilities in an S3 region.

* Amazon S3 PUT and PUT Object copy operations synchronously store the data across multiple facilities before returning
  SUCCESS.
* Once the objects are stored, S3 maintains its durability by quickly detecting and repairing any lost redundancy.
* S3 also regularly verifies the **integrity **of data stored using checksums. If Amazon S3 detects data corruption, it is repaired using redundant data.
* In addition, S3 calculates checksums on all network traffic to detect corruption of data packets when storing or retrieving data
* Data protection against accidental overwrites and deletions can be added by enabling Versioning to preserve, retrieve and restore every version of the object stored
* S3 also provides the ability to protect data in-transit \(as it travels to and from S3\) and at rest \(while it is stored in S3\)

## Data Protection

### Data in-transit

S2 allows protection of data in-transit by enabling communication via SSL or using client-side encryption

### Data at Rest

* S3 supports both client side encryption and server side encryption for protecting data at rest
* Using Server-Side Encryption, S3 encrypts the object before saving it on disks in its data centers and decrypt it when the objects are downloaded
* Using Client-Side Encryption, you can encrypt data client-side and upload the encrypted data to S3. In this case, you manage the encryption process, the encryption keys, and related tools.

#### Server-Side Encryption

* Server-side encryption is about data encryption at rest
* Server-side encryption encrypts only the object data. Any object metadata is not encrypted.
* S3 handles the encryption \(as it writes to disks\) and decryption \(when you access the objects\) of the data objects
* There is no difference in the access mechanism for both encrypted or unencrypted objects and is handled transparently by S3

##### Server-Side Encryption with Amazon S3-Managed Keys \(SSE-S3\)

* Each object is encrypted with a unique data key employing strong multi-factor encryption.
* SSE-S3 encrypts the data key with a master key that is regularly rotated.
* S3 server-side encryption uses one of the strongest block ciphers available , 256-bit Advanced Encryption Standard \(AES-256\), to encrypt the data.
* Whether or not objects are encrypted with SSE-S3 can’t be enforced when they are uploaded using pre-signed URLs, because the only way you can specify server-side encryption is through the AWS Management Console or through an HTTP request header

##### Server-Side Encryption with AWS KMS-Managed Keys \(SSE-KMS\)

![](https://i0.wp.com/jayendrapatil.com/wp-content/uploads/2016/03/Screen-Shot-2016-11-16-at-5.19.01-PM.png?resize=656%2C165 "Server-Side Encryption with AWS KMS-Managed Keys \(SSE-KMS\)")

* SSE-KMS is similar to SSE-S3, but it uses AWS Key management Services \(KMS\) which provides additional benefits along with additional charges
  * KMS is a service that combines secure, highly available hardware and software to provide a key management system scaled for the cloud.
  * KMS uses customer master keys \(CMKs\) to encrypt the S3 objects.
  * Master key is never made available
  * KMS enables you to centrally create encryption keys, define the policies that control how keys can be used
  * Allows audit use of key usage to prove they are being used correctly, by inspecting logs in AWS CloudTrail
  * Allows keys to temporarily disabled and re-enabled
  * Allows keys to be rotated regularly
  * Security controls in AWS KMS can help meet encryption-related compliance requirements.
* SSE-KMS enables separate permissions for the use of an envelope key \(that is, a key that protects the data’s encryption key\) that provides added protection against unauthorized access of the objects in S3.
* SSE-KMS provides the option to create and manage encryption keys yourself, or use a default customer master key \(CMK\) that is unique to you, the service you’re using, and the region you’re working in.
* Creating and Managing your own CMK gives you more flexibility, including the ability to create, rotate, disable, and define access controls, and to audit the encryption keys used to protect your data.
* Data keys used to encrypt your data are also encrypted and stored alongside the data they protect and are unique to each object
* Process flow
  * An application or AWS service client requests an encryption key to encrypt data and passes a reference to a master key under the account.
  * Client requests are authenticated based on whether they have access to use the master key.
  * A new data encryption key is created, and a copy of it is encrypted under the master key.
  * Both the data key and encrypted data key are returned to the client.
  * Data key is used to encrypt customer data and then deleted as soon as is practical.
  * Encrypted data key is stored for later use and sent back to AWS KMS when the source data needs to be decrypted.

##### Server-Side Encryption with Customer-Provided Keys \(SSE-C\)

![](https://i1.wp.com/jayendrapatil.com/wp-content/uploads/2016/03/Screen-Shot-2016-11-16-at-5.11.02-PM.png?resize=656%2C164 "AWS S3 Server Side Encryption using Customer Provided Keys SSE-C")

* Encryption keys can be managed and provided by the Customer and S3 manages the encryption, as it writes to disks, and decryption, when you access the objects
* When you upload an object, the encryption key is provided as a part of the request and S3 uses that encryption key to apply AES-256 encryption to the data and removes the encryption key from memory.
* When you download an object, the same encryption key should be provided as a part of the request. S3 first verifies the encryption key and if matches decrypts the object before returning back to you
* As each object and each object’s version can be encrypted with a different key, you are responsible for maintaining the mapping between the object and the encryption key used.
* SSE-C request must be done through HTTPS and S3 will reject any requests made over http when using SSE-C.
* For security considerations, AWS recommends to consider any key sent erroneously using http to be compromised and discarded or rotated
* S3 does not store the encryption key provided. Instead, it stores a randomly salted HMAC value of the encryption key which can be used to validate future requests. The salted HMAC value cannot be used to derive the value of the encryption key or to decrypt the contents of the encrypted object. That means, if you lose the encryption key, you lose the object.

#### Client-Side Encryption

Client-side encryption refers to encrypting data before sending it to Amazon S3 and decrypting the data after downloading it

##### AWS KMS-managed customer master key \(CMK\)

* Customer can maintain the encryption CMK with AWS KMS and can provide the CMK id to the client to encrypt the data
* Uploading Object
  * AWS S3 encryption client first sends a request to AWS KMS for the key to encrypt the object data
  * AWS KMS returns a  randomly generated data encryption key with 2 versions a plain text version for encrypting the data and cipher blob to be uploaded with the object as object metadata
  * Client obtains a unique data encryption key for each object it uploads.
  * AWS S3 encryption client uploads the encrypted data and the cipher blob with object metadata
* Download Object
  * AWS Client first downloads the encrypted object from Amazon S3 along with the cipher blob version of the data encryption key stored as object metadata.
  * AWS Client then sends the cipher blob to AWS KMS to get the plain text version of the same, so that it can decrypt the object data.

##### Client-Side master key

* Encryption master keys are completely maintained at Client-side
* Uploading Object
  * Amazon S3 encryption client \(
    _for e.g. AmazonS3EncryptionClient_
    _in the AWS SDK for Java_
    \) locally generates randomly a one-time-use symmetric key \(also known as a data encryption key or data key\).
  * Client encrypts the data encryption key using the customer provided master key
  * Client uses this dataencryption key to encrypt the data of a single S3 object \(for each object, the client generates a separate data key\).
  * Client then uploads the encrypted data to Amazon S3 and also saves the encrypted data key and itsmaterial description  as object metadata \(
    x-amz-meta-x-amz-key
    \) in Amazon S3 by default
* Downloading Object
  * Client first downloads the encrypted object from Amazon S3 along with the object metadata.
  * Using the material description in the metadata, the client first determines which master key to use to decrypt the encrypted data key.
  * Using that master key, the client decrypts the data key and uses it to decrypt the object
* Client-side master keys and your unencrypted data are never sent to AWS
* If the master key is lost the data cannot be decrypted



