package com.eric.solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Description : 最大间距
 * 给定一个无序的数组 nums，返回 数组在排序之后，相邻元素之间最大的差值 。如果数组元素个数小于 2，则返回 0 。
 * 您必须编写一个在「线性时间」内运行并使用「线性额外空间」的算法。
 * <p>
 * 示例 1:
 * 输入: nums = [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * <p>
 * 示例 2:
 * 输入: nums = [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 * <p>
 * 提示:
 * -> 1 <= nums.length <= 105
 * -> 0 <= nums[i] <= 109
 *
 * @author Eric L SHU
 * @date 2023-12-29 1:46 PM
 * @since jdk-11.0.14
 */
public class P0164MaximumGap
{
    public static int maximumGapByBucket(int[] nums)
    {
        if (nums.length < 2)
            return 0;
        bucketSort(nums);
        // System.out.println(Arrays.toString(nums));
        int max = 0;
        for (int i = 1; i < nums.length; i++)
        {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }
        return max;
    }

    private static void bucketSort(int[] nums)
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
        /*
            计算桶个数                  期望桶个数
            (max - min) / range + 1 = nums.length
            (max - min) / (nums.length -1) = range
         */
        int range = Math.max((max - min) / (nums.length - 1), 1);
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
            for (Integer v : bucket)
            {
                nums[idx++] = v;
            }
        }
    }

    public static int maximumGap(int[] nums)
    {
        if (nums.length < 2)
            return 0;
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] > max)
                max = nums[i];
            if (nums[i] < min)
                min = nums[i];
        }
        /*
            期望桶个数比元素个数多一个，保证有空桶，则桶间元素差值大于桶内元素差值
            计算桶个数                  期望桶个数
            (max - min) / range + 1 = nums.length + 1
            (max - min) / range = nums.length
            (max - min) / nums.length = range
         */
        int range = Math.max((max - min) / nums.length, 1);
        int size = (max - min) / range + 1;
        int[][] buckets = new int[size][2];
        for (int i = 0; i < size; i++)
        {
            // [max = -1, min = 1_000_000_001]
            buckets[i] = new int[]{-1, 1_000_000_001};
        }
        for (int num : nums)
        {
            int i = (num - min) / range;
            if (num > buckets[i][0])
                buckets[i][0] = num;
            if (num < buckets[i][1])
                buckets[i][1] = num;
        }
        // System.out.println(Arrays.deepToString(buckets));
        int maxGap = 0;
        int lastMax = buckets[0][0];
        for (int i = 1; i < size; i++)
        {
            // 当前桶不为空
            if (buckets[i][0] >= 0)
            {
                maxGap = Math.max(maxGap, buckets[i][1] - lastMax);
                lastMax = buckets[i][0];
            }
        }
        return maxGap;
    }

    public static int maximumGapByRadix(int[] nums)
    {
        if (nums.length < 2)
            return 0;
        radixSort(nums);
        int max = 0;
        for (int i = 1; i < nums.length; i++)
        {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }
        return max;
    }

    public static void radixSort(int[] nums)
    {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] > max)
                max = nums[i];
        }
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(10);
        for (int i = 0; i < 10; i++)
        {
            buckets.add(new ArrayList<>());
        }

        int mod = 1;
        while (mod <= max)
        {
            for (int n : nums)
            {
                buckets.get(n / mod % 10).add(n);
            }
            int idx = 0;
            for (ArrayList<Integer> bucket : buckets)
            {
                for (int n : bucket)
                {
                    nums[idx++] = n;
                }
                bucket.clear();
            }
            System.out.print("nums = " + Arrays.toString(nums));
            System.out.println("; mod = " + mod);
            mod *= 10;
        }
    }
}
