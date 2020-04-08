package leetcode;


/**
 *
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
        }

        if(node.left == null && node.right==null){
            return 1;
        }

        int leftHeight = 1 + findDepth(node.left);
        int rightHeight = 1 + findDepth(node.right);

        if(leftHeight > rightHeight){
            return leftHeight;
        }else {
            return rightHeight;
        }
    }


    public static void main(String[] args){
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(5);
        Node n4 = new Node(6);

        n1.left = n2;
        n3.left = n4;
        n1.right = n3;

        System.out.println(findDepth(n1));
    }

}
