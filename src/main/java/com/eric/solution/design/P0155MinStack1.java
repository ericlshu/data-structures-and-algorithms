package com.eric.solution.design;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description : 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * 实现 MinStack 类:
 * -> MinStack() 初始化堆栈对象。
 * -> void push(int val) 将元素val推入堆栈。
 * -> void pop() 删除堆栈顶部的元素。
 * -> int top() 获取堆栈顶部的元素。
 * -> int getMin() 获取堆栈中的最小元素。
 * <p>
 * 示例 1:
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * 提示：
 * -> -2^31 <= val <= 2^31 - 1
 * -> pop、top 和 getMin 操作总是在 非空栈 上调用
 * -> push, pop, top, and getMin最多被调用 3 * 104 次
 *
 * @author Eric L SHU
 * @date 2022-10-23 11:56 AM
 * @since jdk-11.0.14
 */
public class P0155MinStack1
{
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public P0155MinStack1()
    {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x)
    {
        stack.push(x);
        minStack.push(Math.min(x, minStack.peek()));
    }

    public void pop()
    {
        stack.pop();
        minStack.pop();
    }

    public int top()
    {
        return stack.peek();
    }

    public int getMin()
    {
        return minStack.peek();
    }
}
