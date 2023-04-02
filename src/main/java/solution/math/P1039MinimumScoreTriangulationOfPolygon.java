package solution.math;

import java.util.HashMap;
import java.util.Map;

/**
 * Description : 多边形三角剖分的最低得分
 * 你有一个凸的 n 边形，其每个顶点都有一个整数值。给定一个整数数组 values ，其中 values[i] 是第 i 个顶点的值（即 顺时针顺序 ）。
 * 假设将多边形 剖分 为 n - 2 个三角形。对于每个三角形，该三角形的值是顶点标记的乘积，三角剖分的分数是进行三角剖分后所有 n - 2 个三角形的值之和。
 * 返回 多边形进行三角剖分后可以得到的最低分 。
 * <p>
 * 示例 1：
 * 输入：values = [1,2,3]
 * 输出：6
 * 解释：多边形已经三角化，唯一三角形的分数为 6。
 * <p>
 * 示例 2：
 * 输入：values = [3,7,4,5]
 * 输出：144
 * 解释：有两种三角剖分，可能得分分别为：3*7*5 + 4*5*7 = 245，或 3*4*5 + 3*4*7 = 144。最低分数为 144。
 * <p>
 * 示例 3：
 * 输入：values = [1,3,1,4,1,5]
 * 输出：13
 * 解释：最低分数三角剖分的得分情况为 1*1*3 + 1*1*4 + 1*1*5 + 1*1*1 = 13。
 * <p>
 * 提示：
 * -> n == values.length
 * -> 3 <= n <= 50
 * -> 1 <= values[i] <= 100
 *
 * @author Eric L SHU
 * @date 2023-04-02 17:13
 * @since jdk-11.0.14
 */
public class P1039MinimumScoreTriangulationOfPolygon
{
    public int minScoreTriangulation(int[] values)
    {
        this.n = values.length;
        this.arr = values;
        return dp(0, n - 1);
    }

    int n;
    int[] arr;
    Map<Integer, Integer> memo = new HashMap<>();

    public int dp(int i, int j)
    {
        if (i + 2 > j)
            return 0;
        if (i + 2 == j)
            return arr[i] * arr[i + 1] * arr[j];
        int key = i * n + j;
        if (!memo.containsKey(key))
        {
            int minScore = Integer.MAX_VALUE;
            for (int k = i + 1; k < j; k++)
            {
                minScore = Math.min(minScore, arr[i] * arr[k] * arr[j] + dp(i, k) + dp(k, j));
            }
            memo.put(key, minScore);
        }
        return memo.get(key);
    }
}
