package com.harsha.cs.linkedlists;

public class LinkedListTest {

    public static void main(String[] args){
        LinkedListOps ops = new LinkedListOps();
        ops.addFirst(4);
        ops.addFirst(2);
        ops.addFirst(7);
        ops.addFirst(8);
        ops.addLast(12);

        System.out.println(ops.size);
        System.out.println(ops.last.val);
        System.out.println(ops.first.val);

        ops.remove(7);
        System.out.println(ops.size);

    }

}
