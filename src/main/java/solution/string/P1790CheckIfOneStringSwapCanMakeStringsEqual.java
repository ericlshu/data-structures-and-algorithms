package solution.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Description : 仅执行一次字符串交换能否使两个字符串相等
 * 给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
 * 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：s1 = "bank", s2 = "kanb"
 * 输出：true
 * 解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
 * <p>
 * 示例 2：
 * 输入：s1 = "attack", s2 = "defend"
 * 输出：false
 * 解释：一次字符串交换无法使两个字符串相等
 * <p>
 * 示例 3：
 * 输入：s1 = "kelb", s2 = "kelb"
 * 输出：true
 * 解释：两个字符串已经相等，所以不需要进行字符串交换
 * <p>
 * 示例 4：
 * 输入：s1 = "abcd", s2 = "dcba"
 * 输出：false
 * <p>
 * 提示：
 * 1 <= s1.length, s2.length <= 100
 * s1.length == s2.length
 * s1 和 s2 仅由小写英文字母组成
 *
 * @author Eric L SHU
 * @date 2022-10-11 22:07
 * @since jdk-11.0.14
 */
public class P1790CheckIfOneStringSwapCanMakeStringsEqual
{
    public boolean areAlmostEqual_2p(String s1, String s2)
    {
        if (s1.equals(s2))
            return true;
        int left, i = 0, j = 0, len = s1.length();
        while (s1.charAt(i) == s2.charAt(j))
        {
            i++;
            j++;
        }
        left = i;
        i++;
        j++;
        while (i < len && j < len && s1.charAt(i) == s2.charAt(j))
        {
            i++;
            j++;
        }
        if (i == len)
            return false;

        char[] chars = s2.toCharArray();
        char temp = chars[left];
        chars[left] = chars[j];
        chars[j] = temp;
        return s1.equals(new String(chars));
    }

    public boolean areAlmostEqual_list(String s1, String s2)
    {
        if (s1.equals(s2))
            return true;
        int n = s1.length();
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < n; ++i)
        {
            if (s1.charAt(i) != s2.charAt(i))
            {
                if (diff.size() == 2)
                    return false;
                diff.add(i);
            }
        }
        if (diff.size() == 1)
            return false;
        return s1.charAt(diff.get(0)) == s2.charAt(diff.get(1)) && s1.charAt(diff.get(1)) == s2.charAt(diff.get(0));
    }
}
