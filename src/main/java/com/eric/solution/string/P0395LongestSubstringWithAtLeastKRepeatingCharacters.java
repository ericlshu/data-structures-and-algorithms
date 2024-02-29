package com.eric.solution.string;

/**
 * <p>Copyright (c) 2024 Authors. All rights reserved.
 *
 * <p>Project: data-structures-and-algorithms
 * <p>Created By : Eric L SHU
 * <p>Created On : 2024-02-29 15:48:56
 * <p>
 * Description : 至少有 K 个重复字符的最长子串
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 * 如果不存在这样的子字符串，则返回 0。
 * <p>
 * 示例 1：
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * <p>
 * 示例 2：
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 * <p>
 * 提示：
 * 1 <= s.length <= 10^4
 * s 仅由小写英文字母组成
 * 1 <= k <= 10^5
 *
 * @version 1.0
 * @since jdk-17
 */
public class P0395LongestSubstringWithAtLeastKRepeatingCharacters
{
    public int longestSubstring(String s, int k)
    {
       /*
            统计字符串中没个字符出现的次数，移除那些出现次数 < k 的字符
            剩余的子串递归做此处理直至
                - 整个子串的长度 < k（排除）
                - 子串中没有出现次数 < k 的字符
        */

        // 整个子串的长度 < k（落选）
        if (s.length() < k) return 0;

        int[] freq = new int[26];
        char[] arr = s.toCharArray();
        for (char ch : arr)
        {
            freq[ch - 'a']++;
        }

        // System.out.println(Arrays.toString(freq));

        for (int i = 0; i < arr.length; i++)
        {
            char ch = arr[i];
            int cnt = freq[ch - 'a'];

            if (cnt > 0 && cnt < k)
            {
                int j = i + 1;
                while (j < arr.length && freq[arr[j] - 'a'] < k)
                {
                    j++;
                }
                // System.out.println(s.substring(0, i) + " " + s.substring(j));
                return Integer.max(
                        longestSubstring(s.substring(0, i), k),
                        longestSubstring(s.substring(j), k)
                );
            }
        }
        // 子串中没有出现次数 < k 的字符（入选）
        return s.length();
    }
}
