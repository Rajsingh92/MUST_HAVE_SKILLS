/*
Write an SQL query to find the person_name of the last person who will fit in the elevator without exceeding the weight limit. It is guaranteed that the person who is first in the queue can fit in the elevator.

Queue table
+-----------+-------------------+--------+------+
| person_id | person_name       | weight | turn |
+-----------+-------------------+--------+------+
| 5         | George Washington | 250    | 1    |
| 3         | John Adams        | 350    | 2    |
| 6         | Thomas Jefferson  | 400    | 3    |
| 2         | Will Johnliams    | 200    | 4    |
| 4         | Thomas Jefferson  | 175    | 5    |
| 1         | James Elephant    | 500    | 6    |
+-----------+-------------------+--------+------+

Result table
+-------------------+
| person_name       |
+-------------------+
| Thomas Jefferson  |
+-------------------+

Queue table is ordered by turn in the example for simplicity.
In the example George Washington(id 5), John Adams(id 3) and Thomas Jefferson(id 6) will enter the elevator as their weight sum is 250 + 350 + 400 = 1000.
Thomas Jefferson(id 6) is the last person to fit in the elevator because he has the last turn in these three people.


*/


CREATE TABLE Queue 
(
	person_id INT,
    person_name  	VARCHAR(512),
     weight      	INT,
     turn    	INT
);

INSERT INTO Queue (person_id,  person_name, weight , turn) VALUES
	('5', 'George Washington', '250', '1'),
	('3', 'John Adams', '350', '2'),
	('6', 'Thomas Jefferson', '400', '3'),
	('2', 'Will Johnliams', '200', '4'),
	('4', 'Thomas Jefferson', '175', '5'),
	('1', 'James Elephant', '500', '6');


SELECT person_name 
from (
	select *
		, sum(weight) over(ORDER BY turn ROWS UNBOUNDED PRECEDING) weight_now
	FROM Queue
) a where weight_now <= 1000
order by weight_now desc 
limit 1;



select person_name from Queue last_person
where (select sum(weight) from Queue where turn <= last_person.turn) <= 1000
order by turn desc limit 1;

    
