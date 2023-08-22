package com.eric.solution.collection;

import com.eric.domain.ListNode;

/**
 * Description : 合并两个链表
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 * 请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。
 * 下图中蓝色边和节点展示了操作后的结果：
 * 请你返回结果链表的头指针。
 * <p>
 * 示例 1：
 * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * 输出：[0,1,2,1000000,1000001,1000002,5]
 * 解释：我们删除 list1 中下标为 3 和 4 的两个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
 * <p>
 * 提示：
 * -> 3 <= list1.length <= 104
 * -> 1 <= a <= b < list1.length - 1
 * -> 1 <= list2.length <= 104
 *
 * @author Eric L SHU
 * @date 2023-01-30 19:51
 * @since jdk-11.0.14
 */
public class P1669MergeInBetweenLinkedLists
{
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2)
    {
        ListNode node1 = list1;
        for (int i = 1; i < a; i++)
        {
            node1 = node1.next;
        }
        ListNode node2 = node1;
        for (int i = 0; i <= b - a + 1; i++)
        {
            node2 = node2.next;
        }
        node1.next = list2;
        while (list2.next != null)
        {
            list2 = list2.next;
        }
        list2.next = node2;
        return list1;
    }
}
