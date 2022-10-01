import domain.TreeNode;
import org.junit.Test;
import solution.tree.*;

import java.util.List;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2021-03-27 14:27
 * @since JDK 1.8
 */
public class TreeTest
{
    @Test
    public void testP0925()
    {
        P0925LongPressedName obj = new P0925LongPressedName();
        System.out.println("result = " + obj.isLongPressedName("saeedi", "ssaaeediixxxiii"));
    }

    static TreeNode root;

    static
    {
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node1 = new TreeNode(1, node3, node4);
        TreeNode node2 = new TreeNode(2, node5, node6);
        root = new TreeNode(0, node1, node2);
    }

    @Test
    public void test0094()
    {
        P0094BinaryTreeInorderTraversal p0094 = new P0094BinaryTreeInorderTraversal();
        System.out.println(p0094.inorderTraversalRecursion(root));
        System.out.println(p0094.inorderTraversalIteration(root));
        System.out.println(p0094.inorderTraversalMorris(root));
    }

    @Test
    public void test0144()
    {
        P0144BinaryTreePreorderTraversal p0144 = new P0144BinaryTreePreorderTraversal();
        System.out.println(p0144.preorderTraversalRecursion(root));
        System.out.println(p0144.preorderTraversalIteration(root));
        System.out.println(p0144.preorderTraversalMorris(root));
    }

    @Test
    public void test0145()
    {
        P0145BinaryTreePostorderTraversal p0145 = new P0145BinaryTreePostorderTraversal();
        System.out.println(p0145.postorderTraversalRecursion(root));
        System.out.println(p0145.postorderTraversalIteration(root));
        System.out.println(p0145.postorderTraversalMorris(root));
    }

    @Test
    public void test0102()
    {
        P0102BinaryTreeLevelOrderTraversal p0102 = new P0102BinaryTreeLevelOrderTraversal();
        List<List<Integer>> lists = p0102.levelOrderIteration(root);
        lists.forEach(System.out::println);

        lists = p0102.levelOrderRecursion(root);
        lists.forEach(System.out::println);
    }

    @Test
    public void test0104()
    {
        P0104MaximumDepthOfBinaryTree p0104 = new P0104MaximumDepthOfBinaryTree();
        System.out.println(p0104.maxDepthIteration(root));
        System.out.println(p0104.maxDepthRecursion(root));
    }

    @Test
    public void test0101()
    {
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4, null, new TreeNode(5));
        TreeNode node5 = new TreeNode(4, new TreeNode(5), null);
        TreeNode node6 = new TreeNode(3);

        TreeNode node1 = new TreeNode(2, node3, node4);
        TreeNode node2 = new TreeNode(2, node5, node6);

        TreeNode root = new TreeNode(1, node1, node2);

        P0101SymmetricTree p0101 = new P0101SymmetricTree();
        System.out.println(p0101.isSymmetricIteration1(root));
        System.out.println(p0101.isSymmetricIteration2(root));
        System.out.println(p0101.isSymmetricRecursion1(root));
        System.out.println(p0101.isSymmetricRecursion2(root));
    }

    @Test
    public void test0226()
    {
        P0144BinaryTreePreorderTraversal p0144 = new P0144BinaryTreePreorderTraversal();

        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);
        TreeNode node1 = new TreeNode(2, node3, node4);
        TreeNode node2 = new TreeNode(7, node5, node6);
        TreeNode root = new TreeNode(4, node1, node2);

        System.out.println(p0144.preorderTraversalRecursion(root));

        P0226InvertBinaryTree p0226 = new P0226InvertBinaryTree();

        root = p0226.invertTreeRecursion(root);
        System.out.println(p0144.preorderTraversalRecursion(root));

        root = p0226.invertTreeBFS(root);
        System.out.println(p0144.preorderTraversalRecursion(root));

        root = p0226.invertTreeDFS(root);
        System.out.println(p0144.preorderTraversalRecursion(root));
    }

    @Test
    public void test0112()
    {
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(1);

        TreeNode node3 = new TreeNode(11, node6, node7);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4, null, node8);

        TreeNode node1 = new TreeNode(4, node3, null);
        TreeNode node2 = new TreeNode(8, node4, node5);

        TreeNode root = new TreeNode(5, node1, node2);

        P0112PathSum p0112 = new P0112PathSum();
        System.out.println(p0112.hasPathSumRecursion(root, 22));
        // System.out.println(p0112.hasPathSumBFS1(root, 22));
        System.out.println(p0112.hasPathSumBFS2(root, 22));
        // System.out.println(p0112.hasPathSumDFS(root, 22));
    }

    @Test
    public void test0700()
    {
        P0700SearchInABinarySearchTree p0700 = new P0700SearchInABinarySearchTree();
        TreeNode node = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode root = new TreeNode(4, node, new TreeNode(7));
        System.out.println(p0700.searchBSTRecursion(root, 5));
        System.out.println(p0700.searchBSTIteration(root, 4));
    }

    @Test
    public void test0701()
    {
        P0701InsertIntoABinarySearchTree p0701 = new P0701InsertIntoABinarySearchTree();
        TreeNode node = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode root = new TreeNode(4, node, new TreeNode(7));
        TreeNode result = p0701.insertIntoBST(root, 5);

        P0094BinaryTreeInorderTraversal p0094 = new P0094BinaryTreeInorderTraversal();
        System.out.println(p0094.inorderTraversalRecursion(result));
    }
}
