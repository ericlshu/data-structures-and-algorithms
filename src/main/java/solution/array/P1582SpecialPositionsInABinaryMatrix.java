package solution.array;

/*
 * Description : 1582. 二进制矩阵中的特殊位置
 * 给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵 mat 中特殊位置的数目 。
 * 特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i, j) 被称为特殊位置。
 *
 * 示例 1：
 * 输入：mat = [[1,0,0],
 *             [0,0,1],
 *             [1,0,0]]
 * 输出：1
 * 解释：(1,2) 是一个特殊位置，因为 mat[1][2] == 1 且所处的行和列上所有其他元素都是 0
 *
 * 示例 2：
 * 输入：mat = [[1,0,0],
 *             [0,1,0],
 *             [0,0,1]]
 * 输出：3
 * 解释：(0,0), (1,1) 和 (2,2) 都是特殊位置
 *
 * 示例 3：
 * 输入：mat = [[0,0,0,1],
 *             [1,0,0,0],
 *             [0,1,1,0],
 *             [0,0,0,0]]
 * 输出：2
 *
 * 示例 4：
 * 输入：mat = [[0,0,0,0,0],
 *             [1,0,0,0,0],
 *             [0,1,0,0,0],
 *             [0,0,1,0,0],
 *             [0,0,0,1,1]]
 * 输出：3
 *
 * 提示：
 * rows == mat.length
 * cols == mat[i].length
 * 1 <= rows, cols <= 100
 * mat[i][j] 是 0 或 1
 *
 * @author Eric L SHU
 * @date 2022-09-04 11:49
 * @since jdk-11.0.14
 */
public class P1582SpecialPositionsInABinaryMatrix
{
    public int numSpecial_1(int[][] mat)
    {
        int rowCount = mat.length;
        int colCount = mat[0].length;

        int[] rowSum = new int[rowCount];
        int[] colSum = new int[colCount];

        for (int i = 0; i < rowCount; i++)
        {
            for (int j = 0; j < colCount; j++)
            {
                rowSum[i] += mat[i][j];
                colSum[j] += mat[i][j];
            }
        }

        int result = 0;

        for (int i = 0; i < rowCount; i++)
        {
            for (int j = 0; j < colCount; j++)
            {
                if (mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1)
                {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 列的标记值
     * 对于 (i,j)，它为特殊位置的条件为 mat[i][j]=1 且该行和该列中 1 的数量都为 1。
     * 据此，定义第 j 列的标记值为：该列所有 1 所在行中的 1 的数量之和。
     * (i,j) 为特殊位置的充要条件是，第 j 列的标记值恰好为 1：
     * 那么整个矩阵的特殊位置的数量就是最后标记值为 1 的列的数量。
     * 用原始矩阵的第一行来作为我们标记列的额外空间，从而使空间复杂度降至 O(1)。
     */
    public int numSpecial(int[][] mat)
    {
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++)
        {
            int count = 0;
            for (int j = 0; j < n; j++)
            {
                if (mat[i][j] == 1)
                {
                    count++;
                }
            }
            if (i == 0)
            {
                count--;
            }
            if (count > 0)
            {
                for (int j = 0; j < n; j++)
                {
                    if (mat[i][j] == 1)
                    {
                        mat[0][j] += count;
                    }
                }
            }
        }
        int sum = 0;
        for (int num : mat[0])
        {
            if (num == 1)
            {
                sum++;
            }
        }
        return sum;
    }
}
