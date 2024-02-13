/*
Write a SQL query to fetch the second last record from a employee table.
*/


--Tables Structure:

drop table employee;
create table employee
( emp_ID int primary key
, emp_NAME varchar(50) not null
, DEPT_NAME varchar(50)
, SALARY int);

insert into employee values(101, 'Mohan', 'Admin', 4000);
insert into employee values(102, 'Rajkumar', 'HR', 3000);
insert into employee values(103, 'Akbar', 'IT', 4000);
insert into employee values(104, 'Dorvin', 'Finance', 6500);
insert into employee values(105, 'Rohit', 'HR', 3000);
insert into employee values(106, 'Rajesh',  'Finance', 5000);
insert into employee values(107, 'Preet', 'HR', 7000);
insert into employee values(108, 'Maryam', 'Admin', 4000);
insert into employee values(109, 'Sanjay', 'IT', 6500);
insert into employee values(110, 'Vasudha', 'IT', 7000);
insert into employee values(111, 'Melinda', 'IT', 8000);
insert into employee values(112, 'Komal', 'IT', 10000);
insert into employee values(113, 'Gautham', 'Admin', 2000);
insert into employee values(114, 'Manisha', 'HR', 3000);
insert into employee values(115, 'Chandni', 'IT', 4500);
insert into employee values(116, 'Satya', 'Finance', 6500);
insert into employee values(117, 'Adarsh', 'HR', 3500);
insert into employee values(118, 'Tejaswi', 'Finance', 5500);
insert into employee values(119, 'Cory', 'HR', 8000);
insert into employee values(120, 'Monica', 'Admin', 5000);
insert into employee values(121, 'Rosalin', 'IT', 6000);
insert into employee values(122, 'Ibrahim', 'IT', 8000);
insert into employee values(123, 'Vikram', 'IT', 8000);
insert into employee values(124, 'Dheeraj', 'IT', 11000);

select * from employee;

-- Solution:
select * from employee order by emp_id desc limit 1,1;


select emp_id, emp_name, dept_name, salary
from (
select *,
row_number() over (order by emp_id desc) as rn
from employee e) x
where x.rn = 2;




/*

from pyspark.sql.types import IntegerType, StringType, StructType, StructField
from pyspark.sql.window import Window
from pyspark.sql.functions import row_number,col



# Define the schema for the Employee DataFrame
employee_schema = StructType([
    StructField("emp_ID", IntegerType(), nullable=False),
    StructField("emp_NAME", StringType(), nullable=False),
    StructField("DEPT_NAME", StringType(), nullable=True),
    StructField("SALARY", IntegerType(), nullable=True)
])

# Create the Employee DataFrame with the specified schema
employee_data = [
    (101, 'Mohan', 'Admin', 4000),
    (102, 'Rajkumar', 'HR', 3000),
    (103, 'Akbar', 'IT', 4000),
    (104, 'Dorvin', 'Finance', 6500),
    (105, 'Rohit', 'HR', 3000),
    (106, 'Rajesh', 'Finance', 5000),
    (107, 'Preet', 'HR', 7000),
    (108, 'Maryam', 'Admin', 4000),
    (109, 'Sanjay', 'IT', 6500),
    (110, 'Vasudha', 'IT', 7000),
    (111, 'Melinda', 'IT', 8000),
    (112, 'Komal', 'IT', 10000),
    (113, 'Gautham', 'Admin', 2000),
    (114, 'Manisha', 'HR', 3000),
    (115, 'Chandni', 'IT', 4500),
    (116, 'Satya', 'Finance', 6500),
    (117, 'Adarsh', 'HR', 3500),
    (118, 'Tejaswi', 'Finance', 5500),
    (119, 'Cory', 'HR', 8000),
    (120, 'Monica', 'Admin', 5000),
    (121, 'Rosalin', 'IT', 6000),
    (122, 'Ibrahim', 'IT', 8000),
    (123, 'Vikram', 'IT', 8000),
    (124, 'Dheeraj', 'IT', 11000)
]

employee_df = spark.createDataFrame(employee_data, schema=employee_schema)

# Show the result DataFrame
employee_df.show()


windowSpec  = Window.orderBy(employee_df["emp_ID"].desc())
df = employee_df.withColumn("rn",row_number().over(windowSpec))
df = df.select("*").filter("rn==2")
df.show()

*/


