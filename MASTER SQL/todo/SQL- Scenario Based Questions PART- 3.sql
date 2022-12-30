CREATE TABLE ProductDetail
( ProductID Int,
  ProductName Varchar(30),
  Price int)

  INSERT INTO ProductDetail Values(101,'Dove',55)
  INSERT INTO ProductDetail Values(101,'Dove',55)
  INSERT INTO ProductDetail Values(102,'Hamam',30)
  INSERT INTO ProductDetail Values(103,'Cinthol',35)
  INSERT INTO ProductDetail Values(103,'Cinthol',35)

Solution#1: By using GROUP BY clause. By selecting all columns and then grouping by all columns gives distinct records.

  SELECT ProductID,ProductName,Price
  FROM ProductDetail
  GROUP BY ProductID,ProductName,Price



Solution#2: By using UNION . We know that UNION always gives distinct record from a table. So By doing UNION between the same table will give unique records.

  SELECT ProductID,ProductName,Price
  FROM ProductDetail
  UNION
  SELECT ProductID,ProductName,Price
  FROM ProductDetail



