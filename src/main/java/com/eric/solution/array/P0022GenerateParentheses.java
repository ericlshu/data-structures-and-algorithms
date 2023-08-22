package com.eric.solution.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Description : 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * 提示：
 * -> 1 <= n <= 8
 *
 * @author Eric L SHU
 * @date 2023-01-15 16:50
 * @since jdk-11.0.14
 */
public class P0022GenerateParentheses
{
    public List<String> generateParenthesis_1(int n)
    {
        List<String> res = new ArrayList<>();
        generate(res, new char[2 * n], 0);
        return res;
    }

    private void generate(List<String> res, char[] curr, int idx)
    {
        if (idx == curr.length)
        {
            if (valid(curr))
            {
                res.add(new String(curr));
            }
        }
        else
        {
            curr[idx] = '(';
            generate(res, curr, idx + 1);
            curr[idx] = ')';
            generate(res, curr, idx + 1);
        }
    }

    private boolean valid(char[] curr)
    {
        int balance = 0;
        for (char c : curr)
        {
            if (c == '(')
                balance++;
            else
                balance--;
            if (balance < 0)
                return false;
        }
        return balance == 0;
    }

    public List<String> generateParenthesis_2(int n)
    {
        List<String> res = new ArrayList<>();
        backtrack_1(res, new StringBuilder(), 0, 0, n);
        res.add("<==>");
        backtrack_2(res, new StringBuilder(), n, n);
        return res;
    }

    private void backtrack_1(List<String> res, StringBuilder curr, int open, int close, int n)
    {
        if (curr.length() == 2 * n)
        {
            res.add(new String(curr));
            return;
        }
        if (open < n)
        {
            curr.append('(');
            backtrack_1(res, curr, open + 1, close, n);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (close < open)
        {
            curr.append(')');
            backtrack_1(res, curr, open, close + 1, n);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    private void backtrack_2(List<String> res, StringBuilder curr, int left, int right)
    {
        if (left == 0 && right == 0)
        {
            res.add(new String(curr));
            return;
        }
        if (left > 0)
        {
            curr.append('(');
            backtrack_2(res, curr, left - 1, right);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (right > left)
        {
            curr.append(')');
            backtrack_2(res, curr, left, right - 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
