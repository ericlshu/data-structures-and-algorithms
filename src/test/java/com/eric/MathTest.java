package com.eric;

import com.eric.solution.math.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(-123, result);
    }

    @Test
    public void testP0009()
    {
        P0009PalindromeNumber obj = new P0009PalindromeNumber();
        assertTrue(obj.isPalindrome(10201));
    }

    @Test
    public void testOfferII072()
    {
        OfferII072 obj = new OfferII072();
       assertEquals(46340, (int) Math.floor(Math.sqrt(2147395600)));
       assertEquals(0, obj.mySqrtBisection(0));
       assertEquals(46340, obj.mySqrtNewton(2147395600));
    }

    @Test
    public void testOffer101()
    {
        Offer101FibonacciSequence obj = new Offer101FibonacciSequence();
        assertEquals(832040, obj.fib3(30));
        assertEquals(832040,obj.fib4(30));
    }

    @Test
    public void testP0509()
    {
        P0509FibonacciNumber obj = new P0509FibonacciNumber();
        assertEquals(24157817, obj.fib(37));
        assertEquals(24157817, obj.fibonacci(37));
    }

    @Test
    public void test1137()
    {
        P1137NthTribonacciNumber obj = new P1137NthTribonacciNumber();
        assertEquals(2082876103, obj.tribonacci_1(37));
        assertEquals(2082876103, obj.tribonacci_2(37));
        assertEquals(2082876103, obj.tribonacci_3(37));
    }

    @Test
    public void test0670()
    {
        P0670MaximumSwap obj = new P0670MaximumSwap();
        assertEquals(7236, obj.maximumSwap_1(2736));
        assertEquals(9973, obj.maximumSwap_2(9973));
    }

    @Test
    public void test0069()
    {
        P0069SqrtOfX p0069 = new P0069SqrtOfX();
        assertEquals(2, p0069.mySqrt1(8));
        assertEquals(9, p0069.mySqrt2(99));
        assertEquals(46339, p0069.mySqrt2(2147395599));
        assertEquals(46339, p0069.mySqrtMath(2147395599));
        assertEquals(46339, p0069.mySqrtNewton(2147395599));
    }

    @Test
    public void test0190()
    {
        P0190ReverseBits p0190 = new P0190ReverseBits();
        int n1 = 0b00000010100101000001111010011100;
        int n2 = 0b11111111111111111111111111111101;
        assertEquals(964176192, p0190.reverseBits_1(n1));
        assertEquals(-1073741825, p0190.reverseBits_2(n2));
        assertEquals(-1073741825, p0190.reverseBits_3(n2));
    }

    @Test
    public void test0077()
    {
        P0077Combinations p0077 = new P0077Combinations();
        assertEquals("[" +
                        "[1, 2, 3], [1, 2, 4], [1, 2, 5], [1, 3, 4], [1, 3, 5], [1, 4, 5], [2, 3, 4], [2, 3, 5], [2, 4, 5], [3, 4, 5], " +
                        "[3, 4, 5], [2, 4, 5], [2, 3, 5], [2, 3, 4], [1, 4, 5], [1, 3, 5], [1, 3, 4], [1, 2, 5], [1, 2, 4], [1, 2, 3]]"
                , p0077.combine_dfs(5, 3).toString());
        assertEquals("[[1, 2, 3], [1, 2, 4], [1, 3, 4], [2, 3, 4], [1, 2, 5], [1, 3, 5], [2, 3, 5], [1, 4, 5], [2, 4, 5], [3, 4, 5]]"
                , p0077.combine_dict(5, 3).toString());
        assertEquals("[[2, 1], [3, 1], [4, 1], [3, 2], [4, 2], [4, 3]]"
                , p0077.combineBackTrace(4, 2).toString());
        assertEquals("[[3, 2, 1], [4, 2, 1], [4, 3, 1], [4, 3, 2]]"
                , p0077.combineBackTrace(4, 3).toString());
    }

    @Test
    public void test0216()
    {
        P0077Combinations p0077 = new P0077Combinations();
        assertEquals("[[1, 2, 3], [1, 2, 4], [1, 2, 5], [1, 3, 4], [1, 3, 5], [1, 4, 5], [2, 3, 4], [2, 3, 5], [2, 4, 5], [3, 4, 5], [3, 4, 5], [2, 4, 5], [2, 3, 5], [2, 3, 4], [1, 4, 5], [1, 3, 5], [1, 3, 4], [1, 2, 5], [1, 2, 4], [1, 2, 3]]",
                p0077.combine_dfs(5, 3).toString());
        assertEquals("[[1, 2, 3], [1, 2, 4], [1, 3, 4], [2, 3, 4], [1, 2, 5], [1, 3, 5], [2, 3, 5], [1, 4, 5], [2, 4, 5], [3, 4, 5]]",
                p0077.combine_dict(5, 3).toString());
        assertEquals("[[2, 1], [3, 1], [4, 1], [3, 2], [4, 2], [4, 3]]",
                p0077.combineBackTrace(4, 2).toString());
        assertEquals("[[3, 2, 1], [4, 2, 1], [4, 3, 1], [4, 3, 2]]",
                p0077.combineBackTrace(4, 3).toString());
    }

    @Test
    public void test0784()
    {
        P0784LetterCasePermutation p0784 = new P0784LetterCasePermutation();
        assertEquals("[a1b2, a1B2, A1B2, A1b2, A1b2, a1b2, a1B2, A1B2]",
                p0784.letterCasePermutation("a1b2").toString());
    }

    @Test
    public void test0202()
    {
        P0202HappyNumber p0202 = new P0202HappyNumber();
        assertTrue(p0202.isHappy_1(19));
        assertTrue(p0202.isHappy_2(19));
        assertTrue(p0202.isHappy_3(19));
        assertFalse(p0202.isHappy_1(2));
        assertFalse(p0202.isHappy_2(2));
        assertFalse(p0202.isHappy_3(2));
    }

    @Test
    public void test0989()
    {
        P0989AddToArrayFormOfInteger p0989 = new P0989AddToArrayFormOfInteger();
        assertEquals("[1, 2, 3, 4]", p0989.addToArrayForm(new int[]{1, 2, 0, 0}, 34).toString());
        assertEquals("[4, 5, 5]", p0989.addToArrayForm(new int[]{2, 7, 4}, 181).toString());
        assertEquals("[1, 0, 2, 1]", p0989.addToArrayForm(new int[]{2, 1, 5}, 806).toString());
        assertEquals("[8, 2, 1]", p0989.addToArrayForm(new int[]{1, 5}, 806).toString());
        assertEquals("[1, 0, 0, 0]", p0989.addToArrayForm(new int[]{9, 8, 9}, 11).toString());
    }

    @Test
    public void test0150()
    {
        P0150EvaluateReversePolishNotation p0150 = new P0150EvaluateReversePolishNotation();
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        assertEquals(9, p0150.evalRPN_stack(tokens1));
        assertEquals(6, p0150.evalRPN_array(tokens2));
        assertEquals(22, p0150.evalRPN_array(tokens3));
    }

    @Test
    public void test0191()
    {
        P0191NumberOf1Bits p0191 = new P0191NumberOf1Bits();
        assertEquals(2, p0191.hammingWeight_1(3));
        assertEquals(1, p0191.hammingWeight_1(1));
        assertEquals(5, p0191.hammingWeight_2(31));
    }

    @Test
    public void test0231()
    {
        P0231PowerOfTwo p0231 = new P0231PowerOfTwo();
        assertTrue(p0231.isPowerOfTwo_1(1));
        assertTrue(p0231.isPowerOfTwo_2(2));
        assertFalse(p0231.isPowerOfTwo_3(3));
    }

    @Test
    public void test1688()
    {
        P1688CountOfMatchesInTournament obj = new P1688CountOfMatchesInTournament();
        int matches = obj.numberOfMatches(1000);
        assertEquals(999,matches);
    }

    @Test
    public void test0367()
    {
        P0367ValidPerfectSquare p0367 = new P0367ValidPerfectSquare();
        assertTrue(p0367.isPerfectSquare_1(1024));
        assertTrue(p0367.isPerfectSquare_2(256));
        assertTrue(p0367.isPerfectSquare_3(64));
        assertTrue(p0367.isPerfectSquare_4(100));
        assertFalse(p0367.isPerfectSquare_1(10));
        assertFalse(p0367.isPerfectSquare_2(20));
        assertFalse(p0367.isPerfectSquare_3(30));
        assertFalse(p0367.isPerfectSquare_4(40));
    }

    @Test
    public void test1232()
    {
        P1232CheckIfItIsAStraightLine p1232 = new P1232CheckIfItIsAStraightLine();
        int[][] coordinates1 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        int[][] coordinates2 = {{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}};
        assertTrue(p1232.checkStraightLine(coordinates1));
        assertFalse(p1232.checkStraightLine(coordinates2));
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
        assertEquals(11, p0120.minimumTotal_n2(triangle));
        assertEquals(11, p0120.minimumTotal_2n(triangle));
        assertEquals(11, p0120.minimumTotal_n(triangle));
        assertEquals(11, p0120.minimumTotal_recursion_1(triangle));
        assertEquals(11, p0120.minimumTotal_recursion_2(triangle));
        assertEquals(11, p0120.minimumTotal_dpn2(triangle));
        assertEquals(11, p0120.minimumTotal_dpn(triangle));
        assertEquals(11, p0120.minimumTotal_iteration(triangle));
    }

    @Test
    public void test0070()
    {
        P0070ClimbingStairs p0070 = new P0070ClimbingStairs();
        // assertEquals(1836311903, p0070.climbStairs_1(45));
        assertEquals(1836311903, p0070.climbStairs_2(45));
        assertEquals(1836311903, p0070.climbStairs_3(45));
        assertEquals(1836311903, p0070.climbStairs_4(45));
        assertEquals(1836311903, p0070.climbStairs_5(45));
        assertEquals(1836311903, p0070.climbStairs_6(45));
        assertEquals(1836311903, p0070.climbStairs_7(45));
    }

    @Test
    public void test0062()
    {
        P0062UniquePaths p0062 = new P0062UniquePaths();
        assertEquals(3, p0062.uniquePaths_dp1(3, 2));
        assertEquals(28, p0062.uniquePaths_dp1(3, 7));
        assertEquals(3, p0062.uniquePaths_dp2(3, 2));
        assertEquals(28, p0062.uniquePaths_dp2(3, 7));
        assertEquals(28, p0062.uniquePaths_math(7, 3));
        assertEquals(6, p0062.uniquePaths_math(3, 3));
    }

    @Test
    public void test1806()
    {
        P1806MinimumNumberOfOperationsToReinitializeAPermutation p1806 = new P1806MinimumNumberOfOperationsToReinitializeAPermutation();
        assertEquals(1,p1806.reinitializePermutation_1(2));
        assertEquals(2,p1806.reinitializePermutation_1(4));
        assertEquals(4,p1806.reinitializePermutation_2(6));
        assertEquals(30,p1806.reinitializePermutation_2(100));
    }

    @Test
    public void test0089()
    {
        P0089GrayCode p0089 = new P0089GrayCode();
        assertEquals("[0, 1, 3, 2]", p0089.grayCode_1(2).toString());
        assertEquals("[0, 1, 3, 2, 6, 7, 5, 4]", p0089.grayCode_2(3).toString());
    }

    @Test
    public void test1238()
    {
        P1238CircularPermutationInBinaryRepresentation p1238 = new P1238CircularPermutationInBinaryRepresentation();
        assertEquals("[3, 2, 0, 1]", p1238.circularPermutation_1(2, 3).toString());
        assertEquals("[2, 3, 1, 0, 4, 5, 7, 6]", p1238.circularPermutation_2(3, 2).toString());
    }

    @Test
    public void test0502()
    {
        M0502BinaryNumberToStringLCCI m0502 = new M0502BinaryNumberToStringLCCI();
        assertEquals("0.101", m0502.printBin(0.625));
        assertEquals("ERROR", m0502.printBin(0.1));
    }

    @Test
    public void test1039()
    {
        P1039MinimumScoreTriangulationOfPolygon p1039 = new P1039MinimumScoreTriangulationOfPolygon();
        int[] values1 = {1, 2, 3};
        int[] values2 = {3, 7, 4, 5};
        int[] values3 = {1, 3, 1, 4, 1, 5};
        assertEquals(6, p1039.minScoreTriangulation(values1));
        assertEquals(144, p1039.minScoreTriangulation(values2));
        assertEquals(13, p1039.minScoreTriangulation(values3));
    }

    @Test
    public void test0050()
    {
        assertEquals("1024.0", String.valueOf(P0050Powxn.myPowRecursion(2.0, 10)));
        assertEquals("9.261000000000001", String.valueOf(P0050Powxn.myPowRecursion(2.1, 3)));
        assertEquals("0.25", String.valueOf(P0050Powxn.myPowRecursion(2.0, -2)));
        assertEquals("0.0", String.valueOf(P0050Powxn.myPowRecursion(2.0, -2147483648)));
        assertEquals("1024.0", String.valueOf(P0050Powxn.myPowIteration(2.0, 10)));
        assertEquals("9.261000000000001", String.valueOf(P0050Powxn.myPowIteration(2.1, 3)));
        assertEquals("0.25", String.valueOf(P0050Powxn.myPowIteration(2.0, -2)));
        assertEquals("0.0", String.valueOf(P0050Powxn.myPowIteration(2.0, -2147483648)));
    }
}
