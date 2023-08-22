package com.eric.solution.tree;

import com.eric.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2022-09-29 21:07
 * @since jdk-11.0.14
 */
public class P0104MaximumDepthOfBinaryTree
{
    public int maxDepthRecursion(TreeNode root)
    {
        if (root == null)
            return 0;
        else
        {
            int leftHeight = maxDepthRecursion(root.left);
            int rightHeight = maxDepthRecursion(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public int maxDepthIteration(TreeNode root)
    {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ret = 0;
        while (queue.size() > 0)
        {
            int size = queue.size();
            while (size > 0)
            {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                size--;
            }
            ret++;
        }
        return ret;
    }
}
