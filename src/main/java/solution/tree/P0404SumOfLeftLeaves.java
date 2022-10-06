package solution.tree;

import domain.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Description : 左叶子之和
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 * <p>
 * 示例 1：
 * 输入: root = [3,9,20,null,null,15,7]
 * 输出: 24
 * 解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * <p>
 * 示例 2:
 * 输入: root = [1]
 * 输出: 0
 * <p>
 * 提示:
 * 节点数在 [1, 1000] 范围内
 * -1000 <= Node.val <= 1000
 *
 * @author Eric L SHU
 * @date 2022-10-06 6:16 PM
 * @since jdk-11.0.14
 */
public class P0404SumOfLeftLeaves
{
    public int sumOfLeftLeaves_status(TreeNode root)
    {
        Queue<MyTreeNode> queue = new ArrayDeque<>();
        int sum = 0;
        queue.offer(new MyTreeNode(root, false));
        while (!queue.isEmpty())
        {
            MyTreeNode myNode = queue.poll();
            TreeNode node = myNode.node;
            if (myNode.isLeft && node.left == null && node.right == null)
                sum += node.val;
            if (node.left != null)
                queue.offer(new MyTreeNode(node.left, true));
            if (node.right != null)
                queue.offer(new MyTreeNode(node.right, false));
        }
        return sum;
    }

    class MyTreeNode
    {
        TreeNode node;
        boolean isLeft;

        public MyTreeNode(TreeNode node, boolean isLeft)
        {
            this.node = node;
            this.isLeft = isLeft;
        }

    }
    public int sumOfLeftLeaves_dfs(TreeNode root)
    {
        int leftSum = 0;
        if (root.left != null)
            leftSum += isLeafNode(root.left) ? root.left.val : sumOfLeftLeaves_dfs(root.left);
        if (root.right != null && !isLeafNode(root.right))
            leftSum += sumOfLeftLeaves_dfs(root.right);
        return leftSum;
    }

    public int sumOfLeftLeaves_dfs_2(TreeNode root)
    {
        dfs(root, false);
        return sum;
    }

    int sum = 0;

    public void dfs(TreeNode node, boolean isLeft)
    {
        if (node == null)
            return;
        if (isLeft && isLeafNode(node))
            sum += node.val;
        dfs(node.left, true);
        dfs(node.right, false);
    }

    // private int dfs(TreeNode node)
    // {
    //     int leftSum = 0;
    //     if (node.left != null)
    //         leftSum += isLeafNode(node.left) ? node.left.val : dfs(node.left);
    //     if (node.right != null && !isLeafNode(node.right))
    //         leftSum += dfs(node.right);
    //     return leftSum;
    // }

    private boolean isLeafNode(TreeNode node)
    {
        return node.left == null && node.right == null;
    }

    public int sumOfLeftLeaves_bfs(TreeNode root)
    {
        Queue<TreeNode> queue = new ArrayDeque<>();
        int leftSum = 0;
        queue.offer(root);
        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if (node.left != null)
            {
                if (isLeafNode(node.left))
                    leftSum += node.left.val;
                else
                    queue.offer(node.left);
            }
            if (node.right != null && !isLeafNode(node.right))
                queue.offer(node.right);
        }
        return leftSum;
    }
}
