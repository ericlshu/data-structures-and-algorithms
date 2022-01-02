package solution.math;

/**
 * Description : 斐波那契数
 * <p>
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 * <p>
 * 示例 1：
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * <p>
 * 示例 2：
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * <p>
 * 示例 3：
 * <p>
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * <p>
 * 提示：
 * 0 <= n <= 30
 *
 * @author Eric L SHU
 * @date 2022-01-02 17:26
 * @since JDK 1.8
 */
public class P0509FibonacciNumber {
    public int fib(int n)
    {
        int[] dp = new int[]{0, 1, 1};
        for (int i = 0; i < n; i++)
        {
            dp[2] = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[0];
    }

    public int fibonacci(int n)
    {
        if (n < 2)
            return n;
        int[][] param = {{1, 1}, {1, 0}};
        int[][] result = {{1}, {0}};
        int x = n - 1;
        while (x > 0)
        {
            if ((x & 1) == 1)
            {
                result = matrixMulti(param, result);
            }
            param = matrixMulti(param, param);
            x >>= 1;
        }
        return result[0][0];
    }


    private int[][] matrixMulti(int[][] a, int[][] b)
    {
        int row = a.length, rowColumn = a[0].length, column = b[0].length;
        int[][] result = new int[row][column];
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                for (int k = 0; k < rowColumn; k++)
                {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

}
