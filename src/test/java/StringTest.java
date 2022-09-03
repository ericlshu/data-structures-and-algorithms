import org.junit.Test;
import solution.array.P0242ValidAnagramArray;
import solution.array.P1796SecondLargestDigitInAString;
import solution.hash_table.P0242ValidAnagramHash;
import solution.math.P0389FindTheDifference;
import solution.string.P0003LongestSubstringWithoutRepeatingCharacters;
import solution.string.P0012IntegerToRoman;
import solution.string.P0013RomanToInteger;
import solution.string.P0014LongestCommonPrefix;
import solution.string.P0017LetterCombinationsOfAPhoneNumber;
import solution.string.P0028ImplementStrStr;
import solution.string.P0844BackspaceStringCompare;
import solution.string.P0973KClosestPointsToOrigin;

import java.util.Arrays;
import java.util.List;

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
        P0003LongestSubstringWithoutRepeatingCharacters obj = new P0003LongestSubstringWithoutRepeatingCharacters();
        int length = obj.lengthOfLongestSubstring("solution.string.P0003_LongestSubstringWithoutRepeatingCharacters");
        System.out.println("length = " + length);
    }

    @Test
    public void testP0012()
    {
        P0012IntegerToRoman obj = new P0012IntegerToRoman();
        System.out.println("result = " + obj.intToRoman(3994));
    }

    @Test
    public void testP0013()
    {
        P0013RomanToInteger obj = new P0013RomanToInteger();
        System.out.println("result = " + obj.romanToInt("CMXCIX"));
    }

    @Test
    public void testP0014()
    {
        P0014LongestCommonPrefix obj = new P0014LongestCommonPrefix();
        System.out.println("result = " + obj.longestCommonPrefix(new String[]{"ab", "a"}));
    }

    @Test
    public void testP0028()
    {
        P0028ImplementStrStr obj = new P0028ImplementStrStr();
        System.out.println("result = " + obj.strStr("mississippi", "issippip"));
    }

    @Test
    public void testP0844()
    {
        P0844BackspaceStringCompare obj = new P0844BackspaceStringCompare();
        System.out.println("result = " + obj.backspaceString("oi###mu#ueo##pk#o##rsztu#y#s#xu###bxx##dqc#gz#djz"));
    }

    @Test
    public void testP973()
    {
        P0973KClosestPointsToOrigin obj = new P0973KClosestPointsToOrigin();
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        points = obj.kClosest(points, 2);
        for (int[] point : points)
        {
            System.out.println("point = " + Arrays.toString(point));
        }
    }

    @Test
    public void testP0017()
    {
        P0017LetterCombinationsOfAPhoneNumber obj = new P0017LetterCombinationsOfAPhoneNumber();
        List<String> list = obj.letterCombinations("23");
        System.out.println(list);
    }

    @Test
    public void test0242()
    {
        P0242ValidAnagramArray array = new P0242ValidAnagramArray();
        P0242ValidAnagramHash hash = new P0242ValidAnagramHash();
        System.out.println("array result = " + array.isAnagram("anagram", "nagaram"));
        System.out.println("hash result  = " + hash.isAnagram("anagram", "nagaram"));
    }

    @Test
    public void test0389()
    {
        P0389FindTheDifference math = new P0389FindTheDifference();
        String s = "abcd";
        String t = "abcde";
        System.out.println("hash result  = " + math.findTheDifference(s, t));

    }

    @Test
    public void test1796()
    {
        P1796SecondLargestDigitInAString obj = new P1796SecondLargestDigitInAString();
        // String s = "abc1111";
        String s = "dfa12321afd";
        System.out.println("result  = " + obj.secondHighest(s));
    }

}
