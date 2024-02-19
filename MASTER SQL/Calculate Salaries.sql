-- Calculate Salaries
"CREATE TABLE Salaries (
    company_id INT,
    employee_id INT,
    employee_name VARCHAR(50),
    salary INT
);
INSERT INTO Salaries (company_id, employee_id, employee_name, salary) VALUES 
(1, 1, 'Tony', 2000),
(1, 2, 'Pronub', 21300),
(1, 3, 'Tyrrox', 10800),
(2, 1, 'Pam', 300),
(2, 7, 'Bassem', 450),
(2, 9, 'Hermione', 700),
(3, 7, 'Bocaben', 100),
(3, 2, 'Ognjen', 2200),
(3, 13, 'Nyancat', 3300),
(3, 15, 'Morninngcat', 1866);"	

"with cte as (
select company_id,case when max(salary)<1000 then 0 when max(salary)>=1000 and max(salary)<10000 then 24 else 49 end as tax_rate
from Salaries
group by company_id
) 
select Salaries.company_id,employee_id,employee_name , (salary-salary*tax_rate/100) as tax_rate
from Salaries
left join cte on Salaries.company_id = cte.company_id"