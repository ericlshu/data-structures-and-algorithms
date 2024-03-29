package com.eric.solution.array;

/**
 * Description : 33. 搜索旋转排序数组
 * <p>
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * <p>
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * <p>
 * 示例 3：
 * 输入：nums = [1], target = 0
 * 输出：-1
 * <p>
 * 提示：
 * -> 1 <= nums.length <= 5000
 * -> -10^4 <= nums[i] <= 10^4
 * -> nums 中的每个值都 独一无二
 * -> 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -> -10^4 <= target <= 10^4
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
 *
 * @author Eric L SHU
 * @date 2021-04-23 20:10
 * @since JDK 1.8
 */
public class P0033SearchInRotatedSortedArray
{
    public int search_1(int[] nums, int target)
    {
        int left = 0, right = nums.length - 1;
        while (left <= right)
        {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
            {
                return mid;
            }
            else if (nums[mid] < nums[right])
            {
                // 如果中间的数小于最右边的数，则右半段是有序的
                if (nums[mid] < target && target <= nums[right])
                    // 目标值在右半段数组
                    left = mid + 1;
                else
                    // 目标值在左半段数组
                    right = mid - 1;
            }
            else
            {
                // 如果中间的数大于最右边的数，则左半段是有序的
                if (nums[left] <= target && target < nums[mid])
                    // 目标值在左半段数组
                    right = mid - 1;
                else
                    // 目标值在右半段数组
                    left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * nums[0] <= nums[mid]（0 - mid不包含旋转）且nums[0] <= target <= nums[mid] 时 high 向前规约；
     * nums[mid] < nums[0]（0 - mid包含旋转），target <= nums[mid] < nums[0] 时向前规约（target 在旋转位置到 mid 之间）
     * nums[mid] < nums[0]，nums[mid] < nums[0] <= target 时向前规约（target 在 0 到旋转位置之间）
     * 其他情况向后规约
     * 也就是说nums[mid] < nums[0]，nums[0] > target，target > nums[mid] 三项均为真或者只有一项为真时向后规约。
     */
    public int search_2(int[] nums, int target)
    {
        int left = 0, right = nums.length - 1;
        while (left < right)
        {
            int mid = (left + right) / 2;
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left] == target ? left : -1;
    }

    public int search_3(int[] nums, int target)
    {
        int left = 0, right = nums.length - 1;
        while (left <= right)
        {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}
