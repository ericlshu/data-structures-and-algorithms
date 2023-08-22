package com.eric.solution.collection;

import com.eric.domain.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description : 重排链表
 * <p>
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * <p>
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * @author Eric L SHU
 * @date 2020-10-20 21:24
 * @since JDK 1.8
 */
public class P0143ReorderList
{
    public void reorderList_1(ListNode head)
    {
        if (head == null) return;
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null)
        {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j)
        {
            list.get(i++).next = list.get(j);
            if (i == j) break;
            list.get(j--).next = list.get(i);
        }
        list.get(i).next = null;
    }

    public void reorderList_2(ListNode head)
    {
        if (head == null) return;
        ListNode mid = middleNode(head);
        ListNode midNext = mid.next;
        mid.next = null;
        mergeList(head, reverseList(midNext));
    }

    private ListNode middleNode(ListNode head)
    {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head)
    {
        if (head == null || head.next == null)
            return head;
        ListNode ret = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return ret;
    }

    private void mergeList(ListNode l1, ListNode l2)
    {
        ListNode node1;
        ListNode node2;
        while (l1 != null && l2 != null)
        {
            node1 = l1.next;
            node2 = l2.next;
            l1.next = l2;
            l1 = node1;
            l2.next = l1;
            l2 = node2;
        }
    }
}
