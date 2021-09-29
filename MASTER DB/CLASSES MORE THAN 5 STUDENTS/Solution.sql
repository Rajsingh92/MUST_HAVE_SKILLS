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


