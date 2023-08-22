package com.eric.solution.collection;

import com.eric.domain.ListNode;

/**
 * Description : 合并两个有序链表
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author Eric L SHU
 * @date 2020-10-26 21:23
 * @since JDK 1.8
 */
public class P0021MergeTwoSortedLists
{
    public ListNode mergeTwoLists_iteration(ListNode l1, ListNode l2)
    {
        ListNode dummyHead = new ListNode(-1);
        ListNode node = dummyHead;
        while (l1 != null && l2 != null)
        {
            if (l1.val <= l2.val)
            {
                node.next = l1;
                l1 = l1.next;
            }
            else
            {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        node.next = l1 == null ? l2 : l1;
        return dummyHead.next;
    }

    /**
     * 两个链表头部值较小的一个节点与剩下元素的 merge 操作结果合并。
     * 如果 list1 或者 list2 一开始就是空链表 ，那么没有任何操作需要合并，所以我们只需要返回非空链表。
     * 否则，我们要判断 list1 和 list2 哪一个链表的头节点的值更小，然后递归地决定下一个添加到结果里的节点。
     * 如果两个链表有一个为空，递归结束。
     * <p>
     * 终止条件：当两个链表都为空时，表示我们对链表已合并完成。
     * 如何递归：我们判断 list1 和 list2 头结点哪个更小，然后较小结点的 next 指针指向其余结点的合并结果。（调用递归）
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {
        if (list1 == null)
        {
            return list2;
        }
        else if (list2 == null)
        {
            return list1;
        }
        else if (list1.val < list2.val)
        {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        else
        {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
