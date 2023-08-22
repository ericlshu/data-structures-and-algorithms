package com.eric.solution.string;

import java.util.*;

/**
 * Description : 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * <p>
 * 示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * <p>
 * 提示:
 * -> 1 <= s.length, p.length <= 3 * 104
 * -> s 和 p 仅包含小写字母
 *
 * @author Eric L SHU
 * @date 2022-10-24 21:16
 * @since jdk-11.0.14
 */
public class P0438FindAllAnagramsInAString
{
    public List<Integer> findAnagrams_baoli(String s, String p)
    {
        List<Integer> list = new ArrayList<>();
        int len = p.length();
        for (int i = 0; i <= s.length() - len; i++)
        {
            if (isAnagrams(s.substring(i, i + len), p))
            {
                list.add(i);
            }
        }
        return list;
    }

    private boolean isAnagrams(String s1, String s2)
    {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return new String(ch1).equals(new String(ch2));
    }

    public List<Integer> findAnagrams_sw(String s, String p)
    {
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int n = p.length();
        for (int i = 0; i < n; i++)
        {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        Map<Character, Integer> sw = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            sw.put(s.charAt(i), sw.getOrDefault(s.charAt(i), 0) + 1);
            if (i >= n)
            {
                char ch = s.charAt(i - n);
                if (sw.get(ch) == 1)
                    sw.remove(ch);
                else
                    sw.put(ch, sw.get(ch) - 1);
            }
            if (i >= n - 1 && map.equals(sw))
            {
                list.add(i - n + 1);
            }
        }
        return list;
    }

    public List<Integer> findAnagrams_sw1(String s, String p)
    {
        int m = s.length(), n = p.length();
        List<Integer> list = new ArrayList<>();
        if (m < n)
            return list;
        int[] sCnt = new int[26];
        int[] pCnt = new int[26];
        for (int i = 0; i < n; ++i)
        {
            ++sCnt[s.charAt(i) - 'a'];
            ++pCnt[p.charAt(i) - 'a'];
        }
        if (Arrays.equals(sCnt, pCnt))
            list.add(0);

        for (int i = 0; i < m - n; ++i)
        {
            --sCnt[s.charAt(i) - 'a'];
            ++sCnt[s.charAt(i + n) - 'a'];
            if (Arrays.equals(sCnt, pCnt))
                list.add(i + 1);
        }
        return list;
    }

    public List<Integer> findAnagrams_sw2(String s, String p)
    {
        int m = s.length(), n = p.length();
        List<Integer> list = new ArrayList<>();
        if (m < n)
            return list;
        int[] count = new int[26];
        for (int i = 0; i < n; ++i)
        {
            ++count[s.charAt(i) - 'a'];
            --count[p.charAt(i) - 'a'];
        }
        int diff = 0;
        for (int i = 0; i < 26; ++i)
        {
            if (count[i] != 0)
                ++diff;
        }
        if (diff == 0)
            list.add(0);
        for (int i = 0; i < m - n; ++i)
        {
            int idx = s.charAt(i) - 'a';
            if (count[idx] == 1)
            {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从不同变得相同
                --diff;
            }
            else if (count[idx] == 0)
            {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从相同变得不同
                ++diff;
            }
            --count[idx];

            idx = s.charAt(i + n) - 'a';
            if (count[idx] == -1)
            {  // 窗口中字母 s[i+n] 的数量与字符串 p 中的数量从不同变得相同
                --diff;
            }
            else if (count[idx] == 0)
            {  // 窗口中字母 s[i+n] 的数量与字符串 p 中的数量从相同变得不同
                ++diff;
            }
            ++count[idx];
            if (diff == 0)
                list.add(i + 1);
        }
        return list;
    }

}
