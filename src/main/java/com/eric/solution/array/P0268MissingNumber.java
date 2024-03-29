package com.eric.solution.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description : 268. 丢失的数字
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * <p>
 * 示例 1：
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * <p>
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * <p>
 * 示例 3：
 * 输入：nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 * <p>
 * 示例 4：
 * 输入：nums = [0]
 * 输出：1
 * 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 104
 * 0 <= nums[i] <= n
 * nums 中的所有数字都 独一无二
 * <p>
 * 进阶：你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
 *
 * @author Eric L SHU
 * @date 2022-09-02 21:45
 * @since jdk-11.0.14
 */
public class P0268MissingNumber
{
    public int missingNumber_sort(int[] nums)
    {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++)
        {
            if (nums[i] != i)
                return i;
        }
        return n;
    }

    public int missingNumber_math_sum(int[] nums)
    {
        int n = nums.length;
        int total = n * (n + 1) / 2;
        int arrSum = 0;
        for (int num : nums)
        {
            arrSum += num;
        }
        return total - arrSum;
    }

    /**
     * 位运算
     */
    public int missingNumber_math_bit(int[] nums)
    {
        int xor = 0;
        int n = nums.length;
        for (int num : nums)
        {
            xor ^= num;
        }
        for (int i = 0; i <= n; i++)
        {
            xor ^= i;
        }
        return xor;
    }

    /**
     * 哈希集合
     */
    public int missingNumber_hash(int[] nums)
    {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int num : nums)
        {
            set.add(num);
        }
        for (int i = 0; i <= n; i++)
        {
            if (!set.contains(i))
                return i;
        }
        return n;
    }
}
