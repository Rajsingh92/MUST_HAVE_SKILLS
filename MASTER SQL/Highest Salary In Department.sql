/*
Highest Salary In Department

Find the employee with the highest salary per department.
Output the department name, employee's first name along with the corresponding salary.

employee
    id int
    first_name varchar
    last_name varchar
    age int
    sex varchar
    employee_title varchar
    department varchar
    salary int
    target int
    bonus int
    email varchar
    city varchar
    address varchar
    manager_id int
*/

SELECT department, first_name employee_name, salary 
FROM employee
WHERE (department,salary) IN (
    SELECT department,MAX(salary) highest_salary
    FROM employee
    GROUP BY department
)


