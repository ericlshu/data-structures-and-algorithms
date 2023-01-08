package solution.graph;

import java.util.*;

/**
 * Description : 所有可能的路径
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 * graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
 * <p>
 * 示例 1：
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 * <p>
 * 示例 2：
 * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * <p>
 * 提示：
 * -> n == graph.length
 * -> 2 <= n <= 15
 * -> 0 <= graph[i][j] < n
 * -> graph[i][j] != i（即不存在自环）
 * -> graph[i] 中的所有元素 互不相同
 * -> 保证输入为 有向无环图（DAG）
 *
 * @author Eric L SHU
 * @date 2023-01-08 22:22
 * @since jdk-11.0.14
 */
public class P0797AllPathsFromSourceToTarget
{
    List<List<Integer>> res;
    Deque<Integer> stack;

    public List<List<Integer>> allPathsSourceTarget_dfs(int[][] graph)
    {
        res = new ArrayList<>();
        stack = new ArrayDeque<>();
        stack.offer(0);
        dfs(graph, 0, graph.length - 1);
        return res;
    }

    private void dfs(int[][] graph, int x, int n)
    {
        if (x == n)
        {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int y : graph[x])
        {
            stack.offerLast(y);
            dfs(graph, y, n);
            stack.pollLast();
        }
    }

    public List<List<Integer>> allPathsSourceTarget_bfs(int[][] graph)
    {
        int n = graph.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(List.of(0));
        while (!queue.isEmpty())
        {
            int size = queue.size();
            while (size-- > 0)
            {
                List<Integer> path = queue.poll();
                int last = path.get(path.size() - 1);
                if (last == n)
                {
                    res.add(path);
                    continue;
                }
                for (int num : graph[last])
                {
                    ArrayList<Integer> _path = new ArrayList<>(path);
                    _path.add(num);
                    queue.offer(_path);
                }
            }
        }
        return res;
    }
}
