package com.eric.solution.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Description : 统计一个数组中好对子的数目
 * 给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。比方说 rev(123) = 321 ， rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ：
 * 0 <= i < j < nums.length
 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * 请你返回好下标对的数目。由于结果可能会很大，请将结果对 109 + 7 取余 后返回。
 * <p>
 * 示例 1：
 * 输入：nums = [42,11,1,97]
 * 输出：2
 * 解释：两个坐标对为：
 * - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
 * - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。
 * <p>
 * 示例 2：
 * 输入：nums = [13,10,35,24,76]
 * 输出：4
 * <p>
 * 提示：
 * -> 1 <= nums.length <= 105
 * -> 0 <= nums[i] <= 109
 *
 * @author Eric L SHU
 * @date 2023-01-17 21:21
 * @since jdk-11.0.14
 */
public class P1814CountNicePairsInAnArray
{
    public int countNicePairs(int[] nums)
    {
        final int MOD = 1_000_000_007;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
        {
            int _num = 0, tmp = num;
            while (tmp > 0)
            {
                _num = _num * 10 + tmp % 10;
                tmp /= 10;
            }
            res = (res + map.getOrDefault(num - _num, 0)) % MOD;
            map.put(num - _num, map.getOrDefault(num - _num, 0) + 1);
        }
        return res;
    }
}
