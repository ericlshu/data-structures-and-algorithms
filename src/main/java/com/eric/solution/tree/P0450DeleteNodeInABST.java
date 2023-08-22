package com.eric.solution.tree;

import com.eric.domain.TreeNode;

/**
 * Description : 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * <p>
 * 示例 1:
 * 输入：root = [5,3,6,2,4,null,7], key = 3
 * 输出：[5,4,6,2,null,null,7]
 * 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * <p>
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,7], key = 0
 * 输出: [5,3,6,2,4,null,7]
 * 解释: 二叉树不包含值为 0 的节点
 * <p>
 * 示例 3:
 * 输入: root = [], key = 0
 * 输出: []
 * <p>
 * 提示:
 * -> 节点数的范围 [0, 104].
 * -> -10^5 <= Node.val <= 10^5
 * -> 节点值唯一
 * -> root 是合法的二叉搜索树
 * -> -10^5 <= key <= 10^5
 * <p>
 * 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。
 *
 * @author Eric L SHU
 * @date 2022-10-28 11:37
 * @since jdk-11.0.14
 */
public class P0450DeleteNodeInABST
{
    public TreeNode deleteNode_recursion(TreeNode root, int key)
    {
        // root 为空，代表未搜索到值为 key 的节点，返回空。
        if (root == null)
            return null;
        // root.val>key，表示值为 key 的节点可能存在于 root 的左子树中，需要递归地在 root.left 调用 deleteNode，并返回 root
        if (root.val > key)
        {
            root.left = deleteNode_recursion(root.left, key);
            return root;
        }
        // root.val>key，表示值为 key 的节点可能存在于 root 的右子树中，需要递归地在 root.right 调用 deleteNode，并返回 root
        else if (root.val < key)
        {
            root.right = deleteNode_recursion(root.right, key);
            return root;
        }
        // root.val=key，root 即为要删除的节点。此时要做的是删除 root，并将它的子树合并成一棵子树，保持有序性，并返回根节点。
        else
        {
            // root 为叶子节点，没有子树。此时可以直接将它删除，即返回空。
            if (root.left == null && root.right == null)
            {
                return null;
            }
            // root 只有左子树，没有右子树。此时可以将它的左子树作为新的子树，返回它的左子节点。
            else if (root.right == null)
            {
                return root.left;
            }
            // root 只有右子树，没有左子树。此时可以将它的右子树作为新的子树，返回它的右子节点。
            else if (root.left == null)
            {
                return root.right;
            }
            // root 有左右子树
            else
            {
                // 将 root 的后继节点（比 root 大的最小节点，即它的右子树中的最小节点，记为 successor
                TreeNode successor = root.right;
                while (successor.left != null)
                {
                    successor = successor.left;
                }
                // 并将 successor 从 root 的右子树中删除，使得在保持有序性的情况下合并左右子树。
                root.right = deleteNode_recursion(root.right, successor.val);
                // successor 作为新的根节点替代 root
                successor.right = root.right;
                successor.left = root.left;
                return successor;
            }
        }
    }

    public TreeNode deleteNode_iteration(TreeNode root, int key)
    {
        TreeNode curr = root, currParent = null;
        while (curr != null && curr.val != key)
        {
            currParent = curr;
            if (curr.val > key)
                curr = curr.left;
            else
                curr = curr.right;
        }
        // 没有找到目标节点
        if (curr == null)
        {
            return root;
        }
        // 目标节点为叶子节点，没有子树。此时可以直接将它直接置空
        if (curr.left == null && curr.right == null)
        {
            curr = null;
        }
        // 目标节点只有左子树，没有右子树。此时可以将它的左子树的根节点替换当前节点；
        else if (curr.right == null)
        {
            curr = curr.left;
        }
        // 目标节点只有右子树，没有左子树。此时可以将它的右子树的根节点替换当前节点；
        else if (curr.left == null)
        {
            curr = curr.right;
        }
        // 目标节点有左右子树
        else
        {
            // 目标节点的右节点初始化为后继节点，目标节点初始化为后继节点的父节点
            // 后继节点为目标节点右子树中的最小节点，并记录其父节点
            TreeNode successor = curr.right, successorParent = curr;
            while (successor.left != null)
            {
                successorParent = successor;
                successor = successor.left;
            }
            // successor.left == null
            // 后继节点一定是其父节点的左节点，将后继节点从目标节点的右子树中删除
            if (successorParent.val == curr.val)
                successorParent.right = successor.right;
            else
                successorParent.left = successor.right;
            // 将目标节点的左右节赋值给后继节点的左右节点
            successor.right = curr.right;
            successor.left = curr.left;
            curr = successor;
        }
        // 目标节点是根节点
        if (currParent == null)
            return curr;
        else
        {
            // 目标节点是其父节点的左节点，将其父节点的左节点替换为后继节点，反之替换右节点；
            if (currParent.left != null && currParent.left.val == key)
                currParent.left = curr;
            else
                currParent.right = curr;
            return root;
        }
    }
}
