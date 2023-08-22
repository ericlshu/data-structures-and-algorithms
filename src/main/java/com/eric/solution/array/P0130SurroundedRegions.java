package com.eric.solution.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description : 被围绕的区域
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 示例 1：
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * <p>
 * 示例 2：
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 * <p>
 * 提示：
 * -> m == board.length
 * -> n == board[i].length
 * -> 1 <= m, n <= 200
 * -> board[i][j] 为 'X' 或 'O'
 *
 * @author Eric L SHU
 * @date 2023-01-08 20:45
 * @since jdk-11.0.14
 */
public class P0130SurroundedRegions
{
    int row, col;

    public void solve_dfs(char[][] board)
    {
        row = board.length;
        col = board[0].length;
        for (int i = 0; i < row; i++)
        {
            dfs(board, i, 0);
            dfs(board, i, col - 1);
        }

        for (int j = 1; j < col - 1; j++)
        {
            dfs(board, 0, j);
            dfs(board, row - 1, j);
        }
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (board[i][j] == 'A')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] board, int x, int y)
    {
        if (x < 0 || x >= row || y < 0 || y >= col || board[x][y] != 'O')
            return;
        board[x][y] = 'A';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }

    public void solve_bfs(char[][] board)
    {
        int row = board.length, col = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++)
        {
            if (board[i][0] == 'O')
            {
                queue.offer(new int[]{i, 0});
                board[i][0] = 'A';
            }
            if (board[i][col - 1] == 'O')
            {
                queue.offer(new int[]{i, col - 1});
                board[i][col - 1] = 'A';
            }
        }
        for (int j = 1; j < col - 1; j++)
        {
            if (board[0][j] == 'O')
            {
                queue.offer(new int[]{0, j});
                board[0][j] = 'A';
            }
            if (board[row - 1][j] == 'O')
            {
                queue.offer(new int[]{row - 1, j});
                board[row - 1][j] = 'A';
            }
        }
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1}, cell;
        int x, y, _x, _y;
        while (!queue.isEmpty())
        {
            cell = queue.poll();
            x = cell[0];
            y = cell[1];
            for (int k = 0; k < 4; k++)
            {
                _x = x + dx[k];
                _y = y + dy[k];
                if (_x >= 0 && _x < row && _y >= 0 && _y < col && board[_x][_y] == 'O')
                {
                    queue.offer(new int[]{_x, _y});
                    board[_x][_y] = 'A';
                }
            }
        }
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (board[i][j] == 'A')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
}
