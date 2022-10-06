package solution.tree;

import domain.NaryNode;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2022-10-06 7:20 PM
 * @since jdk-11.0.14
 */
public class P0559MaximumDepthOfNaryTree
{
    public int maxDepth_bfs(NaryNode root)
    {
        if (root == null)
            return 0;
        int maxDepth = 0;
        Queue<NaryNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                NaryNode node = queue.poll();
                List<NaryNode> children = node.children;
                if (children != null)
                {
                    for (NaryNode child : children)
                    {
                        queue.offer(child);
                    }
                }
            }
            maxDepth++;
        }
        return maxDepth;
    }

    public int maxDepth_dfs(NaryNode root)
    {
        if (root == null)
            return 0;
        int maxDepth = 0;
        List<NaryNode> children = root.children;
        if (children != null)
        {
            for (NaryNode child : children)
            {
                maxDepth = Math.max(maxDepth_dfs(child), maxDepth);
            }
        }
        return maxDepth + 1;
    }
}
