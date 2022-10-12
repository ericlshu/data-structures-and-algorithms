package solution.array;

import java.util.Arrays;

/**
 * Description : 三角形的最大周长
 * 给定由一些正数（代表长度）组成的数组 nums ，返回 由其中三个长度组成的、面积不为零的三角形的最大周长 。如果不能形成任何面积不为零的三角形，返回 0。
 * <p>
 * 示例 1：
 * 输入：nums = [2,1,2]
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,1]
 * 输出：0
 * <p>
 * 提示：
 * 3 <= nums.length <= 104
 * 1 <= nums[i] <= 106
 *
 * @author Eric L SHU
 * @date 2022-10-12 9:41 PM
 * @since jdk-11.0.14
 */
public class P0976LargestPerimeterTriangle
{
    public int largestPerimeter(int[] nums)
    {
        Arrays.sort(nums);
        int idx = nums.length - 3;
        while (idx >= 0)
        {
            if (nums[idx] + nums[idx + 1] > nums[idx + 2])
                return nums[idx] + nums[idx + 1] + nums[idx + 2];
            idx--;
        }
        return 0;
    }
}
