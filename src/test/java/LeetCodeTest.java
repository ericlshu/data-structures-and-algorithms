import domain.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
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
        System.out.println("result = " + obj.longestCommonPrefix(new String[]{"ab", "a"}));
    }

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

    @Test
    public void testP0925()
    {
        P0925_LongPressedName obj = new P0925_LongPressedName();
        System.out.println("result = " + obj.isLongPressedName("saeedi", "ssaaeediixxxiii"));
    }

    @Test
    public void testP0028()
    {
        P0028_ImplementStrStr obj = new P0028_ImplementStrStr();
        System.out.println("result = " + obj.strStr("mississippi", "issippip"));
    }

    @Test
    public void testP1024()
    {
        P1024_VideoStitching obj = new P1024_VideoStitching();
        int[][] clips = {{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}};
        System.out.println("result = " + obj.videoStitching(clips, 9));
    }

    @Test
    public void testP0845()
    {
        P0845_LongestMountainInArray obj = new P0845_LongestMountainInArray();
        int[] nums = {0, 2, 0, 0, 2, 0, 2, 1, 1, 0, 2, 1, 0, 0, 1, 0, 2, 1, 2, 0, 1, 1, 0, 2, 2, 1, 2, 2, 0, 0, 0, 1, 0, 2, 0, 0, 1, 2, 0, 1, 0, 2, 0, 2, 0, 0, 0, 0, 2, 1, 0, 0, 0, 0, 1, 0, 2, 1, 2, 2, 1, 0, 0, 1, 0, 2, 0, 0, 0, 2, 1, 0, 1, 2, 1, 0, 1, 0, 2, 1, 0, 2, 0, 2, 1, 1, 2, 0, 1, 0, 1, 1, 1, 1, 2, 1, 2, 2, 2, 0};
        System.out.println("result = " + obj.longestMountain(nums));
    }

    @Test
    public void testP1207()
    {
        P0017_LetterCombinationsOfAPhoneNumber obj = new P0017_LetterCombinationsOfAPhoneNumber();
        System.out.println("result = " + obj.letterCombinations("232"));
    }

    @Test
    public void testP0381()
    {
        P0381_InsertDeleteAndGetRandom obj = new P0381_InsertDeleteAndGetRandom();
        P0381_InsertDeleteAndGetRandom.RandomizedCollection randomizedCollection = obj.new RandomizedCollection();
        System.out.println("result = " + randomizedCollection.insert(21));
    }

    @Test
    public void testP0139()
    {
        P0139_WordBreak obj = new P0139_WordBreak();
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        wordDict.add("leet");
        wordDict.add("code");
        wordDict.add("apple");
        wordDict.add("pen");
        System.out.println("result = " + obj.wordBreak(s, wordDict));
    }

    @Test
    public void testP0035()
    {
        P0035_SearchInsertPosition obj = new P0035_SearchInsertPosition();
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        System.out.println("result = " + obj.searchInsert_1(nums, target));
    }


    @Test
    public void testP0349()
    {
        P0349_IntersectionOfTwoArrays obj = new P0349_IntersectionOfTwoArrays();
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        int[] result = obj.intersection(nums1, nums2);
        for (int i : result)
        {
            System.out.println("i = " + i);
        }
    }

    @Test
    public void testP0053()
    {
        P0053_MaximumSubarray obj = new P0053_MaximumSubarray();
        int[] nums = {-24};
        System.out.println("result = " + obj.maxSubArray_1(nums));
    }

    @Test
    public void testP0941()
    {
        P0941_ValidMountainArray obj = new P0941_ValidMountainArray();
        int[] nums = {
                9, 8, 7, 6, 5, 4};
        System.out.println("result = " + obj.validMountainArray(nums));
    }

    @Test
    public void testP0057()
    {
        P0057_InsertInterval obj = new P0057_InsertInterval();
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] ansList = obj.insert(intervals, newInterval);
        for (int[] ints : ansList)
        {
            System.out.println("ansList[i] = " + Arrays.toString(ints));
        }
    }

    @Test
    public void testP0056()
    {
        P0056_MergeIntervals obj = new P0056_MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = obj.merge(intervals);
        for (int[] ints : merge)
        {
            System.out.println("ints = " + Arrays.toString(ints));
        }
    }

    @Test
    public void testP1356()
    {
        P1356_SortIntegersByTheNumberOf1Bits obj = new P1356_SortIntegersByTheNumberOf1Bits();

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("obj.get(i) : " + Arrays.toString(obj.sortByBits_1(arr)));
    }

    @Test
    public void testP0121()
    {
        P0121_BestTimeToBuyAndSellStock obj = new P0121_BestTimeToBuyAndSellStock();

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] nums = {7,1,5,3,6,4};
        System.out.println("result = " + obj.maxProfit_1(nums));
    }

    @Test
    public void testP0122()
    {
        P0122_BestTimeToBuyAndSellStockII obj = new P0122_BestTimeToBuyAndSellStockII();

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] nums = {7,1,5,3,6,4};
        System.out.println("result = " + obj.maxProfit_1(nums));
    }
}
