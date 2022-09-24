package solution.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Description : 字符串中的第一个唯一字符
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 * <p>
 * 示例 1：
 * 输入: s = "leetcode"
 * 输出: 0
 * <p>
 * 示例 2:
 * 输入: s = "loveleetcode"
 * 输出: 2
 * <p>
 * 示例 3:
 * 输入: s = "aabb"
 * 输出: -1
 * <p>
 * 提示:
 * 1 <= s.length <= 105
 * s 只包含小写字母
 *
 * @author Eric L SHU
 * @date 2022-09-10 12:50
 * @since jdk-11.0.14
 */
public class P0387FirstUniqueCharacterInAString
{
    public int firstUniqChar_map(String s)
    {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++)
        {
            if (map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public int firstUniqChar_array(String s)
    {
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++)
        {
            frequency[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++)
        {
            if (frequency[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }

    /**
     * 对于哈希映射中的每一个键值对，键表示一个字符，值表示它的首次出现的索引（如果该字符只出现一次）或者 -1−1（如果该字符出现多次）。
     * 当我们第一次遍历字符串时，设当前遍历到的字符为 c，如果 c 不在哈希映射中，我们就将 c 与它的索引作为一个键值对加入哈希映射中，否则我们将 c 在哈希映射中对应的值修改为 −1。
     * 在第一次遍历结束后，我们只需要再遍历一次哈希映射中的所有值，找出其中不为 −1 的最小值，即为第一个不重复字符的索引。
     * 如果哈希映射中的所有值均为 −1，我们就返回 −1。
     */
    public int firstUniqChar_index(String s)
    {
        Map<Character, Integer> position = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; ++i)
        {
            char ch = s.charAt(i);
            if (position.containsKey(ch))
                position.put(ch, -1);
            else
                position.put(ch, i);
        }
        int first = n;
        for (Map.Entry<Character, Integer> entry : position.entrySet())
        {
            int pos = entry.getValue();
            if (pos != -1 && pos < first)
                first = pos;
        }
        return first == n ? -1 : first;
    }

    public int firstUniqChar_queue(String s)
    {
        Map<Character, Integer> position = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n; ++i)
        {
            char ch = s.charAt(i);
            if (!position.containsKey(ch))
            {
                position.put(ch, i);
                queue.offer(new Pair(ch, i));
            }
            else
            {
                position.put(ch, -1);
                while (!queue.isEmpty() && position.get(queue.peek().ch) == -1)
                {
                    queue.poll();
                }
            }
        }
        return queue.isEmpty() ? -1 : queue.poll().pos;
    }

    static class Pair
    {
        char ch;
        int pos;

        Pair(char ch, int pos)
        {
            this.ch = ch;
            this.pos = pos;
        }
    }

    public int firstUniqChar_api(String s)
    {
        for (int i = 0; i < s.length(); i++)
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i)))
                return i;
        return -1;
    }
}
