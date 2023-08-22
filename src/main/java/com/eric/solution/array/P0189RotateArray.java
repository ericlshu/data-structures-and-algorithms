package com.eric.solution.array;

import java.util.Arrays;

/**
 * Description : 轮转数组
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 示例 2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 * <p>
 * 提示：
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 * <p>
 * 进阶：
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *
 * @author Eric L SHU
 * @date 2022-09-11 16:17
 * @since jdk-11.0.14
 */
public class P0189RotateArray
{
    public void rotate_newArray_1(int[] nums, int k)
    {
        int n = nums.length;
        k = k % n;
        int[] result = new int[n];
        for (int i = 0; i < n; i++)
        {
            if (i < k)
                result[i] = nums[n - k + i];
            else
                result[i] = nums[i - k];
        }
        System.arraycopy(result, 0, nums, 0, n);
    }

    public void rotate_newArray_2(int[] nums, int k)
    {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i)
        {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }


    public void rotate_local_1(int[] nums, int k)
    {
        int n = nums.length;
        k = k % n;
        for (int i = 0; i < k; i++)
        {
            int last = nums[n - 1];
            for (int j = n - 1; j > 0; j--)
            {
                nums[j] = nums[j - 1];
            }
            nums[0] = last;
        }
    }

    public void rotate_local_2(int[] nums, int k)
    {
        int n = nums.length;
        k = k % n;
        int[] tmp = Arrays.copyOfRange(nums, n - k, n);
        for (int j = n - 1; j >= 0; j--)
        {
            if (j >= k)
                nums[j] = nums[j - k];
            else
                nums[j] = tmp[j];
        }
    }

    public void rotate(int[] nums, int k)
    {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end)
    {
        while (start < end)
        {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
