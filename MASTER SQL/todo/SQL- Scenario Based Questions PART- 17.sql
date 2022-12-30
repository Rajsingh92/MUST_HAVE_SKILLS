Order_Tbl has four columns namely ORDER_ID, PRODUCT_ID, QUANTITY and PRICE.


Write a SQL query that will explode the above data into single unit level records as shown below.

SOLUTION

 SELECT
    MT.Order_ID,
    MT.Product_ID,
    1 AS quantity
FROM
    ORDER_TABLE MT
INNER JOIN
    (
        SELECT 1 AS nbr UNION ALL SELECT 2 AS nbr UNION ALL
        SELECT 3 AS nbr UNION ALL SELECT 4 AS nbr UNION ALL SELECT 5 AS nbr
    ) N ON N.nbr <= MT.quantity



Using Recursive CTE

WITH  CTE_Order As
(
-- Anchor Query
Select Order_ID,Product_ID, 1 As Quantity,1 As Cnt
FROM ORDER_TABLE
UNION ALL
-- Recursive Part
Select A.Order_ID,A.Product_ID, B.Quantity,B.Cnt+1
FROM ORDER_TABLE As A INNER JOIN CTE_Order As B
ON  A.Product_ID=B.Product_ID WHERE B.Cnt+1 <= A.Quantity
)
Select Order_ID,Product_ID,  Quantity
FROM CTE_Order
ORDER BY Product_ID,Order_ID

