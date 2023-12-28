package com.eric.solution.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2023-12-28 4:52 PM
 * @since jdk-11.0.14
 */
public class BucketSort
{
    public static void sortByRange(int[] nums)
    {
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] > max)
                max = nums[i];
            if (nums[i] < min)
                min = nums[i];
        }
        int range = 10;
        int size = (max - min) / range + 1;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(size);
        for (int i = 0; i < size; i++)
        {
            buckets.add(new ArrayList<>());
        }
        for (int num : nums)
        {
            buckets.get((num - min) / range).add(num);
        }
        int idx = 0;
        for (ArrayList<Integer> bucket : buckets)
        {
            Collections.sort(bucket);
            // System.out.println("bucket = " + bucket);
            for (Integer v : bucket)
            {
                nums[idx++] = v;
            }
        }
    }

    public static void sortByCount(int[] nums)
    {
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] > max)
                max = nums[i];
            if (nums[i] < min)
                min = nums[i];
        }
        int size = 10;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(size);
        for (int i = 0; i < size; i++)
        {
            buckets.add(new ArrayList<>());
        }
        for (int num : nums)
        {
            int idx = (num - min) * size / (max - min + 1);
            // System.out.println("idx = " + idx);
            buckets.get(idx).add(num);
        }
        int idx = 0;
        for (ArrayList<Integer> bucket : buckets)
        {
            // System.out.println("bucket = " + bucket);
            Collections.sort(bucket);
            for (Integer v : bucket)
            {
                nums[idx++] =v;
            }
        }
    }
}
