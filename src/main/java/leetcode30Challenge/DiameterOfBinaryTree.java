package leetcode30Challenge;

import java.util.LinkedList;

/**
 * Diameter of Binary Tree
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree {

    public static class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode(int x) { val = x; }
    }

    /**
     * regular BFS, calculate diameters in each node.
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = findMaxDepth(root.left);
        int rightHeight = findMaxDepth(root.right);

        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);

        return Math.max(leftHeight+rightHeight, Math.max(leftDiameter, rightDiameter));
    }


    /**
     * Find max depth of tree.
     * @param node
     * @return
     */
    public int findMaxDepth(TreeNode node){
        if(node == null) {
            return 0;
        }else {
            return 1 + Math.max(findMaxDepth(node.left), findMaxDepth(node.right));
        }
    }

}
