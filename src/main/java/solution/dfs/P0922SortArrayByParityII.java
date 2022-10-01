package solution.dfs;

/**
 * Description : 按奇偶排序数组 II
 * <p>
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 * <p>
 * 示例：
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * <p>
 * 提示：
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *
 * @author Eric L SHU
 * @date 2020-11-12 19:40
 * @since JDK 1.8
 */
public class P0922SortArrayByParityII
{
    public int[] sortArrayByParityII(int[] A)
    {
        int[] result = new int[A.length];
        int evenIndex = 0, oddIndex = 1;
        for (int i : A)
        {
            if (i % 2 == 0)
            {
                result[evenIndex] = i;
                evenIndex += 2;
            }
            else
            {
                result[oddIndex] = i;
                oddIndex += 2;
            }
        }
        return result;
    }

    public int[] sortArrayByParityII_1(int[] A)
    {
        int odd = 1;
        for (int even = 0; even < A.length; even += 2)
        {
            if (A[even] % 2 == 1)
            {
                while (A[odd] % 2 == 1)
                {
                    odd += 2;
                }
                swap(A, even, odd);
            }
        }
        return A;
    }

    public void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
