package com.eric.solution.string;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2025-02-23 18:16
 * @since jdk-11.0.14
 */
public class P3280ConvertDateToBinary
{
    public static String convertDateToBinary(String date)
    {
        return binary(Integer.parseInt(date.substring(0, 4))) + "-"
                + binary(Integer.parseInt(date.substring(5, 7))) + "-"
                + binary(Integer.parseInt(date.substring(8, 10)));
    }

    private static String binary(int n)
    {
        StringBuilder result = new StringBuilder();
        while (n > 0)
        {
            result.append(n & 1);
            n >>= 1;
        }
        return result.reverse().toString();
    }
}
