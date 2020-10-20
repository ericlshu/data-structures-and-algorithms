package problem.java;

import domain.ListNode;

/**
 * Description : 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * <p>
 * 说明：
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 *
 * @author Eric L SHU
 * @date 2020-10-18 18:27
 * @since JDK 1.8
 */
public class P0019_RemoveNthNodeFromEndOfList
{
    public ListNode removeNthFromEnd_1(ListNode head, int n)
    {
        if (head == null) return null;
        int count = getLength(head);
        if (count == 1 && n == 1) return null;
        if (count > 1 && n == count) return head.next;
        ListNode node = head;
        for (int i = 1; i < count - n; i++)
        {
            node = node.next;
        }
        node.next = node.next.next;
        return head;
    }

    public ListNode removeNthFromEnd_2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode node = dummy;
        for (int i = 0; i < length - n; i++) {
            node = node.next;
        }
        node.next = node.next.next;
        return dummy.next;
    }

    public int getLength(ListNode head)
    {
        int length = 0;
        while (head != null)
        {
            length++;
            head = head.next;
        }
        return length;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        // 第一个指针从head开始移动n次
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        // 两个指针同时移动，直至第一个指针指向null
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        // 重置第二个指针的下一个元素
        second.next = second.next.next;
        return dummy.next;
    }
}
