package com.eric.solution.string;

/**
 * Description : 反转字符串中的单词 III
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1：
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * <p>
 * 示例 2:
 * 输入： s = "God Ding"
 * 输出："doG gniD"
 * <p>
 * 提示：
 * 1 <= s.length <= 5 * 104
 * s 包含可打印的 ASCII 字符。
 * s 不包含任何开头或结尾空格。
 * s 里 至少 有一个词。
 * s 中的所有单词都用一个空格隔开。
 *
 * @author Eric L SHU
 * @date 2022-09-13 20:50
 * @since jdk-11.0.14
 */
public class P0557ReverseWordsInAStringIII
{
    public String reverseWords_1(String s)
    {
        String[] strings = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String value : strings)
        {
            builder.append(reverse(value)).append(" ");
        }
        return builder.substring(0, s.length());
    }

    private String reverse(String s)
    {
        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;
        char temp;
        while (left < right)
        {
            temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
        return String.valueOf(chars);
    }

    public String reverseWords_2(String s)
    {
        char[] chars = s.toCharArray();
        int i = 0, n = chars.length;
        while (i < n)
        {
            int left = i;
            while (i < n && chars[i] != ' ')
            {
                i++;
            }
            int right = i - 1;
            while (left < right)
            {
                char temp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = temp;
            }
            i++;
        }
        return String.valueOf(chars);
    }
}
