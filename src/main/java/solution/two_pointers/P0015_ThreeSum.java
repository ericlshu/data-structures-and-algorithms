package solution.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description : 三数之和
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author Eric L SHU
 * @date 2020-10-29 22:54
 * @since JDK 1.8
 */
public class P0015_ThreeSum
{
    public List<List<Integer>> threeSum(int[] nums)
    {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                for (int k = j + 1; k < n; k++)
                {
                    if (nums[i] + nums[j] + nums[k] == 0)
                    {
                        List<Integer> element = new ArrayList<>();
                        element.add(nums[i]);
                        element.add(nums[j]);
                        element.add(nums[k]);
                        if (!result.contains(element))
                            result.add(element);
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum_1(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length <= 2) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++)
        {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right)
            {
                if (nums[left] + nums[right] == target)
                {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1])
                    {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1])
                    {
                        right--;
                    }
                }
                else if (nums[left] + nums[right] < target)
                {
                    left++;
                }
                else
                {
                    right--;
                }
            }
        }
        return result;
    }
}
