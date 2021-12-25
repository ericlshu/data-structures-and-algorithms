package solution.math;

/**
 * Description : 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * 输入: 121
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * @author Eric L SHU
 * @date 2020-10-18 16:01
 * @since JDK 1.8
 */
public class P0009PalindromeNumber
{
    public boolean isPalindrome_1(int x)
    {
        return (Integer.toString(x)).equals((new StringBuilder(String.valueOf(x))).reverse().toString());
    }

    public boolean isPalindrome_2(int x)
    {
        if (x < 0) return false;

        int div = 1;
        while (x / div >= 10) div *= 10;

        while (x > 0)
        {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    public boolean isPalindrome(int x)
    {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int y = 0;
        while (x > y)
        {
            y = y * 10 + x % 10;
            x /= 10;
        }
        return x == y || x == y / 10;
    }
}
