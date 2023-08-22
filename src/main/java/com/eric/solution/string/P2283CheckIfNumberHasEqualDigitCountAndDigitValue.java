package com.eric.solution.string;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2023-01-11 20:22
 * @since jdk-11.0.14
 */
public class P2283CheckIfNumberHasEqualDigitCountAndDigitValue
{
    public boolean digitCount(String num)
    {
        int n = num.length();
        int[] freq = new int[10];
        for (int i = 0; i < n; i++)
        {
            freq[num.charAt(i) - '0']++;
        }
        for (int i = 0; i < n; i++)
        {
            if (num.charAt(i) - '0' != freq[i])
                return false;
        }
        return true;
    }
}
