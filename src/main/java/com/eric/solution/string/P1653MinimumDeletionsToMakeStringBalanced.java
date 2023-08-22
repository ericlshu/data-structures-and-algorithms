package com.eric.solution.string;

/**
 * Description : 使字符串平衡的最少删除次数
 * 给你一个字符串 s ，它仅包含字符 'a' 和 'b'。
 * 你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b' 的同时 s[j]= 'a' ，此时认为 s 是 平衡 的。
 * 请你返回使 s 平衡 的 最少 删除次数。
 * <p>
 * 示例 1：
 * 输入：s = "aababbab"
 * 输出：2
 * 解释：你可以选择以下任意一种方案：
 * 下标从 0 开始，删除第 2 和第 6 个字符（"aababbab" -> "aaabbb"），
 * 下标从 0 开始，删除第 3 和第 6 个字符（"aababbab" -> "aabbbb"）。
 * <p>
 * 示例 2：
 * 输入：s = "bbaaaaabb"
 * 输出：2
 * 解释：唯一的最优解是删除最前面两个字符。
 * <p>
 * 提示：
 * -> 1 <= s.length <= 105
 * -> s[i] 要么是 'a' 要么是 'b' 。
 *
 * @author Eric L SHU
 * @date 2023-03-06 20:17
 * @since jdk-11.0.14
 */
public class P1653MinimumDeletionsToMakeStringBalanced
{
    public int minimumDeletions(String s)
    {
        int n = s.length(), rightA = 0, leftB = 0;
        for (int i = 0; i < n; i++)
        {
            if (s.charAt(i) == 'a')
                rightA++;
        }
        int res = rightA;
        for (int i = 0; i < n; i++)
        {
            char c = s.charAt(i);
            if (c == 'a')
                rightA--;
            else
                leftB++;
            res = Math.min(res, leftB + rightA);
        }
        return res;
    }
}
