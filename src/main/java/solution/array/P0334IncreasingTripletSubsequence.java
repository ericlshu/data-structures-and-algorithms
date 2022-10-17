package solution.array;

/**
 * Description : 递增的三元子序列
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,4,5]
 * 输出：true
 * 解释：任何 i < j < k 的三元组都满足题意
 * <p>
 * 示例 2：
 * 输入：nums = [5,4,3,2,1]
 * 输出：false
 * 解释：不存在满足题意的三元组
 * <p>
 * 示例 3：
 * 输入：nums = [2,1,5,0,4,6]
 * 输出：true
 * 解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
 * <p>
 * 提示：
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 * <p>
 * 进阶：你能实现时间复杂度为 O(n) ，空间复杂度为 O(1) 的解决方案吗？
 *
 * @author Eric L SHU
 * @date 2022-10-17 21:03
 * @since jdk-11.0.14
 */
public class P0334IncreasingTripletSubsequence
{
    public boolean increasingTriplet_1(int[] nums)
    {
        int n = nums.length;
        if (n < 3)
            return false;
        int[] min = new int[n];
        int[] max = new int[n];
        min[0] = nums[0];
        max[n - 1] = nums[n - 1];
        int j;
        for (int i = 1; i < n; i++)
        {
            min[i] = Math.min(min[i - 1], nums[i]);
            j = n - i - 1;
            max[j] = Math.max(max[j + 1], nums[j]);
        }
        for (int i = 1; i < n - 1; i++)
        {
            if (nums[i] > min[i - 1] && nums[i] < max[i + 1])
                return true;
        }
        return false;
    }

    /**
     * 赋初始值的时候，已经满足second > first了，现在找第三个数third
     * (1) 如果third比second大，那就是找到了，直接返回true
     * (2) 如果third比second小，但是比first大，那就把second的值设为third，然后继续遍历找third
     * (3) 如果third比first还小，那就把first的值设为third，然后继续遍历找third（这样的话first会跑到second的后边，但是不要紧，因为在second的前边，老first还是满足的）
     */
    public boolean increasingTriplet_2(int[] nums)
    {
        int n = nums.length;
        if (n < 3)
            return false;
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++)
        {
            int third = nums[i];
            if (third > second)
                return true;
            else if (third > first)
                // first < third <= second
                second = third;
            else
                // third <= first
                first = third;
        }
        return false;
    }
}
