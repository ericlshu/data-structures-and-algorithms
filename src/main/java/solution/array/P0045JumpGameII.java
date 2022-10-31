package solution.array;

/**
 * Description : 跳跃游戏 II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * <p>
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * <p>
 * 提示:
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 *
 * @author Eric L SHU
 * @date 2022-10-31 20:52
 * @since jdk-11.0.14
 */
public class P0045JumpGameII
{
    public int jump_1(int[] nums)
    {
        int steps = 0, idx = nums.length - 1;
        while (idx > 0)
        {
            for (int i = 0; i < idx; i++)
            {
                if (i + nums[i] >= idx)
                {
                    idx = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    public int jump_2(int[] nums)
    {
        int n = nums.length;
        int preEnd = 0; // 上次跳跃可达范围右边界
        int maxPos = 0; // 当前能够到达的最远位置
        int steps = 0;
        for (int i = 0; i < n - 1; i++)
        {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (maxPos >= n - 1)
            {
                return ++steps;
            }
            if (i == preEnd)
            {
                preEnd = maxPos;
                steps++;
            }
        }
        return steps;
    }
}
