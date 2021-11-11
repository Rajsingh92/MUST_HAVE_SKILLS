/* 
Classes More Than 5 Students

There is a table courses with columns: student and class

Please list out all classes which have more than or equal to 5 students.

For example, the table:

+---------+------------+
| student | class      |
+---------+------------+
| A       | Math       |
| B       | English    |
| C       | Math       |
| D       | Biology    |
| E       | Math       |
| F       | Computer   |
| G       | Math       |
| H       | Math       |
| I       | Math       |
+---------+------------+
Should output:

+---------+
| class   |
+---------+
| Math    |
+---------+

*/


SELECT class 
FROM (
    SELECT class, COUNT(DISTINCT student) as std_cnt
    FROM courses
    GROUP BY class
) as temp_table
WHERE std_cnt >= 5;




SELECT class
FROM courses
GROUP BY class
HAVING COUNT(DISTINCT student) >= 5;


