package com.eric.solution.string;

/**
 * Description : 赎金信
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * <p>
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * <p>
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 * <p>
 * 提示：
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote 和 magazine 由小写英文字母组成
 *
 * @author Eric L SHU
 * @date 2022-09-10 13:13
 * @since jdk-11.0.14
 */
public class P0383RansomNote
{
    public boolean canConstruct(String ransomNote, String magazine)
    {
        if (ransomNote.length() > magazine.length())
            return false;
        int[] count = new int[26];
        for (char c : magazine.toCharArray())
        {
            count[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray())
        {
            if (--count[c - 'a'] < 0)
                return false;
        }
        return true;
    }
}
