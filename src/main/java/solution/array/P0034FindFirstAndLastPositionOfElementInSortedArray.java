package solution.array;

/**
 * Description : 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * <p>
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * <p>
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * <p>
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 *
 * @author Eric L SHU
 * @date 2021-04-25 6:09 PM
 * @since JDK 1.8
 */
public class P0034FindFirstAndLastPositionOfElementInSortedArray
{
    public int[] searchRange_1(int[] nums, int target)
    {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target)
            return result;
        int left = 0, right = nums.length - 1;
        while (left <= right)
        {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
            {
                left = right = mid;
                while (left >= 0 && nums[left] == target)
                    result[0] = left--;
                while (right <= nums.length - 1 && nums[right] == target)
                    result[1] = right++;
                return result;
            }
            else if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return result;
    }

    public int[] searchRange_2(int[] nums, int target)
    {
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false) - 1;
        if (left <= right && right < nums.length && nums[left] == target && nums[right] == target)
        {
            return new int[]{left, right};
        }
        return new int[]{-1, -1};
    }

    private int binarySearch(int[] nums, int target, boolean lower)
    {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right)
        {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target))
            {
                right = mid - 1;
                ans = mid;
            }
            else
            {
                left = mid + 1;
            }
        }
        return ans;
    }

    public int[] searchRange_3(int[] nums, int target)
    {
        return new int[]{bs(nums, target, true), bs(nums, target, false)};
    }

    private int bs(int[] nums, int target, boolean minMode)
    {
        int left = 0, right = nums.length - 1, idx = -1, mid;
        while (left <= right)
        {
            mid = (left + right) >>> 1;
            if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
            else
            {
                idx = mid;
                if (minMode)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return idx;
    }
}
