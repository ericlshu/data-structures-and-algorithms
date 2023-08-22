package com.eric.solution.array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description : 图像渲染
 * 有一幅以 m x n 的二维整数数组表示的图画 image ，其中 image[i][j] 表示该图画的像素值大小。
 * 你也被给予三个整数 sr ,  sc 和 newColor 。你应该从像素 image[sr][sc] 开始对图像进行 上色填充 。
 * 为了完成 上色工作 ，从初始像素开始，记录初始坐标的 上下左右四个方向上 像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应 四个方向上 像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为 newColor 。
 * 最后返回 经过上色渲染后的图像 。
 * <p>
 * 示例 1:
 * 输入: image = [[1,1,1],[1,1,0],[1,0,1]]，sr = 1, sc = 1, newColor = 2
 * 输出: [[2,2,2],[2,2,0],[2,0,1]]
 * 解析: 在图像的正中间，(坐标(sr,sc)=(1,1)),在路径上所有符合条件的像素点的颜色都被更改成2。
 * 注意，右下角的像素没有更改为2，因为它不是在上下左右四个方向上与初始点相连的像素点。
 * <p>
 * 示例 2:
 * 输入: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
 * 输出: [[2,2,2],[2,2,2]]
 * <p>
 * 提示:
 * -> m == image.length
 * -> n == image[i].length
 * -> 1 <= m, n <= 50
 * -> 0 <= image[i][j], newColor < 216
 * -> 0 <= sr < m
 * -> 0 <= sc < n
 *
 * @author Eric L SHU
 * @date 2022-10-02 12:14
 * @since jdk-11.0.14
 */
public class P0733FloodFill
{
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int[][] floodFill_dfs_recursion(int[][] image, int sr, int sc, int color)
    {
        int currColor = image[sr][sc];
        if (currColor != color)
            dfs_1(image, sr, sc, currColor, color);
        return image;
    }

    private void dfs_1(int[][] image, int x, int y, int currColor, int newColor)
    {
        if (image[x][y] == currColor)
        {
            image[x][y] = newColor;
            for (int i = 0; i < 4; i++)
            {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < image.length && my >= 0 && my < image[0].length)
                    dfs_1(image, mx, my, currColor, newColor);
            }
        }
    }

    private void dfs_2(int[][] image, int sr, int sc, int newColor, int oldColor)
    {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length
                || image[sr][sc] != oldColor || newColor == oldColor)
            return;

        image[sr][sc] = newColor;

        dfs_2(image, sr - 1, sc, newColor, oldColor);
        dfs_2(image, sr + 1, sc, newColor, oldColor);
        dfs_2(image, sr, sc - 1, newColor, oldColor);
        dfs_2(image, sr, sc + 1, newColor, oldColor);

    }

    public int[][] floodFill_dfs_stack(int[][] image, int sr, int sc, int color)
    {
        int currColor = image[sr][sc];
        if (currColor == color)
            return image;
        image[sr][sc] = color;
        int row = image.length, col = image[0].length;
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{sr, sc});
        while (!stack.isEmpty())
        {
            int[] cell = stack.pop();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++)
            {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < row && my >= 0 && my < col && image[mx][my] == currColor)
                {
                    stack.push(new int[]{mx, my});
                    image[mx][my] = color;
                }
            }
        }
        return image;
    }

    public int[][] floodFill_bfs_queue(int[][] image, int sr, int sc, int color)
    {
        int currColor = image[sr][sc];
        if (currColor == color)
            return image;
        int row = image.length, col = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = color;
        while (!queue.isEmpty())
        {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++)
            {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < row && my >= 0 && my < col && image[mx][my] == currColor)
                {
                    queue.offer(new int[]{mx, my});
                    image[mx][my] = color;
                }
            }
        }
        return image;
    }
}
