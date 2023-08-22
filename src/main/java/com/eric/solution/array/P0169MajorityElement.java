package com.eric.solution.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description : 169. 多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1：
 * 输入：nums = [3,2,3]
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 * <p>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 * @author Eric L SHU
 * @date 2022-09-02 20:54
 * @since jdk-11.0.14
 */
public class P0169MajorityElement
{
    public int majorityElement_sort(int[] nums)
    {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement_hash(int[] nums)
    {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet())
        {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue())
            {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }

    /**
     * 用哈希表来快速统计每个元素出现的次数
     */
    private Map<Integer, Integer> countNums(int[] nums)
    {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums)
        {
            // if (!counts.containsKey(num))
            //     counts.put(num, 1);
            // else
            //     counts.put(num, counts.get(num) + 1);
            counts.put(num, counts.containsKey(num) ? counts.get(num) + 1 : 1);
        }
        return counts;
    }

    /**
     * Boyer-Moore 投票算法
     * 如果我们把众数记为 +1，把其他数记为 -1，将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多。
     */
    public int majorityElement_math(int[] nums)
    {
        int count = 0;
        Integer candidate = null;
        for (int num : nums)
        {
            if (count == 0)
                candidate = num;
            if (num == candidate)
                count++;
            else
                count--;
        }
        return candidate;
    }
}
