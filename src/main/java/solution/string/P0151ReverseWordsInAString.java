package solution.string;

import java.util.*;

/**
 * Description :  反转字符串中的单词
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * <p>
 * 示例 1：
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * <p>
 * 示例 2：
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 * <p>
 * 示例 3：
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 * <p>
 * 提示：
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 * <p>
 * 进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。
 *
 * @author Eric L SHU
 * @date 2022-09-13 20:55
 * @since jdk-11.0.14
 */
public class P0151ReverseWordsInAString
{
    public String reverseWords_1(String s)
    {
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        int n = chars.length, i = n - 1;
        while (i >= 0)
        {
            while (i >= 0 && chars[i] == ' ')
            {
                i--;
            }
            int right = i;
            while (i >= 0 && chars[i] != ' ')
            {
                i--;
            }
            int left = i + 1;
            for (int j = left; j <= right; j++)
            {
                builder.append(chars[j]);
            }
            while (i >= 0 && chars[i] == ' ')
            {
                i--;
            }
            if (i >= 0)
                builder.append(' ');
        }
        return builder.toString();
    }

    public String reverseWords_2(String s)
    {
        List<String> wordList = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public String reverseWords_3(String s)
    {
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ')
        {
            ++left;
        }
        while (left <= right && s.charAt(right) == ' ')
        {
            --right;
        }

        Deque<String> deque = new ArrayDeque<>();
        StringBuilder builder = new StringBuilder();
        while (left <= right)
        {
            char c = s.charAt(left);
            if (builder.length() != 0 && c == ' ')
            {
                deque.offerFirst(builder.toString());
                builder.setLength(0);
            }
            else if (c != ' ')
            {
                builder.append(c);
            }
            ++left;
        }
        deque.offerFirst(builder.toString());
        return String.join(" ", deque);
    }
}
