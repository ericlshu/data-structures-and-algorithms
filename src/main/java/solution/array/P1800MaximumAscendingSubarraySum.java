package solution.array;

/**
 * Description : 最大升序子数组和
 * 给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
 * 子数组是数组中的一个连续数字序列。
 * 已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），numsi < numsi+1 都成立，则称这一子数组为 升序 子数组。
 * 注意，大小为 1 的子数组也视作 升序 子数组。
 * <p>
 * 示例 1：
 * 输入：nums = [10,20,30,5,10,50]
 * 输出：65
 * 解释：[5,10,50] 是元素和最大的升序子数组，最大元素和为 65 。
 * <p>
 * 示例 2：
 * 输入：nums = [10,20,30,40,50]
 * 输出：150
 * 解释：[10,20,30,40,50] 是元素和最大的升序子数组，最大元素和为 150 。
 * <p>
 * 示例 3：
 * 输入：nums = [12,17,15,13,10,11,12]
 * 输出：33
 * 解释：[10,11,12] 是元素和最大的升序子数组，最大元素和为 33 。
 * <p>
 * 示例 4：
 * 输入：nums = [100,10,1]
 * 输出：100
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 *
 * @author Eric L SHU
 * @date 2022-10-07 9:14 AM
 * @since jdk-11.0.14
 */
public class P1800MaximumAscendingSubarraySum
{
    public int maxAscendingSum(int[] nums)
    {
        int maxSum = nums[0], sum = nums[0], idx = 1;
        while (idx < nums.length)
        {
            if (nums[idx] > nums[idx - 1])
                sum += nums[idx];
            else
                sum = nums[idx];
            maxSum = Math.max(maxSum, sum);
            idx++;
        }
        return maxSum;
    }

    /**
     * 0. 当i=0时，dp[0]=nums[0];
     * 1. 当nums[i]>nums[i−1]时，dp[i]=dp[i−1]+nums[i];
     * 2. 当nums[i]≤nums[i−1]时，dp[i]=nums[i];
     */
    public int maxAscendingSum_dp_n(int[] nums)
    {
        int len = nums.length;
        int[] dp = new int[len];
        int maxSum = dp[0] = nums[0];
        for (int i = 1; i < len; i++)
        {
            if (nums[i] > nums[i - 1])
                dp[i] = dp[i - 1] + nums[i];
            else
                dp[i] = nums[i];
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    public int maxAscendingSum_dp_1(int[] nums)
    {
        int[] dp = new int[2];
        int idx = 0, len = nums.length;
        while (idx < len)
        {
            dp[0] = nums[idx++];
            while (idx < len && nums[idx] > nums[idx - 1])
            {
                dp[0] += nums[idx++];
            }
            dp[1] = Math.max(dp[1], dp[0]);
        }
        return dp[1];
    }
}
