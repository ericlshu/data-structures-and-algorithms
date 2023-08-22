package com.eric.solution.math;

/**
 * Description :  最大交换
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * <p>
 * 示例 1 :
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * <p>
 * 示例 2 :
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * <p>
 * 注意:
 * 给定数字的范围是 [0, 108]
 *
 * @author Eric L SHU
 * @date 2022-09-13 21:13
 * @since jdk-11.0.14
 */
public class P0670MaximumSwap
{
    public int maximumSwap_1(int num)
    {
        char[] chars = String.valueOf(num).toCharArray();
        int n = chars.length;
        int max = num;
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                swap(chars, i, j);
                max = Math.max(Integer.parseInt(String.valueOf(chars)), max);
                swap(chars, i, j);
            }
        }
        return max;
    }

    private void swap(char[] chars, int i, int j)
    {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public int maximumSwap_2(int num)
    {
        char[] chars = String.valueOf(num).toCharArray();
        int n = chars.length;
        int maxIdx = n - 1;
        int lowIdx = -1, highIdx = -1;
        for (int i = n - 2; i >= 0; i--)
        {
            if (chars[i] > chars[maxIdx])
            {
                maxIdx = i;
            }
            else if (chars[i] < chars[maxIdx])
            {
                lowIdx = i;
                highIdx = maxIdx;
            }
        }
        if (lowIdx >= 0)
        {
            swap(chars, lowIdx, highIdx);
            return Integer.parseInt(new String(chars));
        }
        else
        {
            return num;
        }
    }
}
