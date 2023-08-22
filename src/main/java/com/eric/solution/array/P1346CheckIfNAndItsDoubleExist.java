package com.eric.solution.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Description : 检查整数及其两倍数是否存在
 * 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
 * 更正式地，检查是否存在两个下标 i 和 j 满足：
 * <p>
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 * <p>
 * 示例 1：
 * 输入：arr = [10,2,5,3]
 * 输出：true
 * 解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
 * <p>
 * 示例 2：
 * 输入：arr = [7,1,14,11]
 * 输出：true
 * 解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
 * <p>
 * 示例 3：
 * 输入：arr = [3,1,7,11]
 * 输出：false
 * 解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
 * <p>
 * 提示：
 * 2 <= arr.length <= 500
 * -10^3 <= arr[i] <= 10^3
 *
 * @author Eric L SHU
 * @date 2022-09-20 8:41 PM
 * @since jdk-11.0.14
 */
public class P1346CheckIfNAndItsDoubleExist
{
    public boolean checkIfExist_1(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr.length; j++)
            {
                if (i == j)
                    continue;
                if (arr[j] == 2 * arr[i])
                    return true;
            }
        }
        return false;
    }

    public boolean checkIfExist_2(int[] arr)
    {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr)
        {
            if (set.contains(2 * i) || (i % 2 == 0 && set.contains(i / 2)))
                return true;
            set.add(i);
        }
        return false;
    }

    public boolean checkIfExist_3(int[] arr)
    {
        Arrays.sort(arr);
        int n = arr.length;
        int i = 0, j = 0;
        while (i < n)
        {
            while (j < n && 2 * arr[i] > arr[j])
                j++;
            if (j < n && i != j && 2 * arr[i] == arr[j])
                return true;
            i++;
        }
        /*i = j = n - 1;
        while (i >= 0)
        {
            while (j >= 0 && 2 * arr[i] > arr[j])
            {
                j--;
            }
            if (j >= 0 && i != j && 2 * arr[i] == arr[j])
            {
                return true;
            }
            i--;
        }*/
        return false;
    }
}
