package com.eric.solution.array;

/**
 * Description : 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 * <p>
 * 提示：
 * -> m == board.length
 * -> n = board[i].length
 * -> 1 <= m, n <= 6
 * -> 1 <= word.length <= 15
 * -> board 和 word 仅由大小写英文字母组成
 * <p>
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 *
 * @author Eric L SHU
 * @date 2023-01-15 17:50
 * @since jdk-11.0.14
 */
public class P0079WordSearch
{
    public boolean exist(char[][] board, String word)
    {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (dfs(board, i, j, word, 0))
                {
                    return true;
                }
            }
        }
        return false;
    }

    boolean[][] visited;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int m, n;

    private boolean dfs(char[][] board, int i, int j, String word, int k)
    {
        if (board[i][j] != word.charAt(k))
            return false;
        if (word.length() - 1 == k)
            return true;
        visited[i][j] = true;
        boolean res = false;
        for (int l = 0; l < 4; l++)
        {
            int x = i + dx[l], y = j + dy[l];
            if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y])
            {
                if (dfs(board, x, y, word, k + 1))
                {
                    res = true;
                    break;
                }
            }
        }
        visited[i][j] = false;
        return res;
    }
}
