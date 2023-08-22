package com.eric.solution.string;

/**
 * Description : 反转字符串中的元音字母
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
 * <p>
 * 示例 1：
 * 输入：s = "hello"
 * 输出："holle"
 * <p>
 * 示例 2：
 * 输入：s = "leetcode"
 * 输出："leotcede"
 * <p>
 * 提示：
 * 1 <= s.length <= 3 * 105
 * s 由 可打印的 ASCII 字符组成
 *
 * @author Eric L SHU
 * @date 2022-10-07 1:17 PM
 * @since jdk-11.0.14
 */
public class P0345ReverseVowelsOfAString
{
    public String reverseVowels(String s)
    {
        int len = s.length(), left = 0, right = len - 1;
        char[] chars = s.toCharArray();
        while (left < right)
        {
            while (left < right && notVowel(chars[left]))
            {
                left++;
            }
            while (left < right && notVowel(chars[right]))
            {
                right--;
            }
            swap(chars, left++, right--);
        }
        return new String(chars);
    }

    public String reverseVowels_1(String s)
    {
        int l = 0, r = s.length() - 1;
        char[] c = s.toCharArray();
        while (l < r)
        {
            while (l < r && notVowel(c[l]))
                l++;
            while (l < r && notVowel(c[r]))
                r--;
            if (c[l] != c[r])
                swap(c, l, r);
            l++;
            r--;
        }
        return new String(c);
    }

    private boolean notVowel(char c)
    {
        return "aeiouAEIOU".indexOf(c) < 0;
    }

    private void swap(char[] chars, int i, int j)
    {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
