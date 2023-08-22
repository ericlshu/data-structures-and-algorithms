package com.eric.solution.string;

/**
 * Description : 找出字符串中第一个匹配项的下标
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 * <p>
 * 示例 1：
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * <p>
 * 示例 2：
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 * <p>
 * 提示：
 * -> 1 <= haystack.length, needle.length <= 104
 * -> haystack 和 needle 仅由小写英文字符组成
 *
 * @author Eric L SHU
 * @date 2020-10-22 20:08
 * @since JDK 1.8
 */
public class P0028ImplementStrStr
{
    public int strStr_1(String haystack, String needle)
    {
        if (needle.length() > haystack.length())
            return -1;
        int idx = -1;
        for (int i = 0; i < haystack.length(); i++)
        {
            if (haystack.charAt(i) == needle.charAt(0))
            {
                idx = i++;
                int j = 1;
                while (j < needle.length())
                {
                    if (i == haystack.length())
                    {
                        return -1;
                    }
                    else if (haystack.charAt(i) == needle.charAt(j))
                    {
                        i++;
                        j++;
                    }
                    else
                    {
                        i = idx;
                        idx = -1;
                        break;
                    }
                }
            }
            if (idx != -1) return idx;
        }
        return idx;
    }

    public int strStr_2(String haystack, String needle)
    {
        int h = haystack.length(), n = needle.length();
        for (int i = 0; i <= h - n; i++)
        {
            boolean matched = true;
            for (int j = 0; j < n; j++)
            {
                if (haystack.charAt(i + j) != needle.charAt(j))
                {
                    matched = false;
                    break;
                }
            }
            if (matched)
            {
                return i;
            }
        }
        return -1;
    }

    public int strStr_kmp(String haystack, String needle)
    {
        int h = haystack.length(), n = needle.length();
        int[] pi = new int[n];
        for (int i = 1, j = 0; i < n; i++)
        {
            while (j > 0 && needle.charAt(i) != needle.charAt(j))
            {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j))
            {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < h; i++)
        {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j))
            {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j))
            {
                j++;
            }
            if (j == n)
            {
                return i - n + 1;
            }
        }
        return -1;
    }
}
