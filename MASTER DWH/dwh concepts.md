


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

We can see that the complexity increases from conceptual to logical to physical. This is why we always first start with the conceptual data model 
(so we understand at high level what are the different entities in our data and how they relate to one another), then move on to the logical data model 
(so we understand the details of our data without worrying about how they will actually implemented), and finally the physical data model 
(so we know exactly how to implement our data model in the database of choice). In a data warehousing project, sometimes the conceptual data model 
and the logical data model are considered as a single deliverable.


- Data Cube
A data cube helps us represent data in multiple dimensions. It is defined by dimensions and facts. 
The dimensions are the entities with respect to which an enterprise preserves the records.


- Conformed Dimension
A conformed dimension is a dimension that has exactly the same meaning and content when being referred from different fact tables. 
A conformed dimension can refer to multiple tables in multiple data marts within the same organization.


- Junk Dimension
In a Junk dimension, we combine these indicator fields into a single dimension. This way, we'll only need to build a single dimension table, and the number of fields in the fact table, as well as the size of the fact table, can be decreased.


- Degenerate Dimension
According to Ralph Kimball, in a data warehouse, a degenerate dimension is a dimension key in the fact table that does not have its own dimension table, because all the interesting attributes have been placed in analytic dimensions. The term "degenerate dimension" was originated by Ralph Kimball. 


- Slowly Changing Dimensions 
There are many approaches how to deal with SCD. The most popular are: 

Type 0 - The passive method
Type 1 - Overwriting the old value
Type 2 - Creating a new additional record
Type 3 - Adding a new column
Type 4 - Using historical table
Type 6 - Combine approaches of types 1,2,3 (1+2+3=6)




- Step by Step approach to set up the Dimensional Model using a retail case study

- ER Model Vs Dimensional Model
In this lecture we talk about the differences between ER model and the Dimensional Model.

- OLAP Overview
  OLAP (Online Analytical Processing) is the technology behind many Business Intelligence (BI) applications. OLAP is a powerful technology for data discovery,
  including capabilities for limitless report viewing, complex analytical calculations, and predictive “what if” scenario (budget, forecast) planning.


- OLTP Vs OLAP 
- OLTP (On-line Transaction Processing) is characterized by a large number of short on-line transactions (INSERT, UPDATE, DELETE). 
  The main emphasis for OLTP systems is put on very fast query processing, maintaining data integrity in multi-access environments 
  and an effectiveness measured by number of transactions per second. In OLTP database there is detailed and current data, and schema 
  used to store transnational databases is the entity model (usually 3NF). 
- OLAP (On-line Analytical Processing) is characterized by relatively low volume of transactions. Queries are often very complex and 
  involve aggregations. For OLAP systems a response time is an effectiveness measure. OLAP applications are widely used by Data Mining 
  techniques. In OLAP database there is aggregated, historical data, stored in multi-dimensional schemas (usually star schema).

- OLTP (On-line Transaction Processing) is characterized by a large number of short on-line transactions (INSERT, UPDATE, DELETE). 
  The main emphasis for OLTP systems is put on very fast query processing, maintaining data integrity in multi-access environments and 
  an effectiveness measured by number of transactions per second. In OLTP database there is detailed and current data, and schema used to 
  store transnational databases is the entity model (usually 3NF). 
- OLAP (On-line Analytical Processing) is characterized by relatively low volume of transactions. Queries are often very complex and involve 
  aggregations. For OLAP systems a response time is an effectiveness measure. OLAP applications are widely used by Data Mining techniques. 
  In OLAP database there is aggregated, historical data, stored in multi-dimensional schemas (usually star schema).


- MOLAP
  MOLAP (multidimensional online analytical processing) is online analytical processing (OLAP) that indexes directly into a multidimensional database.


- ROLAP
  Relational online analytical processing (ROLAP) is a form of online analytical processing (OLAP) that performs dynamic multidimensional analysis of 
  data stored in a relational database rather than in a multidimensional database (which is usually considered the OLAP standard).

- HOLAP
  HOLAP (hybrid online analytical processing) is a combination of ROLAP (Relational OLAP) and MOLAP (Multidimensional OLAP) which are other possible 
  implementations of OLAP. HOLAP allows storing part of the data in a MOLAP store and another part of the data in a ROLAP store, allowing a tradeoff of 
  the advantages of each.


- DOLAP
  DOLAP (Desktop OLAP or Database OLAP)provide multidimensional analysis locally in the client machine on the data collected from relational or 
  multidimensional database servers.

