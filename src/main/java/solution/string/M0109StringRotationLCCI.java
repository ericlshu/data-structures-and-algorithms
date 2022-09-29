package solution.string;

/**
 * Description : 面试题 01.09. 字符串轮转
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 * <p>
 * 示例1:
 * 输入：s1 = "waterbottle", s2 = "erbottlewat"
 * 输出：True
 * <p>
 * 示例2:
 * 输入：s1 = "aa", s2 = "aba"
 * 输出：False
 * <p>
 * 提示：
 * 字符串长度在[0, 100000]范围内。
 * 说明:
 * <p>
 * 你能只调用一次检查子串的方法吗？
 *
 * @author Eric L SHU
 * @date 2022-09-29 21:23
 * @since jdk-11.0.14
 */
public class M0109StringRotationLCCI
{
    public boolean isFlipedStringPointers1(String s1, String s2)
    {
        if (s1.length() != s2.length())
            return false;
        int len = s1.length();
        if (len == 0) return true;
        int idx = 0;
        while (idx < len)
        {
            String s = s1.substring(idx, len) + s1.substring(0, idx);
            if (s2.equals(s))
                return true;
            idx++;
        }
        return false;
    }

    public boolean isFlipedStringPointers2(String s1, String s2)
    {
        int m = s1.length(), n = s2.length();
        if (m != n)
            return false;
        if (n == 0)
            return true;
        for (int i = 0; i < n; i++)
        {
            boolean flag = true;
            for (int j = 0; j < n; j++)
            {
                if (s1.charAt((i + j) % n) != s2.charAt(j))
                {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return true;
        }
        return false;
    }

    public boolean isFlipedStringSearch(String s1, String s2)
    {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }
}
