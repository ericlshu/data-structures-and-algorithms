package solution.linked_list;

import domain.ListNode;

/**
 * Description : 反转链表
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * NULL 1 2 3 4 5
 * <p>
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @author Eric L SHU
 * @date 2020-10-20 22:10
 * @since JDK 1.8
 */
public class P0206ReverseLinkedList
{
    /**
     * 迭代
     */
    public ListNode reverseListByIteration(ListNode head)
    {
        // 记录上一个节点，头结点反转后变为尾结点，因此上一个节点默认为null
        ListNode prev = null;
        ListNode next;
        ListNode curr = head;
        while (curr != null)
        {
            next = curr.next;
            // 当前节点的下一个节点指向上一个节点，实现反转
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 递归
     */
    public ListNode reverseListByRecursion(ListNode node)
    {
        // 递归终止条件，找到尾结点
        if (node == null || node.next == null)
            return node;
        // 找到的尾结点变为新的头结点，接收并返回即可
        ListNode head = reverseListByRecursion(node.next);
        // 当前节点下一个节点的下一个节点指向当前节点，实现当前节点和下一个节点的反转
        node.next.next = node;
        node.next = null;
        return head;
    }
}
