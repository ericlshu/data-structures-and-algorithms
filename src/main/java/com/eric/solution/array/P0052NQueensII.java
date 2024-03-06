package com.eric.solution.array;

/**
 * <p>Copyright (c) 2024 Authors. All rights reserved.
 *
 * <p>Project: data-structures-and-algorithms
 * <p>Created By : Eric L SHU
 * <p>Created On : 2024-03-06 15:05:52
 * <p>
 * Description : N 皇后 II
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 * <p>
 * 示例 1：
 * 输入：n = 4
 * 输出：2
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 * <p>
 * 提示：
 * 1 <= n <= 9
 *
 * @version 1.0
 * @since jdk-17
 */
public class P0052NQueensII
{
    public static int totalNQueens(int n)
    {
        boolean[] column = new boolean[n];
        boolean[] left = new boolean[2 * n + 1];
        boolean[] right = new boolean[2 * n + 1];
        return dfs(n, 0, column, left, right);
    }

    private static int dfs(int n, int i, boolean[] column, boolean[] left, boolean[] right)
    {
        if (i == n)
            return 1;
        int res = 0;
        for (int j = 0; j < n; j++)
        {
            if (column[j] || left[i + j] || right[n - 1 - (i - j)])
                continue;
            column[j] = left[i + j] = right[n - 1 - (i - j)] = true;
            res += dfs(n, i + 1, column, left, right);
            column[j] = left[i + j] = right[n - 1 - (i - j)] = false;
        }
        return res;
    }
}
