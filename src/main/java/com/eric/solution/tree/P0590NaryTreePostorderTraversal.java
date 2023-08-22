package com.eric.solution.tree;

import com.eric.domain.NaryNode;

import java.util.*;

/**
 * Description : N 叉树的后序遍历
 * 给定一个 n 叉树的根节点 root ，返回 其节点值的 后序遍历 。
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * <p>
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[5,6,3,2,4,1]
 * <p>
 * 示例 2：
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 * <p>
 * 提示：
 * 节点总数在范围 [0, 104] 内
 * 0 <= Node.val <= 104
 * n 叉树的高度小于或等于 1000
 *
 * @author Eric L SHU
 * @date 2022-10-15 18:48
 * @since jdk-11.0.14
 */
public class P0590NaryTreePostorderTraversal
{
    public List<Integer> postorder_recursion(NaryNode root)
    {
        List<Integer> list = new ArrayList<>();
        post(root, list);
        return list;
    }

    private void post(NaryNode node, List<Integer> list)
    {
        if (node == null)
            return;
        List<NaryNode> children = node.children;
        if (children != null && children.size() > 0)
        {
            for (NaryNode child : children)
            {
                post(child, list);
            }
        }
        list.add(node.val);
    }

    public List<Integer> postorder_iteration(NaryNode root)
    {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Deque<NaryNode> stack = new ArrayDeque<>();
        Set<NaryNode> visited = new HashSet<>();
        stack.push(root);
        while (!stack.isEmpty())
        {
            NaryNode node = stack.peek();
            if (node.children == null || node.children.size() == 0 || visited.contains(node))
            {
                stack.pop();
                list.add(node.val);
                continue;
            }
            int size = node.children.size();
            while (--size >= 0)
            {
                stack.push(node.children.get(size));
            }
            visited.add(node);
        }
        return list;
    }

    public List<Integer> preorder_reverse(NaryNode root)
    {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Deque<NaryNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty())
        {
            NaryNode node = stack.pop();
            list.add(node.val);
            List<NaryNode> children = node.children;
            if (children == null)
                continue;
            for (NaryNode child : children)
            {
                stack.push(child);
            }
        }
        Collections.reverse(list);
        return list;
    }
}
