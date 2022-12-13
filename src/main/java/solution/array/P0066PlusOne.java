package solution.array;

/**
 * Description : 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * <p>
 * 示例 2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * <p>
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 * <p>
 * 提示：
 * <p>
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * <p>
 * Related Topics
 * 数组
 * 数学
 *
 * @author Eric L SHU
 * @date 2022-01-24 21:04
 * @since JDK 1.8
 */
public class P0066PlusOne
{
    public int[] plusOne_1(int[] digits)
    {
        for (int i = digits.length - 1; i >= 0; i--)
        {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public int[] plusOne_2(int[] digits)
    {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--)
        {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0)
                return digits;
        }
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }

    public int[] plusOne_3(int[] digits)
    {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i)
        {
            if (digits[i] != 9)
            {
                ++digits[i];
                for (int j = i + 1; j < n; ++j)
                {
                    digits[j] = 0;
                }
                return digits;
            }
        }
        // digits 中所有的元素均为 9
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }
}
