package com.eric.solution.tree;

import com.eric.domain.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description :  二叉树的前序遍历
 * <p>
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * <p>
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * <p>
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[1,2]
 * <p>
 * 示例 5：
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 * <p>
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @author Eric L SHU
 * @date 2020-10-27 20:51
 * @since JDK 1.8
 */
public class P0144BinaryTreePreorderTraversal
{
    public List<Integer> preorderTraversalRecursion(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }

    private void preorderTraversal(TreeNode node, List<Integer> res)
    {
        if (node == null) return;
        res.add(node.val);
        preorderTraversal(node.left, res);
        preorderTraversal(node.right, res);
    }

    public List<Integer> preorderTraversalIteration1(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null)
        {
            while (node != null)
            {
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return list;
    }

    public List<Integer> preorderTraversalIteration2(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty())
        {
            if (curr != null)
            {
                // System.out.println(curr.val);
                list.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            else
            {
                TreeNode pop = stack.pop();
                // System.out.println(pop.val);
                curr = pop.right;
            }
        }
        return list;
    }


    public List<Integer> preorderTraversalMorris(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        if (root == null)
        {
            return res;
        }

        TreeNode p1 = root, p2;

        while (p1 != null)
        {
            p2 = p1.left;
            if (p2 != null)
            {
                while (p2.right != null && p2.right != p1)
                {
                    p2 = p2.right;
                }
                if (p2.right == null)
                {
                    res.add(p1.val);
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                }
                else
                {
                    p2.right = null;
                }
            }
            else
            {
                res.add(p1.val);
            }
            p1 = p1.right;
        }
        return res;
    }
}
