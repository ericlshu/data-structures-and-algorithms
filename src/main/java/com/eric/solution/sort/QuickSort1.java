package com.eric.solution.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2025-02-24 20:41
 * @since jdk-11.0.14
 */
public class QuickSort1
{
    public static void quickSort(int[] arr)
    {
        System.out.println("arr = " + Arrays.toString(arr));
        doSort(arr, 0, arr.length - 1);
    }

    private static void doSort(int[] arr, int left, int right)
    {
        if (left >= right)
            return;
        int pv = partition(arr, left, right);
        doSort(arr, left, pv - 1);
        doSort(arr, pv + 1, right);
    }

    private static int partition(int[] arr, int left, int right)
    {
        int idx = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        System.out.print ("idx = " + idx + "\t");
        int pv = arr[idx];
        swap(arr, idx, left);
        int i = left;
        int j = right;
        while (i < j)
        {
            while (i < j && arr[j] > pv)
            {
                j--;
            }
            while (i < j && arr[i] <= pv)
            {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, i, left);
        System.out.println("arr = " + Arrays.toString(arr));
        return i;
    }

    private static void swap(int[] arr, int i, int j)
    {
        if (i == j)
            return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
