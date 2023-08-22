package com.eric.solution.design;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

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
public class P0155MinStack2
{
    Deque<Long> stack;
    private long min;

    public P0155MinStack2()
    {
        stack = new ArrayDeque<>();
    }

    public void push(int val)
    {
        if (stack.isEmpty())
        {
            min = val;
            stack.addFirst(0L);
            return;
        }
        stack.push((long) val - min);
        min = Math.min(val, min);
    }

    public void pop()
    {
        long pop = stack.pop();
        // 当弹出元素小于0时，说明弹出元素是当前栈中的最小值，要更新最小值
        if (pop < 0)
            min = min - pop;
        // 若大于等于0，不会对min有影响
    }

    public int top()
    {
        long peek = stack.peek();
        if (peek <= 0)
            // 若当前栈顶小于等于0，说明最小值就是栈顶元素
            return (int) min;
        else
            // 否则就是min+peek
            return (int) (min + peek);
    }

    public int getMin()
    {
        return (int) min;
    }
}
