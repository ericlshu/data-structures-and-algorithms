package com.eric.solution.array;

/**
 * Description : 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例 1：
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 示例 2：
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 * <p>
 * 提示：
 * -> m == grid.length
 * -> n == grid[i].length
 * -> 1 <= m, n <= 200
 * -> 0 <= grid[i][j] <= 100
 *
 * @author Eric L SHU
 * @date 2022-12-15 21:47
 * @since jdk-11.0.14
 */
public class P0064MinimumPathSum
{
    public int minPathSum_1(int[][] grid)
    {
        int m = grid.length, n = grid[0].length;
        for (int i = 1; i < m; i++)
        {
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < n; j++)
        {
            grid[0][j] += grid[0][j - 1];
        }
        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }

    public int minPathSum_2(int[][] grid)
    {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (i == 0 && j == 0)
                    continue;
                else if (i == 0)
                    grid[0][j] += grid[0][j - 1];
                else if (j == 0)
                    grid[i][0] += grid[i - 1][0];
                else
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }
}
