package com.eric.solution.array;

/**
 * Description : 最大子序和
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * @author Eric L SHU
 * @date 2020-11-02 22:33
 * @since JDK 1.8
 */
public class P0053MaximumSubarray
{
    public int maxSubArray_greedy(int[] nums)
    {
        int preSum = 0, curSum, maxSum = nums[0];
        for (int x : nums)
        {
            curSum = preSum + x;
            preSum = Math.max(curSum, x);
            maxSum = Math.max(maxSum, preSum);
        }
        return maxSum;
    }

    public int maxSubArray_dp1(int[] nums)
    {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        int result = dp[0] = nums[0];
        for (int i = 1; i < n; ++i)
        {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public int maxSubArray_dp2(int[] nums)
    {
        int pre = 0, maxAns = nums[0];
        for (int x : nums)
        {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public int maxSubArray_dp3(int[] nums)
    {
        int result = nums[0];
        for (int i = 1; i < nums.length; ++i)
        {
            if (nums[i - 1] > 0)
                nums[i] += nums[i - 1];
            result = Math.max(result, nums[i]);
        }
        return result;
    }

    public static class Status
    {
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum)
        {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    public int maxSubArray_partition(int[] nums)
    {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public Status getInfo(int[] a, int l, int r)
    {
        if (l == r)
            return new Status(a[l], a[l], a[l], a[l]);
        int m = (l + r) >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public Status pushUp(Status l, Status r)
    {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }

    public int minSubArray(int[] nums)
    {
        int curSum = nums[0], minSum = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            curSum = Math.min(curSum + nums[i], nums[i]);
            minSum = Math.min(minSum, curSum);
        }
        return minSum;
    }
}
