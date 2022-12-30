/*
Consecutive Numbers
Write an SQL query to find all numbers that appear at least three times consecutively.

Input: 
Logs table:
+----+-----+
| id | num |
+----+-----+
| 1  | 1   |
| 2  | 1   |
| 3  | 1   |
| 4  | 2   |
| 5  | 1   |
| 6  | 2   |
| 7  | 2   |
+----+-----+
Output: 
+-----------------+
| ConsecutiveNums |
+-----------------+
| 1               |
+-----------------+
*/


SELECT DISTINCT num  ConsecutiveNums 
FROM (
    SELECT id,num,
    LAG(num,1,null) OVER (ORDER BY id)  LAG_num,
    LEAD(num,1,null) OVER (ORDER BY id)  LEAD_num
    FROM Logs
) t
WHERE num = LAG_num AND num = LEAD_num;



SELECT DISTINCT
    l1.Num AS ConsecutiveNums
FROM
    Logs l1,
    Logs l2,
    Logs l3
WHERE
    l1.Id = l2.Id - 1
    AND l2.Id = l3.Id - 1
    AND l1.Num = l2.Num
    AND l2.Num = l3.Num;

    
