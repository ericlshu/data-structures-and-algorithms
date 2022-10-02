package solution.array;

import java.util.Deque;
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
public class P0695MaxAreaOfIsland
{
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int maxAreaOfIsland_dfs_recursion(int[][] grid)
    {
        int ans = 0, row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; ++i)
        {
            for (int j = 0; j < col; ++j)
            {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int x, int y)
    {
        if (x < 0 || y < 0 || x == grid.length || y == grid[0].length || grid[x][y] != 1)
            return 0;
        grid[x][y] = 0;
        int ans = 1;
        for (int i = 0; i < 4; i++)
        {
            ans += dfs(grid, x + dx[i], y + dy[i]);
        }
        return ans;
    }

    public int maxAreaOfIsland_dfs_stack(int[][] grid)
    {
        int ans = 0;
        for (int i = 0; i != grid.length; ++i)
        {
            for (int j = 0; j != grid[0].length; ++j)
            {
                int max = 0;
                Deque<int[]> stack = new LinkedList<>();
                // Deque<Integer> stacki = new LinkedList<>();
                // Deque<Integer> stackj = new LinkedList<>();
                stack.push(new int[]{i, j});
                // stacki.push(i);
                // stackj.push(j);
                while (!stack.isEmpty())
                {
                    // int x = stacki.pop(), y = stackj.pop();
                    int[] cell = stack.pop();
                    int x = cell[0], y = cell[1];
                    if (x < 0 || y < 0 || x == grid.length || y == grid[0].length || grid[x][y] != 1)
                        continue;
                    max++;
                    grid[x][y] = 0;
                    for (int idx = 0; idx < 4; idx++)
                    {
                        stack.push(new int[]{x + dx[idx], y + dy[idx]});
                        // stacki.push(x + dx[index]);
                        // stackj.push(y + dy[index]);
                    }
                }
                ans = Math.max(ans, max);
            }
        }
        return ans;
    }

    public int maxAreaOfIsland_bfs_queue(int[][] grid)
    {
        int ans = 0;
        for (int i = 0; i != grid.length; ++i)
        {
            for (int j = 0; j != grid[0].length; ++j)
            {
                int max = 0;
                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{i, j});
                while (!queue.isEmpty())
                {
                    int[] cell = queue.poll();
                    int x = cell[0], y = cell[1];
                    if (x < 0 || y < 0 || x == grid.length || y == grid[0].length || grid[x][y] != 1)
                        continue;
                    max++;
                    grid[x][y] = 0;
                    for (int idx = 0; idx < 4; idx++)
                    {
                        queue.offer(new int[]{x + dx[idx], y + dy[idx]});
                    }
                }
                ans = Math.max(ans, max);
            }
        }
        return ans;
    }
}
