import org.junit.Test;
import solution.dp.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2021-03-27 14:19
 * @since JDK 1.8
 */
public class DPTest
{
    @Test
    public void testP0053()
    {
        P0053MaximumSubarray p0053 = new P0053MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(p0053.maxSubArray_greedy(nums));
        System.out.println(p0053.maxSubArray_partition(nums));
        System.out.println(p0053.maxSubArray_dp1(nums));
        System.out.println(p0053.maxSubArray_dp2(nums));
        System.out.println(p0053.maxSubArray_dp3(nums));
    }

    @Test
    public void testP0121()
    {
        P0121BestTimeToBuyAndSellStock obj = new P0121BestTimeToBuyAndSellStock();
        // int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println("result = " + obj.maxProfit(nums));
        System.out.println("result = " + obj.maxProfit_dp1(nums));
        System.out.println("result = " + obj.maxProfit_dp2(nums));
        System.out.println("result = " + obj.maxProfit_dp3(nums));
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

    @Test
    public void test0120()
    {
        P0120Triangle p0120 = new P0120Triangle();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Collections.singletonList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(p0120.minimumTotal_n2(triangle));
        System.out.println(p0120.minimumTotal_2n(triangle));
        System.out.println(p0120.minimumTotal_n(triangle));
        System.out.println(p0120.minimumTotal_recursion_1(triangle));
        System.out.println(p0120.minimumTotal_recursion_2(triangle));
        System.out.println(p0120.minimumTotal_dpn2(triangle));
        System.out.println(p0120.minimumTotal_dpn(triangle));
        System.out.println(p0120.minimumTotal_iteration(triangle));

    }

    @Test
    public void test0070()
    {
        P0070ClimbingStairs p0070 = new P0070ClimbingStairs();
        System.out.println(p0070.climbStairs_1(45));
        System.out.println(p0070.climbStairs_2(45));
        System.out.println(p0070.climbStairs_3(45));
        System.out.println(p0070.climbStairs_4(45));
        System.out.println(p0070.climbStairs_5(45));
        System.out.println(p0070.climbStairs_6(45));
        System.out.println(p0070.climbStairs_7(45));
    }

    @Test
    public void test0198()
    {
        P0198HouseRobber p0198 = new P0198HouseRobber();
        System.out.println(p0198.rob_1(new int[]{1, 2, 3, 1}));
        System.out.println(p0198.rob_2(new int[]{2, 7, 9, 3, 1}));
    }
}
