package com.eric.solution.tree;

import com.eric.domain.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description : 二叉树的中序遍历
 * <p>
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @author Eric L SHU
 * @date 2022-01-25 14:53
 * @since JDK 1.8
 */
public class P0094BinaryTreeInorderTraversal
{
    public List<Integer> inorderTraversalRecursion(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }

    private void inorderTraversal(TreeNode node, List<Integer> list)
    {
        if (node == null) return;
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
    }

    public List<Integer> inorderTraversalIteration1(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null)
        {
            while (node != null)
            {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
            node = node.right;
        }
        return list;
    }


    public List<Integer> inorderTraversalIteration2(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null)
        {
            if (node != null)
            {
                stack.push(node);
                node = node.left;
            }
            else
            {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }

    public List<Integer> inorderTraversalMorris(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        TreeNode predecessor;

        while (root != null)
        {
            if (root.left != null)
            {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root)
                {
                    predecessor = predecessor.right;
                }

                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null)
                {
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else
                {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else
            {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
