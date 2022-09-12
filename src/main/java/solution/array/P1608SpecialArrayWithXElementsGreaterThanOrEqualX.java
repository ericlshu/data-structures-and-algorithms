package solution.array;

import java.util.Arrays;

/**
 * Description : 特殊数组的特征值
 * 给你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值 。
 * 注意： x 不必 是 nums 的中的元素。
 * 如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，那么其特征值 x 是 唯一的 。
 * <p>
 * 示例 1：
 * 输入：nums = [3,5]
 * 输出：2
 * 解释：有 2 个元素（3 和 5）大于或等于 2 。
 * <p>
 * 示例 2：
 * 输入：nums = [0,0]
 * 输出：-1
 * 解释：没有满足题目要求的特殊数组，故而也不存在特征值 x 。
 * 如果 x = 0，应该有 0 个元素 >= x，但实际有 2 个。
 * 如果 x = 1，应该有 1 个元素 >= x，但实际有 0 个。
 * 如果 x = 2，应该有 2 个元素 >= x，但实际有 0 个。
 * x 不能取更大的值，因为 nums 中只有两个元素。
 * <p>
 * 示例 3：
 * 输入：nums = [0,4,3,0,4]
 * 输出：3
 * 解释：有 3 个元素大于或等于 3 。
 * <p>
 * 示例 4：
 * 输入：nums = [3,6,7,7,0]
 * 输出：-1
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 *
 * @author Eric L SHU
 * @date 2022-09-12 10:54
 * @since jdk-11.0.14
 */
public class P1608SpecialArrayWithXElementsGreaterThanOrEqualX
{
    public int specialArray_1(int[] nums)
    {
        int n = nums.length;
        Arrays.sort(nums);
        if (n <= nums[0]) return n;
        for (int i = 1; i <= n; i++)
        {
            int count = 0;
            for (int num : nums)
            {
                if (i <= num)
                {
                    if (++count > i)
                        break;
                }
            }
            if (count == i)
                return i;
        }
        return -1;
    }

    /**
     * 根据特征值 x 的定义，x 一定是在 [1,n] 范围内的一个整数，其中 n 是数组 nums 的长度。
     * 因此，我们可以遍历 [1,n] 并判断某个整数 i 是否为特征值。
     * 若 i 为特征值，那么 nums 中恰好有 i 个元素大于等于 i。
     * 由于数组已经降序排序，说明 nums[i-1] 必须大于等于 i，并且 nums[i]（如果存在）必须小于 i。
     */
    public int specialArray_2(int[] nums)
    {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right)
        {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
        // for (int i = 0, j = n - 1; i < j; i++, j--)
        // {
        //     int temp = nums[i];
        //     nums[i] = nums[j];
        //     nums[j] = temp;
        // }
        for (int i = 1; i <= n; ++i)
        {
            if (nums[i - 1] >= i && (i == n || nums[i] < i))
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * 排序 + 枚举 + 二分
     * 根据题意并结合 nums[i] 的数据范围为 1000，我们可以通过「枚举」的方式找到 x，
     * 而对于每个 x 的合法性检查，我们需要快速知道 nums 中比 x 大的数的个数，这可以通过「排序 + 二分」来做。
     */
    public int specialArray(int[] nums)
    {
        Arrays.sort(nums);
        int n = nums.length;
        for (int x = 1; x <= n; x++)
        {
            int l = 0, r = n - 1;
            while (l < r)
            {
                int mid = l + r >> 1;
                if (nums[mid] >= x)
                    r = mid;
                else
                    l = mid + 1;
            }
            if (nums[r] >= x && x == n - r)
                return x;
        }
        return -1;
    }

}
