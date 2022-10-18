package solution.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description : 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 示例 1：
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 * <p>
 * 提示：
 * -> m == grid.length
 * -> n == grid[i].length
 * -> 1 <= m, n <= 300
 * -> grid[i][j] 的值为 '0' 或 '1'
 *
 * @author Eric L SHU
 * @date 2022-10-18 21:17
 * @since jdk-11.0.14
 */
public class P0200NumberOfIslands
{
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int numIslands_bfs(char[][] grid)
    {
        int cnt = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == '1')
                {
                    grid[i][j] = '0';
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty())
                    {
                        int[] cell = queue.poll();
                        for (int k = 0; k < 4; k++)
                        {
                            int x = cell[0] + dx[k];
                            int y = cell[1] + dy[k];
                            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1')
                            {
                                grid[x][y] = '0';
                                queue.offer(new int[]{x, y});
                            }
                        }
                    }
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public int numIslands_dfs(char[][] grid)
    {
        int cnt = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == '1')
                {
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }

    private void dfs(char[][] grid, int i, int j)
    {
        int m = grid.length;
        int n = grid[0].length;

        for (int k = 0; k < 4; k++)
        {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1')
            {
                grid[x][y] = '0';
                dfs(grid, x, y);
            }
        }
    }
}
