package solution.dp;

import java.util.Arrays;

/**
 * Description : 剑指 Offer 10- I. 斐波那契数列
 * <p>
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：n = 5
 * 输出：5
 * <p>
 * 提示：
 * 0 <= n <= 100
 *
 * @author Eric L SHU
 * @date 2022-01-02 12:15
 * @since JDK 1.8
 */
public class Offer101FibonacciSequence {
    static int mod = 1000000007;

    /**
     * 递归
     */
    public int fibonacci(int n)
    {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return (fibonacci(n - 1) + fibonacci(n - 2)) % 1000000007;
    }

    /**
     * 动态规划1
     */
    public int fib1(int n)
    {
        if (n < 2)
            return n;
        int x, y = 0, z = 1;
        for (int i = 2; i <= n; i++)
        {
            x = y;
            y = z;
            z = (x + y) % mod;
            System.out.println("i = " + i + ", z = " + z);
        }
        return z;
    }

    /**
     * 动态规划2
     */
    public int fib2(int n)
    {
        int[] dp = new int[]{0, 1, 1};
        for (int i = 0; i < n; i++)
        {
            dp[2] = (dp[0] + dp[1]) % mod;
            dp[0] = dp[1];
            dp[1] = dp[2];
            System.out.println("i = " + i + ", fib(n) = " + dp[0]);
        }
        return dp[0];
    }

    /**
     * 矩阵幂
     */
    public int fib3(int n)
    {
        if (n < 2)
            return n;
        int[][] result = new int[][]{
                {1, 1},
                {1, 0}
        };
        for (int i = 2; i < n; i++)
        {
            int[][] temp = new int[2][2];
            temp[0][0] = (result[0][0] + result[0][1]) % mod;
            temp[0][1] = (result[0][0]) % mod;
            temp[1][0] = (result[1][0] + result[1][1]) % mod;
            temp[1][1] = (result[1][0]) % mod;
            result = temp;
            System.out.println("result = " + Arrays.deepToString(result));
        }
        return result[0][0];
    }

    /**
     * 矩阵快速幂
     */

    public int fib4(int n)
    {
        if (n < 2)
            return n;
        long[][] param = new long[][]{{1, 1}, {1, 0}};
        long[][] result = new long[][]{{1}, {0}};
        int x = n - 1;
        while (x > 0)
        {
            // if (x % 2 == 1)
            if ((x & 1) == 1)
                result = matrixMultiplication(param, result);
            param = matrixMultiplication(param, param);
            // x = x / 2;
            x >>= 1;

        }
        return (int) (result[0][0] % mod);
    }


    /**
     * Matrix multiplication
     * 1、当矩阵A的列数（column）等于矩阵B的行数（row）时，A与B可以相乘。
     * 2、矩阵C的行数等于矩阵A的行数，C的列数等于B的列数。
     * 3、乘积C的第m行第n列的元素等于矩阵A的第m行的元素与矩阵B的第n列对应元素乘积之和。
     */
    long[][] matrixMultiplication(long[][] a, long[][] b)
    {
        int row = a.length, column = b[0].length, columnRow = b.length;
        long[][] result = new long[row][column];
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                for (int k = 0; k < columnRow; k++)
                {
                    result[i][j] += a[i][k] * b[k][j];
                    result[i][j] %= mod;
                }
            }
        }
        return result;
    }
}
