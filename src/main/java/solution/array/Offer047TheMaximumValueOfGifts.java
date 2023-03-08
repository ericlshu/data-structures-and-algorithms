package solution.array;

/**
 * Description : 剑指 Offer 47. 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * 示例 1:
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * <p>
 * 提示：
 * -> 0 < grid.length <= 200
 * -> 0 < grid[0].length <= 200
 *
 * @author Eric L SHU
 * @date 2023-03-08 20:36
 * @since jdk-11.0.14
 */
public class Offer047TheMaximumValueOfGifts
{
    public int maxValue_1(int[][] grid)
    {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++)
        {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++)
        {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                dp[i][j] = grid[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        // System.out.println("dp = " + Arrays.deepToString(dp));
        // for (int i = 0; i < m; i++)
        // {
        //     for (int j = 0; j < n; j++)
        //     {
        //         if (i > 0)
        //             dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
        //         if (j > 0)
        //             dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
        //         dp[i][j] += grid[i][j];
        //     }
        // }
        return dp[m - 1][n - 1];
    }

    public int maxValue_2(int[][] grid)
    {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[2][n];
        for (int i = 0; i < m; i++)
        {
            int idx = i % 2;
            for (int j = 0; j < n; j++)
            {
                dp[idx][j] = 0;
                if (i > 0)
                    dp[idx][j] = Math.max(dp[idx][j], dp[1 - idx][j]);
                if (j > 0)
                    dp[idx][j] = Math.max(dp[idx][j], dp[idx][j - 1]);
                dp[idx][j] += grid[i][j];
            }
        }
        return dp[(m - 1) % 2][n - 1];
    }

    public int maxValue_3(int[][] grid)
    {
        int n = grid[0].length;
        int[] dp = new int[n];
        for (int[] row : grid)
        {
            dp[0] += row[0];
            for (int j = 1; j < n; j++)
            {
                dp[j] = Math.max(dp[j - 1], dp[j]) + row[j];
            }
        }
        return dp[n - 1];
    }
}
