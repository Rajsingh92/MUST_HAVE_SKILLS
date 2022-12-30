/*
Write an SQL query that reports the best seller by total sales price, If there is a tie, report them all.

Product table:
+------------+--------------+------------+
| product_id | product_name | unit_price |
+------------+--------------+------------+
| 1          | S8           | 1000       |
| 2          | G4           | 800        |
| 3          | iPhone       | 1400       |
+------------+--------------+------------+

Sales table:
+-----------+------------+----------+------------+----------+-------+
| seller_id | product_id | buyer_id | sale_date  | quantity | price |
+-----------+------------+----------+------------+----------+-------+
| 1         | 1          | 1        | 2019-01-21 | 2        | 2000  |
| 1         | 2          | 2        | 2019-02-17 | 1        | 800   |
| 2         | 2          | 3        | 2019-06-02 | 1        | 800   |
| 3         | 3          | 4        | 2019-05-13 | 2        | 2800  |
+-----------+------------+----------+------------+----------+-------+

Result table:
+-------------+
| seller_id   |
+-------------+
| 1           |
| 3           |
+-------------+
Both sellers with id 1 and 3 sold products with the most total price of 2800.

*/

SELECT seller_id 
FROM Sales 
GROUP BY seller_id
HAVING SUM(price) = (
    SELECT SUM(price) sum
    FROM Sales
    GROUP BY seller_id
    ORDER BY sum DESC
    LIMIT 1
);






WITH summary AS 
(
    SELECT 
        seller_id, 
        dense_rank() OVER(ORDER BY sum(price) desc) as 'rank'
    FROM sales 
    group by seller_id
) 
select seller_id 
from summary 
where rank = 1;




with s as
(
    select seller_id, sum(price) sum_price 
    from sales 
    group by seller_id
)
select seller_id 
from s
where sum_price = (
    select max(sum_price) 
    from s
);



