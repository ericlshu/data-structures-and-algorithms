import domain.ListNode;
import org.junit.Test;
import solution.array.*;
import solution.binary_search.P1122RelativeSortArray;
import solution.dynamic_programming.Offer042LCOF;
import solution.math.P1688CountOfMatchesInTournament;

import java.util.Arrays;
import java.util.List;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2021-03-27 13:33
 * @since JDK 1.8
 */
public class ArrayTest
{
    @Test
    public void testP0001()
    {
        P0001TwoSum obj = new P0001TwoSum();
        int[] numbers = {2, 5, 7, 9, 12};
        int sum = 17;
        int[] result = obj.twoNumbersAddUp02(numbers, sum);
        for (int i : result)
        {
            System.out.println("    i = " + i);
        }
    }

    @Test
    public void testP0019()
    {
        P0019RemoveNthNodeFromEndOfList obj = new P0019RemoveNthNodeFromEndOfList();
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
        P0035SearchInsertPosition obj = new P0035SearchInsertPosition();
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        System.out.println("result = " + obj.searchInsert_1(nums, target));
    }

    @Test
    public void testP0056()
    {
        P0056MergeIntervals obj = new P0056MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = obj.merge(intervals);
        for (int[] nums : merge)
        {
            System.out.println("nums = " + Arrays.toString(nums));
        }
    }

    @Test
    public void testP0057()
    {
        P0057InsertInterval obj = new P0057InsertInterval();
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] ansList = obj.insert(intervals, newInterval);
        for (int[] nums : ansList)
        {
            System.out.println("ansList[i] = " + Arrays.toString(nums));
        }
    }

    @Test
    public void testP0122()
    {
        P0122BestTimeToBuyAndSellStockII obj = new P0122BestTimeToBuyAndSellStockII();

        // int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println("result = " + obj.maxProfit_1(nums));
    }

    @Test
    public void testP0941()
    {
        P0941ValidMountainArray obj = new P0941ValidMountainArray();
        int[] nums = {9, 8, 7, 6, 5, 4};
        System.out.println("result = " + obj.validMountainArray(nums));
    }

    @Test
    public void testP1356()
    {
        P1356SortIntegersByTheNumberOf1Bits obj = new P1356SortIntegersByTheNumberOf1Bits();
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("obj.get(i) : " + Arrays.toString(obj.sortByBits_1(arr)));
    }

    @Test
    public void test1122()
    {
        P1122RelativeSortArray obj = new P1122RelativeSortArray();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, arr2 = {2, 1, 4, 3, 9, 6};
        System.out.println("result = " + Arrays.toString(obj.relativeSortArray(arr1, arr2)));
    }

    @Test
    public void test016()
    {
        P0016ThreeSumClosest obj = new P0016ThreeSumClosest();
        obj.threeSumClosest(new int[]{}, 0);
    }


    @Test
    public void test0018()
    {
        P0018FourSum obj = new P0018FourSum();
        obj.fourSum(new int[]{}, 0);
    }

    @Test
    public void test0033()
    {
        P0033SearchInRotatedSortedArray obj = new P0033SearchInRotatedSortedArray();
//        int[] nums = {4,5,6,7,0,1,2};
        int[] nums = {1};
        int result = obj.search(nums, 1);
        System.out.println("result = " + result);
    }

    @Test
    public void test0034()
    {
        P0034FindFirstAndLastPositionOfElementInSortedArray obj = new P0034FindFirstAndLastPositionOfElementInSortedArray();
        int[] nums = {5, 7, 7, 8, 8, 8, 10};
//        int[] nums = {1};
        int[] result = obj.searchRange(nums, 8);
        System.out.println("result = " + Arrays.toString(result));
    }

    @Test
    public void test0039()
    {
        P0039CombinationSum obj = new P0039CombinationSum();
        int[] nums = {2, 3, 5};
        System.out.println("candidates = " + Arrays.toString(nums));
        List<List<Integer>> result = obj.combinationSum(nums, 8);
        System.out.println("result = " + result);
    }

    @Test
    public void testOffer45()
    {
        Offer045ArrayToMinNumber obj = new Offer045ArrayToMinNumber();
        int[] nums = {3, 30, 34, 5, 9};
        String result = obj.minNumber(nums);
        System.out.println("result = " + result);
    }

    @Test
    public void test0080()
    {
        P0080RemoveDuplicatesFromSortedArrayTwo obj = new P0080RemoveDuplicatesFromSortedArrayTwo();
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        // int[] nums = {1,1,1};
        int result = obj.removeDuplicatesOfficial(nums);
        System.out.println("result = " + result);
        for (int i = 0; i < result; i++)
        {
            System.out.println("nums = " + nums[i]);
        }
    }

    @Test
    public void testOffer03()
    {
        Offer003FindRepeatNumberInArray obj = new Offer003FindRepeatNumberInArray();
        int repeatNumber = obj.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3});
        System.out.println("repeatNumber = " + repeatNumber);
    }

    @Test
    public void test0724()
    {
        P0724FindPivotIndex obj = new P0724FindPivotIndex();
        // int[] nums = {1, 7, 3, 6, 5, 6};
        int[] nums = {1, 1, 1};
        int result = obj.pivotIndex(nums);
        System.out.println("result = " + result);
    }

    @Test
    public void test2022()
    {
        P2022Convert1DArrayInto2DArray obj = new P2022Convert1DArrayInto2DArray();
        System.out.println("result = " + Arrays.deepToString(obj.construct2DArray(new int[]{1, 2, 3, 4}, 1, 2)));
    }

    @Test
    public void test0628()
    {
        P0628MaximumProductOfThreeNumbers obj = new P0628MaximumProductOfThreeNumbers();
        System.out.println("result = " + obj.maximumProductNormalLinearScan(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void testOfferII006()
    {
        OfferII006TwoSumInSortedArray obj = new OfferII006TwoSumInSortedArray();
        int[] index = obj.twoSumByBisection(new int[]{1, 2, 3, 4, 5}, 8);
        System.out.println("result = " + Arrays.toString(index));

    }

    @Test
    public void testP0088()
    {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;

        // int[] nums1 = {0};
        // int[] nums2 = {1};
        // int m = 0, n = 1;

        P0088MergeSortedArray obj = new P0088MergeSortedArray();
        obj.merge3(nums1, m, nums2, n);
        System.out.println("nums = " + Arrays.toString(nums1));
    }

    @Test
    public void test1001()
    {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;

        MianShi1001SortedMergeLCCI lcci = new MianShi1001SortedMergeLCCI();
        lcci.merge(nums1, m, nums2, n);
        System.out.println("lcci = " + Arrays.toString(nums1));
    }

    @Test
    public void test0643()
    {
        P0643MaximumAverageSubarrayOne obj = new P0643MaximumAverageSubarrayOne();
        int[] nums = {-6662, 5432, -8558, -8935, 8731, -3083, 4115, 9931, -4006, -3284, -3024, 1714, -2825, -2374,
                -2750, -959, 6516, 9356, 8040, -2169, -9490, -3068, 6299, 7823, -9767, 5751, -7897, 6680, -1293, -3486,
                -6785, 6337, -9158, -4183, 6240, -2846, -2588, -5458, -9576, -1501, -908, -5477, 7596, -8863, -4088,
                7922, 8231, -4928, 7636, -3994, -243, -1327, 8425, -3468, -4218, -364, 4257, 5690, 1035, 6217, 8880,
                4127, -6299, -1831, 2854, -4498, -6983, -677, 2216, -1938, 3348, 4099, 3591, 9076, 942, 4571, -4200,
                7271, -6920, -1886, 662, 7844, 3658, -6562, -2106, -296, -3280, 8909, -8352, -9413, 3513, 1352, -8825};
        System.out.println("maxAverage = " + obj.findMaxAverage3(nums, 1));
    }

    @Test
    public void testOffer042()
    {
        Offer042LCOF lcof = new Offer042LCOF();
        int maxSubArray = lcof.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println("maxSubArray = " + maxSubArray);
    }

    @Test
    public void test0066()
    {
        P0066PlusOne plusOne = new P0066PlusOne();
        int[] result = plusOne.plusOne(new int[]{9, 9, 9, 9});
        System.out.println("result = " + Arrays.toString(result));
    }

    @Test
    public void test1688()
    {
        P1688CountOfMatchesInTournament obj = new P1688CountOfMatchesInTournament();
        int matches = obj.numberOfMatches(1000);
        System.out.println("matches = " + matches);
    }

    @Test
    public void test0469()
    {
        P0496NextGreaterElementI obj = new P0496NextGreaterElementI();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result = obj.nextGreaterElement(nums1, nums2);
        System.out.println("result = " + Arrays.toString(result));
    }

    @Test
    public void test1475()
    {
        P1475FinalPricesWithASpecialDiscountInAShop obj = new P1475FinalPricesWithASpecialDiscountInAShop();
        int[] prices = {8, 4, 6, 2, 3};
        int[] result = obj.finalPrices(prices);
        System.out.println("result = " + Arrays.toString(result));
    }

    @Test
    public void test0169()
    {
        P0169MajorityElement obj = new P0169MajorityElement();
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("sort result = " + obj.majorityElement_sort(nums));
        System.out.println("hash result = " + obj.majorityElement_hash(nums));
        System.out.println("math result = " + obj.majorityElement_math(nums));
    }

    @Test
    public void test0268()
    {
        P0268MissingNumber obj = new P0268MissingNumber();

        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println("array result = " + obj.missingNumber_sort(nums));
        System.out.println("hash  result = " + obj.missingNumber_hash(nums));
        System.out.println("math  result = " + obj.missingNumber_math_sum(nums));
        System.out.println("math  result = " + obj.missingNumber_math_bit(nums));
    }

    @Test
    public void test0414()
    {
        P0414ThirdMaximumNumber array = new P0414ThirdMaximumNumber();
        int[] nums = {2, 2, 4, 6, 9, 9, 9, 8, 8, 3, 1};
        // int[] nums = {2, 2,3, 1};
        // int[] nums = {1, 1, 2};
        System.out.println("array result = " + array.thirdMax(nums));
    }

    @Test
    public void test0283()
    {
        int[] nums = {0, 1, 0, 3, 12};
        // int[] nums = {2, 2,3, 1};
        // int[] nums = {1, 1, 2};
        new P0283MoveZeroes().moveZeroes(nums);
        System.out.println("nums = " + Arrays.toString(nums));
    }

    @Test
    public void test1582()
    {
        int[][] mat1 = {
                {1, 0, 0},
                {0, 0, 1},
                {1, 0, 0}
        };

        int[][] mat2 = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        int[][] mat3 = {
                {0, 0, 0, 1},
                {1, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

        int[][] mat4 = {
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };

        P1582SpecialPositionsInABinaryMatrix binaryMatrix = new P1582SpecialPositionsInABinaryMatrix();

        System.out.println("mat1 = " + binaryMatrix.numSpecial(mat1));
        System.out.println("mat2 = " + binaryMatrix.numSpecial(mat2));
        System.out.println("mat3 = " + binaryMatrix.numSpecial(mat3));
        System.out.println("mat4 = " + binaryMatrix.numSpecial(mat4));
    }

    @Test
    public void test0448()
    {
        P0448FindAllNumbersDisappearedInAnArray obj = new P0448FindAllNumbersDisappearedInAnArray();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = obj.findDisappearedNumbers(nums);
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("list = " + list);
    }

    @Test
    public void test0485()
    {
        P0485MaxConsecutiveOnes obj = new P0485MaxConsecutiveOnes();
        int[] nums = {1, 1, 0, 1, 1, 1};
        // int[] nums = {1,1,1,1,0,1};
        System.out.println("result = " + obj.findMaxConsecutiveOnes(nums));
    }

    @Test
    public void test0500()
    {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        P0500KeyboardRow obj = new P0500KeyboardRow();
        String[] result = obj.findWords(words);
        System.out.println("result = " + Arrays.toString(result));
    }

    @Test
    public void test0506()
    {
        P0506RelativeRanks obj = new P0506RelativeRanks();
        int[] score = {10, 3, 8, 9, 4};
        String[] relativeRanks = obj.findRelativeRanks(score);
        System.out.println("result = " + Arrays.toString(relativeRanks));
    }

    @Test
    public void test0561()
    {
        P0561ArrayPartition obj = new P0561ArrayPartition();
        int[] nums = {6, 2, 6, 5, 1, 2};
        System.out.println("result = " + obj.arrayPairSum(nums));
    }

    @Test
    public void test0575()
    {
        P0575DistributeCandies obj = new P0575DistributeCandies();
        int[] nums = {1, 1, 2, 2, 3, 3};
        System.out.println("result = " + obj.distributeCandies(nums));
    }

    @Test
    public void test0250()
    {
        P0350IntersectionOfTwoArraysII obj = new P0350IntersectionOfTwoArraysII();
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println("result = " + Arrays.toString(obj.intersect(nums1, nums2)));
    }

    @Test
    public void test0566()
    {
        P0566ReshapeTheMatrix obj = new P0566ReshapeTheMatrix();
        int[][] mat = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        System.out.println(Arrays.deepToString(obj.matrixReshape(mat, 2, 4)));
    }

    @Test
    public void test0118()
    {
        P0118PascalsTriangle obj = new P0118PascalsTriangle();
        List<List<Integer>> lists = obj.generate(10);
        lists.forEach(System.out::println);
    }

    @Test
    public void test0119()
    {
        P0119PascalsTriangleII obj = new P0119PascalsTriangleII();
        System.out.println(obj.getRow(5));
        System.out.println(obj.getRow_1(6));
        System.out.println(obj.getRow_2(7));
        System.out.println(obj.getRow_3(8));
    }

    @Test
    public void test0645()
    {
        P0645SetMismatch obj = new P0645SetMismatch();
        System.out.println(Arrays.toString(obj.findErrorNums_math(new int[]{1, 2, 2, 4})));
        System.out.println(Arrays.toString(obj.findErrorNums_hash(new int[]{1, 2, 3, 4, 6, 5, 3})));
        System.out.println(Arrays.toString(obj.findErrorNums_sort(new int[]{1, 2, 3, 4, 6, 5, 3})));
    }

    @Test
    public void test0036()
    {
        char[][] board1 = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        char[][] board2 = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        P0036ValidSudoku obj = new P0036ValidSudoku();
        System.out.println("result 1 = " + obj.isValidSudoku(board1));
        System.out.println("result 2 = " + obj.isValidSudoku(board2));
    }

    @Test
    public void test0073()
    {
        P0073SetMatrixZeroes obj = new P0073SetMatrixZeroes();
        int[][] matrix1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] matrix2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        obj.setZeroes_2(matrix1);
        obj.setZeroes_3(matrix2);
        System.out.println("matrix1 = " + Arrays.deepToString(matrix1));
        System.out.println("matrix2 = " + Arrays.deepToString(matrix2));
    }

    @Test
    public void test1598()
    {
        P1598CrawlerLogFolder obj = new P1598CrawlerLogFolder();
        String[] logs1 = {"d1/", "d2/", "../", "d21/", "./"};
        String[] logs2 = {"d1/", "d2/", "./", "d3/", "../", "d31/"};
        System.out.println("logs1 = " + obj.minOperations(logs1));
        System.out.println("logs2 = " + obj.minOperations(logs2));
    }

    @Test
    public void test0977()
    {
        P0977SquaresOfASortedArray obj = new P0977SquaresOfASortedArray();
        int[] nums = {-7,-3,2,3,11};
        System.out.println("result = " + Arrays.toString(obj.sortedSquares(nums)));
    }
}
