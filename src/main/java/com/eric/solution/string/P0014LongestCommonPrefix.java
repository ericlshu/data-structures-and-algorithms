package com.eric.solution.string;

/**
 * Description : 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 *
 * @author Eric L SHU
 * @date 2020-10-20 20:43
 * @since JDK 1.8
 */
public class P0014LongestCommonPrefix
{
    public String longestCommonPrefix1(String[] strs)
    {
        if (strs == null || strs.length == 0) return "";
        int index = 0;
        while (index < strs[0].length())
        {
            char ch = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++)
            {
                if (index == strs[i].length() || strs[i].charAt(index) != ch)
                    return strs[0].substring(0, index);
            }
            index++;
        }
        return strs[0];
    }

    public String longestCommonPrefix2(String[] strs)
    {
        char[] first = strs[0].toCharArray();
        for (int i = 0; i < first.length; i++)
        {
            char ch = first[i];
            for (int j = 1; j < strs.length; j++)
            {
                if (strs[j].length() == i || ch != strs[j].charAt(i))
                    return new String(first, 0, i);
            }
        }
        return strs[0];
    }
}
