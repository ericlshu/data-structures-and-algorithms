package solution.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Description : 第 k 个缺失的正整数
 * 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
 * 请你找到这个数组里第 k 个缺失的正整数。
 * <p>
 * 示例 1：
 * 输入：arr = [2,3,4,7,11], k = 5
 * 输出：9
 * 解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
 * <p>
 * 示例 2：
 * 输入：arr = [1,2,3,4], k = 2
 * 输出：6
 * 解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
 * <p>
 * 提示：
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * 1 <= k <= 1000
 * 对于所有 1 <= i < j <= arr.length 的 i 和 j 满足 arr[i] < arr[j]
 * <p>
 * 进阶：
 * 你可以设计一个时间复杂度小于 O(n) 的算法解决此问题吗？
 *
 * @author Eric L SHU
 * @date 2022-09-17 19:57
 * @since jdk-11.0.14
 */
public class P1539KthMissingPositiveNumber
{

    public int findKthPositive_1(int[] arr, int k)
    {
        List<Integer> missed = new ArrayList<>();
        int count = 0, nextNum = 1;
        for (int num : arr)
        {
            while (num > nextNum)
            {
                missed.add(nextNum++);
                count++;
            }
            nextNum++;
        }
        if (k <= count)
            return missed.get(k - 1);
        else

            return arr[arr.length - 1] + (k - count);
    }

    public int findKthPositive_2(int[] arr, int k)
    {
        int count = 0, nextNum = 1;
        for (int num : arr)
        {
            while (num > nextNum)
            {
                if (++count == k)
                    return nextNum;
                else
                    nextNum++;
            }
            nextNum++;
        }
        return nextNum + (k - count - 1);
    }

    public int findKthPositive_3(int[] arr, int k)
    {
        for (int j : arr)
        {
            if (j <= k) k++;
            else break;
        }
        return k;
    }

    public int findKthPositive(int[] arr, int k)
    {
        int left = 0, right = arr.length - 1;
        while (left <= right)
        {
            int mid = (left + right) >> 1;
            if (arr[mid] - (mid + 1) < k)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left + k;
    }
}
