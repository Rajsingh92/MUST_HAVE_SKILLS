-- Number of Calls Between Two Persons
"CREATE TABLE Calls (
    from_id INT,
    to_id INT,
    duration INT
);
INSERT INTO Calls (from_id, to_id, duration) VALUES 
(1, 2, 59),
(2, 1, 11),
(1, 3, 20),
(3, 4, 100),
(3, 4, 200),
(3, 4, 200),
(4, 3, 499);"	

"select case when from_id > to_id then to_id else from_id end as person1,
case when from_id > to_id then from_id else to_id end as person2,count(*) as call_count ,sum(duration) as total_duration
from calls
group by 
case when from_id > to_id then to_id else from_id end,
case when from_id > to_id then from_id else to_id end"