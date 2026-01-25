package com.shl;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2026-01-13 18:50
 */
public class MrHenryIsSavingMoneyToBuyANewCar
{
    public static int minStops(int num, int[] dis, int[] gas, int distance, int initialGas)
    {
        // 将加油站的信息按距离排序
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int fuel = initialGas, stops = 0, prev = 0;
        int i = 0;

        // 遍历每个加油站，并模拟行驶过程
        while (fuel < distance)
        {
            // 尽可能往前开，并将经过的加油站油量加入最大堆
            while (i < num && dis[i] <= fuel)
            {
                maxHeap.offer(gas[i]);
                i++;
            }

            // 如果无法到达下一个加油站且没有油可以加，则返回 -1
            if (maxHeap.isEmpty()) return -1;

            // 加油，选择经过的加油站中油量最大的加油站
            fuel += maxHeap.poll();
            stops++;
        }

        return stops;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // 输入
        int num = scanner.nextInt();
        int[] dis = new int[num];
        int[] gas = new int[num];
        for (int i = 0; i < num; i++)
        {
            dis[i] = scanner.nextInt();
        }
        int numS = scanner.nextInt();
        for (int i = 0; i < num; i++)
        {
            gas[i] = scanner.nextInt();
        }
        int distance = scanner.nextInt();
        int initialGas = scanner.nextInt();

        // 计算最小加油次数
        int result = minStops(num, dis, gas, distance, initialGas);

        // 输出结果
        System.out.println(result);
    }
}
