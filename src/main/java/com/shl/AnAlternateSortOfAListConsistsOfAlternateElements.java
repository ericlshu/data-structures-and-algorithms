package com.shl;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description :
 * An alternate sort of list consists of alternate elements (starting from the first position) of the given list after sorting it in an ascending order.
 * You are given a list of unsorted elements, Write an algorithm to find the alternate sort of the gven list
 * <p>
 * Input
 * The first line of the input consists of an integer size, representing the size of the given list (N).
 * The second line consists of N space-separated integers arr0, arr1, arrn,representing the elements of input list
 *
 * @author Eric L SHU
 * @date 2026-01-13 20:08
 */
public class AnAlternateSortOfAListConsistsOfAlternateElements
{
    public static int[] alternateSort(int[] arr)
    {
        Arrays.sort(arr);  // 对数组排序

        int n = arr.length;
        int newSize = (n + 1) / 2; // 需要的新数组大小（奇数位置个数）
        int[] answer = new int[newSize];

        for (int i = 0, j = 0; i < n; i += 2, j++)
        {
            answer[j] = arr[i]; // 取排序后的偶数下标（即原题的“alternate”位置）
        }

        return answer;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int arr_size = in.nextInt();
        int[] arr = new int[arr_size];

        for (int idx = 0; idx < arr_size; idx++)
        {
            arr[idx] = in.nextInt();
        }

        int[] result = alternateSort(arr);
        for (int val : result)
        {
            System.out.print(val + " ");
        }
    }
}
