package solution.collection;

import java.util.Arrays;

/**
 * Description : 设计哈希映射
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 * 实现 MyHashMap 类：
 * <p>
 * MyHashMap() 用空映射初始化对象
 * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 * <p>
 * 示例：
 * 输入：
 * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * 输出：
 * [null, null, null, 1, -1, null, 1, null, -1]
 * <p>
 * 解释：
 * MyHashMap myHashMap = new MyHashMap();
 * myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
 * myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
 * myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
 * myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
 * myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
 * <p>
 * 提示：
 * 0 <= key, value <= 106
 * 最多调用 104 次 put、get 和 remove 方法
 *
 * @author Eric L SHU
 * @date 2022-10-11 21:50
 * @since jdk-11.0.14
 */
public class P0706DesignHashMap
{
    public static class MyHashMapArray
    {
        int[] map = new int[1_000_001];

        public MyHashMapArray()
        {
            Arrays.fill(map, -1);
        }

        public void put(int key, int value)
        {
            map[key] = value;
        }

        public int get(int key)
        {
            return map[key];
        }

        public void remove(int key)
        {
            map[key] = -1;
        }
    }

    public static class MyHashMapNode
    {

        static class Node
        {
            int key, value;
            Node next;

            Node(int _key, int _value)
            {
                key = _key;
                value = _value;
            }
        }

        Node[] nodes = new Node[10_000];

        public void put(int key, int value)
        {
            // 根据 key 获取哈希桶的位置
            int idx = getIndex(key);

            // 头插法
            // Node node = new Node(key, value);
            // node.next = nodes[idx];
            // nodes[idx] = node;

            // 该位置节点为null则新建节点
            if (nodes[idx] == null)
            {
                nodes[idx] = new Node(key, value);
            }
            else
            {
                Node node = nodes[idx], prev = null;
                while (node != null)
                {
                    // key存在则更新节点值
                    if (node.key == key)
                    {
                        node.value = value;
                        return;
                    }
                    prev = node;
                    node = node.next;
                }
                // key不存在则新建节点插入尾部
                prev.next = new Node(key, value);
            }
        }

        public void remove(int key)
        {
            int idx = getIndex(key);
            Node node = nodes[idx];
            if (node != null)
            {
                Node prev = null;
                while (node != null)
                {
                    if (node.key == key)
                    {
                        // 判断是否是第一个节点
                        if (prev != null)
                            prev.next = node.next;
                        else
                            nodes[idx] = node.next;
                        return;
                    }
                    prev = node;
                    node = node.next;
                }
            }
        }

        public int get(int key)
        {
            int idx = getIndex(key);
            Node node = nodes[idx];
            while (node != null)
            {
                if (node.key == key)
                    return node.value;
                node = node.next;
            }
            return -1;
        }

        private int getIndex(int key)
        {
            int hash = Integer.hashCode(key);
            hash ^= (hash >>> 16);
            return hash % nodes.length;
        }
    }
}
