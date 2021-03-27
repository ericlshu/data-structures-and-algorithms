import org.junit.Test;
import solution.math.P0007_ReverseInteger;
import solution.math.P0009_PalindromeNumber;

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


}
