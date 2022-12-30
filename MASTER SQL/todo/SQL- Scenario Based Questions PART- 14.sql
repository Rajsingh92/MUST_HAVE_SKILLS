

Problem Statement:-
Student Table has three columns Student_Name, Total_Marks and Year. User has to write a SQL query to display Student_Name, Total_Marks, Year,  Prev_Yr_Marks for those whose Total_Marks are greater than or equal to the previous year


SOLUTION

SELECT Student_Name,Total_Marks,Year,Prev_Yr_Marks
FROM
(
SELECT Student_Name,Year,Total_Marks,Prev_Yr_Marks ,
CASE WHEN Total_Marks > = Prev_Yr_Marks Then 1 Else 0 END as Flag
FROM
(
SELECT Student_Name,Year,Total_Marks,
LAG(Total_Marks) OVER(PARTITION BY Student_Name ORDER BY Year )
AS Prev_Yr_Marks
FROM Student)A
) B
WHERE Flag=1



