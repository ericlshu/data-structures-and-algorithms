package com.eric.solution.array;

import java.util.*;

/**
 * Description : 腐烂的橘子
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * -> 值 0 代表空单元格；
 * -> 值 1 代表新鲜橘子；
 * -> 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * <p>
 * 示例 1：
 * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * <p>
 * 示例 2：
 * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * <p>
 * 示例 3：
 * 输入：grid = [[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 * <p>
 * 提示：
 * -> m == grid.length
 * -> n == grid[i].length
 * -> 1 <= m, n <= 10
 * -> grid[i][j] 仅为 0、1 或 2
 *
 * @author Eric L SHU
 * @date 2022-10-04 17:30
 * @since jdk-11.0.14
 */
public class P0994RottingOranges
{
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int orangesRotting(int[][] grid)
    {
        int m = grid.length, n = grid[0].length;
        boolean noFresh = true;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == 1)
                    noFresh = false;
                else if (grid[i][j] == 2)
                    queue.offer(new int[]{i, j});
            }
        }

        if (noFresh) return 0;


        int minute = 0;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int s = 0; s < size; s++)
            {
                int[] pt = queue.poll();
                for (int k = 0; k < 4; k++)
                {
                    int x = pt[0] + dx[k];
                    int y = pt[1] + dy[k];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1)
                    {
                        queue.offer(new int[]{x, y});
                        grid[x][y] = 2;
                    }
                }
            }
            minute++;
        }
        // noFresh = true;
        for (int[] ints : grid)
        {
            for (int j = 0; j < n; j++)
            {
                if (ints[j] == 1)
                {
                    // noFresh = false;
                    // break;
                    return -1;
                }
            }
        }
        // return noFresh ? minute - 1 : -1;
        return minute - 1;
    }


    public int orangesRotting_official(int[][] grid)
    {
        int R = grid.length, C = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> depth = new HashMap<>();
        for (int r = 0; r < R; ++r)
        {
            for (int c = 0; c < C; ++c)
            {
                if (grid[r][c] == 2)
                {
                    int code = r * C + c;
                    queue.add(code);
                    depth.put(code, 0);
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty())
        {
            int code = queue.remove();
            int r = code / C, c = code % C;
            for (int k = 0; k < 4; ++k)
            {
                int nr = r + dx[k];
                int nc = c + dy[k];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1)
                {
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }
        for (int[] row : grid)
        {
            for (int v : row)
            {
                if (v == 1)
                {
                    return -1;
                }
            }
        }
        return ans;
    }
}
