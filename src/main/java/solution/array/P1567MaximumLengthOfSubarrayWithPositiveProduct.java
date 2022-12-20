package solution.array;

/**
 * Description : 乘积为正数的最长子数组长度
 * 给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
 * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
 * 请你返回乘积为正数的最长子数组长度。
 * <p>
 * 示例  1：
 * 输入：nums = [1,-2,-3,4]
 * 输出：4
 * 解释：数组本身乘积就是正数，值为 24 。
 * <p>
 * 示例 2：
 * 输入：nums = [0,1,-2,-3,-4]
 * 输出：3
 * 解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
 * 注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。
 * <p>
 * 示例 3：
 * 输入：nums = [-1,-2,-3,0,1]
 * 输出：2
 * 解释：乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3] 。
 * <p>
 * 提示：
 * -> 1 <= nums.length <= 10^5
 * -> -10^9 <= nums[i] <= 10^9
 *
 * @author Eric L SHU
 * @date 2022-12-20 19:42
 * @since jdk-11.0.14
 */
public class P1567MaximumLengthOfSubarrayWithPositiveProduct
{
    public int getMaxLen_1(int[] nums)
    {
        int n = nums.length;
        int[] pos = new int[n];
        int[] neg = new int[n];

        if (nums[0] > 0)
            pos[0] = 1;
        else if (nums[0] < 0)
            neg[0] = 1;

        int max = pos[0];
        for (int i = 1; i < n; i++)
        {
            if (nums[i] > 0)
            {
                pos[i] = pos[i - 1] + 1;
                neg[i] = neg[i - 1] > 0 ? neg[i - 1] + 1 : 0;
            }
            else if (nums[i] < 0)
            {
                pos[i] = neg[i - 1] > 0 ? neg[i - 1] + 1 : 0;
                neg[i] = pos[i - 1] + 1;
            }
            else
            {
                pos[i] = 0;
                neg[i] = 0;
            }
            max = Math.max(max, pos[i]);
        }
        return max;
    }

    public int getMaxLen_2(int[] nums)
    {
        int n = nums.length;
        int pos = nums[0] > 0 ? 1 : 0;
        int neg = nums[0] < 0 ? 1 : 0;
        int max = pos, _neg;
        for (int i = 1; i < n; i++)
        {
            _neg = neg > 0 ? neg + 1 : 0;
            if (nums[i] > 0)
            {
                pos++;
                neg = _neg;
            }
            else if (nums[i] < 0)
            {
                neg = pos + 1;
                pos = _neg;
            }
            else
            {
                pos = 0;
                neg = 0;
            }
            max = Math.max(max, pos);
        }
        return max;
    }
}
