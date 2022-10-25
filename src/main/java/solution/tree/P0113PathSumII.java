package solution.tree;

import domain.TreeNode;

import java.util.*;

/**
 * Description : 路径总和 II
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * <p>
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 * <p>
 * 提示：
 * -> 树中节点总数在范围 [0, 5000] 内
 * -> -1000 <= Node.val <= 1000
 * -> -1000 <= targetSum <= 1000
 *
 * @author Eric L SHU
 * @date 2022-10-25 13:41
 * @since jdk-11.0.14
 */
public class P0113PathSumII
{
    public List<List<Integer>> pathSum_dfs(TreeNode root, int targetSum)
    {
        List<List<Integer>> lists = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        dfs(root, targetSum, path, lists);
        return lists;
    }

    private void dfs(TreeNode root, int targetSum, Stack<Integer> path, List<List<Integer>> lists)
    {
        if (root == null)
            return;
        path.push(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0)
            lists.add(new ArrayList<>(path));
        dfs(root.left, targetSum, path, lists);
        dfs(root.right, targetSum, path, lists);
        path.pop();
    }


    public List<List<Integer>> pathSum_bfs(TreeNode root, int targetSum)
    {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null)
            return lists;
        Map<TreeNode, TreeNode> node2Parent = new HashMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        nodeQueue.offer(root);
        sumQueue.offer(0);
        while (!nodeQueue.isEmpty())
        {
            TreeNode node = nodeQueue.poll();
            int sum = sumQueue.poll() + node.val;
            if (node.left == null && node.right == null)
            {
                if (sum == targetSum)
                    this.getPath(node, node2Parent, lists);
            }
            else
            {
                if (node.left != null)
                {
                    nodeQueue.offer(node.left);
                    sumQueue.offer(sum);
                    node2Parent.put(node.left, node);
                }
                if (node.right != null)
                {
                    nodeQueue.offer(node.right);
                    sumQueue.offer(sum);
                    node2Parent.put(node.right, node);
                }
            }
        }
        return lists;
    }

    private void getPath(TreeNode node, Map<TreeNode, TreeNode> map, List<List<Integer>> lists)
    {
        List<Integer> list = new LinkedList<>();
        while (node != null)
        {
            list.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(list);
        lists.add(new ArrayList<>(list));
    }

}
