package com.eric.solution.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description : 查找用户活跃分钟数
 * 给你用户在 LeetCode 的操作日志，和一个整数 k 。日志用一个二维整数数组 logs 表示，其中每个 logs[i] = [IDi, timei] 表示 ID 为 IDi 的用户在 timei 分钟时执行了某个操作。
 * 多个用户 可以同时执行操作，单个用户可以在同一分钟内执行 多个操作 。
 * 指定用户的 用户活跃分钟数（user active minutes，UAM） 定义为用户对 LeetCode 执行操作的 唯一分钟数 。 即使一分钟内执行多个操作，也只能按一分钟计数。
 * 请你统计用户活跃分钟数的分布情况，统计结果是一个长度为 k 且 下标从 1 开始计数 的数组 answer ，对于每个 j（1 <= j <= k），answer[j] 表示 用户活跃分钟数 等于 j 的用户数。
 * 返回上面描述的答案数组 answer 。
 * <p>
 * 示例 1：
 * 输入：logs = [[0,5],[1,2],[0,2],[0,5],[1,3]], k = 5
 * 输出：[0,2,0,0,0]
 * 解释：
 * ID=0 的用户执行操作的分钟分别是：5 、2 和 5 。因此，该用户的用户活跃分钟数为 2（分钟 5 只计数一次）
 * ID=1 的用户执行操作的分钟分别是：2 和 3 。因此，该用户的用户活跃分钟数为 2
 * 2 个用户的用户活跃分钟数都是 2 ，answer[2] 为 2 ，其余 answer[j] 的值都是 0
 * <p>
 * 示例 2：
 * 输入：logs = [[1,1],[2,2],[2,3]], k = 4
 * 输出：[1,1,0,0]
 * 解释：
 * ID=1 的用户仅在分钟 1 执行单个操作。因此，该用户的用户活跃分钟数为 1
 * ID=2 的用户执行操作的分钟分别是：2 和 3 。因此，该用户的用户活跃分钟数为 2
 * 1 个用户的用户活跃分钟数是 1 ，1 个用户的用户活跃分钟数是 2
 * 因此，answer[1] = 1 ，answer[2] = 1 ，其余的值都是 0
 * <p>
 * 提示：
 * -> 1 <= logs.length <= 104
 * -> 0 <= IDi <= 109
 * -> 1 <= timei <= 105
 * -> k 的取值范围是 [用户的最大用户活跃分钟数, 105]
 *
 * @author Eric L SHU
 * @date 2023-01-20 20:53
 * @since jdk-11.0.14
 */
public class P1817FindingTheUsersActiveMinutes
{
    public int[] findingUsersActiveMinutes(int[][] logs, int k)
    {
        Map<Integer, Set<Integer>> activeMinutes = new HashMap<>();
        for (int[] log : logs)
        {
            int id = log[0], time = log[1];
            activeMinutes.putIfAbsent(id, new HashSet<>());
            activeMinutes.get(id).add(time);
        }
        int[] res = new int[k];
        for (Set<Integer> minutes : activeMinutes.values())
        {
            res[minutes.size() - 1]++;
        }
        return res;
    }
}
