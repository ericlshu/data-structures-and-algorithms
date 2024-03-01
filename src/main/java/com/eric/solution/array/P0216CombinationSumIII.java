package com.eric.solution.array;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Copyright (c) 2024 Authors. All rights reserved.
 *
 * <p>Project: data-structures-and-algorithms
 * <p>Created By : Eric L SHU
 * <p>Created On : 2024-02-29 21:54:37
 * <p>
 * Description : 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * <p>
 * 示例 1:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 * <p>
 * 示例 2:
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 * <p>
 * 示例 3:
 * 输入: k = 4, n = 1
 * 输出: []
 * 解释: 不存在有效的组合。
 * 在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
 *
 * @version 1.0
 * @since jdk-17
 */
public class P0216CombinationSumIII
{
    public static List<List<Integer>> combinationSum3(int k, int n)
    {

        List<List<Integer>> res = new ArrayList<>();

        dfs(1, k, n, new LinkedList<>(), res);

        return res;
    }

    private static void dfs(int start, int k, int n, Deque<Integer> stack, List<List<Integer>> res)
    {
        if (n == 0 && stack.size() == k)
        {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i <= 9; i++)
        {
            if (i > n || stack.size() == k)
                continue;
            stack.push(i);
            dfs(i + 1, k, n - i, stack, res);
            stack.pop();
        }
    }
}
