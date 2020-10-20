package problem.java;

/**
 * Description : 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 * 示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 *
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author Eric L SHU
 * @date 2020-10-18 15:34
 * @since JDK 1.8
 */
public class P0007_ReverseInteger
{
    public int reverse(int x)
    {
        int y = 0;
        while (x != 0)
        {
            int pop = x % 10;
            if (y > Integer.MAX_VALUE / 10 || (y == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10))
            {
                return 0;
            }
            else if (y < Integer.MIN_VALUE / 10 || (y == Integer.MIN_VALUE / 10 && x < Integer.MIN_VALUE % 10))
            {
                return 0;
            }
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return y;
    }
}
