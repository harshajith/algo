package com.harsha.cs.treechallenge;

import java.util.Stack;

/**
 * DFS to find out visible nodes
 * CONDITION == nodes are visible if values are higher than the root value
 * Created by Harsha on 2/7/17.
 */
public class Solution {

    public boolean isBST(TreeNode tree, int min, int max){
        if(tree == null) return true;

        if(tree.val < min || tree.val > max){
            return false;
        }

        return isBST(tree.l, min, tree.val -1) && isBST(tree.r, tree.val +1, max);

    }

    public int solution(TreeNode t){
        Stack<TreeNode> stack = new Stack();
        int count = 0;
        int rootValue = t.val;
        stack.push(t);

        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            if(current.val > rootValue){
                count++;
            }
            if(current.r != null){
                stack.push(current.r);
            }

            if(current.l != null){
                stack.push(current.l);
            }
        }
        return count;
    }


    public static void main(String[] args){
        Solution s = new Solution();
        TreeNode treeNode = s.makeTree();
        int visibleNodes = s.solution(treeNode);
        //System.out.println(visibleNodes);
        System.out.println(s.isBST(treeNode, Integer.MIN_VALUE, Integer.MAX_VALUE));

    }


    public TreeNode makeTree(){
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(15);

        t2.l = t3;
        t2.r = t4;
        t5.l = t6;
        t5.r = t7;
        t1.l = t2;
        t1.r = t5;

        return t1;
    }

}
