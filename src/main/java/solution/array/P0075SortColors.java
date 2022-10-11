package solution.array;

/**
 * Description : 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库的sort函数的情况下解决这个问题。
 * <p>
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * <p>
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 * <p>
 * 进阶：
 * 你可以不使用代码库中的排序函数来解决这道题吗？
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * @author Eric L SHU
 * @date 2022-10-11 21:59
 * @since jdk-11.0.14
 */
public class P0075SortColors
{
    public void sortColors_2n(int[] nums)
    {
        int idx = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == 0)
                swap(nums, i, idx++);
        }
        for (int i = idx; i < nums.length; i++)
        {
            if (nums[i] == 1)
                swap(nums, i, idx++);
        }
    }

    private void swap(int[] nums, int i, int j)
    {
        if (i != j)
        {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }

    public void sortColors_n(int[] nums)
    {
        int p0 = 0, p1 = 0;
        for (int i = 0; i < nums.length; ++i)
        {
            if (nums[i] == 1)
                swap(nums, i, p1++);
            else if (nums[i] == 0)
            {
                swap(nums, i, p0);
                if (p0 < p1)
                    swap(nums, i, p1);
                p1++;
                p0++;
            }
        }
    }

    public void sortColors(int[] nums)
    {
        int l = 0, r = nums.length - 1, i = 0;
        while (i <= r)
        {
            if (nums[i] == 0)
                swap(nums, i++, l++);
            else if (nums[i] == 2)
                swap(nums, i, r--);
            else
                i++;
        }
    }
}
