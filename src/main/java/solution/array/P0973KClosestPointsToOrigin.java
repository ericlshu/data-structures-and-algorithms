package solution.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description : 最接近原点的 K 个点
 * <p>
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * （这里，平面上两点之间的距离是欧几里德距离。）
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 * <p>
 * 示例 1：
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * <p>
 * 示例 2：
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 * <p>
 * 提示：
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 *
 * @author Eric L SHU
 * @date 2020-11-09 20:38
 * @since JDK 1.8
 */
public class P0973KClosestPointsToOrigin
{
    public int[][] kClosest_sort(int[][] points, int K)
    {
        // Arrays.sort(points, (o1, o2) ->
        //         (o1[0] * o1[0] + o1[1] * o1[1]) - (o2[0] * o2[0] + o2[1] * o2[1]));
        Arrays.sort(points, Comparator.comparingInt(o -> (o[0] * o[0] + o[1] * o[1])));
        return Arrays.copyOfRange(points, 0, K);
    }

    /**
     * 优先队列升序
     */
    public int[][] kClosest_pq1(int[][] points, int k)
    {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt((arr) -> arr[0] * arr[0] + arr[1] * arr[1]));
        for (int[] point : points)
        {
            pq.offer(point);
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++)
        {
            res[i] = pq.poll();
        }
        return res;
    }

    /**
     * 优先队列降序
     */
    public int[][] kClosest_pq2(int[][] points, int k)
    {
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) ->
                (arr2[0] * arr2[0] + arr2[1] * arr2[1]) - (arr1[0] * arr1[0] + arr1[1] * arr1[1]));
        for (int[] point : points)
        {
            pq.offer(point);
            if (pq.size() > k)
                pq.poll();
        }
        int[][] res = new int[k][2];
        // for (int i = 0; i < k; i++)
        // {
        //     res[i] = pq.poll();
        // }
        int idx = 0;
        while (!pq.isEmpty())
        {
            res[idx++] = pq.poll();
        }
        return res;
    }
}
