package solution.array;

/**
 * Description : 在区间范围内统计奇数数目
 * 给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。
 * <p>
 * 示例 1：
 * 输入：low = 3, high = 7
 * 输出：3
 * 解释：3 到 7 之间奇数数字为 [3,5,7] 。
 * <p>
 * 示例 2：
 * 输入：low = 8, high = 10
 * 输出：1
 * 解释：8 到 10 之间奇数数字为 [9] 。
 * <p>
 * 提示：
 * 0 <= low <= high <= 10^9
 *
 * @author Eric L SHU
 * @date 2022-10-10 12:35
 * @since jdk-11.0.14
 */
public class P1523CountOddNumbersInAnIntervalRange
{
    public int countOdds_1(int low, int high)
    {
        int ret = (high - low) / 2;
        return (low % 2 == 0 && high % 2 == 0) ? ret : ret + 1;
    }

    public int countOdds_2(int low, int high)
    {
        return pre(high) - pre(low - 1);
    }

    private int pre(int x)
    {
        return (x + 1) >> 1;
    }
}
