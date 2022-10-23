package solution.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Description : 移除无效的括号
 * 给你一个由 '('、')' 和小写字母组成的字符串 s。
 * 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
 * 请返回任意一个合法字符串。
 * <p>
 * 有效「括号字符串」应当符合以下 任意一条 要求：
 * -> 空字符串或只包含小写字母的字符串
 * -> 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
 * -> 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
 * <p>
 * 示例 1：
 * 输入：s = "lee(t(c)o)de)"
 * 输出："lee(t(c)o)de"
 * 解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
 * <p>
 * 示例 2：
 * 输入：s = "a)b(c)d"
 * 输出："ab(c)d"
 * <p>
 * 示例 3：
 * 输入：s = "))(("
 * 输出：""
 * 解释：空字符串也是有效的
 * <p>
 * 提示：
 * -> 1 <= s.length <= 105
 * -> s[i] 可能是 '('、')' 或英文小写字母
 *
 * @author Eric L SHU
 * @date 2022-10-23 1:40 PM
 * @since jdk-11.0.14
 */
public class P1249MinimumRemoveToMakeValidParentheses
{
    public String minRemoveToMakeValid_1(String s)
    {
        Set<Integer> invalidIdx = new HashSet<>();
        Stack<Integer> bracket = new Stack<>();
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if (ch == '(')
                bracket.push(i);
            if (ch == ')')
            {
                if (bracket.isEmpty())
                    invalidIdx.add(i);
                else
                    bracket.pop();
            }
        }
        while (!bracket.isEmpty())
        {
            invalidIdx.add(bracket.pop());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
        {
            if (!invalidIdx.contains(i))
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public String minRemoveToMakeValid_2(String s)
    {
        int balance = 0;
        StringBuilder sb = new StringBuilder();
        // 删除多余的')'
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if (ch == '(')
            {
                balance++;
                sb.append(ch);
            }
            else if (ch == ')')
            {
                balance--;
                if (balance < 0)
                    balance = 0;
                else
                    sb.append(ch);
            }
            else
            {
                sb.append(ch);
            }
        }
        // 删除多余的'('
        for (int i = sb.length() - 1; balance > 0 && i >= 0; i--)
        {
            if (sb.charAt(i) == '(')
            {
                balance--;
                sb.deleteCharAt(i);
            }
        }
        return sb.toString();
    }

    public String minRemoveToMakeValid_3(String s)
    {
        StringBuilder res = removeInvalidClosing(s, '(', ')');
        res = removeInvalidClosing(res.reverse(), ')', '(');
        return res.reverse().toString();
    }

    private StringBuilder removeInvalidClosing(CharSequence string, char open, char close)
    {
        StringBuilder sb = new StringBuilder();
        int balance = 0;
        for (int i = 0; i < string.length(); i++)
        {
            char c = string.charAt(i);
            if (c == open)
                balance++;
            else if (c == close)
            {
                if (balance == 0)
                    continue;
                balance--;
            }
            sb.append(c);
        }
        return sb;
    }
}
