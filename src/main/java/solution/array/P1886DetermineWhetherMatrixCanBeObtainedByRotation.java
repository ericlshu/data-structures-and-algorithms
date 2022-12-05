package solution.array;

import java.util.Arrays;

/**
 * Description : 判断矩阵经轮转后是否一致
 * 给你两个大小为 n x n 的二进制矩阵 mat 和 target 。
 * 现 以 90 度顺时针轮转 矩阵 mat 中的元素 若干次 ，如果能够使 mat 与 target 一致，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
 * 输出：true
 * 解释：顺时针轮转 90 度一次可以使 mat 和 target 一致。
 * <p>
 * 示例 2：
 * 输入：mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
 * 输出：false
 * 解释：无法通过轮转矩阵中的元素使 equal 与 target 一致。
 * <p>
 * 示例 3：
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
 * 输出：true
 * 解释：顺时针轮转 90 度两次可以使 mat 和 target 一致。
 * <p>
 * 提示：
 * -> n == mat.length == target.length
 * -> n == mat[i].length == target[i].length
 * -> 1 <= n <= 10
 * -> mat[i][j] 和 target[i][j] 不是 0 就是 1
 *
 * @author Eric L SHU
 * @date 2022-12-05 10:18
 * @since jdk-11.0.14
 */
public class P1886DetermineWhetherMatrixCanBeObtainedByRotation
{
    public boolean findRotation_1(int[][] mat, int[][] target)
    {
        if (Arrays.deepEquals(mat, target))
            return true;
        int n = mat.length;
        for (int k = 0; k < 3; k++)
        {
            for (int i = 0; i < n / 2; ++i)
            {
                for (int j = 0; j < (n + 1) / 2; ++j)
                {
                    int temp = mat[i][j];
                    mat[i][j] = mat[n - j - 1][i];
                    mat[n - j - 1][i] = mat[n - i - 1][n - j - 1];
                    mat[n - i - 1][n - j - 1] = mat[j][n - i - 1];
                    mat[j][n - i - 1] = temp;
                }
            }
            if (Arrays.deepEquals(mat, target))
                return true;
        }
        return false;
    }

    public boolean findRotation_2(int[][] mat, int[][] target)
    {
        return isSameMatrix(mat, target) ||
                isSameMatrix(mat, matrixRotation(target)) ||
                isSameMatrix(mat, matrixRotation(matrixRotation(target))) ||
                isSameMatrix(mat, matrixRotation(matrixRotation(matrixRotation(target))));
    }

    private boolean isSameMatrix(int[][] a, int[][] b)
    {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a.length; j++)
            {
                if (a[i][j] != b[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }

    private int[][] matrixRotation(int mat[][])
    {
        int res[][] = new int[mat.length][mat.length];
        for (int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat.length; j++)
            {
                res[j][mat.length - 1 - i] = mat[i][j];
            }
        }
        return res;
    }
}
