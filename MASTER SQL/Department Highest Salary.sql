/*
Write an SQL query to find employees who have the highest salary in each of the departments.

Employee table:
+----+-------+--------+--------------+
| id | name  | salary | departmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Jim   | 90000  | 1            |
| 3  | Henry | 80000  | 2            |
| 4  | Sam   | 60000  | 2            |
| 5  | Max   | 90000  | 1            |
+----+-------+--------+--------------+
Department table:
+----+-------+
| id | name  |
+----+-------+
| 1  | IT    |
| 2  | Sales |
+----+-------+

Output: 
+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Jim      | 90000  |
| Sales      | Henry    | 80000  |
| IT         | Max      | 90000  |
+------------+----------+--------+


*/

SELECT 
    d.name Department, 
    e.name Employee , 
    Salary
FROM Employee e JOIN Department d
ON e.departmentId  = d.id
WHERE (e.departmentId ,  e.salary ) IN
(
  SELECT departmentId, MAX(Salary)
  FROM Employee
  GROUP BY departmentId 
)


  


