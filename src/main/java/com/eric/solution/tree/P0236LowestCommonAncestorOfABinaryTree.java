package com.eric.solution.tree;

import com.eric.domain.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description : 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * <p>
 * 示例 2：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * 示例 3：
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 * <p>
 * 提示：
 * -> 树中节点数目在范围 [2, 105] 内。
 * -> -109 <= Node.val <= 109
 * -> 所有 Node.val 互不相同 。
 * -> p != q
 * -> p 和 q 均存在于给定的二叉树中。
 *
 * @author Eric L SHU
 * @date 2022-10-30 19:54
 * @since jdk-11.0.14
 */
public class P0236LowestCommonAncestorOfABinaryTree
{
    public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q)
    {
        dfs_1(root, p, q);
        return this.ans;
    }

    private TreeNode ans;

    private boolean dfs_1(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root == null) return false;
        boolean lSon = dfs_1(root.left, p, q);
        boolean rSon = dfs_1(root.right, p, q);
        if ((lSon && rSon) || ((root.val == p.val || root.val == q.val) && (lSon || rSon)))
            ans = root;
        return lSon || rSon || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q)
    {
        return dfs(root, p, q);
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root == null || root.val == p.val || root.val == q.val)
            return root;
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        // 如果left为空，right不为空，就返回right，说明目标节点是通过right返回的，反之依然。
        // 如果left 和 right都不为空，说明此时root就是最近公共节点
        if (left != null && right != null)
            return root;
        else if (left == null)
            return right;
        else
            return left;
    }

    public TreeNode lowestCommonAncestor_3(TreeNode root, TreeNode p, TreeNode q)
    {
        Map<Integer, TreeNode> parent = new HashMap<>();
        dfs(root, parent);
        Set<Integer> visited = new HashSet<>();
        while (p != null)
        {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null)
        {
            if (visited.contains(q.val))
                return q;
            q = parent.get(q.val);
        }
        return null;
    }

    public void dfs(TreeNode root, Map<Integer, TreeNode> parent)
    {
        if (root.left != null)
        {
            parent.put(root.left.val, root);
            dfs(root.left, parent);
        }
        if (root.right != null)
        {
            parent.put(root.right.val, root);
            dfs(root.right, parent);
        }
    }
}
