package solution.array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Description : 表现良好的最长时间段
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 * 请你返回「表现良好时间段」的最大长度。
 * <p>
 * 示例 1：
 * 输入：hours = [9,9,6,0,6,6,9]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 * <p>
 * 示例 2：
 * 输入：hours = [6,6,6]
 * 输出：0
 * <p>
 * 提示：
 * -> 1 <= hours.length <= 104
 * -> 0 <= hours[i] <= 16
 *
 * @author Eric L SHU
 * @date 2023-02-14 21:51
 * @since jdk-11.0.14
 */
public class P1124LongestWellPerformingInterval
{
    public int longestWPI_hash(int[] hours)
    {
        int n = hours.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, res = 0;
        for (int i = 0; i < n; i++)
        {
            sum += hours[i] > 8 ? 1 : -1;
            if (sum > 0)
            {
                res = Math.max(res, i + 1);
            }
            else
            {
                if (map.containsKey(sum - 1))
                {
                    res = Math.max(res, i - map.get(sum - 1));
                }
            }
            if (!map.containsKey(sum))
            {
                map.put(sum, i);
            }
        }
        return res;
    }

    public int longestWPI_queue(int[] hours)
    {
        int n = hours.length;
        int[] s = new int[n + 1];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i <= n; i++)
        {
            s[i] = s[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
            if (s[stack.peek()] > s[i])
            {
                stack.push(i);
            }
        }
        int res = 0;
        for (int r = n; r >= 1; r--)
        {
            while (!stack.isEmpty() && s[stack.peek()] < s[r])
            {
                res = Math.max(res, r - stack.pop());
            }
        }
        return res;
    }
}
