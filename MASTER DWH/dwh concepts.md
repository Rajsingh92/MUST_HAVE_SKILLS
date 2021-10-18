1. Data Warehouse
- is Data Warehouse still relevent in the age of Big Data?
The original intent of the data warehouse was to segregate analytical operations from mainframe transaction processing in order to avoid 
slowdowns in transaction response times, and minimize the increased CPU costs accrued by running ad hoc queries and creating and 
distributing reports. Over time, the enterprise data warehouse became a core component of information architectures, and it's now rare 
to find a mature business that doesn't employ some form of an EDW or a collection of smaller data marts to support business intelligence, 
reporting and analytics applications.



- Why do we need dwh?
The concept of data warehousing is not hard to understand. The notion is to create a permanent storage space for the data needed to 
support reporting, analysis, and other BI functions.



- what is data warehousing?
A data warehouse is a relational database that is designed for query and analysis rather than for transaction processing. It usually 
contains historical data derived from transaction data, but it can include data from other sources. It separates analysis workload from 
transaction workload and enables an organization to consolidate data from several sources.
In addition to a relational database, a data warehouse environment includes an extraction, transportation, transformation, and 
loading (ETL) solution, an online analytical processing (OLAP) engine, client analysis tools, and other applications that manage the 
process of gathering data and delivering it to business users.



-  Characterstics of dwh?
A common way of introducing data warehousing is to refer to the characteristics of a data warehouse as set forth by 
William (Bill) Inmon:

•Subject Oriented
•Integrated
•Nonvolatile
•Time Variant



- Business Intelligence
Business intelligence (BI) is a technology-driven process for analyzing data and presenting actionable information to help corporate executives, business managers and other end users make more informed business decisions.
Business intelligence (BI) is the use of computing technologies for the identification, discovery and analysis of business data - like sales revenue, products, costs and incomes.
BI technologies provide current, historical and predictive views of internally structured data for products and departments by establishing more effective decision-making and strategic operational insights through functions like online analytical processing (OLAP, 
reporting, predictive analytics, data/text mining, bench marking and Business Performance Management (BPM). These technologies and functions are often referred to as information management.


- Uses of Business Intelligence
Business operations reporting
Forecasting
Dashboard
Multidimensional analysis
Finding correlation among different factors




- Delivery Process
- System Process














2. Data Warehouse Architectures

-   Enterprise Architecture or Centralized Architecture
In this lecture we see how the Centralized architecture is set up, in which there exists only one data warehouse which stores all data necessary for the business analysis. 


-  Federated Architecture
In a Federated Architecture the data is logically consolidated but stored in separate physical database, at the same or at different physical sites. The local data marts store only the relevant information for a department. 

The amount of data is reduced in contrast to a central data warehouse. The level of detail is enhanced in this kind of model. 


-  Multi-Tired Architecture
A Multi Tired architecture is a distributed data approach. This process cannot be done in a one step because many sources have to be integrated into a warehouse.


-  Components of a Data Warehouse
Different data warehousing systems have different structures. Some may have an ODS (operational data store), while some may have multiple data marts. Some may have a small number of data sources, while some may have dozens of data sources. In view of this, it is far more reasonable to present the different layers of a data warehouse architecture rather than discussing the specifics of any one system.

In general, all data warehouse systems have the following layers:

Data Source Layer
Data Extraction Layer
Staging Area
ETL Layer
Data Storage Layer
Data Logic Layer
Data Presentation Layer
Metadata Layer
System Operations Layer

- Purpose of a Staging Area in Data Warehouse Architecture 
This is where data is stored prior to being scrubbed and transformed into a data warehouse / data mart. Having one common area makes it easier for subsequent data processing / integration. Based on the business architecture and design there can be more than one staging area which can be termed with different naming conventions. 


- Advantages of Traditional warehouse
Data warehouses tend to have a high query success, as they have complete control over the four main areas of data management systems:

Clean data
Indexes: multiple types
Query processing: multiple options
Security: data and access


- Limitations of Traditional Data Warehouses
There are considerable disadvantages involved in moving data from multiple, often highly disparate, data sources to one data warehouse that translate into long implementation time, high cost, lack of flexibility, dated information and limited capabilities.

Other disadvantages are discussed in the video. 




















7. ODS - Operational Data Store
- What is ODS?
An ODS is designed for relatively simple queries on small amounts of data (such as finding the status of a customer order), rather than the complex queries on large amounts of data typical of the data warehouse. 

An ODS is similar to your short term memory in that it stores only very recent information; in comparison, the data warehouse is more like long term memory in that it stores relatively permanent information.

- Define ODS
The typical definition of an operational data store (ODS) is that it’s a set of logically related data structures within a database. The data within an ODS is integrated, volatile and at a non-historical granular level that is designed to address a set of operational functions for a specific business purpose. The ODS must also be based on the enterprise standards for data management for the organization.


- Staging Vs ODS
This lecture covers the topic of the difference between Staging and ODS.


- Differences between ODS,DWH, OLTP, OLAP, DSS
Please refer to the additional resources of this section which contains the Info-graphic on the differences between the ODS, DWH, OLTP, OLAP, DSS and DM (Data Mart).











8. OLAP
- OLAP Overview
OLAP (Online Analytical Processing) is the technology behind many Business Intelligence (BI) applications. OLAP is a powerful technology for data discovery, including capabilities for limitless report viewing, complex analytical calculations, and predictive “what if” scenario (budget, forecast) planning.


- OLTP Vs OLAP - Part 1_U
- OLTP (On-line Transaction Processing) is characterized by a large number of short on-line transactions (INSERT, UPDATE, DELETE). The main emphasis for OLTP systems is put on very fast query processing, maintaining data integrity in multi-access environments and an effectiveness measured by number of transactions per second. In OLTP database there is detailed and current data, and schema used to store transnational databases is the entity model (usually 3NF). 

- OLAP (On-line Analytical Processing) is characterized by relatively low volume of transactions. Queries are often very complex and involve aggregations. For OLAP systems a response time is an effectiveness measure. OLAP applications are widely used by Data Mining techniques. In OLAP database there is aggregated, historical data, stored in multi-dimensional schemas (usually star schema).


- OLTP Vs OLAP - Part 2
- OLTP (On-line Transaction Processing) is characterized by a large number of short on-line transactions (INSERT, UPDATE, DELETE). The main emphasis for OLTP systems is put on very fast query processing, maintaining data integrity in multi-access environments and an effectiveness measured by number of transactions per second. In OLTP database there is detailed and current data, and schema used to store transnational databases is the entity model (usually 3NF). 

- OLAP (On-line Analytical Processing) is characterized by relatively low volume of transactions. Queries are often very complex and involve aggregations. For OLAP systems a response time is an effectiveness measure. OLAP applications are widely used by Data Mining techniques. In OLAP database there is aggregated, historical data, stored in multi-dimensional schemas (usually star schema).


- OLAP Architecture - MOLAP
MOLAP (multidimensional online analytical processing) is online analytical processing (OLAP) that indexes directly into a multidimensional database.


- ROLAP
Relational online analytical processing (ROLAP) is a form of online analytical processing (OLAP) that performs dynamic multidimensional analysis of data stored in a relational database rather than in a multidimensional database (which is usually considered the OLAP standard).


- HOLAP
HOLAP (hybrid online analytical processing) is a combination of ROLAP (Relational OLAP) and MOLAP (Multidimensional OLAP) which are other possible implementations of OLAP. HOLAP allows storing part of the data in a MOLAP store and another part of the data in a ROLAP store, allowing a tradeoff of the advantages of each.



- DOLAP
DOLAP (Desktop OLAP or Database OLAP)provide multidimensional analysis locally in the client machine on the data collected from relational or multidimensional database servers.












9. Data Mart
- What is a Data Mart?
The data mart is a subset of the data warehouse that is usually oriented to a specific business line or team. Data marts are small slices of the data warehouse. Whereas data warehouses have an enterprise-wide depth, the information in data marts pertains to a single department.



- Fundamental Difference between DWH and DM
Data Warehouse:

Holds multiple subject areas
Holds very detailed information
Works to integrate all data sources
Does not necessarily use a dimensional model but feeds dimensional models.
Data Mart:

Often holds only one subject area- for example, Finance, or Sales
May hold more summarized data (although many hold full detail)
Concentrates on integrating information from a given subject area or set of source systems
Is built focused on a dimensional model using a star schema.


- Advantages of a Data Mart
The primary advantages are:

Data Segregation: Each box of information is developed without changing the other ones. This boosts information security and the quality of data.
Easier Access to Information: These data structures provide a easiest way of interpret the information stored on the database
Faster Response: Derived from the adopted structure
Simple queries: Based on the structure and size of the data
Subject full detailed data: Might also provide summarization of the information
Specific to User Needs: This set of data is focused on the end user needs
Easy to Create and Mantain


- Characteristics of a Data Mart
Easy access to frequently needed data
Creates collective view by a group of users
Improves end-user response time
Ease of creation
Lower cost than implementing a full data warehouse
Potential users are more clearly defined than in a full data warehouse
Contains only business essential data and is less cluttered.



- Disadvantages of a Data Mart
Like any other system, data marts have many issues including functionality, data size, scalability, performance, data access, and consolidation. Since data marts can be broken into different departments to focus on their individual needs. This approach makes data access, consolidation, and cleansing very difficult.

For instance, when a company has a data mart for each of its departments including sales, inventory, tracking, shipping, receiving, and production. Combining revenue information from each of these departments into a single data mart can be overwhelming and confusing, due to the volume of data to be analyzed.


- Mistakes and MisConceptions of a Data Mart
This lecture talks about the mistakes and the mis-conceptions one have with regard to the Data warehouse













10. Metadata
- Overview of Metadata
Metadata is data that describes other data. Meta is a prefix that in most information technology usages means "an underlying definition or description." Metadata summarizes basic information about data, which can make finding and working with particular instances of data easier.


- Benefits of Metadata
Metadata provides a number of very important benefits to the enterprise, including:

Consistency of definitions: Metadata contains information about data that helps reconcile the difference in terminology such as "clients" and "customers," "revenue" and "sales," etc.

Clarity of relationships: Metadata helps resolve ambiguity and inconsistencies when determining the associations between entities stored throughout data environment. 

Clarity of data lineage: Metadata contains information about the origins of a particular data set and can be granular enough to define information at the attribute level; metadata may maintain allowed values for a data attribute, its proper format, location, owner, and steward. 


- Types of Metadata

- Projects on Metadata
In this lecture, we will see what is to be considered for setting up the projects with Metadata. 


- Best Practices for Metadata Setup
The standard best practices are discussed in this project. Though these may vary from project to project and enterprise to enterprise, these can be considered as the ground rules. 











11. Data Modeling
- What is Data Modeling?
Data modeling is the formalization and documentation of existing processes and events that occur during application software design and development. 


- Data Modeling Techniques
Data modeling techniques and tools capture and translate complex system designs into easily understood representations of the data flows and processes, creating a blueprint for construction and/or re-engineering. 













12. Entity Relational Data Model
- ER - (Entity Relation) Data Model
An entity–relationship model (ER model) is a data model for describing the data or information aspects of a business domain or its process requirements, in an abstract way that lends itself to ultimately being implemented in a database such as a relational database.


- ER Data Model - What is Entity?
An entity can be a real-world object, either animate or inanimate, that can be easily identifiable. 

For example, in a university database, students, teachers, classes, and courses offered can be considered as entities. All these entities have some attributes or properties that give them their identity.

An entity set is a collection of similar types of entities. An entity set may contain entities with attribute sharing similar values. 

For example, a Students set may contain all the students of a university; likewise a Teachers set may contain all the teachers of a university from all faculties. Entity sets need not be disjoint.


- ER Data Model - Types of Entities - Part 1
Entity Types: The following types are discussed in this lecture

Independent/Fundamental Entity (###b/b###)
Dependent/Attributive Entity (Weak)
Associative Entity



- ER Data Model - Types of Entities - Part 2
Entity Types: The following types are discussed in this lecture

Super type Entity
Sub type Entity

- ER Data Model - Attributes
Entities are represented by means of their properties, called attributes. All attributes have values. 


- ER Data Model - Types of Attributes
Simple attribute
Composite attribute
Derived attribute
Single-value attribute 
Multi-value attribute

- ER Data Model - Entity-Set and Keys
Key is an attribute or collection of attributes that uniquely identifies an entity among entity set.

Super Key
Candidate Key
Primary Key

- ER Data Model - Identifier
One or more attribute uniquely identifies an instance of an entity.


- ER Data Model - Relationship
The association among entities is called a relationship. For example, an employee works_at a department, a customer enrolls for an offer. Here, Works_at and Enrolls are called relationships.


- ER Data Model - Notation
ER-Diagram is a visual representation of data that describes how data is related to each other.


- ER Data Model - Logical Data Model
A logical data model describes the data in as much detail as possible, without regard to how they will be physical implemented in the database. Features of a logical data model include:

Includes all entities and relationships among them.
All attributes for each entity are specified.
The primary key for each entity is specified.
Foreign keys (keys identifying the relationship between different entities) are specified.
Normalization occurs at this level.
The steps for designing the logical data model are as follows:

Specify primary keys for all entities.
Find the relationships between different entities.
Find all attributes for each entity.
Resolve many-to-many relationships.
Normalization.

- ER Data Model - Moving from Logical Data Model to Physical Data Model

- ER Data Model - Differences between CDM, LDM and PDM
Here we compare these three types of data models. 

We can see that the complexity increases from conceptual to logical to physical. This is why we always first start with the conceptual data model (so we understand at high level what are the different entities in our data and how they relate to one another), then move on to the logical data model (so we understand the details of our data without worrying about how they will actually implemented), and finally the physical data model (so we know exactly how to implement our data model in the database of choice). In a data warehousing project, sometimes the conceptual data model and the logical data model are considered as a single deliverable.


- ER Data Model - Disadvantages
Following are advantages of an E-R Model:

Straightforward relation representation
Easy conversion for E-R to other data model
Graphical representation for better understanding
Disadvantages of E-R Data Model:

No industry standard for notation
Popular for high-level design
Software cannot usefully query a general ER model
Non-intuitive 
















13. Dimensional Model
- What is Dimension Modelling?
A Dimensional Model is a database structure that is optimized for online queries and Data Warehousing tools. It is comprised of "fact" and "dimension" tables. A "fact" is a numeric value that a business wishes to count or sum. A "dimension" is essentially an entry point for getting at the facts.


- Benefits of Dimensional Modelling
Benefits of the dimensional model:

Understand-ability
Query performance 
Extensible 

- What is a Dimension?
A dimension is a structure that categorizes facts and measures in order to enable users to answer business questions. Commonly used dimensions are people, products, place and time. In a data warehouse, dimensions provide structured labeling information to otherwise un-ordered numeric measures.


- What is a Fact?
In data warehousing, a fact table consists of the measurements, metrics or facts of a business process. It is often located at the center of a star schema, surrounded by dimension tables.

There are four types of facts. 

Additive - Measures that can be added across all dimensions.
Non Additive - Measures that cannot be added across all dimensions.
Semi Additive – Measures that can be added across few dimensions and not with others.
Fact less fact tables – The fact table does not have aggregate numeric values or information.

- Additive Facts
There are four types of facts. 

Additive - Measures that can be added across all dimensions.
Non Additive - Measures that cannot be added across all dimensions.
Semi Additive – Measures that can be added across few dimensions and not with others.
Fact less fact tables – The fact table does not have aggregate numeric values or information.

- Semi Additive Facts
There are four types of facts. 

Additive - Measures that can be added across all dimensions.
Non Additive - Measures that cannot be added across all dimensions.
Semi Additive – Measures that can be added across few dimensions and not with others.
Fact less fact tables – The fact table does not have aggregate numeric values or information.

- Non-Additive Facts
There are four types of facts. 

Additive - Measures that can be added across all dimensions.
Non Additive - Measures that cannot be added across all dimensions.
Semi Additive – Measures that can be added across few dimensions and not with others.
Fact less fact tables – The fact table does not have aggregate numeric values or information.

- FactLess Facts
There are four types of facts. 

Additive - Measures that can be added across all dimensions.
Non Additive - Measures that cannot be added across all dimensions.
Semi Additive – Measures that can be added across few dimensions and not with others.
Fact less fact tables – The fact table does not have aggregate numeric values or information.

- What is a Surrogate key?
A surrogate key is any column or set of columns that can be declared as the primary key instead of a "real" or natural key. Sometimes there can be several natural keys that could be declared as the primary key, and these are all called candidate keys. So a surrogate is a candidate key.

- Data Cube
A data cube helps us represent data in multiple dimensions. It is defined by dimensions and facts. The dimensions are the entities with respect to which an enterprise preserves the records.

- Star Schema
A star schema is the simplest form of a dimensional model, in which data is organized into facts and dimensions. 


- SnowFlake Schema
 The snowflake schema is diagrammed with each fact surrounded by its associated dimensions (as in a star schema), and those dimensions are further related to other dimensions, branching out into a snowflake pattern.


- Galaxy Schema or Fact Constellation Schema
Galaxy schema also know as fact constellation schema because it is the combination of both of star schema and Snow flake schema.


- Differences between Star Schema and SnowFlake Schema?
When choosing a database schema for a data warehouse, snowflake and star schema tend to be popular choices. This comparison discusses suitability of star vs. snowflake schema in different scenarios and their characteristics.


- Conformed Dimension
A conformed dimension is a dimension that has exactly the same meaning and content when being referred from different fact tables. A conformed dimension can refer to multiple tables in multiple data marts within the same organization.


- Junk Dimension
In a Junk dimension, we combine these indicator fields into a single dimension. This way, we'll only need to build a single dimension table, and the number of fields in the fact table, as well as the size of the fact table, can be decreased.


- Degenerate Dimension
According to Ralph Kimball, in a data warehouse, a degenerate dimension is a dimension key in the fact table that does not have its own dimension table, because all the interesting attributes have been placed in analytic dimensions. The term "degenerate dimension" was originated by Ralph Kimball. 


- Slowly Changing Dimensions - Intro and Example Creation
We start with the basic definition of a Dimension, Fact and start with the Slowly Changing Dimensions.


- Slowly Changing Dimensions - Type 1, 2 and 3
There are many approaches how to deal with SCD. The most popular are: 

Type 0 - The passive method
Type 1 - Overwriting the old value
Type 2 - Creating a new additional record
Type 3 - Adding a new column
Type 4 - Using historical table
Type 6 - Combine approaches of types 1,2,3 (1+2+3=6)

- Slowly Changing Dimensions - Summary
Dimension, Fact and SCD Type 1, 2 and 3 are reviewed in this lecture. 


- Step by Step approach to set up the Dimensional Model using a retail case study

- ER Model Vs Dimensional Model
In this lecture we talk about the differences between ER model and the Dimensional Model.




14. DWH Indexes
- What is an Index?
Indexing the data warehouse can reduce the amount of time it takes to see query results. When indexing dimensions, you'll want to index on the dimension key. When indexing the fact table, you'll want to index on the date key or the combined data plus time.


- Bitmap Index
A bitmap index is a special kind of database index that uses bitmaps.Bitmap indexes have traditionally been considered to work well for low-cardinality columns, which have a modest number of distinct values, either absolutely, or relative to the number of records that contain the data.


- B-Tree index
A B-tree is a self-balancing tree data structure that keeps data sorted and allows searches, sequential access, insertions, and deletions in logarithmic time.


- Bitmap Index Vs B Tree Index
One of the common questions which come up in the interviews is which one is the better one to use, Is it Bitmap or B Tree?

In this lecture, we try to evaluate the differences and the best one to use.


15. Data integration and ETL
- What is Data Integration?
Data integration is the combination of technical and business processes used to combine data from disparate sources into meaningful and valuable information. A complete data integration solution delivers trusted data from a variety of sources.


- What is ETL?
ETL is short for extract, transform, load, three database functions that are combined into one tool to pull data out of one database and place it into another database.

Extract is the process of reading data from a database.

Transform is the process of converting the extracted data from its previous form into the form it needs to be in so that it can be placed into another database. Transformation occurs by using rules or lookup tables or by combining the data with other data.

Load is the process of writing the data into the target database.

ETL is used to migrate data from one database to another, to form data marts and data warehouses and also to convert databases from one format or type to another.


- Common Questions and Summary
In this lecture we discuss on what are the common questions which are raised for Data Integration and ETL.


16. ETL vs ELT 
- ETL - Explained
ETL is short for extract, transform, load, three database functions that are combined into one tool to pull data out of one database and place it into another database.

Extract is the process of reading data from a database.

Transform is the process of converting the extracted data from its previous form into the form it needs to be in so that it can be placed into another database. Transformation occurs by using rules or lookup tables or by combining the data with other data.

Load is the process of writing the data into the target database.

ETL is used to migrate data from one database to another, to form data marts and data warehouses and also to convert databases from one format or type to another.


- ELT - Explained
ELT is a variation of the Extract, Transform, Load (ETL), a data integration process in which transformation takes place on an intermediate server before it is loaded into the target.


- ETL Vs ELT



17. ETL- Extraction Transformation and loading
- Build Vs Buy
There are many advantages of ETL Tools in Data Warehouse which includes:

A set of comprehensive Scheduling Mechanisms.
Logging, Audit and Metadata support
Easier Maintenance specially when multiple developers are to be involved
Supporting heterogeneous connectivity
Robust execution control and error handling
Parallel processing
High Availability
Partitioning / Push-down Optimization capabilities
There are scenarios where-in Hand written code would be better (not faster than existing ETL's in development though) but the challenge is to select the right ETL Tool depending on your scenario instead of thinking of writing it on your own.


- ETL Tools for Data Warehouses
Many ETL tools were originally developed to make the task of the data warehouse developer easier and more fun. Developers are spared the arduous task of handwriting SQL code, replacing it with easy drag and drop to develop a data warehouse.

Today, the top ETL tools in the market have vastly expanded their functionality beyond data warehousing and ETL. They now contain extended functionalities for data profiling, data cleansing, Enterprise Application Integration (EAI), Big Data processing, data governance and master data management. 


- Extraction Methods in Data Warehouses
Full Load is the entire data dump load taking place the very first time.In this we give the last extract date as empty so that all the data gets loaded

Incremental - Where delta or difference between target and source data is dumped at regular intervals.Here we give the last extract date such that only records after this date are loaded.














