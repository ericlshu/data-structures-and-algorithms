package com.eric.solution.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description : 省份数量
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * 返回矩阵中 省份 的数量。
 * <p>
 * 示例 1：
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 * <p>
 * 提示：
 * -> 1 <= n <= 200
 * -> n == isConnected.length
 * -> n == isConnected[i].length
 * -> isConnected[i][j] 为 1 或 0
 * -> isConnected[i][i] == 1
 * -> isConnected[i][j] == isConnected[j][i]
 *
 * @author Eric L SHU
 * @date 2023-01-08 14:17
 * @since jdk-11.0.14
 */
public class P0547NumberOfProvinces
{
    public int findCircleNum_dfs(int[][] isConnected)
    {
        int n = isConnected.length, cnt = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++)
        {
            if (!visited[i])
            {
                dfs(isConnected, visited, n, i);
                cnt++;
            }
        }
        return cnt;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int n, int i)
    {
        for (int j = 0; j < n; j++)
        {
            if (isConnected[i][j] == 1 && !visited[j])
            {
                visited[j] = true;
                dfs(isConnected, visited, n, j);
            }
        }
    }

    public int findCircleNum_bfs(int[][] isConnected)
    {
        int n = isConnected.length, cnt = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++)
        {
            if (!visited[i])
            {
                queue.offer(i);
                while (!queue.isEmpty())
                {
                    int j = queue.poll();
                    visited[j] = true;
                    for (int k = 0; k < n; k++)
                    {
                        if (isConnected[j][k] == 1 && !visited[k])
                        {
                            queue.offer(k);
                        }
                    }
                }
                cnt++;
            }
        }
        return cnt;
    }
}
