package com.eric.solution.tree;

import com.eric.domain.TreeNode;

/*
 * 前序遍历构造二叉搜索树
 * 给定一个整数数组，它表示BST(即 二叉搜索树 )的 先序遍历 ，构造树并返回其根。
 * 保证 对于给定的测试用例，总是有可能找到具有给定需求的二叉搜索树。
 * -> 二叉搜索树 是一棵二叉树，其中每个节点， Node.left 的任何后代的值 严格小于 Node.val , Node.right 的任何后代的值 严格大于 Node.val。
 * -> 二叉树的 前序遍历 首先显示节点的值，然后遍历Node.left，最后遍历Node.right。
 *
 * 示例 1：
 * 输入：preorder = [8,5,1,7,10,12]
 * 输出：[8,5,10,1,7,null,12]
 *
 * 示例 2:
 * 输入: preorder = [1,3]
 * 输出: [1,null,3]
 *
 * 提示：
 * -> 1 <= preorder.length <= 100
 * -> 1 <= preorder[i] <= 10^8
 * -> preorder 中的值 互不相同
 */
public class P1008ConstructBinarySearchTreeFromPreorderTraversal
{
    public TreeNode bstFromPreorder1(int[] preorder)
    {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++)
        {
            int val = preorder[i];
            insert(root, val);
        }
        return root;
    }

    private TreeNode insert(TreeNode node, int val)
    {
        if (node == null)
            return new TreeNode(val);
        if (val < node.val)
            node.left = insert(node.left, val);
        else
            node.right = insert(node.right, val);
        return node;
    }

    public TreeNode bstFromPreorder2(int[] preorder)
    {
        return insert(preorder, Integer.MAX_VALUE);
    }

    int idx = 0;

    private TreeNode insert(int[] preorder, int max)
    {
        if (idx == preorder.length)
            return null;
        int val = preorder[idx];
        if (val > max)
            return null;
        TreeNode node = new TreeNode(val);
        idx++;
        node.left = insert(preorder, val);
        node.right = insert(preorder, max);
        return node;
    }

    public TreeNode bstFromPreorder3(int[] preorder)
    {
        return partition(preorder, 0, preorder.length - 1);
    }

    private TreeNode partition(int[] preorder, int start, int end)
    {
        if (start > end)
            return null;
        TreeNode root = new TreeNode(preorder[start]);
        int idx = start + 1;
        while (idx <= end)
        {
            if (preorder[idx] > preorder[start])
                break;
            idx++;
        }
        root.left = partition(preorder, start + 1, idx - 1);
        root.right = partition(preorder, idx, end);
        return root;
    }
}
