package com.shl;

import java.util.*;

/**
 * Description :
 * John misses his bus and has to walk all his way from home to school.
 * The distance between his school and home is D units. He starts his journey with an initial energy of K units. His energy decreases by 1 unit for every unit of distance walked.
 * On his way to school, there are N juice stalls, Each stall has a specific amount of juice in liters, His energy increases by 1 unit for every liter of juice he consumes.
 * Note that inorder to keep him walking he should have non-zero energy.Write an algorithm to help John figure out the minimum number of juice stalls at which he should stop to successfully reach the school.
 * In case he can't reach the school,the output will be -1
 * <p>
 * Input
 * The first line of the input consists of an integer num Stalls, representing the number of juice stalls (N)
 * The second line consists of N space-separated integers - dis to dist.. dist.,representing, the distance of the ith stall from John's home.
 * The third line consists of an integer -num5, representing the number of stalls for available juices (M is always equal to N).
 * The fourth line consists of M space-separated integers - /to lit,. /ir ,representing the liters of juice available at the ith stall.
 * The fifth line consists of an integer - distance, representing the distance of the school from john's home (D).
 * The last line consists of an integer - initEnergy,representing the initial energy of john (K).
 * Output
 * Print an integer representing the minimum number of juice stalls at which john should stop to reach the school successfully.
 *
 * @author Eric L SHU
 * @date 2026-01-13 20:00
 */
public class JohnMissesHisBusAndHasToWalk
{
    public static int stallVisited(int[] dist, int[] lit, int distance, int initEnergy)
    {
        int n = dist.length;
        List<int[]> stalls = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            stalls.add(new int[]{dist[i], lit[i]});
        }

        // 把终点也当成一个补给点，果汁量为0
        stalls.add(new int[]{distance, 0});

        // 按距离升序排列
        stalls.sort(Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int ans = 0;
        int currEnergy = initEnergy;
        int prevDist = 0;

        for (int[] stall : stalls)
        {
            int currDist = stall[0];
            int juice = stall[1];

            int need = currDist - prevDist; // 需要走的距离

            currEnergy -= need;

            while (currEnergy < 0 && !maxHeap.isEmpty())
            {
                // 能量不足，补充之前遇到的最大果汁量
                currEnergy += maxHeap.poll();
                ans++;
            }

            if (currEnergy < 0)
            {
                // 没法继续走了
                return -1;
            }

            maxHeap.offer(juice);
            prevDist = currDist;
        }

        return ans;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int distSize = in.nextInt();
        int[] dist = new int[distSize];
        for (int i = 0; i < distSize; i++)
        {
            dist[i] = in.nextInt();
        }

        int litSize = in.nextInt();
        int[] lit = new int[litSize];
        for (int i = 0; i < litSize; i++)
        {
            lit[i] = in.nextInt();
        }

        int distance = in.nextInt();
        int initEnergy = in.nextInt();

        int result = stallVisited(dist, lit, distance, initEnergy);
        System.out.print(result);
    }
}
