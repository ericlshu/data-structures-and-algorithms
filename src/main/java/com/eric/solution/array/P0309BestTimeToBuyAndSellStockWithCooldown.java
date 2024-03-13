package com.eric.solution.array;

/**
 * <p>Copyright (c) 2024 Authors. All rights reserved.
 *
 * <p>Project: data-structures-and-algorithms
 * <p>Created By : Eric L SHU
 * <p>Created On : 2024-03-13 20:32:22
 * <p>
 * Description : 买卖股票的最佳时机含冷冻期
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * <p>
 * 示例 2:
 * 输入: prices = [1]
 * 输出: 0
 * <p>
 * 提示：
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 *
 * @version 1.0
 * @since jdk-17
 */
public class P0309BestTimeToBuyAndSellStockWithCooldown
{
    public int maxProfitDpn(int[] prices)
    {
        if (prices.length == 1)
            return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        sell[0] = 0;
        buy[1] = Integer.max(-prices[0], -prices[1]);
        // sell[1] =  Integer.max(sell[0], buy[0] + prices[1]);
        sell[1] = Integer.max(0, prices[1] - prices[0]);
        for (int i = 2; i < prices.length; i++)
        {
            buy[i] = Integer.max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = Integer.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[prices.length - 1];
    }

    public int maxProfitDp1(int[] prices)
    {
        if (prices.length == 1)
            return 0;

        int sell0 = 0;
        int buy1 = Integer.max(-prices[0], -prices[1]);
        int sell1 = Integer.max(0, prices[1] - prices[0]);

        for (int i = 2; i < prices.length; i++)
        {
            int buy = Integer.max(buy1, sell0 - prices[i]);
            int sell = Integer.max(sell1, buy1 + prices[i]);
            buy1 = buy;
            sell0 = sell1;
            sell1 = sell;
        }
        return sell1;
    }
}
