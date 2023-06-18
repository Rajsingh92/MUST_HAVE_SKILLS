/*
Write a SQL query to fetch all the duplicate records from a table.
*/


--Tables Structure:

drop table users;
create table users
(
user_id int primary key,
user_name varchar(30) not null,
email varchar(50));

insert into users values
(1, 'Sumit', 'sumit@gmail.com'),
(2, 'Reshma', 'reshma@gmail.com'),
(3, 'Farhana', 'farhana@gmail.com'),
(4, 'Robin', 'robin@gmail.com'),
(5, 'Robin', 'robin@gmail.com');


select user_id, user_name, email
from (
select *,
row_number() over (partition by user_name order by user_id) as rn
from users u
order by user_id) x
where x.rn <> 1;



/*
from pyspark.sql.types import IntegerType, StringType, StructType, StructField
from pyspark.sql.window import Window
from pyspark.sql.functions import row_number,col


# Define the schema for the Users DataFrame
users_schema = StructType([
    StructField("user_id", IntegerType(), nullable=False),
    StructField("user_name", StringType(), nullable=False),
    StructField("email", StringType(), nullable=True)
])

# Create the Users DataFrame with the specified schema
users_data = [
    (1, 'Sumit', 'sumit@gmail.com'),
    (2, 'Reshma', 'reshma@gmail.com'),
    (3, 'Farhana', 'farhana@gmail.com'),
    (4, 'Robin', 'robin@gmail.com'),
    (5, 'Robin', 'robin@gmail.com')
]

users_df = spark.createDataFrame(users_data, schema=users_schema)

# Show the result DataFrame
users_df.show()


windowSpec  = Window.partitionBy("user_name").orderBy("user_id")
df = users_df.withColumn("rn",row_number().over(windowSpec))
df = df.select("user_id", "user_name", "email").filter("rn<>1").orderBy('user_id')
df.show()

*/


