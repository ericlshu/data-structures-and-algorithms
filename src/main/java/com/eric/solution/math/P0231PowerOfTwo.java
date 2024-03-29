package com.eric.solution.math;

/**
 * Description : 2 的幂
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 * <p>
 * 示例 1：
 * 输入：n = 1
 * 输出：true
 * 解释：20 = 1
 * <p>
 * 示例 2：
 * 输入：n = 16
 * 输出：true
 * 解释：24 = 16
 * <p>
 * 示例 3：
 * 输入：n = 5
 * 输出：false
 * <p>
 * 提示：
 * -231 <= n <= 231 - 1
 * 进阶：你能够不使用循环/递归解决此问题吗？
 *
 * @author Eric L SHU
 * @date 2022-09-22 9:52 PM
 * @since jdk-11.0.14
 */
public class P0231PowerOfTwo
{
    public boolean isPowerOfTwo_1(int n)
    {
        while (n % 2 == 0)
        {
            n /= 2;
        }
        return n == 1;
    }

    public boolean isPowerOfTwo_2(int n)
    {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo_3(int n)
    {
        return n > 0 && (n & -n) == n;
    }
}
