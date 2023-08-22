package com.eric.solution.collection;

import com.eric.domain.ListNode;

/**
 * Description : K 个一组翻转链表
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * <p>
 * 示例 2：
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * <p>
 * 提示：
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 * <p>
 * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 *
 * @author Eric L SHU
 * @date 2022-10-23 4:21 PM
 * @since jdk-11.0.14
 */
public class P0025ReverseNodesInKGroup
{
    public ListNode reverseKGroup_1(ListNode head, int k)
    {
        ListNode dummyHead = new ListNode(0, head);
        ListNode prev = dummyHead;
        while (head != null)
        {
            ListNode tail = prev;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 1; i <= k; ++i)
            {
                tail = tail.next;
                if (tail == null)
                    return dummyHead.next;
            }
            ListNode next = tail.next;
            // // ListNode[] reverse = reverse_1(head, tail);
            // // head = reverse[0];
            // // tail = reverse[1];
            // ListNode subHead = reverse(head, tail);
            // tail = head;
            // // 把子链表重新接回原链表
            // prev.next = subHead;
            // tail.next = next;
            // prev = tail;
            // head = tail.next;
            prev.next = reverse(head, tail);
            head.next = next;
            prev = head;
            head = next;
        }
        return dummyHead.next;
    }

    private ListNode[] reverse_1(ListNode head, ListNode tail)
    {
        ListNode prev = tail.next;
        ListNode curr = head;
        while (prev != tail)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new ListNode[]{tail, head};
    }

    private ListNode reverse(ListNode head, ListNode tail)
    {
        ListNode prev = null;
        ListNode curr = head;
        while (prev != tail)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseKGroup_2(ListNode head, int k)
    {
        ListNode dummyHead = new ListNode(-1, head), prev = dummyHead;
        while (true)
        {
            // 检查剩余节点是否有k个，不足则返回
            ListNode last = prev;
            for (int i = 0; i < k; i++)
            {
                last = last.next;
                if (last == null)
                    return dummyHead.next;
            }

            // 翻转k个节点
            ListNode curr = prev.next, next;
            for (int i = 0; i < k - 1; i++)
            {
                next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = curr;
        }
    }
}
