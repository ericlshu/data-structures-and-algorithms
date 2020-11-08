/**
 * Description : 有效的山脉数组
 * <p>
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * <p>
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * <p>
 * 示例 1：
 * 输入：[2,1]
 * 输出：false
 * <p>
 * 示例 2：
 * 输入：[3,5,5]
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：[0,3,2,1]
 * 输出：true
 * <p>
 * 提示：
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 *
 * @author Eric L SHU
 * @date 2020-11-03 19:56
 * @since JDK 1.8
 */
public class P0941_ValidMountainArray
{
    public boolean validMountainArray(int[] A)
    {
        if (A == null || A.length < 3) return false;
        int i = 1;
        while (i < A.length && A[i] > A[i - 1]) i++;
        if (i == 1 || i == A.length) return false;
        while (i < A.length && A[i] < A[i - 1]) i++;
        return i == A.length;
    }
}
