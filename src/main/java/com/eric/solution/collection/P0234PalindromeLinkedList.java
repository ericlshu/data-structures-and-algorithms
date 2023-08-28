package com.eric.solution.collection;

import com.eric.domain.ListNode;

/**
 * Description : 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：false
 * <p>
 * 提示：
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 * <p>
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * @author Eric L SHU
 * @date 2023-08-28 22:50
 * @since jdk-11.0.14
 */
public class P0234PalindromeLinkedList
{
    public boolean isPalindrome_1(ListNode head)
    {
        ListNode middle = middle(head);
        // System.out.println("middle = " + middle);
        ListNode newHead = reverse(middle);
        // System.out.println("newHead = " + newHead);
        while (newHead != null)
        {
            if (newHead.val != head.val)
            {
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }
        return true;
    }

    private ListNode middle(ListNode head)
    {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head)
    {
        ListNode prev = null, curr = head;
        while (curr != null)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public boolean isPalindrome_2(ListNode head)
    {
        ListNode fast = head, slow = head;
        ListNode prev = null, curr = head;
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            // ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = slow;
        }
        if (fast != null)
        {
            slow = slow.next;
        }
        // System.out.println("prev = " + prev);
        // System.out.println("slow = " + slow);
        while (prev != null)
        {
            if (prev.val != slow.val)
            {
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }
}
