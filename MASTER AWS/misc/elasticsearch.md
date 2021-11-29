# ElasticSearch

* use cases
  * log analysis
  * search documents
  * .
* Cluster configuration

  * number of instances and types
  * possible to use dedicated master nodes \(yes/no\), more stable.
    * recommended 3 per cluster. don't hold data. they are used as backups 
  * can be distributed across AZs.

* Primary shard and Replica shards can be split across different AZs for reliability

* Loading data using lambda: 
  * post data in cloudwatch logs
  * use lambda to load from cloudwatch to firehose
  * lambda decorator processes firehose with additional data \(e.g. when processing VPC flow logs\)
    * e.g. adding country by querying service for geoip,...
  * then firehose sends data to elasticsearch.

# RStudio

* open source IDE for R
* RStudio Server integrates with Athena, RDS, Redshift, ...
  * needs to install R packages first
* run RStudio in EC2





# AWS Elasticsearch

* Amazon Elasticsearch Service is a managed service that makes it easy to deploy, operate, and scale Elasticsearch clusters in the AWS Cloud.
* Elasticsearch is a popular open-source search and analytics engine for use cases such as log analytics, real-time application monitoring, and clickstream analytics
* Elasticsearch provides
  * real-time, distributed search and analytics engine
  * ability to provision all the resources for Elasticsearch cluster and launches the cluster
  * easy to use cluster scaling options
  * provides self-healing clusters, which automatically detects and replaces failed Elasticsearch nodes, reducing the overhead associated with self-managed infrastructures
  * domain snapshots to back up and restore ES domains and replicate domains across AZs
  * data durability
  * enhanced security with IAM access control
  * node monitoring
  * multiple configurations of CPU, memory, and storage capacity, known as instance types
  * storage volumes for the data using EBS volumes
  * Multiple geographical locations for your resources, known as regions and Availability Zones
  * ability to span cluster nodes across two AZs in the same region, known as zone awareness,  for high availability and redundancy
  * dedicated master nodes to improve cluster stability
  * data visualization using the Kibana tool
  * integration with CloudWatch for monitoring ES domain metrics
  * integration with CloudTrail for auditing configuration API calls to ES domains
  * integration with S3, Kinesis, and DynamoDB for loading streaming data
  * ability to handle structured and Unstructured data
  * HTTP Rest APIs



