package com.eric.solution.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>Copyright (c) 2024 Authors. All rights reserved.
 *
 * <p>Project: data-structures-and-algorithms
 * <p>Created By : Eric L SHU
 * <p>Created On : 2024-03-05 21:30:20
 * <p>
 * Description : 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * 提示：
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 *
 * @version 1.0
 * @since jdk-17
 */
public class P0042TrappingRainWater
{
    public static int trap1(int[] heights)
    {
        int res = 0;
        LinkedList<Bar> stack = new LinkedList<>();
        for (int i = 0; i < heights.length; i++)
        {
            Bar right = new Bar(heights[i], i);
            while (!stack.isEmpty() && stack.peek().h < right.h)
            {
                Bar pop = stack.pop();
                Bar left = stack.peek();
                if (left != null)
                {
                    int width = right.i - left.i - 1;
                    int height = Integer.min(left.h, right.h) - pop.h;
                    res += width * height;
                }
            }
            stack.push(right);
        }
        return res;
    }

    public static int trap2(int[] height)
    {
        int res = 0;
        // LinkedList<int[]> stack = new LinkedList<>();
        // for (int i = 0; i < heights.length; i++)
        // {
        //     int[] right = new int[]{heights[i], i};
        //     while (!stack.isEmpty() && stack.peek()[0] < right[0])
        //     {
        //         int[] pop = stack.pop();
        //         int[] left = stack.peek();
        //         if (left != null)
        //         {
        //             int width = right[1] - left[1] - 1;
        //             int height = Integer.min(left[0], right[0]) - pop[0];
        //             res += width * height;
        //         }
        //     }
        //     stack.push(right);
        // }
        Deque<Integer> stack = new LinkedList<>();
        for (int r = 0; r < height.length; r++)
        {
            while (!stack.isEmpty() && height[r] > height[stack.peek()])
            {
                Integer p = stack.pop();
                Integer l = stack.peek();
                if (l != null)
                {
                    int w = r - l - 1;
                    int h = Integer.min(height[l], height[r]) - height[p];
                    res += w * h;
                }
            }
            stack.push(r);
        }
        return res;
    }

    static class Bar
    {
        int h; // 高度
        int i; // 索引

        public Bar(int h, int i)
        {
            this.h = h;
            this.i = i;
        }
    }
}
