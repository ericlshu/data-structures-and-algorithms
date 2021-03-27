package solution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description : 移掉K位数字
 * <p>
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * <p>
 * 示例 1 :
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * <p>
 * 示例 2 :
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * <p>
 * 示例 3 :
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 * <p>
 * 注意:
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 *
 * @author Eric L SHU
 * @date 2020-11-15 20:39
 * @since JDK 1.8
 */
public class P0402_RemoveKDigits
{
    public String removeKDigits(String num, int k)
    {
        if (num.length() == k) return "0";
        for (int i = 0; i < k; i++)
        {
            num = this.removeOneDigit(num);
        }
        return num;
    }

    private String removeOneDigit(String num)
    {
        if (num.length() == 1) return "0";
        String result = num;
        String temp;
        for (int i = 0; i < num.length(); i++)
        {
            temp = num.replaceFirst(num.substring(i, i + 1), "");

            while (temp.length() > 0 && temp.charAt(0) == '0')
            {
                temp = temp.replaceFirst("0", "");
            }

            if (temp.length() > result.length())
                continue;

            if (temp.length() < result.length() || temp.compareTo(result) < 0)
                result = temp;
        }
        return result.length() > 0 ? result : "0";
    }

    public String removeKdigits(String num, int k)
    {
        Deque<Character> deque = new LinkedList<>();
        int length = num.length();
        for (int i = 0; i < length; i++)
        {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit)
            {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }
        for (int i = 0; i < k; ++i)
        {
            deque.pollLast();
        }
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty())
        {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0')
                continue;
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }
}
