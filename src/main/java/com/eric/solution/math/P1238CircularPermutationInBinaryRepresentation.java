package com.eric.solution.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Description : 循环码排列
 * 给你两个整数 n 和 start。你的任务是返回任意 (0,1,2,,...,2^n-1) 的排列 p，并且满足：
 * -> p[0] = start
 * -> p[i] 和 p[i+1] 的二进制表示形式只有一位不同
 * -> p[0] 和 p[2^n -1] 的二进制表示形式也只有一位不同
 * <p>
 * 示例 1：
 * 输入：n = 2, start = 3
 * 输出：[3,2,0,1]
 * 解释：这个排列的二进制表示是 (11,10,00,01)
 * 所有的相邻元素都有一位是不同的，另一个有效的排列是 [3,1,0,2]
 * <p>
 * 示例 2：
 * 输出：n = 3, start = 2
 * 输出：[2,6,7,5,4,0,1,3]
 * 解释：这个排列的二进制表示是 (010,110,111,101,100,000,001,011)
 * <p>
 * 提示：
 * -> 1 <= n <= 16
 * -> 0 <= start < 2^n
 *
 * @author Eric L SHU
 * @date 2023-02-26 21:18
 * @since jdk-11.0.14
 */
public class P1238CircularPermutationInBinaryRepresentation
{
    public List<Integer> circularPermutation_1(int n, int start)
    {
        List<Integer> res = new ArrayList<>();
        res.add(start);
        for (int i = 1; i <= n; i++)
        {
            int m = res.size();
            for (int j = m - 1; j >= 0; j--)
            {
                res.add(((res.get(j) ^ start) | (1 << (i - 1))) ^ start);
            }
        }
        return res;
    }

    public List<Integer> circularPermutation_2(int n, int start)
    {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++)
        {
            res.add((i >> 1) ^ i ^ start);
        }
        return res;
    }
}
