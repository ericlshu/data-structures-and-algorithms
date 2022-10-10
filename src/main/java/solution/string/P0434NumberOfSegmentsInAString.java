package solution.string;

/**
 * Description : 字符串中的单词数
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * <p>
 * 示例:
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 *
 * @author Eric L SHU
 * @date 2022-10-10 12:41
 * @since jdk-11.0.14
 */
public class P0434NumberOfSegmentsInAString
{
    public int countSegments_1(String s)
    {
        int cnt = 0;
        boolean start = false;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) != ' ')
            {
                start = true;
            }
            else
            {
                if (start)
                {
                    cnt++;
                    start = false;
                }
            }
        }
        if (start)
            cnt++;
        return cnt;
    }

    public int countSegments_2(String s)
    {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ')
                cnt++;
        }
        return cnt;
    }


    public int countSegments_3(String s)
    {
        s = s.trim();
        if (s.equals(""))
            return 0;
        return s.split("\\s+").length;
    }
}
