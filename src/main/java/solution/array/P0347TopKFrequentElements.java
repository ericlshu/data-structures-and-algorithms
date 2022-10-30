package solution.array;

import java.util.*;

/**
 * Description : 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * <p>
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * 提示：
 * -> 1 <= nums.length <= 105
 * -> k 的取值范围是 [1, 数组中不相同的元素的个数]
 * -> 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * <p>
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 *
 * @author Eric L SHU
 * @date 2022-10-30 13:09
 * @since jdk-11.0.14
 */
public class P0347TopKFrequentElements
{
    public int[] topKFrequent_pq1(int[] nums, int k)
    {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums)
        {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> arr2[1] - arr1[1]);
        // PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));
        // for (Map.Entry<Integer, Integer> entry : freq.entrySet())
        // {
        //     int num = entry.getKey(), cnt = entry.getValue();
        //     if (pq.size() == k)
        //     {
        //         assert pq.peek() != null;
        //         if (pq.peek()[1] < cnt)
        //         {
        //             pq.poll();
        //             pq.offer(new int[]{num, cnt});
        //         }
        //     }
        //     else
        //     {
        //         pq.offer(new int[]{num, cnt});
        //     }
        // }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet())
        {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] res = new int[k];
        for (int i = 0; i < k && !pq.isEmpty(); ++i)
        {
            res[i] = pq.poll()[0];
        }
        return res;
    }

    public int[] topKFrequent_pq2(int[] nums, int k)
    {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums)
        {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));
        for (Map.Entry<Integer, Integer> entry : freq.entrySet())
        {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
            if (pq.size() > k)
                pq.poll();
        }
        int[] res = new int[k];
        for (int i = 0; i < k && !pq.isEmpty(); ++i)
        {
            res[i] = pq.poll()[0];
        }
        return res;
    }

    public int[] topKFrequent_pq3(int[] nums, int k)
    {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums)
        {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (e1, e2) -> e2.getValue() - e1.getValue());
        pq.addAll(freq.entrySet());
        int[] res = new int[k];
        for (int i = 0; i < k && !pq.isEmpty(); ++i)
        {
            res[i] = pq.poll().getKey();
        }
        return res;
    }

    public int[] topKFrequent(int[] nums, int k)
    {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums)
        {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet())
        {
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] res = new int[k];
        quickSort(list, 0, list.size() - 1, res, 0, k);
        return res;
    }

    private void quickSort(List<int[]> list, int start, int end, int[] res, int resIdx, int k)
    {
        int picked = (int) (Math.random() * (end - start + 1)) + start;
        Collections.swap(list, picked, start);
        int pivot = list.get(start)[1];
        int idx = start;
        for (int i = start + 1; i <= end; i++)
        {
            if (list.get(i)[1] >= pivot)
            {
                Collections.swap(list, ++idx, i);
            }
        }
        Collections.swap(list, start, idx);
        if (k <= idx - start)
            quickSort(list, start, idx - 1, res, resIdx, k);
        else
        {
            for (int i = start; i <= idx; i++)
                res[resIdx++] = list.get(i)[0];
            if (k > idx - start + 1)
                quickSort(list, idx + 1, end, res, resIdx, k - (idx - start + 1));
        }
    }
}
