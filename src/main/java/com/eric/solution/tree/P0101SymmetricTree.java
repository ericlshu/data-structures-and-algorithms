package com.eric.solution.tree;

import com.eric.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description : 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * <p>
 * 提示：
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 * <p>
 * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * @author Eric L SHU
 * @date 2022-09-29 21:10
 * @since jdk-11.0.14
 */
public class P0101SymmetricTree
{
    public boolean isSymmetricRecursion1(TreeNode root)
    {
        return check(root, root);
    }

    public boolean isSymmetricRecursion2(TreeNode root)
    {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode l, TreeNode r)
    {
        if (l == null && r == null)
            return true;
        if (l == null || r == null)
            return false;
        return l.val == r.val && check(l.left, r.right) && check(l.right, r.left);
    }

    public boolean isSymmetricIteration1(TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty())
        {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null)
                continue;
            if ((left == null || right == null) || (left.val != right.val))
                return false;

            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    public boolean isSymmetricIteration2(TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<TreeNode> row;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            row = new ArrayList<>();
            int idx = 0;
            while (idx < size)
            {
                TreeNode node = queue.remove();
                row.add(node);
                if (node != null)
                {
                    queue.add(node.left);
                    queue.add(node.right);
                }
                idx++;
            }
            // System.out.println("row = " + row);
            int left = 0, right = size - 1;
            while (left <= right)
            {
                if (row.get(left) == null && row.get(right) == null)
                {
                    right--;
                    left++;
                    continue;
                }
                if (row.get(left) == null || row.get(right) == null)
                    return false;
                if (row.get(left).val != row.get(right).val)
                    return false;
                right--;
                left++;
            }
        }
        return true;
    }
}
