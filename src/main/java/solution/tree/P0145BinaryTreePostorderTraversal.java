package solution.tree;

import domain.Node;
import domain.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2022-01-25 15:22
 * @since JDK 1.8
 */
public class P0145BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        postorderTraversalRecursion(root, list);
        return list;
    }

    private void postorderTraversalRecursion(TreeNode node, List<Integer> list)
    {
        if (node == null) return;
        postorderTraversalRecursion(node.left, list);
        postorderTraversalRecursion(node.right, list);
        list.add(node.val);
    }


    public List<Integer> postorderTraversalIteration(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> stack = new LinkedList<>();
        // previous node been added to list
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null)
        {
            while (root != null)
            {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev)
            {
                list.add(root.val);
                prev = root;
                root = null;
            }
            else
            {
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }
}
