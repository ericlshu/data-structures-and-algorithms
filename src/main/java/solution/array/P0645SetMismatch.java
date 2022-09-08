package solution.array;

import java.util.*;

/**
 * Description : 错误的集合
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * <p>
 * 示例 2：
 * 输入：nums = [1,1]
 * 输出：[1,2]
 * <p>
 * 提示：
 * 2 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 *
 * @author Eric L SHU
 * @date 2022-09-08 20:46
 * @since jdk-11.0.14
 */
public class P0645SetMismatch
{
    public int[] findErrorNums_math(int[] nums)
    {
        int sumNum = 0, sumSet = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
        {
            sumNum += num;
            if (set.add(num))
                sumSet += num;
        }
        int repeated = sumNum - sumSet;
        int missed = (1 + nums.length) * nums.length / 2 - sumSet;
        return new int[]{repeated, missed};
    }

    public int[] findErrorNums_hash(int[] nums)
    {
        int[] errorNums = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 1; i <= nums.length; i++)
        {
            int count = map.getOrDefault(i, 0);
            if (count == 2)
                errorNums[0] = i;
            else if (count == 0)
                errorNums[1] = i;
        }
        return errorNums;
    }

    public int[] findErrorNums(int[] nums)
    {
        return new int[]{
                Arrays.stream(nums).sum() - Arrays.stream(nums).distinct().sum(),
                (1 + nums.length) * nums.length / 2 - Arrays.stream(nums).distinct().sum()
        };
    }

    public int[] findErrorNums_sort(int[] nums)
    {
        int[] result = new int[2];
        int n = nums.length;
        Arrays.sort(nums);
        int prev = 0;
        for (int curr : nums)
        {
            if (curr == prev)
                result[0] = prev;
            else if (curr - prev > 1)
                result[1] = prev + 1;
            prev = curr;
        }
        if (nums[n - 1] != n)
            result[1] = n;
        return result;
    }

    public int[] findErrorNums_bit(int[] nums)
    {
        int n = nums.length;
        int xor = 0;
        for (int num : nums)
        {
            xor ^= num;
        }
        for (int i = 1; i <= n; i++)
        {
            xor ^= i;
        }
        int lowBit = xor & (-xor);
        int num1 = 0, num2 = 0;
        for (int num : nums)
        {
            if ((num & lowBit) == 0)
                num1 ^= num;
            else
                num2 ^= num;
        }
        for (int i = 1; i <= n; i++)
        {
            if ((i & lowBit) == 0)
                num1 ^= i;
            else
                num2 ^= i;
        }
        for (int num : nums)
        {
            if (num == num1)
                return new int[]{num1, num2};
        }
        return new int[]{num2, num1};
    }
}
