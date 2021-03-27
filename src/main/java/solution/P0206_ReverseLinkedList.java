package solution;

import domain.ListNode;

/**
 * Description : 反转链表
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * NULL 1 2 3 4 5
 * <p>
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @author Eric L SHU
 * @date 2020-10-20 22:10
 * @since JDK 1.8
 */
public class P0206_ReverseLinkedList
{
    public ListNode reverseList_1(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null)
        {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public ListNode reverseList(ListNode head)
    {
        if (head == null || head.next == null)
            return head;
        ListNode ret = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return ret;
    }
}
