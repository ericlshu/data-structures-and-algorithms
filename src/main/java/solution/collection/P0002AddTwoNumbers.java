package solution.collection;

import domain.ListNode;

/**
 * Description : 两数相加
 * <p>
 * 给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author Eric L SHU
 * @date 2020-10-14 20:17
 * @since JDK 1.8
 */
public class P0002AddTwoNumbers
{
    public ListNode addTwoNumbers_1(ListNode l1, ListNode l2)
    {
        ListNode head = null;
        ListNode tail = null;
        int quotient = 0;
        while (l1 != null || l2 != null)
        {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + quotient;
            quotient = sum / 10;
            ListNode node = new ListNode(sum % 10);
            if (head == null)
            {
                head = tail = node;
            }
            else
            {
                tail.next = node;
                tail = tail.next;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (quotient > 0)
        {
            tail.next = new ListNode(quotient);
        }
        return head;
    }

    public ListNode addTwoNumbers_2(ListNode l1, ListNode l2)
    {
        int carry = 0;
        ListNode curr = l1, prev = null;
        while (curr != null && l2 != null)
        {
            int sum = curr.val + l2.val + carry;
            curr.val = sum % 10;
            carry = sum / 10;
            prev = curr;
            curr = curr.next;
            l2 = l2.next;
        }

        if (curr == null)
        {
            assert prev != null;
            prev.next = curr = l2;
        }

        while (carry == 1 && curr != null)
        {
            int sum = curr.val + carry;
            curr.val = sum % 10;
            carry = sum / 10;
            prev = curr;
            curr = curr.next;
        }
        if (carry == 1)
            prev.next = new ListNode(1);
        return l1;
    }
}
