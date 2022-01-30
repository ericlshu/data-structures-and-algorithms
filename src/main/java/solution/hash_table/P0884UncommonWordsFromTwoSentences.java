package solution.hash_table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description : 两句话中的不常见单词
 * <p>
 * 句子 是一串由空格分隔的单词。每个 单词 仅由小写字母组成。
 * 如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，那么这个单词就是 不常见的 。
 * 给你两个 句子 s1 和 s2 ，返回所有 不常用单词 的列表。返回列表中单词可以按 任意顺序 组织。
 * <p>
 * 示例 1：
 * 输入：s1 = "this apple is sweet", s2 = "this apple is sour"
 * 输出：["sweet","sour"]
 * <p>
 * 示例 2：
 * 输入：s1 = "apple apple", s2 = "banana"
 * 输出：["banana"]
 * <p>
 * 提示：
 * 1 <= s1.length, s2.length <= 200
 * s1 和 s2 由小写英文字母和空格组成
 * s1 和 s2 都不含前导或尾随空格
 * s1 和 s2 中的所有单词间均由单个空格分隔
 *
 * @author Eric L SHU
 * @date 2022-01-30 20:38
 * @since JDK 1.8
 */
public class P0884UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String s1, String s2)
    {
        HashMap<String, Integer> freq = new HashMap<>(10);
        insert(freq, s1);
        insert(freq, s2);
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : freq.entrySet())
        {
            if (entry.getValue() == 1)
            {
                list.add(entry.getKey());
            }
        }
        return list.toArray(new String[0]);
    }

    private void insert(HashMap<String, Integer> freq, String str)
    {
        String[] arr = str.split(" ");
        for (String s : arr)
        {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }

    }

}
