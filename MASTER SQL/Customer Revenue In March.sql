/*
Customer Revenue In March
Calculate the total revenue from each customer in March 2019. 

Output the revenue along with the customer id and sort the results based on the revenue 
in descending order.

orders
    id int
    cust_id int
    order_date datetime
    order_details varchar
    total_order_cost int

*/

SELECT cust_id,
       SUM(total_order_cost) AS revenue
FROM orders
WHERE EXTRACT('MONTH'
              FROM order_date :: TIMESTAMP) = 3
      AND
      EXTRACT('YEAR'
              FROM order_date :: TIMESTAMP) = 2019
GROUP BY cust_id
ORDER BY revenue DESC
