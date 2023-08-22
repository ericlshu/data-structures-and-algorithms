package com.eric.solution.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Description : 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 提示：
 * -> m == matrix.length
 * -> n == matrix[i].length
 * -> 1 <= m, n <= 10
 * -> -100 <= matrix[i][j] <= 100
 *
 * @author Eric L SHU
 * @date 2022-12-08 15:03
 * @since jdk-11.0.14
 */
public class P0054SpiralMatrix
{
    public List<Integer> spiralOrder_1(int[][] matrix)
    {
        ArrayList<Integer> list = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right)
        {
            for (int i = left; i <= right; i++)
            {
                list.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++)
            {
                list.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom && left <= right)
            {
                for (int i = right; i >= left; i--)
                {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
                for (int i = bottom; i >= top; i--)
                {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
    }

    public List<Integer> spiralOrder_2(int[][] matrix)
    {
        List<Integer> order = new ArrayList<>();
        int rows = matrix.length, cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int total = rows * cols;
        int row = 0, col = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirIdx = 0;
        for (int i = 0; i < total; i++)
        {
            order.add(matrix[row][col]);
            visited[row][col] = true;
            int _row = row + dirs[dirIdx][0], _col = col + dirs[dirIdx][1];
            if (_row < 0 || _row >= rows || _col < 0 || _col >= cols || visited[_row][_col])
            {
                dirIdx = (dirIdx + 1) % 4;
            }
            row += dirs[dirIdx][0];
            col += dirs[dirIdx][1];
        }
        return order;
    }

    public List<Integer> spiralOrder_3(int[][] matrix)
    {
        ArrayList<Integer> list = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        int count = matrix.length * matrix[0].length;
        while (count >= 1)
        {
            for (int i = left; i <= right && count >= 1; i++)
            {
                list.add(matrix[top][i]);
                count--;
            }
            top++;
            for (int i = top; i <= bottom && count >= 1; i++)
            {
                list.add(matrix[i][right]);
                count--;
            }
            right--;
            for (int i = right; i >= left && count >= 1; i--)
            {
                list.add(matrix[bottom][i]);
                count--;
            }
            bottom--;
            for (int i = bottom; i >= top && count >= 1; i--)
            {
                list.add(matrix[i][left]);
                count--;
            }
            left++;
        }
        return list;
    }

}
