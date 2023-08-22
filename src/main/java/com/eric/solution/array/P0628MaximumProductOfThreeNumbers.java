package com.eric.solution.array;

import java.util.Arrays;

/**
 * Description : 三个数的最大乘积
 * <p>
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：6
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：24
 * <p>
 * 示例 3：
 * 输入：nums = [-1,-2,-3]
 * 输出：-6
 * <p>
 * 提示：
 * 3 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 *
 * @author Eric L SHU
 * @date 2022-01-01 20:43
 * @since JDK 1.8
 */
public class P0628MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {

        return 0;
    }


    public int maximumProductNormal(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
    }

    public int maximumProductNormalLinearScan(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            }
            else if (num < min2) {
                min2 = num;
            }
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;

            }
            else if (num > max2) {
                max3 = max2;
                max2 = num;
            }
            else if (num > max3) {
                max3 = num;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
