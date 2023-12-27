package com.eric.solution.sort;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2023-12-27 11:51 AM
 * @since jdk-11.0.14
 */
public class SortUtil
{
    public static void swap(int[] arr, int i, int j)
    {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
