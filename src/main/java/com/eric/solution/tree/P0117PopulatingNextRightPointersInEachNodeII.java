package com.eric.solution.tree;

import com.eric.domain.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description : 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * 进阶：
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * <p>
 * 示例：
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。
 * <p>
 * 提示：
 * -> 树中的节点数小于 6000
 * -> -100 <= node.val <= 100
 *
 * @author Eric L SHU
 * @date 2023-01-09 21:53
 * @since jdk-11.0.14
 */
public class P0117PopulatingNextRightPointersInEachNodeII
{
    public Node connect_bfs1(Node root)
    {
        if (root == null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            Node prev = null, curr;
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                curr = queue.poll();
                if (prev != null)
                {
                    prev.next = curr;
                }
                prev = curr;
                assert curr != null;
                if (curr.left != null)
                {
                    queue.offer(curr.left);
                }
                if (curr.right != null)
                {
                    queue.offer(curr.right);
                }
            }
        }
        return root;
    }

    public Node connect_bfs2(Node root)
    {
        Node curr = root;
        Node dummy, prev;
        while (curr != null)
        {
            dummy = new Node(0);
            prev = dummy;
            while (curr != null)
            {
                if (curr.left != null)
                {
                    prev.next = curr.left;
                    prev = prev.next;
                }
                if (curr.right != null)
                {
                    prev.next = curr.right;
                    prev = prev.next;
                }
                curr = curr.next;
            }
            curr = dummy.next;
        }
        return root;
    }
}
