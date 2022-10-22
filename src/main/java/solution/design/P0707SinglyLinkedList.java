package solution.design;

/**
 * Description : 设计链表
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。
 * val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * <p>
 * 在链表类中实现这些功能：
 * -> get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * -> addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * -> addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * -> addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * -> deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 * <p>
 * 示例：
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 * <p>
 * 提示：
 * -> 0 <= index, val <= 1000
 * -> 请不要使用内置的 LinkedList 库。
 * -> get, addAtHead, addAtTail, addAtIndex 和 deleteAtIndex 的操作次数不超过 2000。
 *
 * @author Eric L SHU
 * @date 2022-10-22 6:31 PM
 * @since jdk-11.0.14
 */
public class P0707SinglyLinkedList
{
    int size;
    ListNode dummyHead;

    public P0707SinglyLinkedList()
    {
        size = 0;
        dummyHead = new ListNode(0);
    }

    public int get(int index)
    {
        if (index < 0 || index >= size)
            return -1;
        ListNode curr = dummyHead;
        while (index-- >= 0)
        {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val)
    {
        addAtIndex(0, val);
    }

    public void addAtTail(int val)
    {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val)
    {
        if (index > size)
            return;
        index = Math.max(0, index);
        size++;
        ListNode prev = dummyHead;
        while (index-- > 0)
        {
            prev = prev.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = prev.next;
        prev.next = toAdd;
    }

    public void deleteAtIndex(int index)
    {
        if (index < 0 || index >= size)
            return;
        size--;
        ListNode prev = dummyHead;
        while (index-- > 0)
        {
            prev = prev.next;
        }
        prev.next = prev.next.next;
    }

    static class ListNode
    {
        int val;
        ListNode next;

        public ListNode(int val)
        {
            this.val = val;
        }

        @Override
        public String toString()
        {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString()
    {
        return "SinglyLinkedList{" +
                "sentinel=" + dummyHead +
                '}';
    }
}
