package com.eric.solution.tree;

import com.eric.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description : 相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1：
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 * <p>
 * 提示：
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -104 <= Node.val <= 104
 *
 * @author Eric L SHU
 * @date 2022-10-06 4:57 PM
 * @since jdk-11.0.14
 */
public class P0100SameTree
{
    public boolean isSameTree_bfs_1(TreeNode p, TreeNode q)
    {
        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();
        pQueue.offer(p);
        qQueue.offer(q);
        while (!pQueue.isEmpty() || !qQueue.isEmpty())
        {
            TreeNode pNode = pQueue.poll();
            TreeNode qNode = qQueue.poll();
            if (pNode == null && qNode == null)
                continue;
            if (pNode == null || qNode == null)
                return false;
            if (pNode.val != qNode.val)
                return false;
            pQueue.offer(pNode.left);
            pQueue.offer(pNode.right);
            qQueue.offer(qNode.left);
            qQueue.offer(qNode.right);
        }
        return true;
    }

    public boolean isSameTree_bfs_2(TreeNode p, TreeNode q)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty())
        {
            p = queue.poll();
            q = queue.poll();
            if (p == null && q == null)
                continue;
            if (p == null || q == null)
                return false;
            if (p.val != q.val)
                return false;
            queue.offer(p.left);
            queue.offer(q.left);
            queue.offer(p.right);
            queue.offer(q.right);
        }
        return true;
    }

    public boolean isSameTree_dfs(TreeNode p, TreeNode q)
    {
        if (p == null && q == null)
            return true;
        else if ((p == null || q == null) || (p.val != q.val))
            return false;
        else
            return isSameTree_dfs(p.left, q.left) && isSameTree_dfs(p.right, q.right);
    }
}
