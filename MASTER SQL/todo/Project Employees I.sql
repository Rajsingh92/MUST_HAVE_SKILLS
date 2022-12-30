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




/*
Write an SQL query that reports all the projects that have the most employees.

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
+-------------+
| project_id  |
+-------------+
| 1           |
+-------------+
The first project has 3 employees while the second one has 2.

*/


WITH 
result as
(
    select project_id, count(*) as cnt 
    from project 
    group by project_id
),
result1 as
(
    select project_id, cnt,
    max(cnt) over() as max_cnt
    from result
)

select project_id 
from result1 
where cnt = max_cnt







/*
Write an SQL query that reports the most experienced employees in each project. In case of a tie, 
report all employees with the maximum number of experience years.

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
| 3           | John   | 3                |
| 4           | Doe    | 2                |
+-------------+--------+------------------+

Result table:
+-------------+---------------+
| project_id  | employee_id   |
+-------------+---------------+
| 1           | 1             |
| 1           | 3             |
| 2           | 1             |
+-------------+---------------+

Both employees with id 1 and 3 have the most experience among the employees of the first project. 
For the second project, the employee with id 1 has the most experience.
*/


select project_id, employee_id
from Project left join Employee ON p.employee_id = e.employee_id
where (project_id,experience_years) in 
    (
        select 
            project_id,
            max(experience_years) 
        from Project p left join Employee e ON p.employee_id = e.employee_id
        group by 1
    );



select project_id, employee_id
from (select 
        project_id, 
        employee_id, 
        rank() over (partition by project_id order by experience_years desc) rk
    from Project left join Employee ON p.employee_id = e.employee_id
) t
where rk =1




