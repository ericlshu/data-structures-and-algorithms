package solution;

import domain.ListNode;

/**
 * Description :
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * @author Eric L SHU
 * @date 2020-10-13 21:41
 * @since JDK 1.8
 */
public class P0024_SwapNodesInPairs
{
    public ListNode swapPairs(ListNode head)
    {
        //链表中没有节点或者链表中只有一个节点，无法交换递归终止
        if (head == null || head.next == null)
        {
            return head;
        }
        // 将原始链表的第二个节点赋值为新链表的头节点
        ListNode newHead = head.next;
        // 将其余节点进行两两交换，交换后的新的头节点为 head 的下一个节点
        head.next = swapPairs(newHead.next);
        // 将原始头结点赋值为新头结点的下一个结点
        newHead.next = head;
        return newHead;
    }
}
