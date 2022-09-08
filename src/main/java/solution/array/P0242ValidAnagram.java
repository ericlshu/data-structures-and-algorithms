package solution.array;

import java.util.Arrays;

/**
 * Description : 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 提示:
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 * <p>
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * @author Eric L SHU
 * @date 2022-09-02 21:24
 * @since jdk-11.0.14
 */
public class P0242ValidAnagram
{
    public boolean isAnagram_sort(String s, String t)
    {
        if (s.length() != t.length())
            return false;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        return Arrays.equals(ss, tt);
    }

    public boolean isAnagram_hash_1(String s, String t)
    {
        if (s.length() != t.length())
            return false;

        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++)
        {
            table[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++)
        {
            int index = t.charAt(i) - 'a';
            table[index]--;
            if (table[index] < 0)
                return false;
        }
        return true;
    }

    /**
     * 首先判断两个字符串长度是否相等，不相等则直接返回 false
     * 若相等，则初始化 26 个字母哈希表，遍历字符串 s 和 t
     * s 负责在对应位置增加，t 负责在对应位置减少
     * 如果哈希表的值都为 0，则二者是字母异位词
     */
    public boolean isAnagram_hash_2(String s, String t)
    {
        if (s.length() != t.length())
            return false;
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++)
        {
            alpha[s.charAt(i) - 'a']++;
            alpha[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++)
            if (alpha[i] != 0)
                return false;
        return true;
    }
}
