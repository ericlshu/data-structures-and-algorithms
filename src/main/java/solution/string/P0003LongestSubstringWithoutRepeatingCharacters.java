package solution.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Description : 无重复字符的最长子串
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * <p>
 * 示例:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 * @author Eric L SHU
 * @date 2020-10-15 23:02
 * @since JDK 1.8
 */
public class P0003LongestSubstringWithoutRepeatingCharacters
{
    public int lengthOfLongestSubstring_map(String s)
    {
        HashMap<Character, Integer> map = new HashMap<>(10);
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++)
        {
            char ch = s.charAt(end);
            if (map.containsKey(ch))
                start = Math.max(map.get(ch) + 1, start);
            max = Math.max(max, end - start + 1);
            map.put(ch, end);

            System.out.print("| end -->> " + end + "\t");
            System.out.print("| char = " + ch + "\t");
            System.out.print("| stat = " + start + "\t");
            System.out.print("| maxl = " + max + "\t");
            System.out.print("| leng = " + (end - start + 1) + "\t");
            System.out.print("| subs = " + s.substring(start, end + 1));
            System.out.println();
        }
        return max;
    }

    public int lengthOfLongestSubstring_set(String s)
    {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int idx = 0, max = 0;
        for (int i = 0; i < n; i++)
        {
            if (i > 0)
                // 左指针向右移动一格，移除一个字符
                set.remove(s.charAt(i - 1));
            while (idx < n && !set.contains(s.charAt(idx)))
            {
                // 不断地移动右指针
                set.add(s.charAt(idx++));
            }
            // 第 i 到 idx 个字符是一个极长的无重复字符子串
            max = Math.max(max, idx - i);
        }
        return max;
    }
}
