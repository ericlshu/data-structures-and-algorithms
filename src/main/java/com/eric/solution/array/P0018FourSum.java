package com.eric.solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2021-04-22 21:51
 * @since JDK 1.8
 */
public class P0018FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            // 起始位置四个数之和大于target，结束循环
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                break;
            // 起始位置一个数与结束位置三个数之和小于target，起始位置右移，进行一下一次循环
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target)
                continue;
            for (int j = i + 1; j < length - 2; j++) {
                // 跳过相邻相等数据
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target)
                    break;
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target)
                    continue;
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        left++;
                        while (left < right && nums[right] == nums[right - 1])
                            right--;
                        right--;
                    }else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
