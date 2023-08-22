package com.eric.solution.array;

import java.util.TreeSet;

/**
 * Description : 1796. 字符串中第二大的数字
 * 给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
 * 混合字符串 由小写英文字母和数字组成。
 * <p>
 * 示例 1：
 * 输入：s = "dfa12321afd"
 * 输出：2
 * 解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
 * <p>
 * 示例 2：
 * 输入：s = "abc1111"
 * 输出：-1
 * 解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
 * <p>
 * 提示：
 * 1 <= s.length <= 500
 * s 只包含小写英文字母和（或）数字。
 *
 * @author Eric L SHU
 * @date 2022-09-03 19:29
 * @since jdk-11.0.14
 */
public class P1796SecondLargestDigitInAString
{
    public int secondHighest_1(String s)
    {
        TreeSet<Character> set = new TreeSet<>();
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9')
            {
                set.add(c);
                if (set.size() > 2)
                    set.remove(set.first());
            }
        }
        return set.size() < 2 ? -1 : set.first() - 48;
    }

    public int secondHighest(String s)
    {
        int maxNum = -1, secondMaxNum = -1;
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            // if (c >= '0' && c <= '9')
            if (Character.isDigit(c))
            {
                int num = c - '0';
                if (num > maxNum)
                {
                    secondMaxNum = maxNum;
                    maxNum = num;
                }
                else if (num > secondMaxNum && num < maxNum)
                {
                    secondMaxNum = num;
                }
            }
        }
        return secondMaxNum;
    }

}
