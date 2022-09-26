import domain.ListNode;
import org.junit.Test;
import solution.linked_list.*;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2021-03-27 14:27
 * @since JDK 1.8
 */
public class LinkedListTest
{
    @Test
    public void test0142()
    {
        P0142LinkedListCycleTwo p0142 = new P0142LinkedListCycleTwo();
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        System.out.println(p0142.detectCycle1(node1).val);
        System.out.println(p0142.detectCycle2(node1).val);
    }

    @Test
    public void testP0143()
    {
        P0143ReorderList obj = new P0143ReorderList();
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        obj.reorderList(node1);
    }

    @Test
    public void testP0206()
    {
        P0206ReverseLinkedList obj = new P0206ReverseLinkedList();
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode head = new ListNode(0, node1);

        System.out.println("ListNode = " + head);

        head = obj.reverseListByIteration(head);
        System.out.println("ListNode = " + head);

        head = obj.reverseListByRecursion(head);
        System.out.println("ListNode = " + head);

        head = obj.reverseListByStack(head);
        System.out.println("ListNode = " + head);
    }

    @Test
    public void test0203()
    {
        P0203RemoveLinkedListElements obj = new P0203RemoveLinkedListElements();

        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(6, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);

        ListNode result = obj.removeElements_recursion(head, 6);
        while (result != null)
        {
            System.out.println(result.val);
            result = result.next;
        }

        System.out.println("result = " + obj.removeElements_iteration(null, 1));
    }

    @Test
    public void test0021()
    {
        P0021MergeTwoSortedLists obj = new P0021MergeTwoSortedLists();

        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode result = obj.mergeTwoLists(l1, l2);
        while (result != null)
        {
            System.out.println(result.val);
            result = result.next;
        }
    }

    @Test
    public void test0083()
    {
        P0083RemoveDuplicatesFromSortedList obj = new P0083RemoveDuplicatesFromSortedList();

        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(3, null)))));

        ListNode result = obj.deleteDuplicates(head);
        while (result != null)
        {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
