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