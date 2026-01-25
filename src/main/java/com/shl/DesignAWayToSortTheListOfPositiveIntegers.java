package com.shl;

import java.util.*;

/**
 * Description :
 * Design a way to sort the list of positive integers in the descending order according to frequency of the elements, The elements with
 * higher frequency come before those with lower frequencyElements with the same frequency come in the same order as they
 * appear in the given list.
 * InputThe first line of the input consists of an integer num, representing
 * the number of elements in the list (N).
 * The second line consists of N space-separated integers
 * representing the elements in the list.
 * OutputPrint N space-separated integers representing the elements of the list sorted according to the frequency of elements present in the
 * given list.
 * <p>
 * Example
 * Input
 * 19
 * 1 2 2 3 3 3 4 4 5 5 5 5 6 6 6 7 8 9 10
 * Output:
 * 5 5 5 5 3 3 3 6 6 6 2 2 4 4 1 7 8 9 10
 * <p>
 * Explanation:
 * The element 5 has highest frequency.
 * The elements 3 and 6 have same frequencies, So, their original order has been maintained in the output.
 * Similarly, the frequencies of rest of elements will be found and
 * arranged.So,the output will be:
 * 5 5 5 5 3 3 3 6 6 6 2 2 4 4 1 7 8 9 10
 *
 * @author Eric L SHU
 * @date 2026-01-13 19:25
 */
public class DesignAWayToSortTheListOfPositiveIntegers
{
    public static int[] freqSort(int[] listEle)
    {
        // 1. 统计频率
        Map<Integer, Integer> freqMap = new HashMap<>();
        // 2. 记录首次出现位置
        Map<Integer, Integer> firstIndex = new HashMap<>();

        for (int i = 0; i < listEle.length; i++)
        {
            int val = listEle[i];
            freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
            firstIndex.putIfAbsent(val, i);
        }

        // 3. 转成 List 方便稳定排序
        List<Integer> list = new ArrayList<>();
        for (int v : listEle)
        {
            list.add(v);
        }

        // 4. 稳定排序
        list.sort((a, b) ->
        {
            int freqCompare = Integer.compare(freqMap.get(b), freqMap.get(a));
            if (freqCompare != 0)
            {
                return freqCompare; // 频率高的在前
            }
            // 频率相同，按首次出现顺序
            return Integer.compare(firstIndex.get(a), firstIndex.get(b));
        });

        // 5. 转回数组
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        // 输入列表大小
        int listEleSize = in.nextInt();
        int[] listEle = new int[listEleSize];

        // 输入列表元素
        for (int idx = 0; idx < listEleSize; idx++)
        {
            listEle[idx] = in.nextInt();
        }

        // 获取排序后的结果
        int[] result = freqSort(listEle);

        // 输出排序后的结果
        for (int idx = 0; idx < result.length; idx++)
        {
            System.out.print(result[idx] + " ");
        }
    }
}
