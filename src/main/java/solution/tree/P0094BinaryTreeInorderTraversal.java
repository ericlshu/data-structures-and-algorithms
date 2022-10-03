package solution.tree;

import domain.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description : 二叉树的中序遍历
 * <p>
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @author Eric L SHU
 * @date 2022-01-25 14:53
 * @since JDK 1.8
 */
public class P0094BinaryTreeInorderTraversal
{
    public List<Integer> inorderTraversalRecursion(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }

    private void inorderTraversal(TreeNode node, List<Integer> list)
    {
        if (node == null) return;
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
    }

    public List<Integer> inorderTraversalIteration(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null)
        {
            while (node != null)
            {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
            node = node.right;
        }
        return list;
    }

    public List<Integer> inorderTraversalMorris(TreeNode root)
    {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode predecessor = null;

        while (root != null)
        {
            if (root.left != null)
            {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root)
                {
                    predecessor = predecessor.right;
                }

                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null)
                {
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else
                {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else
            {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    /**
     * Description : 求根到叶子节点数字之和
     * <p>
     * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
     * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
     * 计算从根到叶子节点生成的所有数字之和。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     * <p>
     * 示例 1:
     * 输入: [1,2,3]
     * 1
     * / \
     * 2   3
     * 输出: 25
     * 解释:
     * 从根到叶子节点路径 1->2 代表数字 12.
     * 从根到叶子节点路径 1->3 代表数字 13.
     * 因此，数字总和 = 12 + 13 = 25.
     * <p>
     * 示例 2:
     * 输入: [4,9,0,5,1]
     * 4
     * / \
     * 9   0
     * / \
     * 5   1
     * 输出: 1026
     * 解释:
     * 从根到叶子节点路径 4->9->5 代表数字 495.
     * 从根到叶子节点路径 4->9->1 代表数字 491.
     * 从根到叶子节点路径 4->0 代表数字 40.
     * 因此，数字总和 = 495 + 491 + 40 = 1026.
     *
     * @author Eric L SHU
     * @date 2020-10-29 22:50
     * @since JDK 1.8
     */
    public static class P0129SumRootToLeafNumbers
    {
        public int sumNumbers(TreeNode root)
        {
            return dfs(root, 0);
        }

        public int dfs(TreeNode root, int prevSum)
        {
            if (root == null) return 0;
            int sum = prevSum * 10 + root.val;
            if (root.left == null && root.right == null)
                return sum;
            else
                return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}
