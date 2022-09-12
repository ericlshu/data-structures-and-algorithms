package solution.array;

/**
 * Description : 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 * <p>
 * 提示:
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * <p>
 * 进阶：你能尽量减少完成的操作次数吗？
 *
 * @author Eric L SHU
 * @date 2022-09-03 20:00
 * @since jdk-11.0.14
 */
public class P0283MoveZeroes
{
    public void moveZeroes(int[] nums)
    {
        int index = 0;
        for (int num : nums)
        {
            if (num != 0)
                nums[index++] = num;
        }
        // for (int i = index; i < nums.length; i++)
        // {
        //     nums[i] = 0;
        // }
        while (index < nums.length)
        {
            nums[index++] = 0;
        }
    }

    public void moveZeroes_1(int[] nums)
    {
        int n = nums.length, left = 0, right = 0;
        while (right < n)
        {
            if (nums[right] != 0)
            {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private void swap(int[] nums, int left, int right)
    {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
