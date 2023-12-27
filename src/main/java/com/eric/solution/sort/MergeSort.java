package com.eric.solution.sort;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2023-12-27 5:16 PM
 * @since jdk-11.0.14
 */
public class MergeSort
{
    public static void sortTopDown(int[] arr)
    {
        int[] tmp = new int[arr.length];
        split(arr, 0, arr.length - 1, tmp);
    }

    public static void sortBottomUp(int[] arr)
    {
        int len = arr.length;
        int[] tmp = new int[len];
        for (int width = 1; width < len; width *= 2)
        {
            for (int left = 0; left < len; left += 2 * width)
            {
                int right = Math.min(left + 2 * width - 1, len - 1);
                int mid = Math.min(left + width - 1, len - 1);
                // System.out.printf("width = %d, mid = %d in [%d, %d]%n", width,mid, left, right);
                merge(arr,left,mid,mid+1,right,tmp);
            }
            System.arraycopy(tmp,0,arr,0,len);
        }
    }

    private static void split(int[] arr, int left, int right, int[] tmp)
    {
        // System.out.println(Arrays.toString(Arrays.copyOfRange(arr, left, right + 1)));
        if (left == right)
            return;
        int mid = (left + right) >> 1;
        split(arr, left, mid, tmp);
        split(arr, mid + 1, right, tmp);
        merge(arr, left, mid, mid + 1, right, tmp);
        System.arraycopy(tmp, left, arr, left, right - left + 1);
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
