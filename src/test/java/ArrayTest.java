import domain.ListNode;
import org.junit.Test;
import solution.array.*;
import solution.binary_search.P1122_RelativeSortArray;

import java.util.Arrays;
import java.util.List;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2021-03-27 13:33
 * @since JDK 1.8
 */
public class ArrayTest {

    @Test
    public void testP0001()
    {
        P0001_TwoSum obj = new P0001_TwoSum();
        int[] numbers = {2, 5, 7, 9, 12};
        int sum = 17;
        int[] result = obj.twoNumbersAddUp02(numbers, sum);
        for (int i : result) {
            System.out.println("    i = " + i);
        }
    }

    @Test
    public void testP0019(){
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
    public void testP0035()
    {
        P0035_SearchInsertPosition obj = new P0035_SearchInsertPosition();
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        System.out.println("result = " + obj.searchInsert_1(nums, target));
    }

    @Test
    public void testP0056()
    {
        P0056_MergeIntervals obj = new P0056_MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = obj.merge(intervals);
        for (int[] nums : merge) {
            System.out.println("nums = " + Arrays.toString(nums));
        }
    }

    @Test
    public void testP0057()
    {
        P0057_InsertInterval obj = new P0057_InsertInterval();
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] ansList = obj.insert(intervals, newInterval);
        for (int[] nums : ansList) {
            System.out.println("ansList[i] = " + Arrays.toString(nums));
        }
    }

    @Test
    public void testP0122()
    {
        P0122_BestTimeToBuyAndSellStockII obj = new P0122_BestTimeToBuyAndSellStockII();

        // int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println("result = " + obj.maxProfit_1(nums));
    }

    @Test
    public void testP0941()
    {
        P0941_ValidMountainArray obj = new P0941_ValidMountainArray();
        int[] nums = {9, 8, 7, 6, 5, 4};
        System.out.println("result = " + obj.validMountainArray(nums));
    }

    @Test
    public void testP1356()
    {
        P1356_SortIntegersByTheNumberOf1Bits obj = new P1356_SortIntegersByTheNumberOf1Bits();
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("obj.get(i) : " + Arrays.toString(obj.sortByBits_1(arr)));
    }

    @Test
    public void test1122()
    {
        P1122_RelativeSortArray obj = new P1122_RelativeSortArray();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, arr2 = {2, 1, 4, 3, 9, 6};
        System.out.println("result = " + Arrays.toString(obj.relativeSortArray(arr1, arr2)));
    }

    @Test
    public void test016()
    {
        P0016_3SumClosest obj = new P0016_3SumClosest();
        obj.threeSumClosest(new int[]{}, 0);
    }


    @Test
    public void test0018()
    {
        P0018_4Sum obj = new P0018_4Sum();
        obj.fourSum(new int[]{}, 0);
    }

    @Test
    public void test0033()
    {
        P0033_SearchInRotatedSortedArray obj = new P0033_SearchInRotatedSortedArray();
//        int[] nums = {4,5,6,7,0,1,2};
        int[] nums = {1};
        int result = obj.search(nums, 1);
        System.out.println("result = " + result);
    }

    @Test
    public void test0034()
    {
        P0034_FindFirstAndLastPositionOfElementInSortedArray obj = new P0034_FindFirstAndLastPositionOfElementInSortedArray();
        int[] nums = {5,7,7,8,8,8,10};
//        int[] nums = {1};
        int[] result = obj.searchRange(nums, 8);
        System.out.println("result = " + Arrays.toString(result));
    }

    @Test
    public void test0039()
    {
        P0039_CombinationSum obj = new P0039_CombinationSum();
        int[] nums = {2,3,5};
        System.out.println("candidates = " + Arrays.toString(nums));
        List<List<Integer>> result = obj.combinationSum(nums, 8);
        System.out.println("result = " + result);
    }

    @Test
    public void testOffer45()
    {
        Offer45ArrayToMinNumber obj = new Offer45ArrayToMinNumber();
        int[] nums = {3,30,34,5,9};
        String result = obj.minNumber(nums);
        System.out.println("result = " + result);
    }

}
