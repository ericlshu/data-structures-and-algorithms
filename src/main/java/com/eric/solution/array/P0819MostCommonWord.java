package com.eric.solution.array;

import java.util.*;

/*
 * Description : 最常见的单词
 * 给你一个字符串 paragraph 和一个表示禁用词的字符串数组 banned ，返回出现频率最高的非禁用词。题目数据 保证 至少存在一个非禁用词，且答案 唯一 。
 * paragraph 中的单词 不区分大小写 ，答案应以 小写 形式返回。
 *
 * 示例 1：
 * 输入：paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
 * 输出："ball"
 * 解释：
 * "hit" 出现了 3 次，但它是禁用词。
 * "ball" 出现了两次（没有其他单词出现这么多次），因此它是段落中出现频率最高的非禁用词。
 * 请注意，段落中的单词不区分大小写，
 * 标点符号会被忽略（即使它们紧挨着单词，如 "ball,"），
 * 并且尽管 "hit" 出现的次数更多，但它不能作为答案，因为它是禁用词。
 *
 * 示例 2：
 * 输入：paragraph = "a.", banned = []
 * 输出："a"
 *
 * 提示：
 * -> 1 <= paragraph.length <= 1000
 * -> paragraph 由英文字母、空格 ' '、和以下符号组成："!?',;."
 * -> 0 <= banned.length <= 100
 * -> 1 <= banned[i].length <= 10
 * -> banned[i] 仅由小写英文字母组成
 *
 * @author Eric L SHU
 * @date 2023-12-26 5:34 PM
 * @since jdk-11.0.14
 */
public class P0819MostCommonWord
{
    public String mostCommonWord1(String paragraph, String[] banned)
    {
        String[] split = paragraph.toLowerCase().split("[^A-Za-z]+");
        Set<String> set = Set.of(banned);
        HashMap<String, Integer> freq = new HashMap<>();
        for (String key : split)
        {
            if (!set.contains(key))
                freq.compute(key, (k, v) -> v == null ? 1 : v + 1);
        }
        Optional<Map.Entry<String, Integer>> entry = freq.entrySet().stream().max(Map.Entry.comparingByValue());
        return entry.map(Map.Entry::getKey).orElse(null);
    }

    public String mostCommonWord2(String paragraph, String[] banned)
    {
        char[] chars = paragraph.toLowerCase().toCharArray();
        Set<String> set = Set.of(banned);
        HashMap<String, Integer> freq = new HashMap<>();
        int max = 0;
        String maxKey = null;
        StringBuilder sb = new StringBuilder();
        for (char ch : chars)
        {
            if (ch >= 'a' && ch <= 'z')
            {
                sb.append(ch);
            }
            else if (!sb.isEmpty())
            {
                String key = sb.toString();
                if (!set.contains(key))
                    freq.put(key, freq.getOrDefault(key, 0) + 1);
                sb.setLength(0);
            }
        }
        if (!sb.isEmpty())
        {
            String key = sb.toString();
            if (!set.contains(key))
                freq.put(key, freq.getOrDefault(key, 0) + 1);
        }
        // System.out.println(freq);
        for (Map.Entry<String, Integer> entry : freq.entrySet())
        {
            if (entry.getValue() > max)
            {
                max = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }
}
