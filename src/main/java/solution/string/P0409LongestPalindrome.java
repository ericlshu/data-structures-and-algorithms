package solution.string;

/**
 * Description : 最长回文串
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 示例 1:
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * <p>
 * 示例 2:
 * 输入:s = "a"
 * 输入:1
 * <p>
 * 提示:
 * 1 <= s.length <= 2000
 * s 只由小写 和/或 大写英文字母组成
 *
 * @author Eric L SHU
 * @date 2022-10-15 19:30
 * @since jdk-11.0.14
 */
public class P0409LongestPalindrome
{
    public int longestPalindrome(String s)
    {
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i)
        {
            count[s.charAt(i)]++;
        }

        int ans = 0;
        for (int freq : count)
        {
            ans += freq / 2 * 2;
            // if (freq % 2 == 1 && ans % 2 == 0)
            // {
            //     ans++;
            // }
        }
        if (ans < s.length()) ans++;
        return ans;
    }
}
