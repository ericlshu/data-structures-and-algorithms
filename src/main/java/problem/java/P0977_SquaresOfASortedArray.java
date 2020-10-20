package problem.java;

/**
 * Description : 有序数组的平方
 *
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A已按非递减顺序排序。
 *
 * @author Eric L SHU
 * @date 2020-10-16 20:56
 * @since JDK 1.8
 */
public class P0977_SquaresOfASortedArray
{
    public int[] sortedSquares(int[] A)
    {
        int left = 0;
        int length = A.length;
        int right = length - 1;
        int index = length - 1;
        int[] result = new int[length];
        while (index >= 0) {
            if (A[left] + A[right] < 0) {
                result[index--] = A[left] * A[left];
                left++;
            } else {
                result[index--] = A[right] * A[right];
                right--;
            }
        }
        return result;
    }
}
