package solution.two_pointers;

import java.util.Arrays;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2021-04-22 21:53
 * @since JDK 1.8
 */
public class P0016ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = 10000;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (target == sum) {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;
                if (sum > target) {
                    right--;
                    while (right > left && nums[right] == nums[right + 1]) right--;
                }
                else {
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                }
            }
        }
        return result;
    }
}
