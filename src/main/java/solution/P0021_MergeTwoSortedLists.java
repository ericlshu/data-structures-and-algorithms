package solution;

import domain.ListNode;

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
public class P0021_MergeTwoSortedLists
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
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
        node.next = l1 == null ? l2 : l1;
        return dummyHead.next;
    }
}
