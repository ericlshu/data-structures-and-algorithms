package com.eric.solution.tree;

import com.eric.domain.TreeNode;

import java.util.Random;

/**
 * Description : 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * <p>
 * 示例 1：
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 * <p>
 * 示例 2：
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
 * <p>
 * 提示：
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 按 严格递增 顺序排列
 *
 * @author Eric L SHU
 * @date 2022-10-25 11:33
 * @since jdk-11.0.14
 */
public class P0108ConvertSortedArrayToBST
{
    public TreeNode sortedArrayToBST(int[] nums)
    {
        dfs_left(nums, 0, nums.length - 1);
        dfs_right(nums, 0, nums.length - 1);
        return dfs_random(nums, 0, nums.length - 1);
    }

    private TreeNode dfs_left(int[] nums, int left, int right)
    {
        if (left > right)
            return null;
        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs_left(nums, left, mid - 1);
        root.right = dfs_left(nums, mid + 1, right);
        return root;
    }

    private TreeNode dfs_right(int[] nums, int left, int right)
    {
        if (left > right)
            return null;
        // 总是选择中间位置右边的数字作为根节点
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs_right(nums, left, mid - 1);
        root.right = dfs_right(nums, mid + 1, right);
        return root;
    }


    Random random = new Random();

    private TreeNode dfs_random(int[] nums, int left, int right)
    {
        if (left > right)
            return null;
        // 选择任意一个中间位置数字作为根节点
        int mid = (left + right + random.nextInt(2)) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs_random(nums, left, mid - 1);
        root.right = dfs_random(nums, mid + 1, right);
        return root;
    }
}
