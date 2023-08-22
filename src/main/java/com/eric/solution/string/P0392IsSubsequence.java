package com.eric.solution.string;

/**
 * Description : 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * <p>
 * 示例 1：
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 * <p>
 * 提示：
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
 *
 * @author Eric L SHU
 * @date 2022-09-29 21:31
 * @since jdk-11.0.14
 */
public class P0392IsSubsequence
{
    public boolean isSubsequence1(String s, String t)
    {
        int lenS = s.length(), lenT = t.length();
        int idxS = 0, idxT = 0;
        while (idxS < lenS && idxT < lenT)
        {
            while (idxT < lenT && t.charAt(idxT) != s.charAt(idxS))
            {
                idxT++;
            }
            idxS++;
            idxT++;
        }
        return idxS == lenS && idxT <= lenT;
    }

    public boolean isSubsequence2(String s, String t)
    {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m)
        {
            if (s.charAt(i) == t.charAt(j))
                i++;
            j++;
        }
        return i == n;
    }

    public boolean isSubsequenceDp(String s, String t)
    {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++)
        {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--)
        {
            for (int j = 0; j < 26; j++)
            {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++)
        {
            if (f[add][s.charAt(i) - 'a'] == m)
            {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }
}
