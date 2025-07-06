package com.eric.solution.design;

import java.util.HashMap;
import java.util.Map;

/**
 * Description : 1865. 找出和为指定值的下标对
 * 给你两个整数数组 nums1 和 nums2 ，请你实现一个支持下述两类查询的数据结构：
 * 累加 ，将一个正整数加到 nums2 中指定下标对应元素上。
 * 计数 ，统计满足 nums1[i] + nums2[j] 等于指定值的下标对 (i, j) 数目（0 <= i < nums1.length 且 0 <= j < nums2.length）。
 * 实现 FindSumPairs 类：
 * <p>
 * FindSumPairs(int[] nums1, int[] nums2) 使用整数数组 nums1 和 nums2 初始化 FindSumPairs 对象。
 * void add(int index, int val) 将 val 加到 nums2[index] 上，即，执行 nums2[index] += val 。
 * int count(int tot) 返回满足 nums1[i] + nums2[j] == tot 的下标对 (i, j) 数目。
 * <p>
 * 示例：
 * ["FindSumPairs", "count", "add", "count", "count", "add", "add", "count"]
 * [[[1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4]], [7], [3, 2], [8], [4], [0, 1], [1, 1], [7]]
 * [null, 8, null, 2, 1, null, null, 11]
 * <p>
 * 解释：
 * FindSumPairs findSumPairs = new FindSumPairs([1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4]);
 * findSumPairs.count(7);  // 返回 8 ; 下标对 (2,2), (3,2), (4,2), (2,4), (3,4), (4,4) 满足 2 + 5 = 7 ，下标对 (5,1), (5,5) 满足 3 + 4 = 7
 * findSumPairs.add(3, 2); // 此时 nums2 = [1,4,5,4,5,4]
 * findSumPairs.count(8);  // 返回 2 ；下标对 (5,2), (5,4) 满足 3 + 5 = 8
 * findSumPairs.count(4);  // 返回 1 ；下标对 (5,0) 满足 3 + 1 = 4
 * findSumPairs.add(0, 1); // 此时 nums2 = [2,4,5,4,5,4]
 * findSumPairs.add(1, 1); // 此时 nums2 = [2,5,5,4,5,4]
 * findSumPairs.count(7);  // 返回 11 ；下标对 (2,1), (2,2), (2,4), (3,1), (3,2), (3,4), (4,1), (4,2), (4,4) 满足 2 + 5 = 7 ，下标对 (5,3), (5,5) 满足 3 + 4 = 7
 * <p>
 * 提示：
 * 1 <= nums1.length <= 1000
 * 1 <= nums2.length <= 10^5
 * 1 <= nums1[i] <= 10^9
 * 1 <= nums2[i] <= 10^5
 * 0 <= index < nums2.length
 * 1 <= val <= 10^5
 * 1 <= tot <= 10^9
 * 最多调用 add 和 count 函数各 1000 次
 *
 * @author Eric L SHU
 * @date 2025-07-06 10:56
 */
public class P1865FindSumPairs1
{
    Map<Integer, Integer> freq;
    int[] nums;

    public P1865FindSumPairs1(int[] nums1, int[] nums2)
    {
        freq = new HashMap<>();
        nums = nums2;
        for (int i : nums1)
        {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
    }

    public void add(int index, int val)
    {
        nums[index] += val;
    }

    public int count(int tot)
    {
        int res = 0;
        for (int num : nums)
        {
            res+= freq.getOrDefault(tot-num,0);
        }
        return res;
    }
}
