SCENARIO:

We have EMP_DETAILS table which contains employee details such as EMPID, GENDER,EMAILID and DEPT_ID columns. We want to display all emailid associated with a particular DEPT_ID to be concatenated with semicolon as shown below.

EMP_DETAILS Table

EMPID
GENDER
EMAILID
DEPT_ID
1111
M
YYYYY@gmaix.com
104

2222
M
ZZZ@gmaix.com
103

3333
F
AAAAA@gmaix.com
102

4444
F
PP@gmaix.com
104

5555
M
CCCC@yahu.com
101

6666
M
DDDDD@yahu.com
100

7777
F
E@yahu.com
102

8888
M
M@yahu.com
102

9999
F
SS@yahu.com
100


DEPT_ID
EMAILS
100
DDDDD@yahu.com;SS@yahu.com

101
CCCC@yahu.com

102
AAAAA@gmaix.com;E@yahu.com;M@yahu.com

103
ZZZ@gmaix.com

104
PP@gmaix.com;YYYYY@gmaix.com



SELECT DEPT_ID,
LISTAGG(EMAILID,';')WITHIN GROUP(ORDER BY EMAILID) EMAILS
FROM EMP_DETAILS GROUP BY DEPT_ID;

