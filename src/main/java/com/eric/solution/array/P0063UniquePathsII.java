package com.eric.solution.array;

/**
 * Description : 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 示例 1：
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * <p>
 * 示例 2：
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 * <p>
 * 提示：
 * -> m == obstacleGrid.length
 * -> n == obstacleGrid[i].length
 * -> 1 <= m, n <= 100
 * -> obstacleGrid[i][j] 为 0 或 1
 *
 * @author Eric L SHU
 * @date 2022-12-15 20:41
 * @since jdk-11.0.14
 */
public class P0063UniquePathsII
{
    public int uniquePathsWithObstacles_mn(int[][] obstacleGrid)
    {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++)
        {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++)
        {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                if (obstacleGrid[i][j] == 0)
                {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 首先从第一行开始遍历,f[0]已经进行初始化,想到到达obstacleGrid[0][j]只能够从左往右走,上面没有路可以走;
     * java整型数组初始化的时候默认值是零,也就是说f[j]的默认值都是零;
     * 经过f[j] += f[j - 1] (此时i=0也就是在第一行)的第一次循环完成后第一行的所有值就已经确定了,没有障碍物就是全为1,有障碍物就是为1或0。
     * 现在f[i]数组中保存的值就是从起点出发到第一行第i个网格有多少条不同的路径。
     * 之后继续循环，当i=1也就是遍历到第二行，
     * 每一行第一个网格的值如果有障碍就将其置0，如果无障碍的话值与上一行的f[j]保持一致，不用变化;
     * 第二个网格的值计算方式为上方的网格值加上左边网格的值，左边网格值已经确定，为f[j-1]，而上方网格的值就是上一轮循环中的f[j]，
     * 两个值相加得到第二行第二个网格的值并将f[j]中的数据覆盖，依次循环将f[j]中的数据全部替换，此时f[j]中就保存了从起点出发到第二行第j个网格有多少条不同的路径。
     * 继续循环直到完成，最后的结果就是从起点到终点有多少条不同的路径。
     */
    public int uniquePathsWithObstacles_n(int[][] obstacleGrid)
    {
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int[] row : obstacleGrid)
        {
            for (int j = 0; j < n; j++)
            {
                if (row[j] == 1)
                {
                    dp[j] = 0;
                    continue;
                }
                // if (j >= 1 && row[j - 1] == 0)
                if (j >= 1)
                {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }
}
