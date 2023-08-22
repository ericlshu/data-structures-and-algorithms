package com.eric.solution.array;

import java.util.Arrays;

/**
 * Description : 最小差值 II
 * 给你一个整数数组 nums，和一个整数 k 。
 * 对于每个下标 i（0 <= i < nums.length），将 nums[i] 变成 nums[i] + k 或 nums[i] - k 。
 * nums 的 分数 是 nums 中最大元素和最小元素的差值。
 * 在更改每个下标对应的值之后，返回 nums 的最小 分数 。
 * <p>
 * 示例 1：
 * 输入：nums = [1], k = 0
 * 输出：0
 * 解释：分数 = max(nums) - min(nums) = 1 - 1 = 0 。
 * <p>
 * 示例 2：
 * 输入：nums = [0,10], k = 2
 * 输出：6
 * 解释：将数组变为 [2, 8] 。分数 = max(nums) - min(nums) = 8 - 2 = 6 。
 * <p>
 * 示例 3：
 * 输入：nums = [1,3,6], k = 3
 * 输出：3
 * 解释：将数组变为 [4, 6, 3] 。分数 = max(nums) - min(nums) = 6 - 3 = 3 。
 * <p>
 * 提示：
 * -> 1 <= nums.length <= 104
 * -> 0 <= nums[i] <= 104
 * -> 0 <= k <= 104
 *
 * @author Eric L SHU
 * @date 2023-01-13 22:04
 * @since jdk-11.0.14
 */
public class P0910SmallestRangeII
{
    public int smallestRangeII(int[] nums, int k)
    {
        Arrays.sort(nums);
        int n = nums.length, res = nums[n - 1] - nums[0];
        int high, low;
        for (int i = 0; i < n - 1; i++)
        {
            high = Math.max(nums[i] + k, nums[n - 1] - k);
            low = Math.min(nums[0] + k, nums[i + 1] - k);
            res = Math.min(res, high - low);
        }
        return res;
    }
}
