package com.shl;

import java.util.Scanner;

/**
 * Description :
 * Josh went to the market to buy N apples. He found two shops, A and B, that sold apples in lots.
 * He can buy any number of complete lots but he cannot buy loose apples, He is confused about the price and needs help to calculate the minimum cost of exactly N apples.
 * Write an algorithm for Josh to calculate the minimum cost of exactly N apples.
 * InputThe first line of the input consists of an integer - num, representing the total number of apples that Josh wishes to buy (N).
 * The second line consists of a positive integer - appleShop1, representing the number of apples in a lot from shop A.
 * The third line consists of a positive integer -priceShop1, representing the price of the lot at shop A.
 * The fourth line consists of a positive integer - appleShop2, representing the number of apples in a lot from shop B.
 * The fifth line consists of a positive integer - priceShop2, representing the price of the lot at shop B.
 * <p>
 * Output
 * Print a positive integer representing the minimum price at which Josh can buy N apples.
 * <p>
 * Constraints
 * 0 <= num, priceShop1, priceShop2
 * 1 <= appleShop1, appleShop2
 * <p>
 * Note
 * There will always be at least one solution.
 * There is only one lot size for a particular shop.
 * There is an unlimited supply of apples at both shops
 * <p>
 * Example
 * <p>
 * Input:
 * 19
 * 3
 * 10
 * 4
 * 15
 * <p>
 * Output
 * 65
 *
 * @author Eric L SHU
 * @date 2026-01-13 19:39
 */
public class JoshWentToTheMarketToBuyNApples
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // 读取输入
        int num = sc.nextInt();
        int appleShop1 = sc.nextInt();
        int priceShop1 = sc.nextInt();
        int appleShop2 = sc.nextInt();
        int priceShop2 = sc.nextInt();

        // 初始化最小花费为一个较大的值
        int minCost = Integer.MAX_VALUE;

        // 枚举在店铺 A 中购买的批次数量
        for (int i = 0; i * appleShop1 <= num; i++)
        {
            int applesFromA = i * appleShop1; // 从 A 店买的苹果数量
            int remainingApples = num - applesFromA; // 剩余需要的苹果数量

            // 计算需要从店铺 B 购买的批次数量（向上取整）
            int batchesFromB = (int) Math.ceil((double) remainingApples / appleShop2);

            // 总花费
            int totalCost = i * priceShop1 + batchesFromB * priceShop2;

            // 更新最小花费
            minCost = Math.min(minCost, totalCost);
        }

        // 输出最小花费
        System.out.println(minCost);
    }
}
