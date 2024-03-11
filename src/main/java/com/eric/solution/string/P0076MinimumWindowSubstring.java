package com.eric.solution.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>Copyright (c) 2024 Authors. All rights reserved.
 *
 * <p>Project: data-structures-and-algorithms
 * <p>Created By : Eric L SHU
 * <p>Created On : 2024-03-11 20:34:31
 * <p>
 * Description : 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * <p>
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * <p>
 * 示例 3:
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * <p>
 * 提示：
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s 和 t 由英文字母组成
 * <p>
 * 进阶：你能设计一个在 o(m+n) 时间内解决此问题的算法吗？
 *
 * @version 1.0
 * @since jdk-17
 */
public class P0076MinimumWindowSubstring
{
    public static String minWindow(String s, String t)
    {
        String res = "";

        Map<Character, Integer> tFreq = new HashMap<>();
        Map<Character, Integer> sFreq = new HashMap<>();
        char[] target = t.toCharArray();
        char[] source = s.toCharArray();
        for (char ch : target)
        {
            tFreq.put(ch, tFreq.getOrDefault(ch, 0) + 1);
        }

        int i = 0, j = 0,passed = 0;
        while (j < source.length)
        {
            char right = source[j];
            sFreq.put(right, sFreq.getOrDefault(right, 0) + 1);
            if (Objects.equals(sFreq.get(right), tFreq.get(right)))
            {
                passed++;
            }
            while (passed == tFreq.size() && i <= j)
            {
                if (res.isEmpty() || j - i + 1 < res.length())
                {
                    res = s.substring(i, j + 1);
                }
                char left = source[i];
                sFreq.put(left, sFreq.get(left) - 1);
                if (sFreq.get(left) < tFreq.getOrDefault(left, 0))
                {
                    passed--;
                }
                i++;
            }
            j++;
        }
        return res;
    }
}
