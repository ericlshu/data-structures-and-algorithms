package solution.array;

/**
 * Description : 重塑矩阵
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
 * 给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 * <p>
 * 示例 1：
 * 输入：mat = [[1,2],[3,4]], r = 1, c = 4
 * 输出：[[1,2,3,4]]
 * <p>
 * 示例 2：
 * 输入：mat = [[1,2],[3,4]], r = 2, c = 4
 * 输出：[[1,2],[3,4]]
 * <p>
 * 提示：
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * -1000 <= mat[i][j] <= 1000
 * 1 <= r, c <= 300
 *
 * @author Eric L SHU
 * @date 2022-09-08 20:28
 * @since jdk-11.0.14
 */
public class P0566ReshapeTheMatrix
{
    public int[][] matrixReshape(int[][] mat, int r, int c)
    {
        int count = mat.length * mat[0].length;
        if (count != r * c)
            return mat;

        int[][] result = new int[r][c];
        int matCol = mat[0].length;

        for (int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat[0].length; j++)
            {
                result[(i * matCol + j) / c][(i * matCol + j) % c] = mat[i][j];
            }
        }
        return result;
    }

    public int[][] matrixReshape_1(int[][] mat, int r, int c)
    {
        int count = mat.length * mat[0].length;
        if (count != r * c)
            return mat;

        int[][] result = new int[r][c];
        int matCol = mat[0].length;

        for (int i = 0; i < count; i++)
        {
            result[i / c][i % c] = mat[i / matCol][i % matCol];
        }
        return result;
    }
}
