/*
Finding Updated Records

We have a table with employees and their salaries, however, some of the records are 
old and contain outdated salary information. Find the current salary of each employee 
assuming that salaries increase each year. Output their id, first name, last name, 
department ID, and current salary. Order your list by employee ID in ascending order.

ms_employee_salary
id	first_name	last_name	salary	department_id
1	Todd	    Wilson	    110000	1006
1	Todd	    Wilson	    106119	1006
2	Justin	    Simon	    128922	1005
2	Justin	    Simon	    130000	1005

Output:
id	first_name	last_name	salary	department_id
1	Todd	    Wilson	    110000	1006
2	Justin	    Simon	    130000	1005

*/


SELECT 
    id,
    first_name,
    last_name,
    department_id,
    max(salary) 
FROM ms_employee_salary 
GROUP BY 
    id,
    department_id,
    first_name,
    last_name 
ORDER BY id;

