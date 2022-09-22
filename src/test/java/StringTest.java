import org.junit.Test;
import solution.array.P0242ValidAnagram;
import solution.array.P1796SecondLargestDigitInAString;
import solution.math.P0389FindTheDifference;
import solution.string.*;

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
        P0242ValidAnagram obj = new P0242ValidAnagram();
        System.out.println("sort result = " + obj.isAnagram_sort("anagram", "nagaram"));
        System.out.println("hash result = " + obj.isAnagram_hash_1("anagram", "nagaram"));
        System.out.println("hash result = " + obj.isAnagram_hash_2("anagram", "nagaram"));
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

    @Test
    public void test1592()
    {
        String text1 = "  this   is  a sentence ";
        String text2 = " practice   makes   perfect";
        String text3 = "hello   world";
        String text4 = "  walks  udp package   into  bar a";
        String text5 = "a";
        P1592RearrangeSpacesBetweenWords obj = new P1592RearrangeSpacesBetweenWords();
        System.out.println("result 1 = " + obj.reorderSpaces(text1));
        System.out.println("result 2 = " + obj.reorderSpaces(text2));
        System.out.println("result 3 = " + obj.reorderSpaces(text3));
        System.out.println("result 4 = " + obj.reorderSpaces(text4));
        System.out.println("result 5 = " + obj.reorderSpaces(text5));
    }

    @Test
    public void test0387()
    {
        P0387FirstUniqueCharacterInAString obj = new P0387FirstUniqueCharacterInAString();
        System.out.println(obj.firstUniqChar_index("leetcode"));
        System.out.println(obj.firstUniqChar_index("loveleetcode"));
        System.out.println(obj.firstUniqChar_index("aabb"));
    }

    @Test
    public void test0383()
    {
        P0383RansomNote obj = new P0383RansomNote();
        System.out.println(obj.canConstruct("a", "b"));
        System.out.println(obj.canConstruct("aa", "ab"));
        System.out.println(obj.canConstruct("aa", "aab"));
    }

    @Test
    public void test0344()
    {
        P0344ReverseString obj = new P0344ReverseString();
        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        obj.reverseString(s1);
        obj.reverseString(s2);
        System.out.println("s1 = " + Arrays.toString(s1));
        System.out.println("s1 = " + Arrays.toString(s1));
    }

    @Test
    public void test0541()
    {
        P0541ReverseStringII obj = new P0541ReverseStringII();
        System.out.println(obj.reverseStr_1("abcdefg", 2));
        System.out.println(obj.reverseStr_2("abcd", 2));
    }

    @Test
    public void test0557()
    {
        P0557ReverseWordsInAStringIII obj = new P0557ReverseWordsInAStringIII();
        String s1 = "Let's take LeetCode contest";
        String s2 = "God Ding";
        System.out.println(obj.reverseWords_1(s1));
        System.out.println(obj.reverseWords_2(s2));
    }

    @Test
    public void test0151()
    {
        P0151ReverseWordsInAString obj = new P0151ReverseWordsInAString();
        String s1 = "the sky is blue";
        String s2 = "  hello world  ";
        String s3 = "  a good   example   ";
        System.out.println(obj.reverseWords_1(s1));
        System.out.println(obj.reverseWords_2(s2));
        System.out.println(obj.reverseWords_3(s3));
    }

    @Test
    public void test0020()
    {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        P0020ValidParentheses obj = new P0020ValidParentheses();
        System.out.println(obj.isValid_1(s1));
        System.out.println(obj.isValid_2(s2));
        System.out.println(obj.isValid_3(s3));
    }

    @Test
    public void test1624()
    {
        P1624LargestSubstringBetweenTwoEqualCharacters obj = new P1624LargestSubstringBetweenTwoEqualCharacters();
        System.out.println(obj.maxLengthBetweenEqualCharacters("aa"));
        System.out.println(obj.maxLengthBetweenEqualCharacters("abca"));
        System.out.println(obj.maxLengthBetweenEqualCharacters("cbzxy"));
        System.out.println(obj.maxLengthBetweenEqualCharacters("cabbac"));
    }

    @Test
    public void test0567()
    {
        P0567PermutationInString p0567 = new P0567PermutationInString();
        System.out.println(p0567.checkInclusion("ab", "eidbaooo"));
    }
}
