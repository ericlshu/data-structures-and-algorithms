package com.shl;

import java.util.Scanner;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2026-01-13 17:39
 */
public class CountOccurrencesOfNeedleInHaystack
{
    // Write an algorithm to find the number of occurrences of needle in a given positive number haystack,
    // Input
    // The first line of the input consists of an integer needle, representing a digit.
    // The second line consists of an integer haystack, representing the positive number.

    // Output
    // Print an integer representing the number of occurrences of needle in haystack.

    // Constraints
    // 0 <= needle <=9
    // 0 <= haystack <= 99999999

    // Example
    // Input
    // 2
    // 123228

    // Output
    // 3
    // Explanation
    // needle 2 occurs 3 times in the haystack

    public static int countOccurrences(int needle, int haystack)
    {
        int answer = 0;

        // Special case: haystack is 0
        if (haystack == 0)
        {
            return needle == 0 ? 1 : 0;
        }

        while (haystack > 0)
        {
            if (haystack % 10 == needle)
            {
                answer++;
            }
            haystack /= 10;
        }
        return answer;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        // input for needle
        int needle = in.nextInt();
        // input for haystack
        int haystack = in.nextInt();
        int result = countOccurrences(needle, haystack);
        System.out.print(result);
    }
}
