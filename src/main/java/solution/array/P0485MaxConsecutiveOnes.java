package solution.array;

/**
 * Description : 最大连续 1 的个数
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * <p>
 * 示例 2:
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2
 * <p>
 * 提示：
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1.
 *
 * @author Eric L SHU
 * @date 2022-09-04 19:54
 * @since jdk-11.0.14
 */
public class P0485MaxConsecutiveOnes
{
    public int findMaxConsecutiveOnes_1(int[] nums)
    {
        int maxCount = 0;
        int n = nums.length;
        int i = 0;
        while (i < n)
        {
            boolean start = false;
            int count = 0;
            while (i < n && !start && nums[i++] == 1)
            {
                start = true;
                count++;
            }
            while (i < n && start && nums[i++] == 1)
            {
                count++;
            }
            if (count > maxCount)
            {
                maxCount = count;
            }
        }
        return maxCount;
    }

    public int findMaxConsecutiveOnes(int[] nums)
    {
        int maxCount = 0, count = 0;
        for (int num : nums)
        {
            if (num == 1)
            {
                count++;
            }
            else
            {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        return Math.max(maxCount, count);
    }
}
