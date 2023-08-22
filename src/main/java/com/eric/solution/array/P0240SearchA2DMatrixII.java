package com.eric.solution.array;

/**
 * Description : 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 * <p>
 * 提示：
 * -> m == matrix.length
 * -> n == matrix[i].length
 * -> 1 <= n, m <= 300
 * -> -109 <= matrix[i][j] <= 109
 * -> 每行的所有元素从左到右升序排列
 * -> 每列的所有元素从上到下升序排列
 * -> -109 <= target <= 109
 *
 * @author Eric L SHU
 * @date 2022-10-13 9:09 PM
 * @since jdk-11.0.14
 */
public class P0240SearchA2DMatrixII
{
    public boolean searchMatrix_1(int[][] matrix, int target)
    {
        for (int[] nums : matrix)
        {
            int idx = search(nums, target);
            if (idx >= 0)
                return true;
        }
        return false;
    }

    private int search(int[] nums, int target)
    {
        int left = 0, right = nums.length - 1;
        while (left <= right)
        {
            int mid = (left + right) >> 1;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left++;
            else
                right--;
        }
        return -1;
    }

    public boolean searchMatrix_2(int[][] matrix, int target)
    {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0)
        {
            if (matrix[x][y] == target)
                return true;
            else if (matrix[x][y] < target)
                x++;
            else
                y--;
        }
        return false;
    }
}
