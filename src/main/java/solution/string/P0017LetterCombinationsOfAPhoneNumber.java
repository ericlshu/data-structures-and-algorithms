package solution.string;

import java.util.*;

/**
 * Description : 电话号码的字母组合
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * @author Eric L SHU
 * @date 2020-10-28 20:20
 * @since JDK 1.8
 */
public class P0017LetterCombinationsOfAPhoneNumber
{
    public List<String> letterCombinations_1(String digits)
    {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) return combinations;

        Map<Character, String[]> phoneMap = new HashMap<>(8);
        phoneMap.put('2', new String[]{"a", "b", "c"});
        phoneMap.put('3', new String[]{"d", "e", "f"});
        phoneMap.put('4', new String[]{"g", "h", "i"});
        phoneMap.put('5', new String[]{"j", "k", "l"});
        phoneMap.put('6', new String[]{"m", "n", "o"});
        phoneMap.put('7', new String[]{"p", "q", "r", "s"});
        phoneMap.put('8', new String[]{"t", "u", "v"});
        phoneMap.put('9', new String[]{"w", "x", "y", "z"});

        for (int i = 0; i < digits.length(); i++)
        {
            String[] letters = phoneMap.get(digits.charAt(i));
            if (combinations.size() == 0)
                combinations = Arrays.asList(letters);
            else
            {
                List<String> temp = new ArrayList<>();
                for (String letter : letters)
                {
                    for (String combination : combinations)
                    {
                        temp.add(combination + letter);
                    }
                }
                combinations = temp;
            }
        }
        return combinations;
    }

    Map<Character, String> phoneMap = new HashMap<>()
    {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations_2(String digits)
    {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0)
            return res;
        backtrack(res, digits, 0, new StringBuilder());
        return res;
    }

    private void backtrack(List<String> res, String digits, int idx, StringBuilder comb)
    {
        if (idx == digits.length())
            res.add(comb.toString());
        else
        {
            char digit = digits.charAt(idx);
            String letters = phoneMap.get(digit);
            for (int i = 0; i < letters.length(); i++)
            {
                comb.append(letters.charAt(i));
                backtrack(res, digits, idx + 1, comb);
                comb.deleteCharAt(idx);
            }
        }
    }

    private String[] getListByNumber(char num)
    {
        switch (num)
        {
            case '2': return new String[]{"a", "b", "c"};
            case '3': return new String[]{"d", "e", "f"};
            case '4': return new String[]{"g", "h", "i"};
            case '5': return new String[]{"j", "k", "l"};
            case '6': return new String[]{"m", "n", "o"};
            case '7': return new String[]{"p", "q", "r", "s"};
            case '8': return new String[]{"t", "u", "v"};
            case '9': return new String[]{"w", "x", "y", "z"};
            default: return null;
        }
    }
}
