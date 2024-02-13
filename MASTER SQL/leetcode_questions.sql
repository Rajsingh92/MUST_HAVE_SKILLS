-- Calculate the Influence of Each Salesperson

"CREATE TABLE Salesperson (
    salesperson_id INT,
    name VARCHAR(50)
);
INSERT INTO Salesperson (salesperson_id, name) VALUES 
(1, 'Alice'),
(2, 'Bob'),
(3, 'Jerry');

CREATE TABLE Customer (
    customer_id INT,
    salesperson_id INT
);
INSERT INTO Customer (customer_id, salesperson_id) VALUES 
(1, 1),
(2, 1),
(3, 2);

CREATE TABLE Sales (
    sale_id INT,
    customer_id INT,
    price INT
);
INSERT INTO Sales (sale_id, customer_id, price) VALUES 
(1, 2, 892),
(2, 1, 354),
(3, 3, 988),
(4, 3, 856);"
"select sp.*,COALESCE(price,0) from Salesperson sp
left join (
select c.Salesperson_id,sum(price) as price
from Sales S
left join Customer c on S.customer_id = c.customer_id
group by c.Salesperson_id
) as sc 
on sp.Salesperson_id = sc.Salesperson_id"

---------------------------------------------------------------------------------------

-- Number of Calls Between Two Persons
"CREATE TABLE Calls (
    from_id INT,
    to_id INT,
    duration INT
);
INSERT INTO Calls (from_id, to_id, duration) VALUES 
(1, 2, 59),
(2, 1, 11),
(1, 3, 20),
(3, 4, 100),
(3, 4, 200),
(3, 4, 200),
(4, 3, 499);"	

"select case when from_id > to_id then to_id else from_id end as person1,
case when from_id > to_id then from_id else to_id end as person2,count(*) as call_count ,sum(duration) as total_duration
from calls
group by 
case when from_id > to_id then to_id else from_id end,
case when from_id > to_id then from_id else to_id end"


---------------------------------------------------------------------------------------

-- The Most Frequently Ordered Products for Each Customer
"drop table if exists Customers;
CREATE TABLE Customers (
    customer_id INT,
    name VARCHAR(50)
);
INSERT INTO Customers (customer_id, name) VALUES 
(1, 'Alice'),
(2, 'Bob'),
(3, 'Tom'),
(4, 'Jerry'),
(5, 'John');
drop table if exists Products;
CREATE TABLE Products (
    product_id INT,
    product_name VARCHAR(50),
    price INT
);
INSERT INTO Products (product_id, product_name, price) VALUES 
(1, 'keyboard', 120),
(2, 'mouse', 80),
(3, 'screen', 600),
(4, 'hard disk', 450);
drop table if exists Orders;
CREATE TABLE Orders (
    order_id INT,
    order_date DATE,
    customer_id INT,
    product_id INT
);
INSERT INTO Orders (order_id, order_date, customer_id, product_id) VALUES 
(1, '2020-07-31', 1, 1),
(2, '2020-07-30', 2, 2),
(3, '2020-08-29', 3, 3),
(4, '2020-07-29', 4, 1),
(5, '2020-06-10', 1, 2),
(6, '2020-08-01', 2, 1),
(7, '2020-08-01', 3, 3),
(8, '2020-08-03', 1, 2),
(9, '2020-08-07', 2, 3),
(10, '2020-07-15', 1, 2);"	

"select ff.customer_id,ff.product_id,product_name from(
select customer_id,product_id, rank() over(partition by customer_id order by count(*)) as rn 
from Orders
group by customer_id,product_id
) ff
left join Products prod on ff.product_id = prod.product_id
where rn=1"


---------------------------------------------------------------------------------------

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


---------------------------------------------------------------------------------------

-- Tournament Winners
"
CREATE TABLE Players (
    player_id INT,
    group_id INT
);
INSERT INTO Players (player_id, group_id) VALUES 
(15, 1),
(25, 1),
(30, 1),
(45, 1),
(10, 2),
(35, 2),
(50, 2),
(20, 3),
(40, 3);
CREATE TABLE Matches (
    match_id INT,
    first_player INT,
    second_player INT,
    first_score INT,
    second_score INT
);
INSERT INTO Matches (match_id, first_player, second_player, first_score, second_score) VALUES 
(1, 15, 45, 3, 0),
(2, 30, 25, 1, 2),
(3, 30, 15, 2, 0),
(4, 40, 20, 5, 2),
(5, 35, 50, 1, 1);"	

"with cte as (
select first_player as player_id, first_score as score from Matches
union all
select second_player as player_id, second_score as score from Matches
),
cte2 as (
select p.player_id,p.group_id,coalesce(sum(score),0) as score 
from Players p
left join cte on cte.player_id = p.player_id
group by p.player_id,p.group_id
),
cte3 as (
select * , rank() over(partition by group_id order by score desc ,player_id asc) as rk
from cte2
) 
select * from cte3 where rk = 1"



---------------------------------------------------------------------------------------

