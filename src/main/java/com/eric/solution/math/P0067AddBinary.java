package com.eric.solution.math;

/**
 * Description : 二进制求和
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * <p>
 * 示例 1：
 * 输入:a = "11", b = "1"
 * 输出："100"
 * <p>
 * 示例 2：
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 * <p>
 * 提示：
 * 1 <= a.length, b.length <= 104
 * a 和 b 仅由字符 '0' 或 '1' 组成
 * 字符串如果不是 "0" ，就不含前导零
 *
 * @author Eric L SHU
 * @date 2022-12-02 15:05
 * @since jdk-11.0.14
 */
public class P0067AddBinary
{
    public String addBinary_1(String a, String b)
    {
        if (a.length() < b.length())
            return addBinary_1(b, a);

        StringBuilder sb = new StringBuilder();
        int m = a.length() - 1, n = b.length() - 1;
        int idx = m - n - 1, carry = 0;
        while (n >= 0)
        {
            int sum = (a.charAt(m--) - '0') + (b.charAt(n--) - '0') + carry;
            carry = sum / 2;
            sb.insert(0, sum % 2);
        }
        while (idx >= 0)
        {
            int sum = (a.charAt(idx--) - '0') + carry;
            carry = sum / 2;
            sb.insert(0, sum % 2);
        }
        if (carry > 0)
            sb.insert(0, carry);
        return sb.toString();
    }

    public String addBinary_2(String a, String b)
    {
        int m = a.length(), n = b.length();
        int x = Math.max(a.length(), b.length()), carry = 0;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < x; ++i)
        {
            carry += i < m ? (a.charAt(m - 1 - i) - '0') : 0;
            carry += i < n ? (b.charAt(n - 1 - i) - '0') : 0;
            ans.insert(0, carry % 2);
            // ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0)
        {
            // ans.append('1');
            ans.insert(0, carry);
        }

        // ans.reverse();
        return ans.toString();
    }

    public String addBinary_api(String a, String b)
    {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }
}
