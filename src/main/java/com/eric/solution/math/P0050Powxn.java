package com.eric.solution.math;

/**
 * <p>Copyright (c) 2024 Authors. All rights reserved.
 *
 * <p>Project: data-structures-and-algorithms
 * <p>Created By : Eric L SHU
 * <p>Created On : 2024-02-29 14:18:11
 * <p>
 * Description : Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 * <p>
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * <p>
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * <p>
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * 提示：
 * -> -100.0 < x < 100.0
 * -> -2^31 <= n <= 2^31-1
 * -> n 是一个整数
 * -> 要么 x 不为零，要么 n > 0 。
 * -> -10^4 <= x^n <= 10^4
 *
 * @version 1.0
 * @since jdk-17
 */
public class P0050Powxn
{
    public static double myPowRecursion(double x, int n)
    {
        long p = n;
        if (n < 0)
            p = -p;
        double res = quickMulRec(x, p);
        return n < 0 ? 1 / res : res;
    }

    private static double quickMulRec(double x, long n)
    {
        if (n == 0) return 1.0;
        if (n == 1) return x;

        double y = quickMulRec(x, n / 2);
        if ((n & 1) == 0)
            return y * y;
        else
            return x * y * y;
    }

    public static double myPowIteration(double x, int n)
    {
        return (long) n > 0 ? quickMulItr(x, n) : 1.0 / quickMulItr(x, -(long) n);
    }

    private static double quickMulItr(double x, long n)
    {
        double res = 1.0;
        // 贡献的初始值为 x
        double _x = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (n > 0)
        {
            if ((n & 1) == 1)
            {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                res *= _x;
            }
            // 将贡献不断地平方
            _x *= _x;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            n /= 2;
        }
        return res;
    }
}
