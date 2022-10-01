package solution.array;

/**
 * Description : 数组中的最长山脉
 * <p>
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 * <p>
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 * 如果不含有 “山脉” 则返回 0。
 * <p>
 * 示例 1：
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * <p>
 * 示例 2：
 * <p>
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 *
 * @author Eric L SHU
 * @date 2020-10-25 12:50
 * @since JDK 1.8
 */
public class P0845LongestMountainInArray
{
    public int longestMountain(int[] A)
    {
        int start = -1, end = -1, maxLength = 0;
        boolean hasPeak = false;
        for (int i = 1; i < A.length; i++)
        {
            // 当前值与上一值相等，重置指针，进行下一次循环
            if (A[i] == A[i - 1])
            {
                start = -1;
                end = -1;
                hasPeak = false;
                continue;
            }
            // 当前值大于上一值，并且未标记起始位置或已标记结束位置，
            // 标记上一位置为起始位置，重置结束位置
            else if (A[i] > A[i - 1] && (start == -1 || end != -1))
            {
                start = i - 1;
                end = -1;
                hasPeak = false;
            }
            // 已标记起始位置，并当前值小于上一值，标记结束位置
            else if (start != -1 && A[i - 1] > A[i])
            {
                end = i;
                // 标记是否存在峰顶 A[i - 2] < A[i - 1] > A[i]
                if (A[i - 2] < A[i - 1])
                    hasPeak = true;
            }
            // 峰顶存在时计算山峰长度
            if (hasPeak)
                maxLength = Math.max(end - start + 1, maxLength);
        }
        return maxLength;
    }
}
