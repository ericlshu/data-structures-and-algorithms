package com.eric.solution.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Description : 划分字母区间
 * <p>
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 示例 1：
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * <p>
 * 提示：
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 *
 * @author Eric L SHU
 * @date 2020-10-22 21:24
 * @since JDK 1.8
 */
public class P0763PartitionLabels
{
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int len = s.length();
        // 遍历字符串，得到每个字母最后一次出现的下标位置。
        for (int i = 0; i < len; i++)
        {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < len; i++)
        {
            // 对于每个访问到的字母，得到当前字母的最后一次出现的下标位置 end 则当前片段的结束下标一定不会小于 end
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end)
            {
                // 当访问到下标 end 时，当前片段访问结束，当前片段的下标范围是 [start,end] ，
                // 长度为 end−start+1，将当前片段的长度添加到返回值
                partition.add(end - start + 1);
                // 然后令 start=end+1 ，继续寻找下一个片段。
                start = end + 1;
            }
        }
        return partition;
    }
}
