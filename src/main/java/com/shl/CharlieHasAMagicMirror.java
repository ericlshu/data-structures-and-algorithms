package com.shl;

import java.util.Scanner;

/**
 * Description :
 * Charlie has a magic mirror that shows the right-rotated versions of a given word. To generate different right rotations of a word,
 * the word is written in a circle in a clockwise order and read it starting from any given character in a clockwise order until all the characters are covered,
 * For example, in the word "sample',if we start with 'p', we get the right rotated word as "plesarm".
 * Write an algorithm to output 1 if the word/ is a right rotation of word2 otherwise output -1,
 * <p>
 * Input
 * The first line of the input consists of a string, word, representing the first
 * word.The second line consists of a string, word2, representing, the second word.
 * <p>
 * Output
 * Print 1 if the wordj is a right rotation of word2 otherwise print-1
 * <p>
 * Note
 * Both word1 and word2 contain only lowercase letters between a-z.
 * <p>
 * Example
 * Input:
 * sample
 * plesam
 * <p>
 * Output:
 * 1
 * <p>
 * Explanation:
 * For the word "sample", if we start with "p", we get the right-rotated word as "plesam".
 * There are six such right rotations of "sample", including the original word. So,the output is 1.
 *
 * @author Eric L SHU
 * @date 2026-01-13 19:57
 */
public class CharlieHasAMagicMirror
{
    public static int isSameReflection(String word1, String word2)
    {
        // 如果两个字符串长度不同，一定不可能是旋转关系
        if (word1.length() != word2.length())
        {
            return -1;
        }

        // 把 word2 拼接两遍，这样就包含了所有旋转的可能
        String doubled = word2 + word2;

        // 如果 word1 是 doubled 的子串，说明 word1 是 word2 的旋转
        if (doubled.contains(word1))
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        // input for word1
        String word1 = in.nextLine();

        // input for word2
        String word2 = in.nextLine();

        int result = isSameReflection(word1, word2);
        System.out.print(result);
    }
}
