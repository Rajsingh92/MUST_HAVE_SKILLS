# AWS CloudSearch

* CloudSearch is a fully-managed, full-featured search service in the AWS Cloud that makes it easy to set up, manage, and scale a search solution
* CloudSearch
  * automatically provisions the required resources
  * deploys a highly tuned search index
  * easy configuration and can be up & running in less than one hour
  * search and ability to upload searchable data
  * automatically scales for data and traffic
  * self-healing clusters, and
  * high availability with Multi-AZ
* CloudSearch uses Apache Solr as the underlying text search engine and
  * can be used to index and search both structured and unstructured data.
  * content can come from multiple sources and can include database fields along with files in a variety of formats, web pages, and so on.
  * supports indexing features like algorithmic stemming, dictionary stemming, stopword dictionary
  * can support customizable result ranking i.e. relevancy
  * supports search features for text search, different query types \(range, boolean etc\), sorting, facets for filtering, grouping etc
  * supports enhanced features for auto suggestions, highlighting, spatial search, fuzzy search etc
* CloudSearch supports Multi-AZ option and it deploys additional instances in a second AZ in the same region.
* CloudSearch can offer significantly lower total cost of ownership compared to operating and managing your own search environment

## CloudSearch Search Domains, Data & Indexing

![](https://i0.wp.com/d0.awsstatic.com/whiteboard-graphics/products/CloudSearch/cloudsearcharchitecture.png?zoom=1.25&resize=656%2C492&ssl=1 "CloudSearch Architecture")

* Search domain is a data container and a set of services that make the data searchable
  * Document service that allows data uploading to domain for indexing
  * Search service that enables search requests against the indexed data
  * Configuration service for controlling the domains behavior \(include relevance ranking\)
* Search domain can’t be automatically migrated from one region to another. New domain in the target region needs to be created, configured and data uploaded, and then the original domain deleted
* Indexed data to be made searchable
  * can be submitted through a REST based web service url
  * has to be in JSON or XML format
  * is represented as a document with a unique document ID and multiple fields either to be search on to needed to be just retrieved
* CloudSearch generates a search index from the document data according to the index fields configured for the domain
* Data updates can be submitted by to add, update and delete documents
* Data can be uploaded using secure and encrypted SSL HTTPS connection

## CloudSearch Auto Scaling

![](https://i0.wp.com/d0.awsstatic.com/whiteboard-graphics/products/CloudSearch/CloudSearchScaling.png?zoom=1.25&resize=656%2C398&ssl=1 "CloudSearch Scaling")

* Search domains scale in two dimensions: data and traffic
* A search instance is a single search engine in the cloud that indexes documents and responds to search requests with a finite amount of RAM and CPU resources for indexing data and processing requests.
* Search domain can have one or more search partitions, portion of the data which fits on a single search instance, and the number of search partitions can change as the documents are indexed
* CloudSearch can determine the size and number of search instances required to deliver low latency, high throughput search performance
* When a search domain is created , a single instance is deployed
* CloudSearch automatically scales the domain by adding instances as the volume of data or traffic increases
* **Scaling for data**
  * CloudSearch handles scaling for data by
    * Vertical scaling by increasing the size of the instance, when the amount of data exceeds a single search instance
    * Horizontal scaling using search partitions, when the amount of data exceeds the capacity of the largest search instance type
  * Number of search instances required to hold the index partitions is sometimes referred to as the domain’s width.
  * CloudSearch reduces the number of partitions and size of search instances if the amount of data reduces
* **Scaling for traffic**
  * CloudSearch handles Scaling for traffic by
    * Vertical scaling by increasing the size of the instance, when the amount of traffic exceeds a single search instance
    * Horizontal scaling by deploying a duplicate search instance to provide additional processing power i.e. the complete number of partitions are duplicated
  * CloudSearch reduces the number of partitions and size of search instances if the traffic reduces
  * Number of duplicate search instances is sometimes referred to as the domain’s
    depth
    .

## CloudSearch Search Features

* CloudSearch provides features to index and search both structured data and plain text as well as unstructured data like pdf, word documents
* CloudSearch provides near real-time indexing for document updates
* Indexing features include
  * tokenization,
  * stopwords,
  * stemming and
  * synonyms
* Search features include
  * faceted search, free text search, Boolean search expressions,
  * customizable relevance ranking, query time rank expressions,
  * grouping
  * field weighting, searching and sorting
  * Other features like
    * Autocomplete suggestions
    * Highlighting
    * Geospatial search
    * New data types: date, double, 64 bit signed int, LatLon
    * Dynamic fields
    * Index field statistics
    * Sloppy phrase search
    * Term boosting
    * Enhanced range searching for all field types
    * Search filters that don’t affect relevance
    * Support for multiple query parsers: simple, structured, lucene, dismax
    * Query parser configuration options



