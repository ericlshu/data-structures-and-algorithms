package solution.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * Description : 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * <p>
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * <p>
 * 示例 2：
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * <p>
 * 提示：
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 *
 * @author Eric L SHU
 * @date 2021-04-25 8:16 PM
 * @since JDK 1.8
 */
public class P0039CombinationSum {

    public List<List<Integer>> combinationSum_(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) return result;
        // 排序是剪枝的前提
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, target, path, result);
        return result;
    }

    /**
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param target     每减去一个元素，目标值变小
     * @param path       从根结点到叶子结点的路径
     * @param result     结果集列表
     */
    private void dfs(int[] candidates, int begin, int target, Deque<Integer> path, List<List<Integer>> result) {
        // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            // 重点理解这里剪枝，前提是候选数组已经有序，
            if (target - candidates[i] < 0)
                break;
            path.addLast(candidates[i]);
            dfs(candidates, i, target - candidates[i], path, result);
            path.removeLast();
        }
    }

    int length;
    List<List<Integer>> result;
    Deque<Integer> path;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        length = candidates.length;
        if (length == 0) return result;
        // 排序是剪枝的前提
        Arrays.sort(candidates);
        path = new ArrayDeque<>();
        dfs(candidates, 0, target);
        return result;
    }

    /**
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param target     每减去一个元素，目标值变小
     */
    private void dfs(int[] candidates, int begin, int target) {
        // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        if (target == 0) {
            result.add(new ArrayList<>(path));
            System.out.println("===> result = " + result);
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            // 重点理解这里剪枝，前提是候选数组已经有序，
            if (target - candidates[i] < 0){
                System.out.println("<--> begin : " + i + ", candidate : " + candidates[i] + ", left : " + (target - candidates[i]) + ", path : " + path);
                break;
            }
            path.addLast(candidates[i]);
            System.out.println("|--> begin : " + i + ", candidate : " + candidates[i] + ", left : " + (target - candidates[i]) + ", path : " + path);
            dfs(candidates, i, target - candidates[i]);
            path.removeLast();
            System.out.println("<--| begin : " + i + ", candidate : " + candidates[i] + ", left : " + (target - candidates[i]) + ", path : " + path);
        }
    }

}
