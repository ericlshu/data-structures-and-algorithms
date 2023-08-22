package com.eric.solution.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Description : 判断句子是否为全字母句
 * 全字母句 指包含英语字母表中每个字母至少一次的句子。
 * 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。
 * 如果是，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
 * 输出：true
 * 解释：sentence 包含英语字母表中每个字母至少一次。
 * <p>
 * 示例 2：
 * 输入：sentence = "leetcode"
 * 输出：false
 * <p>
 * 提示：
 * -> 1 <= sentence.length <= 1000
 * -> sentence 由小写英语字母组成
 *
 * @author Eric L SHU
 * @date 2022-12-13 10:17
 * @since jdk-11.0.14
 */
public class P1832CheckIfTheSentenceIsPangram
{
    public boolean checkIfPangram_arr(String sentence)
    {
        int[] freq = new int[26];
        for (int i = 0; i < sentence.length(); i++)
        {
            freq[sentence.charAt(i) - 'a']++;
        }
        for (int i : freq)
        {
            if (i == 0)
                return false;
        }
        return true;
    }

    public boolean checkIfPangram_set(String sentence)
    {
        Set<Character> set = new HashSet<>();
        for (char c : sentence.toCharArray())
        {
            set.add(c);
        }
        return set.size() == 26;
    }

    public boolean checkIfPangram_bit(String sentence)
    {
        int state = 0;
        for (int i = 0; i < sentence.length(); i++)
        {
            char ch = sentence.charAt(i);
            state |= 1 << (ch - 'a');
        }
        System.out.println("state = " + state);
        return state == (1 << 26) - 1;
    }
}
