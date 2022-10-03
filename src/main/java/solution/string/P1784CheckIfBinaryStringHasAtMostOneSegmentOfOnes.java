package solution.string;

/**
 * Description : 检查二进制字符串字段
 * 给你一个二进制字符串 s ，该字符串 不含前导零 。
 * 如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，返回 true 。否则，返回 false 。
 * 如果 s 中 由连续若干个 '1' 组成的字段 数量不超过 1，返回 true 。否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：s = "1001"
 * 输出：false
 * 解释：由连续若干个 '1' 组成的字段数量为 2，返回 false
 * <p>
 * 示例 2：
 * 输入：s = "110"
 * 输出：true
 * <p>
 * 提示：
 * 1 <= s.length <= 100
 * s[i] 为 '0' 或 '1'
 * s[0] 为 '1'
 * <p>
 * 首先我们依次分析这两种情况：
 * 字符串 s 中包含零个由连续 1 组成的字段，那么整个串的表示为 000000⋯00。
 * 字符串 s 中只包含一个由连续 1 组成的字段，因为已知字符串 s 不包含前导零，所以整个串的表示为 1⋯100⋯00。
 *
 * @author Eric L SHU
 * @date 2022-10-03 17:27
 * @since jdk-11.0.14
 */
public class P1784CheckIfBinaryStringHasAtMostOneSegmentOfOnes
{
    public boolean checkOnesSegment_api(String s)
    {
        return !s.contains("01");
    }

    public boolean checkOnesSegment(String s)
    {
        int n = s.length(), cnt = 0, idx = 1;
        while (idx < n && cnt <= 1)
        {
            while (idx < n && s.charAt(idx) == '1')
            {
                idx++;
            }
            cnt++;
            while (idx < n && s.charAt(idx) == '0')
            {
                idx++;
            }
        }
        return cnt <= 1;
    }
}
