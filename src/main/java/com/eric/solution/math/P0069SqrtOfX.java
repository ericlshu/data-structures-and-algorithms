package com.eric.solution.math;

/**
 * Description : x 的平方根
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * <p>
 * 示例 1：
 * 输入：x = 4
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 提示：
 * 0 <= x <= 231 - 1
 *
 * @author Eric L SHU
 * @date 2022-09-15 20:39
 * @since jdk-11.0.14
 */
public class P0069SqrtOfX
{
    public int mySqrt1(int x)
    {
        int left = 0, right = x;
        int mid;
        long square;
        while (left <= right)
        {
            mid = (left + right) >>> 1;
            square = (long) mid * mid;
            if (square == x)
                return mid;
            else if (square < x)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return right;
    }

    public int mySqrt2(int x)
    {
        int l = 0, r = x, ans = -1;
        while (l <= r)
        {
            // int mid = l + (r - l) / 2;
            // if ((long) mid * mid <= x)
            int mid = (l + r) >>> 1;
            if (mid <= x / mid)
            {
                ans = mid;
                l = mid + 1;
            }
            else
            {
                r = mid - 1;
            }
        }
        return ans;
    }

    public int mySqrtMath(int x)
    {
        if (x == 0) return 0;
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

    public int mySqrtNewton(int x)
    {
        if (x == 0) return 0;
        double x0 = x;
        while (true)
        {
            double xi = 0.5 * (x0 + (double) x / x0);
            if (Math.abs(x0 - xi) < 1e-7)
            {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }
}
