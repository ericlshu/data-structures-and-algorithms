package com.eric.solution.string;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2025-06-22 18:28
 * @since jdk-11.0.14
 */
public class P2138DivideAStringIntoGroupsOfSizeK
{
    public String[] divideString(String s, int k, char fill)
    {
        int n = (s.length() + k - 1) / k;
        String[] ans = new String[n];
        s = s + String.valueOf(fill).repeat(n * k - s.length());
        for (int i = 0; i < n; i++)
        {
            ans[i] = s.substring(i * k, (i + 1) * k);
        }
        return ans;
    }
}
