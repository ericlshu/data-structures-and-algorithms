package solution.array;

import java.util.Arrays;

/**
 * Description : 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * <p>
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * <p>
 * 提示：
 * -> 1 <= target <= 109
 * -> 1 <= nums.length <= 105
 * -> 1 <= nums[i] <= 105
 * <p>
 * 进阶：
 * -> 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 *
 * @author Eric L SHU
 * @date 2023-01-07 22:51
 * @since jdk-11.0.14
 */
public class P0209MinimumSizeSubarraySum
{
    public int minSubArrayLen_n2(int target, int[] nums)
    {
        int n = nums.length, res = n + 1, sum;
        for (int i = 0; i < n; i++)
        {
            sum = 0;
            for (int j = i; j < n; j++)
            {
                sum += nums[j];
                if (sum >= target)
                {
                    res = Math.min(res, j - i + 1);
                    break;
                }
            }
        }
        return res > n ? 0 : res;
    }

    public int minSubArrayLen_n(int target, int[] nums)
    {
        int n = nums.length, res = n + 1, sum = 0;
        int left = 0, right = 0;
        while (right < n)
        {
            sum += nums[right];
            while (sum >= target)
            {
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];
            }
            right++;
        }
        return res > n ? 0 : res;
    }

    public int minSubArrayLen_nlogn(int target, int[] nums)
    {
        int n = nums.length, res = n + 1;
        int[] preSum = new int[res];
        for (int i = 1; i <= n; i++)
        {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int tar, idx;
        for (int i = 0; i < n; i++)
        {
            tar = target + preSum[i];
            idx = Arrays.binarySearch(preSum, tar);
            if (idx < 0)
                idx = ~idx;
            if (idx <= n)
                res = Math.min(res, idx - i);
        }
        return res > n ? 0 : res;
    }
}
