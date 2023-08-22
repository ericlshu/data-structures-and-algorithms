package com.eric.solution.tree;

import com.eric.domain.TreeNode;

import java.util.*;

/**
 * Description : 两数之和 IV - 输入二叉搜索树
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果二叉搜索树中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * <p>
 * 示例 1：
 * 输入: root = [5,3,6,2,4,null,7], k = 9
 * 输出: true
 * <p>
 * 示例 2：
 * 输入: root = [5,3,6,2,4,null,7], k = 28
 * 输出: false
 * <p>
 * 提示:
 * 二叉树的节点个数的范围是  [1, 104].
 * -104 <= Node.val <= 104
 * 题目数据保证，输入的 root 是一棵 有效 的二叉搜索树
 * -105 <= k <= 105
 *
 * @author Eric L SHU
 * @date 2022-10-02 10:44
 * @since jdk-11.0.14
 */
public class P0653TwoSumIVInputIsABST
{
    Set<Integer> set = new HashSet<>();

    public boolean findTarget_dfs_hash(TreeNode root, int k)
    {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return findTarget_dfs_hash(root.left, k) || findTarget_dfs_hash(root.right, k);
    }

    public boolean findTarget_bfs_hash(TreeNode root, int k)
    {
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            // System.out.println("node = " + node);
            if (set.contains(k - node.val))
                return true;
            set.add(node.val);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
        return false;
    }

    public boolean findTarget_dfs_pt(TreeNode root, int k)
    {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        // System.out.println("list = " + list);
        int left = 0, right = list.size() - 1;
        while (left < right)
        {
            if (list.get(left) + list.get(right) == k)
                return true;
            if (list.get(left) + list.get(right) < k)
                left++;
            else
                right--;
        }
        return false;
    }

    private void inorderTraversal(TreeNode node, List<Integer> list)
    {
        if (node == null)
            return;
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
    }

    public boolean findTarget_iteration_dp(TreeNode root, int k)
    {
        TreeNode left = root, right = root;
        Deque<TreeNode> leftStack = new ArrayDeque<>();
        Deque<TreeNode> rightStack = new ArrayDeque<>();
        leftStack.push(left);
        while (left.left != null)
        {
            leftStack.push(left.left);
            left = left.left;
        }
        rightStack.push(right);
        while (right.right != null)
        {
            rightStack.push(right.right);
            right = right.right;
        }
        while (left != right)
        {
            if (left.val + right.val == k)
                return true;
            if (left.val + right.val < k)
                left = getLeft(leftStack);
            else
                right = getRight(rightStack);
        }
        return false;
    }

    private TreeNode getLeft(Deque<TreeNode> stack)
    {
        TreeNode root = stack.pop();
        TreeNode node = root.right;
        while (node != null)
        {
            stack.push(node);
            node = node.left;
        }
        return root;
    }

    private TreeNode getRight(Deque<TreeNode> stack)
    {
        TreeNode root = stack.pop();
        TreeNode node = root.left;
        while (node != null)
        {
            stack.push(node);
            node = node.right;
        }
        return root;
    }
}
