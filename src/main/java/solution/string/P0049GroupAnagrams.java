package solution.string;

import java.util.*;

/**
 * Description : 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * <p>
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 * <p>
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * <p>
 * 提示：
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 *
 * @author Eric L SHU
 * @date 2022-10-17 20:12
 * @since jdk-11.0.14
 */
public class P0049GroupAnagrams
{
    public List<List<String>> groupAnagrams_1(String[] strs)
    {
        List<List<String>> lists = new ArrayList<>();
        for (String str : strs)
        {
            int idx = 0;
            while (idx < lists.size())
            {
                if (isAnagrams(lists.get(idx).get(0), str))
                    break;
                idx++;
            }

            if (idx < lists.size())
            {
                List<String> list = new ArrayList<>(lists.get(idx));
                list.add(str);
                lists.set(idx, list);
            }
            else
            {
                lists.add(List.of(str));
            }
        }
        return lists;
    }

    private boolean isAnagrams(String s1, String s2)
    {
        if (s1.length() != s2.length())
            return false;
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return new String(arr1).equals(new String(arr2));
    }

    public List<List<String>> groupAnagrams_2(String[] strs)
    {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs)
        {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams_3(String[] strs)
    {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs)
        {
            int[] cnt = new int[26];
            for (int i = 0; i < str.length(); i++)
            {
                cnt[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++)
            {
                if (cnt[i] > 0)
                    sb.append((char) ('a' + i)).append(cnt[i]);
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
