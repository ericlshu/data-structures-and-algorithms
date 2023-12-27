package com.eric.solution.sort;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2023-12-27 1:56 PM
 * @since jdk-11.0.14
 */
public class ShellSort
{
    public static void sort(int[] arr)
    {
        for (int gap = arr.length >> 1; gap > 0; gap = gap >> 1)
        {
            for (int low = gap; low < arr.length; low++)
            {
                int tmp = arr[low];
                int idx = low - gap;
                while (idx >= 0 && arr[idx] > tmp)
                {
                    arr[idx + gap] = arr[idx];
                    idx -= gap;
                }
                if (idx + gap != low)
                    arr[idx + gap] = tmp;
            }
            // System.out.println(Arrays.toString(arr));
        }
    }
}
