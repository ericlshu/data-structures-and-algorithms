package com.eric.solution.string;

/**
 * Description : 解码字母到整数映射
 * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
 * 字符（'a' - 'i'）分别用（'1' - '9'）表示。
 * 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。
 * 返回映射之后形成的新字符串。
 * 题目数据保证映射始终唯一。
 * <p>
 * 示例 1：
 * 输入：s = "10#11#12"
 * 输出："jkab"
 * 解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 * <p>
 * 示例 2：
 * 输入：s = "1326#"
 * 输出："acz"
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s[i] 只包含数字（'0'-'9'）和 '#' 字符。
 * s 是映射始终存在的有效字符串。
 *
 * @author Eric L SHU
 * @date 2022-10-18 20:56
 * @since jdk-11.0.14
 */
public class P1309DecryptStringFromAlphabetToIntegerMapping
{
    public String freqAlphabets_reverse(String s)
    {
        int i = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0)
        {
            if (s.charAt(i) == '#')
            {
                sb.insert(0, (char) ('a' + Integer.parseInt(s.substring(i - 2, i)) - 1));
                i -= 3;
            }
            else
            {
                sb.insert(0, (char) (s.charAt(i) + 48));
                i--;
            }
        }
        return sb.toString();
    }

    public String freqAlphabets_forward(String s)
    {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
        {
            if (i + 2 < n && s.charAt(i + 2) == '#')
            {
                sb.append((char) ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '1') + 'a'));
                i += 2;
            }
            else
            {
                sb.append((char) (s.charAt(i) - '1' + 'a'));
            }
        }
        return sb.toString();
    }
}
