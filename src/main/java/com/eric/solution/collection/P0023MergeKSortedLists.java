package com.eric.solution.collection;

import com.eric.domain.ListNode;

/**
 * Description : 合并 K 个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * <p>
 * 示例 2：
 * 输入：lists = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * 提示：
 * -> k == lists.length
 * -> 0 <= k <= 10^4
 * -> 0 <= lists[i].length <= 500
 * -> -10^4 <= lists[i][j] <= 10^4
 * -> lists[i] 按 升序 排列
 * -> lists[i].length 的总和不超过 10^4
 *
 * @author Eric L SHU
 * @date 2023-08-28 22:11
 * @since jdk-11.0.14
 */
public class P0023MergeKSortedLists
{
    public ListNode mergeKLists(ListNode[] lists)
    {
        if (lists.length == 0)
            return null;
        return split(lists, 0, lists.length - 1);

    }

    private ListNode split(ListNode[] lists, int i, int j)
    {
        if (i == j)
            return lists[i];
        int mid = (i + j) >>> 1;
        ListNode left = split(lists, i, mid);
        ListNode right = split(lists, mid + 1, j);
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode sentinel = new ListNode();
        ListNode node = sentinel;
        while (l1 != null && l2 != null)
        {
            if (l1.val < l2.val)
            {
                node.next = l1;
                l1 = l1.next;
            }
            else
            {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        node.next = l1 == null ? l2 : l1;
        return sentinel.next;
    }

    public ListNode mergeKListsByHeap(ListNode[] lists)
    {
        if (lists.length == 0)
            return null;
        MinHeap heap = new MinHeap(lists.length);
        for (ListNode node : lists)
        {
            if (node != null)
            {
                // 将链表的头结点加入小顶堆
                heap.offer(node);
            }
        }
        ListNode sentinel = new ListNode(-1, null);
        ListNode pointer = sentinel;
        while (!heap.isEmpty())
        {
            ListNode min = heap.poll();
            pointer.next = min;
            pointer = min;
            if (min.next != null)
            {
                heap.offer(min.next);
            }
        }
        return sentinel.next;
    }


    static class MinHeap
    {
        ListNode[] array;
        int size;

        public MinHeap(int capacity)
        {
            array = new ListNode[capacity];
        }

        public boolean offer(ListNode offered)
        {
            if (isFull())
                return false;

            int child = size++;
            shiftUp(offered, child);
            return true;
        }

        private void shiftUp(ListNode offered, int child)
        {
            int parent = (child - 1) / 2;
            while (child > 0 && offered.val < array[parent].val)
            {
                array[child] = array[parent];
                child = parent;
                parent = (child - 1) / 2;
            }
            array[child] = offered;
        }

        public ListNode poll()
        {
            if (isEmpty())
                return null;
            swap(0, --size);
            ListNode node = array[size];
            array[size] = null;
            shiftDown(0);
            return node;
        }

        private void shiftDown(int parent)
        {
            int left = 2 * parent + 1;
            int right = left + 1;
            int min = parent;
            if (left < size && array[left].val < array[min].val)
                min = left;
            if (right < size && array[right].val < array[min].val)
                min = right;
            if (min != parent)
            {
                swap(min, parent);
                shiftDown(min);
            }
        }

        private void swap(int i, int j)
        {
            ListNode t = array[i];
            array[i] = array[j];
            array[j] = t;
        }

        public boolean isFull()
        {
            return size == array.length;
        }

        public boolean isEmpty()
        {
            return size == 0;
        }
    }
}
