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
}
