package solution.collection;

import domain.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description : 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 示例1：
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * <p>
 * 示例2：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 * <p>
 * 示例3：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * 提示：
 * -> 链表的长度范围为 [1, 100]
 * -> 0 <= node.val <= 9
 * -> 输入数据保证链表代表的数字无前导 0
 * <p>
 * 进阶：如果输入链表不能翻转该如何解决？
 *
 * @author Eric L SHU
 * @date 2023-01-14 12:04
 * @since jdk-11.0.14
 */
public class P0445AddTwoNumbersII
{
    public ListNode addTwoNumbers_1(ListNode l1, ListNode l2)
    {
        return reverse(add(reverse(l1), reverse(l2), 0));
    }

    private ListNode reverse(ListNode node)
    {
        if (node == null || node.next == null)
            return node;
        ListNode head = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return head;
    }

    private ListNode add(ListNode l1, ListNode l2, int carry)
    {
        if (l1 == null && l2 == null && carry == 0)
            return null;
        if (l1 != null)
        {
            carry += l1.val;
            l1 = l1.next;
        }
        if (l2 != null)
        {
            carry += l2.val;
            l2 = l2.next;
        }
        ListNode node = new ListNode(carry % 10);
        node.next = add(l1, l2, carry / 10);
        return node;
    }

    public ListNode addTwoNumbers_2(ListNode l1, ListNode l2)
    {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l1 != null)
        {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null)
        {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode res = null, node;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0)
        {
            carry += stack1.isEmpty() ? 0 : stack1.pop();
            carry += stack2.isEmpty() ? 0 : stack2.pop();
            node = new ListNode(carry % 10);
            carry /= 10;
            node.next = res;
            res = node;
        }
        return res;
    }
}
