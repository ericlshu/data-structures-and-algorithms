package com.eric.solution.design;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Copyright (c) 2024 Authors. All rights reserved.
 *
 * <p>Project: data-structures-and-algorithms
 * <p>Created By : Eric L SHU
 * <p>Created On : 2024-03-12 13:58:25
 * <p>
 * <p>Description : LFU 缓存
 * <p>请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
 * <p>实现 LFUCache 类：
 * <p>LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
 * <p>int get(int key) - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。
 * <p>void put(int key, int value) - 如果键 key 已存在，则变更其值；如果键不存在，请插入键值对。
 * <p>当缓存达到其容量 capacity 时，则应该在插入新项之前，移除最不经常使用的项。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最久未使用 的键。
 * <p>为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
 * <p>当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
 * <p>函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * <p>示例：
 * <p>输入：
 * <p>["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
 * <p>[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 * <p>输出：
 * <p>[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 * <p>解释：
 * <p>// cnt(x) = 键 x 的使用计数
 * <p>// cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
 * <p>LFUCache lfu = new LFUCache(2);
 * <p>lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
 * <p>lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
 * <p>lfu.get(1);      // 返回 1
 * <p>                 // cache=[1,2], cnt(2)=1, cnt(1)=2
 * <p>lfu.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
 * <p>                 // cache=[3,1], cnt(3)=1, cnt(1)=2
 * <p>lfu.get(2);      // 返回 -1（未找到）
 * <p>lfu.get(3);      // 返回 3
 * <p>                 // cache=[3,1], cnt(3)=2, cnt(1)=2
 * <p>lfu.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
 * <p>                 // cache=[4,3], cnt(4)=1, cnt(3)=2
 * <p>lfu.get(1);      // 返回 -1（未找到）
 * <p>lfu.get(3);      // 返回 3
 * <p>                 // cache=[3,4], cnt(4)=1, cnt(3)=3
 * <p>lfu.get(4);      // 返回 4
 * <p>                 // cache=[3,4], cnt(4)=2, cnt(3)=3
 * <p>
 * <p>提示：
 * <p>1 <= capacity <= 104
 * <p>0 <= key <= 105
 * <p>0 <= value <= 109
 * <p>最多调用 2 * 105 次 get 和 put 方法
 *
 * @version 1.0
 * @since jdk-17
 */
public class P0460LFUCache
{
    private final Map<Integer, Node> kvMap = new HashMap<>();
    private final Map<Integer, LinkedList> freqMap = new HashMap<>();
    private final int capacity;
    private int minFreq = 1;

    public P0460LFUCache(int capacity)
    {
        this.capacity = capacity;
    }

    public int get(int key)
    {
        // 如果键不存在于缓存中，否则返回 -1
        if (!kvMap.containsKey(key))
            return -1;
        Node node = kvMap.get(key);
        // 将节点对象从原始频度链表中移除
        LinkedList oldList = freqMap.get(node.freq);
        oldList.remove(node);
        // 移除节点后，当前频度链表为空且节点频度为最小频度，则最小频度加1
        if (oldList.isEmpty() && node.freq == minFreq)
            minFreq++;
        // 节点访问频度+1
        node.freq++;
        // 将节点加入到新的频度链表头部
        LinkedList newList = freqMap.getOrDefault(node.freq, new LinkedList());
        newList.addFirst(node);
        freqMap.put(node.freq, newList);
        // 返回节点的值
        return node.val;
    }

    public void put(int key, int value)
    {
        // 如果键 key 已存在，则变更其值；
        if (kvMap.containsKey(key))
        {
            Node node = kvMap.get(key);
            LinkedList list = freqMap.get(node.freq);
            list.remove(node);
            if (list.isEmpty() && node.freq == minFreq)
                minFreq++;
            node.freq++;
            freqMap.computeIfAbsent(node.freq, k -> new LinkedList()).addFirst(node);
            node.val = value;
        }
        // 如果键不存在，请插入键值对。
        else
        {
            if (kvMap.size() == capacity)
            {
                Node node = freqMap.get(minFreq).removeLast();
                kvMap.remove(node.key);
            }
            Node node = new Node(key, value);
            kvMap.put(key, node);
            freqMap.computeIfAbsent(1, k -> new LinkedList()).addFirst(node);
            minFreq = 1;
        }
    }

    static class Node
    {
        Node next;
        Node prev;
        int key;
        int val;
        int freq = 1;

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
        int size;

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
            size++;
        }

        public void remove(Node node)
        {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public Node removeLast()
        {
            Node last = tail.prev;
            remove(last);
            return last;
        }

        public boolean isEmpty()
        {
            return size == 0;
        }
    }
}
