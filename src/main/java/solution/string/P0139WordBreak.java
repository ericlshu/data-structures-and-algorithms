package solution.string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description : 单词拆分
 * <p>
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * <p>
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * <p>
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * 注意你可以重复使用字典中的单词。
 * <p>
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * @author Eric L SHU
 * @date 2020-11-01 11:23
 * @since JDK 1.8
 */
public class P0139WordBreak
{
    public boolean wordBreak(String s, List<String> wordDict)
    {
        int strLength = s.length(), maxLength = 0;
        Set<String> wordDictSet = new HashSet<>();
        for (String word : wordDict)
        {
            wordDictSet.add(word);
            maxLength = Math.max(maxLength, word.length());
        }
        boolean[] dp = new boolean[strLength + 1];
        dp[0] = true;
        for (int i = 1; i <= strLength; i++)
        {
            for (int j = i > maxLength ? i - maxLength : 0; j < i; j++)
            {
                if (dp[j] && wordDictSet.contains(s.substring(j, i)))
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
