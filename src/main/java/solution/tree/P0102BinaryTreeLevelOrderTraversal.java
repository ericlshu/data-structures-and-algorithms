package solution.tree;

import domain.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description :  二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
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
 * -1000 <= Node.val <= 1000
 *
 * @author Eric L SHU
 * @date 2022-09-29 20:58
 * @since jdk-11.0.14
 */
public class P0102BinaryTreeLevelOrderTraversal
{
    public List<List<Integer>> levelOrderRecursion(TreeNode root)
    {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null)
            return ret;
        dfs(0, root, ret);
        return ret;
    }

    private void dfs(int level, TreeNode node, List<List<Integer>> ret)
    {
        if (ret.size() <= level)
            ret.add(new ArrayList<>());
        ret.get(level).add(node.val);
        if (node.left != null)
            dfs(level + 1, node.left, ret);
        if (node.right != null)
            dfs(level + 1, node.right, ret);
    }

    public List<List<Integer>> levelOrderIteration(TreeNode root)
    {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> row;
        TreeNode node;
        while (queue.size() > 0)
        {
            row = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                node = queue.remove();
                row.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            list.add(row);
        }
        return list;
    }
}
