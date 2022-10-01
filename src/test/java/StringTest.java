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
        System.out.println(obj.lengthOfLongestSubstring_set("solution.string.P0003_LongestSubstringWithoutRepeatingCharacters"));
        System.out.println(obj.lengthOfLongestSubstring_map("solution.string.P0003_LongestSubstringWithoutRepeatingCharacters"));
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
        System.out.println(p0567.checkInclusion_sw1("ab", "eidbaooo"));
        System.out.println(p0567.checkInclusion_sw2("ab", "eidbaooo"));
        System.out.println(p0567.checkInclusion_sw3("ab", "eidboaoo"));
        System.out.println(p0567.checkInclusion_pointers("ab", "eidboaoo"));
    }

    @Test
    public void test0102()
    {
        M0102CheckPermutationLCCI m0102 = new M0102CheckPermutationLCCI();
        System.out.println(m0102.CheckPermutation_hash("abc", "bca"));
        System.out.println(m0102.CheckPermutation_array("abc", "bca"));
        System.out.println(m0102.CheckPermutation_sort("abc", "bca"));
    }

    @Test
    public void test0058()
    {
        P0058LengthOfLastWord p0058 = new P0058LengthOfLastWord();
        System.out.println(p0058.lengthOfLastWord("Hello World"));
        System.out.println(p0058.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(p0058.lengthOfLastWord("luffy is still joyboy"));
        System.out.println(p0058.lengthOfLastWord("a"));
        System.out.println(p0058.lengthOfLastWord(" a "));
    }

    @Test
    public void test0125()
    {
        P0125ValidPalindrome p0125 = new P0125ValidPalindrome();
        System.out.println(p0125.isPalindrome_pointers("A man, a plan, a canal: Panama"));
        System.out.println(p0125.isPalindrome_pointers("race a car"));
    }

    @Test
    public void test0171()
    {
        P0171ExcelSheetColumnNumber p0171 = new P0171ExcelSheetColumnNumber();
        System.out.println(p0171.titleToNumber("AB"));
        System.out.println(p0171.titleToNumber("FXSHRXW"));
        System.out.println(p0171.titleToNumber("A"));
        System.out.println(p0171.titleToNumber("ZZY"));
        System.out.println(Integer.MAX_VALUE);
    }

    @Test
    public void test0168()
    {
        P0168ExcelSheetColumnTitle p0168 = new P0168ExcelSheetColumnTitle();
        System.out.println(p0168.convertToTitle(Integer.MAX_VALUE));
        System.out.println(p0168.convertToTitle(701));
        System.out.println(p0168.convertToTitle(18277));
    }

    @Test
    public void test0109()
    {
        M0109StringRotationLCCI m0109 = new M0109StringRotationLCCI();
        System.out.println(m0109.isFlipedStringPointers1("waterbottle", "erbottlewat"));
        System.out.println(m0109.isFlipedStringPointers2("waterbottle", "erbottlewat"));
        System.out.println(m0109.isFlipedStringSearch("waterbottle", "erbottlewat"));
    }

    @Test
    public void test0392()
    {
        P0392IsSubsequence p0392 = new P0392IsSubsequence();
        System.out.println(p0392.isSubsequenceDp("abc", "ahbgdc"));
        System.out.println(p0392.isSubsequence2("abc", "ahbgdc"));
        System.out.println(p0392.isSubsequence1("a", "b"));
    }

    @Test
    public void test1694()
    {
        P1694ReformatPhoneNumber p1694 = new P1694ReformatPhoneNumber();
        System.out.println(p1694.reformatNumber_baoli("1-23-45 6"));
        System.out.println(p1694.reformatNumber_baoli("123 4-567"));
        System.out.println(p1694.reformatNumber_baoli("123 4-5678"));
        System.out.println(p1694.reformatNumber_baoli("12"));
        System.out.println(p1694.reformatNumber_official("--17-5 229 35-39475 "));
    }
}
