package com.eric.solution.math;

import java.util.*;

/**
 * Description : 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * <p>
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * <p>
 * 提示：
 * -> 1 <= n <= 20
 * -> 1 <= k <= n
 *
 * @author Eric L SHU
 * @date 2022-10-06 11:38 AM
 * @since jdk-11.0.14
 */
public class P0077Combinations
{
    public List<List<Integer>> combine_dfs(int n, int k)
    {
        List<List<Integer>> lists = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        // 从 1 开始是题目的设定
        dfs_1(n, k, 1, path, lists);
        dfs_2(n, k, 1, path, lists);
        return lists;
    }

    private void dfs_1(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> lists)
    {
        // 递归终止条件是：path 的长度等于 k
        if (path.size() == k)
        {
            lists.add(new ArrayList<>(path));
            return;
        }
        // 遍历可能的搜索起点
        // for (int i = begin; i <= n; i++)
        // 搜索起点的上界 + 接下来要选择的元素个数 - 1 = n
        for (int i = begin; i <= n - (k - path.size()) + 1; i++)
        {
            // 向路径变量里添加一个数
            path.addLast(i);
            // System.out.println("递归之前 => " + path);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            dfs_1(n, k, i + 1, path, lists);
            // 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
            path.removeLast();
            // System.out.println("递归之后 <= " + path);
        }
    }

    private void dfs_2(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> lists)
    {
        if (k == 0)
        {
            lists.add(new ArrayList<>(path));
            return;
        }
        // 基础版本的递归终止条件：if (begin == n + 1) {
        if (begin > n - k + 1)
            return;
        // 不选当前考虑的数 begin，直接递归到下一层
        dfs_2(n, k, begin + 1, path, lists);
        // 不选当前考虑的数 begin，递归到下一层的时候 k - 1，这里 k 表示还需要选多少个数
        path.addLast(begin);
        dfs_2(n, k - 1, begin + 1, path, lists);
        // 深度优先遍历有回头的过程，因此需要撤销选择
        path.removeLast();
    }

    public List<List<Integer>> combine_dict(int n, int k)
    {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        // 初始化
        // 将 temp 中 [0, k - 1] 每个位置 i 设置为 i + 1，即 [0, k - 1] 存 [1, k]
        // 末尾加一位 n + 1 作为哨兵
        for (int i = 1; i <= k; ++i)
        {
            temp.add(i);
        }
        temp.add(n + 1);

        int j = 0;
        while (j < k)
        {
            ans.add(new ArrayList<>(temp.subList(0, k)));
            j = 0;
            // 寻找第一个 temp[j] + 1 != temp[j + 1] 的位置 t
            // 我们需要把 [0, t - 1] 区间内的每个位置重置成 [1, t]
            while (j < k && temp.get(j) + 1 == temp.get(j + 1))
            {
                temp.set(j, j + 1);
                ++j;
            }
            // j 是第一个 temp[j] + 1 != temp[j + 1] 的位置
            temp.set(j, temp.get(j) + 1);
        }
        return ans;
    }

    public List<List<Integer>> combineBackTrace(int n, int k)
    {
        List<List<Integer>> res = new ArrayList<>();
        backTrace(n, k, 1, new LinkedList<>(), res);
        return res;
    }

    private void backTrace(int n, int k, int start, Deque<Integer> path, List<List<Integer>> res)
    {
        if (path.size() == k)
        {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++)
        {
            // 缺的数字数 大于 备用的数字数，剪枝
            if (k - path.size() > n - i + 1)
                continue;
            path.push(i);
            // 递归
            backTrace(n, k, i + 1, path, res);
            // 回溯
            path.pop();
        }
    }
}
