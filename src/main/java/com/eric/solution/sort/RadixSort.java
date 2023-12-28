package com.eric.solution.sort;

import java.util.ArrayList;

/**
 * Description : <h3>基数排序 最低有效数字 LSD(Least significant digit)</h3>
 *
 * @author Eric L SHU
 * @date 2023-12-28 6:22 PM
 * @since jdk-11.0.14
 */
public class RadixSort
{
    public static void sort(String[] arr, int len)
    {
        // ArrayList<ArrayList<String>> buckets = new ArrayList<>(10);
        ArrayList<ArrayList<String>> buckets = new ArrayList<>(128);
        for (int i = 0; i < 128; i++)
        {
            buckets.add(new ArrayList<>());
        }
        for (int i = len - 1; i >= 0; i--)
        {
            for (String str : arr)
            {
                // buckets.get(str.charAt(i) - '0').add(str);
                buckets.get(str.charAt(i)).add(str);
            }

            int idx = 0;
            for (ArrayList<String> bucket : buckets)
            {
                for (String str : bucket)
                {
                    arr[idx++] = str;
                }
                bucket.clear();
            }
        }
    }
}
