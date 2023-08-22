package com.eric.solution.string;

import java.util.*;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2020-10-20 21:07
 * @since JDK 1.8
 */
public class P0020ValidParentheses
{
    public boolean isValid_1(String s)
    {
        while (s.contains("{}") || s.contains("()") || s.contains("[]"))
        {
            s = s.replace("{}", "");
            s = s.replace("[]", "");
            s = s.replace("()", "");
        }
        return "".equals(s);
    }

    public boolean isValid_2(String s)
    {
        if (s.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray())
        {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.empty() || c != stack.pop())
                return false;
        }
        return stack.empty();
    }

    public boolean isValid_3(String s)
    {
        int n = s.length();
        if (n % 2 == 1)
            return false;
        Map<Character, Character> pairs = new HashMap<Character, Character>()
        {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++)
        {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch))
            {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch))
                    return false;
                stack.pop();
            }
            else
                stack.push(ch);
        }
        return stack.isEmpty();
    }
}
