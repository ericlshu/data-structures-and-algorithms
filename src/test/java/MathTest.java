import org.junit.Test;
import solution.math.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2021-03-27 14:14
 * @since JDK 1.8
 */
public class MathTest
{
    @Test
    public void testP0007()
    {
        P0007ReverseInteger obj = new P0007ReverseInteger();
        int result = obj.reverse(-321);
        System.out.println("result = " + result);
    }

    @Test
    public void testP0009()
    {
        P0009PalindromeNumber obj = new P0009PalindromeNumber();
        System.out.println("result = " + obj.isPalindrome(10201));
    }

    @Test
    public void testOfferII072()
    {
        OfferII072 obj = new OfferII072();
        System.out.println("result = " + (int) Math.floor(Math.sqrt(2147395600)));
        System.out.println("result = " + obj.mySqrtBisection(0));
        System.out.println("result = " + obj.mySqrtNewton(2147395600));
    }

    @Test
    public void testOffer101()
    {
        Offer101FibonacciSequence obj = new Offer101FibonacciSequence();
        System.out.println("result = " + obj.fib3(30));
        System.out.println("mul = " + obj.fib4(30));
    }

    @Test
    public void testP0509()
    {
        P0509FibonacciNumber obj = new P0509FibonacciNumber();
        System.out.println("result = " + obj.fib(37));
        System.out.println("result = " + obj.fibonacci(37));
    }

    @Test
    public void test1137()
    {
        P1137NthTribonacciNumber obj = new P1137NthTribonacciNumber();
        System.out.println("result1 = " + obj.tribonacci_1(37));
        System.out.println("result2 = " + obj.tribonacci_2(37));
        System.out.println("result3 = " + obj.tribonacci_3(37));
    }

    @Test
    public void test0670()
    {
        P0670MaximumSwap obj = new P0670MaximumSwap();
        System.out.println(obj.maximumSwap_1(2736));
        System.out.println(obj.maximumSwap_2(9973));
    }

    @Test
    public void test0069()
    {
        P0069SqrtOfX obj = new P0069SqrtOfX();
        for (int i = 0; i < Integer.MAX_VALUE; i++)
        {
            System.out.println(obj.mySqrt_1(i));
        }
    }

    @Test
    public void test0190()
    {
        P0190ReverseBits p0190 = new P0190ReverseBits();
        int n1 = 0b00000010100101000001111010011100;
        int n2 = 0b11111111111111111111111111111101;
        System.out.println(p0190.reverseBits_1(n1));
        System.out.println(p0190.reverseBits_2(n2));
        System.out.println(p0190.reverseBits_3(n2));
    }

    @Test
    public void test0077()
    {
        P0077Combinations p0077 = new P0077Combinations();
        System.out.println(p0077.combine_dfs(5, 3));
        System.out.println(p0077.combine_dict(5, 3));
    }

    @Test
    public void test0784()
    {
        P0784LetterCasePermutation p0784 = new P0784LetterCasePermutation();
        System.out.println(p0784.letterCasePermutation("a1b2"));
    }

    @Test
    public void test0202()
    {
        P0202HappyNumber p0202 = new P0202HappyNumber();
        System.out.println(p0202.isHappy_1(19));
        System.out.println(p0202.isHappy_2(19));
        System.out.println(p0202.isHappy_3(19));
        System.out.println(p0202.isHappy_1(2));
        System.out.println(p0202.isHappy_2(2));
        System.out.println(p0202.isHappy_3(2));
    }

    @Test
    public void test0989()
    {
        P0989AddToArrayFormOfInteger p0989 = new P0989AddToArrayFormOfInteger();
        System.out.println(p0989.addToArrayForm(new int[]{1, 2, 0, 0}, 34));
        System.out.println(p0989.addToArrayForm(new int[]{2, 7, 4}, 181));
        System.out.println(p0989.addToArrayForm(new int[]{2, 1, 5}, 806));
        System.out.println(p0989.addToArrayForm(new int[]{1, 5}, 806));
        System.out.println(p0989.addToArrayForm(new int[]{9, 8, 9}, 11));
    }

    @Test
    public void test0150()
    {
        P0150EvaluateReversePolishNotation p0150 = new P0150EvaluateReversePolishNotation();
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(p0150.evalRPN_stack(tokens1));
        System.out.println(p0150.evalRPN_array(tokens2));
        System.out.println(p0150.evalRPN_array(tokens3));
    }

    @Test
    public void test0191()
    {
        P0191NumberOf1Bits p0191 = new P0191NumberOf1Bits();
        System.out.println(p0191.hammingWeight_1(3));
        System.out.println(p0191.hammingWeight_1(1));
        System.out.println(p0191.hammingWeight_2(31));
    }

    @Test
    public void test0231()
    {
        P0231PowerOfTwo p0231 = new P0231PowerOfTwo();
        for (int i = 1; i <= 1024; i++)
        {
            if (p0231.isPowerOfTwo_2(i) && p0231.isPowerOfTwo_3(i))
            {
                System.out.println("i = " + i);
            }
        }
    }

    @Test
    public void test1688()
    {
        P1688CountOfMatchesInTournament obj = new P1688CountOfMatchesInTournament();
        int matches = obj.numberOfMatches(1000);
        System.out.println("matches = " + matches);
    }

    @Test
    public void test0367()
    {
        P0367ValidPerfectSquare p0367 = new P0367ValidPerfectSquare();
        for (int i = 1; i <= 4096; i++)
        {
            if (p0367.isPerfectSquare_3(i))
            {
                System.out.print("i = " + i);
                System.out.println("; Math.sqrt(i) = " + Math.sqrt(i));
            }
        }
    }

    @Test
    public void test1232()
    {
        P1232CheckIfItIsAStraightLine p1232 = new P1232CheckIfItIsAStraightLine();
        int[][] coordinates1 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        int[][] coordinates2 = {{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}};
        System.out.println(p1232.checkStraightLine(coordinates1));
        System.out.println(p1232.checkStraightLine(coordinates2));
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
    public void test0062()
    {
        P0062UniquePaths p0062 = new P0062UniquePaths();
        System.out.println(p0062.uniquePaths_dp(3, 2));
        System.out.println(p0062.uniquePaths_dp(3, 7));
        System.out.println(p0062.uniquePaths_math(7, 3));
        System.out.println(p0062.uniquePaths_math(3, 3));
    }

    @Test
    public void test1806()
    {
        P1806MinimumNumberOfOperationsToReinitializeAPermutation p1806 = new P1806MinimumNumberOfOperationsToReinitializeAPermutation();
        System.out.println(p1806.reinitializePermutation_1(2));
        System.out.println(p1806.reinitializePermutation_1(4));
        System.out.println(p1806.reinitializePermutation_2(6));
        System.out.println(p1806.reinitializePermutation_2(100));
    }

    @Test
    public void test0089()
    {
        P0089GrayCode p0089 = new P0089GrayCode();
        System.out.println(p0089.grayCode_1(2));
        System.out.println(p0089.grayCode_2(3));
    }

    @Test
    public void test1238()
    {
        P1238CircularPermutationInBinaryRepresentation p1238 = new P1238CircularPermutationInBinaryRepresentation();
        System.out.println(p1238.circularPermutation_1(2, 3));
        System.out.println(p1238.circularPermutation_2(3, 2));
    }

    @Test
    public void test0502()
    {
        M0502BinaryNumberToStringLCCI m0502 = new M0502BinaryNumberToStringLCCI();
        System.out.println(m0502.printBin(0.625));
        System.out.println(m0502.printBin(0.1));
    }
}
