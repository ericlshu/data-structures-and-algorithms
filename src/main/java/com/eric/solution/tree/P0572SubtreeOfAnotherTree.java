package com.eric.solution.tree;

import com.eric.domain.TreeNode;

/**
 * Description : 另一棵树的子树
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 * <p>
 * 示例 1：
 * 输入：root = [3,4,5,1,2], subRoot = [4,1,2]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * 输出：false
 * <p>
 * 提示：
 * -> root 树上的节点数量范围是 [1, 2000]
 * -> subRoot 树上的节点数量范围是 [1, 1000]
 * -> -104 <= root.val <= 104
 * -> -104 <= subRoot.val <= 104
 *
 * @author Eric L SHU
 * @date 2023-01-09 20:51
 * @since jdk-11.0.14
 */
public class P0572SubtreeOfAnotherTree
{
    public boolean isSubtree(TreeNode root, TreeNode subRoot)
    {
        if (subRoot == null)
            return true;
        if (root == null)
            return false;
        return check(root, subRoot)
                || isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }

    private boolean check(TreeNode node1, TreeNode node2)
    {
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null)
            return false;
        if (node1.val != node2.val)
            return false;
        return check(node1.left, node2.left) && check(node1.right, node2.right);
    }
}
