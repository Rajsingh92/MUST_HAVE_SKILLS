Q1.Write a SQL query to display Employee Name , Department Name and Location


SELECT EmpName,DeptName,Location FROM Employee E
INNER JOIN Department D 
ON E.DeptNo=D.DeptNo

Q2.Write a SQL query to display total number of Employee and maximum salary under each Department Name .
SELECT D.DeptName,
       Max(Salary)As MaxSalary,
       COUNT(EmpName) As TotEmp
FROM Department D
LEFT OUTER JOIN Employee E
ON E.DeptNo=D.DeptNo
GROUP BY D.DeptName


Q2.Write a SQL query to list maximum salary, minimum salary and average salary designationwise, for department 200 and display only those records which has average salary greater than 10000.

SELECT E.Designation,
       Max(Salary)As MaxSalary,
       Min(Salary)As MinSalary,
       AVG(Salary) As AvgSalary
FROM Employee E
INNER JOIN Department D
ON E.DeptNo=D.DeptNo
WHERE D.DeptNo=200
GROUP BY E.Designation
HAVING AVG(Salary) > 10000