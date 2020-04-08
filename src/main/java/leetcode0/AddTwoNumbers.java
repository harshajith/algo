package leetcode0;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * /**
 *  * Definition for singly-linked list.
 *  * public class ListNode {
 *  *     int val;
 *  *     ListNode next;
 *  *     ListNode(int x) { val = x; }
 *  * }
 *
 */


public class AddTwoNumbers {


    public ListNode addNumbers(ListNode l1, ListNode l2){

        if(l1 == null && l2 != null){
            return l2;
        }else if(l1 != null && l2 == null){
            return l1;
        }

        ListNode c1 = l1;
        ListNode c2 = l2;

        int remain = 0;

        while(c1 != null && c2 != null){
            int v1 = c1.val;
            int v2 = c2.val;
            int i = v1 + v2 + remain;
            if(i > 9){
                remain = 1;
                enQueue(Integer.valueOf(String.valueOf(i).substring(1,2)));
            }else {
                remain = 0;
                enQueue(i);
            }
            c1 = c1.next;
            c2 = c2.next;
        }

        while(c1 != null){
            int v1 = c1.val;
            int i = v1 + remain;
            if(i > 9){
                remain = 1;
                enQueue(Integer.valueOf(String.valueOf(i).substring(1,2)));
            }else {
                remain = 0;
                enQueue(i);
            }
            c1 = c1.next;
        }

        while(c2 != null){
            int v2 = c2.val;
            int i = v2 + remain;
            if(i > 9){
                remain = 1;
                enQueue(Integer.valueOf(String.valueOf(i).substring(1,2)));
            }else {
                remain = 0;
                enQueue(i);
            }
            c2 = c2.next;
        }

        if(remain == 1){
            enQueue(1);
        }

        return head;
    }


    private static ListNode head;

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void enQueue(int val){
        ListNode newNode = new ListNode(val);
        if(head == null){
            head = newNode;
        }else {
            ListNode last = head;
            while(last.next != null){
                last = last.next;
            }
            last.next = newNode;
        }
    }


    private static void printList(ListNode head){
        ListNode current = head;
        while(current != null){
            System.out.println(current.val);
            current = current.next;
        }
    }

    public static void main(String[] args){
        AddTwoNumbers x = new AddTwoNumbers();


        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(4);

       // l1.next = l2;

        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(9);
        ListNode l7 = new ListNode(9);
        ListNode l8 = new ListNode(9);
        ListNode l9 = new ListNode(9);
        ListNode l10 = new ListNode(9);


        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l10;


        ListNode result = x.addNumbers(l1, l3);
        //addTwoNumbers(l1, l3);

        x.printList(head);

    }


}
