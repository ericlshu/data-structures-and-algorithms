package solution.string;

import java.util.*;

/**
 * Description : 根据字符出现频率排序
 * 给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
 * 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
 * <p>
 * 示例 1:
 * 输入: s = "tree"
 * 输出: "eert"
 * 解释: 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * <p>
 * 示例 2:
 * 输入: s = "cccaaa"
 * 输出: "cccaaa"
 * 解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * <p>
 * 示例 3:
 * 输入: s = "Aabb"
 * 输出: "bbAa"
 * 解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * <p>
 * 提示:
 * 1 <= s.length <= 5 * 105
 * s 由大小写英文字母和数字组成
 *
 * @author Eric L SHU
 * @date 2022-10-30 18:45
 * @since jdk-11.0.14
 */
public class P0451SortCharactersByFrequency
{
    public String frequencySort_pq(String s)
    {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (e1, e2) -> e2.getValue() - e1.getValue()
        );
        for (Map.Entry<Character, Integer> entry : freq.entrySet())
        {
            pq.offer(entry);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty())
        {
            Map.Entry<Character, Integer> entry = pq.poll();
            sb.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }
        return sb.toString();
    }

    public String frequencySort_list(String s)
    {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Character> list = new ArrayList<>(freq.keySet());
        list.sort((a, b) -> freq.get(b) - freq.get(a));
        StringBuilder sb = new StringBuilder();
        for (char ch : list)
        {
            sb.append(String.valueOf(ch).repeat(freq.get(ch)));
        }
        return sb.toString();
    }

    public String frequencySort_bucket(String s)
    {
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int n = s.length();
        for (int i = 0; i < n; i++)
        {
            char ch = s.charAt(i);
            int freq = map.getOrDefault(ch, 0) + 1;
            map.put(ch, freq);
            maxFreq = Math.max(maxFreq, freq);
        }
        StringBuffer[] buckets = new StringBuffer[maxFreq + 1];
        for (int i = 0; i <= maxFreq; i++)
        {
            buckets[i] = new StringBuffer();
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet())
        {
            char ch = entry.getKey();
            int freq = entry.getValue();
            buckets[freq].append(ch);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = maxFreq; i > 0; i--)
        {
            StringBuffer bucket = buckets[i];
            int size = bucket.length();
            for (int j = 0; j < size; j++)
            {
                sb.append(String.valueOf(bucket.charAt(j)).repeat(i));
            }
        }
        return sb.toString();
    }
}
