package solution.collection;

import domain.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description : 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * <p>
 * 示例 2：
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 * <p>
 * 提示：
 * -> 链表中节点的数目在范围 [0, 500] 内
 * -> -100 <= Node.val <= 100
 * -> 0 <= k <= 2 * 109
 *
 * @author Eric L SHU
 * @date 2023-01-16 22:17
 * @since jdk-11.0.14
 */
public class P0061RotateList
{
    public ListNode rotateRight_1(ListNode head, int k)
    {
        if (k == 0 || head == null || head.next == null)
            return head;
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null)
        {
            list.add(node);
            node = node.next;
        }
        int n = list.size();
        k %= n;
        if (k == 0)
            return head;
        node = head = list.get(n - k);
        for (int i = 1; i < n; i++)
        {
            node.next = list.get((n - k + i) % n);
            node = node.next;
        }
        node.next = null;
        return head;
    }

    public ListNode rotateRight_2(ListNode head, int k)
    {
        if (k == 0 || head == null || head.next == null)
            return head;
        int n = 1;
        ListNode node = head;
        while (node.next != null)
        {
            n++;
            node = node.next;
        }
        k = n - k % n;
        if (k == n)
            return head;
        node.next = head;
        while (k-- > 0)
        {
            node = node.next;
        }
        head = node.next;
        node.next = null;
        return head;
    }
}
