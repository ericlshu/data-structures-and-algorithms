package com.eric.solution.tree;

/**
 * <p>Copyright (c) 2024 Authors. All rights reserved.
 *
 * <p>Project: data-structures-and-algorithms
 * <p>Created By : Eric L SHU
 * <p>Created On : 2024-02-29 09:39:38
 * <p>
 * Description : 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 * <p>
 * 提示：
 * -> 1 <= n <= 19
 *
 * @version 1.0
 * @since jdk-17
 */
public class P0096UniqueBinarySearchTrees
{
    public static int numTreesDp(int n)
    {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    // public static int numTrees(int n)
    // {
    //     return switch (n)
    //     {
    //         case 1 -> 1;
    //         case 2 -> 2;
    //         case 3 -> 5;
    //         case 4 -> 14;
    //         case 5 -> 42;
    //         case 6 -> 132;
    //         case 7 -> 429;
    //         case 8 -> 1430;
    //         case 9 -> 4862;
    //         case 10 -> 16796;
    //         case 11 -> 58786;
    //         case 12 -> 208012;
    //         case 13 -> 742900;
    //         case 14 -> 2674440;
    //         case 15 -> 9694845;
    //         case 16 -> 35357670;
    //         case 17 -> 129644790;
    //         case 18 -> 477638700;
    //         case 19 -> 1767263190;
    //         default -> 0;
    //     };
    // }

    public static int numTreesMath(int n)
    {
        long C = 1;
        for (int i = 0; i < n; ++i)
        {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }

}
