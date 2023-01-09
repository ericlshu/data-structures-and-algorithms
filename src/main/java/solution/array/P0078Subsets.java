package solution.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Description : 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 提示：
 * -> 1 <= nums.length <= 10
 * -> -10 <= nums[i] <= 10
 * -> nums 中的所有元素 互不相同
 *
 * @author Eric L SHU
 * @date 2023-01-09 21:12
 * @since jdk-11.0.14
 */
public class P0078Subsets
{
    public List<List<Integer>> subsets_iteration(int[] nums)
    {
        System.out.println("-------------------------------------------------");
        int n = nums.length, bound = 1 << n;
        for (int i = 0; i < bound; i++)
        {
            list.clear();
            for (int j = 0; j < n; j++)
            {
                System.out.print("i : " + Integer.toBinaryString(i));
                System.out.print("\t | (1 << j) : " + Integer.toBinaryString(1 << j));
                System.out.println(" \t | (i & (1 << j)) : " + (i & (1 << j)));
                if ((i & (1 << j)) != 0)
                {
                    list.add(nums[j]);
                }
            }
            System.out.println("-------------------------------------------------");
            res.add(new ArrayList<>(list));
        }
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets_recursion(int[] nums)
    {
        dfs(0, nums);
        return res;
    }

    private void dfs(int curr, int[] nums)
    {
        if (curr == nums.length)
        {
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[curr]);
        dfs(curr + 1, nums);
        list.remove(list.size() - 1);
        dfs(curr + 1, nums);
    }
}
