package solution.tree;

import domain.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description :  二叉树的前序遍历
 * <p>
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * <p>
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * <p>
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[1,2]
 * <p>
 * 示例 5：
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 * <p>
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @author Eric L SHU
 * @date 2020-10-27 20:51
 * @since JDK 1.8
 */
public class P0144BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        preorderTraversalRecursion(root, res);
        return res;
    }

    /**
     * 递归
     */
    private void preorderTraversalRecursion(TreeNode node, List<Integer> res)
    {
        if (node == null) return;
        res.add(node.val);
        preorderTraversalRecursion(node.left, res);
        preorderTraversalRecursion(node.right, res);
    }

    /**
     * 迭代
     */
    public List<Integer> preorderTraversalIteration(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null)
        {
            while (node != null)
            {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }

    /**
     * Morris
     */
    public List<Integer> preorderTraversalMorris(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        if (root == null)
        {
            return res;
        }

        TreeNode p1 = root, p2;

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
                    res.add(p1.val);
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                }
                else
                {
                    p2.right = null;
                }
            }
            else
            {
                res.add(p1.val);
            }
            p1 = p1.right;
        }
        return res;
    }
}
