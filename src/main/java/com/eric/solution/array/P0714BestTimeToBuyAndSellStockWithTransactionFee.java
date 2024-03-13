package com.eric.solution.array;

/**
 * <p>Copyright (c) 2024 Authors. All rights reserved.
 *
 * <p>Project: data-structures-and-algorithms
 * <p>Created By : Eric L SHU
 * <p>Created On : 2024-03-13 20:27:06
 * <p>
 * Description : 买卖股票的最佳时机含手续费
 * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * <p>
 * 示例 1：
 * 输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出：8
 * 解释：能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8
 * <p>
 * 示例 2：
 * 输入：prices = [1,3,7,5,10,3], fee = 3
 * 输出：6
 * <p>
 * 提示：
 * 1 <= prices.length <= 5 * 104
 * 1 <= prices[i] < 5 * 104
 * 0 <= fee < 5 * 104
 *
 * @version 1.0
 * @since jdk-17
 */
public class P0714BestTimeToBuyAndSellStockWithTransactionFee
{
    public int maxProfitDpn(int[] prices, int fee)
    {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i < prices.length; i++)
        {
            buy[i] = Integer.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Integer.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
        }
        return sell[prices.length - 1];
    }

    public int maxProfitDp1(int[] prices, int fee)
    {
        int _buy = -prices[0];
        int _sell = 0;
        for (int i = 1; i < prices.length; i++)
        {
            int buy = Integer.max(_buy, _sell - prices[i]);
            int sell = Integer.max(_sell, _buy + prices[i] - fee);
            _buy = buy;
            _sell = sell;
        }
        return _sell;
    }

    public int maxProfitDp2(int[] prices, int fee)
    {
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        for (int price : prices)
        {
            buy = Integer.max(buy, sell - price);
            sell = Integer.max(sell, buy + price - fee);
        }
        return sell;
    }
}
