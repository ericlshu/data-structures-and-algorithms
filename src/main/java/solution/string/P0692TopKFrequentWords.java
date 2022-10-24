package solution.string;

import java.util.*;

/**
 * Description : 前K个高频单词
 * 给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
 * <p>
 * 示例 1：
 * 输入: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 * <p>
 * 示例 2：
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * 出现次数依次为 4, 3, 2 和 1 次。
 * <p>
 * 注意：
 * 1 <= words.length <= 500
 * 1 <= words[i] <= 10
 * words[i] 由小写英文字母组成。
 * k 的取值范围是 [1, 不同 words[i] 的数量]
 * <p>
 * 进阶：尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 *
 * @author Eric L SHU
 * @date 2022-10-24 14:42
 * @since jdk-11.0.14
 */
public class P0692TopKFrequentWords
{
    public List<String> topKFrequent_pq(String[] words, int k)
    {
        List<String> list = new ArrayList<>();
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words)
        {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (e1, e2) -> Objects.equals(e1.getValue(), e2.getValue()) ?
                        e1.getKey().compareTo(e2.getKey()) : e2.getValue() - e1.getValue());
        for (Map.Entry<String, Integer> entry : freq.entrySet())
        {
            pq.offer(entry);
        }
        for (int i = 0; i < k; i++)
        {
            list.add(Objects.requireNonNull(pq.poll()).getKey());
        }
        return list;
    }

    public List<String> topKFrequent_list(String[] words, int k)
    {
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words)
        {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : freq.entrySet())
        {
            list.add(entry.getKey());
        }
        list.sort((w1, w2) ->
                Objects.equals(freq.get(w1), freq.get(w2)) ?
                        w1.compareTo(w2) : freq.get(w2) - freq.get(w1));
        return list.subList(0, k);
    }
}
