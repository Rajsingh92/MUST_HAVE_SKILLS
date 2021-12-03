/*
+----------+-------------+
|  Number  |  Frequency  |
+----------+-------------|
|  0       |  7          |
|  1       |  1          |
|  2       |  3          |
|  3       |  1          |
+----------+-------------+
In this table, the numbers are 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 3, so the median is (0 + 0) / 2 = 0.

+--------+
| median |
+--------|
| 0.0000 |
+--------+
*/


select avg(number) as median
from
(select number, sum(frequency) over(order by number asc) as asc_amount, 
                sum(frequency) over(order by number desc) as desc_amount,
                sum(frequency) over() as total_num
from numbers) a
where asc_amount >= total_num/2 and desc_amount >= total_num / 2;

