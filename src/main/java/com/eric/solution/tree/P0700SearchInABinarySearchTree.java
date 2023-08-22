package com.eric.solution.tree;

import com.eric.domain.TreeNode;

/**
 * Description : 二叉搜索树中的搜索
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 * <p>
 * 示例 1:
 * 输入：root = [4,2,7,1,3], val = 2
 * 输出：[2,1,3]
 * <p>
 * 示例 2:
 * 输入：root = [4,2,7,1,3], val = 5
 * 输出：[]
 * <p>
 * 提示：
 * 数中节点数在 [1, 5000] 范围内
 * 1 <= Node.val <= 107
 * root 是二叉搜索树
 * 1 <= val <= 107
 *
 * @author Eric L SHU
 * @date 2022-10-01 6:07 PM
 * @since jdk-11.0.14
 */
public class P0700SearchInABinarySearchTree
{
    public TreeNode searchBSTRecursion(TreeNode root, int val)
    {
        if (root == null)
            return null;
        if (root.val == val)
            return root;
        else if (val < root.val)
            return searchBSTRecursion(root.left, val);
        else
            return searchBSTRecursion(root.right, val);
    }

    public TreeNode searchBSTIteration(TreeNode root, int val)
    {
        while (root != null)
        {
            if (root.val == val)
                return root;
            else if (val < root.val)
                root = root.left;
            else
                root = root.right;
        }
        return null;
    }
}
