Problem Statement:-


Given below table Emp as Input which has two columns ‘Group’ and ‘Sequence’, Write a SQL query to find the maximum and minimum values of continuous ‘Sequence’ in each ‘Group’


SOLUTION :

SELECT [Group],
MIN([Sequence]) As Min_Seq,
MAX([Sequence]) As Max_Seq
FROM
(
SELECT [Group],
[Sequence],
[Sequence] - ROW_NUMBER() OVER(Partition BY [Group] ORDER BY [Sequence]) as [Split]
From Emp
) A
GROUP BY [Group],[Split]
ORDER BY [Group]


