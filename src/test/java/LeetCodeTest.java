import domain.ListNode;
import org.junit.Test;
import problem.java.*;
import sun.security.util.Length;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2020-10-13 22:13
 * @since JDK 1.8
 */
public class LeetCodeTest
{
    @Test
    public void testP0001()
    {
        P0001_TwoSum obj = new P0001_TwoSum();
        int[] numbers = {2, 5, 7, 9, 12};
        int sum = 17;
        int[] result = obj.twoNumbersAddUp02(numbers, sum);
        for (int i : result)
        {
            System.out.println("    i = " + i);
        }
    }

    @Test
    public void testP0003()
    {
        P0003_LongestSubstringWithoutRepeatingCharacters obj = new P0003_LongestSubstringWithoutRepeatingCharacters();
        int length = obj.lengthOfLongestSubstring("P0003_LongestSubstringWithoutRepeatingCharacters");
        System.out.println("length = " + length);
    }

    @Test
    public void testP0007()
    {
        P0007_ReverseInteger obj = new P0007_ReverseInteger();
        int result = obj.reverse(-321);
        System.out.println("result = " + result);
    }

    @Test
    public void testP0009()
    {
        P0009_PalindromeNumber obj = new P0009_PalindromeNumber();
        System.out.println("result = " + obj.isPalindrome(10201));
    }

    @Test
    public void testP0013()
    {
        P0013_RomanToInteger obj = new P0013_RomanToInteger();
        System.out.println("result = " + obj.romanToInt("CMXCIX"));
    }

    @Test
    public void testP0019()
    {
        P0019_RemoveNthNodeFromEndOfList obj = new P0019_RemoveNthNodeFromEndOfList();
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        ListNode node = obj.removeNthFromEnd(node1, 3);
        System.out.println("node = " + node);
    }

    @Test
    public void testP0012()
    {
        P0012_IntegerToRoman obj = new P0012_IntegerToRoman();
        System.out.println("result = " + obj.intToRoman(3994));
    }

    @Test
    public void testP0844()
    {
        P0844_BackspaceStringCompare obj = new P0844_BackspaceStringCompare();
        System.out.println("result = " + obj.backspaceString("oi###mu#ueo##pk#o##rsztu#y#s#xu###bxx##dqc#gz#djz"));
    }
    @Test
    public void testP0014()
    {
        P0014_LongestCommonPrefix obj = new P0014_LongestCommonPrefix();
        System.out.println("result = " + obj.longestCommonPrefix(new String[] {"ab","a"}));
    }

    @Test
    public void testP0143()
    {
        P0143_ReorderList obj = new P0143_ReorderList();
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        obj.reorderList(node1);
    }

    @Test
    public void testP0925()
    {
        P0925_LongPressedName obj = new P0925_LongPressedName();
        System.out.println("result = " + obj.isLongPressedName("saeedi","ssaaeediixxxiii"));
    }

    @Test
    public void testP0028()
    {
        P0028_ImplementStrStr obj = new P0028_ImplementStrStr();
        System.out.println("result = " + obj.strStr("mississippi","issippip"));
    }
}
