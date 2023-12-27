package com.eric.solution.sort;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2023-12-27 11:43 AM
 * @since jdk-11.0.14
 */
public class BubbleSort
{
    public static void sort(int[] arr)
    {
        int right = arr.length - 1;
        while (right > 0)
        {
            int lastSwap = 0;
            for (int left = 0; left < right; left++)
            {
                if (arr[left] > arr[left + 1])
                {
                    SortUtil.swap(arr, left, left + 1);
                    lastSwap = left;
                }
            }
            right = lastSwap;
            // System.out.println(Arrays.toString(arr));
        }
    }
}
