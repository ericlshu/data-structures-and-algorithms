package solution.tree;

import domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Description : 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * <p>
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * <p>
 * 示例 2：
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 * <p>
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 提示：
 * 树中节点数目范围在 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * @author Eric L SHU
 * @date 2022-09-30 8:27 PM
 * @since jdk-11.0.14
 */
public class P0226InvertBinaryTree
{
    public TreeNode invertTreeRecursion(TreeNode root)
    {
        if (root == null)
            return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTreeRecursion(root.left);
        invertTreeRecursion(root.right);

        return root;
    }

    public TreeNode invertTreeBFS(TreeNode root)
    {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            // System.out.println("node = " + node);
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
        return root;
    }

    public TreeNode invertTreeDFS(TreeNode root)
    {
        if (root == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty())
        {
            int size = stack.size();
            for (int i = 0; i < size; i++)
            {
                TreeNode node = stack.pop();
                // System.out.println("node = " + node);
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                if (node.left != null)
                    stack.push(node.left);
                if (node.right != null)
                    stack.push(node.right);
            }
        }
        return root;
    }
}
