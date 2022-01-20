package solution.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description : 存在重复元素 II
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 * <p>
 * 提示：
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 *
 * @author Eric L SHU
 * @date 2022-01-20 22:14
 * @since JDK 1.8
 */
public class P0219ContainsDuplicate2 {

    /**
     * HashMap
     */
    public boolean containsNearbyDuplicate1(int[] nums, int k)
    {
        Map<Integer, Integer> temp = new HashMap<>(10);
        for (int i = 0; i < nums.length; i++)
        {
            if (temp.containsKey(nums[i]) && (i - temp.get(nums[i]) <= k))
                return true;
            else
                temp.put(nums[i], i);
        }
        return false;
    }

    /**
     * 滑动窗口
     */
    public boolean containsNearbyDuplicate(int[] nums, int k)
    {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++)
        {
            if (i > k) set.remove(nums[i - k - 1]);
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
}
