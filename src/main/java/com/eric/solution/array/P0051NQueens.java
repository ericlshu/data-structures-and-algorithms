package com.eric.solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Copyright (c) 2024 Authors. All rights reserved.
 *
 * <p>Project: data-structures-and-algorithms
 * <p>Created By : Eric L SHU
 * <p>Created On : 2024-03-03 17:53:30
 * <p>
 * Description : N 皇后
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例 1：
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：[["Q"]]
 * <p>
 * 提示：
 * 1 <= n <= 9
 *
 * @version 1.0
 * @since jdk-17
 */
public class P0051NQueens
{
    public static List<List<String>> solveNQueens(int n)
    {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        boolean[] columns = new boolean[n];
        boolean[] diagonalsLeft = new boolean[2 * n + 1];
        boolean[] diagonalsRight = new boolean[2 * n + 1];
        for (char[] row : board)
        {
            Arrays.fill(row, '.');
        }

        dfs(board, 0, n, columns, diagonalsLeft, diagonalsRight, res);

        return res;
    }

    private static void dfs(char[][] board, int i, int n, boolean[] columns,
                            boolean[] diagonalsLeft, boolean[] diagonalsRight, List<List<String>> res)
    {
        if (i == n)
        {
            List<String> list = new ArrayList<>();
            for (char[] row : board)
            {
                list.add(new String(row));
            }
            res.add(list);
        }

        for (int j = 0; j < n; j++)
        {
            // 剪枝
            if (columns[j] || diagonalsLeft[i + j] || diagonalsRight[n - 1 - (i - j)])
            {
                continue;
            }
            board[i][j] = 'Q';
            columns[j] = diagonalsLeft[i + j] = diagonalsRight[n - 1 - (i - j)] = true;
            // 递归
            dfs(board, i + 1, n, columns, diagonalsLeft, diagonalsRight, res);
            // 回溯
            board[i][j] = '.';
            columns[j] = diagonalsLeft[i + j] = diagonalsRight[n - 1 - (i - j)] = false;
        }
    }
}
