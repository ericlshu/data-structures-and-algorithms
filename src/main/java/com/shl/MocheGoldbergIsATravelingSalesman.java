package com.shl;

import java.util.Scanner;

/**
 * Description :
 * <p>
 * Moche Goldberg is a traveling salesman, He works in N towns.
 * Each day he sells his production one of the towns, The towns that are chosen on any two successive days should be different and a town i can be chosen at most ci times.
 * Write an algorithm to determine the number of days when he can sell in the given towns
 * following the above-mentioned rules.
 * <p>
 * Input
 * The first line of the input consists of an integer num,representing the number of towns(N).
 * The next line consists of N space-separated integers countTown0, countTown1.., countTown n-1., representing the number of times each town can be chosen (ci).
 * <p>
 * Output
 * Print an integer representing the maximum number of days during which the salesman Can work
 * <p>
 * Example
 * Input:
 * 3
 * 7 2 3
 * Output:
 * 11
 * <p>
 * Explanation:
 * The first, second and third towns are chosen 7,2 and 3 times respectively.
 * The different towns are selected on successive days in a sequence: first,Second,first, third,first second, first,third,first, third, first.
 * So, the maximum number of days during which a salesman can sell is 11.
 *
 * @author Eric L SHU
 * @date 2026-01-13 19:46
 */
public class MocheGoldbergIsATravelingSalesman
{
    public static int maxDaysToWork(int[] countTown)
    {
        int sum = 0;
        int max = 0;

        for (int c : countTown)
        {
            sum += c;
            max = Math.max(max, c);
        }

        int rest = sum - max;

        if (max <= rest + 1)
        {
            // 可以全部使用
            return sum;
        }
        else
        {
            // 最大城镇过多，被限制
            return 2 * rest + 1;
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] countTown = new int[N];

        for (int i = 0; i < N; i++)
        {
            countTown[i] = scanner.nextInt();
        }

        scanner.close();

        int result = maxDaysToWork(countTown);
        System.out.println(result);
    }
}
