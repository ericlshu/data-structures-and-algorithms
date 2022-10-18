package solution.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description : 岛屿的最大面积
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * <p>
 * 示例 1：
 * 输入：grid =
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 输出：6
 * 解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
 * <p>
 * 示例 2：
 * 输入：grid = [[0,0,0,0,0,0,0,0]]
 * 输出：0
 * <p>
 * 提示：
 * -> m == grid.length
 * -> n == grid[i].length
 * -> 1 <= m, n <= 50
 * -> grid[i][j] 为 0 或 1
 *
 * @author Eric L SHU
 * @date 2022-10-02 16:28
 * @since jdk-11.0.14
 */
public class OfferII105MaxAreaOfIsland
{
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int maxAreaOfIsland_dfs(int[][] grid)
    {
        int m = grid.length, n = grid[0].length, maxArea = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == 1)
                {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j)
    {
        // if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
        //     return 0;
        grid[i][j] = 0;
        int m = grid.length, n = grid[0].length, area = 1;
        for (int k = 0; k < 4; k++)
        {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1)
            {
                grid[x][y] = 0;
                area += dfs(grid, x, y);
            }
        }
        return area;
    }

    public int maxAreaOfIsland_bfs(int[][] grid)
    {
        int m = grid.length, n = grid[0].length, maxArea = 0;

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == 1)
                {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    int area = 1;
                    grid[i][j] = 0;
                    while (!queue.isEmpty())
                    {
                        int[] cell = queue.poll();
                        for (int k = 0; k < 4; k++)
                        {
                            int x = cell[0] + dx[k];
                            int y = cell[1] + dy[k];
                            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1)
                            {
                                grid[x][y] = 0;
                                area++;
                                queue.offer(new int[]{x, y});
                            }
                        }
                    }
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }
}
