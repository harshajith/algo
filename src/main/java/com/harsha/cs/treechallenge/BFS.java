package com.harsha.cs.treechallenge;

import java.util.Queue;

public class BFS {

    int[] queue;
    int head;
    int last;

    public BFS(int v){
        queue = new int[v];
        head = 0;
        last = 0;
    }

    public void enqueue(int value){
        if(last < queue.length){
            queue[last++] = value;
        }
    }

    public int dequeue(){
        if(queue.length > 0){
            return queue[head++];
        }else {
            throw new RuntimeException("Queue is empty");
        }
    }

    public boolean isEmpty(){
        return queue.length == 0;
    }

    public void searchBFS(TreeNode node){
        this.enqueue(node.X);

        while(!this.isEmpty()){
            int n = this.dequeue();
            System.out.println(n);

            if(node.r != null){
                this.enqueue(node.r.X);
            }
            if(node.l != null){
                this.enqueue(node.l.X);
            }
        }
    }


    public static void main(String[] args){
        BFS bfs = new BFS(8);
        TreeNode node = bfs.makeTree();
        bfs.searchBFS(node);
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
