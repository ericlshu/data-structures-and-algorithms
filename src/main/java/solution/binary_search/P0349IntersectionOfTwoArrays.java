package solution.binary_search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Description : 两个数组的交集
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * <p>
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * <p>
 * 说明：
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * @author Eric L SHU
 * @date 2020-11-02 20:40
 * @since JDK 1.8
 */
public class P0349IntersectionOfTwoArrays
{
    public int[] intersection(int[] nums1, int[] nums2)
    {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        int p1 = 0, p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length)
        {
            if (nums1[p1] == nums2[p2])
            {
                set.add(nums1[p1]);
                p1++;
                p2++;
            }
            else if (nums1[p1] < nums2[p2])
                p1++;
            else // nums1[p1] > nums2[p2]
                p2++;
        }
        int[] result = new int[set.size()];
        int i = 0;
        for (int num : set)
        {
            result[i++] = num;
        }
        return result;
    }

    public int[] intersection_1(int[] nums1, int[] nums2)
    {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).distinct().filter(set::contains).toArray();
    }

    public int[] intersection_2(int[] nums1, int[] nums2)
    {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1)
        {
            set1.add(num);
        }
        for (int num : nums2)
        {
            set2.add(num);
        }
        return getIntersection(set1, set2);
    }

    private int[] getIntersection(Set<Integer> set1, Set<Integer> set2)
    {
        if (set1.size() > set2.size())
            return getIntersection(set2, set1);
        Set<Integer> intersectionSet = new HashSet<>();
        for (int num : set1)
        {
            if (set2.contains(num))
                intersectionSet.add(num);
        }
        int[] intersection = new int[intersectionSet.size()];
        int index = 0;
        for (int num : intersectionSet)
        {
            intersection[index++] = num;
        }
        return intersection;
    }
}
