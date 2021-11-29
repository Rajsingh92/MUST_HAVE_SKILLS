/*
Write an SQL query that selects the team_id, team_name and num_points of each team in the 
tournament after all described matches. Result table should be ordered by num_points 
(decreasing order). In case of a tie, order the records by team_id (increasing order).

Teams table:
+-----------+--------------+
| team_id   | team_name    |
+-----------+--------------+
| 10        | Leetcode FC  |
| 20        | NewYork FC   |
| 30        | Atlanta FC   |
| 40        | Chicago FC   |
| 50        | Toronto FC   |
+-----------+--------------+

Matches table:
+------------+--------------+---------------+-------------+--------------+
| match_id   | host_team    | guest_team    | host_goals  | guest_goals  |
+------------+--------------+---------------+-------------+--------------+
| 1          | 10           | 20            | 3           | 0            |
| 2          | 30           | 10            | 2           | 2            |
| 3          | 10           | 50            | 5           | 1            |
| 4          | 20           | 30            | 1           | 0            |
| 5          | 50           | 30            | 1           | 0            |
+------------+--------------+---------------+-------------+--------------+

Result table:
+------------+--------------+---------------+
| team_id    | team_name    | num_points    |
+------------+--------------+---------------+
| 10         | Leetcode FC  | 7             |
| 20         | NewYork FC   | 3             |
| 50         | Toronto FC   | 3             |
| 30         | Atlanta FC   | 1             |
| 40         | Chicago FC   | 0             |
+------------+--------------+---------------+

*/



SELECT
  team_id,
    team_name,
    SUM(CASE WHEN team_id = host_team AND host_goals > guest_goals THEN 3 ELSE 0 END) +
    SUM(CASE WHEN team_id = host_team AND host_goals = guest_goals THEN 1 ELSE 0 END) +
    SUM(CASE WHEN team_id = guest_team AND guest_goals > host_goals THEN 3 ELSE 0 END) +
    SUM(CASE WHEN team_id = guest_team AND host_goals = guest_goals THEN 1 ELSE 0 END) AS num_points
FROM
  Teams
LEFT JOIN
  Matches ON team_id = host_team OR team_id = guest_team
GROUP BY
  team_id, team_name
ORDER BY
    num_points DESC,
    team_id ASC;



