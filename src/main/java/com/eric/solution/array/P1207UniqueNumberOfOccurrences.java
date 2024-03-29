package com.eric.solution.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description : 独一无二的出现次数
 * <p>
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * <p>
 * 示例 1：
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * <p>
 * 示例 2：
 * 输入：arr = [1,2]
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 * <p>
 * 提示：
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 *
 * @author Eric L SHU
 * @date 2020-10-28 19:43
 * @since JDK 1.8
 */
public class P1207UniqueNumberOfOccurrences
{
    public boolean uniqueOccurrences(int[] arr)
    {
        Map<Integer, Integer> occur = new HashMap<>(100);
        for (int x : arr)
        {
            occur.put(x, occur.getOrDefault(x, 0) + 1);
        }
        Set<Integer> times = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : occur.entrySet())
        {
            times.add(entry.getValue());
        }
        return times.size() == occur.size();
    }
}
