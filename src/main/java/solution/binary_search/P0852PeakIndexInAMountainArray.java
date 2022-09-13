package solution.binary_search;

/**
 * Description : 山脉数组的峰顶索引
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 * <p>
 * 示例 1：
 * 输入：arr = [0,1,0]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：arr = [0,2,1,0]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：arr = [0,10,5,2]
 * 输出：1
 * <p>
 * 示例 4：
 * 输入：arr = [3,4,5,1]
 * 输出：2
 * <p>
 * 示例 5：
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * 输出：2
 * <p>
 * 提示：
 * 3 <= arr.length <= 104
 * 0 <= arr[i] <= 106
 * 题目数据保证 arr 是一个山脉数组
 *
 * @author Eric L SHU
 * @date 2022-09-13 20:30
 * @since jdk-11.0.14
 */
public class P0852PeakIndexInAMountainArray
{
    /**
     * 考虑边界
     */
    public int peakIndexInMountainArray_1(int[] arr)
    {
        int left = 0, right = arr.length - 1;
        int mid;
        while (left <= right)
        {
            mid = (left + right) >>> 1;
            if (mid == 0)
            {
                if (arr[mid] > arr[mid + 1])
                    return mid;
                else
                    mid = 1;
            }
            else if (mid == arr.length - 1)
            {
                if (arr[mid] > arr[mid - 1])
                    return mid;
                else
                    mid = mid - 1;
            }
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                return mid;
            else if (arr[mid] < arr[mid - 1])
                right = mid - 1;
            else if (arr[mid] < arr[mid + 1])
                left = mid + 1;
        }
        return left;
    }

    /**
     * 不考虑边界
     */
    public int peakIndexInMountainArray_2(int[] arr)
    {
        int left = 0, right = arr.length - 1;
        int mid;
        while (left <= right)
        {
            mid = (left + right) >>> 1;
            if (mid == 0)
            {
                mid = mid + 1;
            }
            else if (mid == arr.length - 1)
            {
                mid = mid - 1;
            }
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                return mid;
            else if (arr[mid] < arr[mid - 1])
                right = mid - 1;
            else if (arr[mid] < arr[mid + 1])
                left = mid + 1;
        }
        return left;
    }

    public int peakIndexInMountainArray_3(int[] arr)
    {
        int left = 1, right = arr.length - 2;
        while (left <= right)
        {
            int mid = (left + right) >>> 1;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                return mid;
            else if (arr[mid] < arr[mid - 1])
                right = mid - 1;
            else if (arr[mid] < arr[mid + 1])
                left = mid + 1;
        }
        return left;
    }
}
