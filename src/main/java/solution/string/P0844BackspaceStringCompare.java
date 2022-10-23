package solution.string;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2020-10-19 22:34
 * @since JDK 1.8
 */
public class P0844BackspaceStringCompare
{
    public boolean backspaceCompare_1(String S, String T)
    {
        return build(S).equals(build(T))
                && backspaceString(S).equals(backspaceString(T));
    }

    private String build(String str)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (ch == '#')
            {
                int idx = sb.length();
                if (idx > 0)
                    sb.deleteCharAt(idx - 1);
            }
            else
                sb.append(ch);
        }
        return sb.toString();
    }

    private String backspaceString(String str)
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

    public boolean backspaceCompare_2(String s, String t)
    {
        int idxS = s.length() - 1, idxT = t.length() - 1;
        int cntS = 0, cntT = 0;
        while (idxS >= 0 || idxT >= 0)
        {
            while (idxS >= 0)
            {
                if (s.charAt(idxS) == '#')
                {
                    cntS++;
                    idxS--;
                }
                else if (cntS > 0)
                {
                    cntS--;
                    idxS--;
                }
                else
                {
                    break;
                }
            }
            while (idxT >= 0)
            {
                if (t.charAt(idxT) == '#')
                {
                    cntT++;
                    idxT--;
                }
                else if (cntT > 0)
                {
                    cntT--;
                    idxT--;
                }
                else
                {
                    break;
                }
            }
            if (idxS >= 0 && idxT >= 0)
            {
                if (s.charAt(idxS) != t.charAt(idxT))
                    return false;
            }
            else if (idxS >= 0 || idxT >= 0)
            {
                return false;
            }
            idxS--;
            idxT--;
        }
        return true;
    }
}
