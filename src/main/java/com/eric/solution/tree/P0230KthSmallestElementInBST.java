package com.eric.solution.tree;

import com.eric.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Description : 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * <p>
 * 示例 1：
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 * <p>
 * 提示：
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 * <p>
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 *
 * @author Eric L SHU
 * @date 2022-10-28 10:50
 * @since jdk-11.0.14
 */
public class P0230KthSmallestElementInBST
{
    public int kthSmallest_1(TreeNode root, int k)
    {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty())
        {
            while (node != null)
            {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (--k == 0)
                break;
            node = node.right;
        }
        assert node != null;
        return node.val;
    }


    public int kthSmallest_2(TreeNode root, int k)
    {
        MyBst bst = new MyBst(root);
        return bst.kthSmallest(k);
    }

    static class MyBst
    {
        TreeNode root;
        Map<TreeNode, Integer> nodeNum;

        public MyBst(TreeNode root)
        {
            this.root = root;
            this.nodeNum = new HashMap<>();
            countNodeNum(root);
        }

        // 返回二叉搜索树中第k小的元素
        public int kthSmallest(int k)
        {
            TreeNode node = root;
            while (node != null)
            {
                int left = getNodeNum(node.left);
                if (left < k - 1)
                {
                    node = node.right;
                    k -= left + 1;
                }
                else if (left == k - 1)
                    break;
                else
                    node = node.left;
            }
            return node.val;
        }

        // 统计以node为根结点的子树的结点数
        private int countNodeNum(TreeNode node)
        {
            if (node == null)
                return 0;
            nodeNum.put(node, 1 + countNodeNum(node.left) + countNodeNum(node.right));
            return nodeNum.get(node);
        }

        // 获取以node为根结点的子树的结点数
        private int getNodeNum(TreeNode node)
        {
            return nodeNum.getOrDefault(node, 0);
        }
    }
}
