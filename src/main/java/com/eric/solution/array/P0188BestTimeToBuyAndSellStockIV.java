package com.eric.solution.array;

import java.util.Arrays;

/**
 * <p>Copyright (c) 2024 Authors. All rights reserved.
 *
 * <p>Project: data-structures-and-algorithms
 * <p>Created By : Eric L SHU
 * <p>Created On : 2024-03-13 20:38:27
 * <p>
 * Description : 买卖股票的最佳时机 IV
 * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1：
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * <p>
 * 示例 2：
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * <p>
 * 提示：
 * 1 <= k <= 100
 * 1 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 *
 * @version 1.0
 * @since jdk-17
 */
public class P0188BestTimeToBuyAndSellStockIV
{
    public int maxProfit(int k, int[] prices)
    {
        if (k >= prices.length / 2)
            return maxProfit(prices);

        int[] buy = new int[k];
        int[] sell = new int[k];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int price : prices)
        {
            // 第一次买，不依赖之前状态，以当日价格买入
            buy[0] = Integer.max(buy[0], -price);
            // 第一次卖，依赖于第一次买 + 当日价格
            sell[0] = Integer.max(sell[0], buy[0] + price);
            for (int i = 1; i < k; i++)
            {
                // 第 k 次买，依赖于昨天第 k-1 次卖 - 当日价格
                buy[i] = Integer.max(buy[i], sell[i - 1] - price);
                // 第 k 次卖，依赖于昨天第 k-1 次买 + 当日价格
                sell[i] = Integer.max(sell[i], buy[i] + price);
            }
        }
        return sell[k - 1];
    }

    private int maxProfit(int[] prices)
    {
        int sum = 0;
        for (int i = 1; i < prices.length; i++)
        {
            if (prices[i] > prices[i - 1])
                sum += (prices[i] - prices[i - 1]);
        }
        return sum;
    }
}
