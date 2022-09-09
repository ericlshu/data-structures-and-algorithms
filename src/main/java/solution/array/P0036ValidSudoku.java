package solution.array;

import java.util.HashSet;
import java.util.Set;

/*
 * Description : 有效的数独
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 *
 * 注意：
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 *
 * 示例 1：
 *
 * 输入：board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：true
 *
 * 示例 2：
 * 输入：board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：false
 * 解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 *
 * 提示：
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字（1-9）或者 '.'
 *
 * @author Eric L SHU
 * @date 2022-09-09 19:49
 * @since jdk-11.0.14
 */
public class P0036ValidSudoku
{
    public boolean isValidSudoku_1(char[][] board)
    {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++)
        {
            Set<Character> setRow = new HashSet<>();
            Set<Character> setCol = new HashSet<>();
            for (int j = 0; j < cols; j++)
            {
                if (board[i][j] != '.' && !setRow.add(board[i][j]))
                    return false;

                if (board[j][i] != '.' && !setCol.add(board[j][i]))
                    return false;
            }
        }
        for (int rowStart = 0; rowStart < rows; rowStart += 3)
        {
            for (int colStart = 0; colStart < cols; colStart += 3)
            {
                int rowEnd = rowStart + 3;
                int colEnd = colStart + 3;
                Set<Character> set = new HashSet<>();
                for (int i = rowStart; i < rowEnd; i++)
                {
                    for (int j = colStart; j < colEnd; j++)
                    {
                        if (board[i][j] != '.' && !set.add(board[i][j]))
                            return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 二维数组 rows 和 cols 分别记录数独的每一行和每一列中的每个数字的出现次数
     * 三维数组 subBoxes 记录数独的每一个小九宫格中的每个数字的出现次数
     */
    public boolean isValidSudoku(char[][] board)
    {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][][] subBoxes = new int[3][3][9];
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                char c = board[i][j];
                if (c != '.')
                {
                    int index = c - '1';
                    rows[i][index]++;
                    cols[j][index]++;
                    subBoxes[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || cols[j][index] > 1 || subBoxes[i / 3][j / 3][index] > 1)
                        return false;
                }
            }
        }
        return true;
    }
}
