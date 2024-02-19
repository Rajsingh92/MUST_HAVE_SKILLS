-- Tournament Winners
"
CREATE TABLE Players (
    player_id INT,
    group_id INT
);
INSERT INTO Players (player_id, group_id) VALUES 
(15, 1),
(25, 1),
(30, 1),
(45, 1),
(10, 2),
(35, 2),
(50, 2),
(20, 3),
(40, 3);
CREATE TABLE Matches (
    match_id INT,
    first_player INT,
    second_player INT,
    first_score INT,
    second_score INT
);
INSERT INTO Matches (match_id, first_player, second_player, first_score, second_score) VALUES 
(1, 15, 45, 3, 0),
(2, 30, 25, 1, 2),
(3, 30, 15, 2, 0),
(4, 40, 20, 5, 2),
(5, 35, 50, 1, 1);"	

"with cte as (
select first_player as player_id, first_score as score from Matches
union all
select second_player as player_id, second_score as score from Matches
),
cte2 as (
select p.player_id,p.group_id,coalesce(sum(score),0) as score 
from Players p
left join cte on cte.player_id = p.player_id
group by p.player_id,p.group_id
),
cte3 as (
select * , rank() over(partition by group_id order by score desc ,player_id asc) as rk
from cte2
) 
select * from cte3 where rk = 1"