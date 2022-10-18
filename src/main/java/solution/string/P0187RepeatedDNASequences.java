package solution.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Description : 重复的DNA序列
 * DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
 * 例如，"ACGAATTCCG" 是一个 DNA序列 。
 * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
 * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
 * <p>
 * 示例 1：
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * <p>
 * 示例 2：
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 * <p>
 * 提示：
 * 0 <= s.length <= 105
 * s[i]=='A'、'C'、'G' or 'T'
 *
 * @author Eric L SHU
 * @date 2022-10-18 21:05
 * @since jdk-11.0.14
 */
public class P0187RepeatedDNASequences
{
    public List<String> findRepeatedDnaSequences_1(String s)
    {
        ArrayList<String> list = new ArrayList<>();
        if (s.length() <= 10)
            return list;
        for (int i = 0; i <= s.length() - 10; i++)
        {
            String sub = s.substring(i, i + 10);
            if (s.indexOf(sub) < s.lastIndexOf(sub) && !list.contains(sub))
                list.add(sub);
        }
        return list;
    }

    public List<String> findRepeatedDnaSequences_2(String s)
    {
        ArrayList<String> list = new ArrayList<>();
        if (s.length() <= 10)
            return list;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++)
        {
            String sub = s.substring(i, i + 10);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
            if (map.get(sub) == 2)
                list.add(sub);
        }
        return list;
    }
}
