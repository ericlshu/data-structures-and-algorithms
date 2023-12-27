package com.eric.solution.sort;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2023-12-27 12:44 PM
 * @since jdk-11.0.14
 */
public class SelectionSort
{
    public static void sort(int[] arr)
    {
        for (int right = arr.length - 1; right > 0; right--)
        {
            int max = right;
            for (int i = 0; i < right; i++)
            {
                if (arr[i] > arr[max])
                    max = i;
            }
            if (max != right)
                SortUtil.swap(arr, max, right);
        }
    }
}
