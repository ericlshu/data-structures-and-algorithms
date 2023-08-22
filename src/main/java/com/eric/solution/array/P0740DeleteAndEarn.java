package com.eric.solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description : 删除并获得点数
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * <p>
 * 示例 1：
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * <p>
 * 示例 2：
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 * <p>
 * 提示：
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] <= 104
 *
 * @author Eric L SHU
 * @date 2022-10-31 16:48
 * @since jdk-11.0.14
 */
public class P0740DeleteAndEarn
{
    public int deleteAndEarn_dp1(int[] nums)
    {
        int max = 0;
        for (int num : nums)
        {
            max = Math.max(max, num);
        }
        // int max = Arrays.stream(nums).max().getAsInt();
        int[] sum = new int[max + 1];
        for (int num : nums)
        {
            sum[num] += num;
        }
        int prev = sum[0], curr = Math.max(sum[0], sum[1]);
        for (int i = 2; i <= max; i++)
        {
            int temp = curr;
            curr = Math.max(prev + sum[i], curr);
            prev = temp;
        }
        return curr;
    }

    public int deleteAndEarn_dp2(int[] nums)
    {
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);
        List<Integer> sum = new ArrayList<>();
        sum.add(nums[0]);
        int size = 1;
        for (int i = 1; i < n; ++i)
        {
            int val = nums[i];
            if (val == nums[i - 1])
            {
                sum.set(size - 1, sum.get(size - 1) + val);
            }
            else if (val == nums[i - 1] + 1)
            {
                sum.add(val);
                ++size;
            }
            else
            {
                ans += rob(sum);
                sum.clear();
                sum.add(val);
                size = 1;
            }
        }
        ans += rob(sum);
        return ans;
    }

    private int rob(List<Integer> nums)
    {
        int size = nums.size();
        if (size == 1)
            return nums.get(0);
        int first = nums.get(0), second = Math.max(nums.get(0), nums.get(1));
        for (int i = 2; i < size; i++)
        {
            int temp = second;
            second = Math.max(first + nums.get(i), second);
            first = temp;
        }
        return second;
    }
}
