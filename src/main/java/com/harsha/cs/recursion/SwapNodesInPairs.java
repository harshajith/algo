package com.harsha.cs.recursion;


/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodesInPairs {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        swapPairs(head.next.next);


        ListNode tmp = head.next;
        head.next = tmp.next;
        tmp.next = head;

        return tmp;
    }

    public static void main(String[] args) {
        ListNode head  = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        SwapNodesInPairs solution = new SwapNodesInPairs();
        ListNode result = solution.swapPairs(head);

        while(result.next != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
