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



with recursive t as (
    select 1 as ids
    union 
    select ids+1 from t where ids < (select max(customer_id) from Customers)
)
select * from t where ids not in (select distinct customer_id from Customers );




    