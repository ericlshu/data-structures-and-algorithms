package com.eric.solution.math;

/**
 * Description : 有效的完全平方数
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 进阶：不要 使用任何内置的库函数，如 sqrt 。
 * <p>
 * 示例 1：
 * 输入：num = 16
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：num = 14
 * 输出：false
 * <p>
 * 提示：
 * 1 <= num <= 2^31 - 1
 *
 * @author Eric L SHU
 * @date 2022-09-14 20:36
 * @since jdk-11.0.14
 */
public class P0367ValidPerfectSquare
{
    public boolean isPerfectSquare_1(int num)
    {
        int x = (int) Math.sqrt(num);
        return x * x == num;
    }

    public boolean isPerfectSquare_2(int num)
    {
        long x = 1, square = 1;
        while (square <= num)
        {
            if (square == num)
            {
                return true;
            }
            ++x;
            square = x * x;
        }
        return false;
    }

    public boolean isPerfectSquare_3(int num)
    {
        if (num == 1) return true;
        int left = 0, right = num / 2;
        while (left <= right)
        {
            int mid = (right + left) >> 1;
            long square = (long) mid * mid;
            if (square < num)
                left = mid + 1;
            else if (square > num)
                right = mid - 1;
            else
                return true;
        }
        return false;
    }

    /**
     * 牛顿迭代
     */
    public boolean isPerfectSquare_4(int num)
    {
        double x0 = num;
        while (true)
        {
            double x1 = (x0 + num / x0) / 2;
            if (x0 - x1 < 1e-6)
            {
                break;
            }
            x0 = x1;
        }
        int x = (int) x0;
        return x * x == num;
    }
}
