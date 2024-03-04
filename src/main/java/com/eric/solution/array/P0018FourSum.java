package com.eric.solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description : 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * <p>
 * 示例 2：
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 200
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 *
 * @author Eric L SHU
 * @date 2021-04-22 21:51
 * @since JDK 1.8
 */
public class P0018FourSum
{
    public List<List<Integer>> fourSum(int[] nums, int target)
    {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return result;
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++)
        {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            // 起始位置四个数之和大于target，结束循环
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                break;
            // 起始位置一个数与结束位置三个数之和小于target，起始位置右移，进行一下一次循环
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target)
                continue;
            for (int j = i + 1; j < length - 2; j++)
            {
                // 跳过相邻相等数据
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target)
                    break;
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target)
                    continue;
                int left = j + 1, right = length - 1;
                while (left < right)
                {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target)
                    {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        left++;
                        while (left < right && nums[right] == nums[right - 1])
                            right--;
                        right--;
                    }
                    else if (sum < target)
                    {
                        left++;
                    }
                    else
                    {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> fourSumDfs(int[] nums, int target)
    {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 4, target, 0, nums.length - 1, new LinkedList<>(), result);
        return result;
    }

    private void dfs(int[] nums, int n, long target, int i, int j, LinkedList<Integer> stack, List<List<Integer>> result)
    {
        if (n == 2)
        {
            twoSum(nums, target, i, j, stack, result);
            return;
        }
        for (int k = i; k < j - (n - 2); k++)
        {
            if (k > i && nums[k] == nums[k - 1])
                continue;
            stack.push(nums[k]);
            dfs(nums, n - 1, target - nums[k], k + 1, j, stack, result);
            stack.pop();
        }
    }

    private void twoSum(int[] nums, long target, int i, int j, LinkedList<Integer> stack, List<List<Integer>> result)
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
                result.add(list);
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
