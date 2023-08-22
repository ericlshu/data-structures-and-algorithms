package com.eric.solution.string;

/**
 * Description : 字母板上的路径
 * 我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。
 * 在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]，如下所示。
 * -> 我们可以按下面的指令规则行动：
 * -> 如果方格存在，'U' 意味着将我们的位置上移一行；
 * -> 如果方格存在，'D' 意味着将我们的位置下移一行；
 * -> 如果方格存在，'L' 意味着将我们的位置左移一列；
 * -> 如果方格存在，'R' 意味着将我们的位置右移一列；
 * -> '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。
 * -> （注意，字母板上只存在有字母的位置。）
 * 返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。
 * <p>
 * 示例 1：
 * 输入：target = "leet"
 * 输出："DDR!UURRR!!DDD!"
 * <p>
 * 示例 2：
 * 输入：target = "code"
 * 输出："RR!DDRR!UUL!R!"
 * <p>
 * 提示：
 * -> 1 <= target.length <= 100
 * -> target 仅含有小写英文字母。
 *
 * @author Eric L SHU
 * @date 2023-02-12 21:32
 * @since jdk-11.0.14
 */
public class P1138AlphabetBoardPath
{
    public String alphabetBoardPath(String target)
    {
        int n = target.length(), x0 = 0, y0 = 0, idx, x, y;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++)
        {
            idx = target.charAt(i) - 'a';
            x = idx / 5;
            y = idx % 5;
            while (x0 > x)
            {
                res.append("U");
                x0--;
            }
            while (y0 > y)
            {
                res.append("L");
                y0--;
            }
            while (x0 < x)
            {
                res.append("D");
                x0++;
            }
            while (y0 < y)
            {
                res.append("R");
                y0++;
            }
            res.append("!");
        }
        return res.toString();
    }
}
