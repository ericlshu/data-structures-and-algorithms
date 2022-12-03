package solution.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description : 数组形式的整数加法
 * 整数的 数组形式  num 是按照从左到右的顺序表示其数字的数组。
 * 例如，对于 num = 1321 ，数组形式是 [1,3,2,1] 。
 * 给定 num ，整数的 数组形式 ，和整数 k ，返回 整数 num + k 的 数组形式 。
 * <p>
 * 示例 1：
 * 输入：num = [1,2,0,0], k = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * <p>
 * 示例 2：
 * 输入：num = [2,7,4], k = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * <p>
 * 示例 3：
 * 输入：num = [2,1,5], k = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * <p>
 * 提示：
 * 1 <= num.length <= 104
 * 0 <= num[i] <= 9
 * num 不包含任何前导零，除了零本身
 * 1 <= k <= 104
 *
 * @author Eric L SHU
 * @date 2022-12-03 16:44
 * @since jdk-11.0.14
 */
public class P0989AddToArrayFormOfInteger
{
    public List<Integer> addToArrayForm_1(int[] num, int k)
    {
        List<Integer> list = new ArrayList<>();
        int n = num.length - 1, carry = 0, sum;
        while (k > 0 && n >= 0)
        {
            sum = k % 10 + num[n] + carry;
            list.add(0, sum % 10);
            carry = sum / 10;
            k /= 10;
            n--;
        }
        while (k > 0)
        {
            sum = k % 10 + carry;
            list.add(0, sum % 10);
            carry = sum / 10;
            k /= 10;
        }
        while (n >= 0)
        {
            sum = num[n] + carry;
            list.add(0, sum % 10);
            carry = sum / 10;
            n--;
        }
        if (carry > 0)
        {
            list.add(0, 1);
        }
        return list;
    }

    public List<Integer> addToArrayForm(int[] num, int k)
    {
        List<Integer> list = new ArrayList<>();
        int n = num.length - 1, carry = 0, sum;
        while (k > 0 || n >= 0)
        {
            // sum = (n >= 0 ? num[n] : 0) + k % 10 + carry;
            // list.add(0, sum % 10);
            // carry = sum / 10;
            // k /= 10;
            // n--;
            k += n >= 0 ? num[n--] : 0;
            list.add(k % 10);
            k /= 10;
        }
        // if (carry > 0)
        // {
        //     list.add(0, 1);
        // }
        Collections.reverse(list);
        return list;
    }

    public List<Integer> addToArrayForm_3(int[] num, int k)
    {
        List<Integer> res = new ArrayList<>();
        int n = num.length;
        for (int i = n - 1; i >= 0 || k > 0; --i, k /= 10)
        {
            if (i >= 0)
            {
                k += num[i];
            }
            res.add(0, k % 10);
        }
        // Collections.reverse(res);
        return res;
    }
}
