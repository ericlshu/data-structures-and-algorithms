package solution.tree;

import domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description : 合并二叉树
 * 给你两棵二叉树： root1 和 root2 。
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。
 * 合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 * 返回合并后的二叉树。
 * 注意: 合并过程必须从两个树的根节点开始。
 * <p>
 * 示例 1：
 * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * 输出：[3,4,5,5,4,null,7]
 * <p>
 * 示例 2：
 * 输入：root1 = [1], root2 = [1,2]
 * 输出：[2,2]
 * <p>
 * 提示：
 * 两棵树中的节点数目在范围 [0, 2000] 内
 * -104 <= Node.val <= 104
 *
 * @author Eric L SHU
 * @date 2022-10-03 16:00
 * @since jdk-11.0.14
 */
public class P0617MergeTwoBinaryTrees
{
    public TreeNode mergeTrees_dfs(TreeNode root1, TreeNode root2)
    {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees_dfs(root1.left, root2.left);
        merged.right = mergeTrees_dfs(root1.right, root2.right);
        return merged;
    }

    // public TreeNode mergeTrees_bfs_1(TreeNode root1, TreeNode root2)
    // {
    //     if (root1 == null || root2 == null)
    //         return root1 == null ? root2 : root1;
    //
    //     TreeNode merged = new TreeNode(root1.val + root2.val);
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     Queue<TreeNode> queue1 = new LinkedList<>();
    //     Queue<TreeNode> queue2 = new LinkedList<>();
    //     queue.offer(merged);
    //     queue1.offer(root1);
    //     queue2.offer(root2);
    //     while (!queue1.isEmpty() && !queue2.isEmpty())
    //     {
    //         TreeNode node = queue.poll(), node1 = queue1.poll(), node2 = queue2.poll();
    //         TreeNode left1 = node1.left, left2 = node2.left, right1 = node1.right, right2 = node2.right;
    //         if (left1 != null || left2 != null)
    //         {
    //             if (left1 != null && left2 != null)
    //             {
    //                 TreeNode left = new TreeNode(left1.val + left2.val);
    //                 node.left = left;
    //                 queue.offer(left);
    //                 queue1.offer(left1);
    //                 queue2.offer(left2);
    //             }
    //             else if (left1 != null)
    //                 node.left = left1;
    //             else if (left2 != null)
    //                 node.left = left2;
    //         }
    //         if (right1 != null || right2 != null)
    //         {
    //             if (right1 != null && right2 != null)
    //             {
    //                 TreeNode right = new TreeNode(right1.val + right2.val);
    //                 node.right = right;
    //                 queue.offer(right);
    //                 queue1.offer(right1);
    //                 queue2.offer(right2);
    //             }
    //             else if (right1 != null)
    //                 node.right = right1;
    //             else
    //                 node.right = right2;
    //         }
    //     }
    //     return merged;
    // }

    public TreeNode mergeTrees_bfs_1(TreeNode root1, TreeNode root2)
    {
        if (root1 == null || root2 == null)
            return root1 == null ? root2 : root1;

        TreeNode merged = new TreeNode(root1.val + root2.val);
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue.offer(merged);
        queue1.offer(root1);
        queue2.offer(root2);
        while (!queue1.isEmpty() && !queue2.isEmpty())
        {
            TreeNode node = queue.poll(), node1 = queue1.poll(), node2 = queue2.poll();

            if (node1.left != null && node2.left != null)
            {
                TreeNode left = new TreeNode(node1.left.val + node2.left.val);
                node.left = left;
                queue.offer(left);
                queue1.offer(node1.left);
                queue2.offer(node2.left);
            }
            else
            {
                node.left = node1.left == null ? node2.left : node1.left;
            }

            if (node1.right != null && node2.right != null)
            {
                TreeNode right = new TreeNode(node1.right.val + node2.right.val);
                node.right = right;
                queue.offer(right);
                queue1.offer(node1.right);
                queue2.offer(node2.right);
            }
            else
            {
                node.right = node1.right == null ? node2.right : node1.right;
            }
        }
        return merged;
    }


    public TreeNode mergeTrees_bfs_2(TreeNode root1, TreeNode root2)
    {
        // 如果 t1和t2中，只要有一个是null，函数就直接返回
        if (root1 == null || root2 == null)
            return root1 == null ? root2 : root1;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        queue.add(root2);
        while (queue.size() > 0)
        {
            TreeNode node1 = queue.remove();
            TreeNode node2 = queue.remove();
            node1.val += node2.val;

            // 如果r1和r2的左子树都不为空，就放到队列中
            if (node1.left != null && node2.left != null)
            {
                queue.add(node1.left);
                queue.add(node2.left);
            }
            // 如果r1的左子树为空，就把r2的左子树挂到r1的左子树上
            else if (node1.left == null)
            {
                node1.left = node2.left;
            }
            // 如果r2的左子树为空，无需处理
            // 右子树同理
            if (node1.right != null && node2.right != null)
            {
                queue.add(node1.right);
                queue.add(node2.right);
            }
            else if (node1.right == null)
            {
                node1.right = node2.right;
            }
        }
        return root1;
    }
}
