package solution.tree;

import domain.TreeNode;

import java.util.*;

/**
 * Description : 二叉树的所有路径
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * <p>
 * 示例 2：
 * 输入：root = [1]
 * 输出：["1"]
 * <p>
 * 提示：
 * 树中节点的数目在范围 [1, 100] 内
 * -100 <= Node.val <= 100
 *
 * @author Eric L SHU
 * @date 2022-10-06 4:12 PM
 * @since jdk-11.0.14
 */
public class P0257BinaryTreePaths
{
    public List<String> binaryTreePaths_dfs(TreeNode root)
    {
        List<String> list = new ArrayList<>();
        dfs_1(root, new StringBuilder(), list);
        dfs_2(root, new StringBuilder(), list);
        return list;
    }

    private void dfs_1(TreeNode node, StringBuilder path, List<String> list)
    {
        path.append(node.val);
        if (node.left == null && node.right == null)
        {
            list.add(path.toString());
            return;
        }
        if (node.left != null)
        {
            dfs_1(node.left, new StringBuilder(path).append("->"), list);
        }
        if (node.right != null)
        {
            dfs_1(node.right, new StringBuilder(path).append("->"), list);
        }
    }

    private void dfs_2(TreeNode node, StringBuilder path, List<String> list)
    {
        if (node != null)
        {
            path.append(node.val);
            if (node.left == null && node.right == null)
                list.add(path.toString());
            else
            {
                path.append("->");
                dfs_2(node.left, new StringBuilder(path), list);
                dfs_2(node.right, new StringBuilder(path), list);
            }
        }
    }

    public List<String> binaryTreePaths_bfs(TreeNode root)
    {
        List<String> list = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();
        nodeQueue.offer(root);
        pathQueue.offer(String.valueOf(root.val));

        while (!nodeQueue.isEmpty())
        {
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();

            if (node.left == null && node.right == null)
                list.add(path);
            else
            {
                if (node.left != null)
                {
                    nodeQueue.offer(node.left);
                    pathQueue.offer(path + "->" + node.left.val);
                }
                if (node.right != null)
                {
                    nodeQueue.offer(node.right);
                    pathQueue.offer(path + "->" + node.right.val);
                }
            }
        }
        return list;
    }
}
