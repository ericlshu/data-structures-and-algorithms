package com.eric.solution.array;

/**
 * Description : 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 *
 * @author Eric L SHU
 * @date 2022-09-19 9:31 PM
 * @since jdk-11.0.14
 */
public class P0074SearchA2DMatrix
{
    public boolean searchMatrix_1(int[][] matrix, int target)
    {
        int row = bsFirstColumn(matrix, target);
        if (row < 0)
            return false;
        return bsRow(matrix[row], target);
    }

    private int bsFirstColumn(int[][] matrix, int target)
    {
        int low = 0, high = matrix.length - 1, mid;
        while (low < high)
        {
            // int mid = (high - low + 1) / 2 + low;
            mid = (high + low + 1) >> 1;
            if (matrix[mid][0] <= target)
                low = mid;
            else
                high = mid - 1;
        }
        return low;
    }

    private boolean bsRow(int[] row, int target)
    {
        int low = 0, high = row.length - 1;
        while (low <= high)
        {
            int mid = (high + low) >> 1;
            if (row[mid] == target)
                return true;
            else if (row[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }

    public boolean searchMatrix_2(int[][] matrix, int target)
    {
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = rows * cols - 1;
        while (left <= right)
        {
            int mid = (left + right) >> 1;
            int x = matrix[mid / cols][mid % cols];
            if (x == target)
                return true;
            else if (x > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }
}
