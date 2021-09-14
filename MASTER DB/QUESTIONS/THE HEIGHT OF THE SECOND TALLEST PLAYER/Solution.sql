
select max(height) second_height 
from players 
where height not in  (select max(height) from players);



