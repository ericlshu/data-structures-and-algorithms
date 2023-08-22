package com.eric.solution.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Description : 重排字符形成目标字符串
 * 给你两个下标从 0 开始的字符串 s 和 target 。你可以从 s 取出一些字符并将其重排，得到若干新的字符串。
 * 从 s 中取出字符并重新排列，返回可以形成 target 的 最大 副本数。
 * <p>
 * 示例 1：
 * 输入：s = "ilovecodingonleetcode", target = "code"
 * 输出：2
 * 解释：
 * 对于 "code" 的第 1 个副本，选取下标为 4 、5 、6 和 7 的字符。
 * 对于 "code" 的第 2 个副本，选取下标为 17 、18 、19 和 20 的字符。
 * 形成的字符串分别是 "ecod" 和 "code" ，都可以重排为 "code" 。
 * 可以形成最多 2 个 "code" 的副本，所以返回 2 。
 * <p>
 * 示例 2：
 * 输入：s = "abcba", target = "abc"
 * 输出：1
 * 解释：
 * 选取下标为 0 、1 和 2 的字符，可以形成 "abc" 的 1 个副本。
 * 可以形成最多 1 个 "abc" 的副本，所以返回 1 。
 * 注意，尽管下标 3 和 4 分别有额外的 'a' 和 'b' ，但不能重用下标 2 处的 'c' ，所以无法形成 "abc" 的第 2 个副本。
 * <p>
 * 示例 3：
 * 输入：s = "abbaccaddaeea", target = "aaaaa"
 * 输出：1
 * 解释：
 * 选取下标为 0 、3 、6 、9 和 12 的字符，可以形成 "aaaaa" 的 1 个副本。
 * 可以形成最多 1 个 "aaaaa" 的副本，所以返回 1 。
 * <p>
 * 提示：
 * -> 1 <= s.length <= 100
 * -> 1 <= target.length <= 10
 * -> s 和 target 由小写英文字母组成
 *
 * @author Eric L SHU
 * @date 2023-01-13 20:19
 * @since jdk-11.0.14
 */
public class P2287RearrangeCharactersToMakeTargetString
{
    public int rearrangeCharacters(String s, String target)
    {
        if (s.length() < target.length())
            return 0;
        Map<Character, Integer> tt = new HashMap<>();
        Map<Character, Integer> ss = new HashMap<>();
        for (int i = 0; i < target.length(); i++)
        {
            tt.put(target.charAt(i), tt.getOrDefault(target.charAt(i), 0) + 1);
        }
        char c;
        for (int i = 0; i < s.length(); i++)
        {
            c = s.charAt(i);
            if (tt.containsKey(c))
            {
                ss.put(c, ss.getOrDefault(c, 0) + 1);
            }
        }
        if (ss.size() < tt.size())
            return 0;
        int cnt = 101;
        for (Map.Entry<Character, Integer> entry : tt.entrySet())
        {
            c = entry.getKey();
            cnt = Math.min(cnt, ss.get(c) / tt.get(c));
        }
        return cnt;
    }
}
