package com.eric.solution.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Description : 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * <p>
 * 示例 1：
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 示例 2：
 * 输入：triangle = [[-10]]
 * 输出：-10
 * <p>
 * 提示：
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 * <p>
 * 进阶：
 * 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
 *
 * @author Eric L SHU
 * @date 2022-09-23 23:31
 * @since jdk-11.0.14
 */
public class P0120Triangle
{
    /**
     * f[0][0] = c[0][0]
     * f[i][0] = f[i−1][0] + c[i][0]
     * f[i][j] = min(f[i−1][j−1], f[i−1][j]) + c[i][j]
     * f[i][i] = f[i−1][i−1] + c[i][i]
     */
    public int minimumTotal_n2(List<List<Integer>> triangle)
    {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i)
        {
            List<Integer> row = triangle.get(i);
            dp[i][0] = dp[i - 1][0] + row.get(0);
            for (int j = 1; j < i; ++j)
            {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + row.get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + row.get(i);
        }
        int minTotal = dp[n - 1][0];
        for (int i = 1; i < n; ++i)
        {
            minTotal = Math.min(minTotal, dp[n - 1][i]);
        }
        return minTotal;
    }

    public int minimumTotal_2n(List<List<Integer>> triangle)
    {
        int n = triangle.size();
        int[][] dp = new int[2][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i)
        {
            int curr = i % 2;
            int prev = 1 - curr;
            dp[curr][0] = dp[prev][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j)
            {
                dp[curr][j] = Math.min(dp[prev][j - 1], dp[prev][j]) + triangle.get(i).get(j);
            }
            dp[curr][i] = dp[prev][i - 1] + triangle.get(i).get(i);
        }
        int idx = (n - 1) % 2;
        int minTotal = dp[idx][0];
        for (int i = 1; i < n; ++i)
        {
            minTotal = Math.min(minTotal, dp[idx][i]);
        }
        return minTotal;
    }

    public int minimumTotal_n(List<List<Integer>> triangle)
    {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i)
        {
            dp[i] = dp[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; --j)
            {
                dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
            }
            dp[0] += triangle.get(i).get(0);
        }
        int minTotal = dp[0];
        for (int i = 1; i < n; ++i)
        {
            minTotal = Math.min(minTotal, dp[i]);
        }
        return minTotal;
    }

    // class Solution {
    //     public:
    //     int minimumTotal(vector<vector<int>>& triangle) {
    //         int n = triangle.size();
    //         for (int i = n-2; i >= 0; i--) {
    //             for (int j = 0; j < triangle[i].size(); j++) {
    //                 triangle[i][j] += min(triangle[i+1][j], triangle[i+1][j+1]);
    //             }
    //         }
    //         return triangle[0][0];
    //     }
    // };

    public int minimumTotal_iteration(List<List<Integer>> triangle)
    {
        int size = triangle.size();
        for (int i = size - 2; i >= 0; i--)
        {
            ArrayList<Integer> list = new ArrayList<>(triangle.get(i));
            for (int j = 0; j < triangle.get(i).size(); j++)
            {
                list.set(j, Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + list.get(j));
            }
            triangle.set(i, list);
        }
        return triangle.get(0).get(0);
    }

    /**
     * 递归
     */
    public int minimumTotal_recursion_1(List<List<Integer>> triangle)
    {
        return dfs_1(triangle, 0, 0);
    }

    private int dfs_1(List<List<Integer>> triangle, int i, int j)
    {
        if (i == triangle.size())
            return 0;
        return Math.min(dfs_1(triangle, i + 1, j), dfs_1(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }

    /**
     * 递归 + 记忆化
     */
    public int minimumTotal_recursion_2(List<List<Integer>> triangle)
    {
        Integer[][] memo = new Integer[triangle.size()][triangle.size()];
        return dfs_2(triangle, 0, 0, memo);
    }

    private int dfs_2(List<List<Integer>> triangle, int i, int j, Integer[][] memo)
    {
        if (i == triangle.size())
            return 0;
        if (memo[i][j] != null)
            return memo[i][j];
        return memo[i][j] = Math.min(dfs_2(triangle, i + 1, j, memo), dfs_2(triangle, i + 1, j + 1, memo)) + triangle.get(i).get(j);
    }

    /**
     * 动态规划
     */
    public int minimumTotal_dpn2(List<List<Integer>> triangle)
    {
        int n = triangle.size();
        // dp[i][j] 表示从点 (i, j) 到底边的最小路径和。
        int[][] dp = new int[n + 1][n + 1];
        // 从三角形的最后一行开始递推。
        for (int i = n - 1; i >= 0; i--)
        {
            for (int j = 0; j <= i; j++)
            {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    // class Solution {
    //     public:
    //     int minimumTotal(vector<vector<int>>& triangle) {
    //         vector<int> dp(triangle.back());
    //         for(int i = triangle.size() - 2; i >= 0; i --)
    //             for(int j = 0; j <= i; j ++)
    //                 dp[j] = min(dp[j], dp[j + 1]) + triangle[i][j];
    //         return dp[0];
    //     }
    // };

    /**
     * 动态规划+空间优化
     */
    public int minimumTotal_dpn(List<List<Integer>> triangle)
    {
        int n = triangle.size();
        // 多申请一个位置就可以不用判断越界了
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--)
        {
            for (int j = 0; j <= i; j++)
            {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
