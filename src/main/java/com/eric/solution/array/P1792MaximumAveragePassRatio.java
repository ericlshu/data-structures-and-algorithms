package com.eric.solution.array;

import java.util.PriorityQueue;

/**
 * Description : 最大平均通过率
 * 一所学校里有一些班级，每个班级里有一些学生，现在每个班都会进行一场期末考试。
 * 给你一个二维数组 classes ，其中 classes[i] = [passi, totali] ，表示你提前知道了第 i 个班级总共有 totali 个学生，其中只有 passi 个学生可以通过考试。
 * 给你一个整数 extraStudents ，表示额外有 extraStudents 个聪明的学生，他们 一定 能通过任何班级的期末考。你需要给这 extraStudents 个学生每人都安排一个班级，使得 所有 班级的 平均 通过率 最大 。
 * 一个班级的 通过率 等于这个班级通过考试的学生人数除以这个班级的总人数。平均通过率 是所有班级的通过率之和除以班级数目。
 * 请你返回在安排这 extraStudents 个学生去对应班级后的 最大 平均通过率。与标准答案误差范围在 10^-5 以内的结果都会视为正确结果。
 * <p>
 * 示例 1：
 * 输入：classes = [[1,2],[3,5],[2,2]], extraStudents = 2
 * 输出：0.78333
 * 解释：你可以将额外的两个学生都安排到第一个班级，平均通过率为 (3/4 + 3/5 + 2/2) / 3 = 0.78333 。
 * <p>
 * 示例 2：
 * 输入：classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
 * 输出：0.53485
 * <p>
 * 提示：
 * -> 1 <= classes.length <= 105
 * -> classes[i].length == 2
 * -> 1 <= passi <= totali <= 105
 * -> 1 <= extraStudents <= 105
 *
 * @author Eric L SHU
 * @date 2023-02-19 15:05
 * @since jdk-11.0.14
 */
public class P1792MaximumAveragePassRatio
{
    public double maxAverageRatio(int[][] classes, int extraStudents)
    {
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) ->
                Long.compare(
                        (long) (arr1[1] + 1) * arr1[1] * (arr2[1] - arr2[0]),
                        (long) (arr2[1] + 1) * arr2[1] * (arr1[1] - arr1[0])
                ));
        for (int[] c : classes)
        {
            pq.offer(new int[]{c[0], c[1]});
        }
        for (int i = 0; i < extraStudents; i++)
        {
            int[] arr = pq.poll();
            assert arr != null;
            pq.offer(new int[]{arr[0] + 1, arr[1] + 1});
        }
        double res = 0;
        while (!pq.isEmpty())
        {
            int[] arr = pq.poll();
            res += 1.0 * arr[0] / arr[1];
        }
        return res / classes.length;
    }
}
