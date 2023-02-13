package solution.string;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2023-02-13 20:46
 * @since jdk-11.0.14
 */
public class P1234ReplaceTheSubstringForBalancedString
{
    public int balancedString_1(String s)
    {
        int n = s.length(), m = n / 4, res = n;
        int[] cnt = new int[4];
        for (int i = 0; i < n; i++)
        {
            cnt[idx(s.charAt(i))]++;
        }
        if (balanced(cnt, m))
            return 0;
        for (int l = 0, r = 0; l < n; l++)
        {
            while (r < n && !balanced(cnt, m))
            {
                cnt[idx(s.charAt(r))]--;
                r++;
            }
            if (!balanced(cnt, m))
                break;
            res = Math.min(res, r - l);
            // System.out.println("s.substring(l, r) = " + s.substring(l, r));
            cnt[idx(s.charAt(l))]++;
        }
        return res;
    }

    private boolean balanced(int[] cnt, int m)
    {
        for (int freq : cnt)
        {
            if (freq > m)
                return false;
        }
        return true;
    }

    private int idx(char c)
    {
        switch (c)
        {
            case 'Q':
                return 0;
            case 'W':
                return 1;
            case 'E':
                return 2;
            case 'R':
                return 3;
            default:
        }
        return -1;
    }

    public int balancedString_2(String s)
    {
        var arr = s.toCharArray();
        var cnt = new int['X'];
        for (var c : arr) ++cnt[c];
        int n = arr.length, m = n / 4;
        if (cnt['Q'] == m && cnt['W'] == m && cnt['E'] == m && cnt['R'] == m)
            return 0;
        int ans = n, left = 0;
        for (int right = 0; right < n; right++)
        {
            --cnt[arr[right]];
            while (cnt['Q'] <= m && cnt['W'] <= m && cnt['E'] <= m && cnt['R'] <= m)
            {
                ans = Math.min(ans, right - left + 1);
                ++cnt[arr[left++]];
            }
        }
        return ans;
    }
}
