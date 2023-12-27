package com.eric.solution.sort;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2023-12-27 5:16 PM
 * @since jdk-11.0.14
 */
public class MergeInsertionSort
{
    public static void sort(int[] arr)
    {
        int[] tmp = new int[arr.length];
        split(arr, 0, arr.length - 1, tmp);
    }

    private static void split(int[] arr, int left, int right, int[] tmp)
    {
        if (right - left <= 32)
        {
            insert(arr, left, right);
            return;
        }
        int mid = (left + right) >> 1;
        split(arr, left, mid, tmp);
        split(arr, mid + 1, right, tmp);
        merge(arr, left, mid, mid + 1, right, tmp);
        System.arraycopy(tmp, left, arr, left, right - left + 1);
    }

    private static void insert(int[] arr, int left, int right)
    {
        for (int low = left; low <= right; low++)
        {
            int tmp = arr[low];
            int idx = low - 1;
            while (idx >= left && arr[idx] > tmp)
            {
                arr[idx + 1] = arr[idx--];
            }
            if (idx + 1 != low)
            {
                arr[idx + 1] = tmp;
            }
        }
    }

    private static void merge(int[] a1, int i, int iEnd, int j, int jEnd, int[] a2)
    {
        int k = i;
        while (i <= iEnd && j <= jEnd)
        {
            if (a1[i] < a1[j])
                a2[k] = a1[i++];
            else
                a2[k] = a1[j++];
            k++;
        }
        if (i > iEnd)
            System.arraycopy(a1, j, a2, k, jEnd - j + 1);
        if (j > jEnd)
            System.arraycopy(a1, i, a2, k, iEnd - i + 1);
    }
}
