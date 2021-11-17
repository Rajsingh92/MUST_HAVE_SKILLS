/*
Write an SQL query to find the daily active user count for a period of 30 days ending 
2019-07-27 inclusively. A user was active on some day if he/she made at least one activity 
on that day.

Activity table:
+---------+------------+---------------+---------------+
| user_id | session_id | activity_date | activity_type |
+---------+------------+---------------+---------------+
| 1       | 1          | 2019-07-20    | open_session  |
| 1       | 1          | 2019-07-20    | scroll_down   |
| 1       | 1          | 2019-07-20    | end_session   |
| 2       | 4          | 2019-07-20    | open_session  |
| 2       | 4          | 2019-07-21    | send_message  |
| 2       | 4          | 2019-07-21    | end_session   |
| 3       | 2          | 2019-07-21    | open_session  |
| 3       | 2          | 2019-07-21    | send_message  |
| 3       | 2          | 2019-07-21    | end_session   |
| 4       | 3          | 2019-06-25    | open_session  |
| 4       | 3          | 2019-06-25    | end_session   |
+---------+------------+---------------+---------------+

Result table:
+------------+--------------+ 
| day        | active_users |
+------------+--------------+ 
| 2019-07-20 | 2            |
| 2019-07-21 | 2            |
+------------+--------------+ 
*/

select 
    activity_date  day, 
    count(distinct user_id)  active_users 
from Activity
where datediff('2019-07-27', activity_date) < 30
group by activity_date;




/*
Write an SQL query to find the average number of sessions per user for a period of 30 days 
ending 2019-07-27 inclusively, rounded to 2 decimal places. The sessions we want to count 
for a user are those with at least one activity in that time period.

Activity table:

| user_id | session_id | activity_date | activity_type |
| 1 | 1 | 2019-07-20 | open_session |
| 1 | 1 | 2019-07-20 | scroll_down | 
| 1 | 1 | 2019-07-20 | end_session | 
| 2 | 4 | 2019-07-20 | open_session | 
| 2 | 4 | 2019-07-21 | send_message | 
| 2 | 4 | 2019-07-21 | end_session | 
| 3 | 2 | 2019-07-21 | open_session | 
| 3 | 2 | 2019-07-21 | send_message | 
| 3 | 2 | 2019-07-21 | end_session | 
| 3 | 5 | 2019-07-21 | open_session | 
| 3 | 5 | 2019-07-21 | scroll_down | 
| 3 | 5 | 2019-07-21 | end_session | 
| 4 | 3 | 2019-06-25 | open_session | 
| 4 | 3 | 2019-06-25 | end_session |


 | average_sessions_per_user |
 | 1.33 | 

 User 1 and 2 each had 1 session in the past 30 days while user 3 had 2 sessions so the 
 average is (1 + 1 + 2) / 3 = 1.33.
*/


select round(ifnull(count(distinct session_id)/count(distinct user_id), 0),2) as average_sessions_per_user
from Activity
where datediff('2019-07-27', activity_date) < 30;

