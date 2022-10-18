package solution.string;

/**
 * Description : 最长回文子串
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author Eric L SHU
 * @date 2020-10-17 13:26
 * @since JDK 1.8
 */
public class P0005LongestPalindromicSubstring
{
    public String longestPalindrome(String s)
    {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++)
        {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start)
            {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right)
    {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
        {
            left--;
            right++;
        }
        // (--right) - (++left) + 1;
        return right - left - 1;
    }

    public String longestPalindrome_dp(String s)
    {
        int len = s.length();
        if (len == 1)
            return s;
        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++)
        {
            dp[i][i] = true;
        }
        char[] arr = s.toCharArray();
        // 先枚举子串长度
        for (int n = 2; n <= len; n++)
        {
            // 枚举左边界
            for (int l = 0; l <= len - n; l++)
            {
                // 确定右边界
                int r = l + n - 1;
                if (arr[l] != arr[r])
                    dp[l][r] = false;
                else
                {
                    if (r - l <= 2)
                        dp[l][r] = true;
                    else
                        // [l+1, r-1] 比 [l, r]长度小2
                        dp[l][r] = dp[l + 1][r - 1];
                }

                // 只要 dp[l][r] == true 成立，就表示子串 s[l..r] 是回文，此时记录回文长度和起始位置
                if (dp[l][r] && r - l + 1 > maxLen)
                {
                    maxLen = r - l + 1;
                    begin = l;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
