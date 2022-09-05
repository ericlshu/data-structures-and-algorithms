package solution.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Description : 500. 键盘行
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 * <p>
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 * <p>
 * 示例 1：
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 * <p>
 * 示例 2：
 * 输入：words = ["omk"]
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：words = ["adsdf","sfd"]
 * 输出：["adsdf","sfd"]
 * <p>
 * 提示：
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 100
 * words[i] 由英文字母（小写和大写字母）组成
 *
 * @author Eric L SHU
 * @date 2022-09-05 20:19
 * @since jdk-11.0.14
 */
public class P0500KeyboardRow
{
    public String[] findWords(String[] words)
    {
        List<String> list = new ArrayList<>();
        String rowIdx = "12210111011122000010020202";
        for (String word : words)
        {
            boolean isValid = true;
            char idx = rowIdx.charAt(Character.toLowerCase(word.charAt(0)) - 'a');
            for (int i = 1; i < word.length(); ++i)
            {
                if (rowIdx.charAt(Character.toLowerCase(word.charAt(i)) - 'a') != idx)
                {
                    isValid = false;
                    break;
                }
            }
            if (isValid)
                list.add(word);
        }
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); ++i)
        {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public String[] findWords_2(String[] words)
    {
        List<String> list = new ArrayList<>();
        int[] rowIndex = {1, 2, 2, 1, 0, 1, 1, 1, 0, 1, 1, 1, 2, 2, 0, 0, 0, 0, 1, 0, 0, 2, 0, 2, 0, 2};
        for (String word : words)
        {
            int preIdx = rowIndex[Character.toLowerCase(word.charAt(0)) - 'a'];
            boolean matched = true;
            for (int i = 1; i < word.length(); i++)
            {
                if (rowIndex[Character.toLowerCase(word.charAt(i)) - 'a'] != preIdx)
                {
                    matched = false;
                    break;
                }
            }
            if (matched) list.add(word);
        }
        return list.toArray(new String[0]);
    }

    public String[] findWords_1(String[] words)
    {
        List<String> list = new ArrayList<>();

        final String line1 = "qwertyuiop";
        final String line2 = "asdfghjkl";
        final String line3 = "zxcvbnm";

        for (String word : words)
        {
            boolean matched = false;
            // word = word.toLowerCase(Locale.ROOT);
            String firstLetter = String.valueOf(word.charAt(0)).toLowerCase();
            if (line1.contains(firstLetter))
            {
                matched = matchWord(word, line1);
            }
            else if (line2.contains(firstLetter))
            {
                matched = matchWord(word, line2);
            }
            else if (line3.contains(firstLetter))
            {
                matched = matchWord(word, line3);
            }
            if (matched)
            {
                list.add(word);
            }
        }
        return list.toArray(new String[0]);
    }

    private boolean matchWord(String word, String key)
    {
        for (int i = 0; i < word.length(); i++)
        {
            String letter = String.valueOf(word.charAt(i)).toLowerCase();
            if (!key.contains(letter))
                return false;
        }
        return true;
    }
}
