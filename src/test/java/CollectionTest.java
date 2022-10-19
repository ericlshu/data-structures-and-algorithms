import domain.ListNode;
import org.junit.Test;
import solution.collection.*;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2021-03-27 14:27
 * @since JDK 1.8
 */
public class CollectionTest
{
    @Test
    public void testP0381()
    {
        P0381InsertDeleteAndGetRandom.RandomizedCollection randomizedCollection = new P0381InsertDeleteAndGetRandom.RandomizedCollection();
        System.out.println("result = " + randomizedCollection.insert(21));
    }

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

    @Test
    public void test0160()
    {
        P0160IntersectionOfTwoLinkedLists p0160 = new P0160IntersectionOfTwoLinkedLists();
        ListNode listA = new ListNode(4);
        ListNode node1 = new ListNode(1);
        listA.next = node1;

        ListNode listB = new ListNode(5);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(1);
        listB.next = node2;
        node2.next = node3;

        ListNode intersect = new ListNode(8, new ListNode(4, new ListNode(5, null)));
        node1.next = intersect;
        node3.next = intersect;

        System.out.println(p0160.getIntersectionNode_hash(listA, listB));
        System.out.println(p0160.getIntersectionNode_pointers(listA, listB));
    }

    @Test
    public void test0706()
    {
        P0706DesignHashMap.MyHashMapArray myHashMapArray = new P0706DesignHashMap.MyHashMapArray();
        myHashMapArray.put(1, 1);                       // myHashMap 现在为 [[1,1]]
        myHashMapArray.put(2, 2);                       // myHashMap 现在为 [[1,1], [2,2]]
        System.out.println(myHashMapArray.get(1));      // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
        System.out.println(myHashMapArray.get(3));      // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
        myHashMapArray.put(2, 1);                       // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
        System.out.println(myHashMapArray.get(2));      // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
        myHashMapArray.remove(2);                   // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
        System.out.println(myHashMapArray.get(2));      // 返回 -1（未找到），myHashMap 现在为 [[1,1]]

        P0706DesignHashMap.MyHashMapNode myHashMapNode = new P0706DesignHashMap.MyHashMapNode();
        myHashMapNode.put(1, 1);                        // myHashMap 现在为 [[1,1]]
        myHashMapNode.put(2, 2);                        // myHashMap 现在为 [[1,1], [2,2]]
        System.out.println(myHashMapNode.get(1));       // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
        System.out.println(myHashMapNode.get(3));       // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
        myHashMapNode.put(2, 1);                        // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
        System.out.println(myHashMapNode.get(2));       // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
        myHashMapNode.remove(2);                    // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
        System.out.println(myHashMapNode.get(2));       // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
    }

    @Test
    public void test0002()
    {
        P0002AddTwoNumbers p0002 = new P0002AddTwoNumbers();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode l3 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode l4 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))));
        System.out.println(p0002.addTwoNumbers_1(l1, l2));
        System.out.println(p0002.addTwoNumbers_2(l3, l4));
    }
}
