-- 180. Consecutive Numbers
/*
连续出现的数字
SQL架构
编写一个 SQL 查询，查找所有至少连续出现三次的数字。

+----+-----+
| Id | Num |
+----+-----+
| 1  |  1  |
| 2  |  1  |
| 3  |  1  |
| 4  |  2  |
| 5  |  1  |
| 6  |  2  |
| 7  |  2  |
+----+-----+
例如，给定上面的 Logs 表， 1 是唯一连续出现至少三次的数字。

+-----------------+
| ConsecutiveNums |
+-----------------+
| 1               |
+-----------------+
*/

Create table If Not Exists Logs (Id int, Num int);
Truncate table Logs;
insert into Logs (Id, Num) values ('1', '1');
insert into Logs (Id, Num) values ('2', '1');
insert into Logs (Id, Num) values ('3', '1');
insert into Logs (Id, Num) values ('4', '2');
insert into Logs (Id, Num) values ('5', '1');
insert into Logs (Id, Num) values ('6', '2');
insert into Logs (Id, Num) values ('7', '2');

select distinct num as 'ConsecutiveNums'
from (
         select num,
                lead(num, 1) over (order by id) as num1,
                lead(num, 2) over (order by id) as num2
         from LOGS) as temp
where temp.num = temp.num1
  and temp.num1 = temp.num2;

select distinct l1.Num as ConsecutiveNums
from Logs l1
         join Logs l2
              on l2.Id - 1 = l1.Id
                  and l2.Num = l1.Num
         join Logs l3
              on l3.Id - 1 = l2.Id
                  and l3.Num = l2.Num;