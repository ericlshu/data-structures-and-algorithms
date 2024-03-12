package com.eric.solution.design;

import java.util.Arrays;
import java.util.Random;

/**
 * <p>Copyright (c) 2024 Authors. All rights reserved.
 *
 * <p>Project: data-structures-and-algorithms
 * <p>Created By : Eric L SHU
 * <p>Created On : 2024-03-12 16:03:08
 * <p>
 * Description : 设计跳表
 * <p>不使用任何库函数，设计一个 跳表 。
 * <p>跳表 是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思想与链表相似。
 * <p>例如，一个跳表包含 [30, 40, 50, 60, 70, 90] ，然后增加 80、45 到跳表中，以下图的方式操作：
 * <p>
 * <p>跳表中有很多层，每一层是一个短的链表。在第一层的作用下，增加、删除和搜索操作的时间复杂度不超过 O(n)。跳表的每一个操作的平均时间复杂度是 O(log(n))，空间复杂度是 O(n)。
 * <p>了解更多 : https://oi-wiki.org/ds/skiplist/
 * <p>在本题中，你的设计应该要包含这些函数：
 * <p>
 * <p>bool search(int target) : 返回target是否存在于跳表中。
 * <p>void add(int num): 插入一个元素到跳表。
 * <p>bool erase(int num): 在跳表中删除一个值，如果 num 不存在，直接返回false. 如果存在多个 num ，删除其中任意一个即可。
 * <p>注意，跳表中可能存在多个相同的值，你的代码需要处理这种情况。
 * <p>
 * <p>示例 1:
 * <p>输入
 * <p>["Skiplist", "add", "add", "add", "search", "add", "search", "erase", "erase", "search"]
 * <p>[[], [1], [2], [3], [0], [4], [1], [0], [1], [1]]
 * <p>输出
 * <p>[null, null, null, null, false, null, true, false, true, false]
 * <p>解释
 * <p>Skiplist skiplist = new Skiplist();
 * <p>skiplist.add(1);
 * <p>skiplist.add(2);
 * <p>skiplist.add(3);
 * <p>skiplist.search(0);   // 返回 false
 * <p>skiplist.add(4);
 * <p>skiplist.search(1);   // 返回 true
 * <p>skiplist.erase(0);    // 返回 false，0 不在跳表中
 * <p>skiplist.erase(1);    // 返回 true
 * <p>skiplist.search(1);   // 返回 false，1 已被擦除
 * <p>
 * <p>提示:
 * <p>0 <= num, target <= 2 * 104
 * <p>调用search, add,  erase操作次数不大于 5 * 104
 *
 * @version 1.0
 * @since jdk-17
 */
public class P1206DesignSkipList
{
    public static class SkipList
    {
        public SkipList()
        {
        }

        static Random r = new Random();
        private static final int MAX_LEVEL = 10;
        private final Node head = new Node(-1);

        static int randomLevel()
        {
            // return r.nextBoolean() ? 1 : r.nextBoolean() ? 2 : r.nextBoolean() ? 3 : 4;
            int x = 1;
            while (x < MAX_LEVEL)
            {
                if (r.nextBoolean())
                    return x;
                x++;
            }
            return x;
        }

        public boolean search(int target)
        {
            Node[] nodes = this.find(target);
            Node node = nodes[0].next[0];
            return node != null && node.val == target;
        }

        public void add(int num)
        {
            // 1. 确定添加位置（把 val 当作目标查询，经历的路径就可以确定添加位置）
            Node[] path = this.find(num);
            // 2. 创建新节点随机高度
            Node node = new Node(num);
            int level = randomLevel();
            // 3. 修改路径节点 next 指针，以及新节点 next 指针
            for (int i = 0; i < level; i++)
            {
                node.next[i] = path[i].next[i];
                path[i].next[i] = node;
            }
        }

        public boolean erase(int num)
        {
            Node[] path = this.find(num);
            Node node = path[0].next[0];
            if (node == null || node.val != num)
                return false;

            for (int i = 0; i < MAX_LEVEL && path[i].next[i] == node; i++)
            {
                path[i].next[i] = node.next[i];
            }
            return true;
        }

        private Node[] find(int val)
        {
            Node[] path = new Node[MAX_LEVEL];
            Node curr = head;
            for (int i = MAX_LEVEL - 1; i >= 0; i--)
            {
                // 若next指针不为null，且next指针指向的节点值<目标值，向右找
                while (curr.next[i] != null && curr.next[i].val < val)
                {
                    curr = curr.next[i];
                }
                path[i] = curr;
                // 若next指针为null，或者next指针指向的节点值>=目标值，向下找
            }
            return path;
        }

        static class Node
        {
            int val;
            Node[] next = new Node[MAX_LEVEL];

            public Node(int val)
            {
                this.val = val;
            }

            @Override
            public String toString()
            {
                return "Node(" + val + ")";
            }
        }
    }

    public static void main(String[] args)
    {
        SkipList list = new SkipList();
        SkipList.Node head = list.head;
        SkipList.Node n3 = new SkipList.Node(3);
        SkipList.Node n7 = new SkipList.Node(7);
        SkipList.Node n11 = new SkipList.Node(11);
        SkipList.Node n12 = new SkipList.Node(12);
        SkipList.Node n16 = new SkipList.Node(16);
        SkipList.Node n19 = new SkipList.Node(19);
        SkipList.Node n22 = new SkipList.Node(22);
        SkipList.Node n23 = new SkipList.Node(23);
        SkipList.Node n26 = new SkipList.Node(26);
        SkipList.Node n30 = new SkipList.Node(30);
        SkipList.Node n37 = new SkipList.Node(37);
        head.next[0] = head.next[1] = head.next[2] = n3;
        head.next[3] = head.next[4] = head.next[5] = head.next[6] = head.next[7] = n19;
        n3.next[0] = n3.next[1] = n3.next[2] = n7;
        n7.next[0] = n11;
        n7.next[1] = n12;
        n7.next[2] = n16;
        n11.next[0] = n12;
        n12.next[0] = n12.next[1] = n16;
        n16.next[0] = n16.next[1] = n16.next[2] = n19;
        n19.next[0] = n19.next[1] = n19.next[2] = n22;
        n19.next[3] = n26;
        n22.next[0] = n23;
        n22.next[1] = n22.next[2] = n26;
        n23.next[0] = n26;
        n26.next[0] = n30;
        n26.next[1] = n37;
        n30.next[0] = n37;

        System.out.println(Arrays.toString(list.find(30)));
    }
}
