package com.eric.solution.array;

/**
 * Description : 除自身以外数组的乘积
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 示例 1:
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * <p>
 * 示例 2:
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 * <p>
 * 提示：
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
 * <p>
 * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 * @author Eric L SHU
 * @date 2022-10-17 20:44
 * @since jdk-11.0.14
 */
public class P0238ProductOfArrayExceptSelf
{
    public int[] productExceptSelf_1(int[] nums)
    {
        int n = nums.length;
        int[] l = new int[n], r = new int[n];
        l[0] = 1;
        r[n - 1] = 1;
        for (int i = 1; i < n; i++)
        {
            l[i] = nums[i - 1] * l[i - 1];
            r[n - i - 1] = nums[n - i] * r[n - i];
        }
        for (int i = 0; i < n; i++)
        {
            nums[i] = l[i] * r[i];
        }
        return nums;
    }

    public int[] productExceptSelf_2(int[] nums)
    {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++)
        {
            res[i] = nums[i - 1] * res[i - 1];
        }
        int r = 1;
        for (int i = n - 1; i >= 0; i--)
        {
            res[i] *= r;
            r *= nums[i];
        }
        return res;
    }
}
