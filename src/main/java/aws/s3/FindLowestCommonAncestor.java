package aws.s3;


/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 *
 * Example 1:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * Example 2:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 */
public class FindLowestCommonAncestor {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int d1 = -1; // distance to p
    int d2 = -1; // distance to q
    int dist = 0;


    TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q, int level){

        if(root == null){
            return null;
        }

        if(root.val == p.val){
            d1 = level;
            return root;
        }

        if(root.val == q.val){
            d2 = level;
            return root;
        }

        TreeNode left_lca = findLCA(root.left, p, q, level+1);
        TreeNode right_lca = findLCA(root.right, p, q, level + 1);

        if(left_lca != null && right_lca != null) { // This node is LCA
            dist = (d1+d2) - 2*level;
            return root;
        }

        return (left_lca != null ? left_lca : right_lca);
    }






}
