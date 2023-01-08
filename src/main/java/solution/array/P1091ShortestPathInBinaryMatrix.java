package solution.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description : 二进制矩阵中的最短路径
 * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
 * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
 * 路径途经的所有单元格都的值都是 0 。
 * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 * 畅通路径的长度 是该路径途经的单元格总数。
 * <p>
 * 示例 1：
 * 输入：grid = [[0,1],[1,0]]
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
 * 输出：4
 * <p>
 * 示例 3：
 * 输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
 * 输出：-1
 * <p>
 * 提示：
 * -> n == grid.length
 * -> n == grid[i].length
 * -> 1 <= n <= 100
 * -> grid[i][j] 为 0 或 1
 *
 * @author Eric L SHU
 * @date 2023-01-08 19:56
 * @since jdk-11.0.14
 */
public class P1091ShortestPathInBinaryMatrix
{
    public int shortestPathBinaryMatrix(int[][] grid)
    {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;
        if (n == 1)
            return 1;
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        // boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        int res = 1;
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;
        int size, x, y, _x, _y;
        int[] pt;
        while (!queue.isEmpty())
        {
            size = queue.size();
            while (size-- > 0)
            {
                pt = queue.poll();
                x = pt[0];
                y = pt[1];
                for (int i = 0; i < 8; i++)
                {
                    _x = x + dx[i];
                    _y = y + dy[i];
                    // if (_x >= 0 && _x < n && _y >= 0 && _y < n && grid[_x][_y] == 0 && !visited[_x][_y])
                    if (_x >= 0 && _x < n && _y >= 0 && _y < n && grid[_x][_y] == 0)

                    {
                        if (_x == n - 1 && _y == n - 1)
                            return res + 1;
                        queue.offer(new int[]{_x, _y});
                        grid[_x][_y] = 1;
                        // visited[_x][_y] = true;
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
