package domain;

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

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        return super.equals(obj);
    }

    @Override
    public String toString()
    {
        return "ListNode{" + "val=" + val + ", next=" + next + '}';
    }
}
