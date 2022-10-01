package solution.collection;

import domain.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description : 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * @author Eric L SHU
 * @date 2022-09-14 20:46
 * @since jdk-11.0.14
 */
public class P0019RemoveNthNodeFromEndOfList
{
    /**
     * 暴力解法
     */
    public ListNode removeNthFromEnd_1(ListNode head, int n)
    {
        if (head == null) return null;
        int count = 1;
        ListNode copy = head;
        while (copy.next != null)
        {
            count++;
            copy = copy.next;
        }
        if (n > count || (count == 1 && n == 1)) return null;
        if (count > 1 && n == count) return head.next;
        ListNode node = head;
        for (int i = 1; i < count - n; i++)
        {
            node = node.next;
        }
        node.next = node.next.next;
        return head;
    }

    /**
     * 两次遍历
     */
    public ListNode removeNthFromEnd_2(ListNode head, int n)
    {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode node = dummy;
        for (int i = 0; i < length - n; i++)
        {
            node = node.next;
        }
        node.next = node.next.next;
        return dummy.next;
    }

    /**
     * 快慢指针
     */
    private int getLength(ListNode head)
    {
        int length = 0;
        while (head != null)
        {
            length++;
            head = head.next;
        }
        return length;
    }

    /**
     * 快慢指针
     */
    public ListNode removeNthFromEnd_pointers(ListNode head, int n)
    {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        // 移动第一个指针从head开始移动n次
        for (int i = 0; i < n; ++i)
        {
            first = first.next;
        }
        // 两个指针同时移动，直至第一个指针指向null
        while (first != null)
        {
            first = first.next;
            second = second.next;
        }
        // 重置第二个指针的下一个元素
        second.next = second.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd_stack(ListNode head, int n)
    {
        ListNode dummyHead = new ListNode(0, head);
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode node = dummyHead;
        while (node != null)
        {
            stack.push(node);
            node = node.next;
        }
        while (n-- > 0)
        {
            stack.pop();
        }
        node = stack.peek();
        node.next = node.next.next;
        return dummyHead.next;
    }
}
