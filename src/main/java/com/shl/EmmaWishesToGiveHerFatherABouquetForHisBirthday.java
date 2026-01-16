package com.shl;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description :
 * Emma wishes to give her father a bouquet for his birthday. She asks for help from her mother Rosy. Rosy gives N flower sticks numbered 1 to N to Emma and tells her to arrange them in the bouquet in a particular order. She asks Emma to arrange the first K flower sticks in the order of increasing length and the remaining sticks in the order of decreasing length.
 * Write an algorithm to find the final arrangement of the flower sticks in the bouquet.
 * <p>
 * Input
 * The first line of the input consists of an integer – flowerStick_size, representing the number of flower sticks (N).
 * The second line consists of N space-separated integers – flowerStick[], representing the length of the flower sticks.
 * The last line consists of an integer – random, representing the number K given by Rosy to Emma.
 * Output
 * Print N space-separated integers representing the final arrangement of the flower sticks in the bouquet.
 * <p>
 * Constraints
 * 0 ≤ random ≤ flowerStick_size
 * 0 < flowerStick_size < 10⁶
 * <p>
 * Example
 * Input:
 * 8
 * 11 7 5 10 46 23 16 8
 * 3
 * Output:
 * 5 7 11 46 23 16 10 8
 * <p>
 * Explanation
 * Emma has to arrange the first three flower sticks in an increasing order of the length and remaining sticks in the decreasing order of the length.
 * The final order of flower sticks in the bouquet is
 * [5, 7, 11, 46, 23, 16, 10, 8]
 *
 * @author Eric L SHU
 * @date 2026-01-13 19:37
 */
public class EmmaWishesToGiveHerFatherABouquetForHisBirthday
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // 读取输入
        int flowerStickSize = sc.nextInt();
        int[] flowerSticks = new int[flowerStickSize];
        for (int i = 0; i < flowerStickSize; i++)
        {
            flowerSticks[i] = sc.nextInt();
        }
        int random = sc.nextInt();

        // 前 K 个按升序排列
        int[] firstPart = Arrays.copyOfRange(flowerSticks, 0, random);
        Arrays.sort(firstPart);

        // 剩余部分按降序排列
        int[] secondPart = Arrays.copyOfRange(flowerSticks, random, flowerStickSize);
        Arrays.sort(secondPart);
        for (int i = 0; i < secondPart.length / 2; i++)
        {
            int temp = secondPart[i];
            secondPart[i] = secondPart[secondPart.length - 1 - i];
            secondPart[secondPart.length - 1 - i] = temp;
        }

        // 合并结果
        int[] result = new int[flowerStickSize];
        System.arraycopy(firstPart, 0, result, 0, firstPart.length);
        System.arraycopy(secondPart, 0, result, firstPart.length, secondPart.length);

        // 输出结果
        for (int i = 0; i < result.length; i++)
        {
            System.out.print(result[i]);
            if (i < result.length - 1)
            {
                System.out.print(" ");
            }
        }
    }
}
