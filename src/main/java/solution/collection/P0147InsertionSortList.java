package solution.collection;

import domain.ListNode;

/**
 * Description : 对链表进行插入排序
 * 给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。
 * 插入排序 算法的步骤:
 * -> 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * -> 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * -> 重复直到所有输入数据插入完为止。
 * <p>
 * 示例 1：
 * 输入: head = [4,2,1,3]
 * 输出: [1,2,3,4]
 * <p>
 * 示例 2：
 * 输入: head = [-1,5,3,4,0]
 * 输出: [-1,0,3,4,5]
 * <p>
 * 提示：
 * -> 列表中的节点数在 [1, 5000]范围内
 * -> -5000 <= Node.val <= 5000
 *
 * @author Eric L SHU
 * @date 2023-01-26 12:03
 * @since jdk-11.0.14
 */
public class P0147InsertionSortList
{
    public ListNode insertionSortList(ListNode head)
    {
        if (head == null)
            return null;
        ListNode dummyHead = new ListNode(0, head);
        // 维护lastSorted为链表已经排好序的最后一个节点并初始化
        ListNode last = head, curr = head.next, prev;
        while (curr != null)
        {
            if (last.val <= curr.val)
            {
                last = last.next;
            }
            else
            {
                prev = dummyHead;
                while (prev.next.val <= curr.val)
                {
                    prev = prev.next;
                }
                last.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = last.next;
        }

        return head;
    }
}
