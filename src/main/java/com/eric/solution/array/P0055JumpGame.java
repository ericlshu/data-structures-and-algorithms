package com.eric.solution.array;

/**
 * Description : 跳跃游戏
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * <p>
 * 示例 2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * @author Eric L SHU
 * @date 2020-10-25 12:26
 * @since JDK 1.8
 */
public class P0055JumpGame
{
    public boolean canJump_1(int[] nums)
    {
        int reach = 0, n = nums.length;
        for (int i = 0; i < n; ++i)
        {
            if (i > reach)
                return false;
            reach = Math.max(reach, i + nums[i]);
            if (reach >= n - 1)
                return true;
        }
        return true;
    }

    public boolean canJump_2(int[] nums)
    {
        int reach = 0, n = nums.length;
        for (int i = 0; i <= reach && reach < n - 1; i++)
        {
            reach = Math.max(i + nums[i], reach);
        }
        return reach >= n - 1;
    }

    public boolean canJump_3(int[] nums)
    {
        int n = nums.length, last = n - 1;
        for (int i = last - 1; i >= 0; i--)
        {
            if (i + nums[i] >= last)
                last = i;
        }
        return last == 0;
    }
}
