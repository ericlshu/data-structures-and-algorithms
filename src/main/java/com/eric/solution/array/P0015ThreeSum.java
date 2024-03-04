package com.eric.solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description : 三数之和
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author Eric L SHU
 * @date 2020-10-29 22:54
 * @since JDK 1.8
 */
public class P0015ThreeSum
{
    public List<List<Integer>> threeSum1(int[] nums)
    {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                for (int k = j + 1; k < n; k++)
                {
                    if (nums[i] + nums[j] + nums[k] == 0)
                    {
                        List<Integer> element = new ArrayList<>();
                        element.add(nums[i]);
                        element.add(nums[j]);
                        element.add(nums[k]);
                        if (!result.contains(element))
                            result.add(element);
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++)
        {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right)
            {
                if (nums[left] + nums[right] == target)
                {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1])
                    {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1])
                    {
                        right--;
                    }
                }
                else if (nums[left] + nums[right] < target)
                {
                    left++;
                }
                else
                {
                    right--;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSumDfs(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 3, 0, nums.length - 1, 0, new LinkedList<>(), res);

        return res;
    }

    /**
     * @param nums   升序数组
     * @param n      选取的数字个数
     * @param i      参与求解数组左边界
     * @param j      参与求解数组右边界
     * @param target 当前问题中数字和，初始为0
     * @param stack  已经被固定的数字
     * @param res    返回结果
     */
    private void dfs(int[] nums, int n, int i, int j, int target, LinkedList<Integer> stack, List<List<Integer>> res)
    {
        if (n == 2)
        {
            // 当n=2时，调用两数之和解法
            twoSum(nums, i, j, target, stack, res);
            return;
        }
        for (int k = i; k < j; k++)
        {
            // 剪枝：检查重复
            if (k > i && nums[k] == nums[k - 1])
                continue;
            // 递归：固定一个数字，求n-1个数字之和
            stack.push(nums[k]);
            dfs(nums, n - 1, k + 1, j, target - nums[k], stack, res);
            // 回溯
            stack.pop();
        }
    }

    private void twoSum(int[] nums, int i, int j, int target, LinkedList<Integer> stack, List<List<Integer>> res)
    {
        while (i < j)
        {
            int sum = nums[i] + nums[j];
            if (sum < target)
                i++;
            else if (sum > target)
                j--;
            else
            {
                ArrayList<Integer> list = new ArrayList<>(stack);
                list.add(nums[i++]);
                list.add(nums[j--]);
                res.add(list);
                while (i < j && nums[i] == nums[i - 1])
                {
                    i++;
                }
                while (i < j && nums[j] == nums[j + 1])
                {
                    j--;
                }
            }
        }
    }
}
