package solution.string;

import java.util.Arrays;

/**
 * Description : 统计包含给定前缀的字符串
 * 给你一个字符串数组 words 和一个字符串 pref 。
 * 返回 words 中以 pref 作为 前缀 的字符串的数目。
 * 字符串 s 的 前缀 就是  s 的任一前导连续字符串。
 * <p>
 * 示例 1：
 * 输入：words = ["pay","attention","practice","attend"], pref = "at"
 * 输出：2
 * 解释：以 "at" 作为前缀的字符串有两个，分别是："attention" 和 "attend" 。
 * <p>
 * 示例 2：
 * 输入：words = ["leetcode","win","loops","success"], pref = "code"
 * 输出：0
 * 解释：不存在以 "code" 作为前缀的字符串。
 * <p>
 * 提示：
 * -> 1 <= words.length <= 100
 * -> 1 <= words[i].length, pref.length <= 100
 * -> words[i] 和 pref 由小写英文字母组成
 *
 * @author Eric L SHU
 * @date 2023-01-08 14:02
 * @since jdk-11.0.14
 */
public class P2185CountingWordsWithAGivenPrefix
{
    public int prefixCount(String[] words, String pref)
    {
        // int cnt = 0;
        // for (String word : words)
        // {
        //     if (word.startsWith(pref))
        //     {
        //         cnt++;
        //     }
        // }
        // return cnt;
        return (int) Arrays.stream(words).filter(word -> word.startsWith(pref)).count();
    }
}
