import org.junit.Test;
import solution.dynamic_programming.P0053MaximumSubarray;
import solution.dynamic_programming.P0121BestTimeToBuyAndSellStock;
import solution.dynamic_programming.P0139WordBreak;
import solution.dynamic_programming.P1024VideoStitching;

import java.util.ArrayList;
import java.util.List;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2021-03-27 14:19
 * @since JDK 1.8
 */
public class DynamicProgrammingTest
{
    @Test
    public void testP0053()
    {
        P0053MaximumSubarray obj = new P0053MaximumSubarray();
        int[] nums = {-24};
        System.out.println("result = " + obj.maxSubArray_1(nums));
    }

    @Test
    public void testP0121()
    {
        P0121BestTimeToBuyAndSellStock obj = new P0121BestTimeToBuyAndSellStock();

        // int[] nums1 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] nums2 = {7, 1, 5, 3, 6, 4};
        System.out.println("result = " + obj.maxProfit_1(nums2));
    }

    @Test
    public void testP0139()
    {
        P0139WordBreak obj = new P0139WordBreak();
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
    public void testP1024()
    {
        P1024VideoStitching obj = new P1024VideoStitching();
        int[][] clips = {{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}};
        System.out.println("result = " + obj.videoStitching(clips, 9));
    }

}
