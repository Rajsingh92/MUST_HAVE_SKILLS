SCENARIO:  We have table EMPLOYEE_INFO which contains Employee information. We want to display all characters before '@' in EMAILID field as Name field. Please see below in details.

SOLUTION:
We can get this done by using the Oracle string functions SUBSTR and INSTR as below .

SELECT EMPID ,EMPNMAE,EMAILID,AGE,GENDER,
SUBSTR(EMAILID,1,INSTR(EMAILID,'@')-1) Name FROM EMPLOYEE_INFO ;


