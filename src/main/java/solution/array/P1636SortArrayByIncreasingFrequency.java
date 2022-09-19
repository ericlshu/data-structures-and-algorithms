package solution.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description : 按照频率将数组升序排序
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 * 请你返回排序后的数组。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,2,2,2,3]
 * 输出：[3,1,1,2,2,2]
 * 解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
 * <p>
 * 示例 2：
 * 输入：nums = [2,3,1,3,2]
 * 输出：[1,3,3,2,2]
 * 解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
 * <p>
 * 示例 3：
 * 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
 * 输出：[5,-1,4,4,-6,-6,1,1,1]
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 *
 * @author Eric L SHU
 * @date 2022-09-19 9:57 PM
 * @since jdk-11.0.14
 */
public class P1636SortArrayByIncreasingFrequency
{
    public int[] frequencySort_2(int[] nums)
    {
        Map<Integer, Integer> frequency = new HashMap<>(10);
        for (int num : nums)
        {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = Arrays.stream(nums).boxed().sorted((o1, o2) ->
        {
            int cnt1 = frequency.get(o1), cnt2 = frequency.get(o2);
            return cnt1 != cnt2 ? cnt1 - cnt2 : o2 - o1;
        }).collect(Collectors.toList());
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int[] frequencySort_1(int[] nums)
    {
        Map<Integer, Integer> frequency = new HashMap<>(10);
        for (int num : nums)
        {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = Arrays.stream(nums).boxed().sorted((o1, o2) ->
        {
            int cnt1 = frequency.get(o1), cnt2 = frequency.get(o2);
            return cnt1 != cnt2 ? cnt1 - cnt2 : o2 - o1;
        }).collect(Collectors.toList());
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int[] frequencySort(int[] nums)
    {
        Map<Integer, Integer> frequency = new HashMap<>(10);
        for (int num : nums)
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        return Arrays.stream(nums).boxed().sorted((o1, o2) ->
        {
            int cnt1 = frequency.get(o1), cnt2 = frequency.get(o2);
            return cnt1 != cnt2 ? cnt1 - cnt2 : o2 - o1;
        }).collect(Collectors.toList()).stream().mapToInt(Integer::valueOf).toArray();
    }
}
