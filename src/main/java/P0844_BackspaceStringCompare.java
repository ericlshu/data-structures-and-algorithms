/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2020-10-19 22:34
 * @since JDK 1.8
 */
public class P0844_BackspaceStringCompare
{
    public boolean backspaceCompare(String S, String T)
    {
        return build(S).equals(build(T));
    }

    private String build(String str)
    {
        StringBuilder result = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++)
        {
            char ch = str.charAt(i);
            if (ch != '#') result.append(ch);
            else
            {
                int index = result.length();
                if (index > 0) result.deleteCharAt(index - 1);
            }
        }
        return result.toString();
    }

    public String backspaceString(String str)
    {
        int index = str.indexOf('#');
        while (index >= 0)
        {
            str = str.replaceFirst("#", "");
            if (index > 0)
                str = str.substring(0, index - 1) + str.substring(index);
            index = str.indexOf('#');
        }
        return str;
    }
}
