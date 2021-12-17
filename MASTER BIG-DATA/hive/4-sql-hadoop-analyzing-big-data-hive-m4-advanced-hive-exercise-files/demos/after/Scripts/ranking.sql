SELECT
    name
   ,territory
   ,sales_amount
   ,SUM(sales_amount) OVER (PARTITION BY territory ORDER BY name ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW)
FROM
   pluralsight.sales_employee;