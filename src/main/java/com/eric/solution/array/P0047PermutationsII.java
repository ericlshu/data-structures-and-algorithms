package com.eric.solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description : 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 提示：
 * -> 1 <= nums.length <= 8
 * -> -10 <= nums[i] <= 10
 *
 * @author Eric L SHU
 * @date 2023-01-14 15:07
 * @since jdk-11.0.14
 */
public class P0047PermutationsII
{
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] visited;
    int n;

    public List<List<Integer>> permuteUnique(int[] nums)
    {
        n = nums.length;
        visited = new boolean[n];
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    /**
     * if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
     * continue;
     * }
     * 加上 !vis[i - 1]来去重主要是通过限制一下两个相邻的重复数字的访问顺序
     * 举个栗子，对于两个相同的数11，我们将其命名为1a1b, 1a表示第一个1，1b表示第二个1；
     * 那么，不做去重的话，会有两种重复排列 1a1b, 1b1a， 我们只需要取其中任意一种排列；为了达到这个目的，限制一下1a, 1b访问顺序即可。
     * 比如我们只取1a1b那个排列的话，只有当visit nums[i-1]之后我们才去visit nums[i]， 也就是如果!visited[i-1]的话则continue
     * !visited[i - 1] 实现了 「同层剪枝」，而 visited[i - 1] 实现「非同层剪枝」。
     */
    private void backtrack(int[] nums, int depth)
    {
        if (depth == n)
        {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++)
        {
            // if (visited[i] || (i > 0 && visited[i - 1] && nums[i] == nums[i - 1]))
            if (visited[i] || (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1]))
                continue;
            path.add(nums[i]);
            visited[i] = true;
            backtrack(nums, depth + 1);
            visited[i] = false;
            path.remove(depth);
        }
    }
}
