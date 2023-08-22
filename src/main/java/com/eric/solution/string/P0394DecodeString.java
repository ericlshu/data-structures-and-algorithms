package com.eric.solution.string;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Description : 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * <p>
 * 示例 2：
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * <p>
 * 示例 3：
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * <p>
 * 示例 4：
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 * <p>
 * 提示：
 * -> 1 <= s.length <= 30
 * -> s 由小写英文字母、数字和方括号 '[]' 组成
 * -> s 保证是一个 有效 的输入。
 * -> s 中所有整数的取值范围为 [1, 300]
 *
 * @author Eric L SHU
 * @date 2022-10-23 7:22 PM
 * @since jdk-11.0.14
 */
public class P0394DecodeString
{
    public String decodeString_baoli(String s)
    {
        StringBuilder sb = new StringBuilder(s);
        while (sb.indexOf("]") > 0)
        {
            int end = sb.lastIndexOf("]");
            int start = 0;
            int idx = end - 1;
            while (idx >= 0)
            {
                if ('[' == sb.charAt(idx))
                {
                    start = idx--;
                    break;
                }
                else if (']' == sb.charAt(idx))
                    end = idx;
                idx--;
            }
            while (idx >= 0 && Character.isDigit(sb.charAt(idx)))
            {
                idx--;
            }
            idx++;
            int times = Integer.parseInt(sb.substring(idx, start));
            int len = end - start - 1;
            sb.deleteCharAt(end).delete(idx, start + 1);
            for (int i = 1; i < times; i++)
            {
                String sub = sb.substring(idx, idx + len);
                sb.insert(idx, sub);
            }
        }
        return sb.toString();
    }

    int idx;

    public String decodeString_stack(String s)
    {
        LinkedList<String> stack = new LinkedList<>();
        idx = 0;

        while (idx < s.length())
        {
            char cur = s.charAt(idx);
            if (Character.isDigit(cur))
            {
                // 获取一个数字并进栈
                String digits = getDigits(s);
                stack.addLast(digits);
            }
            else if (Character.isLetter(cur) || cur == '[')
            {
                // 获取一个字母并进栈
                stack.addLast(String.valueOf(s.charAt(idx++)));
            }
            else
            {
                ++idx;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stack.peekLast()))
                {
                    sub.addLast(stack.removeLast());
                }
                Collections.reverse(sub);
                // 左括号出栈
                stack.removeLast();
                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stack.removeLast());
                StringBuilder t = new StringBuilder();
                String o = getString(sub);
                // 构造字符串
                while (repTime-- > 0)
                {
                    t.append(o);
                }
                // 将构造好的字符串入栈
                stack.addLast(t.toString());
            }
        }
        return getString(stack);
    }

    private String getDigits(String s)
    {
        StringBuilder ret = new StringBuilder();
        while (Character.isDigit(s.charAt(idx)))
        {
            ret.append(s.charAt(idx++));
        }
        return ret.toString();
    }

    private String getString(LinkedList<String> v)
    {
        StringBuilder ret = new StringBuilder();
        for (String s : v)
        {
            ret.append(s);
        }
        return ret.toString();
    }
}
