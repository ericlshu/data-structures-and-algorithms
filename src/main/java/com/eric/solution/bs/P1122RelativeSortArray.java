package com.eric.solution.bs;

import java.util.*;

/**
 * Description : 数组的相对排序
 * <p>
 * 给你两个数组，arr1 和 arr2，
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
 * 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 * 示例：
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * 提示：
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 * @author Eric L SHU
 * @date 2020-11-14 17:28
 * @since JDK 1.8
 */
public class P1122RelativeSortArray
{
    public static int[] relativeSortArray(int[] arr1, int[] arr2)
    {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : arr1)
        {
            list.add(num);
        }

        int[] result = new int[arr1.length];
        int index = 0;
        for (int i : arr2)
        {
            while (list.contains(i))
            {
                result[index++] = i;
                list.remove((Integer) i);
            }
        }

        list.sort(Comparator.comparingInt(i -> i));
        for (int i : list)
        {
            result[index++] = i;
        }
        return result;
    }

    public static int[] relativeSortArrayByMap(int[] arr1, int[] arr2)
    {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : arr1)
        {
            list.add(num);
        }
        for (int i = 0; i < arr2.length; i++)
        {
            map.put(arr2[i], i);
        }
        list.sort((x, y) ->
        {
            if (map.containsKey(x) || map.containsKey(y))
                return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
            return x - y;
        });
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static int[] relativeSortArrayByCount(int[] arr1, int[] arr2)
    {
        int[] cnt = new int[1001];
        for (int i : arr1)
        {
            cnt[i]++;
        }
        // System.out.println("cnt = " + Arrays.toString(cnt));
        int[] res = new int[arr1.length];
        int idx = 0;
        for (int i : arr2)
        {
            while (cnt[i]-- > 0)
            {
                res[idx++] = i;
            }
        }
        // System.out.println("cnt = " + Arrays.toString(cnt));
        for (int i = 0; i < cnt.length; i++)
        {
            while (cnt[i]-- > 0)
            {
                res[idx++] = i;
            }
        }
        return res;
    }
}
