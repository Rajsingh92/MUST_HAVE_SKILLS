/*
Second Highest Salary

SQL Schema
Write a SQL query to get the second highest salary from the Employee table.

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
For example, given the above Employee table, the query should return 200 as the second highest salary. If there is no second highest salary, then the query should return null.

+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+

*/

SELECT (
    SELECT DISTINCT Salary FROM Employee
    ORDER BY Salary DESC 
    LIMIT 1 OFFSET 1
) AS SecondHighestSalary;



SELECT MAX(Salary) AS SecondHighestSalary
FROM Employee
WHERE Salary < (SELECT MAX(Salary) FROM Employee); /* max return null if value doesnt exist */

