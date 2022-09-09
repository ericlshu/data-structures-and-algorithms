package solution.array;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2022-09-09 20:37
 * @since jdk-11.0.14
 */
public class P0073SetMatrixZeroes
{
    public void setZeroes_1(int[][] matrix)
    {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[] row = new boolean[rows];
        boolean[] col = new boolean[cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (matrix[i][j] == 0)
                    row[i] = col[j] = true;

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (row[i] || col[j])
                    matrix[i][j] = 0;
    }

    /**
     * 我们可以用矩阵的第一行和第一列代替方法一中的两个标记数组，以达到 O(1)O(1) 的额外空间。
     * 需要额外使用两个标记变量分别记录第一行和第一列是否原本包含 0。
     */
    public void setZeroes_2(int[][] matrix)
    {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;

        // 1. 首先预处理出两个标记变量；
        for (int[] ints : matrix)
        {
            if (ints[0] == 0)
            {
                flagCol0 = true;
                break;
            }
        }
        for (int j = 0; j < n; j++)
        {
            if (matrix[0][j] == 0)
            {
                flagRow0 = true;
                break;
            }
        }

        // 2. 接着使用其他行与列去处理第一行与第一列；
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;

        // 3. 然后反过来使用第一行与第一列去更新其他行与列；
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;

        // 4. 最后使用两个标记变量更新第一行与第一列即可；
        if (flagCol0)
            for (int i = 0; i < m; i++)
                matrix[i][0] = 0;
        if (flagRow0)
            for (int j = 0; j < n; j++)
                matrix[0][j] = 0;
    }

    /**
     * 只使用一个标记变量记录第一列是否原本存在 0；
     * 第一列的第一个元素即可以标记第一行是否出现 0；
     * 为了防止每一列的第一个元素被提前更新，我们需要从最后一行开始，倒序地处理矩阵元素；
     */
    public void setZeroes_3(int[][] matrix)
    {
        int rows = matrix.length, cols = matrix[0].length;
        boolean flagCol0 = false;
        for (int i = 0; i < rows; i++)
        {
            if (matrix[i][0] == 0)
                flagCol0 = true;
            for (int j = 1; j < cols; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }
        for (int i = rows - 1; i >= 0; i--)
        {
            for (int j = 1; j < cols; j++)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (flagCol0)
                matrix[i][0] = 0;
        }
    }
}
