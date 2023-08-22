package com.eric.solution.array;

/**
 * Description : 剑指 Offer 03. 数组中重复的数字
 * <p>
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * 限制：
 * 2 <= n <= 100000
 *
 * @author Eric L SHU
 * @date 2021-12-26 19:03
 * @since JDK 1.8
 */
public class Offer003FindRepeatNumberInArray {
    public int findRepeatNumber(int[] nums) {
        int[] results = new int[nums.length];
        for (int num : nums)
        {
            results[num]++;
            if (results[num] > 1)
            {
                return num;
            }
        }
        return -1;
    }
}
