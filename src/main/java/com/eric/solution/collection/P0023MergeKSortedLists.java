package com.eric.solution.collection;

import com.eric.domain.ListNode;

/**
 * Description : 合并 K 个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * <p>
 * 示例 2：
 * 输入：lists = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * 提示：
 * -> k == lists.length
 * -> 0 <= k <= 10^4
 * -> 0 <= lists[i].length <= 500
 * -> -10^4 <= lists[i][j] <= 10^4
 * -> lists[i] 按 升序 排列
 * -> lists[i].length 的总和不超过 10^4
 *
 * @author Eric L SHU
 * @date 2023-08-28 22:11
 * @since jdk-11.0.14
 */
public class P0023MergeKSortedLists
{
    public ListNode mergeKLists(ListNode[] lists)
    {
        if (lists.length == 0)
            return null;
        return split(lists, 0, lists.length - 1);

    }

    private ListNode split(ListNode[] lists, int i, int j)
    {
        if (i == j)
            return lists[i];
        int mid = (i + j) >>> 1;
        ListNode left = split(lists, i, mid);
        ListNode right = split(lists, mid + 1, j);
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode sentinel = new ListNode();
        ListNode node = sentinel;
        while (l1 != null && l2 != null)
        {
            if (l1.val < l2.val)
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
        node.next = l1 == null ? l2 : l1;
        return sentinel.next;
    }
}
