package solution.array;

/**
 * Description : 单调数列
 * 如果数组是单调递增或单调递减的，那么它是 单调 的。
 * 如果对于所有 i <= j，nums[i] <= nums[j]，那么数组 nums 是单调递增的。 如果对于所有 i <= j，nums[i]> = nums[j]，那么数组 nums 是单调递减的。
 * 当给定的数组 nums 是单调数组时返回 true，否则返回 false。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,2,3]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：nums = [6,5,4,4]
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：nums = [1,3,2]
 * 输出：false
 * <p>
 * 提示：
 * 1 <= nums.length <= 105
 * -105 <= nums[i] <= 105
 *
 * @author Eric L SHU
 * @date 2022-11-21 21:46
 * @since jdk-11.0.14
 */
public class P0896MonotonicArray
{
    public boolean isMonotonic_2n(int[] nums)
    {
        return isSorted(nums, true) || isSorted(nums, false);
    }

    private boolean isSorted(int[] nums, boolean increasing)
    {
        int n = nums.length;
        if (increasing)
        {
            for (int i = 0; i < n - 1; ++i)
            {
                if (nums[i] > nums[i + 1])
                {
                    return false;
                }
            }
        }
        else
        {
            for (int i = 0; i < n - 1; ++i)
            {
                if (nums[i] < nums[i + 1])
                {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isMonotonic_n(int[] nums)
    {
        boolean asc = true, desc = true;
        int n = nums.length;
        for (int i = 0; i < n - 1; ++i)
        {
            if (nums[i] > nums[i + 1])
            {
                asc = false;
            }
            if (nums[i] < nums[i + 1])
            {
                desc = false;
            }
        }
        return asc || desc;
    }
}
