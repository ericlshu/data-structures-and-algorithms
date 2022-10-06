package solution.math;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description : 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * <p>
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * 提示：
 * -> 1 <= nums.length <= 6
 * -> -10 <= nums[i] <= 10
 * -> nums 中的所有整数 互不相同
 *
 * @author Eric L SHU
 * @date 2022-10-06 12:40 PM
 * @since jdk-11.0.14
 */
public class P0046Permutations
{
    public List<List<Integer>> permute_bt1(int[] nums)
    {
        List<List<Integer>> lists = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Deque<Integer> path = new ArrayDeque<>();
        backtrack_1(nums, 0, path, used, lists);
        return lists;
    }

    private void backtrack_1(int[] nums, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> lists)
    {
        if (depth == nums.length)
        {
            lists.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++)
        {
            if (!used[i])
            {
                path.addLast(nums[i]);
                used[i] = true;
                backtrack_1(nums, depth + 1, path, used, lists);
                used[i] = false;
                path.removeLast();
            }
        }
    }

    public List<List<Integer>> permute_dfs(int[] nums)
    {
        List<List<Integer>> lists = new ArrayList<>();
        int len = nums.length;
        boolean[] used = new boolean[len];
        ArrayList<Integer> path = new ArrayList<>();
        dfs(nums, len, 0, path, used, lists);
        return lists;
    }

    private void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> lists)
    {
        if (depth == len)
        {
            // 3、不用拷贝，因为每一层传递下来的 path 变量都是新建的
            lists.add(path);
            return;
        }
        for (int i = 0; i < len; i++)
        {
            if (!used[i])
            {
                // 1、每一次尝试都创建新的变量表示当前的"状态"
                ArrayList<Integer> newPath = new ArrayList<>(path);
                newPath.add(nums[i]);

                boolean[] newUsed = new boolean[len];
                System.arraycopy(used, 0, newUsed, 0, len);
                newUsed[i] = true;

                dfs(nums, len, depth + 1, newPath, newUsed, lists);

                // 2、无需回溯
            }
        }
    }

    public List<List<Integer>> permute_bt2(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> output = new ArrayList<>();
        for (int num : nums)
        {
            output.add(num);
        }

        int len = nums.length;
        backtrack_2(len, output, res, 0);
        return res;
    }

    private void backtrack_2(int len, List<Integer> output, List<List<Integer>> res, int first)
    {
        // 所有数都填完了
        if (first == len)
        {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < len; i++)
        {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack_2(len, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
}
