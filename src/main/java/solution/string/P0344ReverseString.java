package solution.string;

/**
 * Description : 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 示例 1：
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * <p>
 * 示例 2：
 * 输入：s = ["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * <p>
 * 提示：
 * 1 <= s.length <= 105
 * s[i] 都是 ASCII 码表中的可打印字符
 *
 * @author Eric L SHU
 * @date 2022-09-13 20:40
 * @since jdk-11.0.14
 */
public class P0344ReverseString
{
    public void reverseString(char[] s)
    {
        int left = 0, right = s.length - 1;
        char temp;
        while (left < right)
        {
            temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
