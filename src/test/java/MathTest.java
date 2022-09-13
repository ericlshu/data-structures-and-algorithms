import org.junit.Test;
import solution.dynamic_programming.Offer101FibonacciSequence;
import solution.greedy.P0670MaximumSwap;
import solution.math.*;

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
}
