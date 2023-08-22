package com.eric.solution.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description : 最好的扑克手牌
 * 给你一个整数数组 ranks 和一个字符数组 suit 。你有 5 张扑克牌，第 i 张牌大小为 ranks[i] ，花色为 suits[i] 。
 * 下述是从好到坏你可能持有的 手牌类型 ：
 * -> "Flush"：同花，五张相同花色的扑克牌。
 * -> "Three of a Kind"：三条，有 3 张大小相同的扑克牌。
 * -> "Pair"：对子，两张大小一样的扑克牌。
 * -> "High Card"：高牌，五张大小互不相同的扑克牌。
 * 请你返回一个字符串，表示给定的 5 张牌中，你能组成的 最好手牌类型 。
 * 注意：返回的字符串 大小写 需与题目描述相同。
 * <p>
 * 示例 1：
 * 输入：ranks = [13,2,3,1,9], suits = ["a","a","a","a","a"]
 * 输出："Flush"
 * 解释：5 张扑克牌的花色相同，所以返回 "Flush" 。
 * <p>
 * 示例 2：
 * 输入：ranks = [4,4,2,4,4], suits = ["d","a","a","b","c"]
 * 输出："Three of a Kind"
 * 解释：第一、二和四张牌组成三张相同大小的扑克牌，所以得到 "Three of a Kind" 。
 * 注意我们也可以得到 "Pair" ，但是 "Three of a Kind" 是更好的手牌类型。
 * 有其他的 3 张牌也可以组成 "Three of a Kind" 手牌类型。
 * <p>
 * 示例 3：
 * 输入：ranks = [10,10,2,12,9], suits = ["a","b","c","a","d"]
 * 输出："Pair"
 * 解释：第一和第二张牌大小相同，所以得到 "Pair" 。
 * 我们无法得到 "Flush" 或者 "Three of a Kind" 。
 * <p>
 * 提示：
 * -> ranks.length == suits.length == 5
 * -> 1 <= ranks[i] <= 13
 * -> 'a' <= suits[i] <= 'd'
 * -> 任意两张扑克牌不会同时有相同的大小和花色。
 *
 * @author Eric L SHU
 * @date 2023-02-20 19:40
 * @since jdk-11.0.14
 */
public class P2347BestPokerHand
{
    public String bestHand_arr(int[] ranks, char[] suits)
    {
        int[] rCnt = new int[13], sCnt = new int[4];
        int rMax = 0, sMax = 0;
        for (int rank : ranks)
        {
            rCnt[rank - 1]++;
            rMax = Math.max(rMax, rCnt[rank - 1]);
        }
        for (char suit : suits)
        {
            sCnt[suit - 'a']++;
            sMax = Math.max(sMax, sCnt[suit - 'a']);
        }
        if (sMax == 5)
            return "Flush";
        if (rMax >= 3)
            return "Three of a Kind";
        if (rMax == 2)
            return "Pair";
        return "High Card";
    }

    public String bestHand_hash(int[] ranks, char[] suits)
    {
        Set<Character> set = new HashSet<>();
        for (char suit : suits)
        {
            set.add(suit);
        }
        if (set.size() == 1)
            return "Flush";

        Map<Integer, Integer> map = new HashMap<>();
        for (int rank : ranks)
        {
            map.put(rank, map.getOrDefault(rank, 0) + 1);
        }
        if (map.size() == 5)
            return "High Card";

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if (entry.getValue() > 2)
                return "Three of a Kind";
        }
        return "Pair";
    }
}
