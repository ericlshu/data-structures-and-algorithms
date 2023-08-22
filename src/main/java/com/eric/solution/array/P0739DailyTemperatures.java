package com.eric.solution.array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Description : 每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * <p>
 * 示例 2:
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * <p>
 * 示例 3:
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * <p>
 * 提示：
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 *
 * @author Eric L SHU
 * @date 2022-10-15 19:05
 * @since jdk-11.0.14
 */
public class P0739DailyTemperatures
{
    public int[] dailyTemperatures_reverse(int[] temperatures)
    {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--)
        {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()])
            {
                stack.pop();
            }
            if (!stack.isEmpty())
                res[i] = stack.peek() - i;
            stack.push(i);
        }
        return res;
    }

    public int[] dailyTemperatures_forward(int[] temperatures)
    {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
        {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()])
            {
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }
        return res;
    }
}
