package solution.collection;

import domain.ListNode;

/**
 * Description : 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * <p>
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * <p>
 * 提示：
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 *
 * @author Eric L SHU
 * @date 2022-09-11 14:15
 * @since jdk-11.0.14
 */
public class P0203RemoveLinkedListElements
{
    public ListNode removeElements_iteration(ListNode head, int val)
    {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode node = dummyHead;
        while (node.next != null)
        {
            if (node.next.val == val)
                node.next = node.next.next;
            else
                node = node.next;
        }
        return dummyHead.next;
    }

    public ListNode removeElements_recursion(ListNode head, int val)
    {
        if (head == null) return null;
        head.next = removeElements_recursion(head.next, val);
        return head.val == val ? head.next : head;
    }
}
