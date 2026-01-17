package com.shl;

import java.util.*;

/**
 * Description :
 * Ethan 是一个有 N 名成员的团队的领导。他给每个成员分配了一个初始错误分数，表示他们在团队中的贡献的缺陷数量。错误分数变得异常高，为了提高团队的声誉，他希望将所有成员的错误分数减少到零。
 * Ethan 制定了一个规则：每当团队成功完成一个项目时，成员的错误分数会减少一个固定的数量 compP，同时，其他所有成员的错误分数（大于零的）会减少一个较小的固定数量 othQ。
 * 编写一个算法，帮助 Ethan 计算团队需要完成的最少项目数，使得所有成员的错误分数都变为零。如果不需要完成项目，则输出 0。
 * <p>
 * 输入格式
 * 输入的第一行包含一个整数 errorScore_size，表示错误分数的数量（即团队成员数）。
 * 第二行包含 errorScore_size 个空格分隔的整数，表示初始错误分数。
 * 第三行包含一个整数 compP，表示完成项目后完成该项目的成员错误分数减少的值。
 * 第四行包含一个整数 othQ，表示完成项目后其他成员错误分数减少的值。
 * <p>
 * 输出格式
 * 输出一个整数，表示团队需要完成的最少项目数。
 * <p>
 * 示例
 * 输入：
 * 3
 * 6 4 1
 * 4
 * 1
 * <p>
 * 输出：
 * 3
 * <p>
 * 解释：
 * 首次项目完成后，成员的错误分数分别变为：(2, 3, 1)
 * 第二次项目完成后，错误分数变为：(0, 2, 0)
 * 第三次项目完成后，错误分数变为：(0, 0, 0)
 * 总共完成了 3 个项目。
 *
 * @author Eric L SHU
 * @date 2026-01-13 18:52
 */
public class EthanIsTheLeaderOfATeam
{
    public static int minProject(int[] errorScore, int compP, int othQ)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int score : errorScore)
        {
            pq.offer(score);
        }

        int projects = 0;
        while (!pq.isEmpty() && pq.peek() > 0)
        {
            int maxScore = pq.poll() - compP; // 当前最大分数减少 compP
            List<Integer> temp = new ArrayList<>();

            while (!pq.isEmpty())
            {
                int otherScore = pq.poll();
                otherScore = Math.max(0, otherScore - othQ); // 其他分数减少 othQ
                temp.add(otherScore);
            }

            // 将修改后的分数重新加入队列
            if (maxScore > 0) pq.offer(maxScore);
            for (int score : temp)
            {
                if (score > 0) pq.offer(score);
            }

            projects++;
        }

        return projects;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int errorScore_size = in.nextInt();
        int[] errorScore = new int[errorScore_size];
        for (int i = 0; i < errorScore_size; i++)
        {
            errorScore[i] = in.nextInt();
        }

        int compP = in.nextInt();
        int othQ = in.nextInt();

        int result = minProject(errorScore, compP, othQ);
        System.out.println(result);
    }
}
