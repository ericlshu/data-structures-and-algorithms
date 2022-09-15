package solution.array;

/**
 * Description : 寻找比目标字母大的最小字母
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 * 在比较时，字母是依序循环出现的。举个例子：
 * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 * <p>
 * 示例 1：
 * 输入: letters = ["c", "f", "j"]，target = "a"
 * 输出: "c"
 * <p>
 * 示例 2:
 * 输入: letters = ["c","f","j"], target = "c"
 * 输出: "f"
 * <p>
 * 示例 3:
 * 输入: letters = ["c","f","j"], target = "d"
 * 输出: "f"
 * <p>
 * 提示：
 * 2 <= letters.length <= 104
 * letters[i] 是一个小写字母
 * letters 按非递减顺序排序
 * letters 最少包含两个不同
 *
 * @author Eric L SHU
 * @date 2022-09-15 20:53
 * @since jdk-11.0.14
 */
public class P0744FindSmallestLetterGreaterThanTarget
{
    public char nextGreatestLetter(char[] letters, char target)
    {
        int right = letters.length - 1;
        if (letters[0] > target || letters[right] < target)
            return letters[0];
        int left = 0;
        while (left < right)
        {
            int mid = (left + right) >> 1;
            if (letters[mid] > target)
                right = mid;
            else
                left = mid + 1;
        }
        return letters[right];
    }

    public char nextGreatestLetter_1(char[] letters, char target)
    {
        char nextGreater = letters[0];
        for (char letter : letters)
        {
            if (letter > target)
            {
                nextGreater = letter;
                break;
            }
        }
        return nextGreater;
    }
}
