/*
608. 树节点
给定一个表 tree，id 是树节点的编号， p_id 是它父节点的 id 。
+----+------+
| id | p_id |
+----+------+
| 1  | null |
| 2  | 1    |
| 3  | 1    |
| 4  | 2    |
| 5  | 2    |
+----+------+
树中每个节点属于以下三种类型之一：

叶子：如果这个节点没有任何孩子节点。
根：如果这个节点是整棵树的根，即没有父节点。
内部节点：如果这个节点既不是叶子节点也不是根节点。

写一个查询语句，输出所有节点的编号和节点的类型，并将结果按照节点编号排序。上面样例的结果为：
+----+------+
| id | Type |
+----+------+
| 1  | Root |
| 2  | Inner|
| 3  | Leaf |
| 4  | Leaf |
| 5  | Leaf |
+----+------+

解释
节点 '1' 是根节点，因为它的父节点是 NULL ，同时它有孩子节点 '2' 和 '3' 。
节点 '2' 是内部节点，因为它有父节点 '1' ，也有孩子节点 '4' 和 '5' 。
节点 '3', '4' 和 '5' 都是叶子节点，因为它们都有父节点同时没有孩子节点。
*/
Create table If Not Exists Tree (id int, p_id int);
Truncate table Tree;
insert into Tree (id, p_id) values ('1', null);
insert into Tree (id, p_id) values ('2', '1');
insert into Tree (id, p_id) values ('3', '1');
insert into Tree (id, p_id) values ('4', '2');
insert into Tree (id, p_id) values ('5', '2');

select * from Tree;

select
    distinct
    id,
    case
        when root_id is null then 'Root'
        when leaf_id is null then 'Leaf'
        else 'Inner' end as Type
from
    (
        select
            tree.id,
            root.id as root_id,
            leaf.id as leaf_id
        from Tree tree
        left outer join Tree root on root.id = tree.p_id
        left outer join Tree leaf on leaf.p_id = tree.id
    ) tmp;

select
    distinct
    tree.id,
    case
        when root.id is null then 'Root'
        when leaf.id is null then 'Leaf'
        else 'Inner' end as Type
from Tree tree
         left outer join Tree root on root.id = tree.p_id
         left outer join Tree leaf on leaf.p_id = tree.id
order by id;


SELECT id,
       'Root' AS Type
FROM tree
WHERE p_id IS NULL

UNION

SELECT id,
       'Leaf' AS Type
FROM tree
WHERE id NOT IN (SELECT DISTINCT p_id
                 FROM tree
                 WHERE p_id IS NOT NULL)
  AND p_id IS NOT NULL

UNION

SELECT id,
       'Inner' AS Type
FROM tree
WHERE id IN (SELECT DISTINCT p_id
             FROM tree
             WHERE p_id IS NOT NULL)
  AND p_id IS NOT NULL
ORDER BY id;

SELECT core.id,
       IF(ISNULL(core.p_id), 'Root',
          IF(core.id IN (SELECT p_id FROM tree), 'Inner',
             'Leaf')) Type
FROM tree core
ORDER BY core.id;
