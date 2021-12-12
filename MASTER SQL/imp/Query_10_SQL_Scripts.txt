-- Query 10a
-- Finding n consecutive records where temperature is below zero. And table has a primary key.

--Table Structure:
drop table if exists weather cascade;
create table if not exists weather
	(
		id 					int 				primary key,
		city 				varchar(50) not null,
		temperature int 				not null,
		day 				date				not null
	);

delete from weather;
insert into weather values
	(1, 'London', -1, to_date('2021-01-01','yyyy-mm-dd')),
	(2, 'London', -2, to_date('2021-01-02','yyyy-mm-dd')),
	(3, 'London', 4, to_date('2021-01-03','yyyy-mm-dd')),
	(4, 'London', 1, to_date('2021-01-04','yyyy-mm-dd')),
	(5, 'London', -2, to_date('2021-01-05','yyyy-mm-dd')),
	(6, 'London', -5, to_date('2021-01-06','yyyy-mm-dd')),
	(7, 'London', -7, to_date('2021-01-07','yyyy-mm-dd')),
	(8, 'London', 5, to_date('2021-01-08','yyyy-mm-dd')),
	(9, 'London', -20, to_date('2021-01-09','yyyy-mm-dd')),
	(10, 'London', 20, to_date('2021-01-10','yyyy-mm-dd')),
	(11, 'London', 22, to_date('2021-01-11','yyyy-mm-dd')),
	(12, 'London', -1, to_date('2021-01-12','yyyy-mm-dd')),
	(13, 'London', -2, to_date('2021-01-13','yyyy-mm-dd')),
	(14, 'London', -2, to_date('2021-01-14','yyyy-mm-dd')),
	(15, 'London', -4, to_date('2021-01-15','yyyy-mm-dd')),
	(16, 'London', -9, to_date('2021-01-16','yyyy-mm-dd')),
	(17, 'London', 0, to_date('2021-01-17','yyyy-mm-dd')),
	(18, 'London', -10, to_date('2021-01-18','yyyy-mm-dd')),
	(19, 'London', -11, to_date('2021-01-19','yyyy-mm-dd')),
	(20, 'London', -12, to_date('2021-01-20','yyyy-mm-dd')),
	(21, 'London', -11, to_date('2021-01-21','yyyy-mm-dd'));
COMMIT;

select * from weather;


-- solution:
with
	t1 as
		(select *,	id - row_number() over (order by id) as diff
		from weather w
		where w.temperature < 0),
	t2 as
		(select *,
		count(*) over (partition by diff order by diff) as cnt
		from t1)
select id, city, temperature, day
from t2
where t2.cnt = 3;





-- Query 10b
-- Finding n consecutive records where temperature is below zero. And table does not have primary key.

create or replace view vw_weather as
select city, temperature from weather;

select * from vw_weather ;


with
	w as
		(select *, row_number() over () as id
		from vw_weather),
	t1 as
		(select *,	id - row_number() over (order by id) as diff
		from w
		where w.temperature < 0),
	t2 as
		(select *,
		count(*) over (partition by diff order by diff) as cnt
		from t1)
select city, temperature, id
from t2
where t2.cnt = 5;





-- Query 10c
-- Finding n consecutive records with consecutive date value.

--Table Structure:
drop table if exists orders cascade;
create table if not exists orders
  (
    order_id    varchar(20) primary key,
    order_date  date        not null
);

delete from orders;
insert into orders values
  ('ORD1001', to_date('2021-Jan-01','yyyy-mon-dd')),
  ('ORD1002', to_date('2021-Feb-01','yyyy-mon-dd')),
  ('ORD1003', to_date('2021-Feb-02','yyyy-mon-dd')),
  ('ORD1004', to_date('2021-Feb-03','yyyy-mon-dd')),
  ('ORD1005', to_date('2021-Mar-01','yyyy-mon-dd')),
  ('ORD1006', to_date('2021-Jun-01','yyyy-mon-dd')),
  ('ORD1007', to_date('2021-Dec-25','yyyy-mon-dd')),
  ('ORD1008', to_date('2021-Dec-26','yyyy-mon-dd'));
COMMIT;

select * from orders;


-- Solution
with
  t1 as
		(select *, row_number() over(order by order_date) as rn,
		 order_date - cast(row_number() over(order by order_date)::numeric as int) as diff
		from orders),
	t2 as
		(select *, count(1) over (partition by diff) as cnt
		from t1)
select order_id, order_date
from t2
where cnt >= 3;
