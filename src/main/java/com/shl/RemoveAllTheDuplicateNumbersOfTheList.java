package com.shl;

import java.util.*;

/**
 * Description :
 * You are given a list of numbers, Write an algorithm to remove all the duplicate numbers of the ist so that the list contains only distinct numbers in the same order as they appear in the input list,
 * <p>
 * Input
 * The first line of the input consists of an integer s/ze, representing the number of elements in the list (N).
 * The second line consists of N space-separated integers - arr/0, ar/1l.arf/ N-1) representing the list of positive integers.
 * <p>
 * Output
 * Print space-separated integers representing the distinct elements obtained by removing all the duplicate elements from the given list.
 * <p>
 * Example
 * Input:
 * 1 1 3 2 1 4 5 4
 * Output:
 * 1 3 2 4 5
 * <p>
 * Explanation:
 * Remove all the duplicate elements from the list (i.e., 1 and 4).The final list is [1,3,2,4, 51.
 *
 * @author Eric L SHU
 * @date 2026-01-13 20:11
 */
public class RemoveAllTheDuplicateNumbersOfTheList
{
    public static int[] removeDuplicate(int[] arr)
    {
        // 用于记录是否已经添加过某个数字
        Set<Integer> seen = new HashSet<>();
        // 用于保持插入顺序
        List<Integer> resultList = new ArrayList<>();

        for (int num : arr)
        {
            if (!seen.contains(num))
            {
                seen.add(num);
                resultList.add(num);
            }
        }

        // 将 List 转为数组
        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++)
        {
            result[i] = resultList.get(i);
        }

        return result;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int arr_size = in.nextInt();
        int[] arr = new int[arr_size];

        for (int i = 0; i < arr_size; i++)
        {
            arr[i] = in.nextInt();
        }

        int[] result = removeDuplicate(arr);
        for (int i = 0; i < result.length; i++)
        {
            System.out.print(result[i]);
            if (i != result.length - 1)
            {
                System.out.print(" ");
            }
        }
    }
}
