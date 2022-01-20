package solution.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description : 存在重复元素
 * <p>
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * <p>
 * 示例3：
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 * <p>
 * 提示：
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 *
 * @author Eric L SHU
 * @date 2022-01-20 22:08
 * @since JDK 1.8
 */
public class P0217ContainsDuplicate {
    /**
     * 去重计数
     */
    public boolean containsDuplicate1(int[] nums)
    {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }

    /**
     * 排序比较
     */
    public boolean containsDuplicate2(int[] nums)
    {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++)
        {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }

    /**
     * HashSet1
     */
    public boolean containsDuplicate3(int[] nums)
    {
        Set<Integer> temp = new HashSet<>();
        for (int num : nums)
        {
            if (temp.contains(num))
                return true;
            else
                temp.add(num);
        }
        return false;
    }

    /**
     * HashSet2
     */
    public boolean containsDuplicate4(int[] nums)
    {
        Set<Integer> temp = new HashSet<>();
        for (int num : nums)
        {
            if (!temp.add(num))
                return true;
        }
        return false;
    }

}
