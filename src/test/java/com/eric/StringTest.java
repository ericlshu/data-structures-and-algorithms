package com.eric;

import com.eric.solution.array.P0022GenerateParentheses;
import com.eric.solution.array.P0242ValidAnagram;
import com.eric.solution.array.P1796SecondLargestDigitInAString;
import com.eric.solution.design.P0535EncodeAndDecodeTinyURL;
import com.eric.solution.math.P0067AddBinary;
import com.eric.solution.math.P0389FindTheDifference;
import com.eric.solution.string.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(13, obj.lengthOfLongestSubstring_set("solution.string.P0003_LongestSubstringWithoutRepeatingCharacters"));
        assertEquals(13, obj.lengthOfLongestSubstring_map("solution.string.P0003_LongestSubstringWithoutRepeatingCharacters"));
    }

    @Test
    public void testP0012()
    {
        P0012IntegerToRoman obj = new P0012IntegerToRoman();
        assertEquals("MMMCMXCIV", obj.intToRoman(3994));
    }

    @Test
    public void testP0013()
    {
        P0013RomanToInteger obj = new P0013RomanToInteger();
        assertEquals(999, obj.romanToInt("CMXCIX"));
    }

    @Test
    public void testP0014()
    {
        P0014LongestCommonPrefix p0014 = new P0014LongestCommonPrefix();
        assertEquals("a", p0014.longestCommonPrefix1(new String[]{"ab", "a"}));
        assertEquals("fl", p0014.longestCommonPrefix2(new String[]{"flower", "flow", "flight"}));
        assertEquals("", p0014.longestCommonPrefix2(new String[]{"dog", "racecar", "car"}));
    }

    @Test
    public void testP0028()
    {
        P0028ImplementStrStr p0028 = new P0028ImplementStrStr();
        assertEquals(4, p0028.strStr_1("mississippi", "issippi"));
        assertEquals(4, p0028.strStr_kmp("mississippi", "issippi"));
        assertEquals(0, p0028.strStr_kmp("sadbutsad", "sad"));
        assertEquals(0, p0028.strStr_2("sadbutsad", "sad"));
        assertEquals(4, p0028.strStrKmp("mississippi", "issippi"));
    }

    @Test
    public void testP0017()
    {
        P0017LetterCombinationsOfAPhoneNumber p0016 = new P0017LetterCombinationsOfAPhoneNumber();
        assertEquals("[ad, bd, cd, ae, be, ce, af, bf, cf]", p0016.letterCombinations_1("23").toString());
        assertEquals("[ad, ae, af, bd, be, bf, cd, ce, cf]", p0016.letterCombinations_2("23").toString());
    }

    @Test
    public void test0242()
    {
        P0242ValidAnagram obj = new P0242ValidAnagram();
        assertTrue(obj.isAnagram_sort("anagram", "nagaram"));
        assertTrue(obj.isAnagram_hash_1("anagram", "nagaram"));
        assertTrue(obj.isAnagram_hash_2("anagram", "nagaram"));
    }

    @Test
    public void test0389()
    {
        P0389FindTheDifference math = new P0389FindTheDifference();
        String s = "abcd";
        String t = "abcde";
        assertEquals('e', math.findTheDifference(s, t));
    }

    @Test
    public void test1796()
    {
        P1796SecondLargestDigitInAString obj = new P1796SecondLargestDigitInAString();
        // String s = "abc1111";
        String s = "dfa12321afd";
        assertEquals(2, obj.secondHighest(s));
    }

    @Test
    public void test1592()
    {
        P1592RearrangeSpacesBetweenWords obj = new P1592RearrangeSpacesBetweenWords();
        assertEquals("this   is   a   sentence", obj.reorderSpaces("  this   is  a sentence "));
        assertEquals("practice   makes   perfect ", obj.reorderSpaces(" practice   makes   perfect"));
        assertEquals("hello   world", obj.reorderSpaces("hello   world"));
        assertEquals("walks  udp  package  into  bar  a ", obj.reorderSpaces("  walks  udp package   into  bar a"));
        assertEquals("a", obj.reorderSpaces("a"));
    }

    @Test
    public void test0387()
    {
        P0387FirstUniqueCharacterInAString obj = new P0387FirstUniqueCharacterInAString();
        assertEquals(0, obj.firstUniqChar_index("leetcode"));
        assertEquals(2, obj.firstUniqChar_index("loveleetcode"));
        assertEquals(-1, obj.firstUniqChar_index("aabb"));
    }

    @Test
    public void test0383()
    {
        P0383RansomNote obj = new P0383RansomNote();
        assertFalse(obj.canConstruct("a", "b"));
        assertFalse(obj.canConstruct("aa", "ab"));
        assertTrue(obj.canConstruct("aa", "aab"));
    }

    @Test
    public void test0344()
    {
        P0344ReverseString obj = new P0344ReverseString();
        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        obj.reverseString(s1);
        obj.reverseString(s2);
        assertEquals("[o, l, l, e, h]", Arrays.toString(s1));
        assertEquals("[o, l, l, e, h]", Arrays.toString(s1));
    }

    @Test
    public void test0541()
    {
        P0541ReverseStringII obj = new P0541ReverseStringII();
        assertEquals("bacdfeg", obj.reverseStr_1("abcdefg", 2));
        assertEquals("bacd", obj.reverseStr_2("abcd", 2));
    }

    @Test
    public void test0557()
    {
        P0557ReverseWordsInAStringIII obj = new P0557ReverseWordsInAStringIII();
        String s1 = "Let's take LeetCode contest";
        String s2 = "God Ding";
        assertEquals("s'teL ekat edoCteeL tsetnoc", obj.reverseWords_1(s1));
        assertEquals("doG gniD", obj.reverseWords_2(s2));
    }

    @Test
    public void test0151()
    {
        P0151ReverseWordsInAString obj = new P0151ReverseWordsInAString();
        String s1 = "the sky is blue";
        String s2 = "  hello world  ";
        String s3 = "  a good   example   ";
        assertEquals("blue is sky the", obj.reverseWords_1(s1));
        assertEquals("world hello", obj.reverseWords_2(s2));
        assertEquals("example good a", obj.reverseWords_3(s3));
    }

    @Test
    public void test0020()
    {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        P0020ValidParentheses obj = new P0020ValidParentheses();
        assertTrue(obj.isValid_1(s1));
        assertTrue(obj.isValid_2(s2));
        assertFalse(obj.isValid_3(s3));
    }

    @Test
    public void test1624()
    {
        P1624LargestSubstringBetweenTwoEqualCharacters obj = new P1624LargestSubstringBetweenTwoEqualCharacters();
        assertEquals(0, obj.maxLengthBetweenEqualCharacters("aa"));
        assertEquals(2, obj.maxLengthBetweenEqualCharacters("abca"));
        assertEquals(-1, obj.maxLengthBetweenEqualCharacters("cbzxy"));
        assertEquals(4, obj.maxLengthBetweenEqualCharacters("cabbac"));
    }

    @Test
    public void test0567()
    {
        P0567PermutationInString p0567 = new P0567PermutationInString();
        assertTrue(p0567.checkInclusion_sw1("ab", "eidbaooo"));
        assertTrue(p0567.checkInclusion_sw2("ab", "eidbaooo"));
        assertFalse(p0567.checkInclusion_sw3("ab", "eidboaoo"));
        assertFalse(p0567.checkInclusion_pointers("ab", "eidboaoo"));
    }

    @Test
    public void test0102()
    {
        M0102CheckPermutationLCCI m0102 = new M0102CheckPermutationLCCI();
        assertTrue(m0102.CheckPermutation_hash("abc", "bca"));
        assertTrue(m0102.CheckPermutation_array("abc", "bca"));
        assertTrue(m0102.CheckPermutation_sort("abc", "bca"));
    }

    @Test
    public void test0058()
    {
        P0058LengthOfLastWord p0058 = new P0058LengthOfLastWord();
        assertEquals(5, p0058.lengthOfLastWord("Hello World"));
        assertEquals(4, p0058.lengthOfLastWord("   fly me   to   the moon  "));
        assertEquals(6, p0058.lengthOfLastWord("luffy is still joyboy"));
        assertEquals(1, p0058.lengthOfLastWord("a"));
        assertEquals(1, p0058.lengthOfLastWord(" a "));
    }

    @Test
    public void test0125()
    {
        P0125ValidPalindrome p0125 = new P0125ValidPalindrome();
        assertTrue(p0125.isPalindrome_pointers("A man, a plan, a canal: Panama"));
        assertFalse(p0125.isPalindrome_pointers("race a car"));
    }

    @Test
    public void test0171()
    {
        P0171ExcelSheetColumnNumber p0171 = new P0171ExcelSheetColumnNumber();
        assertEquals(28, p0171.titleToNumber("AB"));
        assertEquals(2147483647, p0171.titleToNumber("FXSHRXW"));
        assertEquals(1, p0171.titleToNumber("A"));
        assertEquals(18277, p0171.titleToNumber("ZZY"));
        assertEquals(2147483647, Integer.MAX_VALUE);
    }

    @Test
    public void test0168()
    {
        P0168ExcelSheetColumnTitle p0168 = new P0168ExcelSheetColumnTitle();
        assertEquals("FXSHRXW", p0168.convertToTitle(Integer.MAX_VALUE));
        assertEquals("ZY", p0168.convertToTitle(701));
        assertEquals("ZZY", p0168.convertToTitle(18277));
    }

    @Test
    public void test0109()
    {
        M0109StringRotationLCCI m0109 = new M0109StringRotationLCCI();
        assertTrue(m0109.isFlipedStringPointers1("waterbottle", "erbottlewat"));
        assertTrue(m0109.isFlipedStringPointers2("waterbottle", "erbottlewat"));
        assertTrue(m0109.isFlipedStringSearch("waterbottle", "erbottlewat"));
    }

    @Test
    public void test0392()
    {
        P0392IsSubsequence p0392 = new P0392IsSubsequence();
        assertTrue(p0392.isSubsequenceDp("abc", "ahbgdc"));
        assertTrue(p0392.isSubsequence2("abc", "ahbgdc"));
        assertFalse(p0392.isSubsequence1("a", "b"));
    }

    @Test
    public void test1694()
    {
        P1694ReformatPhoneNumber p1694 = new P1694ReformatPhoneNumber();
        assertEquals("123-456", p1694.reformatNumber_baoli("1-23-45 6"));
        assertEquals("123-45-67", p1694.reformatNumber_baoli("123 4-567"));
        assertEquals("123-456-78", p1694.reformatNumber_baoli("123 4-5678"));
        assertEquals("12", p1694.reformatNumber_baoli("12"));
        assertEquals("175-229-353-94-75", p1694.reformatNumber_official("--17-5 229 35-39475 "));
    }

    @Test
    public void test1784()
    {
        P1784CheckIfBinaryStringHasAtMostOneSegmentOfOnes p1784 = new P1784CheckIfBinaryStringHasAtMostOneSegmentOfOnes();
        assertTrue(p1784.checkOnesSegment("1"));
        assertTrue(p1784.checkOnesSegment("11"));
        assertTrue(p1784.checkOnesSegment("110"));
        assertFalse(p1784.checkOnesSegment("11100001"));
        assertFalse(p1784.checkOnesSegment("1110000110011111"));
    }

    @Test
    public void test0345()
    {
        P0345ReverseVowelsOfAString p0345 = new P0345ReverseVowelsOfAString();
        assertEquals("holle", p0345.reverseVowels("hello"));
        assertEquals("leotcede", p0345.reverseVowels("leetcode"));
    }

    @Test
    public void test0434()
    {
        P0434NumberOfSegmentsInAString p0434 = new P0434NumberOfSegmentsInAString();
        assertEquals(5, p0434.countSegments_1("Hello, my name is John"));
        assertEquals(5, p0434.countSegments_2("Hello, my name is John"));
        assertEquals(5, p0434.countSegments_3("Hello, my name is John"));
    }

    @Test
    public void test0205()
    {
        P0205IsomorphicStrings p0205 = new P0205IsomorphicStrings();
        assertTrue(p0205.isIsomorphic("egg", "add"));
        assertFalse(p0205.isIsomorphic_hash("foo", "bar"));
        assertTrue(p0205.isIsomorphic_array("paper", "title"));
    }

    @Test
    public void test1790()
    {
        P1790CheckIfOneStringSwapCanMakeStringsEqual p1790 = new P1790CheckIfOneStringSwapCanMakeStringsEqual();
        assertTrue(p1790.areAlmostEqual_2p("bank", "kanb"));
        assertFalse(p1790.areAlmostEqual_2p("attack", "defend"));
        assertTrue(p1790.areAlmostEqual_2p("kelb", "kelb"));
        assertFalse(p1790.areAlmostEqual_2p("abcd", "dcba"));
        assertTrue(p1790.areAlmostEqual_2p("ysmpagrkzsmmzmsssutzgpxrmoylkgemgfcperptsxjcsgojwourhxlhqkxumonfgrczmjvbhwvhpnocz",
                "ysmpagrqzsmmzmsssutzgpxrmoylkgemgfcperptsxjcsgojwourhxlhkkxumonfgrczmjvbhwvhpnocz"));
        assertTrue(p1790.areAlmostEqual_list("ysmpagrkzsmmzmsssutzgpxrmoylkgemgfcperptsxjcsgojwourhxlhqkxumonfgrczmjvbhwvhpnocz",
                "ysmpagrqzsmmzmsssutzgpxrmoylkgemgfcperptsxjcsgojwourhxlhkkxumonfgrczmjvbhwvhpnocz"));
    }

    @Test
    public void test0290()
    {
        P0290WordPattern p0290 = new P0290WordPattern();
        assertTrue(p0290.wordPattern_1("abba", "dog cat cat dog"));
        assertFalse(p0290.wordPattern_1("abba", "dog cat cat fish"));
        assertFalse(p0290.wordPattern_2("aaaa", "dog cat cat dog"));
        assertFalse(p0290.wordPattern_2("abba", "dog dog dog dog"));
    }

    @Test
    public void test0415()
    {
        P0415AddStrings p0415 = new P0415AddStrings();
        assertEquals("134", p0415.addStrings("11", "123"));
        assertEquals("533", p0415.addStrings("456", "77"));
        assertEquals("0", p0415.addStrings("0", "0"));
        assertEquals("100", p0415.addStrings("99", "1"));
    }

    @Test
    public void test1768()
    {
        P1768MergeStringsAlternately p1768 = new P1768MergeStringsAlternately();
        assertEquals("apbqcr", p1768.mergeAlternately_1("abc", "pqr"));
        assertEquals("apbqrs", p1768.mergeAlternately_2("ab", "pqrs"));
        assertEquals("apbqcd", p1768.mergeAlternately_2("abcd", "pq"));
    }

    @Test
    public void test1678()
    {
        P1678GoalParserInterpretation p1678 = new P1678GoalParserInterpretation();
        assertEquals("Goal", p1678.interpret_1("G()(al)"));
        assertEquals("alGalooG", p1678.interpret_2("(al)G(al)()()G"));
    }

    @Test
    public void test0043()
    {
        P0043MultiplyStrings p0043 = new P0043MultiplyStrings();
        assertEquals("6", p0043.multiply_1("2", "3"));
        assertEquals("56088", p0043.multiply_2("123", "456"));
    }

    @Test
    public void test0049()
    {
        P0049GroupAnagrams p0049 = new P0049GroupAnagrams();
        assertEquals("[[]]", p0049.groupAnagrams_1(new String[]{""}).toString());
        assertEquals("[[eat, tea, ate], [bat], [tan, nat]]",
                p0049.groupAnagrams_2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).toString());
        assertEquals("[[a]]", p0049.groupAnagrams_3(new String[]{"a"}).toString());
    }

    @Test
    public void test0763()
    {
        P0763PartitionLabels p0763 = new P0763PartitionLabels();
        assertEquals("[9, 7, 8]", p0763.partitionLabels("ababcbacadefegdehijhklij").toString());
    }

    @Test
    public void test1309()
    {
        P1309DecryptStringFromAlphabetToIntegerMapping p1309 = new P1309DecryptStringFromAlphabetToIntegerMapping();
        assertEquals("jkab", p1309.freqAlphabets_forward("10#11#12"));
        assertEquals("acz", p1309.freqAlphabets_reverse("1326#"));
    }

    @Test
    public void test0709()
    {
        P0709ToLowerCase p0709 = new P0709ToLowerCase();
        assertEquals("lovely", p0709.toLowerCase_api("LOVELY"));
        assertEquals("hello", p0709.toLowerCase("Hello"));
    }

    @Test
    public void test0953()
    {
        P0953VerifyingAnAlienDictionary p0953 = new P0953VerifyingAnAlienDictionary();
        assertTrue(p0953.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        assertFalse(p0953.isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        assertFalse(p0953.isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    public void test0187()
    {
        P0187RepeatedDNASequences p0187 = new P0187RepeatedDNASequences();
        assertEquals("[AAAAAAAAAA]", p0187.findRepeatedDnaSequences_1("AAAAAAAAAAAAA").toString());
        assertEquals("[AAAAACCCCC, CCCCCAAAAA]",
                p0187.findRepeatedDnaSequences_2("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").toString());
    }

    @Test
    public void test0005()
    {
        P0005LongestPalindromicSubstring p0005 = new P0005LongestPalindromicSubstring();
        assertEquals("aba", p0005.longestPalindrome("babad"));
        assertEquals("bb", p0005.longestPalindrome_dp("cbbd"));
    }

    @Test
    public void test0844()
    {
        P0844BackspaceStringCompare p0844 = new P0844BackspaceStringCompare();
        assertTrue(p0844.backspaceCompare_1("ab#c", "ad#c"));
        assertTrue(p0844.backspaceCompare_2("ab##", "c#d#"));
        assertFalse(p0844.backspaceCompare_2("a#c", "b"));
    }

    @Test
    public void test0394()
    {
        P0394DecodeString p0394 = new P0394DecodeString();
        assertEquals("aaabcbc", p0394.decodeString_baoli("3[a]2[bc]"));
        assertEquals("accaccacc", p0394.decodeString_baoli("3[a2[c]]"));
        assertEquals("abcabccdcdcdef", p0394.decodeString_baoli("2[abc]3[cd]ef"));
        assertEquals("abccdcdcdxyz", p0394.decodeString_stack("abc3[cd]xyz"));
    }

    @Test
    public void test0692()
    {
        P0692TopKFrequentWords p0692 = new P0692TopKFrequentWords();
        String[] words1 = {"i", "love", "leetcode", "i", "love", "coding"};
        String[] words2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        assertEquals("[i, love]", p0692.topKFrequent_pq(words1, 2).toString());
        assertEquals("[the, is, sunny, day]", p0692.topKFrequent_list(words2, 4).toString());
    }

    @Test
    public void test0438()
    {
        P0438FindAllAnagramsInAString p0438 = new P0438FindAllAnagramsInAString();
        assertEquals("[0, 6]", p0438.findAnagrams_sw("cbaebabacd", "abc").toString());
        assertEquals("[0, 6]", p0438.findAnagrams_sw1("cbaebabacd", "abc").toString());
        assertEquals("[0, 1, 2]", p0438.findAnagrams_sw2("abab", "ab").toString());
        assertEquals("[0, 1, 2]", p0438.findAnagrams_baoli("abab", "ab").toString());
    }

    @Test
    public void test0299()
    {
        P0299BullsAndCows p0299 = new P0299BullsAndCows();
        assertEquals("1A3B", p0299.getHint("1807", "7810"));
        assertEquals("1A1B", p0299.getHint("1123", "0111"));
    }

    @Test
    public void test0451()
    {
        P0451SortCharactersByFrequency p0451 = new P0451SortCharactersByFrequency();
        assertEquals("eert", p0451.frequencySort_pq("tree"));
        assertEquals("aaaccc", p0451.frequencySort_list("cccaaa"));
        assertEquals("bbAa", p0451.frequencySort_bucket("Aabb"));
    }

    @Test
    public void test0459()
    {
        P0459RepeatedSubstringPattern p0459 = new P0459RepeatedSubstringPattern();
        assertTrue(p0459.repeatedSubstringPattern_n2("abab"));
        assertFalse(p0459.repeatedSubstringPattern_api("aba"));
        assertTrue(p0459.repeatedSubstringPattern_api("abcabcabcabc"));
    }

    @Test
    public void test0067()
    {
        P0067AddBinary p0067 = new P0067AddBinary();
        assertEquals("10101", p0067.addBinary_1("1010", "1011"));
        assertEquals("1000", p0067.addBinary_2("111", "1"));
    }

    @Test
    public void test1781()
    {
        P1781SumOfBeautyOfAllSubstrings p1781 = new P1781SumOfBeautyOfAllSubstrings();
        assertEquals(5, p1781.beautySum("aabcb"));
        assertEquals(17, p1781.beautySum("aabcbaa"));
    }

    @Test
    public void test1832()
    {
        P1832CheckIfTheSentenceIsPangram p1832 = new P1832CheckIfTheSentenceIsPangram();
        assertTrue(p1832.checkIfPangram_arr("thequickbrownfoxjumpsoverthelazydog"));
        assertTrue(p1832.checkIfPangram_set("thequickbrownfoxjumpsoverthelazydog"));
        assertTrue(p1832.checkIfPangram_bit("thequickbrownfoxjumpsoverthelazydog"));
        assertFalse(p1832.checkIfPangram_arr("leetcode"));
        assertFalse(p1832.checkIfPangram_set("leetcode"));
        assertFalse(p1832.checkIfPangram_bit("leetcode"));
    }

    @Test
    public void test0520()
    {
        P0520DetectCapital p0520 = new P0520DetectCapital();
        assertTrue(p0520.detectCapitalUse("USA"));
        assertTrue(p0520.detectCapitalUse_api("leetcode"));
        assertFalse(p0520.detectCapitalUse_regex("FlaG"));
        assertFalse(p0520.detectCapitalUse_official("mL"));
    }

    @Test
    public void test0551()
    {
        P0551StudentAttendanceRecordI p0551 = new P0551StudentAttendanceRecordI();
        assertTrue(p0551.checkRecord_1("PPALLP"));
        assertFalse(p0551.checkRecord_2("PPALLAP"));
        assertFalse(p0551.checkRecord_api("PPALLL"));
    }

    @Test
    public void test1945()
    {
        P1945SumOfDigitsOfStringAfterConvert p1945 = new P1945SumOfDigitsOfStringAfterConvert();
        assertEquals(8, p1945.getLucky_1("zbax", 2));
        assertEquals(36, p1945.getLucky_2("iiii", 1));
        assertEquals(6, p1945.getLucky_2("leetcode", 2));
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
        assertFalse(obj.wordBreak(s, wordDict));
    }

    @Test
    public void test0409()
    {
        P0409LongestPalindrome p0409 = new P0409LongestPalindrome();
        assertEquals(7, p0409.longestPalindrome("abccccdd"));
        assertEquals(1, p0409.longestPalindrome("a"));
    }

    @Test
    public void test2351()
    {
        P2351FirstLetterToAppearTwice p2351 = new P2351FirstLetterToAppearTwice();
        assertEquals('c', p2351.repeatedCharacter_hash("abccbacz"));
        assertEquals('d', p2351.repeatedCharacter_bite("abcdd"));
    }

    @Test
    public void test2042()
    {
        P2042CheckIfNumbersAreAscendingInASentence p2042 = new P2042CheckIfNumbersAreAscendingInASentence();
        assertTrue(p2042.areNumbersAscending_1("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
        assertFalse(p2042.areNumbersAscending_2("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"));
        assertFalse(p2042.areNumbersAscending_3("hello world 5 x 5"));
    }

    @Test
    public void test2185()
    {
        P2185CountingWordsWithAGivenPrefix p2185 = new P2185CountingWordsWithAGivenPrefix();
        String[] words1 = {"pay", "attention", "practice", "attend"};
        String[] words2 = {"leetcode", "win", "loops", "success"};
        assertEquals(2, p2185.prefixCount(words1, "at"));
        assertEquals(0, p2185.prefixCount(words2, "code"));
    }

    @Test
    public void test1807()
    {
        P1807EvaluateTheBracketPairsOfAString p1807 = new P1807EvaluateTheBracketPairsOfAString();
        List<List<String>> lists1 = new ArrayList<>();
        lists1.add(List.of("name", "bob"));
        lists1.add(List.of("age", "two"));
        assertEquals("bobistwoyearsold", p1807.evaluate_2("(name)is(age)yearsold", lists1));

        List<List<String>> lists2 = new ArrayList<>();
        lists2.add(List.of("a", "b"));
        assertEquals("hi?", p1807.evaluate_2("hi(name)", lists2));

        List<List<String>> lists3 = new ArrayList<>();
        lists3.add(List.of("a", "yes"));
        assertEquals("yesyesyesaaa", p1807.evaluate_1("(a)(a)(a)aaa", lists3));
    }

    @Test
    public void test2283()
    {
        P2283CheckIfNumberHasEqualDigitCountAndDigitValue p2283 = new P2283CheckIfNumberHasEqualDigitCountAndDigitValue();
        assertTrue(p2283.digitCount("1210"));
        assertFalse(p2283.digitCount("030"));
    }

    @Test
    public void test2287()
    {
        P2287RearrangeCharactersToMakeTargetString p2287 = new P2287RearrangeCharactersToMakeTargetString();
        assertEquals(2, p2287.rearrangeCharacters("ilovecodingonleetcode", "code"));
        assertEquals(2, p2287.rearrangeCharacters("cabcba", "abc"));
        assertEquals(0, p2287.rearrangeCharacters("abc", "abcd"));
        assertEquals(1, p2287.rearrangeCharacters("abbaccaddaeea", "aaaaa"));
    }

    @Test
    public void test0022()
    {
        P0022GenerateParentheses p0022 = new P0022GenerateParentheses();
        assertEquals("[((())), (()()), (())(), ()(()), ()()()]", p0022.generateParenthesis_1(3).toString());
        assertEquals("[((())), (()()), (())(), ()(()), ()()(), <==>, ((())), (()()), (())(), ()(()), ()()()]",
                p0022.generateParenthesis_2(3).toString());
        assertEquals("[()()(), ()(()), (())(), (()()), ((()))]", p0022.generateParenthesisDp(3).toString());
    }

    @Test
    public void test1813()
    {
        P1813SentenceSimilarityIII p1813 = new P1813SentenceSimilarityIII();
        assertTrue(p1813.areSentencesSimilar("My name is Haley", "My Haley"));
        assertFalse(p1813.areSentencesSimilar("of", "A lot of words"));
        assertTrue(p1813.areSentencesSimilar("Eating right now", "Eating"));
        assertTrue(p1813.areSentencesSimilar("right now Eating", "Eating"));
        assertFalse(p1813.areSentencesSimilar("Luky", "Lucccky"));
    }

    @Test
    public void test2299()
    {
        P2299StrongPasswordCheckerII p2299 = new P2299StrongPasswordCheckerII();
        assertTrue(p2299.strongPasswordCheckerII("IloveLe3tcode!"));
        assertFalse(p2299.strongPasswordCheckerII("Me+You--IsMyDream"));
        assertFalse(p2299.strongPasswordCheckerII("1aB!"));
    }

    @Test
    public void test1663()
    {
        P1663SmallestStringWithAGivenNumericValue p1663 = new P1663SmallestStringWithAGivenNumericValue();
        assertEquals("aay", p1663.getSmallestString_1(3, 27));
        assertEquals("aaszz", p1663.getSmallestString_2(5, 73));
        // System.out.println(p1663.getSmallestString(100000, 2600000));
    }

    @Test
    public void test2309()
    {
        P2309GreatestEnglishLetterInUpperAndLowerCase p2309 = new P2309GreatestEnglishLetterInUpperAndLowerCase();
        assertEquals("E", p2309.greatestLetter_arr("lEeTcOdE"));
        assertEquals("E", p2309.greatestLetter_hash("lEeTcOdE"));
        assertEquals("E", p2309.greatestLetter_bit("lEeTcOdE"));
        assertEquals("R", p2309.greatestLetter_arr("arRAzFif"));
        assertEquals("R", p2309.greatestLetter_hash("arRAzFif"));
        assertEquals("R", p2309.greatestLetter_bit("arRAzFif"));
    }

    @Test
    public void test2315()
    {
        P2315CountAsterisks p2315 = new P2315CountAsterisks();
        assertEquals(2, p2315.countAsterisks("l|*e*et|c**o|*de|"));
        assertEquals(0, p2315.countAsterisks("iamprogrammer"));
        assertEquals(5, p2315.countAsterisks("yo|uar|e**|b|e***au|tifu|l"));
    }

    @Test
    public void test1138()
    {
        P1138AlphabetBoardPath p1138 = new P1138AlphabetBoardPath();
        assertEquals("DDR!UURRR!!DDD!", p1138.alphabetBoardPath("leet"));
        assertEquals("RR!DDRR!UUL!R!", p1138.alphabetBoardPath("code"));
        assertEquals("DDDDD!UUUUURRR!LLLDDDDD!", p1138.alphabetBoardPath("zdz"));
    }

    @Test
    public void test1234()
    {
        P1234ReplaceTheSubstringForBalancedString p1234 = new P1234ReplaceTheSubstringForBalancedString();
        assertEquals(1, p1234.balancedString_1("QQWE"));
        assertEquals(2, p1234.balancedString_2("QQQW"));
        assertEquals(4, p1234.balancedString_2("WWEQERQWQWWRWWERQWEQ"));
    }

    @Test
    public void test1247()
    {
        P1247MinimumSwapsToMakeStringsEqual p1247 = new P1247MinimumSwapsToMakeStringsEqual();
        assertEquals(1, p1247.minimumSwap("xx", "yy"));
        assertEquals(2, p1247.minimumSwap("xy", "yx"));
        assertEquals(-1, p1247.minimumSwap("xx", "xy"));
        assertEquals(4, p1247.minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"));
    }

    @Test
    public void test1653()
    {
        P1653MinimumDeletionsToMakeStringBalanced p1653 = new P1653MinimumDeletionsToMakeStringBalanced();
        assertEquals(2, p1653.minimumDeletions("aababbab"));
        assertEquals(2, p1653.minimumDeletions("bbaaaaabb"));
    }

    @Test
    public void test1487()
    {
        P1487MakingFileNamesUnique p1487 = new P1487MakingFileNamesUnique();
        String[] names1 = {"gta", "gta(1)", "gta", "avalon"};
        String[] names2 = {"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"};
        String[] names3 = {"wano", "wano", "wano", "wano"};
        String[] names4 = {"kaido", "kaido(1)", "kaido", "kaido(1)", "kaido(2)"};
        assertEquals("[gta, gta(1), gta(2), avalon]",
                Arrays.toString(p1487.getFolderNames(names1)));
        assertEquals("[onepiece, onepiece(1), onepiece(2), onepiece(3), onepiece(4)]",
                Arrays.toString(p1487.getFolderNames(names2)));
        assertEquals("[wano, wano(1), wano(2), wano(3)]",
                Arrays.toString(p1487.getFolderNames(names3)));
        assertEquals("[kaido, kaido(1), kaido(2), kaido(1)(1), kaido(2)(1)]",
                Arrays.toString(p1487.getFolderNames(names4)));
    }

    @Test
    public void test0831()
    {
        P0831MaskingPersonalInformation p0831 = new P0831MaskingPersonalInformation();
        assertEquals("l*****e@leetcode.com", p0831.maskPII_2("LeetCode@LeetCode.com"));
        assertEquals("a*****b@qq.com", p0831.maskPII_1("AB@qq.com"));
        assertEquals("***-***-7890", p0831.maskPII_1("1(234)567-890"));
        assertEquals("+**-***-***-5678", p0831.maskPII_2("86-(10)12345678"));
    }


    @Test
    public void test1143()
    {
        assertEquals(3, P1143LongestCommonSubsequence.longestCommonSubsequenceDpnn("abcde", "ace"));
        assertEquals(5, P1143LongestCommonSubsequence.longestCommonSubsequenceDpnn("abxyz", "abcxyz"));
        assertEquals(0, P1143LongestCommonSubsequence.longestCommonSubsequenceDpnn("abc", "def"));

        assertEquals(3, P1143LongestCommonSubsequence.longestCommonSubsequenceDpn1("abcde", "ace"));
        assertEquals(5, P1143LongestCommonSubsequence.longestCommonSubsequenceDpn1("abxyz", "abcxyz"));
        assertEquals(0, P1143LongestCommonSubsequence.longestCommonSubsequenceDpn1("abc", "def"));
    }

    @Test
    public void test0583()
    {
        assertEquals(2, P0583DeleteOperationForTwoStrings.minDistanceDpn1("sea", "eat"));
        assertEquals(4, P0583DeleteOperationForTwoStrings.minDistanceDpn1("leetcode", "etco"));
        assertEquals(3, P0583DeleteOperationForTwoStrings.minDistanceDpn1("park", "spake"));

        assertEquals(4, P0583DeleteOperationForTwoStrings.minDistanceDpnn("leetcode", "etco"));
        assertEquals(3, P0583DeleteOperationForTwoStrings.minDistanceDpnn("park", "spake"));
    }

    @Test
    public void test0395()
    {
        P0395LongestSubstringWithAtLeastKRepeatingCharacters p0395 =
                new P0395LongestSubstringWithAtLeastKRepeatingCharacters();
        assertEquals(3, p0395.longestSubstring("aaabb", 3));
        assertEquals(5, p0395.longestSubstring("ababbc", 2));
        assertEquals(0, p0395.longestSubstring("ababbc", 3));
        assertEquals(3, p0395.longestSubstring("dddxxaabaaabaacciiiefbff", 3));
        assertEquals(10, p0395.longestSubstring("dddxxaabaaabbaacciiiefbff", 3));
    }

    @Test
    public void test2129()
    {
        assertEquals("Capitalize The Title", P2129CapitalizeTheTitle.capitalizeTitle("capiTalIze tHe titLe"));
        assertEquals("i Love Leetcode", P2129CapitalizeTheTitle.capitalizeTitle("i lOve leetcode"));
    }

    @Test
    public void test0076()
    {
        assertEquals("BANC", P0076MinimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
        assertEquals("a", P0076MinimumWindowSubstring.minWindow("a", "a"));
        assertEquals("", P0076MinimumWindowSubstring.minWindow("a", "aa"));
    }

    @Test
    public void test0535()
    {
        P0535EncodeAndDecodeTinyURL.Codec p0535 = new P0535EncodeAndDecodeTinyURL.Codec();
        assertEquals("https://leetcode.com/problems/design-tinyurl",
                p0535.decode(p0535.encode("https://leetcode.com/problems/design-tinyurl")));
    }

    @Test
    public void test2864()
    {
        assertEquals("001", P2864MaximumOddBinaryNumber.maximumOddBinaryNumber("010"));
        assertEquals("1001", P2864MaximumOddBinaryNumber.maximumOddBinaryNumber("0101"));
    }

    @Test
    public void test3280()
    {
        assertEquals("100000100000-10-11101", P3280ConvertDateToBinary.convertDateToBinary("2080-02-29"));
        assertEquals("11101101100-1-1", P3280ConvertDateToBinary.convertDateToBinary("1900-01-01"));
        assertEquals("100000110100-1100-11111", P3280ConvertDateToBinary.convertDateToBinary("2100-12-31"));
    }
}
