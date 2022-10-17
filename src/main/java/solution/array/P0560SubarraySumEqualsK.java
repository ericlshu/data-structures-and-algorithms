package solution.array;

/**
 * Description : 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * <p>
 * 提示：
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 *
 * @author Eric L SHU
 * @date 2022-10-17 21:31
 * @since jdk-11.0.14
 */
public class P0560SubarraySumEqualsK
{
    public int subarraySum_1(int[] nums, int k)
    {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++)
        {
            int sum = nums[i];
            if (sum == k)
            {
                cnt++;
            }
            int j = i + 1;
            while (j < n)
            {
                sum += nums[j++];
                if (sum == k)
                    cnt++;
            }
        }
        return cnt;
    }

    public int subarraySum_2(int[] nums, int k)
    {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++)
        {
            int sum = 0;
            int j = i;
            while (j < n)
            {
                sum += nums[j++];
                if (sum == k)
                    cnt++;
            }
        }
        return cnt;
    }

    // public int subarraySum_3(int[] nums, int k)
    // {
    //     int cnt = 0, pre = 0;
    //     Map<Integer, Integer> map = new HashMap<>();
    //     map.put(0, 1);
    //     for (int num : nums)
    //     {
    //         pre += num;
    //         if (map.containsKey(pre - k))
    //         {
    //             cnt += map.get(pre - k);
    //         }
    //         map.put(pre, map.getOrDefault(pre, 0) + 1);
    //     }
    //     return cnt;
    // }
}
