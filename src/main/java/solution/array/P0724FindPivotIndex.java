package solution.array;

import java.util.Arrays;

/**
 * Description : 寻找数组的中心下标
 * <p>
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 * <p>
 * 示例 1：
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 * <p>
 * 示例 2：
 * 输入：nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心下标。
 * <p>
 * 示例 3：
 * 输入：nums = [2, 1, -1]
 * 输出：0
 * <p>
 * 解释：
 * 中心下标是 0 。
 * 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
 * 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
 * <p>
 * 提示：
 * 1 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 *
 * @author Eric L SHU
 * @date 2021-12-28 21:38
 * @since JDK 1.8
 */
public class P0724FindPivotIndex
{
    public int pivotIndex_1(int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
        {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < i; j++)
            {
                leftSum += nums[j];
            }
            for (int j = i + 1; j < nums.length; j++)
            {
                rightSum += nums[j];
            }
            if (leftSum == rightSum)
                return i;
        }
        return -1;
    }

    public int pivotIndex_2(int[] nums)
    {
        /*int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }*/
        int totalSum = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (2 * leftSum + nums[i] == totalSum)
                return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
