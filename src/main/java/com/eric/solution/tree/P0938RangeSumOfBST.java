package com.eric.solution.tree;

/*
 * 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 * 示例 1：
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 *
 * 示例 2：
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 *
 * 提示：
 * -> 树中节点数目在范围 [1, 2 * 104] 内
 * -> 1 <= Node.val <= 105
 * -> 1 <= low <= high <= 105
 * -> 所有 Node.val 互不相同
 */

import com.eric.domain.TreeNode;

import java.util.LinkedList;

public class P0938RangeSumOfBST
{
    public int rangeSumBSTInorder(TreeNode root, int low, int high)
    {
        TreeNode node = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        int sum = 0;
        while (node != null || !stack.isEmpty())
        {
            if (node != null)
            {
                stack.push(node);
                node = node.left;
            }
            else
            {
                TreeNode pop = stack.pop();
                if (pop.val > high)
                    break;
                if (pop.val >= low)
                    sum += pop.val;
                node = pop.right;
            }
        }
        return sum;
    }

    public int rangeSumBSTRecursion(TreeNode root, int low, int high)
    {
        if (root == null)
            return 0;
        if (root.val < low)
            return rangeSumBSTRecursion(root.right, low, high);
        if (root.val > high)
            return rangeSumBSTRecursion(root.left, low, high);
        return root.val +
                rangeSumBSTRecursion(root.left, low, high) +
                rangeSumBSTRecursion(root.right, low, high);
    }
}
