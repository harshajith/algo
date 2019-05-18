package com.harsha.cs.linkedlists;

public class LinkedListOps {

    LinkedListNode first;
    LinkedListNode last;
    int size;

    public LinkedListOps(){}

    public static class LinkedListNode {
        int val;
        LinkedListNode next;
        LinkedListNode prev;

        public LinkedListNode(LinkedListNode prev, int e, LinkedListNode next){
            this.prev = prev;
            this.val = e;
            this.next = next;
        }
    }

    /**
     * O(1)
     * @param val
     */
    public void addFirst(int val){
        LinkedListNode newNode = new LinkedListNode(null, val, first);
        first = newNode;

        if(last == null){
            last = first;
        }
        size ++;
    }


    /**
     * O(1)
     * @param val
     */
    public void addLast(int val){
        LinkedListNode newNode = new LinkedListNode(last, val, null);
        last = newNode;
        if(first == null){
            first = last;
        }
        size ++;
    }

    public void removeAfter(int val){
        for(LinkedListNode x = first; x != null; x = x.next){
            if(x.val == val){
                unLink(x.next);
            }
        }
    }

    /**
     *
     * @param val
     * @return
     */
    public boolean remove(int val){
        for(LinkedListNode x = first; x != null; x = x.next){
            if(val == x.val){
                unLink(x);
                return true;
            }
        }
        return false;
    }


    /**
     *
     * @param node
     * @return
     */
    public int unLink(LinkedListNode node){
        int val = node.val;
        LinkedListNode next = node.next;
        LinkedListNode prev = node.prev;

        if(prev == null){
            first = next;
        }else{
            node.prev = null;
            prev.next = next;
        }

        if(next == null){
            last = prev;
        }else {
            next.prev = prev;
            node.next = null;
        }

        node.val = 0;
        size --;
        return val;
    }


}
