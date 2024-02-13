-- Q1.Write a SQL query to display Employee Name , Department Name and Location


SELECT EmpName,DeptName,Location FROM Employee E
INNER JOIN Department D 
ON E.DeptNo=D.DeptNo
;

/*
df_result = df_employee.join(df_department, df_employee["DeptNo"] == df_department["DeptNo"], "inner") \
    .select(df_employee["EmpName"], df_department["DeptName"], df_department["Location"])
*/







-- Q2. Write a SQL query to display total number of Employee and maximum salary under each Department Name .
SELECT D.DeptName,
       Max(Salary)As MaxSalary,
       COUNT(EmpName) As TotEmp
FROM Department D
LEFT OUTER JOIN Employee E
ON E.DeptNo=D.DeptNo
GROUP BY D.DeptName
;

/*
df_result = df_department.join(df_employee, df_department["DeptNo"] == df_employee["DeptNo"], "left_outer") \
    .groupBy(df_department["DeptName"]) \
    .agg(max(df_employee["Salary"]).alias("MaxSalary"), count(df_employee["EmpName"]).alias("TotEmp"))
*/






-- Q3. Write a SQL query to list maximum salary, minimum salary and average salary designationwise, for department 200 and display only those records which has average salary greater than 10000.

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
;


/*
df_result = df_employee.join(df_department,df_department["DeptNo"]==df_employee["DeptNo"],"inner") \
                .where(df_department["DeptNo"] == 200) \
                .groupBy(df_employee["Designation"]) \
                .agg(max(df_employee["salary"]).alias("MaxSalary"),min(df_employee["salary"]).alias("MinSalary"),avg(df_employee["salary"]).alias("AvgSalary")) \
                .having(col("AvgSalary")>10000)
*/




-- Q4. Suppose there is a table which contains a column NetBalance which has both negative and positive values. Now you have to write a query to dispaly sum of all positive Balances and sum of all negative Balances.

SELECT SUM(CASE WHEN NetBalance < 0 THEN NetBalance
           ELSE 0 END )As Negative,
       SUM(CASE WHEN NetBalance > 0 THEN NetBalance
           ELSE 0 END )As Positive
FROM BalanceInfo
;


SELECT SUM(CASE WHEN SIGN(NetBalance)= -1 THEN NetBalance
           ELSE 0 END )As Negative,
       SUM(CASE WHEN SIGN(NetBalance)= 1 THEN NetBalance
           ELSE 0 END )As Positive
FROM BalanceInfo
;



-- Q5. We want the output table should display NAME field and it should contain EMPNAME field values leaving behind first and last character in it. Please see below in details.

SELECT EMPID ,EMPNMAE,EMAILID,AGE,GENDER,
SUBSTR(EMPNMAE,2,LENGTH(EMPNMAE)-2) Name FROM EMPLOYEE_INFO;


