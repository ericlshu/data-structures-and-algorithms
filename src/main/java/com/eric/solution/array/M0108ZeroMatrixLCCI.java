package com.eric.solution.array;

/**
 * Description : 面试题 01.08. 零矩阵
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 * 示例 1：
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 * 示例 2：
 * 输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 * @author Eric L SHU
 * @date 2022-09-30 8:23 PM
 * @since jdk-11.0.14
 */
public class M0108ZeroMatrixLCCI
{
    public void setZeroes_1(int[][] matrix)
    {
        int rowCnt = matrix.length;
        int colCnt = matrix[0].length;
        int[] rowFlag = new int[rowCnt];
        int[] colFlag = new int[colCnt];

        for (int i = 0; i < rowCnt; i++)
            for (int j = 0; j < colCnt; j++)
                if (matrix[i][j] == 0)
                    rowFlag[i] = colFlag[j] = 1;

        for (int i = 0; i < rowCnt; i++)
            for (int j = 0; j < colCnt; j++)
                if (rowFlag[i] == 1 || colFlag[j] == 1)
                    matrix[i][j] = 0;
    }

    public void setZeroes_2(int[][] matrix)
    {
        int rowCnt = matrix.length;
        int colCnt = matrix[0].length;
        boolean row0Flag = false;
        boolean col0Flag = false;

        for (int i = 0; i < colCnt; i++)
            if (matrix[0][i] == 0)
            {
                row0Flag = true;
                break;
            }

        for (int[] ints : matrix)
            if (ints[0] == 0)
            {
                col0Flag = true;
                break;
            }

        for (int i = 0; i < rowCnt; i++)
            for (int j = 0; j < colCnt; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;

        for (int i = 1; i < rowCnt; i++)
            for (int j = 1; j < colCnt; j++)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;

        if (row0Flag)
            for (int i = 0; i < colCnt; i++)
                matrix[0][i] = 0;

        if (col0Flag)
            for (int i = 0; i < rowCnt; i++)
                matrix[i][0] = 0;
    }

    public void setZeroes_3(int[][] matrix)
    {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false;
        for (int i = 0; i < m; i++)
        {
            if (matrix[i][0] == 0)
                flagCol0 = true;
            for (int j = 1; j < n; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }
        for (int i = m - 1; i >= 0; i--)
        {
            for (int j = 1; j < n; j++)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (flagCol0)
                matrix[i][0] = 0;
        }
    }
}
