package solution.array;

/**
 * Description : 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 * <p>
 * 示例 1：
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * <p>
 * 示例 2：
 * 输入：c = 3
 * 输出：false
 * <p>
 * 提示：
 * 0 <= c <= 2^31 - 1
 *
 * @author Eric L SHU
 * @date 2022-09-21 8:22 PM
 * @since jdk-11.0.14
 */
public class P0633SumOfSquareNumbers
{
    public boolean judgeSquareSum_sqrt(int c)
    {
        for (long a = 0; a <= Math.sqrt(c); a++)
        {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b)
            {
                return true;
            }
        }
        return false;
    }

    public boolean judgeSquareSum(int c)
    {
        long left = 0;
        long right = (long) Math.sqrt(c);
        while (left <= right)
        {
            long sum = left * left + right * right;
            if (sum == c)
                return true;
            else if (sum > c)
                right--;
            else
                left++;
        }
        return false;
    }

    /**
     * 费马平方和定理 : 一个非负整数 c 如果能够表示为两个整数的平方和，当且仅当 c 的所有形如 4k+3 的质因子的幂均为偶数。
     */
    public boolean judgeSquareSum_math(int c)
    {
        for (int base = 2; base * base <= c; base++)
        {
            // 如果不是因子，枚举下一个
            if (c % base != 0)
            {
                continue;
            }
            // 计算 base 的幂
            int exp = 0;
            while (c % base == 0)
            {
                c /= base;
                exp++;
            }
            // 根据 Sum of two squares theorem 验证
            if (base % 4 == 3 && exp % 2 != 0)
            {
                return false;
            }
        }
        // 例如 11 这样的用例，由于上面的 for 循环里 base * base <= c ，base == 11 的时候不会进入循环体
        // 因此在退出循环以后需要再做一次判断
        return c % 4 != 3;
    }
}
