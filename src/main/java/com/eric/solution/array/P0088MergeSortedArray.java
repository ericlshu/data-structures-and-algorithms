package com.eric.solution.array;

import java.util.Arrays;

/**
 * Description : 合并两个有序数组
 * <p>
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
 * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * <p>
 * 示例 2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * <p>
 * 示例 3：
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 * <p>
 * 提示：
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 * <p>
 * 进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？
 *
 * @author Eric L SHU
 * @date 2022-01-23 16:15
 * @since JDK 1.8
 */
public class P0088MergeSortedArray
{

    /**
     * 逆向双指针
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n)
    {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0 && k >= 0)
        {
            if (nums1[i] >= nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
        if (i >= 0)
        {
            while (i >= 0)
            {
                nums1[k--] = nums1[i--];
            }
        }
        if (j >= 0)
        {
            while (j >= 0)
            {
                nums1[k--] = nums2[j--];
            }
        }
    }

    /**
     * 逆向双指针优化
     */
    public void merge(int[] nums1, int m, int[] nums2, int n)
    {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 || j >= 0)
        {
            if (i == -1)
                nums1[k] = nums2[j--];
            else if (j == -1)
                nums1[k] = nums1[i--];
            else if (nums1[i] >= nums2[j])
                nums1[k] = nums1[i--];
            else
                nums1[k] = nums2[j--];
            k--;
        }
    }

    /**
     * 追加后排序
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n)
    {
        // for (int i = 0; i < n; i++)
        // {
        //     nums1[m+i] = nums2[i];
        // }
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }


    public void merge3(int[] nums1, int m, int[] nums2, int n)
    {
        int i = 0, j = 0;
        int[] sorted = new int[m + n];
        int value;
        while (i < m || j < n)
        {
            if (i == m)
                value = nums2[j++];
            else if (j == n)
                value = nums1[i++];
            else if (nums1[i] < nums2[j])
                value = nums1[i++];
            else
                value = nums2[j++];
            sorted[i + j - 1] = value;
        }
        System.arraycopy(sorted, 0, nums1, 0, m + n);
    }

    public void merge4(int[] nums1, int m, int[] nums2, int n)
    {
        int i = m-- + --n;
        while (n >= 0)
        {
            nums1[i--] = m >= 0 && nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
    }

    public void merge_recursion(int[] nums1, int m, int[] nums2, int n)
    {
        if (n == 0)
            return;
        if (m == 0)
        {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        int[] res = new int[nums1.length];
        System.arraycopy(nums2, 0, nums1, m, n);
        // System.out.println("nums1 = " + Arrays.toString(nums1));
        merge(nums1, 0, m - 1, m, n + m - 1, res, 0);
        // System.out.println("res = " + Arrays.toString(res));
        System.arraycopy(res, 0, nums1, 0, m + n);
    }

    private void merge(int[] nums, int i, int _i, int j, int _j, int[] res, int k)
    {
        if (i > _i)
        {
            System.arraycopy(nums, j, res, k, _j - j + 1);
            return;
        }
        else if (j > _j)
        {
            System.arraycopy(nums, i, res, k, _i - i + 1);
            return;
        }

        if (nums[i] < nums[j])
        {
            res[k++] = nums[i];
            merge(nums, i + 1, _i, j, _j, res, k);
        }
        else
        {
            res[k++] = nums[j];
            merge(nums, i, _i, j + 1, _j, res, k);
        }
    }
}
