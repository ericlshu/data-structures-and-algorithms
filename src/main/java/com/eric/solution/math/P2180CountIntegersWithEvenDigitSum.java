package com.eric.solution.math;

/**
 * Description : 统计各位数字之和为偶数的整数个数
 * 给你一个正整数 num ，请你统计并返回 小于或等于 num 且各位数字之和为 偶数 的正整数的数目。
 * 正整数的 各位数字之和 是其所有位上的对应数字相加的结果。
 * <p>
 * 示例 1：
 * 输入：num = 4
 * 输出：2
 * 解释：
 * 只有 2 和 4 满足小于等于 4 且各位数字之和为偶数。
 * <p>
 * 示例 2：
 * 输入：num = 30
 * 输出：14
 * 解释：
 * 只有 14 个整数满足小于等于 30 且各位数字之和为偶数，分别是：
 * 2、4、6、8、11、13、15、17、19、20、22、24、26 和 28 。
 * <p>
 * 提示：
 * -> 1 <= num <= 1000
 *
 * @author Eric L SHU
 * @date 2023-01-07 20:55
 * @since jdk-11.0.14
 */
public class P2180CountIntegersWithEvenDigitSum
{
    public int countEven_1(int num)
    {
        int res = 0, x, sum;
        for (int i = 1; i <= num; i++)
        {
            x = i;
            sum = 0;
            while (x != 0)
            {
                sum += x % 10;
                x /= 10;
            }
            if (sum % 2 == 0)
            {
                res++;
            }
        }
        return res;
    }

    public int countEven_2(int num)
    {
        if (check(num))
            return num / 2;
        return (num - 1) / 2;

    }

    private boolean check(int num)
    {
        int sum = 0;
        while (num > 0)
        {
            sum += num % 10;
            num /= 10;
        }
        return sum % 2 == 0;
    }
}
