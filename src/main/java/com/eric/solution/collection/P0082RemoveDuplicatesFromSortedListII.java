package com.eric.solution.collection;

import com.eric.domain.ListNode;

/**
 * Description : 删除排序链表中的重复元素 II
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * <p>
 * 示例 2：
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * <p>
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 *
 * @author Eric L SHU
 * @date 2022-10-21 20:22
 * @since jdk-11.0.14
 */
public class P0082RemoveDuplicatesFromSortedListII
{
    public ListNode deleteDuplicates_1(ListNode head)
    {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null)
        {
            if (curr.next.val == curr.next.next.val)
            {
                int x = curr.next.val;
                while (curr.next != null && curr.next.val == x)
                {
                    curr.next = curr.next.next;
                }
            }
            else
            {
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates_2(ListNode head)
    {
        ListNode dummyHead = new ListNode(0, head);
        ListNode prev = dummyHead;
        ListNode curr = head;
        while (curr != null && curr.next != null)
        {
            if (curr.val == curr.next.val)
            {
                int val = curr.val;
                curr = curr.next.next;
                while (curr != null && curr.val == val)
                {
                    curr = curr.next;
                }
                prev.next = curr;
            }
            else
            {
                prev = curr;
                curr = curr.next;
            }
        }
        return dummyHead.next;
    }

    public ListNode deleteDuplicates_3(ListNode head)
    {
        ListNode dummyHead = new ListNode(0, head);
        ListNode prev = dummyHead, curr = head;
        while (curr != null)
        {
            ListNode next = curr.next;
            while (next != null && curr.val == next.val)
            {
                next = next.next;
            }
            if (next != curr.next)
            {
                // next 移动过，说明中间存在重复元素，将 prev 的 next 指针指向
                // 当前的 next，这样就跳过了重复元素
                prev.next = next;
            }
            else
            {
                // next 没有移动过，prev 和 curr 向后移动一位
                prev = curr;
            }
            curr = next;
        }
        return dummyHead.next;
    }
}
