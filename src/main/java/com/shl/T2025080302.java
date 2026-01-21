package com.shl;

import com.itheima.temp.recursion.CharArraySwap;

import java.util.*;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2025-08-03 13:49
 */
public class T2025080302
{
    public static int strConvert(String str1, String str2)
    {
        if (str1.equals(str2)) return 0;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> stepQueue = new LinkedList<>();

        queue.add(str1);
        stepQueue.add(0);
        visited.add(str1);

        while (!queue.isEmpty())
        {
            String current = queue.poll();
            int step = stepQueue.poll();

            for (int len = 2; len <= current.length(); len++)
            {
                for (int i = 0; i <= current.length() - len; i++)
                {
                    String reversed = reverseSubstring(current, i, i + len - 1);
                    if (reversed.equals(str2)) return step + 1;
                    if (!visited.contains(reversed))
                    {
                        visited.add(reversed);
                        queue.add(reversed);
                        stepQueue.add(step + 1);
                    }
                }
            }
        }
        return -1;
    }

    // 反转字符串中某一子串 [start, end]
    private static String reverseSubstring(String s, int start, int end)
    {
        char[] chars = s.toCharArray();
        while (start < end)
        {
            CharArraySwap.swap(chars, start, end);
            start++;
            end--;
        }
        return new String(chars);
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        int result = strConvert(str1, str2);
        System.out.print(result);
    }
}
