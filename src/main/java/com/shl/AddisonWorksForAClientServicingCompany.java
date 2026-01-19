package com.shl;

import java.util.*;

/**
 * Description :
 * Addison works for a Client servicing company whose head office is located in zone'1 in city,
 * He has to provide service to the customer in a zone and return back to head office after servicing each complaint,
 * Since he is not well he likes to optimize the rest time after each service he provides,
 * Hence, he tries to locate the minimum distance between the head office and the target zoneThere are N zones, numbered i to N,
 * connected by M bidirectional roads such that every zone is connected to the head office either directly or via any other zone.
 * Addison is given a list of M pairs of two zones [A, B]and the time c needed to reach from zone A to zone B.
 *
 * @author Eric L SHU
 * @date 2025-08-06 16:38
 */
public class AddisonWorksForAClientServicingCompany
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        // input for numZones
        int numZones = in.nextInt();
        // input for travelTime
        int travelTime_row = in.nextInt();
        int travelTime_col = in.nextInt();
        int[][] travelTime = new int[travelTime_row][travelTime_col];
        for (int idx = 0; idx < travelTime_row; idx++)
        {
            for (int jdx = 0; jdx < travelTime_col; jdx++)
            {
                travelTime[idx][jdx] = in.nextInt();
            }
        }

        // input for timeLimit
        int timeLimit_row = in.nextInt();
        int timeLimit_col = in.nextInt();
        int[][] timeLimit = new int[timeLimit_row][timeLimit_col];
        for (int idx = 0; idx < timeLimit_row; idx++)
        {
            for (int jdx = 0; jdx < timeLimit_col; jdx++)
            {
                timeLimit[idx][jdx] = in.nextInt();
            }
        }

        int[] result = zoneRestTime(numZones, travelTime, timeLimit);
        for (int idx = 0; idx < result.length - 1; idx++)
        {
            System.out.print(result[idx] + " ");
        }
        System.out.print(result[result.length - 1]);
    }

    private static int[] zoneRestTime(int numZones, int[][] travelTime, int[][] timeLimit)
    {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : travelTime)
        {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new int[]{edge[0], edge[2]});
        }

        // 用 Dijkstra 算法从 zone 1 计算到其他区域的最短路径
        int[] minDist = new int[numZones + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{1, 0});
        minDist[1] = 0;

        while (!pq.isEmpty())
        {
            int[] curr = pq.poll();
            int zone = curr[0], dist = curr[1];
            if (dist > minDist[zone]) continue;
            if (!graph.containsKey(zone)) continue;

            for (int[] nei : graph.get(zone))
            {
                int nextZone = nei[0], time = nei[1];
                if (minDist[nextZone] > dist + time)
                {
                    minDist[nextZone] = dist + time;
                    pq.offer(new int[]{nextZone, minDist[nextZone]});
                }
            }
        }

        // 处理每个投诉
        int[] answer = new int[timeLimit.length];
        for (int i = 0; i < timeLimit.length; i++)
        {
            int zoneX = timeLimit[i][0];
            int timeK = timeLimit[i][1];
            int roundTrip = 2 * minDist[zoneX];
            answer[i] = (roundTrip <= timeK) ? (timeK - roundTrip) : 0;
        }

        return answer;
    }
}
