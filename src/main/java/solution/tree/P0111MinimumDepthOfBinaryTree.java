package solution.tree;

import domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description : 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * <p>
 * 提示：
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 *
 * @author Eric L SHU
 * @date 2022-10-06 5:31 PM
 * @since jdk-11.0.14
 */
public class P0111MinimumDepthOfBinaryTree
{
    public int minDepth_bfs(TreeNode root)
    {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minDepth = 1;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null)
                    return minDepth;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            minDepth++;
        }
        return minDepth;
    }

    public int minDepth_dfs_1(TreeNode root)
    {
        if (root == null)
            return 0;
        else if (root.left == null)
            return minDepth_dfs_1(root.right) + 1;
        else if (root.right == null)
            return minDepth_dfs_1(root.left) + 1;
        else
            return Math.min(minDepth_dfs_1(root.left), minDepth_dfs_1(root.right)) + 1;
    }

    public int minDepth_dfs_2(TreeNode root)
    {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int min_depth = 100_001;
        if (root.left != null)
            min_depth = Math.min(minDepth_dfs_2(root.left), min_depth);
        if (root.right != null)
            min_depth = Math.min(minDepth_dfs_2(root.right), min_depth);
        return min_depth + 1;
    }

    public int minDepth_dfs_3(TreeNode root)
    {
        if (root == null)
            return 0;
        int left = minDepth_dfs_3(root.left);
        int right = minDepth_dfs_3(root.right);
        // 如果左子树和右子树的深度都不为 0，即左右子树都存在，那么当前子树的最小深度就是它们较小值+1
        if (left != 0 && right != 0)
            return Math.min(left, right) + 1;
            // 如果左子树或右子树的深度为 0，即存在一个子树，那么当前子树的最小深度就是该子树的深度+1
            // left == 0 || right == 0
        else
            return left + right + 1;
    }
}
