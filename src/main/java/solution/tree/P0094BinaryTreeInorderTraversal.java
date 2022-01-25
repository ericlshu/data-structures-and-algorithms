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
public class P0094BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        inorderTraversalRecursion(root, list);
        return list;
    }

    /**
     * 递归
     */
    private void inorderTraversalRecursion(TreeNode node, List<Integer> list)
    {
        if (node == null) return;
        inorderTraversalRecursion(node.left, list);
        list.add(node.val);
        inorderTraversalRecursion(node.right, list);
    }

    /**
     * 迭代
     */
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


}
