package solution.array;

/**
 * Description : 统计有序矩阵中的负数
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 请你统计并返回 grid 中 负数 的数目。
 * <p>
 * 示例 1：
 * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * 输出：8
 * 解释：矩阵中共有 8 个负数。
 * <p>
 * 示例 2：
 * 输入：grid = [[3,2],[1,0]]
 * 输出：0
 * <p>
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(n + m) 的解决方案吗？
 *
 * @author Eric L SHU
 * @date 2022-09-19 8:02 PM
 * @since jdk-11.0.14
 */
public class P1351CountNegativeNumbersInASortedMatrix
{
    public int countNegatives_1(int[][] grid)
    {
        int count = 0;
        for (int[] arr : grid)
        {
            int left = 0, right = arr.length - 1, index = -1;
            while (left <= right)
            {
                int mid = (left + right) >> 1;
                if (arr[mid] >= 0)
                {
                    left = mid + 1;
                }
                else
                {
                    index = mid;
                    right = mid - 1;
                }
            }
            if (index >= 0)
                count += arr.length - index;
        }
        return count;
    }

    public int countNegatives_2(int[][] grid)
    {
        return solve(0, grid.length - 1, 0, grid[0].length - 1, grid);
    }

    private int solve(int rowStart, int rowEnd, int colStart, int colEnd, int[][] grid)
    {
        if (rowStart > rowEnd) return 0;
        int pos = -1, mid = (rowEnd + rowStart) >> 1;
        for (int i = colStart; i <= colEnd; ++i)
        {
            if (grid[mid][i] < 0)
            {
                pos = i;
                break;
            }
        }
        int ans = 0;
        if (pos >= 0)
        {
            // 第mid行pos及其后的元素均小于0
            ans += grid[0].length - pos;
            // 查找grid[mid][pos]右上方的矩阵
            ans += solve(rowStart, mid - 1, pos, colEnd, grid);
            // 查找grid[mid][pos]左下方的矩阵
            ans += solve(mid + 1, rowEnd, colStart, pos, grid);
        }
        else
        {
            // 查找grid[mid][pos]左下方的矩阵
            ans += solve(mid + 1, rowEnd, colStart, colEnd, grid);
        }
        return ans;
    }

    public int countNegatives(int[][] grid)
    {
        int count = 0;
        int row = 0, col = grid[0].length - 1;
        while (row < grid.length && col >= 0)
        {
            if (grid[row][col] >= 0)
            {
                row++;
            }
            else
            {
                count += grid.length - row;
                col--;
            }
        }
        return count;
    }
}
