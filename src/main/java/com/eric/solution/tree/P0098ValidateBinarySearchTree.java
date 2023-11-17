package com.eric.solution.tree;

import com.eric.domain.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description : 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * -> 节点的左子树只包含 小于 当前节点的数。
 * -> 节点的右子树只包含 大于 当前节点的数。
 * -> 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 示例 1：
 * 输入：root = [2,1,3]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 * <p>
 * 提示：
 * -> 树中节点数目范围在[1, 104] 内
 * -> -231 <= Node.val <= 231 - 1
 *
 * @author Eric L SHU
 * @date 2022-10-02 11:22
 * @since jdk-11.0.14
 */
public class P0098ValidateBinarySearchTree
{
    public boolean isValidBST_sort(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);

        int idx = 1;
        while (idx < list.size())
        {
            if (list.get(idx) <= list.get(idx - 1))
                return false;
            idx++;
        }
        return true;
    }

    private void inorderTraversal(TreeNode node, List<Integer> list)
    {
        if (node == null)
            return;
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
    }

    public boolean isValidBST_recursion(TreeNode root)
    {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long lower, long upper)
    {
        if (node == null)
            return true;
        if (node.val <= lower || node.val >= upper)
            return false;
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    public boolean isValidBST_inorder(TreeNode root)
    {
        Deque<TreeNode> stack = new LinkedList<>();
        long lower = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null)
        {
            while (root != null)
            {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= lower)
                return false;
            lower = root.val;
            root = root.right;
        }
        return true;
    }

    long prev = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root)
    {
        // if (root == null)
        //     return true;
        // boolean leftValid = isValidBST(root.left);
        // if (root.val <= prev)
        //     return false;
        // prev = root.val;
        // boolean rightValid = isValidBST(root.right);
        // return leftValid && rightValid;

        if (root == null)
            return true;
        boolean leftValid = isValidBST(root.left);
        if(!leftValid)
            return false;
        if (root.val <= prev)
            return false;
        prev = root.val;
        return isValidBST(root.right);
    }
}
