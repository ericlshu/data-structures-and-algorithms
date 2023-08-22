package com.eric.solution.array;

import java.util.*;

/**
 * Description : 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * <p>
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 提示：
 * -> 1 <= nums.length <= 10
 * -> -10 <= nums[i] <= 10
 *
 * @author Eric L SHU
 * @date 2023-01-09 22:31
 * @since jdk-11.0.14
 */
public class P0090SubsetsII
{
    public List<List<Integer>> subsetsWithDup_1(int[] nums)
    {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        int n = nums.length, bound = 1 << n;
        for (int i = 0; i < bound; i++)
        {
            list.clear();
            for (int j = 0; j < n; j++)
            {
                if ((i & (1 << j)) != 0)
                {
                    list.add(nums[j]);
                }
            }
            set.add(new ArrayList<>(list));
        }
        return new ArrayList<>(set);
    }

    public List<List<Integer>> subsetsWithDup_2(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length, bound = 1 << n;
        for (int i = 0; i < bound; i++)
        {
            list.clear();
            boolean repeat = false;
            for (int j = 0; j < n; j++)
            {
                if ((i & (1 << j)) != 0)
                {
                    if (j > 0 && nums[j] == nums[j - 1] && (i >> (j - 1) & 1) == 0)
                    {
                        repeat = true;
                        break;
                    }
                    list.add(nums[j]);
                }
            }
            if (!repeat)
                res.add(new ArrayList<>(list));
        }
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup_3(int[] nums)
    {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return res;
    }

    private void dfs(boolean choosePre, int idx, int[] nums)
    {
        if (idx == nums.length)
        {
            res.add(new ArrayList<>(list));
            return;
        }
        dfs(false, idx + 1, nums);
        if (!choosePre && idx > 0 && nums[idx] == nums[idx - 1])
        {
            return;
        }
        list.add(nums[idx]);
        dfs(true, idx + 1, nums);
        list.remove(list.size() - 1);
    }
}
