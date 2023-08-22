package com.eric.solution.array;

import java.util.Arrays;

/**
 * Description : 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 测试用例的答案是一个 32-位 整数。
 * 子数组 是数组的连续子序列。
 * <p>
 * 示例 1:
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * <p>
 * 示例 2:
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * 提示:
 * -> 1 <= nums.length <= 2 * 104
 * -> -10 <= nums[i] <= 10
 * -> nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
 *
 * @author Eric L SHU
 * @date 2022-12-20 19:10
 * @since jdk-11.0.14
 */
public class P0152MaximumProductSubarray
{
    public int maxProduct_1(int[] nums)
    {
        int n = nums.length;
        int[] dpMin = Arrays.copyOfRange(nums, 0, n);
        int[] dpMax = Arrays.copyOfRange(nums, 0, n);
        for (int i = 1; i < n; i++)
        {
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i], Math.max(dpMin[i - 1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMin[i - 1] * nums[i], Math.min(dpMax[i - 1] * nums[i], nums[i]));
        }
        // System.out.println(Arrays.toString(dpMin));
        // System.out.println(Arrays.toString(dpMax));
        // return Arrays.stream(dpMax).max().getAsInt();
        int res = dpMax[0];
        for (int i = 1; i < n; i++)
        {
            res = Math.max(res, dpMax[i]);
        }
        return res;
    }

    public int maxProduct_2(int[] nums)
    {
        int dpMax = nums[0], dpMin = nums[0], max = nums[0];
        int n = nums.length, _max, _min;
        for (int i = 1; i < n; i++)
        {
            _max = dpMax;
            _min = dpMin;
            dpMax = Math.max(_max * nums[i], Math.max(nums[i], _min * nums[i]));
            dpMin = Math.min(_min * nums[i], Math.min(nums[i], _max * nums[i]));
            max = Math.max(max, dpMax);
        }
        return max;
    }
}
