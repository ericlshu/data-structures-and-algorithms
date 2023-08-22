package com.eric.solution.array;

/**
 * Description : 排列硬币
 * <p>
 * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 * <p>
 * 示例 1：
 * 输入：n = 5
 * 输出：2
 * 解释：因为第三行不完整，所以返回 2 。
 * <p>
 * 示例 2：
 * 输入：n = 8
 * 输出：3
 * 解释：因为第四行不完整，所以返回 3 。
 * <p>
 * 提示：
 * 1 <= n <= 231 - 1
 *
 * @author Eric L SHU
 * @date 2022-01-20 22:06
 * @since JDK 1.8
 */
public class P0441ArrangingCoins
{

    public int arrangeCoins1(int n)
    {
        int lineNum = 1;
        while (n >= lineNum)
        {
            n -= lineNum;
            lineNum++;
        }
        return lineNum - 1;
    }

    public int arrangeCoins2(int n)
    {
        return (int) ((Math.sqrt((long) 8 * n + 1) - 1) / 2);
    }

    public int arrangeCoins(int n)
    {
        int left = 1, right = n;
        while (left < right)
        {
            int mid = (right + left + 1) >>> 1;
            if ((long) mid * (mid + 1) <= (long) 2 * n)
                left = mid;
            else
                right = mid - 1;
        }
        return left;
    }
}
