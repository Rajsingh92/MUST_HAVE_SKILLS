/*
Write an SQL query to find the missing customer IDs. The missing IDs are ones that are 
not in the Customers table but are in the range between 1 and the maximum customer_id 
present in the table.

Customer table:
+-------------+---------------+
| customer_id | customer_name |
+-------------+---------------+
| 1           | Alice         |
| 4           | Bob           |
| 5           | Charlie       |
+-------------+---------------+

Result table:
+-----+
| ids |
+-----+
| 2   |
| 3   |
+-----+
The maximum customer_id present in the table is 5, so in the range [1,5], IDs 2 and 3 are missing from the table.
*/


CREATE TABLE Customers 
(
    customer_id  	INT,
     customer_name      	VARCHAR(512)
);

INSERT INTO Customers (customer_id, customer_name) VALUES
	('1', 'Alice'),
	('4', 'Bob'),
	('5', 'Charlie');



--Query
with recursive t as (
    select 1 as ids
    union 
    select ids+1 from t where ids < (select max(customer_id) from Customers)
)
select * from t where ids not in (select distinct customer_id from Customers );





/*

from pyspark.sql import SparkSession
from pyspark.sql.types import IntegerType, StringType, StructType, StructField
from pyspark.sql.functions import col, max


# create schema for dataframe
schema = StructType([
    StructField('customer_id', IntegerType(), True),
    StructField('customer_name', StringType(), True)
])

# create data for dataframe
data = [
    (1, 'Alice'),
    (4, 'Bob'),
    (5, 'Charlie')
]

# create dataframe
df = spark.createDataFrame(data, schema)

# show dataframe
df.show()






# Find the maximum customer_id
max_customer_id = df.select(max("customer_id")).first()[0]

# Create a DataFrame with the sequence of ids
ids_df = spark.range(1, max_customer_id + 1).select(col("id").alias("ids"))

# Perform a left anti-join to get the ids not present in the "Customers" table
result_df = ids_df.join(df, ids_df["ids"] == df["customer_id"], "leftanti")

# Show the result DataFrame
result_df.show()

# Stop the SparkSession
spark.stop()


*/

    