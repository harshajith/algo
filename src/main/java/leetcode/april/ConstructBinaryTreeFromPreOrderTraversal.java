package leetcode.april;

/**
 * Construct Binary Search Tree from Preorder Traversal
 * Return the root node of a binary search tree that matches the given preorder traversal.
 *
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
 *
 *
 *
 * Example 1:
 *
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 *
 */
public class ConstructBinaryTreeFromPreOrderTraversal {

    public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }

    public TreeNode bstFromPreorder(int[] preorder) {

        int rootValue = preorder[0];
        TreeNode tree = new TreeNode(preorder[0]);

        for(int i=1; i<preorder.length; i++){
            int newVal = preorder[i];
            addNode(tree, newVal);
        }
        return tree;
    }

    private void addNode(TreeNode node, int target){
        if(node == null) return;
        if(node.val > target){
            if(node.left == null) {
                TreeNode newNode = new TreeNode(target);
                node.left = newNode;
                return;
            }else {
                addNode(node.left, target);
            }
        }else {
            if(node.right == null){
                TreeNode newNode = new TreeNode(target);
                node.right = newNode;
                return;
            }else {
                addNode(node.right, target);
            }
        }
    }


}
