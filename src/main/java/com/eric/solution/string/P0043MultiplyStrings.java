package com.eric.solution.string;

/**
 * Description : 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * <p>
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * <p>
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * <p>
 * 提示：
 * 1 <= num1.length, num2.length <= 200
 * num1 和 num2 只能由数字组成。
 * num1 和 num2 都不包含任何前导零，除了数字0本身。
 *
 * @author Eric L SHU
 * @date 2022-10-17 20:09
 * @since jdk-11.0.14
 */
public class P0043MultiplyStrings
{
    public String multiply_1(String num1, String num2)
    {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        String ans = "0";
        int len1 = num1.length(), len2 = num2.length();
        for (int i = len2 - 1; i >= 0; i--)
        {
            StringBuilder tmp = new StringBuilder();
            int carry = 0;
            for (int j = len2 - 1; j > i; j--)
            {
                tmp.insert(0, 0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = len1 - 1; j >= 0; j--)
            {
                int x = num1.charAt(j) - '0';
                int product = x * y + carry;
                tmp.insert(0, product % 10);
                carry = product / 10;
            }
            if (carry > 0)
            {
                tmp.insert(0, carry);
            }
            ans = addStrings(ans, tmp.toString());
        }
        return ans;
    }

    private String addStrings(String num1, String num2)
    {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0)
        {
            int x = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int result = x + y + carry;
            res.append(result % 10);
            carry = result / 10;
        }
        res.reverse();
        return res.toString();
    }

    public String multiply_2(String num1, String num2)
    {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int m = num1.length(), n = num2.length(), x, y;
        int[] tmp = new int[m + n];
        for (int i = m - 1; i >= 0; i--)
        {
            x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--)
            {
                y = num2.charAt(j) - '0';
                tmp[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--)
        {
            tmp[i - 1] += tmp[i] / 10;
            tmp[i] %= 10;
        }
        int idx = tmp[0] == 0 ? 1 : 0;
        StringBuilder res = new StringBuilder();
        while (idx < m + n)
        {
            res.append(tmp[idx++]);
        }
        return res.toString();
    }
}
