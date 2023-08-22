package com.eric.solution.array;

import java.util.*;

/**
 * Description : 矩阵中战斗力最弱的 K 行
 * 给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 * 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 * <p>
 * 示例 1：
 * 输入：mat =
 * [[1,1,0,0,0],
 * [1,1,1,1,0],
 * [1,0,0,0,0],
 * [1,1,0,0,0],
 * [1,1,1,1,1]],
 * k = 3
 * 输出：[2,0,3]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 2
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 2
 * 行 4 -> 5
 * 从最弱到最强对这些行排序后得到 [2,0,3,1,4]
 * <p>
 * 示例 2：
 * 输入：mat =
 * [[1,0,0,0],
 * [1,1,1,1],
 * [1,0,0,0],
 * [1,0,0,0]],
 * k = 2
 * 输出：[0,2]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 1
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 1
 * 从最弱到最强对这些行排序后得到 [0,2,3,1]
 * <p>
 * 提示：
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] 不是 0 就是 1
 *
 * @author Eric L SHU
 * @date 2022-09-20 8:37 PM
 * @since jdk-11.0.14
 */
public class P1337TheKWeakestRowsInAMatrix
{
    public int[] kWeakestRows_1(int[][] mat, int k)
    {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < mat.length; i++)
        {
            int[] row = mat[i];
            int left = 0, right = row.length - 1;
            while (left <= right)
            {
                int mid = (left + right) >> 1;
                if (row[mid] == 1)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            list.add(i);
            map.put(i, left);
        }
        list.sort((o1, o2) ->
        {
            int cnt1 = map.get(o1), cnt2 = map.get(o2);
            return cnt1 == cnt2 ? o1 - o2 : cnt1 - cnt2;
        });
        int[] result = new int[k];
        for (int i = 0; i < k; i++)
        {
            result[i] = list.get(i);
        }
        return result;
    }

    public int[] kWeakestRows_2(int[][] mat, int k)
    {
        List<int[]> power = new ArrayList<>();
        for (int i = 0; i < mat.length; ++i)
        {
            int[] row = mat[i];
            int left = 0, right = row.length - 1;
            while (left <= right)
            {
                int mid = (left + right) >> 1;
                if (row[mid] == 1)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            power.add(new int[]{left, i});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (pair1, pair2) ->
                {
                    if (pair1[0] != pair2[0])
                        return pair1[0] - pair2[0];
                    else
                        return pair1[1] - pair2[1];
                });
        for (int[] pair : power)
        {
            pq.offer(pair);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i)
        {
            ans[i] = Objects.requireNonNull(pq.poll())[1];
        }
        return ans;
    }
}
