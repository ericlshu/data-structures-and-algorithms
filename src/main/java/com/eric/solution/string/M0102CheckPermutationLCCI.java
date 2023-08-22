package com.eric.solution.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description : 面试题 01.02. 判定是否互为字符重排
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * <p>
 * 示例 1：
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * <p>
 * 示例 2：
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 * <p>
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 *
 * @author Eric L SHU
 * @date 2022-09-27 12:43
 * @since jdk-11.0.14
 */
public class M0102CheckPermutationLCCI
{
    public boolean CheckPermutation_hash(String s1, String s2)
    {
        if (s1.length() != s2.length())
        {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++)
        {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) - 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet())
        {
            if (entry.getValue() != 0)
            {
                return false;
            }
        }
        return true;
    }

    public boolean CheckPermutation_sort(String s1, String s2)
    {
        if (s1.length() != s2.length())
        {
            return false;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    public boolean CheckPermutation_array(String s1, String s2)
    {
        if (s1.length() != s2.length())
        {
            return false;
        }
        int[] table = new int[128];
        for (int i = 0; i < s1.length(); i++)
        {
            table[s1.charAt(i)]++;
            table[s2.charAt(i)]--;
        }
        for (int i = 0; i < s2.length(); i++)
        {
            if (table[s2.charAt(i)] != 0)
            {
                return false;
            }
        }
        return true;
    }
}
