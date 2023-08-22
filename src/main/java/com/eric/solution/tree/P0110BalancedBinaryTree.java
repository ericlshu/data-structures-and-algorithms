package com.eric.solution.tree;

import com.eric.domain.TreeNode;

/**
 * Description : 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：root = []
 * 输出：true
 * <p>
 * 提示：
 * 树中的节点数在范围 [0, 5000] 内
 * -104 <= Node.val <= 104
 *
 * @author Eric L SHU
 * @date 2022-12-01 9:25
 * @since jdk-11.0.14
 */
public class P0110BalancedBinaryTree
{
    public boolean isBalanced_n2(TreeNode root)
    {
        if (root == null)
            return true;
        else
            return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1
                    && isBalanced_n2(root.left) && isBalanced_n2(root.right);
    }

    private int getHeight(TreeNode root)
    {
        if (root == null)
            return 0;
        else
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public boolean isBalanced_n(TreeNode root)
    {
        return dfs(root) >= 0;
    }

    public int dfs(TreeNode node)
    {
        if (node == null)
            return 0;
        // int leftHeight = dfs(node.left);
        // int rightHeight = dfs(node.right);
        // if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1)
        //     return -1;
        int leftHeight, rightHeight;
        if ((leftHeight = dfs(node.left)) == -1 || (rightHeight = dfs(node.right)) == -1
                || Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        else
            return Math.max(leftHeight, rightHeight) + 1;
    }
}
