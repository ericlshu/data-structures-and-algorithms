package com.eric.domain;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2020-10-27 20:50
 * @since JDK 1.8
 */
public class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode()
    {
    }

    public TreeNode(int val)
    {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // @Override
    // public String toString()
    // {
    //     StringBuilder sb = new StringBuilder("TreeNode{" + "val=" + val);
    //     if (left != null)
    //         sb.append(", left=").append(left);
    //     if (right != null)
    //         sb.append(", right=").append(right);
    //     return sb.append("}").toString();
    // }


    @Override
    public String toString()
    {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
