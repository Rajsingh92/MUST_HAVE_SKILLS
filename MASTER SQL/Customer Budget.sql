/*
Customer Budget

find how many products falls into customer budget along with the list of products
in case of clash choose the less costly product 

+---------------+-----------+---------------+
| customer_id   | budget    | operation_day |
+---------------+-----------+---------------+
| 100           | 400       | p1            |
| 200           | 800       | p1,p2         |
| 300           | 1500      | p1,p2,p3      |
+---------------+-----------+---------------+
*/

create table products
(
product_id varchar(20) ,
cost int
);
insert into products values ('P1',200),('P2',300),('P3',500),('P4',800);

create table customer_budget
(
customer_id int,
budget int
);
insert into customer_budget values (100,400),(200,800),(300,1500);



with running_total as (
select *,sum(cost) over(order by cost asc) as r_total 
from products
)
select customer_id,budget,count(1) as no_of_products,STRING_AGG(product_id,',') as product_list from customer_budget cb 
left join running_total as rt on budget >= r_total
group by customer_id,budget


