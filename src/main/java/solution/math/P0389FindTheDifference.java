package solution.math;

/**
 * Description : 389. 找不同
 * 给定两个字符串 s 和 t ，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 * <p>
 * 示例 1：
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * <p>
 * 示例 2：
 * 输入：s = "", t = "y"
 * 输出："y"
 * <p>
 * 提示：
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 *
 * @author Eric L SHU
 * @date 2022-09-03 17:35
 * @since jdk-11.0.14
 */
public class P0389FindTheDifference
{
    /**
     * 计数
     */
    public char findTheDifference_1(String s, String t)
    {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++)
        {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++)
        {
            char ch = t.charAt(i);
            count[ch - 'a']--;
            if (count[ch - 'a'] < 0)
                return ch;
        }
        return ' ';
    }

    /**
     * 求和
     */
    public char findTheDifference_2(String s, String t)
    {
        int sum = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++)
        {
            sum += t.charAt(i);
            sum -= s.charAt(i);
        }
        return (char) sum;
    }

    /**
     * 位运算
     */
    public char findTheDifference(String s, String t)
    {
        char result = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++)
        {
            result ^= s.charAt(i);
            result ^= t.charAt(i);
        }
        return result;
    }
}
