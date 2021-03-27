import domain.ListNode;
import org.junit.Test;
import solution.linked_list.P0143_ReorderList;

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
    public void testP0143()
    {
        P0143_ReorderList obj = new P0143_ReorderList();
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        obj.reorderList(node1);
    }
}
