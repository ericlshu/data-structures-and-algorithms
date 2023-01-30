package solution.collection;

import domain.ListNode;

/**
 * Description :
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
