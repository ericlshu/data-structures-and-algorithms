import org.junit.Test;
import solution.string.P0003_LongestSubstringWithoutRepeatingCharacters;
import solution.string.P0012_IntegerToRoman;
import solution.string.P0013_RomanToInteger;
import solution.string.P0014_LongestCommonPrefix;
import solution.string.P0028_ImplementStrStr;
import solution.string.P0844_BackspaceStringCompare;
import solution.string.P0973_KClosestPointsToOrigin;

import java.util.Arrays;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2021-03-27 13:34
 * @since JDK 1.8
 */
public class StringTest
{
    @Test
    public void testP0003()
    {
        P0003_LongestSubstringWithoutRepeatingCharacters obj = new P0003_LongestSubstringWithoutRepeatingCharacters();
        int length = obj.lengthOfLongestSubstring("solution.string.P0003_LongestSubstringWithoutRepeatingCharacters");
        System.out.println("length = " + length);
    }

    @Test
    public void testP0012()
    {
        P0012_IntegerToRoman obj = new P0012_IntegerToRoman();
        System.out.println("result = " + obj.intToRoman(3994));
    }

    @Test
    public void testP0013()
    {
        P0013_RomanToInteger obj = new P0013_RomanToInteger();
        System.out.println("result = " + obj.romanToInt("CMXCIX"));
    }

    @Test
    public void testP0014()
    {
        P0014_LongestCommonPrefix obj = new P0014_LongestCommonPrefix();
        System.out.println("result = " + obj.longestCommonPrefix(new String[]{"ab", "a"}));
    }

    @Test
    public void testP0028()
    {
        P0028_ImplementStrStr obj = new P0028_ImplementStrStr();
        System.out.println("result = " + obj.strStr("mississippi", "issippip"));
    }

    @Test
    public void testP0844()
    {
        P0844_BackspaceStringCompare obj = new P0844_BackspaceStringCompare();
        System.out.println("result = " + obj.backspaceString("oi###mu#ueo##pk#o##rsztu#y#s#xu###bxx##dqc#gz#djz"));
    }

    @Test
    public void testP973()
    {
        P0973_KClosestPointsToOrigin obj = new P0973_KClosestPointsToOrigin();
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        points = obj.kClosest(points, 2);
        for (int[] point : points)
        {
            System.out.println("point = " + Arrays.toString(point));
        }
    }


}
