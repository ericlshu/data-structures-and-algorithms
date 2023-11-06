package com.eric.solution.array;

/**
 * 703. 数据流中的第 K 大元素
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * 请实现 KthLargest 类：
 * -> KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * -> int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 * <p>
 * 示例：
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 * <p>
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 * <p>
 * 提示：
 * -> 1 <= k <= 104
 * -> 0 <= nums.length <= 104
 * -> -104 <= nums[i] <= 104
 * -> -104 <= val <= 104
 * -> 最多调用 add 方法 104 次
 * -> 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
 */
public class P0703KthLargestElementInAStream
{
    private final MinHeap minHeap;

    public P0703KthLargestElementInAStream(int k, int[] nums)
    {
        minHeap = new MinHeap(k);
        for (int num : nums)
        {
            add(num);
        }
    }

    public int add(int val)
    {
        if (!minHeap.isFull())
        {
            minHeap.offer(val);
        }
        else if (val > minHeap.peek())
        {
            minHeap.replace(val);
        }
        return minHeap.peek();
    }

    public static class MinHeap
    {
        int[] array;
        int size;

        public MinHeap(int capacity)
        {
            this.array = new int[capacity];
        }

        public boolean isFull()
        {
            return size == array.length;
        }

        public int peek()
        {
            return array[0];
        }

        public boolean offer(int offered)
        {
            if (size == array.length)
                return false;
            up(offered);
            size++;
            return true;
        }

        public void replace(int replaced)
        {
            array[0] = replaced;
            down(0);
        }

        private void up(int offered)
        {
            int child = size;
            while (child > 0)
            {
                int parent = (child - 1) / 2;
                if (offered < array[parent])
                    array[child] = array[parent];
                else
                    break;
                child = parent;
            }
            array[child] = offered;
        }

        private void down(int parent)
        {
            int left = parent * 2 + 1;
            int right = left + 1;
            int min = parent;
            if (left < size && array[left] < array[min])
            {
                min = left;
            }
            if (right < size && array[right] < array[min])
            {
                min = right;
            }
            if (min != parent)
            {
                swap(min, parent);
                down(min);
            }
        }

        private void swap(int i, int j)
        {
            int t = array[i];
            array[i] = array[j];
            array[j] = t;
        }
    }
}
