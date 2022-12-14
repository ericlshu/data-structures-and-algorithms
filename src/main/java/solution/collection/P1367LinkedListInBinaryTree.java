package solution.collection;

import domain.ListNode;
import domain.TreeNode;

/**
 * Description : 二叉树中的链表
 * 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
 * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。
 * 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。
 * <p>
 * 示例 1：
 * 输入：head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * 输出：true
 * 解释：树中蓝色的节点构成了与链表对应的子路径。
 * <p>
 * 示例 2：
 * 输入：head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * 输出：false
 * 解释：二叉树中不存在一一对应链表的路径。
 * <p>
 * 提示：
 * 二叉树和链表中的每个节点的值都满足 1 <= node.val <= 100 。
 * 链表包含的节点数目在 1 到 100 之间。
 * 二叉树包含的节点数目在 1 到 2500 之间。
 *
 * @author Eric L SHU
 * @date 2022-12-06 21:14
 * @since jdk-11.0.14
 */
public class P1367LinkedListInBinaryTree
{
    public boolean isSubPath(ListNode head, TreeNode root)
    {
        // 二叉树访问到了空节点，匹配失败
        if (root == null)
            return false;
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode node)
    {
        // 链表已经全部匹配完，匹配成功
        if (head == null)
            return true;
        // 二叉树访问到了空节点，匹配失败
        if (node == null)
            return false;
        // 当前匹配的二叉树上节点的值与链表节点的值不相等，匹配失败
        if (node.val != head.val)
            return false;
        // 二叉树与链表节点的值相等，递归比较下个节点
        return dfs(head.next, node.left) || dfs(head.next, node.right);
    }
}
