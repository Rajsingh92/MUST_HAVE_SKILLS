/*
Write an SQL query that reports the buyers who have bought S8 but not iPhone.

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
| 2         | 1          | 3        | 2019-06-02 | 1        | 800   |
| 3         | 3          | 3        | 2019-05-13 | 2        | 2800  |
+-----------+------------+----------+------------+----------+-------+

Result table:
+-------------+
| buyer_id    |
+-------------+
| 1           |
+-------------+


*/


WITH result AS
(
        select s.buyer_id, s.product_id, p.product_name 
        from sales s join product p
        on s.product_id = p.product_id
)
               
SELECT distinct buyer_id
FROM result
WHERE product_name = 'S8' 
        AND buyer_id NOT IN (
                SELECT distinct buyer_id 
                FROM result 
                WHERE product_name = 'iPhone'
        )


        