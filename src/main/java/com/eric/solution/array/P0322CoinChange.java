package com.eric.solution.array;

/*
 * 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 *
 * 示例 1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 * 示例 2：
 * 输入：coins = [2], amount = 3
 * 输出：-1
 *
 * 示例 3：
 * 输入：coins = [1], amount = 0
 * 输出：0
 *
 * 提示：
 * -> 1 <= coins.length <= 12
 * -> 1 <= coins[i] <= 231 - 1
 * -> 0 <= amount <= 104
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

public class P0322CoinChange
{
    static int min;

    public static int coinChangeRecursion(int[] coins, int amount)
    {
        min = -1;
        coins = Arrays.stream(coins).boxed()
                .sorted((a, b) -> Integer.compare(b, a))
                .mapToInt(Integer::intValue).toArray();
        rec(0, coins, amount, new AtomicInteger(-1));
        return min;
    }

    private static void rec(int idx, int[] coins, int remain, AtomicInteger cnt)
    {
        cnt.incrementAndGet();
        if (remain == 0)
        {
            if (min == -1)
                min = cnt.get();
            else
                min = Integer.min(min, cnt.get());
        }
        else if (remain > 0)
        {
            for (int i = idx; i < coins.length; i++)
            {
                rec(i, coins, remain - coins[i], cnt);
            }
        }
        cnt.decrementAndGet();
    }

    public static int coinChangeGreedy(int[] coins, int amount)
    {
        coins = Arrays.stream(coins).boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue).toArray();
        int remain = amount;
        int count = 0;
        for (int coin : coins)
        {
            while (remain > coin)
            {
                remain -= coin;
                count++;
            }
            if (remain == coin)
            {
                remain = 0;
                count++;
                break;
            }
        }
        if (remain > 0)
            return -1;
        else
            return count;
    }

    public static int coinChangeDpNn(int[] coins, int amount)
    {
        int[][] dp = new int[coins.length][amount + 1];

        for (int j = 1; j <= amount; j++)
        {
            if (j >= coins[0])
                dp[0][j] = dp[0][j - coins[0]] + 1;
            else
                dp[0][j] = amount + 1;
        }

        for (int i = 1; i < coins.length; i++)
        {
            for (int j = 1; j <= amount; j++)
            {
                if (j >= coins[i])
                    dp[i][j] = Integer.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[coins.length - 1][amount] <= amount ? dp[coins.length - 1][amount] : -1;
    }

    public static int coinChangeDpn1(int[] coins, int amount)
    {
        int[] dp = new int[amount + 1];

        for (int j = 1; j <= amount; j++)
        {
            if (j >= coins[0])
                dp[j] = dp[j - coins[0]] + 1;
            else
                dp[j] = amount + 1;
        }

        for (int i = 1; i < coins.length; i++)
        {
            for (int j = 1; j <= amount; j++)
            {
                if (j >= coins[i])
                    dp[j] = Integer.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        return dp[amount] <= amount ? dp[amount] : -1;
    }

    public static int coinChangeDpn2(int[] coins, int amount)
    {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins)
        {
            for (int j = coin; j <= amount; j++)
            {
                dp[j] = Integer.min(dp[j], dp[j - coin] + 1);
            }
        }
        return dp[amount] <= amount ? dp[amount] : -1;
    }
}
