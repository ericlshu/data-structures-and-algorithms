package com.eric.solution.array;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2023-02-27 20:26
 * @since jdk-11.0.14
 */
public class P1144DecreaseElementsToMakeArrayZigzag
{
    public int movesToMakeZigzag(int[] nums)
    {
        return Math.min(check(nums, 0), check(nums, 1));
    }

    private int check(int[] nums, int idx)
    {
        int res = 0, n = nums.length, gap;
        while (idx < n)
        {
            gap = 0;
            if (idx >= 1)
            {
                gap = Math.max(gap, nums[idx] - nums[idx - 1] + 1);
            }
            if (idx + 1 < n)
            {
                gap = Math.max(gap, nums[idx] - nums[idx + 1] + 1);
            }
            res += gap;
            idx += 2;
        }
        return res;
    }
}
