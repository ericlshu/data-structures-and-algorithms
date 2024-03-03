package com.eric.solution.array;

/**
 * <p>Copyright (c) 2024 Authors. All rights reserved.
 *
 * <p>Project: data-structures-and-algorithms
 * <p>Created By : Eric L SHU
 * <p>Created On : 2024-03-03 18:35:53
 * <p>
 * Description : 解数独
 * 编写一个程序，通过填充空格来解决数独问题。
 * 数独的解法需 遵循如下规则：
 * <p>1. 数字 1-9 在每一行只能出现一次。
 * <p>2. 数字 1-9 在每一列只能出现一次。
 * <p>3. 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * <p>数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * <p>示例 1：
 * <p>输入：board = [
 * <p>["5","3",".",".","7",".",".",".","."],
 * <p>["6",".",".","1","9","5",".",".","."],
 * <p>[".","9","8",".",".",".",".","6","."],
 * <p>["8",".",".",".","6",".",".",".","3"],
 * <p>["4",".",".","8",".","3",".",".","1"],
 * <p>["7",".",".",".","2",".",".",".","6"],
 * <p>[".","6",".",".",".",".","2","8","."],
 * <p>[".",".",".","4","1","9",".",".","5"],
 * <p>[".",".",".",".","8",".",".","7","9"]]
 * <p>输出：[
 * <p>["5","3","4","6","7","8","9","1","2"],
 * <p>["6","7","2","1","9","5","3","4","8"],
 * <p>["1","9","8","3","4","2","5","6","7"],
 * <p>["8","5","9","7","6","1","4","2","3"],
 * <p>["4","2","6","8","5","3","7","9","1"],
 * <p>["7","1","3","9","2","4","8","5","6"],
 * <p>["9","6","1","5","3","7","2","8","4"],
 * <p>["2","8","7","4","1","9","6","3","5"],
 * <p>["3","4","5","2","8","6","1","7","9"]]
 * <p>解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
 * <p>
 * 提示：
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字或者 '.'
 * 题目数据 保证 输入数独仅有一个解
 *
 * @version 1.0
 * @since jdk-17
 */
public class P0037SudokuSolver
{
    public static void solveSudoku(char[][] board)
    {
        boolean[][] rowConf = new boolean[9][9];// 行冲突
        boolean[][] colConf = new boolean[9][9];// 列冲突
        boolean[][] subConf = new boolean[9][9];// 宫冲突

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (board[i][j] != '.')
                {
                    int x = board[i][j] - '1';
                    rowConf[i][x] = true;
                    colConf[j][x] = true;
                    subConf[i / 3 * 3 + j / 3][x] = true;
                }
            }
        }
        dfs(board, 0, 0, rowConf, colConf, subConf);
    }

    private static boolean dfs(char[][] board, int i, int j, boolean[][] rowConf, boolean[][] colConf, boolean[][] subConf)
    {
        // 寻找下一个空白格
        while (board[i][j] != '.')
        {
            if (++j >= 9)
            {
                j = 0;
                i++;
            }
            if (i >= 9)
            {
                return true;
            }
        }

        // 尝试放入1->9的数字
        for (int x = 0; x < 9; x++)
        {
            // 剪枝
            if (rowConf[i][x] || colConf[j][x] || subConf[i / 3 * 3 + j / 3][x])
                continue;

            // 递归
            board[i][j] = (char) (x + '1');
            rowConf[i][x] = colConf[j][x] = subConf[i / 3 * 3 + j / 3][x] = true;
            if (dfs(board, i, j, rowConf, colConf, subConf))
                return true;

            // 回溯
            board[i][j] = '.';
            rowConf[i][x] = colConf[j][x] = subConf[i / 3 * 3 + j / 3][x] = false;
        }
        return false;
    }
}
