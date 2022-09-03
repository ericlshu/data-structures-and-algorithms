package solution.array;

/**
 * Description : 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * @author Eric L SHU
 * @date 2022-09-03 19:52
 * @since jdk-11.0.14
 */
public class P0136SingleNumber
{
    public int singleNumber(int[] nums)
    {
        for (int i = 1; i < nums.length; i++)
        {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}
