package com.eric.solution.sort;

import java.util.Arrays;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2025-02-24 20:06
 * @since jdk-11.0.14
 */
public class MergeSort1
{
    public static void mergeSort(int[] nums)
    {
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
    }

    private static void mergeSort(int[] nums, int left, int right, int[] temp)
    {
        if (left >= right)
            return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        merge(nums, left, mid, right, temp);
    }

    private static void merge(int[] nums, int left, int mid, int right, int[] temp)
    {
        int i = left;
        int j = mid + 1;
        int k = i;
        // while (i <= mid && j <= right)
        // {
        //     temp[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        // }
        // while (i <= mid)
        // {
        //     temp[k++] = nums[i++];
        // }
        // while (j <= right)
        // {
        //     temp[k++] = nums[j++];
        // }
        while (i <= mid || j <= right)
        {
            if (i > mid)
            {
                temp[k++] = nums[j++];
                continue;
            }
            if (j > right)
            {
                temp[k++] = nums[i++];
                continue;
            }
            temp[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        System.arraycopy(temp, left, nums, left, right - left + 1);
    }
}
