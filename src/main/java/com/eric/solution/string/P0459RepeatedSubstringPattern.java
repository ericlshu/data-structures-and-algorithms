package com.eric.solution.string;

/**
 * Description : 重复的子字符串
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * <p>
 * 示例 1:
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * <p>
 * 示例 2:
 * 输入: s = "aba"
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 * <p>
 * 提示：
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 *
 * @author Eric L SHU
 * @date 2022-12-02 10:06
 * @since jdk-11.0.14
 */
public class P0459RepeatedSubstringPattern
{
    public boolean repeatedSubstringPattern_n2(String s)
    {
        int n = s.length();
        for (int i = 1; i * 2 <= n; ++i)
        {
            if (n % i == 0)
            {
                boolean matched = true;
                for (int j = i; j < n; ++j)
                {
                    if (s.charAt(j) != s.charAt(j - i))
                    {
                        matched = false;
                        break;
                    }
                }
                if (matched)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean repeatedSubstringPattern_api(String s)
    {
        // String str = s + s;
        // return str.substring(1, str.length() - 1).contains(s);
        return (s + s).indexOf(s, 1) != s.length();
    }

    // 18392037572
}
