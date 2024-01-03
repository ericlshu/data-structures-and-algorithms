package com.eric.solution.collection;

import com.eric.domain.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 从链表中移除节点
 * 给你一个链表的头节点 head 。
 * 移除每个右侧有一个更大数值的节点。
 * 返回修改后链表的头节点 head 。
 * <p>
 * 示例 1：
 * 输入：head = [5,2,13,3,8]
 * 输出：[13,8]
 * 解释：需要移除的节点是 5 ，2 和 3 。
 * - 节点 13 在节点 5 右侧。
 * - 节点 13 在节点 2 右侧。
 * - 节点 8 在节点 3 右侧。
 * <p>
 * 示例 2：
 * 输入：head = [1,1,1,1]
 * 输出：[1,1,1,1]
 * 解释：每个节点的值都是 1 ，所以没有需要移除的节点。
 * <p>
 * 提示：
 * -> 给定列表中的节点数目在范围 [1, 105] 内
 * -> 1 <= Node.val <= 105
 */
public class P2487RemoveNodesFromLinkedList
{
    public static ListNode removeNodesRecursion(ListNode head)
    {
        if (head == null)
            return null;
        head.next = removeNodesRecursion(head.next);
        if (head.next != null && head.val < head.next.val)
            return head.next;
        else
            return head;
    }

    public static ListNode removeNodesStack(ListNode head)
    {
        Deque<ListNode> stack = new ArrayDeque<>();
        while (head != null)
        {
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty())
        {
            // 如果节点的值大于等于新链表的表头节点值
            if (head == null || stack.peek().val >= head.val)
            {
                // 将该节点插入新链表的表头
                stack.peek().next = head;
                // 更新新链表头结点未当前节点
                head = stack.peek();
            }
            stack.pop();
        }
        return head;
    }

    public static ListNode removeNodesReverse(ListNode head)
    {
        // System.out.println(reverse(head));
        ListNode node = head = reverse(head);
        while (node.next != null)
        {
            if (node.val > node.next.val)
                node.next = node.next.next;
            else
                node = node.next;
        }
        return reverse(head);
    }

    public static ListNode reverse(ListNode head)
    {
        if (head.next == null)
            return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
