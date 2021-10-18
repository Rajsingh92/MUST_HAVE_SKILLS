CREATE EXTERNAL TABLE demotable (col1 bigint, col2 string, col3 string)
STORED BY 'org.apache.hadoop.hive.dynamodb.DynamoDBStorageHandler' 
TBLPROPERTIES ("dynamodb.table.name" = "emrDemo", 
"dynamodb.column.mapping" = "col1:id,col2:dob,col3:name"); 