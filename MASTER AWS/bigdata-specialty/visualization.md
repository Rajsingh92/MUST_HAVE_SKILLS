# Quicksight
- Supported data sources:
    - Redshift
    - Aurora
    - Athena
    - RDS
        - myslq,postgres..., mysql, sql server (no oracle)
    - on prem
        - mysql ,postgres, mssql.
    - from files (on prem or s3)
        - csv, excel, log format..

- Standard edition VS Enterprise edition
    - enterprise has:
        - Active directory integration
        - encryption at rest

- with standard ed, inviting:
    - an IAM user
    - invite by email, which creates quicksight only account.
    - automatic notigfication of access
- with enterprise can also:
    - use microsoft AD groups in AWS Directorsy Service
    - no automatic notification of quicksight access (for security reasons)
- all data in transit is encrypted, but at rest only in enterprise
- SPICE
    - super-fast, parallel in-memory calculation engine
    - measured in GB
    - 10GB per user
    - Hihghly available and durabilty (for data imported to SPICE)
- Data preparation:
    - change field names
    - calculated filed
    - SQL query
    - join tables
    -change data types
- Steps:
    - From a data source, create a dataset
    - create an analysis
        - can create a dashboard of an analysis (can't save filters)

VisualTypes:
    - Autograph (automatically selected by quicksight)
    - Bar chart 
        - single measure for one dimension
        - two or more    

Story:
    - like a slideshow,   

Dashboard:
    - read-only snapshot of an analysis (viewer can filter but not save filters)


# Big data visualization
- notes simplified
- Zeppelin
    - Zeppelin similar to jupyter notebook.
    - Zeppelin can be selected from EMR app list
    - can share notebooks (and real-time collaboration like google docs)
    - use cases:
        - use with spark sql and mlib, for exploratory data analsysis
- Jupyter notebook:
    - can contain live code, can share notebooks
    - used for data sci.
    - install in EMR using bootstrap action

# Microstrategy
- is an external partnet, business intelligence and analytics software (
- like tableau, cognos, ...
- can integrate with athena, aurora, emr, redshift...
