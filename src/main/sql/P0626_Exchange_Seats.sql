/*
小美是一所中学的信息科技老师，她有一张 seat 座位表，平时用来储存学生名字和与他们相对应的座位 id。

其中纵列的 id 是连续递增的

小美想改变相邻俩学生的座位。

你能不能帮她写一个 SQL query 来输出小美想要的结果呢？

 

示例：

+---------+---------+
|    id   | student |
+---------+---------+
|    1    | Abbot   |
|    2    | Doris   |
|    3    | Emerson |
|    4    | Green   |
|    5    | James  |
+---------+---------+
假如数据输入的是上表，则输出结果如下：

+---------+---------+
|    id   | student |
+---------+---------+
|    1    | Doris   |
|    2    | Abbot   |
|    3    | Green   |
|    4    | Emerson |
|    5    | James  |
+---------+---------+
注意：

如果学生人数是奇数，则不需要改变最后一个同学的座位。
*/

Create table If Not Exists Seat (id int, student varchar(255));
Truncate table Seat;
insert into Seat (id, student) values ('1', 'Abbot');
insert into Seat (id, student) values ('2', 'Doris');
insert into Seat (id, student) values ('3', 'Emerson');
insert into Seat (id, student) values ('4', 'Green');
insert into Seat (id, student) values ('5', 'James');

/*
select
    case
        when mod(id,2) = 1 then id + 1
        else id - 1 end as id,
    student
from seat where id <= (select floor(max(id) / 2) * 2 from seat )
union
select * from seat where id > (select floor(max(id) / 2) * 2 from seat )
order by id;
*/

select IF(mod(id, 2) = 1, id + 1, id - 1) as id,
    student
from seat where id <= (select floor(max(id) / 2) * 2 from seat )
union
select * from seat where id > (select floor(max(id) / 2) * 2 from seat )
order by id;

SELECT
    (CASE
         WHEN MOD(id, 2) != 0 AND counts != id THEN id + 1
         WHEN MOD(id, 2) != 0 AND counts = id THEN id
         ELSE id - 1
        END) AS id,
    student
FROM
    seat,
    (SELECT
         COUNT(*) AS counts
     FROM
         seat) AS seat_counts
ORDER BY id;

SELECT
    s1.id, COALESCE(s2.student, s1.student) AS student
FROM
    seat s1
        LEFT JOIN
    seat s2 ON ((s1.id + 1) ^ 1) - 1 = s2.id
ORDER BY s1.id;
