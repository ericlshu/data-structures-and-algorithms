package com.eric.solution.math;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2025-06-26 10:10
 */
public class P2311LongestBinarySubsequenceLessThanOrEqualToK
{
    public int longestSubsequence(String s, int k)
    {
        int sm = 0;
        int cnt = 0;
        int bits = (int) (Math.log(k) / Math.log(2)) + 1;
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(s.length() - 1 - i);
            if (ch == '1')
            {
                if (i < bits && sm + (1 << i) <= k)
                {
                    sm += 1 << i;
                    cnt++;
                }
            }
            else
            {
                cnt++;
            }
        }
        return cnt;
    }
}
