package com.shl;

import java.util.*;

/**
 * Description :
 * A company sells its products at N outlets. All the outlets are connected to each other by a series of roads,
 * There is only one way to reach from one outlet to another. Each outlet of the company has a unique outlet ID.,
 * Whenever the inventory of a certain product reaches a minimum limit then these K outlets make a request for extra inventory.
 * The company sends the requested products from its warehouse to the outlets,In order to save on fuel,
 * the warehouse supervisor directs the driver Mike to deliver the products to the outlets along the shortest and most direct path possible
 * without traveling any single road twice.
 * Write an algorithm to help Mike deliver his inventory to the maximum number of outlets without traveling any road twice.
 *
 * @author Eric L SHU
 * @date 2026-01-13 20:04
 */
public class ACompanySellsItsProductsAtNOutlets
{
    // 全局变量
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static Set<String> usedEdges = new HashSet<>();

    public static int maxOutlets(int num, int[] reqOutletsIDs, int[][] roadCon) {
        // 构建图
        for (int i = 0; i < num; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : roadCon) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int count = 0;
        for (int outlet : reqOutletsIDs) {
            List<String> pathEdges = new ArrayList<>();
            boolean canReach = dfs(0, -1, outlet, pathEdges);

            // 如果路径上的边都没被用过，就标记并计数
            if (canReach) {
                boolean conflict = false;
                for (String e : pathEdges) {
                    if (usedEdges.contains(e)) {
                        conflict = true;
                        break;
                    }
                }
                if (!conflict) {
                    usedEdges.addAll(pathEdges);
                    count++;
                }
            }
        }

        return count;
    }

    // DFS 查找从 start 到 target 的路径，并记录边路径
    static boolean dfs(int current, int parent, int target, List<String> pathEdges) {
        if (current == target) return true;

        for (int neighbor : graph.get(current)) {
            if (neighbor == parent) continue;

            pathEdges.add(makeEdge(current, neighbor));
            boolean found = dfs(neighbor, current, target, pathEdges);
            if (found) return true;
            pathEdges.remove(pathEdges.size() - 1);
        }
        return false;
    }

    static String makeEdge(int a, int b) {
        return a < b ? a + "-" + b : b + "-" + a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int kCount = in.nextInt();

        int[] req = new int[kCount];
        for (int i = 0; i < kCount; i++) {
            req[i] = in.nextInt();
        }

        int numR = in.nextInt();
        int conOutlet = in.nextInt(); // 实际无用

        int[][] roads = new int[numR][2];
        for (int i = 0; i < numR; i++) {
            roads[i][0] = in.nextInt();
            roads[i][1] = in.nextInt();
        }

        System.out.println(maxOutlets(num, req, roads));
    }
}
