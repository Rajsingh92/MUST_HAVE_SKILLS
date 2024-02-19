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