Problem Statement:-
Order_Tbl has four columns namely ORDER_DAY, ORDER_ID, PRODUCT_ID, QUANTITY, and PRICE

PART A

Write a SQL query to get all the products that got sold on both the days and the number of times the product is sold.






PART B

Write a SQL query to get products that were ordered on 02-May-2015 but not on 01-May-2015.




SOLUTION

PART A


SELECT  PRODUCT_ID,COUNT(PRODUCT_ID) AS [COUNT],Count(distinct ORDER_DAY)
FROM Order_Tbl
GROUP BY PRODUCT_ID

HAVING Count(distinct ORDER_DAY) > 1

PART B

Using Subquery

SELECT DISTINCT(PRODUCT_ID) FROM Order_Tbl
WHERE ORDER_DAY = '2015-05-02'
AND PRODUCT_ID NOT in (

SELECT PRODUCT_ID from Order_Tbl where ORDER_DAY =
'2015-05-01')

Using Join

SELECT A.PRODUCT_ID--,B.PRODUCT_ID
FROM (
(
SELECT PRODUCT_ID
FROM Order_Tbl WHERE ORDER_DAY='2015-05-02'
)A
LEFT JOIN
(
SELECT PRODUCT_ID
FROM Order_Tbl WHERE ORDER_DAY='2015-05-01'
)B
ON A.PRODUCT_ID=B.PRODUCT_ID
)

WHERE B.PRODUCT_ID IS NULL

Using EXCEPT Query

SELECT PRODUCT_ID
FROM Order_Tbl WHERE ORDER_DAY='2015-05-02'
EXCEPT
SELECT PRODUCT_ID

FROM Order_Tbl WHERE ORDER_DAY='2015-05-01'




