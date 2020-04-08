package leetcode;


import java.util.Stack;

/**
 * 701. Insert into a Binary Search Tree
 * Medium
 *
 * 459
 *
 * 51
 *
 * Favorite
 *
 * Share
 * Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
 *
 * Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
 *
 * For example,
 *
 * Given the tree:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 * And the value to insert: 5
 * You can return this binary search tree:
 *
 *          4
 *        /   \
 *       2     7
 *      / \   /
 *     1   3 5
 * This tree is also valid:
 *
 *          5
 *        /   \
 *       2     7
 *      / \
 *     1   3
 *          \
 *           4
 */
public class InsertToBinarySearchTree {

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(val > node.val){
                if(node.right != null){
                    stack.push(node.right);
                }else {
                    TreeNode newNode = new TreeNode(val);
                    node.right = newNode;
                    break;
                }
            }else {
                if(node.left != null){
                    stack.push(node.left);
                }else {
                    TreeNode newNode = new TreeNode(val);
                    node.left = newNode;
                    break;
                }
            }
        }
        return root;
    }
}
