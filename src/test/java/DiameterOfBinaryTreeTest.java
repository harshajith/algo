
import leetcode.april.DiameterOfBinaryTree;
import org.junit.Before;
import org.junit.Test;
import leetcode.april.DiameterOfBinaryTree.TreeNode;

/**
 *      1
 *     / \
 *    2  3
 *   / \
 *  4   5
 *
 *
 *
 **/

public class DiameterOfBinaryTreeTest {

    TreeNode tree;

    @Before
    public void setUp(){
        tree = setUpTree();
    }

    public TreeNode setUpTree(){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;


        return t1;
    }


    @Test
    public void testDiameter(){
        DiameterOfBinaryTree solution = new DiameterOfBinaryTree();
        assert  solution.diameterOfBinaryTree(tree) == 3;
    }

}
