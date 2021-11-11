/*
Salaries Differences

Write a query that calculates the difference between the highest salaries found in the 
marketing and engineering departments. Output just the difference in salaries.

db_employee
id	first_name	last_name	salary	department_id
10301	Keith	Morgan	27056	2
10302	Tyler	Booth	32199	3
10303	Clifford	Nguyen	32165	2
10304	Mary	Jones	49488	3
10305	Melissa	Lucero	27024	3


db_dept
id	department
1	engineering
2	human resource
3	operation
4	marketing
5	sales
6	customer care

*/

select  
(select max(salary) from db_employee where db_employee.department_id = 4) - 
(select max(salary) from db_employee where db_employee.department_id = 1) 
as salary_difference;

select  
(select max(salary) from  db_employee e inner join db_dept d on e.department_id = d.id where department = 'marketing') - 
(select max(salary) from  db_employee e inner join db_dept d on e.department_id = d.id where department = 'engineering')
as salary_difference;



