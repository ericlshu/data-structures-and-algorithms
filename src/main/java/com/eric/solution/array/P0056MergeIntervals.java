package com.eric.solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Description : 合并区间
 * <p>
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2:
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 * <p>
 * 提示：
 * intervals[i][0] <= intervals[i][1]
 *
 * @author Eric L SHU
 * @date 2020-11-04 21:00
 * @since JDK 1.8
 */
public class P0056MergeIntervals
{
    public int[][] merge_1(int[][] intervals)
    {
        // if (intervals.length == 0) return new int[0][2];
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++)
        {
            int[] last = merged.get(merged.size() - 1);
            int[] curr = intervals[i];
            if (last[1] < curr[0])
                merged.add(curr);
            else
                last[1] = Math.max(last[1], curr[1]);
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public int[][] merge_2(int[][] intervals)
    {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] curr : intervals)
        {
            if (merged.size() == 0)
                merged.add(curr);
            else
            {
                int[] last = merged.get(merged.size() - 1);
                if (last[1] < curr[0])
                    merged.add(curr);
                else
                    last[1] = Math.max(last[1], curr[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
