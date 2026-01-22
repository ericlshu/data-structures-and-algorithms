package com.shl;

import java.util.Scanner;

/**
 * Description :
 * 一个州有多个城市集群，这些城市通过道路网络相连。这些道路是双向的（即交通可以双向流动）。不同集群之间没有连接。
 * 在一个集群内，假设两座城市之间最多有一条路相连。
 * 编写一个算法来确定城市和道路网络中内部相连城市的集群总数。
 * <p>
 * 输入格式
 * 输入的第一行包含两个整数：matInput_row 和 matInput_col，分别表示州中的城市数量 N 和每个城市的连接数 M。
 * 接下来的 N 行包含 M 个空格分隔的整数，表示矩阵。矩阵中的第 i 行、第 j 列的值为：
 * 1：表示城市 i 与城市 j 之间有一条道路。
 * 0：表示城市 i 与城市 j 之间没有道路。
 * <p>
 * 输出格式
 * 输出一个整数，表示网络中连接的城市集群的总数。
 * <p>
 * 约束条件
 * 矩阵中的元素只能是 0 和 1。
 * <p>
 * 示例
 * 输入：
 * 5 5
 * 0 0 0 0 0
 * 0 0 1 0 0
 * 0 1 0 1 0
 * 0 0 1 0 0
 * 0 0 0 0 0
 * <p>
 * 输出：
 * 3
 * <p>
 * 解释：
 * 共有 5 座城市。
 * 城市之间的连接由 1 表示，共有 3 个独立的集群。
 *
 * @author Eric L SHU
 * @date 2026-01-13 18:55
 */
public class AStateHasANumberOfCityClusters
{
    private static void dfs(int[][] matrix, boolean[] visited, int city)
    {
        visited[city] = true; // 标记当前城市为已访问
        for (int neighbor = 0; neighbor < matrix[city].length; neighbor++)
        {
            if (matrix[city][neighbor] == 1 && !visited[neighbor])
            {
                dfs(matrix, visited, neighbor); // 递归访问邻居城市
            }
        }
    }

    // 计算城市集群的数量
    public static int conClusters(int[][] matInput)
    {
        int n = matInput.length; // 城市的数量
        boolean[] visited = new boolean[n]; // 标记每个城市是否已访问
        int clusterCount = 0;

        for (int city = 0; city < n; city++)
        {
            if (!visited[city])
            {
                dfs(matInput, visited, city); // 对未访问的城市启动 DFS
                clusterCount++; // 每次启动新的 DFS，表示发现一个新的集群
            }
        }
        return clusterCount;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        // 输入行数和列数
        int matInput_row = in.nextInt();
        int matInput_col = in.nextInt();

        // 读取矩阵输入
        int[][] matInput = new int[matInput_row][matInput_col];
        for (int idx = 0; idx < matInput_row; idx++)
        {
            for (int jdx = 0; jdx < matInput_col; jdx++)
            {
                matInput[idx][jdx] = in.nextInt();
            }
        }

        // 计算并输出结果
        int result = conClusters(matInput);
        System.out.print(result);
    }
}
