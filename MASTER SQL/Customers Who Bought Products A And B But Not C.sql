/*
Write an SQL query to report the customer_id and customer_name of customers who bought products 
“A”, “B” but did not buy the product “C” since we want to recommend them buy this product.

Customers table:
+-------------+---------------+
| customer_id | customer_name |
+-------------+---------------+
| 1           | Daniel        |
| 2           | Diana         |
| 3           | Elizabeth     |
| 4           | Jhon          |
+-------------+---------------+

Orders table:
+------------+--------------+---------------+
| order_id   | customer_id  | product_name  |
+------------+--------------+---------------+
| 10         |     1        |     A         |
| 20         |     1        |     B         |
| 30         |     1        |     D         |
| 40         |     1        |     C         |
| 50         |     2        |     A         |
| 60         |     3        |     A         |
| 70         |     3        |     B         |
| 80         |     3        |     D         |
| 90         |     4        |     C         |
+------------+--------------+---------------+

Result table:
+-------------+---------------+
| customer_id | customer_name |
+-------------+---------------+
| 3           | Elizabeth     |
+-------------+---------------+
Only the customer_id with id 3 bought the product A and B but not the product C.
*/


select Customers.customer_id, customer_name
from Customers left join Orders 
on Customers.customer_id = Orders.customer_id
group by Customers.customer_id
having sum(product_name = 'A') > 0 and sum(product_name = 'B') > 0 and sum(product_name = 'C') = 0
order by Customers.customer_id;
