package com.eric.solution.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Description : 查找和最小的 K 对数字
 * 给定两个以 升序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 * <p>
 * 示例 1:
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * <p>
 * 示例 2:
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * <p>
 * 示例 3:
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 * <p>
 * 提示:
 * -> 1 <= nums1.length, nums2.length <= 105
 * -> -109 <= nums1[i], nums2[i] <= 109
 * -> nums1 和 nums2 均为升序排列
 * -> 1 <= k <= 1000
 *
 * @author Eric L SHU
 * @date 2023-01-01 20:38
 * @since jdk-11.0.14
 */
public class P0373FindKPairsWithSmallestSums
{
    public List<List<Integer>> kSmallestPairs_1(int[] nums1, int[] nums2, int k)
    {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(
                (list1, list2) -> (list2.get(0) + list2.get(1)) - (list1.get(0) + list1.get(1)));
        for (int i : nums1)
        {
            for (int j : nums2)
            {
                pq.offer(List.of(i, j));
                if (pq.size() > k)
                {
                    pq.poll();
                }
            }
        }
        List<List<Integer>> lists = new ArrayList<>();
        while (!pq.isEmpty())
        {
            lists.add(pq.poll());
        }
        return lists;
    }

    public List<List<Integer>> kSmallestPairs_2(int[] nums1, int[] nums2, int k)
    {
        // PriorityQueue<int[]> pq = new PriorityQueue<>((pt1, pt2) ->
        //         (nums1[pt1[0]] + nums2[pt1[1]] - (nums1[pt2[0]] + nums2[pt2[1]])));
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(pt -> nums1[pt[0]] + nums2[pt[1]]));
        List<List<Integer>> lists = new ArrayList<>();
        int m = nums1.length, n = nums2.length;
        for (int i = 0; i < Math.min(m, k); i++)
        {
            pq.offer(new int[]{i, 0});
        }
        int x, y;
        while (k-- > 0 && !pq.isEmpty())
        {
            int[] pt = pq.poll();
            x = pt[0];
            y = pt[1];
            lists.add(List.of(nums1[x], nums2[y]));
            if (y + 1 < n)
            {
                pq.offer(new int[]{x, y + 1});
            }
        }
        return lists;
    }
}
