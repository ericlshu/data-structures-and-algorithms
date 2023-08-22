package com.eric.solution.string;

/**
 * Description : 所有子字符串美丽值之和
 * 一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
 * 比方说，"abaacc" 的美丽值为 3 - 1 = 2 。
 * 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。
 * <p>
 * 示例 1：
 * 输入：s = "aabcb"
 * 输出：5
 * 解释：美丽值不为零的字符串包括 ["aab","aabc","aabcb","abcb","bcb"] ，每一个字符串的美丽值都为 1 。
 * <p>
 * 示例 2：
 * 输入：s = "aabcbaa"
 * 输出：17
 * <p>
 * 提示：
 * -> 1 <= s.length <= 500
 * -> s 只包含小写英文字母。
 *
 * @author Eric L SHU
 * @date 2022-12-12 20:26
 * @since jdk-11.0.14
 */
public class P1781SumOfBeautyOfAllSubstrings
{
    public int beautySum(String s)
    {
        int n = s.length(), sum = 0;
        for (int i = 0; i < n; i++)
        {
            int[] cnt = new int[26];
            int maxFreq = 0;
            for (int j = i; j < n; j++)
            {
                maxFreq = Math.max(maxFreq, ++cnt[s.charAt(j) - 'a']);
                int minFreq = n;
                for (int k = 0; k < 26; k++)
                {
                    if (cnt[k] > 0)
                        minFreq = Math.min(minFreq, cnt[k]);
                }
                sum += maxFreq - minFreq;
            }
        }
        return sum;
    }
}
