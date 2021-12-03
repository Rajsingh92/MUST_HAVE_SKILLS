/*
A company wants to divide the employees into teams such that all the members on each team have the same 
salary. The teams should follow these criteria:

Each team should consist of at least two employees.
All the employees on a team should have the same salary.
All the employees of the same salary should be assigned to the same team.
If the salary of an employee is unique, we do not assign this employee to any team.
A team’s ID is assigned based on the rank of the team’s salary relative to the other teams’ salaries, 
where the team with the lowest salary has team_id = 1. Note that the salaries for employees not on a team 
are not included in this ranking.
Write an SQL query to get the team_id of each employee that is in a team.


Employees table:
+-------------+---------+--------+
| employee_id | name    | salary |
+-------------+---------+--------+
| 2           | Meir    | 3000   |
| 3           | Michael | 3000   |
| 7           | Addilyn | 7400   |
| 8           | Juan    | 6100   |
| 9           | Kannon  | 7400   |
+-------------+---------+--------+

Result table:
+-------------+---------+--------+---------+
| employee_id | name    | salary | team_id |
+-------------+---------+--------+---------+
| 2           | Meir    | 3000   | 1       |
| 3           | Michael | 3000   | 1       |
| 7           | Addilyn | 7400   | 2       |
| 9           | Kannon  | 7400   | 2       |
+-------------+---------+--------+---------+


Create table If Not Exists Employees (employee_id int, name varchar(30), salary int);
Truncate table Employees;
insert into Employees (employee_id, name, salary) values ('2', 'Meir', '3000');
insert into Employees (employee_id, name, salary) values ('3', 'Michael', '3000');
insert into Employees (employee_id, name, salary) values ('7', 'Addilyn', '7400');
insert into Employees (employee_id, name, salary) values ('8', 'Juan', '6100');
insert into Employees (employee_id, name, salary) values ('9', 'Kannon', '7400');
*/


with t as (
	SELECT salary, ROW_NUMBER() OVER(ORDER BY salary) team_id 
	FROM employees
	GROUP BY salary
	HAVING COUNT(1) >1 
)
SELECT e.*, t.team_id
FROM t LEFT JOIN Employees e ON t.salary = e.salary
ORDER BY team_id, employee_id;


select *, dense_rank() over(order by salary) team_id
from Employees
where salary in 
	(select salary
	from Employees
	group by salary
	having count(*) > 1)
order by team_id, employee_id;

