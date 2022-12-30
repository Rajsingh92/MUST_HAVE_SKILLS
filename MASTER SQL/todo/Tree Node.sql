/*
+----+------+
| id | p_id |
+----+------+
| 1  | null |
| 2  | 1    |
| 3  | 1    |
| 4  | 2    |
| 5  | 2    |
+----+------+

Result:
+----+------+
| id | Type |
+----+------+
| 1  | Root |
| 2  | Inner|
| 3  | Leaf |
| 4  | Leaf |
| 5  | Leaf |
+----+------+
*/

select id, 'Root' as Type
from tree
where p_id is null

union

select id, 'Leaf' as Type
from tree
where id not in (select distinct p_id
        from tree
        where p_id is not null) 
    and p_id is not null

union

select id, 'Inner' as Type
from tree
where id in (select distinct p_id
        from tree
        where p_id is not null)
    and p_id is not null
order by id
