/*
write a sql query to get the amount of each follower’s follower if he/she has one.

+-------------+------------+
| followee    | follower   |
+-------------+------------+
|     A       |     B      |
|     B       |     C      |
|     B       |     D      |
|     D       |     E      |
+-------------+------------+

Result:
+-------------+------------+
| follower    | num        |
+-------------+------------+
|     B       |  2         |
|     D       |  1         |
+-------------+------------+

*/


select follower, num from (
        select f1.follower follower, count(distinct f2.follower) num
        from follow f1 left join follow f2
        on f1.follower = f2.followee
        group by f1.follower
    )  nums
where num > 0
order by follower;


