package com.eric.solution.tree;

import com.eric.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description : 二叉树的层平均值
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 * 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
 * 因此返回 [3, 14.5, 11] 。
 * <p>
 * 示例 2:
 * 输入：root = [3,9,20,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 * <p>
 * 提示：
 * -> 树中节点数量在 [1, 104] 范围内
 * -> -231 <= Node.val <= 231 - 1
 *
 * @author Eric L SHU
 * @date 2022-12-14 19:32
 * @since jdk-11.0.14
 */
public class P0637AverageOfLevelsInBinaryTree
{
    public List<Double> averageOfLevels_bfs(TreeNode root)
    {
        ArrayList<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            list.add(sum / size);
        }
        return list;
    }

    public List<Double> averageOfLevels_dfs(TreeNode root)
    {
        List<Integer> cnt = new ArrayList<>();
        List<Double> res = new ArrayList<>();
        dfs(root, 0, cnt, res);
        for (int i = 0; i < res.size(); i++)
        {
            res.set(i, res.get(i) / cnt.get(i));
        }
        return res;
    }

    private void dfs(TreeNode root, int level, List<Integer> cnt, List<Double> res)
    {
        if (root == null)
            return;
        if (level < res.size())
        {
            res.set(level, res.get(level) + root.val);
            cnt.set(level, cnt.get(level) + 1);
        }
        else
        {
            res.add((double) root.val);
            cnt.add(1);
        }
        dfs(root.left, level + 1, cnt, res);
        dfs(root.right, level + 1, cnt, res);
    }
}
