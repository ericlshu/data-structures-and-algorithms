package com.eric.solution.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Description :  找到所有数组中消失的数字
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * <p>
 * 示例 1：
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * <p>
 * 示例 2：
 * 输入：nums = [1,1]
 * 输出：[2]
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * <p>
 * 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
 *
 * @author Eric L SHU
 * @date 2022-09-04 13:28
 * @since jdk-11.0.14
 */
public class P0448FindAllNumbersDisappearedInAnArray
{
    public List<Integer> findDisappearedNumbers(int[] nums)
    {
        int n = nums.length;
        for (int num : nums)
        {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            if (nums[i] <= n)
                result.add(i + 1);
        }
        return result;

    }

    public List<Integer> findDisappearedNumbers_1(int[] nums)
    {
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums)
        {
            set.add(num);
        }
        for (int i = 1; i <= nums.length; i++)
        {
            if (set.add(i))
            {
                res.add(i);
            }
        }
        return res;
    }
}
