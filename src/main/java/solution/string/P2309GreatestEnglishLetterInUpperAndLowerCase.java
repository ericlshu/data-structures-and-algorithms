package solution.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Description : 兼具大小写的最好英文字母
 * 给你一个由英文字母组成的字符串 s ，请你找出并返回 s 中的 最好 英文字母。返回的字母必须为大写形式。如果不存在满足条件的字母，则返回一个空字符串。
 * 最好 英文字母的大写和小写形式必须 都 在 s 中出现。
 * 英文字母 b 比另一个英文字母 a 更好 的前提是：英文字母表中，b 在 a 之 后 出现。
 * <p>
 * 示例 1：
 * 输入：s = "lEeTcOdE"
 * 输出："E"
 * 解释：
 * 字母 'E' 是唯一一个大写和小写形式都出现的字母。
 * <p>
 * 示例 2：
 * 输入：s = "arRAzFif"
 * 输出："R"
 * 解释：
 * 字母 'R' 是大写和小写形式都出现的最好英文字母。
 * 注意 'A' 和 'F' 的大写和小写形式也都出现了，但是 'R' 比 'F' 和 'A' 更好。
 * <p>
 * 示例 3：
 * 输入：s = "AbCdEfGhIjK"
 * 输出：""
 * 解释：
 * 不存在大写和小写形式都出现的字母。
 * <p>
 * 提示：
 * -> 1 <= s.length <= 1000
 * -> s 由小写和大写英文字母组成
 *
 * @author Eric L SHU
 * @date 2023-01-27 21:00
 * @since jdk-11.0.14
 */
public class P2309GreatestEnglishLetterInUpperAndLowerCase
{
    public String greatestLetter_arr(String s)
    {
        int n = s.length();
        if (n == 1)
            return "";
        int[] freq = new int[52];
        for (int i = 0; i < n; i++)
        {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch))
                freq[ch - 'a']++;
            else
                freq[ch - 'A' + 26]++;
        }
        for (int i = 25; i >= 0; i--)
        {
            if (freq[i] > 0 && freq[i + 26] > 0)
                return String.valueOf((char) (i + 'A'));
        }
        return "";
    }

    public String greatestLetter_hash(String s)
    {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        for (int i = 0; i < n; i++)
        {
            set.add(s.charAt(i));
        }
        for (int i = 25; i >= 0; i--)
        {
            if (set.contains((char) ('a' + i)) && set.contains((char) ('A' + i)))
                return String.valueOf((char) ('A' + i));
        }
        return "";
    }

    public String greatestLetter_bit(String s)
    {
        int lower = 0, upper = 0;
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isLowerCase(c))
                lower |= 1 << (c - 'a');
            else
                upper |= 1 << (c - 'A');
        }
        for (int i = 25; i >= 0; i--)
        {
            if ((lower & upper & (1 << i)) != 0)
                return String.valueOf((char) ('A' + i));
        }
        return "";
    }
}
