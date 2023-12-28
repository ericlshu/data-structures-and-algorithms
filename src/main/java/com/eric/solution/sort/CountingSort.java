package com.eric.solution.sort;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2023-12-28 4:06 PM
 * @since jdk-11.0.14
 */
public class CountingSort
{
    public static void sort(int[] nums)
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
        int[] cnt = new int[max - min + 1];
        for (int n : nums)
        {
            cnt[n - min]++;
        }

        int idx = 0;
        for (int i = 0; i < cnt.length; i++)
        {
            while (cnt[i]-- > 0)
            {
                nums[idx++] = i + min;
            }
        }
    }
}
