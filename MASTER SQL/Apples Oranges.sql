/*
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| sale_date     | date    |
| fruit         | enum    | 
| sold_num      | int     | 
+---------------+---------+
(sale_date,fruit) is the primary key for this table.
This table contains the sales of "apples" and "oranges" sold each day.


Write an SQL query to report the difference between number of apples and oranges sold each day.

Sales:
+------------+------------+-------------+
| sale_date  | fruit      | sold_num    |
+------------+------------+-------------+
| 2020-05-01 | apples     | 10          |
| 2020-05-01 | oranges    | 8           |
| 2020-05-02 | apples     | 15          |
| 2020-05-02 | oranges    | 15          |
| 2020-05-03 | apples     | 20          |
| 2020-05-03 | oranges    | 0           |
| 2020-05-04 | apples     | 15          |
| 2020-05-04 | oranges    | 16          |
+------------+------------+-------------+

Result :
+------------+--------------+
| sale_date  | diff         |
+------------+--------------+
| 2020-05-01 | 2            |
| 2020-05-02 | 0            |
| 2020-05-03 | 20           |
| 2020-05-04 | -1           |
+------------+--------------+

Day 2020-05-01, 10 apples and 8 oranges were sold (Difference  10 - 8 = 2).
Day 2020-05-02, 15 apples and 15 oranges were sold (Difference 15 - 15 = 0).
Day 2020-05-03, 20 apples and 0 oranges were sold (Difference 20 - 0 = 20).
Day 2020-05-04, 15 apples and 16 oranges were sold (Difference 15 - 16 = -1).

*/





CREATE TABLE Sales 
(
    sale_date  	VARCHAR(512),
     fruit      	VARCHAR(512),
     sold_num    	INT
);

INSERT INTO Sales (sale_date  ,  fruit      ,  sold_num    ) VALUES (' 2020-05-01', ' apples', '10');
INSERT INTO Sales (sale_date  ,  fruit      ,  sold_num    ) VALUES (' 2020-05-01', ' oranges', '8');
INSERT INTO Sales (sale_date  ,  fruit      ,  sold_num    ) VALUES (' 2020-05-02', ' apples', '15');
INSERT INTO Sales (sale_date  ,  fruit      ,  sold_num    ) VALUES (' 2020-05-02', ' oranges', '15');
INSERT INTO Sales (sale_date  ,  fruit      ,  sold_num    ) VALUES (' 2020-05-03', ' apples', '20');
INSERT INTO Sales (sale_date  ,  fruit      ,  sold_num    ) VALUES (' 2020-05-03', ' oranges', '0');
INSERT INTO Sales (sale_date  ,  fruit      ,  sold_num    ) VALUES (' 2020-05-04', ' apples', '15');
INSERT INTO Sales (sale_date  ,  fruit      ,  sold_num    ) VALUES (' 2020-05-04', ' oranges', '16');


select sale_date,sum(case when trim(upper(fruit)) ='APPLES' then sold_num else -sold_num end) as sold_num 
from sales 
group by sale_date;


select sale_date , sum(if(trim(upper(fruit)) ='APPLES',sold_num,-sold_num)) 
from sales
group by sale_date;




/*
from pyspark.sql.types import StringType, IntegerType, StructType, StructField
from pyspark.sql.functions import trim, upper, col, sum, when


# Define the schema for the Sales DataFrame
sales_schema = StructType([
    StructField("sale_date", StringType(), nullable=False),
    StructField("fruit", StringType(), nullable=False),
    StructField("sold_num", IntegerType(), nullable=False)
])

# Create the Sales DataFrame with the specified schema
sales_data = [
    ('2020-05-01', 'apples', 10),
    ('2020-05-01', 'oranges', 8),
    ('2020-05-02', 'apples', 15),
    ('2020-05-02', 'oranges', 15),
    ('2020-05-03', 'apples', 20),
    ('2020-05-03', 'oranges', 0),
    ('2020-05-04', 'apples', 15),
    ('2020-05-04', 'oranges', 16)
]

sales_df = spark.createDataFrame(sales_data, schema=sales_schema)

df = sales_df.groupBy('sale_date').agg(
    sum(when(upper(col("fruit"))=='APPLES',col('sold_num')).otherwise(-col('sold_num'))).alias("sold_num")
)

df.show()

*/






