import org.junit.Test;
import solution.array.P0022GenerateParentheses;
import solution.array.P0242ValidAnagram;
import solution.array.P1796SecondLargestDigitInAString;
import solution.math.P0067AddBinary;
import solution.math.P0389FindTheDifference;
import solution.string.*;

import java.util.ArrayList;
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
        P0028ImplementStrStr p0028 = new P0028ImplementStrStr();
        System.out.println(p0028.strStr_1("mississippi", "issippi"));
        System.out.println(p0028.strStr_kmp("mississippi", "issippi"));
        System.out.println(p0028.strStr_kmp("sadbutsad", "sad"));
        System.out.println(p0028.strStr_2("sadbutsad", "sad"));
    }

    @Test
    public void testP0017()
    {
        P0017LetterCombinationsOfAPhoneNumber p0016 = new P0017LetterCombinationsOfAPhoneNumber();
        System.out.println(p0016.letterCombinations_1("23"));
        System.out.println(p0016.letterCombinations_2("23"));
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

    @Test
    public void test1784()
    {
        P1784CheckIfBinaryStringHasAtMostOneSegmentOfOnes p1784 = new P1784CheckIfBinaryStringHasAtMostOneSegmentOfOnes();
        System.out.println(p1784.checkOnesSegment("1"));
        System.out.println(p1784.checkOnesSegment("11"));
        System.out.println(p1784.checkOnesSegment("110"));
        System.out.println(p1784.checkOnesSegment("11100001"));
        System.out.println(p1784.checkOnesSegment("1110000110011111"));
    }

    @Test
    public void test0345()
    {
        P0345ReverseVowelsOfAString p0345 = new P0345ReverseVowelsOfAString();
        System.out.println(p0345.reverseVowels("hello"));
        System.out.println(p0345.reverseVowels("leetcode"));
    }

    @Test
    public void test0434()
    {
        P0434NumberOfSegmentsInAString p0434 = new P0434NumberOfSegmentsInAString();
        System.out.println(p0434.countSegments_1("Hello, my name is John"));
        System.out.println(p0434.countSegments_2("Hello, my name is John"));
        System.out.println(p0434.countSegments_3("Hello, my name is John"));
    }

    @Test
    public void test0205()
    {
        P0205IsomorphicStrings p0205 = new P0205IsomorphicStrings();
        System.out.println(p0205.isIsomorphic("egg", "add"));
        System.out.println(p0205.isIsomorphic_hash("foo", "bar"));
        System.out.println(p0205.isIsomorphic_array("paper", "title"));
    }

    @Test
    public void test1790()
    {
        P1790CheckIfOneStringSwapCanMakeStringsEqual p1790 = new P1790CheckIfOneStringSwapCanMakeStringsEqual();
        System.out.println(p1790.areAlmostEqual_2p("bank", "kanb"));
        System.out.println(p1790.areAlmostEqual_2p("attack", "defend"));
        System.out.println(p1790.areAlmostEqual_2p("kelb", "kelb"));
        System.out.println(p1790.areAlmostEqual_2p("abcd", "dcba"));
        System.out.println(p1790.areAlmostEqual_2p("ysmpagrkzsmmzmsssutzgpxrmoylkgemgfcperptsxjcsgojwourhxlhqkxumonfgrczmjvbhwvhpnocz",
                "ysmpagrqzsmmzmsssutzgpxrmoylkgemgfcperptsxjcsgojwourhxlhkkxumonfgrczmjvbhwvhpnocz"));
        System.out.println(p1790.areAlmostEqual_list("ysmpagrkzsmmzmsssutzgpxrmoylkgemgfcperptsxjcsgojwourhxlhqkxumonfgrczmjvbhwvhpnocz",
                "ysmpagrqzsmmzmsssutzgpxrmoylkgemgfcperptsxjcsgojwourhxlhkkxumonfgrczmjvbhwvhpnocz"));
    }

    @Test
    public void test0290()
    {
        P0290WordPattern p0290 = new P0290WordPattern();
        System.out.println(p0290.wordPattern_1("abba", "dog cat cat dog"));
        System.out.println(p0290.wordPattern_1("abba", "dog cat cat fish"));
        System.out.println(p0290.wordPattern_2("aaaa", "dog cat cat dog"));
        System.out.println(p0290.wordPattern_2("abba", "dog dog dog dog"));
    }

    @Test
    public void test0415()
    {
        P0415AddStrings p0415 = new P0415AddStrings();
        System.out.println(p0415.addStrings("11", "123"));
        System.out.println(p0415.addStrings("456", "77"));
        System.out.println(p0415.addStrings("0", "0"));
        System.out.println(p0415.addStrings("99", "1"));
    }

    @Test
    public void test1768()
    {
        P1768MergeStringsAlternately p1768 = new P1768MergeStringsAlternately();
        System.out.println(p1768.mergeAlternately_1("abc", "pqr"));
        System.out.println(p1768.mergeAlternately_2("ab", "pqrs"));
        System.out.println(p1768.mergeAlternately_2("abcd", "pq"));
    }

    @Test
    public void test1678()
    {
        P1678GoalParserInterpretation p1678 = new P1678GoalParserInterpretation();
        System.out.println(p1678.interpret_1("G()(al)"));
        System.out.println(p1678.interpret_2("(al)G(al)()()G"));
    }

    @Test
    public void test0043()
    {
        P0043MultiplyStrings p0043 = new P0043MultiplyStrings();
        System.out.println(p0043.multiply_1("2", "3"));
        System.out.println(p0043.multiply_2("123", "456"));
    }

    @Test
    public void test0049()
    {
        P0049GroupAnagrams p0049 = new P0049GroupAnagrams();
        System.out.println(p0049.groupAnagrams_1(new String[]{""}));
        System.out.println(p0049.groupAnagrams_2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(p0049.groupAnagrams_3(new String[]{"a"}));
    }

    @Test
    public void test0763()
    {
        P0763PartitionLabels p0763 = new P0763PartitionLabels();
        System.out.println(p0763.partitionLabels("ababcbacadefegdehijhklij"));
    }

    @Test
    public void test1309()
    {
        P1309DecryptStringFromAlphabetToIntegerMapping p1309 = new P1309DecryptStringFromAlphabetToIntegerMapping();
        System.out.println(p1309.freqAlphabets_forward("10#11#12"));
        System.out.println(p1309.freqAlphabets_reverse("1326#"));
    }

    @Test
    public void test0709()
    {
        P0709ToLowerCase p0709 = new P0709ToLowerCase();
        System.out.println(p0709.toLowerCase_api("LOVELY"));
        System.out.println(p0709.toLowerCase("Hello"));
    }

    @Test
    public void test0953()
    {
        P0953VerifyingAnAlienDictionary p0953 = new P0953VerifyingAnAlienDictionary();
        System.out.println(p0953.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(p0953.isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(p0953.isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    public void test0187()
    {
        P0187RepeatedDNASequences p0187 = new P0187RepeatedDNASequences();
        System.out.println(p0187.findRepeatedDnaSequences_1("AAAAAAAAAAAAA"));
        System.out.println(p0187.findRepeatedDnaSequences_2("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    @Test
    public void test0005()
    {
        P0005LongestPalindromicSubstring p0005 = new P0005LongestPalindromicSubstring();
        System.out.println(p0005.longestPalindrome("babad"));
        System.out.println(p0005.longestPalindrome_dp("cbbd"));
    }

    @Test
    public void test0844()
    {
        P0844BackspaceStringCompare p0844 = new P0844BackspaceStringCompare();
        System.out.println(p0844.backspaceCompare_1("ab#c", "ad#c"));
        System.out.println(p0844.backspaceCompare_2("ab##", "c#d#"));
        System.out.println(p0844.backspaceCompare_2("a#c", "b"));
    }

    @Test
    public void test0394()
    {
        P0394DecodeString p0394 = new P0394DecodeString();
        System.out.println(p0394.decodeString_baoli("3[a]2[bc]"));
        System.out.println(p0394.decodeString_baoli("3[a2[c]]"));
        System.out.println(p0394.decodeString_baoli("2[abc]3[cd]ef"));
        System.out.println(p0394.decodeString_stack("abc3[cd]xyz"));
        System.out.println(p0394.decodeString_stack("100[leetcode]"));
    }

    @Test
    public void test0692()
    {
        P0692TopKFrequentWords p0692 = new P0692TopKFrequentWords();
        String[] words1 = {"i", "love", "leetcode", "i", "love", "coding"};
        String[] words2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(p0692.topKFrequent_pq(words1, 2));
        System.out.println(p0692.topKFrequent_list(words2, 4));
    }

    @Test
    public void test0438()
    {
        P0438FindAllAnagramsInAString p0438 = new P0438FindAllAnagramsInAString();
        System.out.println(p0438.findAnagrams_sw("cbaebabacd", "abc"));
        System.out.println(p0438.findAnagrams_sw1("cbaebabacd", "abc"));
        System.out.println(p0438.findAnagrams_sw2("abab", "ab"));
        System.out.println(p0438.findAnagrams_baoli("abab", "ab"));
    }

    @Test
    public void test0299()
    {
        P0299BullsAndCows p0299 = new P0299BullsAndCows();
        System.out.println(p0299.getHint("1807", "7810"));
        System.out.println(p0299.getHint("1123", "0111"));
    }

    @Test
    public void test0451()
    {
        P0451SortCharactersByFrequency p0451 = new P0451SortCharactersByFrequency();
        System.out.println(p0451.frequencySort_pq("tree"));
        System.out.println(p0451.frequencySort_list("cccaaa"));
        System.out.println(p0451.frequencySort_bucket("Aabb"));
    }

    @Test
    public void test0459()
    {
        P0459RepeatedSubstringPattern p0459 = new P0459RepeatedSubstringPattern();
        System.out.println(p0459.repeatedSubstringPattern_n2("abab"));
        System.out.println(p0459.repeatedSubstringPattern_api("aba"));
        System.out.println(p0459.repeatedSubstringPattern_api("abcabcabcabc"));
    }

    @Test
    public void test0067()
    {
        P0067AddBinary p0067 = new P0067AddBinary();
        System.out.println(p0067.addBinary_1("1010", "1011"));
        System.out.println(p0067.addBinary_2("111", "1"));
    }

    @Test
    public void test1781()
    {
        P1781SumOfBeautyOfAllSubstrings p1781 = new P1781SumOfBeautyOfAllSubstrings();
        System.out.println(p1781.beautySum("aabcb"));
        System.out.println(p1781.beautySum("aabcbaa"));
    }

    @Test
    public void test1832()
    {
        P1832CheckIfTheSentenceIsPangram p1832 = new P1832CheckIfTheSentenceIsPangram();
        System.out.println(p1832.checkIfPangram_arr("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(p1832.checkIfPangram_set("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(p1832.checkIfPangram_bit("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(p1832.checkIfPangram_arr("leetcode"));
        System.out.println(p1832.checkIfPangram_set("leetcode"));
        System.out.println(p1832.checkIfPangram_bit("leetcode"));
    }

    @Test
    public void test0520()
    {
        P0520DetectCapital p0520 = new P0520DetectCapital();
        System.out.println(p0520.detectCapitalUse("USA"));
        System.out.println(p0520.detectCapitalUse_api("leetcode"));
        System.out.println(p0520.detectCapitalUse_regex("FlaG"));
        System.out.println(p0520.detectCapitalUse_official("mL"));
    }

    @Test
    public void test0551()
    {
        P0551StudentAttendanceRecordI p0551 = new P0551StudentAttendanceRecordI();
        System.out.println(p0551.checkRecord_1("PPALLP"));
        System.out.println(p0551.checkRecord_2("PPALLAP"));
        System.out.println(p0551.checkRecord_api("PPALLL"));
    }

    @Test
    public void test1945()
    {
        P1945SumOfDigitsOfStringAfterConvert p1945 = new P1945SumOfDigitsOfStringAfterConvert();
        System.out.println(p1945.getLucky_1("zbax", 2));
        System.out.println(p1945.getLucky_2("iiii", 1));
        System.out.println(p1945.getLucky_2("leetcode", 2));
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
    public void test0409()
    {
        P0409LongestPalindrome p0409 = new P0409LongestPalindrome();
        System.out.println(p0409.longestPalindrome("abccccdd"));
        System.out.println(p0409.longestPalindrome("a"));
    }

    @Test
    public void test2351()
    {
        P2351FirstLetterToAppearTwice p2351 = new P2351FirstLetterToAppearTwice();
        System.out.println(p2351.repeatedCharacter_hash("abccbacz"));
        System.out.println(p2351.repeatedCharacter_bite("abcdd"));
    }

    @Test
    public void test2042()
    {
        P2042CheckIfNumbersAreAscendingInASentence p2042 = new P2042CheckIfNumbersAreAscendingInASentence();
        System.out.println(p2042.areNumbersAscending_1("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
        System.out.println(p2042.areNumbersAscending_2("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"));
        System.out.println(p2042.areNumbersAscending_3("hello world 5 x 5"));
    }

    @Test
    public void test2185()
    {
        P2185CountingWordsWithAGivenPrefix p2185 = new P2185CountingWordsWithAGivenPrefix();
        String[] words1 = {"pay", "attention", "practice", "attend"};
        String[] words2 = {"leetcode", "win", "loops", "success"};
        System.out.println(p2185.prefixCount(words1, "at"));
        System.out.println(p2185.prefixCount(words2, "code"));
    }

    @Test
    public void test1807()
    {
        P1807EvaluateTheBracketPairsOfAString p1807 = new P1807EvaluateTheBracketPairsOfAString();
        List<List<String>> lists1 = new ArrayList<>();
        lists1.add(List.of("name", "bob"));
        lists1.add(List.of("age", "two"));
        System.out.println(p1807.evaluate_2("(name)is(age)yearsold", lists1));

        List<List<String>> lists2 = new ArrayList<>();
        lists2.add(List.of("a", "b"));
        System.out.println(p1807.evaluate_2("hi(name)", lists2));


        List<List<String>> lists3 = new ArrayList<>();
        lists3.add(List.of("a", "yes"));
        System.out.println(p1807.evaluate_1("(a)(a)(a)aaa", lists3));
    }

    @Test
    public void test2283()
    {
        P2283CheckIfNumberHasEqualDigitCountAndDigitValue p2283 = new P2283CheckIfNumberHasEqualDigitCountAndDigitValue();
        System.out.println(p2283.digitCount("1210"));
        System.out.println(p2283.digitCount("030"));
    }

    @Test
    public void test2287()
    {
        P2287RearrangeCharactersToMakeTargetString p2287 = new P2287RearrangeCharactersToMakeTargetString();
        System.out.println(p2287.rearrangeCharacters("ilovecodingonleetcode", "code"));
        System.out.println(p2287.rearrangeCharacters("cabcba", "abc"));
        System.out.println(p2287.rearrangeCharacters("abc", "abcd"));
        System.out.println(p2287.rearrangeCharacters("abbaccaddaeea", "aaaaa"));
    }

    @Test
    public void test0022()
    {
        P0022GenerateParentheses p0022 = new P0022GenerateParentheses();
        System.out.println(p0022.generateParenthesis_1(3));
        System.out.println(p0022.generateParenthesis_2(3));
        System.out.println(p0022.generateParenthesis_1(1));
        System.out.println(p0022.generateParenthesis_2(1));
    }

    @Test
    public void test1813()
    {
        P1813SentenceSimilarityIII p1813 = new P1813SentenceSimilarityIII();
        System.out.println(p1813.areSentencesSimilar("My name is Haley", "My Haley"));
        System.out.println(p1813.areSentencesSimilar("of", "A lot of words"));
        System.out.println(p1813.areSentencesSimilar("Eating right now", "Eating"));
        System.out.println(p1813.areSentencesSimilar("right now Eating", "Eating"));
        System.out.println(p1813.areSentencesSimilar("Luky", "Lucccky"));
    }

    @Test
    public void test2299()
    {
        P2299StrongPasswordCheckerII p2299 = new P2299StrongPasswordCheckerII();
        System.out.println(p2299.strongPasswordCheckerII("IloveLe3tcode!"));
        System.out.println(p2299.strongPasswordCheckerII("Me+You--IsMyDream"));
        System.out.println(p2299.strongPasswordCheckerII("1aB!"));
    }

    @Test
    public void test1663()
    {
        P1663SmallestStringWithAGivenNumericValue p1663 = new P1663SmallestStringWithAGivenNumericValue();
        System.out.println(p1663.getSmallestString_1(3, 27));
        System.out.println(p1663.getSmallestString_2(5, 73));
        // System.out.println(p1663.getSmallestString(100000, 2600000));
    }

    @Test
    public void test2309()
    {
        P2309GreatestEnglishLetterInUpperAndLowerCase p2309 = new P2309GreatestEnglishLetterInUpperAndLowerCase();
        System.out.println(p2309.greatestLetter_arr("lEeTcOdE"));
        System.out.println(p2309.greatestLetter_hash("lEeTcOdE"));
        System.out.println(p2309.greatestLetter_bit("lEeTcOdE"));
        System.out.println(p2309.greatestLetter_arr("arRAzFif"));
        System.out.println(p2309.greatestLetter_hash("arRAzFif"));
        System.out.println(p2309.greatestLetter_bit("arRAzFif"));
    }
}
