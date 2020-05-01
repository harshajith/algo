import leetcodeApril.BinaryTreeMaxPathSum;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeMaxPathSumTest {

    BinaryTreeMaxPathSum.TreeNode tree;
    BinaryTreeMaxPathSum binaryTreeMaxPathSum = new BinaryTreeMaxPathSum();
    @Before
    public void setUp(){
        tree = setUpTree();
    }

    public BinaryTreeMaxPathSum.TreeNode setUpTree(){
        BinaryTreeMaxPathSum.TreeNode t1 = new BinaryTreeMaxPathSum.TreeNode(1);
        BinaryTreeMaxPathSum.TreeNode t2 = new BinaryTreeMaxPathSum.TreeNode(2);
        BinaryTreeMaxPathSum.TreeNode t3 = new BinaryTreeMaxPathSum.TreeNode(3);
        BinaryTreeMaxPathSum.TreeNode t4 = new BinaryTreeMaxPathSum.TreeNode(4);
        BinaryTreeMaxPathSum.TreeNode t5 = new BinaryTreeMaxPathSum.TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;


        return t1;
    }

    @Test
    public void test1(){
        int sum = binaryTreeMaxPathSum.maxPathSum(tree);
        assert sum == 15;
    }


    @Test
    public void test2(){
        int sum = binaryTreeMaxPathSum.maxPathSum(new BinaryTreeMaxPathSum.TreeNode(-3));
        assert sum == -3;
    }

}
