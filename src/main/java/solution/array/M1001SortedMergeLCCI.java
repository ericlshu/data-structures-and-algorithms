package solution.array;

/**
 * Description : 合并排序的数组
 * <p>
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * 说明:
 * <p>
 * A.length == n + m
 *
 * @author Eric L SHU
 * @date 2022-01-23 17:06
 * @since JDK 1.8
 */
public class M1001SortedMergeLCCI
{

    public void merge(int[] A, int m, int[] B, int n)
    {
        int k = m + n;
        while (m > 0 || n > 0)
        {
            if (m == 0)
                A[--k] = B[--n];
            else if (n == 0)
                A[--k] = A[--m];
            else if (A[m - 1] > B[n - 1])
                A[--k] = A[--m];
            else
                A[--k] = B[--n];
        }
    }
}
