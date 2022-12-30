

Problem Statement:-
Order_Tbl has four columns namely ORDER_DAY, ORDER_ID, PRODUCT_ID, QUANTITY and PRICE


PART A
Write a SQL query to get the highest sold Products (Quantity*Price) on both days.

PART B
Write a SQL query to get all product's total sales on 1st May and 2nd May adjacent to each other.

PART C
Write a SQL query to get all products day wise, that was ordered more than once.

SOLUTION

PART A

SELECT A.ORDER_DAY,B.PRODUCT_ID ,A.Sold_Amount
FROM (
(SELECT ORDER_DAY, MAX(QUANTITY*PRICE)as Sold_Amount
FROM Order_Tbl GROUP BY ORDER_DAY) A
INNER JOIN
(SELECT ORDER_DAY ,PRODUCT_ID,QUANTITY*PRICE As Sold_Amount
FROM Order_Tbl ) B
ON A.ORDER_DAY =B.ORDER_DAY AND A.Sold_Amount=B.Sold_Amount)


PART B

SELECT PRODUCT_ID,
SUM(ISNULL(Sales_01,0)) As Total_Sales_01,
SUM(ISNULL(Sales_02,0)) As Total_Sales_02
FROM
(
SELECT PRODUCT_ID,
CASE WHEN ORDER_DAY ='2015-05-01' THEN Total_Sales END as 'Sales_01',
CASE WHEN ORDER_DAY ='2015-05-02' THEN Total_Sales END as 'Sales_02'
FROM(
SELECT ORDER_DAY,PRODUCT_ID, SUM(QUANTITY*PRICE) As Total_Sales
FROM  Order_Tbl
GROUP BY ORDER_DAY,PRODUCT_ID) A
)B
GROUP BY PRODUCT_ID

Using PIVOT Function

SELECT PRODUCT_ID,
ISNULL([2015-05-01],0) As Total_Sales_01,
ISNULL([2015-05-02],0) As Total_Sales_02
FROM
(
SELECT ORDER_DAY,PRODUCT_ID, QUANTITY*PRICE As Total_Sales
FROM  Order_Tbl )BaseTble
PIVOT(
     SUM(Total_Sales)
     FOR ORDER_DAY IN ([2015-05-01],[2015-05-02])
) As Pivot_Table

PART C

SELECT ORDER_DAY,PRODUCT_ID
FROM Order_Tbl
GROUP BY ORDER_DAY,PRODUCT_ID
HAVING COUNT(*) > 1


