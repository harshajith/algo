package leetcode.may;

/**
 * Cousins in Binary Tree
 * Solution
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 *
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 *
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 *
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4], x
 */
public class CousinsInBinaryTree {

    public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
         }
      }


    public boolean isCousins(TreeNode root, int x, int y) {

        int xDepth = findDepth(root, x, 0);
        int yDepth = findDepth(root, y, 0);

        int xParent = findParentRecursive(root, x, new TreeNode(-1));
        int yParent = findParentRecursive(root, y, new TreeNode(-1));

        return xParent != yParent && xDepth == yDepth;
    }

    public int findParentRecursive(TreeNode root, int v, TreeNode parent){
        if(root == null) return 0;

        if(root.val == v) return parent.val;

        int leftParent = findParentRecursive(root.left, v, root);
        if(leftParent != 0) return leftParent;

        int rightParent = findParentRecursive(root.right, v, root);
        if(rightParent != 0) return rightParent;

        return 0;
    }

    public int findDepth(TreeNode root, int x, int depth){
        if(root == null) return 0;

        if(root.val == x) return depth;

        int leftDepth = findDepth(root.left, x, depth+1);
        if(leftDepth != 0) { // found depth in left tree.
            return leftDepth;
        }
        int rightDepth = findDepth(root.right, x, depth+1);
        if(rightDepth != 0){
            return rightDepth;
        }
        return 0;
    }
}
