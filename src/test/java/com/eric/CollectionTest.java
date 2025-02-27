package com.eric;

import com.eric.domain.ListNode;
import com.eric.domain.TreeNode;
import com.eric.solution.collection.*;
import com.eric.solution.design.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertTrue(randomizedCollection.insert(21));
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

        assertEquals(2, p0142.detectCycle1(node1).val);
        assertEquals(2, p0142.detectCycle2(node1).val);
    }

    @Test
    public void testP0143()
    {
        P0143ReorderList p0143 = new P0143ReorderList();
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        p0143.reorderList_1(head1);
        assertEquals(ListNode.of(1, 4, 2, 3), head1);
        p0143.reorderList_2(head2);
        assertEquals(ListNode.of(1, 5, 2, 4, 3), head2);
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

        assertEquals(ListNode.of(0, 1, 2, 3, 4, 5), head);

        head = obj.reverseListByIteration(head);
        assertEquals(ListNode.of(5, 4, 3, 2, 1, 0), head);

        head = obj.reverseListByRecursion(head);
        assertEquals(ListNode.of(0, 1, 2, 3, 4, 5), head);

        head = obj.reverseListByStack(head);
        assertEquals(ListNode.of(5, 4, 3, 2, 1, 0), head);
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

        assertEquals(ListNode.of(1, 2, 3, 4, 5), obj.removeElements_recursion(head, 6));
        assertNull(obj.removeElements_iteration(null, 1));
    }

    @Test
    public void test0021()
    {
        P0021MergeTwoSortedLists obj = new P0021MergeTwoSortedLists();

        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        assertEquals(ListNode.of(1, 1, 2, 3, 4, 4), obj.mergeTwoLists(l1, l2));
    }

    @Test
    public void test0023()
    {
        P0023MergeKSortedLists p0023 = new P0023MergeKSortedLists();

        ListNode[] lists1 = {
                ListNode.of(1, 4, 5),
                ListNode.of(1, 3, 4),
                ListNode.of(2, 6),
                null
        };
        assertEquals(ListNode.of(1, 1, 2, 3, 4, 4, 5, 6), p0023.mergeKLists(lists1));
        ListNode[] lists2 = {
                ListNode.of(1, 4, 5),
                ListNode.of(1, 3, 4),
                ListNode.of(2, 6),
                null
        };
        assertEquals(ListNode.of(1, 1, 2, 3, 4, 4, 5, 6), p0023.mergeKListsByHeap(lists2));
    }

    @Test
    public void test0234()
    {
        P0234PalindromeLinkedList p0234 = new P0234PalindromeLinkedList();
        assertTrue(p0234.isPalindrome_1(ListNode.of(1, 2, 2, 1)));
        assertTrue(p0234.isPalindrome_1(ListNode.of(1, 2, 3, 2, 1)));
        assertFalse(p0234.isPalindrome_1(ListNode.of(1, 2, 3)));

        assertTrue(p0234.isPalindrome_2(ListNode.of(1, 2, 2, 1)));
        assertTrue(p0234.isPalindrome_2(ListNode.of(1, 2, 3, 2, 1)));
        assertFalse(p0234.isPalindrome_2(ListNode.of(1, 2, 3)));
    }

    @Test
    public void test0083()
    {
        P0083RemoveDuplicatesFromSortedList p0083 = new P0083RemoveDuplicatesFromSortedList();
        assertEquals(ListNode.of(1, 2, 3), p0083.deleteDuplicates(ListNode.of(1, 1, 2, 3, 3)));
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

        assertEquals(ListNode.of(8, 4, 5), p0160.getIntersectionNode_hash(listA, listB));
        assertEquals(ListNode.of(8, 4, 5), p0160.getIntersectionNode_pointers(listA, listB));
    }

    @Test
    public void test0706()
    {
        P0706DesignHashMap.MyHashMapArray myHashMapArray = new P0706DesignHashMap.MyHashMapArray();
        myHashMapArray.put(1, 1);                       // myHashMap 现在为 [[1,1]]
        myHashMapArray.put(2, 2);                       // myHashMap 现在为 [[1,1], [2,2]]
        assertEquals(1, myHashMapArray.get(1));      // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
        assertEquals(-1, myHashMapArray.get(3));      // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
        myHashMapArray.put(2, 1);                       // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
        assertEquals(1, myHashMapArray.get(2));      // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
        myHashMapArray.remove(2);                   // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
        assertEquals(-1, myHashMapArray.get(2));      // 返回 -1（未找到），myHashMap 现在为 [[1,1]]

        P0706DesignHashMap.MyHashMapNode myHashMapNode = new P0706DesignHashMap.MyHashMapNode();
        myHashMapNode.put(1, 1);                        // myHashMap 现在为 [[1,1]]
        myHashMapNode.put(2, 2);                        // myHashMap 现在为 [[1,1], [2,2]]
        assertEquals(1, myHashMapNode.get(1));       // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
        assertEquals(-1, myHashMapNode.get(3));       // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
        myHashMapNode.put(2, 1);                        // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
        assertEquals(1, myHashMapNode.get(2));       // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
        myHashMapNode.remove(2);                    // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
        assertEquals(-1, myHashMapNode.get(2));       // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
    }

    @Test
    public void test0002()
    {
        P0002AddTwoNumbers p0002 = new P0002AddTwoNumbers();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode l3 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode l4 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))));
        assertEquals(ListNode.of(7, 0, 8), p0002.addTwoNumbers_1(l1, l2));
        assertEquals(ListNode.of(7, 0, 8), p0002.addTwoNumbers_3(l1, l2));
        assertEquals(ListNode.of(8, 9, 9, 0, 0, 1), p0002.addTwoNumbers_2(l3, l4));
    }

    @Test
    public void test0445()
    {
        P0445AddTwoNumbersII p0445 = new P0445AddTwoNumbersII();
        ListNode l1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode l3 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode l4 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))));
        assertEquals(ListNode.of(7, 8, 0, 7), p0445.addTwoNumbers_1(l1, l2));
        assertEquals(ListNode.of(1, 0, 0, 9, 9, 8), p0445.addTwoNumbers_2(l3, l4));
    }

    @Test
    public void test0082()
    {
        P0082RemoveDuplicatesFromSortedListII p0082 = new P0082RemoveDuplicatesFromSortedListII();
        assertEquals(ListNode.of(1, 2, 5), p0082.deleteDuplicates(ListNode.of(1, 2, 3, 3, 4, 4, 5)));
        assertEquals(ListNode.of(2, 3), p0082.deleteDuplicates(ListNode.of(1, 1, 1, 2, 3)));
        assertNull(p0082.deleteDuplicates(ListNode.of(1, 1, 1)));
    }

    @Test
    public void test0024()
    {
        P0024SwapNodesInPairs p0024 = new P0024SwapNodesInPairs();
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        assertEquals(ListNode.of(2, 1, 4, 3), p0024.swapPairs_recursion(head1));
        assertEquals(ListNode.of(2, 1, 4, 3, 6, 5), p0024.swapPairs_iteration(head2));
    }

    @Test
    public void test0707()
    {
        P0707SinglyLinkedList singlyLinkedList = new P0707SinglyLinkedList();
        singlyLinkedList.addAtHead(1);
        singlyLinkedList.addAtTail(3);
        singlyLinkedList.addAtIndex(1, 2); // 链表变为1-> 2-> 3
        singlyLinkedList.get(1);                    // 返回2
        singlyLinkedList.deleteAtIndex(1);          // 现在链表是1-> 3
        singlyLinkedList.get(1);                    // 返回3

        P0707DoublyLinkedList doublyLinkedList = new P0707DoublyLinkedList();
        doublyLinkedList.addAtHead(1);
        doublyLinkedList.addAtTail(3);
        doublyLinkedList.addAtIndex(1, 2); // 链表变为1-> 2-> 3
        doublyLinkedList.get(1);                    // 返回2
        doublyLinkedList.deleteAtIndex(1);          // 现在链表是1-> 3
        doublyLinkedList.get(1);                    // 返回3
    }

    @Test
    public void test0402()
    {
        P0402RemoveKDigits obj = new P0402RemoveKDigits();
        assertEquals("1219", obj.removeKDigits("1432219", 3));
        assertEquals("200", obj.removeKDigits("10200", 1));
        assertEquals("0", obj.removeKDigits("10", 1));
        assertEquals("11", obj.removeKDigits("112", 1));
        assertEquals("33", obj.removeKDigits("5337", 2));
    }

    @Test
    public void test0232()
    {
        P0232MyQueue1 myQueue1 = new P0232MyQueue1();

        myQueue1.push(1); // queue is: [1]
        myQueue1.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue1.peek(); // return 1
        myQueue1.pop(); // return 1, queue is [2]
        myQueue1.empty(); // return false

        P0232MyQueue2 myQueue2 = new P0232MyQueue2();

        myQueue2.push(1); // queue is: [1]
        myQueue2.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue2.peek(); // return 1
        myQueue2.pop(); // return 1, queue is [2]
        myQueue2.empty(); // return false
    }

    @Test
    public void test0155()
    {
        P0155MinStack1 minStack1 = new P0155MinStack1();
        minStack1.push(-2);
        minStack1.push(0);
        minStack1.push(-3);
        assertEquals(-3, minStack1.getMin());
        minStack1.pop();
        assertEquals(0, minStack1.top());
        assertEquals(-2, minStack1.getMin());

        P0155MinStack2 minStack2 = new P0155MinStack2();
        minStack2.push(-2);
        minStack2.push(0);
        minStack2.push(-3);
        assertEquals(-3, minStack2.getMin());
        minStack2.pop();
        assertEquals(0, minStack2.top());
        assertEquals(-2, minStack2.getMin());
    }

    @Test
    public void test1249()
    {
        P1249MinimumRemoveToMakeValidParentheses p1249 = new P1249MinimumRemoveToMakeValidParentheses();
        assertEquals("lee(t(c)o)de", p1249.minRemoveToMakeValid_1("lee(t(c)o)de)"));
        assertEquals("ab(c)d", p1249.minRemoveToMakeValid_2("a)b(c)d"));
        assertEquals("", p1249.minRemoveToMakeValid_3("))(("));
    }

    @Test
    public void test1823()
    {
        P1823FindTheWinnerOfTheCircularGame p1823 = new P1823FindTheWinnerOfTheCircularGame();
        assertEquals(3, p1823.findTheWinner_queue(5, 2));
        assertEquals(3, p1823.findTheWinner_recursion(5, 2));
        assertEquals(3, p1823.findTheWinner_iteration(5, 2));
    }

    @Test
    public void test0025()
    {
        P0025ReverseNodesInKGroup p0025 = new P0025ReverseNodesInKGroup();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));
        assertEquals(ListNode.of(2, 1, 4, 3, 6, 5, 7), p0025.reverseKGroup_1(head, 2));
        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));
        assertEquals(ListNode.of(3, 2, 1, 6, 5, 4, 7), p0025.reverseKGroup_2(head, 3));
    }

    @Test
    public void test1376()
    {
        P1367LinkedListInBinaryTree p1376 = new P1367LinkedListInBinaryTree();
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(2, new ListNode(9))));
        TreeNode root = new TreeNode(1,
                new TreeNode(4,
                        null,
                        new TreeNode(2,
                                new TreeNode(1),
                                null)),
                new TreeNode(4,
                        new TreeNode(2,
                                new TreeNode(6),
                                new TreeNode(8,
                                        new TreeNode(1),
                                        new TreeNode(3))),
                        null));
        assertFalse(p1376.isSubPath(head, root));
    }

    @Test
    public void testP0019()
    {
        P0019RemoveNthNodeFromEndOfList p0019 = new P0019RemoveNthNodeFromEndOfList();
        assertEquals(ListNode.of(1, 2, 3, 4), p0019.removeNthFromEnd(ListNode.of(1, 2, 3, 4, 5), 1));
        assertEquals(ListNode.of(1, 2, 3, 5), p0019.removeNthFromEnd(ListNode.of(1, 2, 3, 4, 5), 2));
        assertEquals(ListNode.of(1, 2, 4, 5), p0019.removeNthFromEnd(ListNode.of(1, 2, 3, 4, 5), 3));
        assertEquals(ListNode.of(1, 3, 4, 5), p0019.removeNthFromEnd(ListNode.of(1, 2, 3, 4, 5), 4));
        assertEquals(ListNode.of(2, 3, 4, 5), p0019.removeNthFromEnd(ListNode.of(1, 2, 3, 4, 5), 5));
    }

    @Test
    public void test0373()
    {
        P0373FindKPairsWithSmallestSums p0373 = new P0373FindKPairsWithSmallestSums();
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int[] nums3 = {1, 1, 2};
        int[] nums4 = {1, 2, 3};
        int[] nums5 = {1, 2};
        int[] nums6 = {3};
        assertEquals("[[1, 6], [1, 4], [1, 2]]", p0373.kSmallestPairs_1(nums1, nums2, 3).toString());
        assertEquals("[[1, 1], [1, 1]]", p0373.kSmallestPairs_2(nums3, nums4, 2).toString());
        assertEquals("[[1, 3], [2, 3]]", p0373.kSmallestPairs_2(nums5, nums6, 3).toString());
    }

    @Test
    public void test0138()
    {
        P0138CopyListWithRandomPointer.Node node1 = getNode();
        P0138CopyListWithRandomPointer p0138 = new P0138CopyListWithRandomPointer();
        assertEquals("Node{val=7, next=Node{val=13, next=Node{val=11, next=Node{val=10, next=Node{val=1, next=null}}}}}",
                p0138.copyRandomList_1(node1).toString());
        assertEquals("Node{val=7, next=Node{val=13, next=Node{val=11, next=Node{val=10, next=Node{val=1, next=null}}}}}",
                p0138.copyRandomList_2(node1).toString());
    }

    private static P0138CopyListWithRandomPointer.Node getNode()
    {
        P0138CopyListWithRandomPointer.Node node5 = new P0138CopyListWithRandomPointer.Node(1, null);
        P0138CopyListWithRandomPointer.Node node4 = new P0138CopyListWithRandomPointer.Node(10, node5);
        P0138CopyListWithRandomPointer.Node node3 = new P0138CopyListWithRandomPointer.Node(11, node4);
        P0138CopyListWithRandomPointer.Node node2 = new P0138CopyListWithRandomPointer.Node(13, node3);
        P0138CopyListWithRandomPointer.Node node1 = new P0138CopyListWithRandomPointer.Node(7, node2);
        node1.setRandom(null);
        node2.setRandom(node1);
        node3.setRandom(node5);
        node4.setRandom(node3);
        node5.setRandom(node1);
        return node1;
    }

    @Test
    public void test0061()
    {
        P0061RotateList p0061 = new P0061RotateList();
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode head2 = new ListNode(0, new ListNode(1, new ListNode(2)));
        assertEquals(ListNode.of(4, 5, 1, 2, 3), p0061.rotateRight_1(head1, 2));
        assertEquals(ListNode.of(2, 0, 1), p0061.rotateRight_2(head2, 4));
    }

    @Test
    public void test1845()
    {
        P1845SeatManager p1845 = new P1845SeatManager(5);
        assertEquals(1, p1845.reserve());
        assertEquals(2, p1845.reserve());
        p1845.unreserve(1);
        assertEquals(1, p1845.reserve());
        assertEquals(3, p1845.reserve());
        assertEquals(4, p1845.reserve());
        assertEquals(5, p1845.reserve());
        p1845.unreserve(5);
    }

    @Test
    public void test1917()
    {
        P1917AuthenticationManager1 authenticationManager1 = new P1917AuthenticationManager1(5); // 构造 AuthenticationManager ，设置 timeToLive = 5 秒。
        authenticationManager1.renew("aaa", 1);      // 时刻 1 时，没有验证码的 tokenId 为 "aaa" ，没有验证码被更新。
        authenticationManager1.generate("aaa", 2);   // 时刻 2 时，生成一个 tokenId 为 "aaa" 的新验证码。
        assertEquals(1, authenticationManager1.countUnexpiredTokens(6));      // 时刻 6 时，只有 tokenId 为 "aaa" 的验证码未过期，所以返回 1 。
        authenticationManager1.generate("bbb", 7);   // 时刻 7 时，生成一个 tokenId 为 "bbb" 的新验证码。
        authenticationManager1.renew("aaa", 8);      // tokenId 为 "aaa" 的验证码在时刻 7 过期，且 8 >= 7 ，所以时刻 8 的renew 操作被忽略，没有验证码被更新。
        authenticationManager1.renew("bbb", 10);     // tokenId 为 "bbb" 的验证码在时刻 10 没有过期，所以 renew 操作会执行，该 token 将在时刻 15 过期。
        assertEquals(0, authenticationManager1.countUnexpiredTokens(15));     // tokenId 为 "bbb" 的验证码在时刻 15 过期，tokenId 为 "aaa" 的验证码在时刻 7 过期，所有验证码均已过期，所以返回 0 。

        P1917AuthenticationManager2 authenticationManager2 = new P1917AuthenticationManager2(5); // 构造 AuthenticationManager ，设置 timeToLive = 5 秒。
        authenticationManager2.renew("aaa", 1);      // 时刻 1 时，没有验证码的 tokenId 为 "aaa" ，没有验证码被更新。
        authenticationManager2.generate("aaa", 2);   // 时刻 2 时，生成一个 tokenId 为 "aaa" 的新验证码。
        assertEquals(1, authenticationManager2.countUnexpiredTokens(6));      // 时刻 6 时，只有 tokenId 为 "aaa" 的验证码未过期，所以返回 1 。
        authenticationManager2.generate("bbb", 7);   // 时刻 7 时，生成一个 tokenId 为 "bbb" 的新验证码。
        authenticationManager2.renew("aaa", 8);      // tokenId 为 "aaa" 的验证码在时刻 7 过期，且 8 >= 7 ，所以时刻 8 的renew 操作被忽略，没有验证码被更新。
        authenticationManager2.renew("bbb", 10);     // tokenId 为 "bbb" 的验证码在时刻 10 没有过期，所以 renew 操作会执行，该 token 将在时刻 15 过期。
        assertEquals(0, authenticationManager2.countUnexpiredTokens(15));     // tokenId 为 "bbb" 的验证码在时刻 15 过期，tokenId 为 "aaa" 的验证码在时刻 7 过期，所有验证码均已过期，所以返回 0 。
    }

    @Test
    public void test0380()
    {
        P0380RandomizedSet1 randomizedSet1 = new P0380RandomizedSet1();
        assertTrue(randomizedSet1.insert(1)); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        assertFalse(randomizedSet1.remove(2)); // 返回 false ，表示集合中不存在 2 。
        assertTrue(randomizedSet1.insert(2)); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        assertTrue(randomizedSet1.getRandom() >= 1);   // getRandom 应随机返回 1 或 2 。
        assertTrue(randomizedSet1.remove(1)); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        assertFalse(randomizedSet1.insert(2)); // 2 已在集合中，所以返回 false 。
        assertEquals(2, randomizedSet1.getRandom());   // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。

        P0380RandomizedSet2 randomizedSet2 = new P0380RandomizedSet2();
        assertTrue(randomizedSet2.insert(1)); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        assertFalse(randomizedSet2.remove(2)); // 返回 false ，表示集合中不存在 2 。
        assertTrue(randomizedSet2.insert(2)); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        assertTrue(randomizedSet1.getRandom() <= 2);   // getRandom 应随机返回 1 或 2 。
        assertTrue(randomizedSet2.remove(1)); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        assertFalse(randomizedSet2.insert(2)); // 2 已在集合中，所以返回 false 。
        assertEquals(2, randomizedSet2.getRandom());   // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
    }

    @Test
    public void test0622()
    {
        P0622MyCircularQueue1 myCircularQueue1 = new P0622MyCircularQueue1(3);
        assertTrue(myCircularQueue1.enQueue(1));  // 返回 true
        assertTrue(myCircularQueue1.enQueue(2));  // 返回 true
        assertTrue(myCircularQueue1.enQueue(3));  // 返回 true
        assertFalse(myCircularQueue1.enQueue(4));  // 返回 false，队列已满
        assertEquals(3, myCircularQueue1.Rear());  // 返回 3
        assertTrue(myCircularQueue1.isFull());  // 返回 true
        assertTrue(myCircularQueue1.deQueue());  // 返回 true
        assertTrue(myCircularQueue1.enQueue(4));  // 返回 true
        assertEquals(4, myCircularQueue1.Rear());  // 返回 4

        P0622MyCircularQueue2 myCircularQueue2 = new P0622MyCircularQueue2(3);
        assertTrue(myCircularQueue2.enQueue(1));  // 返回 true
        assertTrue(myCircularQueue2.enQueue(2));  // 返回 true
        assertTrue(myCircularQueue2.enQueue(3));  // 返回 true
        assertFalse(myCircularQueue2.enQueue(4));  // 返回 false，队列已满
        assertEquals(3, myCircularQueue2.Rear());  // 返回 3
        assertTrue(myCircularQueue2.isFull());  // 返回 true
        assertTrue(myCircularQueue2.deQueue());  // 返回 true
        assertTrue(myCircularQueue2.enQueue(4));  // 返回 true
        assertEquals(4, myCircularQueue2.Rear());  // 返回 4

        P0622MyCircularQueue3 myCircularQueue3 = new P0622MyCircularQueue3(3);
        assertTrue(myCircularQueue3.enQueue(1));  // 返回 true
        assertTrue(myCircularQueue3.enQueue(2));  // 返回 true
        assertTrue(myCircularQueue3.enQueue(3));  // 返回 true
        assertFalse(myCircularQueue3.enQueue(4));  // 返回 false，队列已满
        assertEquals(3, myCircularQueue3.Rear());  // 返回 3
        assertTrue(myCircularQueue3.isFull());  // 返回 true
        assertTrue(myCircularQueue3.deQueue());  // 返回 true
        assertTrue(myCircularQueue3.enQueue(4));  // 返回 true
        assertEquals(4, myCircularQueue3.Rear());  // 返回 4
    }

    @Test
    public void test0729()
    {
        P0729MyCalendar1 myCalendar1 = new P0729MyCalendar1();
        assertTrue(myCalendar1.book(10, 20)); // return True
        assertFalse(myCalendar1.book(15, 25)); // return False ，这个日程安排不能添加到日历中，因为时间 15 已经被另一个日程安排预订了。
        assertTrue(myCalendar1.book(20, 30)); // return True ，这个日程安排可以添加到日历中，因为第一个日程安排预订的每个时间都小于 20 ，且不包含时间 20 。

        P0729MyCalendar2 myCalendar2 = new P0729MyCalendar2();
        assertTrue(myCalendar2.book(10, 20)); // return True
        assertFalse(myCalendar2.book(15, 25)); // return False
        assertTrue(myCalendar2.book(20, 30)); // return True
    }

    @Test
    public void test1669()
    {
        P1669MergeInBetweenLinkedLists p1669 = new P1669MergeInBetweenLinkedLists();
        ListNode list1 = new ListNode(0, new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(5))))));
        ListNode list2 = new ListNode(1000000, new ListNode(1000001, new ListNode(1000002)));
        assertEquals(ListNode.of(0, 1, 2, 1000000, 1000001, 1000002, 5),
                p1669.mergeInBetween(list1, 3, 4, list2));
    }


    @Test
    public void test2487()
    {
        ListNode target = new ListNode(13, new ListNode(8));

        ListNode node = new ListNode(5, new ListNode(2, new ListNode(13,
                new ListNode(3, new ListNode(8)))));
        assertEquals(target, P2487RemoveNodesFromLinkedList.removeNodesRecursion(node));

        node = new ListNode(5, new ListNode(2, new ListNode(13,
                new ListNode(3, new ListNode(8)))));
        assertEquals(target, P2487RemoveNodesFromLinkedList.removeNodesStack(node));

        node = new ListNode(5, new ListNode(2, new ListNode(13,
                new ListNode(3, new ListNode(8)))));
        assertEquals(target, P2487RemoveNodesFromLinkedList.removeNodesReverse(node));
    }

    @Test
    public void test0146()
    {
        P0146LRUCache lRUCache = new P0146LRUCache(2);
        lRUCache.put(1, 1);                         // 缓存是 {1=1}
        lRUCache.put(2, 2);                         // 缓存是 {1=1, 2=2}
        assertEquals(1, lRUCache.get(1));   // 返回 1
        lRUCache.put(3, 3);                         // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        assertEquals(-1, lRUCache.get(2));  // 返回 -1 (未找到)
        lRUCache.put(4, 4);                         // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        assertEquals(-1, lRUCache.get(1));  // 返回 -1 (未找到)
        assertEquals(3, lRUCache.get(3));   // 返回 3
        assertEquals(4, lRUCache.get(4));   // 返回 4
    }

    @Test
    public void test0460()
    {
        P0460LFUCache lfu = new P0460LFUCache(2);
        lfu.put(1, 1);                              // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);                              // cache=[2,1], cnt(2)=1, cnt(1)=1
        assertEquals(1, lfu.get(1));        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);                              // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小  cache=[3,1], cnt(3)=1, cnt(1)=2
        assertEquals(-1, lfu.get(2));       // 返回 -1（未找到）
        assertEquals(3, lfu.get(3));        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);                              // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用 cache=[4,3], cnt(4)=1, cnt(3)=2
        assertEquals(-1, lfu.get(1));      // 返回 -1（未找到）
        assertEquals(3, lfu.get(3));      // cache=[3,4], cnt(4)=1, cnt(3)=3
        assertEquals(4, lfu.get(4));      // cache=[3,4], cnt(4)=2, cnt(3)=3
    }

    @Test
    public void test1206()
    {
        P1206DesignSkipList.SkipList skiplist = new P1206DesignSkipList.SkipList();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        assertFalse(skiplist.search(0));    // 返回 false
        skiplist.add(4);
        assertTrue(skiplist.search(1));     // 返回 true
        assertFalse(skiplist.erase(0));     // 返回 false，0 不在跳表中
        assertTrue(skiplist.erase(1));      // 返回 true
        assertFalse(skiplist.search(1));   // 返回 false，1 已被擦除
    }

    @Test
    public void test0355()
    {
        P0355DesignTwitter.Twitter twitter = new P0355DesignTwitter.Twitter();
        twitter.postTweet(1, 5);                        // 用户 1 发送了一条新推文 (用户 id = 1, 推文 id = 5)
        assertEquals(List.of(5), twitter.getNewsFeed(1));   // 用户 1 的获取推文应当返回一个列表，其中包含一个 id 为 5 的推文
        twitter.follow(1, 2);                       // 用户 1 关注了用户 2
        twitter.postTweet(2, 6);                        // 用户 2 发送了一个新推文 (推文 id = 6)
        assertEquals(List.of(6, 5), twitter.getNewsFeed(1));    // 用户 1 的获取推文应当返回一个列表，其中包含两个推文，id 分别为 -> [6, 5] 。推文 id 6 应当在推文 id 5 之前，因为它是在 5 之后发送的
        twitter.unfollow(1, 2);                     // 用户 1 取消关注了用户 2
        assertEquals(List.of(5), twitter.getNewsFeed(1));   // 用户 1 获取推文应当返回一个列表，其中包含一个 id 为 5 的推文。因为用户 1 已经不再关注用户 2
    }

    @Test
    public void test1472()
    {
        P1472BrowserHistory browserHistory = new P1472BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        assertEquals("facebook.com", browserHistory.back(1));
        assertEquals("google.com", browserHistory.back(1));
        assertEquals("facebook.com", browserHistory.forward(1));
        browserHistory.visit("linkedin.com");
        assertEquals("linkedin.com", browserHistory.forward(2));
        assertEquals("google.com", browserHistory.back(2));
        assertEquals("leetcode.com", browserHistory.back(7));
    }

    @Test
    public void test2296()
    {
        P2296DesignATextEditor textEditor = new P2296DesignATextEditor(); // 当前 text 为 "|" 。（'|' 字符表示光标）

        textEditor.addText("leetcode");                                     // 当前文本为 "leetcode|" 。
        assertEquals(4, textEditor.deleteText(4));              // 返回 4，当前文本为 "leet|"， 删除了 4 个字符。
        textEditor.addText("practice");                                     // 当前文本为 "leetpractice|" 。
        assertEquals("etpractice", textEditor.cursorRight(3));  // 当前文本为 "leetpractice|". 光标无法移动到文本以外，所以无法移动。 "etpractice" 是光标左边的 10 个字符。
        assertEquals("leet", textEditor.cursorLeft(8));         // 返回 "leet"
        assertEquals(4, textEditor.deleteText(10)); // 返回 4,当前文本为 "leet|practice" 。"leet" 是光标左边的 min(10, 4) = 4 个字符。
        System.out.println("textEditor.editor = " + textEditor.editor);
        assertEquals("",textEditor.cursorLeft(2)); // 返回 "",当前文本为 "|practice" 。只有 4 个字符被删除了。
        assertEquals("practi",textEditor.cursorRight(6)); // 返回 "practi",当前文本为 "|practice" 。光标无法移动到文本以外，所以无法移动。"" 是光标左边的 min(10, 0) = 0 个字符。
        textEditor.addText("abc");
        System.out.println("textEditor.editor = " + textEditor.editor);
        // 当前文本为 "practi|ce" 。
        // "practi" 是光标左边的 min(10, 6) = 6 个字符。
    }
}
