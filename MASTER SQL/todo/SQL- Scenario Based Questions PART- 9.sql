Q1.Write a SQL query to display EMPID , EMAILID and DEPT_NAME for those employee whose Department Name has not been assigned.


SELECT EMPID,EMAILID,DEPT_NAME
FROM EMP_DETAILS E
INNER JOIN DEPT_DETAILS D
ON E.DEPT_ID =D.DEPT_ID
AND D.DEPT_NAME IS NULL ;


Q2.Write a SQL query to display EMPID , EMAILID and DEPT_NAME for all Employee ID. For those EmployeeID whose Department Name has not been assigned , it should display with 'NA'.



SELECT EMPID,EMAILID,D.DEPT_ID,
CASE WHEN D.DEPT_NAME IS NULL THEN 'NA'
ELSE D.DEPT_NAME END AS DEPT_NAME
FROM EMP_DETAILS E
LEFT OUTER JOIN DEPT_DETAILS D
ON E.DEPT_ID =D.DEPT_ID ;




Q3.Write a SQL query to display only those DEPT_ID and DEPT_NAME which has been assigned more than 2 times.



SELECT D.DEPT_ID,DEPT_NAME,
       COUNT(*)AS COUNT
FROM EMP_DETAILS E
INNER JOIN DEPT_DETAILS D
ON E.DEPT_ID =D.DEPT_ID
GROUP BY  D.Dept_Id,DEPT_NAME
HAVING COUNT(*)> 2;

