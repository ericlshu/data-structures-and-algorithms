package com.eric.solution.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Description : 单词规律
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 * <p>
 * 提示:
 * -> 1 <= pattern.length <= 300
 * -> pattern 只包含小写英文字母
 * -> 1 <= s.length <= 3000
 * -> s 只包含小写英文字母和 ' '
 * -> s 不包含 任何前导或尾随对空格
 * -> s 中每个单词都被 单个空格 分隔
 *
 * @author Eric L SHU
 * @date 2022-10-16 12:44
 * @since jdk-11.0.14
 */
public class P0290WordPattern
{
    public boolean wordPattern_1(String pattern, String s)
    {
        String[] arr = s.split(" ");
        if (pattern.length() != arr.length)
            return false;
        Map<Character, String> p2s = new HashMap<>();
        Map<String, Character> s2p = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++)
        {
            char ch = pattern.charAt(i);
            if (p2s.containsKey(ch) || s2p.containsKey(arr[i]))
            {
                if (p2s.containsKey(ch) && s2p.containsKey(arr[i]))
                {
                    if (!p2s.get(ch).equals(arr[i]) || !s2p.get(arr[i]).equals(ch))
                        return false;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                p2s.put(ch, arr[i]);
                s2p.put(arr[i], ch);
            }
        }
        return true;
    }

    public boolean wordPattern_2(String pattern, String s)
    {
        String[] words = s.split(" ");
        if (words.length != pattern.length())
            return false;
        Map<Object, Integer> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++)
        {
            /*
                如果key不存在，插入成功，返回null；如果key存在，返回之前对应的value。

                以pattern = "abba", str = "dog cat cat dog"为例，
                第1次：map.put('a',0)返回null，map.put("dog",0)返回null，两者相等；
                第2次：map.put('b',1)返回null，map.put("cat",1)返回null，两者相等；
                第3次：map.put('b',2)返回1，map.put("cat",2)返回1，两者相等；
                第4次：map.put('a',3)返回0，map.put("dog",3)返回0，两者相等，
                结果为 true。

                以pattern = "abba", str = "dog cat cat fish"为例，
                第1次：map.put('a',0)返回null，map.put("dog",0)返回null，两者相等；
                第2次：map.put('b',1)返回null，map.put("cat",1)返回null，两者相等；
                第3次：map.put('b',2)返回1，map.put("cat",2)返回1，两者相等；
                第4次：map.put('a',3)返回0，map.put("fish",3)返回null，两者不相等，
                结果为 false。
            */
            if (!Objects.equals(map.put(pattern.charAt(i), i), map.put(words[i], i)))
                return false;
        }
        return true;
    }
}
