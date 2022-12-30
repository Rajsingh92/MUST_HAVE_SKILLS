SCENARIO:  We have table EMPLOYEE_INFO  which contains Employee information. We want the output table should display NAME field and it should contain EMPNAME field values leaving behind first and last character in it. Please see below in details.



SOLUTION:

We can get this done by using the combination of Oracle string functions SUBSTR and LENGTH  as below .

SELECT EMPID ,EMPNMAE,EMAILID,AGE,GENDER,
SUBSTR(EMPNMAE,2,LENGTH(EMPNMAE)-2) Name FROM EMPLOYEE_INFO;

