package com.eric.solution.tree;

import com.eric.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Description : 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 解释：等于目标和的根节点到叶节点路径如上图所示。
 * <p>
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * 解释：树中存在两条根节点到叶子节点的路径：
 * (1 --> 2): 和为 3
 * (1 --> 3): 和为 4
 * 不存在 sum = 5 的根节点到叶子节点的路径。
 * <p>
 * 示例 3：
 * 输入：root = [], targetSum = 0
 * 输出：false
 * 解释：由于树是空的，所以不存在根节点到叶子节点的路径。
 *
 * @author Eric L SHU
 * @date 2022-09-30 8:30 PM
 * @since jdk-11.0.14
 */
public class P0112PathSum
{
    public boolean hasPathSumRecursion(TreeNode root, int targetSum)
    {
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return targetSum == root.val;
        return hasPathSumRecursion(root.left, targetSum - root.val) || hasPathSumRecursion(root.right, targetSum - root.val);
    }

    public boolean hasPathSumDFS(TreeNode root, int targetSum)
    {
        if (root == null)
            return false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null)
            {
                if (node.val == targetSum)
                    return true;
            }
            else
            {
                if (node.left != null)
                {
                    node.left.val += node.val;
                    stack.push(node.left);
                }
                if (node.right != null)
                {
                    node.right.val += node.val;
                    stack.push(node.right);
                }
            }
        }
        return false;
    }

    public boolean hasPathSumBFS2(TreeNode root, int targetSum)
    {
        if (root == null)
            return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null)
            {
                if (node.val == targetSum)
                    return true;
            }
            else
            {
                if (node.left != null)
                {
                    node.left.val += node.val;
                    queue.offer(node.left);
                }
                if (node.right != null)
                {
                    node.right.val += node.val;
                    queue.offer(node.right);
                }
            }
        }
        return false;
    }

    public boolean hasPathSumBFS1(TreeNode root, int targetSum)
    {
        if (root == null)
            return false;

        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> queVal = new LinkedList<>();

        queNode.offer(root);
        queVal.offer(root.val);

        while (!queNode.isEmpty())
        {
            TreeNode node = queNode.poll();
            int temp = queVal.poll();
            if (node.left == null && node.right == null)
            {
                if (temp == targetSum)
                    return true;
                continue;
            }
            if (node.left != null)
            {
                queNode.offer(node.left);
                queVal.offer(node.left.val + temp);
            }
            if (node.right != null)
            {
                queNode.offer(node.right);
                queVal.offer(node.right.val + temp);
            }
        }
        return false;
    }

}
