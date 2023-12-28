package com.eric.solution.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2023-12-28 1:21 PM
 * @since jdk-11.0.14
 */
public class QuickSort
{
    public static void sort(int[] arr)
    {
        doSort(arr, 0, arr.length - 1);
    }

    private static void doSort(int[] arr, int left, int right)
    {
        if (left >= right)
            return;
        int p = handleDuplicatePartition(arr, left, right);
        doSort(arr, left, p - 1);
        doSort(arr, p + 1, right);
    }

    /**
     * 快速排序之单边循环（lomuto分区）
     */
    private static int lomutoPartition(int[] arr, int left, int right)
    {
        int pv = arr[right]; // 基准点元素值
        // low找比基准点小的元素， high找比基准点大的元素
        int low = left, high = left;
        while (low < right)
        {
            // 找到了比基准点小的元素
            if (arr[low] < pv)
            {
                if (low != high)
                    SortUtil.swap(arr, low, high);
                high++;
            }
            low++;
        }
        SortUtil.swap(arr, high, right);
        System.out.println(Arrays.toString(arr));
        return high;
    }

    /**
     * 快速排序之双边循环（Hoare分区）
     */
    private static int hoarePartition(int[] arr, int left, int right)
    {
        int pv = arr[left]; // 基准点位置元素值
        int i = left;  // 从左到右找比基准点元素大的值
        int j = right; // 从右向左找比基准点元素小的值
        while (i < j)
        {
            while (i < j && arr[j] > pv)
            {
                j--;
            }
            while (i < j && arr[i] <= pv)
            {
                i++;
            }
            SortUtil.swap(arr, j, i);
        }
        SortUtil.swap(arr, left, i);
        System.out.println(Arrays.toString(arr));
        return i;
    }

    /**
     * 随机选择一个索引位置与左侧元素交换作为基准点，避免降序数据的情况
     */
    private static int randomPartition(int[] arr, int left, int right)
    {
        int idx = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        SortUtil.swap(arr, left, idx);
        int pv = arr[left]; // 基准点位置元素值
        int i = left;  // 从左到右找比基准点元素大的值
        int j = right; // 从右向左找比基准点元素小的值
        while (i < j)
        {
            while (i < j && arr[j] > pv)
            {
                j--;
            }
            while (i < j && arr[i] <= pv)
            {
                i++;
            }
            SortUtil.swap(arr, j, i);
        }
        SortUtil.swap(arr, left, i);
        System.out.println(Arrays.toString(arr));
        return i;
    }

    /**
     * 如果重复值较多，则原来算法中的分区效果也不好，如下图中左侧所示，需要想办法改为右侧的分区效果
     * 核心思想是
     * * 改进前，i 只找大于的，j 会找小于等于的。一个不找等于、一个找等于，势必导致等于的值分布不平衡
     * * 改进后，二者都会找等于的交换，等于的值会平衡分布在基准点两边
     * 细节：
     * * 因为一开始 i 就可能等于 j，因此外层循环需要加等于条件保证至少进入一次，让 j 能减到正确位置
     * * 内层 while 循环中 i <= j 的 = 也不能去掉，因为 i == j 时也要做一次与基准点的判断，好让 i 及 j 正确
     * * i == j 时，也要做一次 i++ 和 j-- 使下次循环二者不等才能退出
     * * 因为最后退出循环时 i 会大于 j，因此最终与基准点交换的是 j
     * 内层两个 while 循环的先后顺序不再重要
     */
    private static int handleDuplicatePartition(int[] arr, int left, int right)
    {
        int pv = arr[left]; // 基准点位置元素值
        int i = left + 1;  // 从左到右找比基准点元素大的值
        int j = right; // 从右向左找比基准点元素小的值
        while (i <= j)
        {
            while (i <= j && arr[i] < pv)
            {
                i++;
            }
            while (i <= j && arr[j] > pv)
            {
                j--;
            }
            if (i <= j)
                SortUtil.swap(arr, j--, i++);
        }
        SortUtil.swap(arr, j, left);
        // System.out.println(Arrays.toString(arr));
        return j;
    }
}
