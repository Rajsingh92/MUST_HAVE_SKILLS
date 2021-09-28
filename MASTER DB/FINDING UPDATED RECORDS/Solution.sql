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

