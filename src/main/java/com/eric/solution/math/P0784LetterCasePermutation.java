package com.eric.solution.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Description : 字母大小写全排列
 * 给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
 * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
 * <p>
 * 示例 1：
 * 输入：s = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * 示例 2:
 * 输入: s = "3z4"
 * 输出: ["3z4","3Z4"]
 * <p>
 * 提示:
 * 1 <= s.length <= 12
 * s 由小写英文字母、大写英文字母和数字组成
 *
 * @author Eric L SHU
 * @date 2022-10-06 1:50 PM
 * @since jdk-11.0.14
 */
public class P0784LetterCasePermutation
{
    public List<String> letterCasePermutation(String s)
    {
        ArrayList<String> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        dfs_1(chars, 0, list);
        dfs_2(chars, 0, list);
        return list;
    }

    private void dfs_1(char[] chars, int idx, ArrayList<String> list)
    {
        if (idx == chars.length)
        {
            list.add(new String(chars));
            return;
        }
        dfs_1(chars, idx + 1, list);
        if (Character.isLetter(chars[idx]))
        {
            chars[idx] ^= 1 << 5;
            dfs_1(chars, idx + 1, list);
        }
    }

    private void dfs_2(char[] chars, int idx, ArrayList<String> list)
    {
        list.add(new String(chars));
        for (int i = idx; i < chars.length; i++)
        {
            if (Character.isLetter(chars[i]))
            {
                chars[i] ^= 1 << 5;
                dfs_2(chars, i + 1, list);
                chars[i] ^= 1 << 5;
            }
        }
    }
}
