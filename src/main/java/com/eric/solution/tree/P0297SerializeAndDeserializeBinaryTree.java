package com.eric.solution.tree;

import com.eric.domain.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description : 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * <p>
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[1,2]
 * <p>
 * 提示：
 * 树中结点数在范围 [0, 104] 内
 * -1000 <= Node.val <= 1000
 *
 * @author Eric L SHU
 * @date 2022-10-30 19:33
 * @since jdk-11.0.14
 */
public class P0297SerializeAndDeserializeBinaryTree
{
    public String serialize(TreeNode root)
    {
        return serialize_dfs(root, "");
    }

    private String serialize_dfs(TreeNode root, String str)
    {
        if (root == null)
            str += "None,";
        else
        {
            str += root.val + ",";
            str = serialize_dfs(root.left, str);
            str = serialize_dfs(root.right, str);
        }
        return str;
    }

    public TreeNode deserialize(String data)
    {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
        return deserialize_dfs(dataList);
    }

    private TreeNode deserialize_dfs(List<String> dataList)
    {
        if (dataList.get(0).equals("None"))
        {
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);
        root.left = deserialize_dfs(dataList);
        root.right = deserialize_dfs(dataList);
        return root;
    }
}
