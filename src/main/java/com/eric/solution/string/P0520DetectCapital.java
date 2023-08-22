package com.eric.solution.string;

/**
 * Description : 检测大写字母
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * -> 全部字母都是大写，比如 "USA" 。
 * -> 单词中所有字母都不是大写，比如 "leetcode" 。
 * -> 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：word = "USA"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：word = "FlaG"
 * 输出：false
 * <p>
 * 提示：
 * -> 1 <= word.length <= 100
 * -> word 由小写和大写英文字母组成
 *
 * @author Eric L SHU
 * @date 2022-12-14 16:38
 * @since jdk-11.0.14
 */
public class P0520DetectCapital
{
    public boolean detectCapitalUse(String word)
    {
        boolean allLower = true, allUpper = true, firstUpper = true;
        if (Character.isUpperCase(word.charAt(0)))
        {
            allLower = false;
        }
        else
        {
            allUpper = false;
            firstUpper = false;
        }
        for (int i = 1; i < word.length(); i++)
        {
            if (Character.isUpperCase(word.charAt(i)))
            {
                firstUpper = false;
                allLower = false;
            }
            else
            {
                allUpper = false;
            }
        }
        return allLower || allUpper || firstUpper;
    }


    public boolean detectCapitalUse_api(String word)
    {
        return word.equals(word.toUpperCase()) ||
                word.substring(1).equals(word.substring(1).toLowerCase());
    }

    public boolean detectCapitalUse_regex(String word)
    {
        return word.matches("[A-Z]*|[A-Z]?[a-z]*");
    }

    public boolean detectCapitalUse_official(String word)
    {
        // 若第 1 个字母为小写，则需额外判断第 2 个字母是否为小写
        if (word.length() >= 2 && Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1)))
        {
            return false;
        }

        // 无论第 1 个字母是否大写，其他字母必须与第 2 个字母的大小写相同
        for (int i = 2; i < word.length(); ++i)
        {
            if (Character.isLowerCase(word.charAt(i)) ^ Character.isLowerCase(word.charAt(1)))
            {
                return false;
            }
        }
        return true;
    }
}
