package solution.tree;

import domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description : 二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * <p>
 * 示例 2:
 * 输入: [1,null,3]
 * 输出: [1,3]
 * <p>
 * 示例 3:
 * 输入: []
 * 输出: []
 * <p>
 * 提示:
 * 二叉树的节点个数的范围是 [0,100]
 * -100 <= Node.val <= 100
 *
 * @author Eric L SHU
 * @date 2022-10-25 13:15
 * @since jdk-11.0.14
 */
public class P0199BinaryTreeRightSideView
{
    public List<Integer> rightSideView_bfs(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            list.add(queue.getLast().val);
            int size = queue.size();
            while (size-- > 0)
            {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offerLast(node.left);
                if (node.right != null)
                    queue.offerLast(node.right);
            }
        }
        return list;
    }

    public List<Integer> rightSideView_dfs(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        // 从根节点开始访问，根节点深度是0
        dfs(root, 0, list);
        return list;
    }

    private void dfs(TreeNode root, int depth, List<Integer> list)
    {
        if (root == null)
            return;
        // 先访问 当前节点，再递归地访问 右子树 和 左子树。
        if (depth == list.size())
        {   // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
            list.add(root.val);
        }
        depth++;
        dfs(root.right, depth, list);
        dfs(root.left, depth, list);
    }
}
