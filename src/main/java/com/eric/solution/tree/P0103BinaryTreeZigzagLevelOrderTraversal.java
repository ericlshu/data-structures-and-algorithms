package com.eric.solution.tree;

import com.eric.domain.TreeNode;

import java.util.*;

/**
 * Description : 二叉树的锯齿形层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * <p>
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 * <p>
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 提示：
 * 树中节点数目在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 *
 * @author Eric L SHU
 * @date 2022-10-25 12:04
 * @since jdk-11.0.14
 */
public class P0103BinaryTreeZigzagLevelOrderTraversal
{
    public List<List<Integer>> zigzagLevelOrder_1(TreeNode root)
    {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null)
            return lists;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> row = new ArrayList<>();
            while (size-- > 0)
            {
                TreeNode node;
                if (level % 2 == 0)
                {
                    node = queue.pollFirst();
                    if (node.left != null)
                        queue.offerLast(node.left);
                    if (node.right != null)
                        queue.offerLast(node.right);
                }
                else
                {
                    node = queue.pollLast();
                    if (node.right != null)
                        queue.offerFirst(node.right);
                    if (node.left != null)
                        queue.offerFirst(node.left);

                }
                row.add(node.val);
            }
            lists.add(row);
            level++;
        }
        return lists;
    }

    public List<List<Integer>> zigzagLevelOrder_2(TreeNode root)
    {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null)
            return lists;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> row = new ArrayList<>();
            while (size-- > 0)
            {
                TreeNode node = queue.poll();
                assert node != null;
                if (node.left != null)
                    queue.offerLast(node.left);
                if (node.right != null)
                    queue.offerLast(node.right);
                row.add(node.val);
            }
            if (level % 2 == 1)
                Collections.reverse(row);
            lists.add(row);
            level++;
        }
        return lists;
    }
}
