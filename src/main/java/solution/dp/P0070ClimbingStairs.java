package solution.dp;

/**
 * Description : 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * <p>
 * 示例 2：
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * <p>
 * 提示：
 * 1 <= n <= 45
 *
 * @author Eric L SHU
 * @date 2022-09-24 10:17
 * @since jdk-11.0.14
 */
public class P0070ClimbingStairs
{
    /**
     * 递归
     */
    public int climbStairs_1(int n)
    {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return climbStairs_1(n - 1) + climbStairs_1(n - 2);
    }

    /**
     * 记忆化递归
     */
    public int climbStairs_2(int n)
    {
        int[] memo = new int[n + 1];
        return climbStairsMemo(n, memo);
    }

    private int climbStairsMemo(int n, int[] memo)
    {
        if (memo[n] > 0)
            return memo[n];
        if (n <= 2)
            memo[n] = n;
        else
            memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
        return memo[n];
    }

    /**
     * 动态规划
     */
    public int climbStairs_3(int n)
    {
        if (n <= 2)
            return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++)
        {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 动态规划优化
     */
    public int climbStairs_4(int n)
    {
        int p, q = 0, r = 1;
        for (int i = 0; i < n; i++)
        {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public int climbStairs_7(int n)
    {
        int first, second = 1, third = 1;
        for (int i = 1; i < n; i++)
        {
            first = second;
            second = third;
            third = first + second;
        }
        return third;
    }

    /**
     * 矩阵快速幂
     */
    public int climbStairs_5(int n)
    {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n)
    {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0)
        {
            if ((n & 1) == 1)
                ret = multiply(ret, a);
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] multiply(int[][] a, int[][] b)
    {
        int[][] ret = new int[2][2];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                ret[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
        return ret;
    }

    public int[][] matrix(int[][] a, int[][] b)
    {
        int row = a.length;
        int colRow = a[0].length;
        int col = b[0].length;
        int[][] result = new int[row][col];

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                for (int k = 0; k < colRow; k++)
                {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    /**
     * 通项公式
     */
    public int climbStairs_6(int n)
    {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) Math.round(fibn / sqrt5);
    }
}
