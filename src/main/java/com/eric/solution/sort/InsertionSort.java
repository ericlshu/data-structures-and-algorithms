package com.eric.solution.sort;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2023-12-27 1:10 PM
 * @since jdk-11.0.14
 */
public class InsertionSort
{
    public static void sort(int[] arr)
    {
        for (int low = 1; low < arr.length; low++)
        {
            int tmp = arr[low];
            int idx = low - 1;

            while (idx >= 0 && arr[idx] > tmp)
            {
                arr[idx + 1] = arr[idx];
                idx--;
            }
            if (idx + 1 != low)
                arr[idx + 1] = tmp;
        }
    }
}
