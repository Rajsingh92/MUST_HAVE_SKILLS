select  
(select max(salary) from db_employee where db_employee.department_id = 4) - 
(select max(salary) from db_employee where db_employee.department_id = 1) 
as salary_difference;

select  
(select max(salary) from  db_employee e inner join db_dept d on e.department_id = d.id where department = 'marketing') - 
(select max(salary) from  db_employee e inner join db_dept d on e.department_id = d.id where department = 'engineering')
as salary_difference;



