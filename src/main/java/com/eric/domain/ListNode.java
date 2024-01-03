package com.eric.domain;

import java.util.Objects;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2020-10-14 20:33
 * @since JDK 1.8
 */
public class ListNode
{
    public int val;
    public ListNode next;

    @Override
    public String toString()
    {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public ListNode()
    {
    }

    public ListNode(int val)
    {
        this.val = val;
    }

    public ListNode(int val, ListNode next)
    {
        this.val = val;
        this.next = next;
    }

    public static ListNode of(int... elements)
    {
        ListNode p = null;
        for (int i = elements.length - 1; i >= 0; i--)
        {
            p = new ListNode(elements[i], p);
        }
        return p;
    }

    public ListNode append(ListNode last)
    {
        ListNode p = this;
        while (p.next != null)
        {
            p = p.next;
        }
        p.next = last;
        return this;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }
}
