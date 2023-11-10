package com.eric.solution.tree;

import com.eric.domain.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2022-01-25 15:22
 * @since JDK 1.8
 */
public class P0145BinaryTreePostorderTraversal
{
    public List<Integer> postorderTraversalRecursion(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        postorderTraversal(root, list);
        return list;
    }

    private void postorderTraversal(TreeNode node, List<Integer> list)
    {
        if (node == null) return;
        postorderTraversal(node.left, list);
        postorderTraversal(node.right, list);
        list.add(node.val);
    }

    public List<Integer> postorderTraversalIteration1(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> stack = new LinkedList<>();
        // previous node been added to list
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null)
        {
            while (root != null)
            {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev)
            {
                list.add(root.val);
                prev = root;
                root = null;
            }
            else
            {
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }


    public List<Integer> postorderTraversalIteration2(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pop = null;
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null)
        {
            if (curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            else
            {
                TreeNode peek = stack.peek();
                if (peek.right == null || peek.right == pop)
                {
                    pop = stack.pop();
                    list.add(pop.val);
                }
                else
                {
                    curr = peek.right;
                }
            }
        }
        return list;
    }

    public List<Integer> postorderTraversalMorris(TreeNode root)
    {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null)
        {
            return res;
        }

        TreeNode p1 = root, p2 = null;

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
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                }
                else
                {
                    p2.right = null;
                    addPath(res, p1.left);
                }
            }
            p1 = p1.right;
        }
        addPath(res, root);
        return res;
    }

    private void addPath(List<Integer> res, TreeNode node)
    {
        int count = 0;
        while (node != null)
        {
            ++count;
            res.add(node.val);
            node = node.right;
        }
        int left = res.size() - count, right = res.size() - 1;
        while (left < right)
        {
            int temp = res.get(left);
            res.set(left, res.get(right));
            res.set(right, temp);
            left++;
            right--;
        }
    }
}
