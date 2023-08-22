package com.eric.solution.tree;

import com.eric.domain.NaryNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Description : N 叉树的前序遍历
 * 给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * <p>
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[1,3,5,6,2,4]
 * <p>
 * 示例 2：
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 * <p>
 * 提示：
 * 节点总数在范围 [0, 104]内
 * 0 <= Node.val <= 104
 * n 叉树的高度小于或等于 1000
 * <p>
 * 进阶：递归法很简单，你可以使用迭代法完成此题吗?
 *
 * @author Eric L SHU
 * @date 2022-10-14 20:49
 * @since jdk-11.0.14
 */
public class P0589NaryTreePreorderTraversal
{
    public List<Integer> preorder_iteration(NaryNode root)
    {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Deque<NaryNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty())
        {
            NaryNode NaryNode = stack.pop();
            list.add(NaryNode.val);
            if (NaryNode.children != null)
            {
                for (int i = NaryNode.children.size() - 1; i >= 0; i--)
                {
                    stack.push(NaryNode.children.get(i));
                }
            }
        }
        return list;
    }

    public List<Integer> preorder_recursion(NaryNode root)
    {
        List<Integer> list = new ArrayList<>();
        pre(root, list);
        return list;
    }

    private void pre(NaryNode node, List<Integer> list)
    {
        if (node == null)
            return;
        list.add(node.val);
        List<NaryNode> children = node.children;
        if (children != null && children.size() > 0)
            for (NaryNode child : children)
                pre(child, list);
    }
}
