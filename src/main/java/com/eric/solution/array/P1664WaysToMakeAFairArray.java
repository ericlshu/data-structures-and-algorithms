package com.eric.solution.array;

/**
 * Description : 生成平衡数组的方案数
 * 给你一个整数数组 nums 。你需要选择 恰好 一个下标（下标从 0 开始）并删除对应的元素。请注意剩下元素的下标可能会因为删除操作而发生改变。
 * 比方说，如果 nums = [6,1,7,4,1] ，那么：
 * -> 选择删除下标 1 ，剩下的数组为 nums = [6,7,4,1] 。
 * -> 选择删除下标 2 ，剩下的数组为 nums = [6,1,4,1] 。
 * -> 选择删除下标 4 ，剩下的数组为 nums = [6,1,7,4] 。
 * 如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 平衡数组 。
 * 请你返回删除操作后，剩下的数组 nums 是 平衡数组 的 方案数 。
 * <p>
 * 示例 1：
 * 输入：nums = [2,1,6,4]
 * 输出：1
 * 解释：
 * 删除下标 0 ：[1,6,4] -> 偶数元素下标为：1 + 4 = 5 。奇数元素下标为：6 。不平衡。
 * 删除下标 1 ：[2,6,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：6 。平衡。
 * 删除下标 2 ：[2,1,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：1 。不平衡。
 * 删除下标 3 ：[2,1,6] -> 偶数元素下标为：2 + 6 = 8 。奇数元素下标为：1 。不平衡。
 * 只有一种让剩余数组成为平衡数组的方案。
 * <p>
 * 示例 2：
 * 输入：nums = [1,1,1]
 * 输出：3
 * 解释：你可以删除任意元素，剩余数组都是平衡数组。
 * <p>
 * 示例 3：
 * 输入：nums = [1,2,3]
 * 输出：0
 * 解释：不管删除哪个元素，剩下数组都不是平衡数组。
 * <p>
 * 提示：
 * -> 1 <= nums.length <= 105
 * -> 1 <= nums[i] <= 104
 *
 * @author Eric L SHU
 * @date 2023-01-28 17:55
 * @since jdk-11.0.14
 */
public class P1664WaysToMakeAFairArray
{
    public int waysToMakeFair_1(int[] nums)
    {
        int lOdd = 0, lEven = 0;
        int rOdd = 0, rEven = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++)
        {
            if ((i & 1) != 0)
                rOdd += nums[i];
            else
                rEven += nums[i];
        }
        int res = 0;
        for (int i = 0; i < n; i++)
        {
            if ((i & 1) != 0)
                rOdd -= nums[i];
            else
                rEven -= nums[i];
            if (lOdd + rEven == rOdd + lEven)
                res++;
            if ((i & 1) != 0)
                lOdd += nums[i];
            else
                lEven += nums[i];

        }
        return res;
    }

    /**
     * 把 odd1 + even2 == odd2 + even1 变形得 odd1 - even1 == odd2 - even2，这样可以化简成两个变量
     * s1 = odd1 - even1 和 s2 = odd2 - even2，如果 s1 == s2 答案就加一。s1 和 s2 的更新就是 i 为奇数加，为偶数减。
     * 再变形成 s1 - s2 == 0，那么令 s = s1 - s2，就可以化简成一个变量了，当 s == 0 时答案加一。
     */
    public int waysToMakeFair_2(int[] nums)
    {
        int res = 0, s = 0, n = nums.length;
        for (int i = 0; i < n; i++)
        {
            s += (i & 1) != 0 ? nums[i] : -nums[i];
        }
        for (int i = 0; i < n; i++)
        {
            s -= (i & 1) != 0 ? nums[i] : -nums[i];
            if (s == 0)
                res++;
            s -= (i & 1) != 0 ? nums[i] : -nums[i];
        }
        return res;
    }
}
