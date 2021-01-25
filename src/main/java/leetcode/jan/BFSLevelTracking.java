package leetcode.jan;

import com.harsha.cs.treechallenge.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS level-order traversal
 */
public class BFSLevelTracking {

    public static void bfs(TreeNode treeNode){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(treeNode);
        TreeNode dummy = null;
        queue.add(dummy);

        int depth = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                System.out.println(node.val);
                if(node.l != null){
                    queue.add(node.l);
                }
                if(node.r != null){
                    queue.add(node.r);
                }
            }else {
                depth ++;
                if(!queue.isEmpty()){
                    queue.add(dummy);
                }
            }
        }
        System.out.println("Tree depth : " + depth);
    }



    public static void main(String[] args){
        TreeNode node = makeTree();
        bfs(node);
    }


    public static TreeNode makeTree(){
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(21);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(1);
        TreeNode t7 = new TreeNode(2);

        t2.l = t3;
        t2.r = t4;
        t5.l = t6;
        t5.r = t7;
        t1.l = t2;
        t1.r = t5;

        return t1;
    }
}
