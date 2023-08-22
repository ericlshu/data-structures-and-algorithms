package com.eric.solution.string;

/**
 * Description : 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * <p>
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * <p>
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由小写英文组成
 * 1 <= k <= 104
 *
 * @author Eric L SHU
 * @date 2022-09-13 20:44
 * @since jdk-11.0.14
 */
public class P0541ReverseStringII
{
    public String reverseStr_1(String s, int k)
    {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k)
        {
            reverse(arr, i, Math.min(i + k, n) - 1);
        }
        return new String(arr);
    }

    private void reverse(char[] chars, int left, int right)
    {
        while (left < right)
        {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
    }

    public String reverseStr_2(String s, int k)
    {
        int n = s.length();
        char[] chars = s.toCharArray();
        int count = n / k;
        int remain = n % k;
        int left, right;
        for (int i = 0; i < count; i += 2)
        {
            left = i * k;
            right = left + k - 1;
            /*while (left < right)
            {
                temp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = temp;
            }*/
            reverse(chars, left, right);
        }
        if (count % 2 == 0 && remain > 1)
        {
            left = count * k;
            right = n - 1;
            /*while (left < right)
            {
                temp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = temp;
            }*/
            reverse(chars, left, right);
        }
        return String.valueOf(chars);
    }
}
