package com.eric.solution.collection;

import com.eric.domain.ListNode;

import java.util.Stack;

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
     * 方法一：迭代
     * -> 在遍历链表时，将当前节点的 next 指针改为指向前一个节点。
     * -> 由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。
     * -> 在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
     * 复杂度分析
     * -> 时间复杂度：O(n)，其中 n 是链表的长度。需要遍历链表一次。
     * -> 空间复杂度：O(1)。
     */
    public ListNode reverseListByIteration(ListNode head)
    {
        // 记录上一个节点，头结点反转后变为尾结点，因此上一个节点默认为null
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null)
        {
            ListNode next = curr.next;
            // 当前节点的下一个节点指向上一个节点，实现反转
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 方法二：递归
     * 时间复杂度：O(n)，其中 n 是链表的长度。需要对链表的每个节点进行反转操作。
     * 空间复杂度：O(n)，其中 n 是链表的长度。空间复杂度主要取决于递归调用的栈空间，最多为 n 层。
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

    public ListNode reverseListByStack(ListNode head)
    {
        Stack<ListNode> stack = new Stack<>();
        while (head != null)
        {
            stack.push(head);
            head = head.next;
        }
        ListNode dummyHead = new ListNode(-1, null);
        ListNode node = dummyHead;
        while (!stack.isEmpty())
        {
            node.next = stack.pop();
            node = node.next;
        }
        node.next = null;
        return dummyHead.next;
    }
}
