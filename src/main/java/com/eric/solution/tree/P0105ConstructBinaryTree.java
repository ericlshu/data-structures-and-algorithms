package com.eric.solution.tree;

import com.eric.domain.TreeNode;

import java.util.*;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2022-10-25 15:05
 * @since jdk-11.0.14
 */
public class P0105ConstructBinaryTree
{
    public TreeNode buildTree_recursion(int[] preorder, int[] inorder)
    {
        int n = preorder.length;
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < n; i++)
        {
            idxMap.put(inorder[i], i);
        }
        System.out.println(buildTree(preorder, idxMap, 0, n - 1, 0, n - 1));
        return buildTree(preorder, idxMap, 0, n - 1);
        // return buildTree(preorder, idxMap, 0, 0, n - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        if (preorder.length == 0)
        {
            return null;
        }
        int value = preorder[0];
        TreeNode root = new TreeNode(value);
        for (int i = 0; i < inorder.length; i++)
        {
            if (inorder[i] == value)
            {
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);

                int[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] preRight = Arrays.copyOfRange(preorder, i + 1, preorder.length);

                root.left = buildTree(preLeft, inLeft);
                root.right = buildTree(preRight, inRight);

                break;
            }
        }
        return root;
    }


    /**
     * @param preorder 前序遍历序列
     * @param preLeft  前序遍历序列子区间的左边界
     * @param preRight 前序遍历序列子区间的右边界
     * @param idxMap   中序遍历序列中数值与下标的对应关系
     * @param inLeft   中序遍历序列子区间的左边界
     * @param inRight  中序遍历序列子区间的右边界
     */
    private TreeNode buildTree(int[] preorder, Map<Integer, Integer> idxMap, int preLeft, int preRight, int inLeft, int inRight)
    {
        if (preLeft > preRight || inLeft > inRight)
            return null;
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int pIdx = idxMap.get(rootVal);
        root.left = buildTree(preorder, idxMap, preLeft + 1, pIdx - inLeft + preLeft, inLeft, pIdx - 1);
        root.right = buildTree(preorder, idxMap, pIdx - inLeft + preLeft + 1, preRight, pIdx + 1, inRight);
        return root;
    }

    int rootIdx = 0;

    private TreeNode buildTree(int[] preorder, Map<Integer, Integer> idxMap, int left, int right)
    {
        if (left > right)
            return null;
        else
        {
            int rootVal = preorder[rootIdx++];
            TreeNode root = new TreeNode(rootVal);
            root.left = buildTree(preorder, idxMap, left, idxMap.get(rootVal) - 1);
            root.right = buildTree(preorder, idxMap, idxMap.get(rootVal) + 1, right);
            return root;
        }
    }

    // private TreeNode buildTree(int[] preorder, Map<Integer, Integer> idxMap, int rootIdx, int left, int right)
    // {
    //     if (left > right)
    //         return null;
    //     else
    //     {
    //         int rootVal = preorder[rootIdx];
    //         // System.out.println("rootVal = " + rootVal);
    //         // System.out.println("rootIdx = " + rootIdx);
    //         // System.out.println("left = " + left);
    //         // System.out.println("right = " + right);
    //         TreeNode root = new TreeNode(rootVal);
    //         root.left = buildTree(preorder, idxMap, rootIdx + 1, left, idxMap.get(rootVal) - 1);
    //         root.right = buildTree(preorder, idxMap, rootIdx + 2, idxMap.get(rootVal) + 1, right);
    //         return root;
    //     }
    // }

    public TreeNode buildTree_iteration(int[] preorder, int[] inorder)
    {
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inIdx = 0;
        for (int i = 1; i < preorder.length; i++)
        {
            int preVal = preorder[i];
            TreeNode node = stack.peek();
            assert node != null;
            if (node.val != inorder[inIdx])
            {
                node.left = new TreeNode(preVal);
                stack.push(node.left);
            }
            else
            {
                while (!stack.isEmpty() && stack.peek().val == inorder[inIdx])
                {
                    node = stack.pop();
                    inIdx++;
                }
                node.right = new TreeNode(preVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
