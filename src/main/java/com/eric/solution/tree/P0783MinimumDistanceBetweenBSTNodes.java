package com.eric.solution.tree;

import com.eric.domain.TreeNode;

/**
 * Description : 二叉搜索树节点最小距离
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * <p>
 * 示例 1：
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 * <p>
 * 提示：
 * 树中节点的数目范围是 [2, 100]
 * 0 <= Node.val <= 10^5
 *
 * @author Eric L SHU
 * @date 2022-12-14 20:03
 * @since jdk-11.0.14
 */
public class P0783MinimumDistanceBetweenBSTNodes
{
    int preVal, minDiff;

    public int minDiffInBST(TreeNode root)
    {
        preVal = -1;
        minDiff = 100_001;
        dfs(root);
        return minDiff;
    }

    private void dfs(TreeNode root)
    {
        if (root == null)
            return;
        dfs(root.left);
        if (preVal != -1)
        {
            minDiff = Math.min(root.val - preVal, minDiff);
        }
        preVal = root.val;
        dfs(root.right);
    }
}
