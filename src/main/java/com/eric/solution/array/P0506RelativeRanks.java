package com.eric.solution.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Description : 相对名次
 * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
 * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
 * <p>
 * 名次第 1 的运动员获金牌 "Gold Medal" 。
 * 名次第 2 的运动员获银牌 "Silver Medal" 。
 * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
 * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
 * <p>
 * 示例 1：
 * 输入：score = [5,4,3,2,1]
 * 输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
 * 解释：名次为 [1st, 2nd, 3rd, 4th, 5th] 。
 * <p>
 * 示例 2：
 * 输入：score = [10,3,8,9,4]
 * 输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
 * 解释：名次为 [1st, 5th, 3rd, 2nd, 4th] 。
 * <p>
 * 提示：
 * n == score.length
 * 1 <= n <= 104
 * 0 <= score[i] <= 106
 * score 中的所有值 互不相同
 *
 * @author Eric L SHU
 * @date 2022-09-05 20:26
 * @since jdk-11.0.14
 */
public class P0506RelativeRanks
{
    public String[] findRelativeRanks(int[] score)
    {
        int n = score.length;
        Map<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++)
        {
            map.put(score[i], i);
        }
        String[] desc = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        Integer[] integers = Arrays.stream(score).boxed().toArray(Integer[]::new);
        // Arrays.sort(integers, (a, b) -> b - a);
        Arrays.sort(integers, Comparator.reverseOrder());
        String[] result = new String[n];
        for (int i = 0; i < integers.length; i++)
        {
            int index = map.get(integers[i]);
            result[index] = i < 3 ? desc[i] : String.valueOf(i + 1);
        }
        return result;
    }

    public String[] findRelativeRanks_2(int[] score)
    {
        int n = score.length;
        String[] desc = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; ++i)
        {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        String[] ans = new String[n];
        for (int i = 0; i < n; ++i)
        {
            if (i >= 3)
                ans[arr[i][1]] = Integer.toString(i + 1);
            else
                ans[arr[i][1]] = desc[i];
        }
        return ans;
    }

    public String[] findRelativeRanks_1(int[] score)
    {
        int n = score.length;
        Map<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++)
        {
            map.put(score[i], i);
        }
        Arrays.sort(score);
        String[] result = new String[n];
        for (int i = n - 1; i >= 0; i--)
        {
            int index = map.get(score[i]);
            if (i == n - 1)
                result[index] = "Gold Medal";
            else if (i == n - 2)
                result[index] = "Silver Medal";
            else if (i == n - 3)
                result[index] = "Bronze Medal";
            else
                result[index] = String.valueOf(n - i);
        }
        return result;
    }
}
