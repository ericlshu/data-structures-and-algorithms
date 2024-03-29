package com.eric.solution.collection;

import com.eric.domain.ListNode;

/**
 * Description : 删除排序链表中的重复元素
 * <p>
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 返回同样按升序排列的结果链表。
 * <p>
 * 示例 1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * <p>
 * 示例 2：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * <p>
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 *
 * @author Eric L SHU
 * @date 2022-01-20 22:17
 * @since JDK 1.8
 */
public class P0083RemoveDuplicatesFromSortedList
{
    public ListNode deleteDuplicates_1(ListNode head)
    {
        if (head == null) return null;
        ListNode curr = head;
        while (curr.next != null)
        {
            if (curr.val == curr.next.val)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }
        return head;
    }

    public ListNode deleteDuplicates(ListNode node)
    {
        if (node == null || node.next == null)
            return node;
        if (node.val == node.next.val)
        {
            return deleteDuplicates(node.next);
        }
        else
        {
            node.next = deleteDuplicates(node.next);
            return node;
        }
    }
}
