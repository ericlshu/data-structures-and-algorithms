package solution.array;

/**
 * Description : 乘积小于 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 * <p>
 * 示例 1：
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3], k = 0
 * 输出：0
 * <p>
 * 提示:
 * 1 <= nums.length <= 3 * 104
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 106
 *
 * @author Eric L SHU
 * @date 2022-12-11 21:22
 * @since jdk-11.0.14
 */
public class P0713SubarrayProductLessThanK
{
    public int numSubarrayProductLessThanK_1(int[] nums, int k)
    {
        if (k == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] < k)
                count++;
            else
                continue;
            int j = i + 1;
            while (j < nums.length && nums[i] * nums[j] < k)
            {
                count++;
                nums[i] *= nums[j++];
            }
        }
        return count;
    }

    public int numSubarrayProductLessThanK_2(int[] nums, int k)
    {
        int n = nums.length, prod = 1, cnt = 0, l = 0;
        for (int r = 0; r < n; r++)
        {
            prod *= nums[r];
            while (l <= r && prod >= k)
            {
                prod /= nums[l];
                l++;
            }
            cnt += r - l + 1;
        }
        return cnt;
    }

    public int numSubarrayProductLessThanK_3(int[] nums, int k)
    {
        if (k == 0)
            return 0;
        int n = nums.length;
        double[] logPrefix = new double[n + 1];
        for (int i = 0; i < n; i++)
        {
            logPrefix[i + 1] = logPrefix[i] + Math.log(nums[i]);
        }
        double logK = Math.log(k);
        int res = 0;
        int left, right, idx, mid;
        for (int i = 0; i < n; i++)
        {
            left = 0;
            right = i + 1;
            idx = i + 1;
            double val = logPrefix[i + 1] - logK + 1e-10;
            while (left <= right)
            {
                mid = (left + right) >> 1;
                if (logPrefix[mid] > val)
                {
                    idx = mid;
                    right = mid - 1;
                }
                else
                {
                    left = mid + 1;
                }
            }
            res += i - idx + 1;
        }
        return res;
    }
}
