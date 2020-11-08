import java.util.HashMap;
import java.util.Map;

/**
 * Description : 两数之和
 *
 * 给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author Eric L SHU
 * @date 2020-10-13 20:48
 * @since JDK 1.8
 */
public class P0001_TwoSum
{
    public int[] twoNumbersAddUp01(int[] nums, int sum)
    {
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                if (nums[i] + nums[j] == sum)
                {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }


    public int[] twoNumbersAddUp02(int[] nums, int target)
    {
        Map<Integer, Integer> map = new HashMap<>(10);

        for (int i = 0; i < nums.length; i++)
        {
            int sub = target - nums[i];

            if (map.containsKey(sub))
            {
                return new int[]{map.get(sub), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
