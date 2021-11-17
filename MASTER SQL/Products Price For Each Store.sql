/*
Write an SQL query to find the price of each product in each store.

Products table:
+-------------+--------+-------+
| product_id  | store  | price |
+-------------+--------+-------+
| 0           | store1 | 95    |
| 0           | store3 | 105   |
| 0           | store2 | 100   |
| 1           | store1 | 70    |
| 1           | store3 | 80    |
+-------------+--------+-------+
Result table:
+-------------+--------+--------+--------+
| product_id  | store1 | store2 | store3 |
+-------------+--------+--------+--------+
| 0           | 95     | 100    | 105    |
| 1           | 70     | null   | 80     |
+-------------+--------+--------+--------+
Product 0 price's are 95 for store1, 100 for store2 and, 105 for store3.
Product 1 price's are 70 for store1, 80 for store3 and, it's not sold in store2.
*/

SELECT product_id, 
       sum(CASE WHEN store='store1' THEN price END) as store1,
       sum(CASE WHEN store='store2' THEN price END) as store2,
       sum(CASE WHEN store='store3' THEN price END) as store3
FROM Products
GROUP BY product_id



/*
Write an SQL query to rearrange the Products table so that each row has (product_id, store, 
price). If a product is not available in a store, do not include a row with that product_id 
and store combination in the result table.

Products table:
+------------+--------+--------+--------+
| product_id | store1 | store2 | store3 |
+------------+--------+--------+--------+
| 0          | 95     | 100    | 105    |
| 1          | 70     | null   | 80     |
+------------+--------+--------+--------+

Result table:
+------------+--------+-------+
| product_id | store  | price |
+------------+--------+-------+
| 0          | store1 | 95    |
| 0          | store2 | 100   |
| 0          | store3 | 105   |
| 1          | store1 | 70    |
| 1          | store3 | 80    |
+------------+--------+-------+

Product 0 is available in all three stores with prices 95, 100, and 105 respectively.
Product 1 is available in store1 with price 70 and store3 with price 80. The product is not available in store2.

*/


select product_id,'store1' as store, store1 as price 
from products 
where store1 is not null

union

select product_id,'store2' as store, store2 as price 
from products 
where store2 is not null

union

select product_id,'store3' as store, store3 as price 
from products 
where store3 is not null






