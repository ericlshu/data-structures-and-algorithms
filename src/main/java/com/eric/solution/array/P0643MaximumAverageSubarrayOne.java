package com.eric.solution.array;

import java.util.Arrays;

/**
 * Description : 子数组最大平均数 I
 * <p>
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 * <p>
 * 示例 1：
 * 输入：nums = [1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * <p>
 * 示例 2：
 * 输入：nums = [5], k = 1
 * 输出：5.00000
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= k <= n <= 105
 * -104 <= nums[i] <= 104
 *
 * @author Eric L SHU
 * @date 2022-01-23 18:53
 * @since JDK 1.8
 */
public class P0643MaximumAverageSubarrayOne {
    public double findMaxAverage1(int[] nums, int k)
    {
        double maxAverage = -1E9;
        int[] temp;
        for (int i = 0; i <= nums.length - k; i++)
        {
            temp = Arrays.copyOfRange(nums, i, i + k);
            double average = Arrays.stream(temp).average().orElse(Double.NaN);
            maxAverage = Math.max(average, maxAverage);
        }
        return maxAverage;
    }

    public double findMaxAverage2(int[] nums, int k)
    {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++)
        {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++)
        {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }

    public double findMaxAverage3(int[] nums, int k)
    {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            if (i == k - 1)
            {
                maxSum = sum;
            }
            else if (i >= k)
            {
                sum -= nums[i - k];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum * 1.0 / k;
    }
}
