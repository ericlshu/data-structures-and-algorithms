package com.eric.solution.array;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * Description : 414. 第三大的数
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * <p>
 * 示例 1：
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * <p>
 * 示例 2：
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * <p>
 * 示例 3：
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 * <p>
 * 提示：
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * <p>
 * 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
 *
 * @author Eric L SHU
 * @date 2022-09-03 18:04
 * @since jdk-11.0.14
 */
public class P0414ThirdMaximumNumber
{
    /**
     * API排序去重
     */
    public int thirdMax_1(int[] nums)
    {
        int[] ints = IntStream.of(nums).distinct().sorted().toArray();
        return ints[ints.length >= 3 ? ints.length - 3 : ints.length - 1];
    }

    /**
     * 倒序排序
     */
    public int thirdMax_2(int[] nums)
    {
        Arrays.sort(nums);
        reverse(nums);
        for (int i = 1, diff = 1; i < nums.length; ++i)
        {
            if (nums[i] != nums[i - 1] && ++diff == 3)
                return nums[i];
        }
        return nums[0];
    }

    public void reverse(int[] nums)
    {
        int left = 0, right = nums.length - 1;
        while (left < right)
        {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }

    public int thirdMax_3(int[] nums)
    {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums)
        {
            set.add(num);
            // 若有序集合的大小超过 3，就删除集合中的最小元素。
            if (set.size() > 3)
            {
                set.remove(set.first());
            }
        }
        // 若有序集合的大小为 3，其最小值就是数组中第三大的数；
        // 若有序集合的大小不足 3，那么就返回有序集合中的最大值。
        return set.size() == 3 ? set.first() : set.last();
    }


    /**
     * 有限变量 + 遍历
     */
    public int thirdMax(int[] nums)
    {
        // long的取值范围大于int的取值范围
        long firstMax = Long.MIN_VALUE, secondMax = Long.MIN_VALUE, thirdMax = Long.MIN_VALUE;
        for (int x : nums)
        {
            // 最大值被更新，将原本的「最大值」和「次大值」往后顺延为「次大值」和「第三大值」，更新最大值；
            if (x > firstMax)
            {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = x;
            }
            // 次大值被更新，将原本的「次大值」往后顺延为「第三大值」，更新次大值；
            else if (x < firstMax && x > secondMax)
            {
                thirdMax = secondMax;
                secondMax = x;
            }
            // 第三大值被更新，更新第三大值
            else if (x < secondMax && x > thirdMax)
            {
                thirdMax = x;
            }
        }
        // 通过判断第三大值是否为初始化时的负无穷，来得知是否存在第三大值。
        return thirdMax != Long.MIN_VALUE ? (int) thirdMax : (int) firstMax;
    }

}
