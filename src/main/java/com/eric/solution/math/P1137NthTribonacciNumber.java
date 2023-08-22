package com.eric.solution.math;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

/**
 * Description : 第 N 个泰波那契数
 * <p>
 * 泰波那契序列 Tn 定义如下：
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * <p>
 * 示例 1：
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * <p>
 * 示例 2：
 * 输入：n = 25
 * 输出：1389537
 * <p>
 * 提示：
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
 *
 * @author Eric L SHU
 * @date 2022-01-02 17:53
 * @since JDK 1.8
 */
public class P1137NthTribonacciNumber {

    public int tribonacci_1(int n)
    {
        int[] dp = {0, 1, 1, 2};
        for (int i = 0; i < n; i++)
        {
            dp[3] = dp[2] + dp[1] + dp[0];
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = dp[3];
        }
        return dp[0];
    }

    public int tribonacci_2(int n)
    {
        if (n < 2) return n;
        if (n == 2) return 1;
        int[][] param = {{1, 1, 1}, {1, 0, 0}, {0, 1, 0}};
        int[][] result = {{1}, {1}, {0}};
        int x = n - 2;
        while (x > 0)
        {
            if ((x & 1) == 1)
                result = matrixMultiple(param, result);
            param = matrixMultiple(param, param);
            x >>= 1;
        }
        return result[0][0];
    }

    private int[][] matrixMultiple(int[][] a, int[][] b)
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

    public int tribonacci_3(int n)
    {
        if (n < 2) return n;
        if (n == 2) return 1;
        double[][] param = {{1, 1, 1}, {1, 0, 0}, {0, 1, 0}};
        double[][] result = {{1}, {1}, {0}};
        RealMatrix paramMatrix = new Array2DRowRealMatrix(param);
        RealMatrix resultMatrix = new Array2DRowRealMatrix(result);
        int x = n - 2;
        while (x > 0)
        {
            if ((x & 1) == 1)
                resultMatrix = paramMatrix.multiply(resultMatrix);
            paramMatrix = paramMatrix.multiply(paramMatrix);
            x >>= 1;
        }
        double[][] data = resultMatrix.getData();
        return (int) data[0][0];
    }
}
