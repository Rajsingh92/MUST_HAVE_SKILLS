#stored procedures
/*
If you want to save this query on the database server for execution later, one way to do it is to use a stored procedure.
A cursor allows you to iterate a set of rows returned by a query and process each row individually.  declare-open-fetch-close
The cursor declaration must be after any variable declaration.A cursor must always associate with a SELECT statement.


	
LEAVE label;
	
DECLARE action HANDLER FOR condition_value statement;

SIGNAL SQLSTATE | condition_name;
SET condition_information_item_name_1 = value_1,
    condition_information_item_name_1 = value_2, etc;
    
MySQL uses DEFINER and SQL SECURITY characteristics to control these privileges.
in inout out  parameters
*/

DELIMITER $$
CREATE PROCEDURE GetCustomers()
BEGIN
    SELECT * FROM customers;
END$$
DELIMITER ;



DELIMITER $$
CREATE PROCEDURE GetEmployees()
BEGIN
    SELECT * FROM employees;
END$$
DELIMITER ;

CALL GetCustomers();
CALL GetEmployees();

DROP PROCEDURE GetEmployees;
SHOW PROCEDURE STATUS;
SHOW PROCEDURE STATUS WHERE db = 'classicmodels';
SHOW PROCEDURE STATUS LIKE 'Get%';

DELIMITER //
CREATE PROCEDURE GetOfficeByCountry(
    IN countryName VARCHAR(255)
)
BEGIN
    SELECT * 
     FROM offices
    WHERE country = countryName;
END //
DELIMITER ;

CALL GetOfficeByCountry('USA');

DELIMITER $$
CREATE PROCEDURE GetOrderCountByStatus (
    IN  orderStatus VARCHAR(25),
    OUT total INT
)
BEGIN
    SELECT COUNT(orderNumber)
    INTO total
    FROM orders
    WHERE status = orderStatus;
END$$
DELIMITER ;


CALL GetOrderCountByStatus('in process',@total);
SELECT @total AS  total_in_process;


DELIMITER $$
CREATE PROCEDURE SetCounter(
    INOUT counter INT,
    IN inc INT
)
BEGIN
    SET counter = counter + inc;
END$$
DELIMITER ;

SET @counter = 1;
CALL SetCounter(@counter,1); -- 2
CALL SetCounter(@counter,1); -- 3
CALL SetCounter(@counter,5); -- 8
SELECT @counter; -- 8

#MySQL cursor is read-only, non-scrollable and asensitive.

DELIMITER $$
CREATE PROCEDURE createEmailList (
    INOUT emailList varchar(4000)
)
BEGIN
    DECLARE finished INTEGER DEFAULT 0;
    DECLARE emailAddress varchar(100) DEFAULT "";
 
    -- declare cursor for employee email
    DEClARE curEmail 
        CURSOR FOR 
            SELECT email FROM employees;
 
    -- declare NOT FOUND handler
    DECLARE CONTINUE HANDLER 
        FOR NOT FOUND SET finished = 1;
 
    OPEN curEmail;
 
    getEmail: LOOP
        FETCH curEmail INTO emailAddress;
        IF finished = 1 THEN 
            LEAVE getEmail;
        END IF;
        -- build email list
        SET emailList = CONCAT(emailAddress,";",emailList);
    END LOOP getEmail;
    CLOSE curEmail;
 
END$$
DELIMITER ;

SET @emailList = ""; 
CALL createEmailList(@emailList); 
SELECT @emailList;

/*
A stored function is a special kind stored program that returns a single value. Typically, you use stored functions to encapsulate common formulas or 
business rules that are reusable among SQL statements or stored programs.

DELIMITER $$
CREATE FUNCTION function_name(
    param1,
    param2,…
)
RETURNS datatype
[NOT] DETERMINISTIC
BEGIN
 -- statements
END $$
DELIMITER ;
*/

DELIMITER $$
CREATE FUNCTION CustomerLevel(
    credit DECIMAL(10,2)
) 
RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
    DECLARE customerLevel VARCHAR(20);
 
    IF credit > 50000 THEN
        SET customerLevel = 'PLATINUM';
    ELSEIF (credit >= 50000 AND credit <= 10000) THEN
        SET customerLevel = 'GOLD';
    ELSEIF credit < 10000 THEN
        SET customerLevel = 'SILVER';
    END IF;
    RETURN (customerLevel);
END$$
DELIMITER ;

SHOW FUNCTION STATUS 
WHERE db = 'classicmodels';

SELECT customerName, CustomerLevel(creditLimit)
FROM customers
ORDER BY customerName;


DELIMITER $$
CREATE PROCEDURE GetCustomerLevel(
    IN  customerNo INT,  
    OUT customerLevel VARCHAR(20)
)
BEGIN
 
    DECLARE credit DEC(10,2) DEFAULT 0;
    
    -- get credit limit of a customer
    SELECT 
        creditLimit 
    INTO credit
    FROM customers
    WHERE 
        customerNumber = customerNo;
    
    -- call the function 
    SET customerLevel = CustomerLevel(credit);
END$$
DELIMITER ;

CALL GetCustomerLevel(-131,@customerLevel);
SELECT @customerLevel;

DROP FUNCTION IF EXISTS NonExistingFunction;




/* 
The routines table in the information_schema database contains all information on the stored procedures 
and stored functions of all databases in the current MySQL server.
 */
SELECT routine_name
FROM information_schema.routines
WHERE routine_type = 'PROCEDURE' AND routine_schema = 'classicmodels';


#triggers:
/* 
In MySQL, a trigger is a stored program invoked automatically in response to an event such as insert, update, or delete that occurs in the associated table. 
For example, you can define a trigger that is invoked automatically before a new row is inserted into a table.

A row-level trigger is activated for each row that is inserted, updated, or deleted.  
For example, if a table has 100 rows inserted, updated, or deleted, the trigger is automatically invoked 100 times for the 100 rows affected.

A statement-level trigger is executed once for each transaction regardless of how many rows are inserted, updated, or deleted.

MySQL supports only row-level triggers. It doesn’t support statement-level triggers.


CREATE TRIGGER trigger_name
{BEFORE | AFTER} {INSERT | UPDATE| DELETE }
ON table_name FOR EACH ROW
trigger_body;

SHOW TRIGGERS
[{FROM | IN} database_name]
[LIKE 'pattern' | WHERE search_condition];
 */
 
CREATE TABLE employees_audit (
    id INT AUTO_INCREMENT PRIMARY KEY,
    employeeNumber INT NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    changedat DATETIME DEFAULT NULL,
    action VARCHAR(50) DEFAULT NULL
);
 
CREATE TRIGGER before_employee_update 
    BEFORE UPDATE ON employees
    FOR EACH ROW 
 INSERT INTO employees_audit
 SET action = 'update',
     employeeNumber = OLD.employeeNumber,
     lastname = OLD.lastname,
     changedat = NOW();
 
 	


SHOW TRIGGERS;

SHOW TRIGGERS
FROM classicmodels;

UPDATE employees 
SET 
    lastName = 'Phan'
WHERE
    employeeNumber = 1056;


SELECT * FROM employees_audit;

CREATE TABLE billings (
    billingNo INT AUTO_INCREMENT,
    customerNo INT,
    billingDate DATE,
    amount DEC(10 , 2 ),
    PRIMARY KEY (billingNo)
);

DELIMITER $$
CREATE TRIGGER before_billing_update
    BEFORE UPDATE 
    ON billings FOR EACH ROW
BEGIN
    IF new.amount > old.amount * 10 THEN
        SIGNAL SQLSTATE '45000' 
            SET MESSAGE_TEXT = 'New amount cannot be 10 times greater than the current amount.';
    END IF;
END$$    
DELIMITER ;


DROP TRIGGER before_billing_update;

CREATE TABLE WorkCenters (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    capacity INT NOT NULL
);

CREATE TABLE WorkCenterStats(
    totalCapacity INT NOT NULL
);



DELIMITER $$
CREATE TRIGGER before_workcenters_insert
BEFORE INSERT
ON WorkCenters FOR EACH ROW
BEGIN
    DECLARE rowcount INT;
    
    SELECT COUNT(*) 
    INTO rowcount
    FROM WorkCenterStats;
    
    IF rowcount > 0 THEN
        UPDATE WorkCenterStats
        SET totalCapacity = totalCapacity + new.capacity;
    ELSE
        INSERT INTO WorkCenterStats(totalCapacity)
        VALUES(new.capacity);
    END IF; 
 
END $$
DELIMITER ;

INSERT INTO WorkCenters(name, capacity)
VALUES('Packing',200);

INSERT INTO WorkCenters(name, capacity)
VALUES('Pac',300);

SELECT * FROM WorkCenters;
SELECT * FROM WorkCenterStats;

CREATE TABLE reminders (
    id INT AUTO_INCREMENT,
    memberId INT,
    message VARCHAR(255) NOT NULL,
    PRIMARY KEY (id , memberId)
);

CREATE TABLE members (
    id INT AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(255),
    birthDate DATE,
    PRIMARY KEY (id)
);

DELIMITER $$
CREATE TRIGGER after_members_insert
AFTER INSERT
ON members FOR EACH ROW
BEGIN
    IF NEW.birthDate IS NULL THEN
        INSERT INTO reminders(memberId, message)
        VALUES(new.id,CONCAT('Hi ', NEW.name, ', please update your date of birth.'));
    END IF;
END$$
DELIMITER ;



INSERT INTO members(name, email, birthDate)
VALUES
    ('John Doe', 'john.doe@example.com', NULL),
    ('Jane Doe', 'jane.doe@example.com','2000-01-01');
    
	
SELECT * FROM members;  
SELECT * FROM reminders;  

CREATE TABLE sales (
    id INT AUTO_INCREMENT,
    product VARCHAR(100) NOT NULL,
    quantity INT NOT NULL DEFAULT 0,
    fiscalYear SMALLINT NOT NULL,
    fiscalMonth TINYINT NOT NULL,
    CHECK(fiscalMonth >= 1 AND fiscalMonth <= 12),
    CHECK(fiscalYear BETWEEN 2000 and 2050),
    CHECK (quantity >=0),
    UNIQUE(product, fiscalYear, fiscalMonth),
    PRIMARY KEY(id)
);

INSERT INTO sales(product, quantity, fiscalYear, fiscalMonth)
VALUES
    ('2003 Harley-Davidson Eagle Drag Bike',120, 2020,1),
    ('1969 Corvair Monza', 150,2020,1),
    ('1970 Plymouth Hemi Cuda', 200,2020,1);
    
    	
SELECT * FROM sales;

DELIMITER $$
CREATE TRIGGER before_sales_update
BEFORE UPDATE
ON sales FOR EACH ROW
BEGIN
    DECLARE errorMessage VARCHAR(255);
    SET errorMessage = CONCAT('The new quantity ',
                        NEW.quantity,
                        ' cannot be 3 times greater than the current quantity ',
                        OLD.quantity);
                        
    IF new.quantity > old.quantity * 3 THEN
        SIGNAL SQLSTATE '45000' 
            SET MESSAGE_TEXT = errorMessage;
    END IF;
END $$
DELIMITER ;



UPDATE sales 
SET quantity = 150
WHERE id = 1;

UPDATE sales 
SET quantity = 500
WHERE id = 1;

SHOW ERRORS;

INSERT INTO Sales(product, quantity, fiscalYear, fiscalMonth)
VALUES
    ('2001 Ferrari Enzo',140, 2021,1),
    ('1998 Chrysler Plymouth Prowler', 110,2021,1),
    ('1913 Ford Model T Speedster', 120,2021,1);
    
 CREATE TABLE SalesChanges (
    id INT AUTO_INCREMENT PRIMARY KEY,
    salesId INT,
    beforeQuantity INT,
    afterQuantity INT,
    changedAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

DELIMITER $$
CREATE TRIGGER after_sales_update
AFTER UPDATE
ON sales FOR EACH ROW
BEGIN
    IF OLD.quantity <> new.quantity THEN
        INSERT INTO SalesChanges(salesId,beforeQuantity, afterQuantity)
        VALUES(old.id, old.quantity, new.quantity);
    END IF;
END$$
DELIMITER ;


UPDATE Sales 
SET quantity = 350
WHERE id = 1;

SELECT * FROM SalesChanges;

UPDATE Sales 
SET quantity = CAST(quantity * 1.1 AS UNSIGNED);

CREATE TABLE Salaries (
    employeeNumber INT PRIMARY KEY,
    validFrom DATE NOT NULL,
    amount DEC(12 , 2 ) NOT NULL DEFAULT 0
);

INSERT INTO salaries(employeeNumber,validFrom,amount)
VALUES
    (1002,'2000-01-01',50000),
    (1056,'2000-01-01',60000),
    (1076,'2000-01-01',70000);
    
CREATE TABLE SalaryArchives (
    id INT PRIMARY KEY AUTO_INCREMENT,
    employeeNumber INT,
    validFrom DATE NOT NULL,
    amount DEC(12 , 2 ) NOT NULL DEFAULT 0,
    deletedAt TIMESTAMP DEFAULT NOW()
);

DELIMITER $$
 
CREATE TRIGGER before_salaries_delete
BEFORE DELETE
ON salaries FOR EACH ROW
BEGIN
    INSERT INTO SalaryArchives(employeeNumber,validFrom,amount)
    VALUES(OLD.employeeNumber,OLD.validFrom,OLD.amount);
END$$    
 
DELIMITER ;

DELETE FROM salaries 
WHERE employeeNumber = 1002;

SELECT * FROM SalaryArchives; 

DELETE FROM salaries;

DROP TABLE IF EXISTS Salaries;
 
CREATE TABLE Salaries (
    employeeNumber INT PRIMARY KEY,
    salary DECIMAL(10,2) NOT NULL DEFAULT 0
);


INSERT INTO Salaries(employeeNumber,salary)
VALUES
    (1002,5000),
    (1056,7000),
    (1076,8000);
  


DROP TABLE IF EXISTS SalaryBudgets;
 
CREATE TABLE SalaryBudgets(
    total DECIMAL(15,2) NOT NULL
);
    
INSERT INTO SalaryBudgets(total)
SELECT SUM(salary) 
FROM Salaries;
SELECT * FROM SalaryBudgets; 



CREATE TRIGGER after_salaries_delete
AFTER DELETE
ON Salaries FOR EACH ROW
UPDATE SalaryBudgets 
SET total = total - old.salary;


DELETE FROM Salaries
WHERE employeeNumber = 1002;


SELECT * FROM SalaryBudgets;

DELETE FROM Salaries;


#views
/*
By definition, a view is a named query stored in the database catalog.

CREATE [OR REPLACE] VIEW [db_name.]view_name [(column_list)]
AS
  select-statement;
  
the name a view cannot the same as the name of an existing table.
use the OR REPLACE option if you want to replace an existing view if the view already exists.
*/

CREATE VIEW salePerOrder AS
    SELECT 
        orderNumber, 
        SUM(quantityOrdered * priceEach) total
    FROM
        orderDetails
    GROUP by orderNumber
    ORDER BY total DESC;
    
SHOW FULL TABLES;    #to show views
SELECT * FROM salePerOrder;


#based on another view
CREATE VIEW bigSalesOrder AS
    SELECT 
        orderNumber, 
        ROUND(total,2) as total
    FROM
        salePerOrder
    WHERE
        total > 60000;
        
select * from bigSalesOrder;

CREATE OR REPLACE VIEW customerOrders AS
SELECT 
    orderNumber,
    customerName,
    SUM(quantityOrdered * priceEach) total
FROM
    orderDetails
INNER JOIN orders o USING (orderNumber)
INNER JOIN customers USING (customerNumber)
GROUP BY orderNumber;


SELECT * FROM customerOrders 
ORDER BY total DESC;

CREATE VIEW aboveAvgProducts AS
    SELECT 
        productCode, 
        productName, 
        buyPrice
    FROM
        products
    WHERE
        buyPrice > (
            SELECT 
                AVG(buyPrice)
            FROM
                products)
    ORDER BY buyPrice DESC;
    
SELECT * FROM aboveAvgProducts;

CREATE VIEW customerOrderStats (
   customerName , 
   orderCount
) 
AS
    SELECT 
        customerName, 
        COUNT(orderNumber)
    FROM
        customers
            INNER JOIN
        orders USING (customerNumber)
    GROUP BY customerName;
    
SELECT 
    customerName,
    orderCount
FROM
    customerOrderStats
ORDER BY 
    orderCount, 
    customerName;
    
	
DROP VIEW IF EXISTS saleperorder;

DROP VIEW IF EXISTS employeeOffices, eOffices;

#alter table


CREATE TABLE vehicles (
    vehicleId INT,
    year INT NOT NULL,
    make VARCHAR(100) NOT NULL,
    PRIMARY KEY(vehicleId)
);

describe vehicles;

ALTER TABLE vehicles
ADD model VARCHAR(100) NOT NULL;


ALTER TABLE vehicles
ADD color VARCHAR(50),
ADD note VARCHAR(255);

ALTER TABLE vehicles 
MODIFY note VARCHAR(100) NOT NULL;

ALTER TABLE vehicles 
MODIFY year SMALLINT NOT NULL,
MODIFY color VARCHAR(20) NULL AFTER make;

ALTER TABLE vehicles 
CHANGE COLUMN note vehicleCondition VARCHAR(100) NOT NULL;

ALTER TABLE vehicles
DROP COLUMN vehicleCondition;

ALTER TABLE vehicles 
RENAME TO cars;

describe cars;

# MySQL fully supports three actions: RESTRICT, CASCADE and SET NULL.
#MySQL CHECK constraint to ensure that values stored in a column or group of columns satisfy a Boolean expression.
#deived table

SELECT 
    productCode, 
    ROUND(SUM(quantityOrdered * priceEach)) sales
FROM
    orderdetails
        INNER JOIN
    orders USING (orderNumber)
WHERE
    YEAR(shippedDate) = 2003
GROUP BY productCode
ORDER BY sales DESC
LIMIT 5;


SELECT 
    productName, sales
FROM
    (SELECT 
        productCode, 
        ROUND(SUM(quantityOrdered * priceEach)) sales
    FROM
        orderdetails
    INNER JOIN orders USING (orderNumber)
    WHERE
        YEAR(shippedDate) = 2003
    GROUP BY productCode
    ORDER BY sales DESC
    LIMIT 5) top5products2003
INNER JOIN
    products USING (productCode);
