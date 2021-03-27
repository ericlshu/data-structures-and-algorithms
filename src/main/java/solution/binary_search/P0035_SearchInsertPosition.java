package solution.binary_search;

/**
 * Description : 搜索插入位置
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * <p>
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * <p>
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * @author Eric L SHU
 * @date 2020-11-01 15:13
 * @since JDK 1.8
 */
public class P0035_SearchInsertPosition
{
    public int searchInsert(int[] nums, int target)
    {
        int i = 0;
        while (i < nums.length && nums[i] < target) i++;
        return i;
    }

    public int searchInsert_1(int[] nums, int target)
    {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right)
        {
            mid = left + (right - left) / 2;
            if (nums[mid] >= target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
}
