package solution.tree;

import domain.TreeNode;

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
 * @date 2022-10-05 20:13
 * @since jdk-11.0.14
 */
public class P0100SameTree
{
    public boolean isSameTree_bfs(TreeNode p, TreeNode q)
    {
        if (p == null && q == null)
        {
            return true;
        }
        else if (p == null || q == null)
        {
            return false;
        }
        else if (p.val != q.val)
        {
            return false;
        }
        else
        {
            return isSameTree_bfs(p.left, q.left) && isSameTree_bfs(p.right, q.right);
        }
    }

    public boolean isSameTree_dfs(TreeNode p, TreeNode q)
    {
        if (p == null && q == null)
        {
            return true;
        }
        else if (p == null || q == null)
        {
            return false;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty())
        {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.val != node2.val)
            {
                return false;
            }
            TreeNode left1 = node1.left, right1 = node1.right, left2 = node2.left, right2 = node2.right;
            if (left1 == null ^ left2 == null)
            {
                return false;
            }
            if (right1 == null ^ right2 == null)
            {
                return false;
            }
            if (left1 != null)
            {
                queue1.offer(left1);
            }
            if (right1 != null)
            {
                queue1.offer(right1);
            }
            if (left2 != null)
            {
                queue2.offer(left2);
            }
            if (right2 != null)
            {
                queue2.offer(right2);
            }
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
