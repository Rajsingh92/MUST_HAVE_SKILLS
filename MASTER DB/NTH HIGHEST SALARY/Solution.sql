CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
DECLARE M INT;
SET M = N-1;
RETURN ( SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC LIMIT 1 OFFSET M );
END

/* 
SELECT Salary from Employee e1 
WHERE N-1 = (SELECT COUNT(DISTINCT sal) FROM Employee e2 where e2.sal > e1.sal) 
*/

