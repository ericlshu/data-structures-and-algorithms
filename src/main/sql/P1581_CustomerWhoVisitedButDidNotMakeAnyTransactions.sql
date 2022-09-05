Create table If Not Exists Visits(visit_id int, customer_id int);
Create table If Not Exists Transactions(transaction_id int, visit_id int, amount int);
Truncate table Visits;
insert into Visits (visit_id, customer_id) values ('1', '23');
insert into Visits (visit_id, customer_id) values ('2', '9');
insert into Visits (visit_id, customer_id) values ('4', '30');
insert into Visits (visit_id, customer_id) values ('5', '54');
insert into Visits (visit_id, customer_id) values ('6', '96');
insert into Visits (visit_id, customer_id) values ('7', '54');
insert into Visits (visit_id, customer_id) values ('8', '54');
    Truncate table Transactions;
insert into Transactions (transaction_id, visit_id, amount) values ('2', '5', '310');
insert into Transactions (transaction_id, visit_id, amount) values ('3', '5', '300');
insert into Transactions (transaction_id, visit_id, amount) values ('9', '5', '200');
insert into Transactions (transaction_id, visit_id, amount) values ('12', '1', '910');
insert into Transactions (transaction_id, visit_id, amount) values ('13', '2', '970');

select customer_id , count(1) as count_no_trans
from Visits v
    left outer join Transactions t on t.visit_id = v.visit_id
where transaction_id is null
group by customer_id
order by count_no_trans desc;

select
    customer_id, count(if(transaction_id is null, 1, null)) count_no_trans
from Visits v
    left join Transactions t on v.visit_id = t.visit_id
group by customer_id
having count_no_trans > 0
order by count_no_trans desc;

select
    customer_id, count(1) count_no_trans
from Visits v
where not exists (
        select 1 from Transactions t where t.visit_id=v.visit_id
    )
group by customer_id
order by count_no_trans desc;
