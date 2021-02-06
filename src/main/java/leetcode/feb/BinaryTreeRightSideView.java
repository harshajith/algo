package leetcode.feb;

import com.harsha.cs.treechallenge.TreeNode;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
import java.util.*;

public class BinaryTreeRightSideView {

    public static void main(String[] args){
        TreeNode node = makeTree();
        List<Integer> result = rightSideView(node);
        System.out.println(Arrays.toString(result.toArray()));
    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode makeTree() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(4);


        t1.right = t3;
        t1.left = t2;
        t2.left = null;
        t2.right = t4;
        t3.left = null;
        t3.right = t5;

        return t1;
    }

    /**
     * BFS with level tracking.
     *
     * @param root
     * @return
     */
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node != null){
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

                if (!queue.isEmpty() && queue.peek() == null) {
                    queue.poll();
                    result.add(node.val);
                    queue.add(null);
                }
            }else {
                break;
            }
        }

        return result;
    }
}
