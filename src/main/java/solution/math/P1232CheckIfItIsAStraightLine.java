package solution.math;

/**
 * Description : 缀点成线
 * 给定一个数组 coordinates ，其中 coordinates[i] = [x, y] ， [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上。
 * <p>
 * 示例 1：
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * 输出：false
 * <p>
 * 提示：
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates 中不含重复的点
 *
 * @author Eric L SHU
 * @date 2022-10-15 19:09
 * @since jdk-11.0.14
 */
public class P1232CheckIfItIsAStraightLine
{
    public boolean checkStraightLine(int[][] coordinates)
    {
        if (coordinates.length == 2) return true;
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int x1 = coordinates[1][0], y1 = coordinates[1][1];

        for (int i = 2; i < coordinates.length; i++)
        {
            int x = coordinates[i][0], y = coordinates[i][1];
            if ((x - x0) * (y - y1) != (x - x1) * (y - y0))
                return false;
        }
        return true;
    }
}
