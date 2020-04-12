package leetcode;


/**
 * Binary Tree Max Height
 * ======================
 */
public class MaxDepthOfBinaryTree {

    static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }


    static int findDepth(Node node){
        if(node == null){
            return 0;
        }else {
            return 1 + Math.max(findDepth(node.left), findDepth(node.right));
        }


    }


    public static void main(String[] args){
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(5);
        Node n4 = new Node(6);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;


        System.out.println(findDepth(n1));
    }

}
