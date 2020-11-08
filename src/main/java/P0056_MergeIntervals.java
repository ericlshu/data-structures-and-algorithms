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
public class P0056_MergeIntervals
{
    public int[][] merge(int[][] intervals)
    {
        if (intervals.length == 0) return new int[0][2];
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        /*for (int i = 1; i < intervals.length; i++)
        {
            int[] last = merged.get(merged.size() - 1);
            int left = intervals[i][0], right = intervals[i][1];
            if(last[1] < left)
                merged.add(intervals[i]);
            else
                last[1] = Math.max(last[1], right);
        }*/
        for (int[] interval : intervals)
        {
            if (merged.size() == 0)
                merged.add(interval);
            else
            {
                int[] last = merged.get(merged.size() - 1);
                int left = interval[0], right = interval[1];
                if(last[1] < left)
                    merged.add(new int[]{left, right});
                else
                    last[1] = Math.max(last[1], right);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
