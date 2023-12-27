package com.eric.solution.sort;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2023-12-27 12:54 PM
 * @since jdk-11.0.14
 */
public class HeapSort
{
    public static void sort(int[] arr)
    {
        heapify(arr, arr.length);
        for (int right = arr.length - 1; right > 0; right--)
        {
            SortUtil.swap(arr, 0, right);
            down(arr, 0, right);
        }
    }

    private static void heapify(int[] arr, int size)
    {
        for (int i = size / 2 - 1; i >= 0; i--)
        {
            down(arr, i, size);
        }
    }

    private static void down(int[] arr, int parent, int size)
    {
        while (true)
        {
            int left = parent * 2 + 1;
            int right = left + 1;
            int max = parent;
            if (left < size && arr[left] > arr[max])
                max = left;
            if (right < size && arr[right] > arr[max])
                max = right;
            if (max == parent)
                break;
            SortUtil.swap(arr, max, parent);
            parent = max;
        }
    }
}
