package com.eric.solution.array;

import java.util.Arrays;

/**
 * Description : 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * 示例 1：
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * <p>
 * 示例 2：
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * 提示：
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A已按非递减顺序排序。
 *
 * @author Eric L SHU
 * @date 2020-10-16 20:56
 * @since JDK 1.8
 */
public class P0977SquaresOfASortedArray
{
    public int[] sortedSquares(int[] A)
    {
        int left = 0;
        int length = A.length;
        int right = length - 1;
        int index = length - 1;
        int[] result = new int[length];
        while (index >= 0)
        {
            if (A[left] + A[right] < 0)
                result[index--] = A[left] * A[left++];
            else
                result[index--] = A[right] * A[right--];
        }
        return result;
    }

    public int[] sortedSquares_1(int[] nums)
    {
        int n = nums.length;
        int negative = -1;
        for (int i = 0; i < n; ++i)
        {
            if (nums[i] < 0)
                negative = i;
            else
                break;
        }
        int[] ans = new int[n];
        int index = 0, i = negative, j = negative + 1;
        while (i >= 0 || j < n)
        {
            if (i < 0)
                ans[index] = nums[j] * nums[j++];
            else if (j == n)
                ans[index] = nums[i] * nums[i--];
            else if (nums[i] * nums[i] < nums[j] * nums[j])
                ans[index] = nums[i] * nums[i--];
            else
                ans[index] = nums[j] * nums[j++];
            ++index;
        }
        return ans;
    }

    public int[] sortedSquares_sort_2(int[] A)
    {
        return Arrays.stream(A).map(a -> a * a).sorted().toArray();
    }

    public int[] sortedSquares_sort_1(int[] nums)
    {
        for (int i = 0; i < nums.length; ++i)
        {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

}
