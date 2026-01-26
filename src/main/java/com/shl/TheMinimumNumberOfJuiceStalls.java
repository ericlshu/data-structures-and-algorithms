package com.shl;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Description : Input
 * The first line of the input consists of an integer-
 * nunStal/ls, representing the number of juice stalls (N).The second line consists of N space-separated integers - distodist,.., distw. representing the distance of the ith stall fromJohn's home.
 * The third line consists of an integer - numS, representing the number of stalls for available juices (M is always equal to N),The fourth line consists of M space-separated integers -lita /it,..litm-; representing the liters of juice available at the ith stall.
 * The fifth line consists of an integer - distance, representing the
 * distance of the school from John's home (D).
 * The last line consists of an integer - initEnergy, representing the
 * initial energy of John (K).
 * Output
 * Print an integer representing the minimum number of juice stalls at which john should stop to reach the school successfully.
 * <p>
 * Example
 * Input:
 * 3
 * 5 7 10
 * 3
 * 2 3 5
 * 15
 * 5
 * Output
 * 3
 *
 * @author Eric L SHU
 * @date 2026-01-13 19:00
 */
public class TheMinimumNumberOfJuiceStalls
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // 输入
        int numStalls = scanner.nextInt();
        int[] distances = new int[numStalls];
        for (int i = 0; i < numStalls; i++)
        {
            distances[i] = scanner.nextInt();
        }

        int numS = scanner.nextInt(); // 等于 numStalls
        int[] juices = new int[numS];
        for (int i = 0; i < numS; i++)
        {
            juices[i] = scanner.nextInt();
        }

        int distance = scanner.nextInt();
        int initEnergy = scanner.nextInt();

        // 优先队列（大根堆）用于存储果汁量
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int stops = 0;
        int currentEnergy = initEnergy;
        int prevDistance = 0;

        for (int i = 0; i < numStalls; i++)
        {
            int requiredEnergy = distances[i] - prevDistance;

            // 如果当前能量不足以到达下一个摊位，尝试从堆中取果汁
            while (currentEnergy < requiredEnergy)
            {
                if (maxHeap.isEmpty())
                {
                    System.out.println(-1); // 无法到达学校
                    return;
                }
                currentEnergy += maxHeap.poll();
                stops++;
            }

            currentEnergy -= requiredEnergy;
            maxHeap.offer(juices[i]);
            prevDistance = distances[i];
        }

        // 最后检查从最后一个摊位到学校的距离
        int requiredEnergyToSchool = distance - prevDistance;
        while (currentEnergy < requiredEnergyToSchool)
        {
            if (maxHeap.isEmpty())
            {
                System.out.println(-1); // 无法到达学校
                return;
            }
            currentEnergy += maxHeap.poll();
            stops++;
        }

        System.out.println(stops);
    }
}
