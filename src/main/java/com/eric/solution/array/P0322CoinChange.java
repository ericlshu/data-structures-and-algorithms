package com.eric.solution.array;

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
}
