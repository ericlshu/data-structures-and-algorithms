package com.eric.solution.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Description : 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 示例 1:
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * <p>
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 * <p>
 * 提示：
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 * @author Eric L SHU
 * @date 2022-10-30 12:51
 * @since jdk-11.0.14
 */
public class P0215KthLargestElementInAnArray
{
    public int findKthLargest_sort(int[] nums, int k)
    {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest_pq1(int[] nums, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums)
        {
            pq.offer(num);
        }
        System.out.println(pq);
        int res = 0;
        for (int i = 1; i <= k; i++)
        {
            res = pq.poll();
        }
        return res;
    }

    public int findKthLargest_pq2(int[] nums, int k)
    {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(i -> i));
        for (int num : nums)
        {
            heap.add(num);
            if (heap.size() > k)
                heap.poll();
        }
        return heap.poll();
    }

    private int quickSort(int[] nums, int left, int right, int k)
    {
        int idx = random.nextInt(right - left + 1) + left;
        int pivot = nums[idx];
        nums[idx] = nums[left];
        int i = left, j = right;
        while ((i < j))
        {
            while (i < j && nums[j] <= pivot)
            {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] >= pivot)
            {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        if (i == k - 1)
            return nums[i];
        else if (i < k - 1)
            return quickSort(nums, i + i, right, k);
        else
            return quickSort(nums, left, i - 1, k);
    }

    Random random = new Random();

    public int findKthLargest(int[] nums, int k)
    {
        System.out.println(quickSort(nums, 0, nums.length - 1, k));
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int k)
    {
        int idx = partition(nums, left, right);
        if (idx == k)
            return nums[idx];
        else if (idx < k)
            return quickSelect(nums, idx + 1, right, k);
        else
            return quickSelect(nums, left, idx - 1, k);
    }

    private int partition(int[] nums, int left, int right)
    {
        int idx = random.nextInt(right - left + 1) + left;
        int pivot = nums[idx], i = left;
        swap(nums, idx, right);
        for (int j = left; j <= right; j++)
        {
            if (nums[j] < pivot)
            {
                swap(nums, i++, j);
            }
        }
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] a, int i, int j)
    {
        if (i != j)
        {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
}
