package com.shl;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2025-08-03 13:49
 */
public class T2025080301
{
    public static int[] funcBouquet(int[] flowerStick, int random)
    {
        int[] answer = new int[flowerStick.length];
        int temp;
        // 前 random 个升序
        int[] firstPart = Arrays.copyOfRange(flowerStick, 0, random);
        Arrays.sort(firstPart);

        // 剩余部分降序
        int[] secondPart = Arrays.copyOfRange(flowerStick, random, flowerStick.length);
        Arrays.sort(secondPart);
        for (int i = 0; i < secondPart.length / 2; i++)
        {
            temp = secondPart[i];
            secondPart[i] = secondPart[secondPart.length - 1 - i];
            secondPart[secondPart.length - 1 - i] = temp;
        }

        // 合并两个部分
        for (int i = 0; i < random; i++)
        {
            answer[i] = firstPart[i];
        }
        for (int i = 0; i < secondPart.length; i++)
        {
            answer[random + i] = secondPart[i];
        }

        return answer;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int flowerStick_size = in.nextInt();
        int[] flowerStick = new int[flowerStick_size];
        for (int i = 0; i < flowerStick_size; i++)
        {
            flowerStick[i] = in.nextInt();
        }

        int random = in.nextInt();

        int[] result = funcBouquet(flowerStick, random);
        for (int i = 0; i < result.length; i++)
        {
            System.out.print(result[i]);
            if (i != result.length - 1)
            {
                System.out.print(" ");
            }
        }
    }
}
