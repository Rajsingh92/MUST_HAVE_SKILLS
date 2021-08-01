drop database rajsinghdb;
create database rajsinghdb;
use rajsinghdb;
        
CREATE TABLE salesman (
    salesman_id int,
    name varchar(255),
    city varchar(255),
    commission FLOAT
);

INSERT INTO salesman (salesman_id, name, City, commission)
VALUES ('5001', 'James Hoog', 'New York', ' 0.15');
INSERT INTO salesman (salesman_id, name, City, commission)
VALUES ('5002', 'Nail Knite', 'Paris', ' 0.13');
INSERT INTO salesman (salesman_id, name, City, commission)
VALUES ('5005', 'Pit Alex', 'London', ' 0.11');
INSERT INTO salesman (salesman_id, name, City, commission)
VALUES ('5006', 'Mc Lyon', 'Paris', ' 0.14');
INSERT INTO salesman (salesman_id, name, City, commission)
VALUES ('5007', 'Paul Adam', 'Rome', ' 0.13');
INSERT INTO salesman (salesman_id, name, City, commission)
VALUES ('5003', 'Lauson Hen', 'San Jose', ' 0.12');




CREATE TABLE customer (
    customer_id int,
    cust_name varchar(255),
    city varchar(255),
    grade int,
    salesman_id int
);

INSERT INTO customer (customer_id, cust_name, City, grade,salesman_id)
VALUES ('3002', 'Nick Rimando', 'New York', '100','5001');
INSERT INTO customer (customer_id, cust_name, City, grade,salesman_id)
VALUES ('3007' , 'Brad Davis' ,'New York','200','5001');
INSERT INTO customer (customer_id, cust_name, City, grade,salesman_id)
VALUES ('3005',  'Graham Zusi' , 'California' ,'200' ,'5002');
INSERT INTO customer (customer_id, cust_name, City, grade,salesman_id)
VALUES ( '3008' , 'Julian Green', 'London'  ,'300' ,'5002');
INSERT INTO customer (customer_id, cust_name, City, grade,salesman_id)
VALUES ('3004' , 'Fabian Johnson' , 'Paris','300' ,'5006');
INSERT INTO customer (customer_id, cust_name, City, grade,salesman_id)
VALUES ('3009' , 'Geoff Cameron'  , 'Berlin'  ,'100' ,'5003');
INSERT INTO customer (customer_id, cust_name, City, grade,salesman_id)
VALUES ('3003' , 'Jozy Altidor', 'Moscow','200','5007');
INSERT INTO customer (customer_id, cust_name, City,salesman_id)
VALUES ('3001' , 'Brad Guzan', 'London' ,'5005');


CREATE TABLE orders (
    ord_no int,
    purch_amt FLOAT,
    ord_date DATE,
    customer_id int,
    salesman_id int
);
INSERT INTO orders (ord_no, purch_amt, ord_date,customer_id,salesman_id)
VALUES ('70001','150.5','2012-10-05','3005','5002');
INSERT INTO orders (ord_no, purch_amt, ord_date,customer_id,salesman_id)
VALUES ('70009','270.65','2012-09-10','3001','5005');
INSERT INTO orders (ord_no, purch_amt, ord_date,customer_id,salesman_id)
VALUES ('70002','65.26','2012-10-05','3002','5001');
INSERT INTO orders (ord_no, purch_amt, ord_date,customer_id,salesman_id)
VALUES ('70004','110.5','2012-08-17','3009','5003');
INSERT INTO orders (ord_no, purch_amt, ord_date,customer_id,salesman_id)
VALUES ('70007','948.5','2012-09-10','3005','5002');
INSERT INTO orders (ord_no, purch_amt, ord_date,customer_id,salesman_id)
VALUES ('70005','2400.6', '2012-07-27','3007','5001');
INSERT INTO orders (ord_no, purch_amt, ord_date,customer_id,salesman_id)
VALUES ('70008','5760', '2012-09-10','3002','5001');
INSERT INTO orders (ord_no, purch_amt, ord_date,customer_id,salesman_id)
VALUES ('70010','1983.43', '2012-10-10','3004','5006');
INSERT INTO orders (ord_no, purch_amt, ord_date,customer_id,salesman_id)
VALUES ('70003','2480.4','2012-10-10','3009','5003');
INSERT INTO orders (ord_no, purch_amt, ord_date,customer_id,salesman_id)
VALUES ('70012','250.45','2012-06-27','3008','5002');
INSERT INTO orders (ord_no, purch_amt, ord_date,customer_id,salesman_id)
VALUES ('70011','75.29','2012-08-17','3003','5007');
INSERT INTO orders (ord_no, purch_amt, ord_date,customer_id,salesman_id)
VALUES ('70013','3045.6','2012-04-25','3002','5001');

                        
                             
CREATE TABLE emp_department (
    DPT_CODE int,
    DPT_NAME varchar(30),
    DPT_ALLOTMENT int
);     
INSERT INTO emp_department (DPT_CODE, DPT_NAME,DPT_ALLOTMENT)
VALUES ('57' , 'IT' ,'65000');   
INSERT INTO emp_department (DPT_CODE, DPT_NAME,DPT_ALLOTMENT)
VALUES ('63' , 'Finance' ,'15000');  
INSERT INTO emp_department (DPT_CODE, DPT_NAME,DPT_ALLOTMENT)
VALUES ('47' , 'HR' ,'240000');  
INSERT INTO emp_department (DPT_CODE, DPT_NAME,DPT_ALLOTMENT)
VALUES ('27' , 'RD' ,'55000');  
INSERT INTO emp_department (DPT_CODE, DPT_NAME,DPT_ALLOTMENT)
VALUES ('89' , 'QC' ,'75000');     
      

                  
CREATE TABLE emp_details (
    EMP_IDNO int,
    EMP_FNAME varchar(100),
    EMP_LNAME varchar(100),
    EMP_DEPT int
);    
INSERT INTO emp_details (EMP_IDNO, EMP_FNAME, EMP_LNAME,EMP_DEPT)
VALUES ('127323','Michale','Robbin','57');
INSERT INTO emp_details (EMP_IDNO, EMP_FNAME, EMP_LNAME,EMP_DEPT)
VALUES ('526689' ,'Carlos','Snares','63');
INSERT INTO emp_details (EMP_IDNO, EMP_FNAME, EMP_LNAME,EMP_DEPT)
VALUES ('843795', 'Enric', 'Dosio','57');
INSERT INTO emp_details (EMP_IDNO, EMP_FNAME, EMP_LNAME,EMP_DEPT)
VALUES ('328717' , 'Jhon', 'Snares', '63');
INSERT INTO emp_details (EMP_IDNO, EMP_FNAME, EMP_LNAME,EMP_DEPT)
VALUES ('444527' , 'Joseph','Dosni', '47');
INSERT INTO emp_details (EMP_IDNO, EMP_FNAME, EMP_LNAME,EMP_DEPT)
VALUES ('659831' , 'Zanifer' , 'Emily', '47');
INSERT INTO emp_details (EMP_IDNO, EMP_FNAME, EMP_LNAME,EMP_DEPT)
VALUES ('847674' ,'Kuleswar','Sitaraman', '57');
INSERT INTO emp_details (EMP_IDNO, EMP_FNAME, EMP_LNAME,EMP_DEPT)
VALUES ('748681', 'Henrey','Gabriel','47');
INSERT INTO emp_details (EMP_IDNO, EMP_FNAME, EMP_LNAME,EMP_DEPT)
VALUES ('555935','Alex', 'Manuel','57');
INSERT INTO emp_details (EMP_IDNO, EMP_FNAME, EMP_LNAME,EMP_DEPT)
VALUES ('539569', 'George','Mardy', '27');
INSERT INTO emp_details (EMP_IDNO, EMP_FNAME, EMP_LNAME,EMP_DEPT)
VALUES ('733843' ,'Mario', 'Saule', '63');
INSERT INTO emp_details (EMP_IDNO, EMP_FNAME, EMP_LNAME,EMP_DEPT)
VALUES ('631548', 'Alan', ' Snappy', '27');
INSERT INTO emp_details (EMP_IDNO, EMP_FNAME, EMP_LNAME,EMP_DEPT)
VALUES ('839139' ,'Maria', 'Foster',' 57');

   
    
CREATE TABLE company_mast (
    COM_ID int,
    COM_NAME varchar(100)
);  
INSERT INTO company_mast (COM_ID, COM_NAME)
VALUES ('11', 'Samsung');
INSERT INTO company_mast (COM_ID, COM_NAME)
VALUES ('12', 'iBall');
INSERT INTO company_mast (COM_ID, COM_NAME)
VALUES ('13', 'Epsion');
INSERT INTO company_mast (COM_ID, COM_NAME)
VALUES ('14', 'Zebronics');
INSERT INTO company_mast (COM_ID, COM_NAME)
VALUES ('15', 'Asus');
INSERT INTO company_mast (COM_ID, COM_NAME)
VALUES ('16', 'Frontech');
    

    
CREATE TABLE item_mast (
    PRO_ID int,
    PRO_NAME varchar(100),
    PRO_PRICE int,
    PRO_COM int
);    
INSERT INTO item_mast (PRO_ID, PRO_NAME, PRO_PRICE,PRO_COM)
VALUES ('101', 'Mother Board','3200','15');
INSERT INTO item_mast (PRO_ID, PRO_NAME, PRO_PRICE,PRO_COM)
VALUES ('102', 'Key Board','450','16');
INSERT INTO item_mast (PRO_ID, PRO_NAME, PRO_PRICE,PRO_COM)
VALUES ('103', 'ZIP drive','250','14');
INSERT INTO item_mast (PRO_ID, PRO_NAME, PRO_PRICE,PRO_COM)
VALUES ('104', 'Speaker','550','16');
INSERT INTO item_mast (PRO_ID, PRO_NAME, PRO_PRICE,PRO_COM)
VALUES ('105', 'Monitor','5000','11');
INSERT INTO item_mast (PRO_ID, PRO_NAME, PRO_PRICE,PRO_COM)
VALUES ('106', 'DVD drive','900','12');
INSERT INTO item_mast (PRO_ID, PRO_NAME, PRO_PRICE,PRO_COM)
VALUES ('107', 'CD drive','800','12');
INSERT INTO item_mast (PRO_ID, PRO_NAME, PRO_PRICE,PRO_COM)
VALUES ('108', 'Printer','2600','13');
INSERT INTO item_mast (PRO_ID, PRO_NAME, PRO_PRICE,PRO_COM)
VALUES ('109', 'Refill cartridge','350','13');
INSERT INTO item_mast (PRO_ID, PRO_NAME, PRO_PRICE,PRO_COM)
VALUES ('110', 'Mouse','250','12');
    
########################################################           JOINS       #####################################################################
/* Write a SQL statement to prepare a list with salesman name, customer name and their cities for the salesmen and customer who belongs to the same city.*/

select s.name,c.cust_name,c.city from salesman s ,customer c where c.city = s.city;


/*Write a SQL statement to make a list with order no, purchase amount, customer name and their cities for those orders which order amount between 500 and 2000*/
SELECT  a.ord_no,a.purch_amt,
b.cust_name,b.city 
FROM orders a,customer b 
WHERE a.customer_id=b.customer_id 
AND a.purch_amt BETWEEN 500 AND 2000;

# Write a SQL statement to know which salesman are working for which customer.
SELECT a.cust_name AS "Customer Name", 
a.city, b.name AS "Salesman", b.commission 
FROM customer a 
INNER JOIN salesman b 
ON a.salesman_id=b.salesman_id;

# Write a SQL statement to find the list of customers who appointed a salesman for their jobs who gets a commission from the company is more than 12%
SELECT a.cust_name AS "Customer Name", 
a.city, b.name AS "Salesman", b.commission 
FROM customer a 
INNER JOIN salesman b 
ON a.salesman_id=b.salesman_id 
WHERE b.commission>.12;

# Write a SQL statement to find the list of customers who appointed a salesman for their jobs who does not live in the same city where their customer lives, and gets a commission is above 12%
SELECT a.cust_name AS "Customer Name", 
a.city, b.name AS "Salesman", b.city,b.commission  
FROM customer a  
INNER JOIN salesman b  
ON a.salesman_id=b.salesman_id 
WHERE b.commission>.12 
AND a.city<>b.city;

# Write a SQL statement to find the details of a order i.e. order number, order date, amount of order, which customer gives the order and which salesman works for that customer and how much commission he gets for an order. 
SELECT a.ord_no,a.ord_date,a.purch_amt,
b.cust_name AS "Customer Name", b.grade, 
c.name AS "Salesman", c.commission 
FROM orders a 
INNER JOIN customer b 
ON a.customer_id=b.customer_id 
INNER JOIN salesman c 
ON a.salesman_id=c.salesman_id;

# Write a SQL statement to make a join on the tables salesman, customer and orders in such a form that the same column of each table will appear once and only the relational rows will come.
SELECT * 
FROM orders 
NATURAL JOIN customer  
NATURAL JOIN salesman;

# Write a SQL statement to make a list in ascending order for the customer who works either through a salesman or by own.
SELECT a.cust_name,a.city,a.grade, 
b.name AS "Salesman",b.city 
FROM customer a 
LEFT JOIN salesman b 
ON a.salesman_id=b.salesman_id 
order by a.customer_id;

# Write a SQL statement to make a list in ascending order for the customer who holds a grade less than 300 and works either through a salesman or by own.
SELECT a.cust_name,a.city,a.grade, 
b.name AS "Salesman", b.city 
FROM customer a 
LEFT OUTER JOIN salesman b 
ON a.salesman_id=b.salesman_id 
WHERE a.grade<300 
ORDER BY a.customer_id;

# Write a SQL statement to make a report with customer name, city, order number, order date, and order amount in ascending order according to the order date to find that either any of the existing customers have placed no order or placed one or more orders.
SELECT a.cust_name,a.city, b.ord_no,
b.ord_date,b.purch_amt AS "Order Amount" 
FROM customer a 
LEFT OUTER JOIN orders b 
ON a.customer_id=b.customer_id 
order by b.ord_date;

# Write a SQL statement to make a report with customer name, city, order number, order date, order amount salesman name and commission to find that either any of the existing customers have placed no order or placed one or more orders by their salesman or by own.
SELECT a.cust_name,a.city, b.ord_no,
b.ord_date,b.purch_amt AS "Order Amount", 
c.name,c.commission 
FROM customer a 
LEFT OUTER JOIN orders b 
ON a.customer_id=b.customer_id 
LEFT OUTER JOIN salesman c 
ON c.salesman_id=b.salesman_id;

# Write a SQL statement to make a list in ascending order for the salesmen who works either for one or more customer or not yet join under any of the customers
SELECT a.cust_name,a.city,a.grade, 
b.name AS "Salesman", b.city 
FROM customer a 
RIGHT OUTER JOIN salesman b 
ON b.salesman_id=a.salesman_id 
ORDER BY b.salesman_id;

# Write a SQL statement to make a list for all salesmen along with customer name, city, grade, order number, date, and amount. Condition for selecting list of salesmen : 1. Salesmen who works for one or more customer or, 2. Salesmen who not yet join under any customer, Condition for selecting list of customer : 3. placed one or more orders, or 4. no order placed to their salesman.
SELECT a.cust_name,a.city,a.grade, 
b.name AS "Salesman", 
c.ord_no, c.ord_date, c.purch_amt 
FROM customer a 
RIGHT OUTER JOIN salesman b 
ON b.salesman_id=a.salesman_id 
RIGHT OUTER JOIN orders c 
ON c.customer_id=a.customer_id;

# Write a SQL statement to make a list for the salesmen who either work for one or more customers or yet to join any of the customer. The customer, may have placed, either one or more orders on or above order amount 2000 and must have a grade, or he may not have placed any order to the associated supplier.
SELECT a.cust_name,a.city,a.grade, 
b.name AS "Salesman", 
c.ord_no, c.ord_date, c.purch_amt 
FROM customer a 
RIGHT OUTER JOIN salesman b 
ON b.salesman_id=a.salesman_id 
LEFT OUTER JOIN orders c 
ON c.customer_id=a.customer_id 
WHERE c.purch_amt>=2000 
AND a.grade IS NOT NULL;

# Write a SQL statement to make a report with customer name, city, order no., order date, purchase amount for those customers from the existing list who placed one or more orders or which order(s) have been placed by the customer who is not on the list.


# Write a SQL statement to make a report with customer name, city, order no. order date, purchase amount for only those customers on the list who must have a grade and placed one or more orders or which order(s) have been placed by the customer who is neither in the list nor have a grade.


# Write a SQL statement to make a cartesian product between salesman and customer i.e. each salesman will appear for all customer and vice versa.
SELECT * 
FROM salesman a 
CROSS JOIN customer b;

# Write a SQL statement to make a cartesian product between salesman and customer i.e. each salesman will appear for all customer and vice versa for that salesman who belongs to a city.
SELECT * 
FROM salesman a 
CROSS JOIN customer b 
WHERE a.city IS NOT NULL;

# Write a SQL statement to make a cartesian product between salesman and customer i.e. each salesman will appear for all customer and vice versa for those salesmen who belongs to a city and the customers who must have a grade.
SELECT * 
FROM salesman a 
CROSS JOIN  customer b 
WHERE a.city IS NOT NULL 
AND b.grade IS NOT NULL;

# Write a SQL statement to make a cartesian product between salesman and customer i.e. each salesman will appear for all customer and vice versa for those salesmen who must belong a city which is not the same as his customer and the customers should have an own grade.
SELECT * 
FROM salesman a 
CROSS JOIN customer b 
WHERE a.city IS NOT NULL 
AND b.grade IS NOT NULL 
AND  a.city<>b.city;

# Write a SQL query to display all the data from the item_mast, including all the data for each item's producer company.
SELECT *
FROM item_mast 
INNER JOIN company_mast
ON item_mast.pro_com= company_mast.com_id;

# Write a SQL query to display the item name, price, and company name of all the products.
SELECT item_mast.pro_name, pro_price, company_mast.com_name
   FROM item_mast 
     INNER JOIN company_mast
        ON item_mast.pro_com = company_mast.com_id; 

# Write a SQL query to display the average price of items of each company, showing the name of the company.
SELECT AVG(pro_price), company_mast.com_name
   FROM item_mast INNER 
     JOIN company_mast
        ON item_mast.pro_com= company_mast.com_id
           GROUP BY company_mast.com_name; 
           
# Write a SQL query to display the names of the company whose products have an average price larger than or equal to Rs.350.   
   SELECT AVG(pro_price), company_mast.com_name
   FROM item_mast INNER JOIN company_mast
   ON item_mast.pro_com= company_mast.com_id
   GROUP BY company_mast.com_name
   HAVING AVG(pro_price) >= 350;        

# Write a SQL query to display the name of each company along with the ID and price for their most expensive product.
SELECT A.pro_name, A.pro_price, F.com_name
   FROM item_mast A INNER JOIN company_mast F
   ON A.pro_com = F.com_id
     AND A.pro_price =
     (
       SELECT MAX(A.pro_price)
         FROM item_mast A
         WHERE A.pro_com = F.com_id
     );        
     
# Write a query in SQL to display all the data of employees including their department.
SELECT emp_idno, A.emp_fname AS "First Name", emp_lname AS "Last Name",
    B.dpt_name AS "Department", emp_dept, dpt_code,  dpt_allotment
     FROM emp_details A 
      INNER JOIN emp_department B
        ON A.emp_dept = B.dpt_code;
        

# Write a query in SQL to display the first name and last name of each employee, along with the name and sanction amount for their department.
SELECT emp_details.emp_fname AS "First Name", emp_lname AS "Last Name", 
    emp_department.dpt_name AS "Department", 
     dpt_allotment AS "Amount Allotted"
       FROM emp_details 
         INNER JOIN emp_department
           ON emp_details.emp_dept = emp_department.dpt_code;
           
           
# Write a query in SQL to find the first name and last name of employees working for departments with a budget more than Rs.50000.
SELECT emp_details.emp_fname AS "First Name", emp_lname AS "Last Name"
  FROM emp_details 
    INNER JOIN emp_department
        ON emp_details.emp_dept = emp_department.dpt_code
    AND emp_department.dpt_allotment > 50000;

# Write a query in SQL to find the names of departments where more than two employees are working.
SELECT emp_department.dpt_name
  FROM emp_details 
     INNER JOIN emp_department
       ON emp_dept =dpt_code
        GROUP BY emp_department.dpt_name
          HAVING COUNT(*) > 2;
           
# Write a query to find those customers with their name and those salesmen with their name and city who lives in the same city.
SELECT customer.cust_name,
salesman.name, salesman.city
FROM salesman, customer
WHERE salesman.city = customer.city;

# Write a SQL statement to find the names of all customers along with the salesmen who works for them.
SELECT customer.cust_name, salesman.name
FROM customer,salesman
WHERE salesman.salesman_id = customer.salesman_id;

# Write a SQL statement to display all those orders by the customers not located in the same cities where their salesmen live.
SELECT ord_no, cust_name, orders.customer_id, orders.salesman_id
FROM salesman, customer, orders
WHERE customer.city <> salesman.city
AND orders.customer_id = customer.customer_id
AND orders.salesman_id = salesman.salesman_id;

# Write a SQL statement that finds out each order number followed by the name of the customers who made the order.
SELECT orders.ord_no, customer.cust_name
FROM orders, customer
WHERE orders.customer_id = customer.customer_id; 

# Write a SQL statement that shorts out the customer and their grade who made an order. Each of the customers must have a grade and served by at least a salesman, who belongs to a city.
SELECT customer.cust_name AS "Customer",
customer.grade AS "Grade"
FROM orders, salesman, customer
WHERE orders.customer_id = customer.customer_id
AND orders.salesman_id = salesman.salesman_id
AND salesman.city IS NOT NULL
AND customer.grade IS NOT NULL;

# Write a query that produces all customers with their name, city, salesman and commission, who served by a salesman and the salesman works at a rate of the commission within 12% to 14%.
SELECT customer.cust_name AS "Customer",
customer.city AS "City",
salesman.name AS "Salesman",
salesman.commission
FROM customer,salesman
WHERE customer.salesman_id = salesman.salesman_id
AND salesman.commission
BETWEEN .12 AND .14;

# Write a SQL statement that produces all orders with the order number, customer name, commission rate and earned commission amount for those customers who carry their grade is 200 or more and served by an existing salesman.
SELECT ord_no, cust_name, commission AS "Commission%",
purch_amt*commission AS "Commission"
FROM salesman,orders,customer
WHERE orders.customer_id = customer.customer_id
AND orders.salesman_id = salesman.salesman_id
AND customer.grade>=200;

# Write a query to display all customers with orders on October 5, 2012.
SELECT *
FROM customer a,orders  b 
WHERE a.customer_id=b.customer_id 
AND b.ord_date='2012-10-05';

           
########################################################           SUBQUERIES        #####################################################################          
# Write a query to display all the orders from the orders table issued by the salesman 'Paul Adam'.
SELECT *
FROM orders
WHERE salesman_id =
    (SELECT salesman_id 
     FROM salesman 
     WHERE name='Paul Adam');

# Write a query to display all the orders for the salesman who belongs to the city London.
SELECT *
FROM orders
WHERE salesman_id =
    (SELECT salesman_id 
     FROM salesman 
     WHERE city='London');

# Write a query to find all the orders issued against the salesman who may works for customer whose id is 3007.
SELECT *
FROM orders
WHERE salesman_id =
    (SELECT DISTINCT salesman_id 
     FROM orders 
     WHERE customer_id =3007);

# Write a query to display all the orders which values are greater than the average order value for 10th October 2012.
SELECT *
FROM orders
WHERE purch_amt >
    (SELECT  AVG(purch_amt) 
     FROM orders 
     WHERE ord_date ='2012-10-10');

# Write a query to find all orders attributed to a salesman in New york
SELECT *
FROM orders
WHERE salesman_id IN
    (SELECT salesman_id 
     FROM salesman 
     WHERE city ='New York');
     
# Write a query to display the commission of all the salesmen servicing customers in Paris.
SELECT commission
FROM salesman
WHERE salesman_id IN
    (SELECT salesman_id 
     FROM customer
     WHERE city = 'Paris');

# Write a query to display the customer whose id is 2001 bellow the salesman ID of Mc Lyon.
SELECT *
FROM customer
WHERE customer_id =
    (SELECT salesman_id -2001
     FROM salesman
     WHERE name = 'Mc Lyon');

# Write a query to count the customers with grades above New York's average.

SELECT grade, COUNT(*)
FROM customer
GROUP BY grade
HAVING grade >
    (SELECT AVG(grade)
     FROM customer
     WHERE city = 'New York');

# Write a query to extract the data from the orders table for those salesman who earned the maximum commission.
SELECT ord_no, purch_amt, ord_date, salesman_id 
FROM orders 
WHERE salesman_id IN(
SELECT salesman_id 
FROM salesman
WHERE commission = (
SELECT MAX(commission) 
FROM salesman));

# Write a query to display all the customers with orders issued on date 17th August, 2012.
SELECT b.*, a.cust_name
FROM orders b, customer a
WHERE a.customer_id=b.customer_id
AND b.ord_date='2012-08-17';

# Write a query to find the salesmen who have multiple customers.
SELECT * 
FROM salesman 
WHERE salesman_id IN (
   SELECT DISTINCT salesman_id 
   FROM customer a 
   WHERE EXISTS (
      SELECT * 
      FROM customer b 
      WHERE b.salesman_id=a.salesman_id 
      AND b.cust_name<>a.cust_name));

# Write a query to find all the salesmen who worked for only one customer.
SELECT * 
FROM salesman 
WHERE salesman_id IN (
   SELECT DISTINCT salesman_id 
   FROM customer a 
   WHERE NOT EXISTS (
      SELECT * FROM customer b 
      WHERE a.salesman_id=b.salesman_id 
      AND a.cust_name<>b.cust_name));

#  Write a query that extract the rows of all salesmen who have customers with more than one orders.
SELECT * 
FROM salesman a 
WHERE EXISTS     
   (SELECT * FROM customer b     
    WHERE a.salesman_id=b.salesman_id     
	 AND 1<             
	     (SELECT COUNT(*)              
		  FROM orders             
		  WHERE orders.customer_id =            
		  b.customer_id));
          
# Write a query to find salesmen with all information who lives in the city where any of the customers lives.
SELECT *
FROM salesman 
WHERE city=ANY
    (SELECT city
     FROM customer);

# Write a query to find all the salesmen for whom there are customers that follow them.
SELECT *
FROM salesman 
WHERE city IN
    (SELECT city
     FROM customer);

# Write a query to extract all data from the customer table if and only if one or more of the customers in the customer table are located in London.
SELECT customer_id,cust_name, city
FROM customer
WHERE EXISTS
   (SELECT *
    FROM customer 
    WHERE city='London');
    
    
# Write a query to find the name and numbers of all salesmen who had more than one customer.
SELECT salesman_id,name 
FROM salesman a 
WHERE 1 < 
    (SELECT COUNT(*) 
     FROM customer 
     WHERE salesman_id=a.salesman_id);

# Write a query to find all orders with order amounts which are above-average amounts for their customers.
SELECT * 
FROM orders a
WHERE purch_amt >
    (SELECT AVG(purch_amt) FROM orders b 
     WHERE b.customer_id = a.customer_id);
     
# Write a queries to find all orders with order amounts which are on or above-average amounts for their customers.
SELECT * 
FROM orders a
WHERE purch_amt >=
    (SELECT AVG(purch_amt) FROM orders b 
     WHERE b.customer_id = a.customer_id);

# Write a query to find the sums of the amounts from the orders table, grouped by date, eliminating all those dates where the sum was not at least 1000.00 above the maximum amount for that date.
SELECT ord_date, SUM(purch_amt)
FROM orders a
GROUP BY ord_date
HAVING SUM(purch_amt) >
    (SELECT 1000.00 + MAX(purch_amt) 
     FROM orders b 
     WHERE a.ord_date = b.ord_date);

# Write a query to display the salesmen which name are alphabetically lower than the name of the customers.
SELECT *
FROM salesman a
WHERE EXISTS
   (SELECT *
	FROM CUSTOMER b
	WHERE  a.name  < b.cust_name);

# Write a query to display the customers who have a greater gradation than any customer who belongs to the alphabetically lower than the city New York.
SELECT *
FROM customer
WHERE grade > ANY
   (SELECT grade
	FROM CUSTOMER
	WHERE  city < 'New York');

# Write a query to display all the orders that had amounts that were greater than at least one of the orders from September 10th 2012.
SELECT *
FROM Orders
WHERE purch_amt > ANY
   (SELECT purch_amt
	FROM orders
	WHERE  ord_date='2012/09/10');

# Write a query to find all orders with an amount smaller than any amount for a customer in London.
SELECT *
FROM orders
WHERE purch_amt < ANY
   (SELECT purch_amt
	FROM orders a, customer b
	WHERE  a.customer_id=b.customer_id
	AND b.city='London');
    
# Write a query to display all orders with an amount smaller than the maximum amount for a customer in London.
SELECT *
FROM orders
WHERE purch_amt < 
   (SELECT MAX(purch_amt)
	FROM orders a, customer b
	WHERE  a.customer_id=b.customer_id
	AND b.city='London');

# Write a query to display only those customers whose grade are, in fact, higher than every customer in New York.
SELECT *
FROM customer
WHERE grade > ALL
   (SELECT grade
	FROM customer
	WHERE city='New York');

#  write a query in sql to find the name, city, and the total sum of orders amount a salesman collects. Salesman should belong to the cities where any of the customer belongs.
SELECT salesman.name, salesman.city, subquery1.total_amt FROM 
salesman, (SELECT salesman_id, SUM(orders.purch_amt) AS total_amt 
FROM orders GROUP BY salesman_id) subquery1 WHERE subquery1.salesman_id = salesman.salesman_id AND
salesman.city IN (SELECT DISTINCT city FROM customer);

# Write a query to get all the information for those customers whose grade is not as the grade of customer who belongs to the city London.

SELECT * FROM customer WHERE grade <> ALL 
(SELECT grade FROM customer WHERE city='London' AND NOT grade IS NULL);


#  Write a query to find all those customers whose grade are not as the grade, belongs to the city Paris.
SELECT *
FROM customer 
WHERE grade NOT IN
   (SELECT grade
	FROM customer
	WHERE city='Paris');

# Write a query to find all those customers who hold a different grade than any customer of the city Dallas.
SELECT *
FROM customer 
WHERE NOT grade = ANY
   (SELECT grade
	FROM customer
	WHERE city='Dallas');
    
# Write a SQL query to find the average price of each manufacturer's products along with their name.
SELECT AVG(pro_price) AS "Average Price", 
   company_mast.com_name As "Company"
   FROM item_mast, company_mast
        WHERE item_mast.pro_com= company_mast.com_id
           GROUP BY company_mast.com_name;
    
 # Write a SQL query to display the average price of the products which is more than or equal to 350 along with their names.
 SELECT AVG(pro_price) AS "Average Price", 
   company_mast.com_name AS "Company"
      FROM item_mast, company_mast
         WHERE item_mast.pro_com= company_mast.com_id
           GROUP BY company_mast.com_name
   HAVING AVG(pro_price) >= 350;

 # Write a SQL query to display the name of each company, price for their most expensive product along with their Name.
 SELECT P.pro_name AS "Product Name", 
       P.pro_price AS "Price", 
       C.com_name AS "Company"
   FROM item_mast P, company_mast C
   WHERE P.pro_com = C.com_id
     AND P.pro_price =
     (
       SELECT MAX(P.pro_price)
         FROM item_mast P
         WHERE P.pro_com = C.com_id
     );

# Write a query in SQL to find all the details of employees whose last name is Gabriel or Dosio.
SELECT * 
  FROM emp_details
   WHERE emp_lname IN ('Gabriel' , 'Dosio');

# Write a query in SQL to display all the details of employees who works in department 89 or 63.
SELECT * 
  FROM emp_details
  WHERE emp_dept IN (89,63);

# Write a query in SQL to display the first name and last name of employees working for the department which allotment amount is more than Rs.50000.
SELECT emp_fname, emp_lname 
 FROM emp_details
  WHERE emp_dept IN
  (SELECT dpt_code 
     FROM emp_department 
       WHERE dpt_allotment > 50000);
    
# Write a query in SQL to find the departments which sanction amount is larger than the average sanction amount of all the departments.
SELECT *
  FROM emp_department
  WHERE dpt_allotment >
  (
    SELECT AVG(dpt_allotment)
    FROM emp_department
  );
    
 # Write a query in SQL to find the names of departments with more than two employees are working.
 SELECT dpt_name FROM emp_department
  WHERE dpt_code IN
  (
    SELECT emp_dept
      FROM emp_details
      GROUP BY emp_dept
      HAVING COUNT(*) >2
  );
  
  # Write a query in SQL to find the first name and last name of employees working for departments which sanction amount is second lowest.
  SELECT emp_fname, emp_lname 
FROM emp_details 
WHERE emp_dept IN (
  SELECT dpt_code
  FROM emp_department 
  WHERE dpt_allotment= (
    SELECT MIN(dpt_allotment)
    FROM emp_department 
    WHERE dpt_allotment >
 (SELECT MIN(dpt_allotment) 
      FROM emp_department )));

########################################################           UNION        #####################################################################   
# Write a query to display all salesmen and customer located in London.
SELECT salesman_id "ID", name, 'Salesman'
FROM salesman
WHERE city='London'
UNION
(SELECT customer_id "ID", cust_name, 'Customer'
FROM customer
WHERE city='London');

#  Write a query to display distinct salesman and their cities.    
SELECT salesman_id "ID", city
FROM customer
UNION
(SELECT salesman_id, city
FROM salesman);
    
# Write a query to display all the salesmen and customer involved in this inventory management system.
 SELECT salesman_id, customer_id
FROM customer
UNION 
(SELECT salesman_id, customer_id
FROM orders);
   
    
# Write a query to make a report of which salesman produce the largest and smallest orders on each date.   
SELECT a.salesman_id, name, ord_no, 'highest on', ord_date
FROM salesman a, orders b
WHERE a.salesman_id =b.salesman_id
AND b.purch_amt=
	(SELECT MAX(purch_amt)
	FROM orders c
	WHERE c.ord_date = b.ord_date)
UNION
(SELECT a.salesman_id, name, ord_no, 'lowest on', ord_date
FROM salesman a, orders b
WHERE a.salesman_id =b.salesman_id
AND b.purch_amt=
	(SELECT MIN(purch_amt)
	FROM orders c
	WHERE c.ord_date = b.ord_date));
  
  # Write a query to make a report of which salesman produce the largest and smallest orders on each date and arranged the orders number in smallest to the largest number.
SELECT a.salesman_id, name, ord_no, 'highest on', ord_date
FROM salesman a, orders b
WHERE a.salesman_id =b.salesman_id
AND b.purch_amt=
	(SELECT MAX(purch_amt)
	FROM orders c
	WHERE c.ord_date = b.ord_date)
UNION
(SELECT a.salesman_id, name, ord_no, 'lowest on', ord_date
FROM salesman a, orders b
WHERE a.salesman_id =b.salesman_id
AND b.purch_amt=
	(SELECT MIN(purch_amt)
	FROM orders c
	WHERE c.ord_date = b.ord_date))
ORDER BY 3;

# Write a query to list all the salesmen, and indicate those who do not have customers in their cities, as well as whose who do.
SELECT salesman.salesman_id, name, cust_name, commission
FROM salesman, customer
WHERE salesman.city = customer.city
UNION
(SELECT salesman_id, name, 'NO MATCH', commission
FROM salesman
WHERE NOT city = ANY
	(SELECT city
        FROM customer))
ORDER BY 2 DESC;

# Write a query to that appends strings to the selected fields, indicating whether or not a specified salesman was matched to a customer in his city.
SELECT a.salesman_id, name, a.city, 'MATCHED'
FROM salesman a, customer b
WHERE a.city = b.city
UNION
(SELECT salesman_id, name, city, 'NO MATCH'
FROM salesman
WHERE NOT city = ANY
	(SELECT city
        FROM customer))
ORDER BY 2 DESC;

# Write a query to create a union of two queries that shows the names, cities, and ratings of all customers. Those with a rating of 300 or greater will also have the words High Rating, while the others will have the words Low Rating.
SELECT customer_id, city, grade, 'High Rating'
FROM customer
WHERE grade >= 300
UNION
(SELECT customer_id, city, grade, 'Low Rating'
FROM customer
WHERE grade < 300);


# Write a query that produces the name and number of each salesman and each customer with more than one current order. Put the results in alphabetical order.
SELECT customer_id,  cust_name
	FROM customer a
	WHERE 1<
		(SELECT COUNT(*)
		   FROM orders b
		   WHERE a.customer_id = b.customer_id)
UNION
(SELECT salesman_id, name
	FROM salesman a
	WHERE 1 <
		(SELECT COUNT(*)
		 FROM orders b
		 WHERE  a.salesman_id = b.salesman_id))
ORDER BY 2;
    
    

########################################################           VIEW        #####################################################################  
    
# Write a query to create a view for those salesmen belongs to the city New York.
CREATE VIEW newyorkstaff
AS SELECT *
FROM salesman
WHERE city = 'New York';
    
    
#  Write a query to create a view for all salesmen with columns salesman_id, name and city.
CREATE VIEW salesown
 AS SELECT salesman_id, name, city
 FROM salesman;
    
# Write a query to find the salesmen of the city New York who achieved the commission more than 13%.
SELECT *
FROM newyorkstaff
WHERE commission > .13;

# Write a query to create a view to getting a count of how many customers we have at each level of a grade.
 CREATE VIEW gradecount (grade, number)
AS SELECT grade, COUNT(*)
FROM customer
GROUP BY grade;
   
 # Write a query to create a view to keeping track the number of customers ordering number of salesmen attached, average amount of orders and the total amount of orders in a day.
 CREATE VIEW totalforday
 AS SELECT ord_date, COUNT(DISTINCT customer_id),
 AVG(purch_amt), SUM(purch_amt)
 FROM orders
 GROUP BY ord_date;
 
 # Write a query to create a view that shows for each order the salesman and customer by name.
 CREATE VIEW nameorders
AS SELECT ord_no, purch_amt, a.salesman_id, name, cust_name
FROM orders a, customer b, salesman c
WHERE a.customer_id = b.customer_id
AND a.salesman_id = c.salesman_id;

# Write a query to create a view that finds the salesman who has the customer with the highest order of a day.
CREATE VIEW elitsalesman
AS SELECT b.ord_date, a.salesman_id, a.name
FROM salesman a, orders b
WHERE a.salesman_id = b.salesman_id
AND b.purch_amt =
    (SELECT MAX(purch_amt)
       FROM orders c
       WHERE c.ord_date = b.ord_date);
   
# Write a query to create a view that finds the salesman who has the customer with the highest order at least 3 times on a day.
CREATE VIEW incentive
AS SELECT DISTINCT salesman_id, name
FROM elitsalesman a
WHERE 3 <=
   (SELECT COUNT(*)
    FROM elitsalesman b
    WHERE a.salesman_id = b.salesman_id);
    
    
# Write a query to create a view that shows all of the customers who have the highest grade.
CREATE VIEW highgrade
  AS SELECT *
  FROM customer
  WHERE grade =
    (SELECT MAX (grade)
     FROM customer);

# Write a query to create a view that shows the number of the salesman in each city.
CREATE VIEW citynum
AS SELECT city, COUNT(DISTINCT salesman_id)
FROM salesman
GROUP BY city;

# Write a query to create a view that shows the average and total orders for each salesman after his or her name. (Assume all names are unique)
CREATE VIEW norders
AS SELECT name, AVG(purch_amt), SUM(purch_amt)
FROM salesman, orders
WHERE salesman.salesman_id = orders.salesman_id
GROUP BY name;

# Write a query to create a view that shows each salesman with more than one customers.
CREATE VIEW mcustomer
AS SELECT *
FROM salesman a
WHERE 1 <
   (SELECT COUNT(*)
     FROM customer b
     WHERE a.salesman_id = b.salesman_id);

# Write a query to create a view that shows all matches of customers with salesman such that at least one customer in the city of customer served by a salesman in the city of the salesman.
CREATE VIEW citymatch(custcity, salescity)
AS SELECT DISTINCT a.city, b.city
FROM customer a, salesman b
WHERE a.salesman_id = b.salesman_id;
    
# Write a query to create a view that shows the number of orders in each day.
CREATE VIEW dateord(ord_date, odcount)
AS SELECT ord_date, COUNT(*)
FROM orders 
GROUP BY ord_date;
    
# Write a query to create a view that finds the salesmen who issued orders on October 10th, 2012.
CREATE VIEW salesmanonoct
AS SELECT *
FROM salesman
WHERE salesman_id IN
    (SELECT salesman_id
         FROM orders
         WHERE ord_date = '2012-10-10');
    
# Write a query to create a view that find the salesmen who issued orders on either August 17th, 2012 or October 10th, 2012.
CREATE VIEW sorder
AS SELECT salesman_id, ord_no, customer_id
FROM orders
WHERE ord_date IN('2012-08-17', '2012-10-10');
    
    
    
    
    
    
    
