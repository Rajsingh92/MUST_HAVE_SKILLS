SCENARIO:
Table Employee_Details has Gender column. In this Gender column M should be updated with F and F should be updated with M.


SOLUTIONS (Using DECODE):
We have to update table using DECODE function as follows.


UPDATE EMPLOYEE_DETAILS

SET GENDER=DECODE(GENDER,'M','F',

                         'F','M');


SOLUTIONS (USing CASE statement ):
We have to update table using CASE  statement as follows.

UPDATE EMPLOYEE_DETAILS
SET GENDER= CASE WHEN Gender='M' THEN 'F'
                                         WHEN Gender='F' THEN 'M'
                             END;
