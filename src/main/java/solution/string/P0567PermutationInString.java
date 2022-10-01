package solution.string;

import java.util.Arrays;

/**
 * Description : 字符串的排列
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * <p>
 * 示例 1：
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * <p>
 * 示例 2：
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 * <p>
 * 提示：
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 *
 * @author Eric L SHU
 * @date 2022-09-22 9:58 PM
 * @since jdk-11.0.14
 */
public class P0567PermutationInString
{
    public boolean checkInclusion_sw1(String s1, String s2)
    {
        char[] pattern = s1.toCharArray();
        char[] text = s2.toCharArray();

        int pLen = s1.length();
        int tLen = s2.length();

        int[] pFreq = new int[26];
        int[] winFreq = new int[26];

        for (int i = 0; i < pLen; i++)
        {
            pFreq[pattern[i] - 'a']++;
        }

        int pCount = 0;
        for (int i = 0; i < 26; i++)
        {
            if (pFreq[i] > 0)
                pCount++;
        }

        int left = 0;
        int right = 0;
        // 当滑动窗口中的某个字符个数与 s1 中对应相等的时候才计数
        int winCount = 0;
        while (right < tLen)
        {
            if (pFreq[text[right] - 'a'] > 0)
            {
                winFreq[text[right] - 'a']++;
                // 如果某一个字符出现的次数恰好等于 s1 中对应字符出现的次数，winCount += 1
                if (winFreq[text[right] - 'a'] == pFreq[text[right] - 'a'])
                    winCount++;
            }
            right++;

            while (pCount == winCount)
            {
                // 当滑动窗口中出现的字符种类数和 s1 中出现的字符种类数相等（根据 winCount 的定义，对应次数也相等），
                // 并且 s2 上的滑动窗口的长度等于字符串 s1 的长度的时候，就找到了 s1 的一个排列。
                if (right - left == pLen)
                {
                    return true;
                }
                if (pFreq[text[left] - 'a'] > 0)
                {
                    winFreq[text[left] - 'a']--;
                    // 在左边界向右移动的过程当中，某一个字符对应的次数减少以后，恰好小于了 s1 对应的字符出现的次数，winCount -= 1
                    if (winFreq[text[left] - 'a'] < pFreq[text[left] - 'a'])
                    {
                        winCount--;
                    }
                }
                left++;
            }
        }
        return false;
    }

    public boolean checkInclusion_sw2(String s1, String s2)
    {
        int n = s1.length(), m = s2.length();
        if (n > m)
            return false;

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i)
        {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(cnt1, cnt2))
            return true;

        for (int i = n; i < m; ++i)
        {
            cnt2[s2.charAt(i) - 'a']++;
            cnt2[s2.charAt(i - n) - 'a']--;
            if (Arrays.equals(cnt1, cnt2))
                return true;
        }
        return false;
    }

    public boolean checkInclusion_sw3(String s1, String s2)
    {
        int n = s1.length(), m = s2.length();
        if (n > m)
            return false;

        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i)
        {
            --cnt[s1.charAt(i) - 'a'];
            ++cnt[s2.charAt(i) - 'a'];
        }

        int diff = 0;
        for (int c : cnt)
        {
            if (c != 0)
                ++diff;
        }
        if (diff == 0)
            return true;

        for (int i = n; i < m; ++i)
        {
            int x = s2.charAt(i) - 'a', y = s2.charAt(i - n) - 'a';
            if (x == y)
                continue;
            if (cnt[x] == 0)
                ++diff;
            ++cnt[x];
            if (cnt[x] == 0)
                --diff;
            if (cnt[y] == 0)
                ++diff;
            --cnt[y];
            if (cnt[y] == 0)
                --diff;
            if (diff == 0)
                return true;
        }
        return false;
    }

    public boolean checkInclusion_pointers(String s1, String s2)
    {
        int n = s1.length(), m = s2.length();
        if (n > m)
            return false;

        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i)
        {
            cnt[s1.charAt(i) - 'a']--;
        }

        int left = 0;
        for (int right = 0; right < m; ++right)
        {
            int x = s2.charAt(right) - 'a';
            cnt[x]++;
            while (cnt[x] > 0)
            {
                cnt[s2.charAt(left) - 'a']--;
                left++;
            }
            if (right - left + 1 == n)
                return true;
        }
        return false;
    }
}
