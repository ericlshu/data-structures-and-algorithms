package solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description : 组合总和 II
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 * <p>
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * <p>
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * <p>
 * 提示:
 * -> 1 <= candidates.length <= 100
 * -> 1 <= candidates[i] <= 50
 * -> 1 <= target <= 30
 *
 * @author Eric L SHU
 * @date 2023-01-14 22:08
 * @since jdk-11.0.14
 */
public class P0040CombinationSumII
{
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int sum = 0, n;

    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        n = candidates.length;
        Arrays.sort(candidates);
        backtrack_1(candidates, target, 0);
        backtrack_2(candidates, target, 0);
        return res;
    }

    private void backtrack_1(int[] candidates, int target, int start)
    {
        if (target == 0)
        {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < n; i++)
        {
            if (candidates[i] > target)
                break;
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            path.add(candidates[i]);
            backtrack_1(candidates, target - candidates[i], i + 1);
            path.remove(path.size() - 1);
        }
    }

    private void backtrack_2(int[] candidates, int target, int start)
    {
        if (target == sum)
        {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < n; i++)
        {
            if (sum + candidates[i] > target)
                break;
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            path.add(candidates[i]);
            sum += candidates[i];
            backtrack_2(candidates, target, i + 1);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
