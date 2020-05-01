package leetcodeApril;


/**
 *Binary Tree Maximum Path Sum
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 */
public class BinaryTreeMaxPathSum {


    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        pathSum(root);
        return maxSum;
    }

    public int pathSum(TreeNode node){
        if(node == null) return 0;
        int leftMax = Math.max(0, pathSum(node.left));
        int rightMax = Math.max(0, pathSum(node.right));
        maxSum = Math.max(maxSum, leftMax+rightMax+node.val);
        return Math.max(leftMax, rightMax) + node.val;
    }



    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }
}
