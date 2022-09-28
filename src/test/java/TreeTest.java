import domain.TreeNode;
import org.junit.Test;
import solution.tree.P0094BinaryTreeInorderTraversal;
import solution.tree.P0144BinaryTreePreorderTraversal;
import solution.tree.P0145BinaryTreePostorderTraversal;
import solution.tree.P0925LongPressedName;

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
}
