package solution.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description : 01 矩阵
 * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 * <p>
 * 示例 1：
 * 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：[[0,0,0],[0,1,0],[0,0,0]]
 * <p>
 * 示例 2：
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
 * 输出：[[0,0,0],[0,1,0],[1,2,1]]
 * <p>
 * 提示：
 * -> m == mat.length
 * -> n == mat[i].length
 * -> 1 <= m, n <= 104
 * -> 1 <= m * n <= 104
 * -> mat[i][j] is either 0 or 1.
 * -> mat 中至少有一个 0
 *
 * @author Eric L SHU
 * @date 2022-10-04 11:34
 * @since jdk-11.0.14
 */
public class P0542ZeroOneMatrix
{
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int[][] updateMatrix_bfs(int[][] mat)
    {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        boolean[][] seen = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                if (mat[i][j] == 0)
                {
                    queue.offer(new int[]{i, j});
                    seen[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty())
        {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];
            for (int k = 0; k < 4; k++)
            {
                int x = i + dx[k];
                int y = j + dy[k];
                if (x >= 0 && x < m && y >= 0 && y < n && !seen[x][y])
                {
                    dist[x][y] = dist[i][j] + 1;
                    queue.offer(new int[]{x, y});
                    seen[x][y] = true;
                }
            }

        }
        return dist;
    }

    public int[][] updateMatrix_bfs_1(int[][] mat)
    {
        // 首先将所有的 0 都入队，并且将 1 的位置设置成 -1，表示该位置是 未被访问过的 1
        Queue<int[]> queue = new LinkedList<>();
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (mat[i][j] == 0)
                    queue.offer(new int[]{i, j});
                else
                    mat[i][j] = -1;
            }
        }
        while (!queue.isEmpty())
        {
            int[] point = queue.poll();
            int i = point[0], j = point[1];
            for (int k = 0; k < 4; k++)
            {
                int x = i + dx[k];
                int y = j + dy[k];
                // 如果四邻域的点是 -1，表示这个点是未被访问过的 1
                // 所以这个点到 0 的距离就可以更新成 mat[i][j] + 1。
                if (x >= 0 && x < m && y >= 0 && y < n && mat[x][y] == -1)
                {
                    mat[x][y] = mat[i][j] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return mat;
    }

    public int[][] updateMatrix_bfs_2(int[][] mat)
    {
        // 首先将 0 边上的 1 入队
        Queue<int[]> queue = new LinkedList<>();
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (mat[i][j] == 0)
                {
                    for (int k = 0; k < 4; k++)
                    {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= 0 && x < m && y >= 0 && y < n && mat[x][y] == 1 && res[x][y] == 0)
                        {
                            // 这是在 0 边上的1。需要加上 res[x][y] == 0 的判断防止重复入队
                            res[x][y] = 1;
                            queue.offer(new int[]{x, y});
                        }
                    }
                }
            }
        }

        while (!queue.isEmpty())
        {
            int[] point = queue.poll();
            int i = point[0], j = point[1];
            for (int k = 0; k < 4; k++)
            {
                int x = i + dx[k];
                int y = j + dy[k];
                if (x >= 0 && x < m && y >= 0 && y < n && mat[x][y] == 1 && res[x][y] == 0)
                {
                    res[x][y] = res[i][j] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return res;
    }

    public int[][] updateMatrix_dp(int[][] mat)
    {
        int m = mat.length, n = mat[0].length;

        // 初始化动态规划的数组，所有的距离值都设置为一个很大的数
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i)
            Arrays.fill(dp[i], 20000);

        // 如果 (i, j) 的元素为 0，那么距离为 0
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (mat[i][j] == 0)
                    dp[i][j] = 0;

        // 只有 水平向左移动 和 竖直向上移动，注意动态规划的计算顺序
        for (int i = 0; i < m; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                if (i - 1 >= 0)
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                if (j - 1 >= 0)
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
            }
        }

        // 只有 水平向左移动 和 竖直向下移动，注意动态规划的计算顺序
        // for (int i = m - 1; i >= 0; --i)
        // {
        //     for (int j = 0; j < n; ++j)
        //     {
        //         if (i + 1 < m)
        //             dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
        //         if (j - 1 >= 0)
        //             dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
        //     }
        // }

        // 只有 水平向右移动 和 竖直向上移动，注意动态规划的计算顺序
        // for (int i = 0; i < m; ++i)
        // {
        //     for (int j = n - 1; j >= 0; --j)
        //     {
        //         if (i - 1 >= 0)
        //             dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
        //         if (j + 1 < n)
        //             dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
        //     }
        // }

        // 只有 水平向右移动 和 竖直向下移动，注意动态规划的计算顺序
        for (int i = m - 1; i >= 0; --i)
        {
            for (int j = n - 1; j >= 0; --j)
            {
                if (i + 1 < m)
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                if (j + 1 < n)
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
            }
        }
        return dp;
    }
}
