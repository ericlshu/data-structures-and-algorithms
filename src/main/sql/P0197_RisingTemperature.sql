-- 197. Rising Temperature

/*
上升的温度
表 Weather

+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| id            | int     |
| recordDate    | date    |
| temperature   | int     |
+---------------+---------+
id 是这个表的主键
该表包含特定日期的温度信息


编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 id 。

返回结果 不要求顺序 。

查询结果格式如下例：

Weather
+----+------------+-------------+
| id | recordDate | Temperature |
+----+------------+-------------+
| 1  | 2015-01-01 | 10          |
| 2  | 2015-01-02 | 25          |
| 3  | 2015-01-03 | 20          |
| 4  | 2015-01-04 | 30          |
+----+------------+-------------+

Result table:
+----+
| id |
+----+
| 2  |
| 4  |
+----+
2015-01-02 的温度比前一天高（10 -> 25）
2015-01-04 的温度比前一天高（30 -> 20）
*/

Create table If Not Exists Weather (Id int, RecordDate date, Temperature int);
Truncate table Weather;
insert into Weather (Id, RecordDate, Temperature) values ('1', '2015-01-01', '10');
insert into Weather (Id, RecordDate, Temperature) values ('2', '2015-01-02', '25');
insert into Weather (Id, RecordDate, Temperature) values ('3', '2015-01-03', '20');
insert into Weather (Id, RecordDate, Temperature) values ('4', '2015-01-04', '30');

select Id
from
    (
        select
            temperature,
            recordDate,
            lead(id,1) over (order by recordDate) as 'Id',
            lead(recordDate,1) over (order by recordDate) as 'nextDate',
            lead(temperature,1) over (order by recordDate) as 'nextTemp'
        from weather
    )t
where nextTemp > temperature and DATEDIFF(nextDate, recordDate) = 1;

select Id
from
    (
        select
            temperature,
            recordDate,
            lead(id,1) over (order by recordDate) as 'Id',
            lead(recordDate,1) over (order by recordDate) as 'nextDate',
            lead(temperature,1) over (order by recordDate) as 'nextTemp'
        from weather
    )t
where nextTemp > temperature and nextDate = DATE_FORMAT(DATE_ADD(recordDate,INTERVAL 1 DAY),'%Y-%m-%d')