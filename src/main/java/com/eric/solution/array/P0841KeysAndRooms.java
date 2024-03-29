package com.eric.solution.array;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description : 钥匙和房间
 * 有 n 个房间，房间按从 0 到 n - 1 编号。最初，除 0 号房间外的其余所有房间都被锁住。你的目标是进入所有的房间。然而，你不能在没有获得钥匙的时候进入锁住的房间。
 * 当你进入一个房间，你可能会在里面找到一套不同的钥匙，每把钥匙上都有对应的房间号，即表示钥匙可以打开的房间。你可以拿上所有钥匙去解锁其他房间。
 * 给你一个数组 rooms 其中 rooms[i] 是你进入 i 号房间可以获得的钥匙集合。如果能进入 所有 房间返回 true，否则返回 false。
 * <p>
 * 示例 1：
 * 输入：rooms = [[1],[2],[3],[]]
 * 输出：true
 * 解释：
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 * <p>
 * 示例 2：
 * 输入：rooms = [[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 * <p>
 * 提示：
 * n == rooms.length
 * 2 <= n <= 1000
 * 0 <= rooms[i].length <= 1000
 * 1 <= sum(rooms[i].length) <= 3000
 * 0 <= rooms[i][j] < n
 * 所有 rooms[i] 的值 互不相同
 *
 * @author Eric L SHU
 * @date 2022-10-30 20:27
 * @since jdk-11.0.14
 */
public class P0841KeysAndRooms
{
    int idx;

    public boolean canVisitAllRooms_dfs(List<List<Integer>> rooms)
    {
        int n = rooms.size();
        idx = 0;
        boolean[] visited = new boolean[n];
        dfs(rooms, 0, visited);
        return idx == n;
    }

    private void dfs(List<List<Integer>> rooms, int x, boolean[] visited)
    {
        visited[x] = true;
        idx++;
        for (int id : rooms.get(x))
        {
            if (!visited[id])
            {
                dfs(rooms, id, visited);
            }
        }
    }

    public boolean canVisitAllRooms_bfs(List<List<Integer>> rooms)
    {
        int n = rooms.size(), num = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;
        queue.offer(0);
        while (!queue.isEmpty())
        {
            int x = queue.poll();
            num++;
            for (int it : rooms.get(x))
            {
                if (!visited[it])
                {
                    visited[it] = true;
                    queue.offer(it);
                }
            }
        }
        return num == n;
    }
}
