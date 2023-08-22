package com.eric.solution.array;

/**
 * Description : 80. 删除有序数组中的重复项 II
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1：
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2：
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为0, 0, 1, 1, 2, 3, 3 。 不需要考虑数组中超出新长度后面的元素。
 *
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按升序排列
 *
 * @author Eric L SHU
 * @date 2021-12-26 17:41
 * @since JDK 1.8
 */
public class P0080RemoveDuplicatesFromSortedArrayTwo {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int slow = 0;
        boolean repeated = false;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] == nums[fast]) {
                if (repeated) {
                    while (fast < nums.length && nums[slow] == nums[fast]) {
                        fast++;
                    }
                    repeated = false;
                }
                else {
                    repeated = true;
                }
            }
            else {
                repeated = false;
            }
            if (fast < nums.length) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }


    public int removeDuplicatesOfficial(int[] nums) {
        if (nums.length <= 2)
            return nums.length;

        int slow = 2, fast = 2;
        while (fast < nums.length) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}
