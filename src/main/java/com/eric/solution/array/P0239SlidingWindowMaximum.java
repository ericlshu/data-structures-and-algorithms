package com.eric.solution.array;

import java.util.LinkedList;

/**
 * <p>Copyright (c) 2024 Authors. All rights reserved.
 *
 * <p>Project: data-structures-and-algorithms
 * <p>Created By : Eric L SHU
 * <p>Created On : 2024-03-05 21:09:15
 * <p>
 * Description : 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * <p>
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 *
 * @version 1.0
 * @since jdk-17
 */
public class P0239SlidingWindowMaximum
{
    public static int[] maxSlidingWindow(int[] nums, int k)
    {
        // 每次向单调递减队列加入元素，队头元素即为滑动窗口最大值
        MonotonicQueue queue = new MonotonicQueue();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++)
        {
            // 检查队列头部元素，超过滑动窗口范围要移除
            if (i >= k && queue.peek() == nums[i - k])
                queue.poll();
            queue.offer(nums[i]);
            if (i >= k - 1)
            {
                res[i - k + 1] = queue.peek();
            }
        }
        return res;
    }


    static class MonotonicQueue
    {
        private final LinkedList<Integer> dequeue = new LinkedList<>();

        public Integer peek()
        {
            return dequeue.peekFirst();
        }

        public void poll()
        {
            dequeue.pollFirst();
        }

        public void offer(Integer t)
        {
            while (!dequeue.isEmpty() && dequeue.peekLast() < t)
            {
                dequeue.pollLast();
            }
            dequeue.offerLast(t);
        }
    }

}
