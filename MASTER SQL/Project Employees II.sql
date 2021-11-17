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



