/*
表: Employees
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| employee_id | int     |
| name        | varchar |
+-------------+---------+
employee_id 是这个表的主键。
每一行表示雇员的id 和他的姓名。

表: Salaries
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| employee_id | int     |
| salary      | int     |
+-------------+---------+
employee_id is 这个表的主键。
每一行表示雇员的id 和他的薪水。

写出一个查询语句，找到所有 丢失信息 的雇员id。当满足下面一个条件时，就被认为是雇员的信息丢失：

雇员的 姓名 丢失了，或者
雇员的 薪水信息 丢失了，或者
返回这些雇员的id employee_id，从小到大排序。

查询结果格式如下面的例子所示。

示例 1：
输入：
Employees table:
+-------------+----------+
| employee_id | name     |
+-------------+----------+
| 2           | Crew     |
| 4           | Haven    |
| 5           | Kristian |
+-------------+----------+
Salaries table:
+-------------+--------+
| employee_id | salary |
+-------------+--------+
| 5           | 76071  |
| 1           | 22517  |
| 4           | 63539  |
+-------------+--------+
输出：
+-------------+
| employee_id |
+-------------+
| 1           |
| 2           |
+-------------+
解释：
雇员1，2，4，5 都工作在这个公司。
1号雇员的姓名丢失了。
2号雇员的薪水信息丢失了。
*/

Create table If Not Exists Employees
(
    employee_id int,
    name        varchar(30)
);
Create table If Not Exists Salaries
(
    employee_id int,
    salary      int
);
Truncate table Employees;
insert into Employees (employee_id, name)
values ('2', 'Crew');
insert into Employees (employee_id, name)
values ('4', 'Haven');
insert into Employees (employee_id, name)
values ('5', 'Kristian');
Truncate table Salaries;
insert into Salaries (employee_id, salary)
values ('5', '76071');
insert into Salaries (employee_id, salary)
values ('1', '22517');
insert into Salaries (employee_id, salary)
values ('4', '63539');

select *
from employees;
select *
from salaries;

select e.employee_id
from Employees e
         left join Salaries s on e.employee_id = s.employee_id
where salary is null
union all
select s.employee_id
from Employees e
         right join Salaries s on e.employee_id = s.employee_id
where name is null
order by employee_id;

select e.employee_id
from employees e
         left outer join salaries s on e.employee_id = s.employee_id
where s.salary is null
union
select s.employee_id
from employees e
         right outer join salaries s on e.employee_id = s.employee_id
where e.name is null
order by employee_id;


select e.employee_id
from Employees e
where not exists(select 1 from Salaries s where s.employee_id = e.employee_id)
union
select s.employee_id
from Salaries s
where not exists(select 1 from Employees e where s.employee_id = e.employee_id)
order by employee_id;

select employee_id
from Employees
where employee_id not in (select employee_id from Salaries)
union
select employee_id
from Salaries
where employee_id not in (select employee_id from Employees)
order by employee_id;

select employee_id
from (select employee_id, count(1) cnt
      from (select distinct employee_id
            from Employees
            union all
            select distinct employee_id
            from Salaries) x
      group by employee_id
      having cnt = 1) y
order by employee_id;
