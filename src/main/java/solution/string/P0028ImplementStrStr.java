package solution.string;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2020-10-22 20:08
 * @since JDK 1.8
 */
public class P0028ImplementStrStr
{
    public int strStr_1(String haystack, String needle)
    {
        if (needle == null || needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;
        int index = -1;
        for (int i = 0; i < haystack.length(); i++)
        {
            if (haystack.charAt(i) == needle.charAt(0))
            {
                index = i++;
                int j = 1;
                while (j < needle.length())
                {
                    if (i == haystack.length())
                    {
                        return -1;
                    }
                    else if (haystack.charAt(i) == needle.charAt(j))
                    {
                        i++;
                        j++;
                    }
                    else
                    {
                        i = index;
                        index = -1;
                        break;
                    }
                }
            }
            if (index != -1) return index;
        }
        return index;
    }

    public int strStr_2(String haystack, String needle)
    {
        int h = haystack.length(), n = needle.length();
        for (int i = 0; i <= h - n; i++)
        {
            boolean matched = true;
            for (int j = 0; j < n; j++)
            {
                if (haystack.charAt(i + j) != needle.charAt(j))
                {
                    matched = false;
                    break;
                }
            }
            if (matched)
            {
                return i;
            }
        }
        return -1;
    }
}
