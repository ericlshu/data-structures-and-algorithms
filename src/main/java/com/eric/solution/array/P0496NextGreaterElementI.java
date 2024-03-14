package com.eric.solution.array;

import java.util.*;

/**
 * Description : 496. 下一个更大元素 I
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 * <p>
 * 示例 1：
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出：[-1,3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
 * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * <p>
 * 示例 2：
 * 输入：nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出：[3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
 * - 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
 * <p>
 * 提示：
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 104
 * nums1和nums2中所有整数 互不相同
 * nums1 中的所有整数同样出现在 nums2 中
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
 *
 * @author Eric L SHU
 * @date 2022-09-01 20:43
 * @since jdk-11.0.14
 */
public class P0496NextGreaterElementI
{
    /**
     * 单调栈-下标入栈
     */
    public int[] nextGreaterElement_4(int[] nums1, int[] nums2)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums2.length; i++)
        {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i])
            {
                map.put(nums2[stack.pop()], nums2[i]);
            }
            stack.push(i); // 下标入栈
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++)
        {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }

    /**
     * 单调栈-元素入栈
     */
    public int[] nextGreaterElement_3(int[] nums1, int[] nums2)
    {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--)
        {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek())
            {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        // System.out.println("stack = " + stack);
        // System.out.println("map = " + map);
        for (int i = 0; i < nums1.length; i++)
        {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }

    /**
     * 暴力解法-2
     */
    public int[] nextGreaterElement_2(int[] nums1, int[] nums2)
    {
        for (int i = 0; i < nums1.length; i++)
        {
            int j = 0;
            while (j < nums2.length && nums2[j] != nums1[i])
            {
                j++;
            }
            int k = j + 1;
            while (k < nums2.length && nums2[k] <= nums2[j])
            {
                k++;
            }
            nums1[i] = k < nums2.length ? nums2[k] : -1;
        }
        return nums1;
    }

    /**
     * 暴力解法-1
     */
    public int[] nextGreaterElement_1(int[] nums1, int[] nums2)
    {
        for (int i = 0; i < nums1.length; i++)
        {
            boolean matched = false;
            int nextGreaterElement = -1;
            for (int num : nums2)
            {
                if (num == nums1[i])
                {
                    matched = true;
                    continue;
                }
                if (matched && num > nums1[i])
                {
                    nextGreaterElement = num;
                    break;
                }
            }
            nums1[i] = nextGreaterElement;
        }
        return nums1;
    }
}
