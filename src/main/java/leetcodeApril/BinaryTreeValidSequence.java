package leetcodeApril;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree
 * Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string is a valid sequence in such binary tree.
 *
 * We get the given string from the concatenation of an array of integers arr and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
 * Output: true
 * Explanation:
 * The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure).
 * Other valid sequences are:
 * 0 -> 1 -> 1 -> 0
 * 0 -> 0 -> 0
 * Example 2:
 *
 *
 *
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
 * Output: false
 * Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.
 * Example 3:
 *
 *
 *
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
 * Output: false
 * Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 5000
 * 0 <= arr[i] <= 9
 * Each node's value is between [0 - 9].
 */
public class BinaryTreeValidSequence {

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

    public boolean isValidSequence(TreeNode root, int[] arr) {

        if(root == null || arr.length == 0) return false;

        if(root.val != arr[0]) {
            return false;
        }

        Stack<List<TreeNode>> paths = new Stack<>();
        paths.add(Arrays.asList(root));

        while(!paths.isEmpty()){
            List<TreeNode> currentPath = paths.pop();
            int currentIndex = currentPath.size()-1;
            TreeNode node = currentPath.get(currentIndex);

            if(currentIndex == arr.length-1 && node.left == null && node.right == null) return true;


            if(node.left != null){
                int leftVal = node.left.val;
                if(currentIndex+1 <= arr.length-1 && leftVal == arr[currentIndex+1]){
                    List<TreeNode> newPath = new ArrayList<>();
                    newPath.addAll(currentPath);
                    newPath.add(node.left);
                    paths.add(newPath);
                }
            }
            if(node.right != null){
                int rightVal = node.right.val;
                if(currentIndex+1 <= arr.length-1 && rightVal == arr[currentIndex+1]){
                    List<TreeNode> newPath = new ArrayList<>();
                    newPath.addAll(currentPath);
                    newPath.add(node.right);
                    paths.add(newPath);
                }
            }
        }
        return false;
    }

}
