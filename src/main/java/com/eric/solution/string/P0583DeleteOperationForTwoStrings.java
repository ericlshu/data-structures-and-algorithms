package com.eric.solution.string;

/**
 * <p>Copyright (c) 2024 Authors. All rights reserved.
 *
 * <p>Project: data-structures-and-algorithms
 * <p>Created By : Eric L SHU
 * <p>Created By : 2024-02-27 16:26:53
 * <p>
 * Description : 两个字符串的删除操作
 * <p>
 * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 * 每步 可以删除任意一个字符串中的一个字符。
 * <p>
 * 示例 1：
 * 输入: word1 = "sea", word2 = "eat"
 * 输出: 2
 * 解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
 * <p>
 * 示例  2:
 * 输入：word1 = "leetcode", word2 = "etco"
 * 输出：4
 * <p>
 * 提示：
 * -> 1 <= word1.length, word2.length <= 500
 * -> word1 和 word2 只包含小写英文字母
 *
 * @version 1.0
 * @since jdk-17
 */
public class P0583DeleteOperationForTwoStrings
{
    public static int minDistanceDpn1(String word1, String word2)
    {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int m = word1.length(), n = word2.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++)
        {
            int prev = dp[0];
            for (int j = 1; j <= n; j++)
            {
                int curr = dp[j];
                if (arr1[i - 1] == arr2[j - 1])
                    dp[j] = prev + 1;
                else
                    dp[j] = Integer.max(dp[j], dp[j - 1]);
                prev = curr;
            }
        }
        return m + n - 2 * dp[n];
    }

    public static int minDistanceDpnn(String word1, String word2)
    {
        int m = word1.length(), n = word2.length();
        char[] arr1 = word1.toCharArray(), arr2 = word2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
        {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++)
        {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++)
        {
            char ch1 = arr1[i - 1];
            for (int j = 1; j <= n; j++)
            {
                char ch2 = arr2[j - 1];
                if (ch1 == ch2)
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Integer.min(dp[i - 1][j], dp[i][j - 1]) + 1;
            }
        }
        return dp[m][n];
    }
}
