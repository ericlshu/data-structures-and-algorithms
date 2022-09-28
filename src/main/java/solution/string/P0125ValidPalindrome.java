package solution.string;

/**
 * Description : 验证回文串
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 * <p>
 * 示例 2：
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 * <p>
 * 示例 3：
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 * <p>
 * 提示：
 * 1 <= s.length <= 2 * 105
 * s 仅由可打印的 ASCII 字符组成
 *
 * @author Eric L SHU
 * @date 2022-09-28 9:18 PM
 * @since jdk-11.0.14
 */
public class P0125ValidPalindrome
{
    public boolean isPalindrome_pointers(String s)
    {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right)
        {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
            {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
            {
                right--;
            }
            if (s.charAt(left) != s.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome_api(String s)
    {
        StringBuilder builder = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++)
        {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch))
                builder.append(Character.toLowerCase(ch));
        }
        StringBuffer sRev = new StringBuffer(builder).reverse();
        return builder.toString().equals(sRev.toString());
    }

    public boolean isPalindrome(String s)
    {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++)
        {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch))
                sb.append(Character.toLowerCase(ch));
        }
        int n = sb.length();
        int left = 0, right = n - 1;
        while (left < right)
        {
            if (Character.toLowerCase(sb.charAt(left++)) != Character.toLowerCase(sb.charAt(right--)))
                return false;
        }
        return true;
    }
}
