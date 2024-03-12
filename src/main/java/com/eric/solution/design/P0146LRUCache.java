package com.eric.solution.design;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Copyright (c) 2024 Authors. All rights reserved.
 *
 * <p>Project: data-structures-and-algorithms
 * <p>Created By : Eric L SHU
 * <p>Created On : 2024-03-12 13:32:42
 * <p>
 * Description : LRU 缓存
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * 示例：
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * <p>
 * 提示：
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 * 最多调用 2 * 105 次 get 和 put
 *
 * @version 1.0
 * @since jdk-17
 */
public class P0146LRUCache
{
    private final Map<Integer, Node> map = new HashMap<>();
    private final LinkedList list = new LinkedList();
    private final int capacity;

    public P0146LRUCache(int capacity)
    {
        this.capacity = capacity;
    }

    public int get(int key)
    {
        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        list.remove(node);
        list.addFirst(node);
        return node.val;
    }

    public void put(int key, int value)
    {
        if (map.containsKey(key))
        {
            Node node = map.get(key);
            node.val = value;
            list.remove(node);
            list.addFirst(node);
        }
        else
        {
            Node node = new Node(key, value);
            map.put(key, node);
            list.addFirst(node);
            if (map.size() > capacity)
            {
                map.remove(list.removeLast().key);
            }
        }
    }

    static class Node
    {
        Node next;
        Node prev;
        int key;
        int val;

        public Node()
        {
        }

        public Node(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }

    static class LinkedList
    {
        Node head;
        Node tail;

        public LinkedList()
        {
            head = tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public void addFirst(Node node)
        {
            Node oldHead = this.head.next;
            node.next = oldHead;
            node.prev = head;
            head.next = node;
            oldHead.prev = node;
        }

        public void remove(Node node)
        {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public Node removeLast()
        {
            Node last = tail.prev;
            remove(last);
            return last;
        }
    }
}
