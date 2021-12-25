package solution.string;

import java.util.Stack;

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

    public boolean isValid(String s)
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
}
