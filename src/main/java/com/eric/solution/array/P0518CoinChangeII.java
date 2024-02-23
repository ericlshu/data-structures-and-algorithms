package com.eric.solution.array;

import java.util.Arrays;

public class P0518CoinChangeII
{
    public static int changeRecursion(int amount, int[] coins)
    {
        coins = Arrays.stream(coins).boxed()
                .sorted((a, b) -> Integer.compare(b, a))
                .mapToInt(Integer::intValue).toArray();
        return rec(0, coins, amount);
    }

    private static int rec(int idx, int[] coins, int remain)
    {
        if (remain < 0)
            return 0;
        else if (remain == 0)
            return 1;
        else
        {
            int cnt = 0;
            for (int i = idx; i < coins.length; i++)
            {
                cnt += rec(i, coins, remain - coins[i]);
            }
            return cnt;
        }
    }

    public static int changeDpNn(int amount, int[] coins)
    {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++)
        {
            dp[i][0] = 1;
        }

        for (int j = coins[0]; j <= amount; j++)
        {
            dp[0][j] = dp[0][j - coins[0]];
        }

        for (int i = 1; i < coins.length; i++)
        {
            for (int j = 1; j <= amount; j++)
            {
                if (j >= coins[i])
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[coins.length - 1][amount];
    }

    public static int changeDpn1(int amount, int[] coins)
    {
        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int j = coins[0]; j <= amount; j++)
        {
            dp[j] = dp[j - coins[0]];
        }

        for (int i = 1; i < coins.length; i++)
        {
            for (int j = 1; j <= amount; j++)
            {
                if (j >= coins[i])
                    dp[j] = dp[j] + dp[j - coins[i]];
            }
        }

        return dp[amount];
    }

    public static int changeDpn2(int amount, int[] coins)
    {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins)
        {
            for (int j = coin; j <= amount; j++)
            {
                dp[j] = dp[j] + dp[j - coin];
            }
        }
        return dp[amount];
    }
}
