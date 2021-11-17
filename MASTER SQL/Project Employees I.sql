/*
Write an SQL query that reports the average experience years of all the employees for 
each project, rounded to 2 digits.

Project table:
+-------------+-------------+
| project_id  | employee_id |
+-------------+-------------+
| 1           | 1           |
| 1           | 2           |
| 1           | 3           |
| 2           | 1           |
| 2           | 4           |
+-------------+-------------+

Employee table:
+-------------+--------+------------------+
| employee_id | name   | experience_years |
+-------------+--------+------------------+
| 1           | Khaled | 3                |
| 2           | Ali    | 2                |
| 3           | John   | 1                |
| 4           | Doe    | 2                |
+-------------+--------+------------------+

Result table:
+-------------+---------------+
| project_id  | average_years |
+-------------+---------------+
| 1           | 2.00          |
| 2           | 2.50          |
+-------------+---------------+
The average experience years for the first project is (3 + 2 + 1) / 3 = 2.00 and for the second project is (3 + 2) / 2 = 2.50

*/

select 
    project_id, 
    ifnull(round(avg(experience_years), 2), 0) as average_years
from Project left join Employee
on Project.employee_id = Employee.employee_id
group by project_id;



select distinct 
    s.project_id, 
    round(avg(cast(s.experience_years as decimal)) over(partition by s.project_id), 2) as average_years
from (
    select 
        p.project_id, 
        p.employee_id, 
        e.experience_years
    from project p left join employee e
    on p.employee_id = e.employee_id
)  s


