package solution.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Description : 面试题 17.05. 字母与数字
 * 给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。
 * 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。
 * <p>
 * 示例 1:
 * 输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
 * 输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
 * <p>
 * 示例 2:
 * 输入: ["A","A"]
 * 输出: []
 * <p>
 * 提示：
 * array.length <= 100000
 *
 * @author Eric L SHU
 * @date 2023-03-11 18:55
 * @since jdk-11.0.14
 */
public class M1705FindLongestSubarrayLCCI
{
    public String[] findLongestSubarray(String[] array)
    {
        Map<Integer, Integer> indices = new HashMap<>();
        indices.put(0, -1);
        int sum = 0, maxLen = 0, startIdx = -1, n = array.length;
        for (int i = 0; i < n; i++)
        {
            sum += Character.isLetter(array[i].charAt(0)) ? 1 : -1;
            if (indices.containsKey(sum))
            {
                int firstIdx = indices.get(sum);
                if (i - firstIdx > maxLen)
                {
                    maxLen = i - firstIdx;
                    startIdx = firstIdx + 1;
                }
            }
            else
            {
                indices.put(sum, i);
            }
        }
        String[] res = new String[maxLen];
        if (maxLen == 0) return res;
        System.arraycopy(array, startIdx, res, 0, maxLen);
        return res;
    }
}
