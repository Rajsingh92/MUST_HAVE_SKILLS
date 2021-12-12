/*
Write an SQL query to find for each month and country, the number of transactions and their total 
amount, the number of approved transactions and their total amount.

Transactions table:
+------+---------+----------+--------+------------+
| id   | country | state    | amount | trans_date |
+------+---------+----------+--------+------------+
| 121  | US      | approved | 1000   | 2018-12-18 |
| 122  | US      | declined | 2000   | 2018-12-19 |
| 123  | US      | approved | 2000   | 2019-01-01 |
| 124  | DE      | approved | 2000   | 2019-01-07 |
+------+---------+----------+--------+------------+

Result table:
+----------+---------+-------------+----------------+--------------------+-----------------------+
| month    | country | trans_count | approved_count | trans_total_amount | approved_total_amount |
+----------+---------+-------------+----------------+--------------------+-----------------------+
| 2018-12  | US      | 2           | 1              | 3000               | 1000                  |
| 2019-01  | US      | 1           | 1              | 2000               | 2000                  |
| 2019-01  | DE      | 1           | 1              | 2000               | 2000                  |
+----------+---------+-------------+----------------+--------------------+-----------------------+

*/


SELECT 
    date_format(trans_date,"%Y-%m") month, 
    country, 
    COUNT(id) trans_count, 
    SUM(CASE WHEN state = 'approved' then 1 else 0) approved_count, 
    SUM(amount) trans_total_amount, 
    SUM(CASE WHEN state = 'approved' then amount else 0) approved_total_amount
FROM Transactions
GROUP BY month, country

