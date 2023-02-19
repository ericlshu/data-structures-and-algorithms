package solution.array;

/**
 * Description : 最大的以 1 为边界的正方形
 * 给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。
 * <p>
 * 示例 1：
 * 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：9
 * <p>
 * 示例 2：
 * 输入：grid = [[1,1,0,0]]
 * 输出：1
 * <p>
 * 提示：
 * -> 1 <= grid.length <= 100
 * -> 1 <= grid[0].length <= 100
 * -> grid[i][j] 为 0 或 1
 *
 * @author Eric L SHU
 * @date 2023-02-18 19:27
 * @since jdk-11.0.14
 */
public class P1139Largest1BorderedSquare
{
    public int largest1BorderedSquare_1(int[][] grid)
    {
        int m = grid.length, n = grid[0].length;
        int[][] left = new int[m + 1][n + 1];
        int[][] up = new int[m + 1][n + 1];
        int maxBorder = 0, border;
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (grid[i - 1][j - 1] == 1)
                {
                    left[i][j] = left[i][j - 1] + 1;
                    up[i][j] = up[i - 1][j] + 1;
                    border = Math.min(left[i][j], up[i][j]);
                    while (left[i - border + 1][j] < border || up[i][j - border + 1] < border)
                    {
                        border--;
                    }
                    maxBorder = Math.max(maxBorder, border);
                }
            }
        }
        return maxBorder * maxBorder;
    }

    public int largest1BorderedSquare_2(int[][] grid)
    {
        int m = grid.length, n = grid[0].length;
        // dp[i][j][0]: (i,j)横向连续1的个数
        // dp[i][j][1]: (i,j)竖向连续1的个数
        int[][][] dp = new int[m + 1][n + 1][2];

        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (grid[i - 1][j - 1] == 0)
                    continue;
                // 如果是1，我们就计算横向和竖向连续1的个数
                dp[i][j][0] = dp[i][j - 1][0] + 1;
                dp[i][j][1] = dp[i - 1][j][1] + 1;
            }
        }
        int max = 0;
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                // curr可以认为是正方形下边和右边的长度
                // 我们还需要根据正方形上边和左边的长度来确认是否满足正方形的条件
                int curr = Math.min(dp[i][j][0], dp[i][j][1]);
                while (curr > max)
                {
                    // 如果正方形的左边和上边的长度不大于curr，我们就缩小正方形的长度curr，然后继续判断
                    if (dp[i - curr + 1][j][0] >= curr && dp[i][j - curr + 1][1] >= curr)
                    {
                        max = curr;
                        // 更短的就没必要考虑了，这里直接中断
                        break;
                    }
                    curr--;
                }
            }
        }
        // 返回正方形的边长
        return max * max;
    }
}
