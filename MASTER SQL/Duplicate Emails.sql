/*
Duplicate Emails

Write an SQL query to report all the duplicate emails

Input: 
Person table:
+----+---------+
| id | email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
Output: 
+---------+
| Email   |
+---------+
| a@b.com |
+---------+
*/

WITH count_email AS
(
     SELECT email, COUNT(email) as cnt
     FROM Person
     GROUP BY email
) 

SELECT email 
FROM count_email
WHERE  cnt > 1;


